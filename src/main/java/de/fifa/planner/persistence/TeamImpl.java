package de.fifa.planner.persistence;

import de.fifa.planner.model.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A basic {@link Team} implementation
 *
 * Created by stefanmuecke on 17.10.16.
 */
@Document
public class TeamImpl implements Team {

    /**
     * A unique id
     */
    @Id
    private String id;

    /**
     * the name of the team
     */
    private String name;

    /**
     * boolean for the fifa badge
     */
    private boolean hasFifaBadge;

    /**
     * default constructor
     */
    public TeamImpl() {
    }

    /**
     * Constructor with name parameter
     *
     * @param name the name of the team
     */
    public TeamImpl(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean getHasFifaBadge() {
        return hasFifaBadge;
    }

    @Override
    public void setHasFifaBadge(boolean hasFifaBadge) {
        this.hasFifaBadge = hasFifaBadge;
    }
}
