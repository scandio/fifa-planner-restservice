package de.scandio.fifa.planner.repository;

import de.scandio.fifa.planner.model.Match;
import de.scandio.fifa.planner.persistence.MatchImpl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by stefanmuecke on 19.10.16.
 */
@Repository
public interface MatchRepository extends MongoRepository<MatchImpl, String> {

    List<? extends Match> findAllByMatchday(Integer matchday);
}
