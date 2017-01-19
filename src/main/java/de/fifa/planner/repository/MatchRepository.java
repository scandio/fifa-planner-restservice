package de.fifa.planner.repository;

import de.fifa.planner.persistence.MatchImpl;
import de.fifa.planner.model.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * An mongo db repository for {@link MatchImpl}s
 *
 * Created by stefanmuecke on 19.10.16.
 */
@Repository
public interface MatchRepository extends MongoRepository<MatchImpl, String> {

    /**
     * Get all matches for a specific matchday
     *
     * @param matchday the matchday
     * @return a {@link List} with {@link Match}es
     */
    List<? extends Match> findAllByMatchday(Integer matchday);

    /**
     * Find all matches between home and away
     * @param home the id of the home team
     * @param away the id of the away team
     * @return a {@link List} with {@link Match}es
     */
    List<? extends Match> findByHomeAndAway(String home, String away);

    /**
     * Find last matches for a team ordered by matchday desc
     * @return a {@link List} with {@link Match}es
     */
    @Query(value = "{ 'homeGoals' : { '$ne' :  null }, '$or':[ {'home' : ?0}, {'away' : ?1} ] }")
    Page<? extends Match> findAllByHomeOrAway(String home, String away, Pageable pageable);

    /**
     * Find next matches for a team ordered by matchday asc
     * @return a {@link List} with {@link Match}es
     */
    @Query(value = "{ 'homeGoals' :  null , '$or':[ {'home' : ?0}, {'away' : ?1} ] }")
    Page<? extends Match> findAllByHomeOrAwayFuture(String home, String away, Pageable pageable);
}
