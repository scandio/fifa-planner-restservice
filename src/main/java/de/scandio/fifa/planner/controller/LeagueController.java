package de.scandio.fifa.planner.controller;

import de.scandio.fifa.planner.comparator.TableComparator;
import de.scandio.fifa.planner.model.Match;
import de.scandio.fifa.planner.model.TableItem;
import de.scandio.fifa.planner.persistence.MatchImpl;
import de.scandio.fifa.planner.persistence.TableItemImpl;
import de.scandio.fifa.planner.repository.MatchRepository;
import de.scandio.fifa.planner.repository.TeamRepository;
import de.scandio.fifa.planner.config.RestConstants;
import de.scandio.fifa.planner.model.Team;
import de.scandio.fifa.planner.persistence.TeamImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by stefanmuecke on 17.10.16.
 */
@RestController
@CrossOrigin(origins = "*")
public class LeagueController {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private MatchRepository matchRepo;

    @RequestMapping(value = RestConstants.BASE_URI, method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    // Team Controller =================================================================

    @RequestMapping(value = RestConstants.TEAMS_URI, method = RequestMethod.GET)
    public List<? extends Team> getTeams(){
        List<? extends Team> teams = this.teamRepo.findAll();
        return teams;
    }

    @RequestMapping(value = RestConstants.TEAM_URI, method = RequestMethod.POST)
    public Team createTeam(@PathVariable("name") String name){
        TeamImpl team = new TeamImpl(name);
        team.setHasFifaBadge(false);
        return this.teamRepo.save(team);
    }

    @RequestMapping(value = RestConstants.TEAM_URI, method = RequestMethod.GET)
    public Team getTeam(@PathVariable("id") String id){
        return this.teamRepo.findOne(id);
    }

    @RequestMapping(value = RestConstants.TEAM_FIFA_BADGE_URI, method = RequestMethod.POST)
    public Team setFifaBadgeForTeam(@PathVariable("id") String id){
        List<TeamImpl> teams = this.teamRepo.findAll();
        for(Team team:teams){
            team.setHasFifaBadge(false);
        }
        this.teamRepo.save(teams);
        TeamImpl team = this.teamRepo.findOne(id);
        team.setHasFifaBadge(true);
        return this.teamRepo.save(team);
    }

    // Match Controller ================================================================

    @RequestMapping(value = RestConstants.MATCHES_URI, method = RequestMethod.GET)
    public List<? extends Match> getMatches(){
        List<? extends Match> matches = this.matchRepo.findAll();
        return matches;
    }

    @RequestMapping(value = RestConstants.MATCHES_ON_MATCHDAY_URI, method = RequestMethod.GET)
    public List<? extends Match> getMatchesOnMatchday(@PathVariable("matchday") Integer matchday){
        List<? extends Match> matches = this.matchRepo.findAllByMatchday(matchday);
        return matches;
    }

    @RequestMapping(value = RestConstants.MATCHES_URI, method = RequestMethod.POST)
    public Match createMatch(@RequestBody MatchImpl match){
        return this.matchRepo.save(match);
    }

    @RequestMapping(value = RestConstants.MATCH_URI, method = RequestMethod.GET)
    public Match getMatch(@PathVariable("id") String id){
        return this.matchRepo.findOne(id);
    }

    // Matchday Controller ===========================================================

    @RequestMapping(value = RestConstants.MATCHES_GENERATE_URI, method = RequestMethod.GET)
    public void generateMatchdays(){
        List<? extends Team> teams = this.teamRepo.findAll();

        Integer teamSize = teams.size();

        if(teamSize % 2 != 0){
            TeamImpl team = new TeamImpl("Spielfrei");
            this.teamRepo.save(team);
            teams = this.teamRepo.findAll();
            teamSize = teams.size();
        }

        Collections.shuffle(teams);

        MatchImpl match;

        for(int i = 0; i < teamSize; i++){
            if(i < teamSize - 1){
                int j = 0;
                while(j < teamSize){
                    if(i != j){
                        if(j == 0 && i % 2 != 0){
                            j++;
                        }else{
                            int day = i + j;
                            if(i > 0 && j == teamSize -1){
                                day = i * 2;
                            }
                            if(day > teamSize -1){
                                day -= teamSize -1;
                            }
                            if(j != teamSize -1 || i < teamSize / 2 - 1){
                                match = new MatchImpl();
                                match.setHome(teams.get(i).getId());
                                match.setAway(teams.get(j).getId());
                                match.setMatchday(day);
                                this.matchRepo.save(match);
                                match = new MatchImpl();
                                match.setHome(teams.get(j).getId());
                                match.setAway(teams.get(i).getId());
                                match.setMatchday(day + teamSize -1);
                                this.matchRepo.save(match);
                            }
                            if(j < teamSize - 2){
                                j += 2;
                            }else{
                                j++;
                            }
                        }
                    }else{
                        j++;
                    }
                }
            }else{
                match = new MatchImpl();
                match.setHome(teams.get(i).getId());
                match.setAway(teams.get(teamSize / 2 - 1).getId());
                match.setMatchday(teamSize - 2);
                this.matchRepo.save(match);

                match = new MatchImpl();
                match.setHome(teams.get(teamSize / 2 - 1).getId());
                match.setAway(teams.get(i).getId());
                match.setMatchday(teamSize - 2 + teamSize - 1);
                this.matchRepo.save(match);

                int day = 1;
                for(int j = teamSize / 2;j < teamSize - 1; j++){
                    match = new MatchImpl();
                    match.setHome(teams.get(i).getId());
                    match.setAway(teams.get(j).getId());
                    match.setMatchday(day);
                    this.matchRepo.save(match);

                    match = new MatchImpl();
                    match.setHome(teams.get(j).getId());
                    match.setAway(teams.get(i).getId());
                    match.setMatchday(day + teamSize - 1);
                    this.matchRepo.save(match);

                    day += 2;
                }
            }
        }
    }

    // Table Controller ================================================================

    @RequestMapping(value = RestConstants.TABLE_GENERATE_URI, method = RequestMethod.GET)
    public Collection<TableItem> getTable(){
        List<? extends Match> matches = this.matchRepo.findAll();
        List<? extends Team> teams = this.teamRepo.findAll();

        Map<String, TableItem> table = new HashMap<>();

        TableItem tableItem;
        for(Team team: teams){
            tableItem = new TableItemImpl();
            tableItem.setId(team.getId());
            tableItem.setPlayed(0);
            tableItem.setWon(0);
            tableItem.setDrawn(0);
            tableItem.setLost(0);
            tableItem.setGoals(0);
            tableItem.setAgainst(0);
            table.put(team.getId(), tableItem);
        }

        for(Match match: matches){
            if(match.getHomeGoals() != null && match.getAwayGoals() != null) {
                TableItem home = table.get(match.getHome());
                TableItem away = table.get(match.getAway());
                home.setGoals(match.getHomeGoals());
                home.setAgainst(match.getAwayGoals());
                away.setGoals(match.getAwayGoals());
                away.setAgainst(match.getHomeGoals());
                home.setPlayed(1);
                away.setPlayed(1);
                if (match.getHomeGoals() > match.getAwayGoals()) {
                    home.setWon(1);
                    away.setLost(1);
                } else if (match.getHomeGoals() < match.getAwayGoals()) {
                    home.setLost(1);
                    away.setWon(1);
                } else if (match.getHomeGoals() == match.getAwayGoals()) {
                    home.setDrawn(1);
                    away.setDrawn(1);
                }
                table.put(home.getId(), home);
                table.put(away.getId(), away);
            }
        }
        TableComparator comparator = new TableComparator();
        List<TableItem> tableItems = new ArrayList<>(table.values());
        Collections.sort(tableItems, comparator.reversed());
        return tableItems;
    }
}
