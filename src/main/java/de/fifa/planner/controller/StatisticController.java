package de.fifa.planner.controller;

import de.fifa.planner.config.RestConstants;
import de.fifa.planner.model.Match;
import de.fifa.planner.persistence.MatchImpl;
import de.fifa.planner.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic rest controller for managing statistics
 *
 * Created by stefanmuecke on 18.01.17.
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class StatisticController {

    /**
     * MongoDB repository for {@link MatchImpl}s
     */
    @Autowired
    private MatchRepository matchRepo;

    // Team Controller =================================================================

    /**
     * Retrieve a list with {@link MatchImpl}s of the last matches for a team.
     *
     * @return a {@link List} of {@link MatchImpl}s
     */
    @RequestMapping(value = RestConstants.STATS_TEAM_HISTORY_URI, method = RequestMethod.GET)
    public List<? extends Match> getLastMatches(
            @PathVariable("id") final String id,
            @RequestParam(value = RestConstants.RESULT_SIZE, defaultValue = RestConstants.DEFAULT_RESULT_SIZE) final int resultSize){
        PageRequest request = new PageRequest(0, resultSize, new Sort(Sort.Direction.DESC, "matchday"));
        Page<? extends Match> matches = matchRepo.findAllByHomeOrAway(id, id, request);
        return matches.getContent();
    }

    /**
     * Retrieve a list with {@link MatchImpl}s of the last matches for a team.
     *
     * @return a {@link List} of {@link MatchImpl}s
     */
    @RequestMapping(value = RestConstants.STATS_TEAM_FUTURE_URI, method = RequestMethod.GET)
    public List<? extends Match> getNextMatches(
            @PathVariable("id") final String id,
            @RequestParam(value = RestConstants.RESULT_SIZE, defaultValue = RestConstants.DEFAULT_RESULT_SIZE) final int resultSize){
        PageRequest request = new PageRequest(0, resultSize, new Sort(Sort.Direction.ASC, "matchday"));
        Page<? extends Match> matches = matchRepo.findAllByHomeOrAwayFuture(id, id, request);
        return matches.getContent();
    }

}
