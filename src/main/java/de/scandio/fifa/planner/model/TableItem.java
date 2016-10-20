package de.scandio.fifa.planner.model;

import java.math.BigInteger;

/**
 * Created by stefanmuecke on 19.10.16.
 */
public interface TableItem {

    String getId();

    void setId(String id);

    Integer getPlayed();

    void setPlayed(Integer played);

    Integer getWon();

    void setWon(Integer won);

    Integer getDrawn();

    void setDrawn(Integer drawn);

    Integer getLost();

    void setLost(Integer lost);

    Integer getGoals();

    void setGoals(Integer goals);

    Integer getAgainst();

    void setAgainst(Integer against);

    Integer getPoints();

    Integer getDiff();
}
