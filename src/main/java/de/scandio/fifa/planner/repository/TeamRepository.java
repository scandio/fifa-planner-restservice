package de.scandio.fifa.planner.repository;

import de.scandio.fifa.planner.model.Team;
import de.scandio.fifa.planner.persistence.TeamImpl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * A mongo db repository for {@link TeamImpl}s
 *
 * Created by stefanmuecke on 19.10.16.
 */
@Repository
public interface TeamRepository extends MongoRepository<TeamImpl, String> {
}
