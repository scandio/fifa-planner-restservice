package de.scandio.fifa.planner.persistence;

import de.scandio.fifa.planner.model.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * Created by stefanmuecke on 17.10.16.
 */
@Document
public class TeamImpl implements Team {

    @Id
    private String id;

    private String name;

    private boolean hasFifaBadge;

    public TeamImpl() {
    }

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
