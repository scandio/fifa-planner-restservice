package de.fifa.planner.repository;

import de.fifa.planner.persistence.TeamImpl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * A mongo db repository for {@link TeamImpl}s
 *
 * Created by stefanmuecke on 19.10.16.
 */
@Repository
public interface TeamRepository extends MongoRepository<TeamImpl, String> {

    /**
     * Find a {@link TeamImpl} by name
     * @param name the team name
     * @return a {@link TeamImpl}
     */
    public TeamImpl findOneByName(String name);

    /**
     * Delete {@link TeamImpl} by name
     * @param name the team name
     */
    public void deleteByName(String name);
}
