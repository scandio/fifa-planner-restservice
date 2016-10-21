package de.scandio.fifa.planner.controller;

import de.scandio.fifa.planner.config.RestConstants;
import de.scandio.fifa.planner.model.Match;
import de.scandio.fifa.planner.persistence.MatchImpl;
import de.scandio.fifa.planner.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by stefanmuecke on 21.10.16.
 */
@RestController
@CrossOrigin(origins = "*")
public class MatchController {

    @Autowired
    private MatchRepository matchRepo;

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

}
