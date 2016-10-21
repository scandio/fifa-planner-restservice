package de.scandio.fifa.planner.controller;

import de.scandio.fifa.planner.config.RestConstants;
import de.scandio.fifa.planner.model.Team;
import de.scandio.fifa.planner.persistence.TeamImpl;
import de.scandio.fifa.planner.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A basic rest controller for managing {@link Team}s
 *
 * Created by stefanmuecke on 21.10.16.
 */
@RestController
@CrossOrigin(origins = "*")
public class TeamController {

    /**
     * MongoDB repository for {@link TeamImpl}s
     */
    @Autowired
    private TeamRepository teamRepo;

    /**
     * Conversion service to convert Entities
     */
    @Autowired
    private ConversionService conversionService;

    // Team Controller =================================================================

    /**
     * Retrieve a list with all {@link TeamImpl}s in the database.
     *
     * @return a {@link List} of {@link TeamImpl}s
     */
    @RequestMapping(value = RestConstants.TEAMS_URI, method = RequestMethod.GET)
    public List<? extends Team> getTeams(){
        return this.teamRepo.findAll();
    }

    /**
     * Create a new team in the database.
     *
     * @param name the name of the team
     * @return the created {@link Team}
     */
    @RequestMapping(value = RestConstants.TEAM_URI, method = RequestMethod.POST)
    public Team createTeam(@PathVariable("name") String name){
        Team team = new TeamImpl(name);
        team.setHasFifaBadge(false);
        return this.teamRepo.save(conversionService.convert(team, TeamImpl.class));
    }

    /**
     * Get a {@link Team} specified by the id.
     *
     * @param id the id of the team
     * @return a {@link Team}
     */
    @RequestMapping(value = RestConstants.TEAM_URI, method = RequestMethod.GET)
    public Team getTeam(@PathVariable("id") String id){
        return this.teamRepo.findOne(id);
    }

    /**
     * Set the FIFA badge for a specific {@link Team}. If an other team has the Fifa badge, it will lose it then.
     *
     * @param id the id of the {@link Team} that gets the FIFA badge
     * @return the {@link Team}
     */
    @RequestMapping(value = RestConstants.TEAM_FIFA_BADGE_URI, method = RequestMethod.POST)
    public Team setFifaBadgeForTeam(@PathVariable("id") String id){
        List<? extends Team> teams = this.teamRepo.findAll();
        for(Team team:teams){
            team.setHasFifaBadge(false);
            this.teamRepo.save(conversionService.convert(team, TeamImpl.class));
        }

        Team team = this.teamRepo.findOne(id);
        team.setHasFifaBadge(true);
        return this.teamRepo.save(conversionService.convert(team, TeamImpl.class));
    }
}
