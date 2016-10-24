package de.scandio.fifa.planner.repository;

import de.scandio.fifa.planner.model.Match;
import de.scandio.fifa.planner.persistence.MatchImpl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
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
}
