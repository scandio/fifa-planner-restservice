package de.scandio.fifa.planner.controller;

import de.scandio.fifa.planner.config.RestConstants;
import de.scandio.fifa.planner.model.Match;
import de.scandio.fifa.planner.persistence.MatchImpl;
import de.scandio.fifa.planner.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A basic rest controller for managing {@link Match}es
 *
 * Created by stefanmuecke on 21.10.16.
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class MatchController {

    /**
     * MongoDB repository for {@link MatchImpl}s
     */
    @Autowired
    private MatchRepository matchRepo;

    /**
     * Conversion service to convert Entities
     */
    @Autowired
    private ConversionService conversionService;

    // Match Controller ================================================================

    /**
     * Retrieve a list with all {@link Match}es in the database.
     *
     * @return a {@link List} of {@link Match}es
     */
    @RequestMapping(value = RestConstants.MATCHES_URI, method = RequestMethod.GET)
    public List<? extends Match> getMatches(){
        return this.matchRepo.findAll();
    }

    /**
     * Retrieve a list with all {@link Match}es on a specific matchday in the database.
     *
     * @return a {@link List} of {@link Match}es
     */
    @RequestMapping(value = RestConstants.MATCHES_ON_MATCHDAY_URI, method = RequestMethod.GET)
    public List<? extends Match> getMatchesOnMatchday(@PathVariable("matchday") Integer matchday){
        log.info("Get matches for matchday {}", matchday);
        List<? extends Match> matches = this.matchRepo.findAllByMatchday(matchday);
        return matches;
    }

    /**
     * Create a new match
     *
     * @param match the match
     * @return the created {@link Match}
     */
    @RequestMapping(value = RestConstants.MATCHES_URI, method = RequestMethod.POST)
    public Match createMatch(@RequestBody MatchImpl match){
        Match matchImpl = this.matchRepo.save(match);
        log.info("Created new match with id '{}' between '{}' and '{}'", matchImpl.getId(),
                matchImpl.getHome(), matchImpl.getAway());
        return matchImpl;
    }

    /**
     * Get the data of a specific match
     *
     * @param id the match id
     * @return the {@link Match}
     */
    @RequestMapping(value = RestConstants.MATCH_URI, method = RequestMethod.GET)
    public Match getMatch(@PathVariable("id") String id){
        log.info("Get Match with id '{}'", id);
        return this.matchRepo.findOne(id);
    }

}
