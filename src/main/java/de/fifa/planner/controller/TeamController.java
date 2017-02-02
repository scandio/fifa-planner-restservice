package de.fifa.planner.controller;

import de.fifa.planner.config.RestConstants;
import de.fifa.planner.model.Team;
import de.fifa.planner.persistence.TeamImpl;
import de.fifa.planner.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("Create new team with name '{}'", name);
        Team team = new TeamImpl(name);
        team.setHasFifaBadge(false);
        return this.teamRepo.save(conversionService.convert(team, TeamImpl.class));
    }

    /**
     * Get a {@link Team} specified by the name.
     *
     * @param name the name of the team
     * @return a {@link Team}
     */
    @RequestMapping(value = RestConstants.TEAM_URI, method = RequestMethod.GET)
    public Team getTeam(@PathVariable("name") String name){
        log.info("Get team with id '{}'", name);
        return this.teamRepo.findOneByName(name);
    }

    /**
     * Set the FIFA badge for a specific {@link Team}. If an other team has the Fifa badge, it will lose it then.
     *
     * @param id the id of the {@link Team} that gets the FIFA badge
     * @return the {@link Team}
     */
    @RequestMapping(value = RestConstants.TEAM_FIFA_BADGE_URI, method = RequestMethod.POST)
    public Team setFifaBadgeForTeam(@PathVariable("id") String id){
        log.info("Set fifa badge for team with id '{}'", id);
        List<? extends Team> teams = this.teamRepo.findAll();
        for(Team team:teams){
            team.setHasFifaBadge(false);
            this.teamRepo.save(conversionService.convert(team, TeamImpl.class));
        }

        Team team = this.teamRepo.findOne(id);
        team.setHasFifaBadge(true);
        return this.teamRepo.save(conversionService.convert(team, TeamImpl.class));
    }

    /**
     * Delete a {@link Team} specified by name
     * @param name the team name
     */
    @RequestMapping(value = RestConstants.TEAM_URI, method = RequestMethod.DELETE)
    public void deleteTeam(@PathVariable("name") String name){
        log.info("Delete team with id '{}'", name);
        this.teamRepo.deleteByName(name);
    }
}
