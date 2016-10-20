package de.scandio.fifa.planner.model;

import java.math.BigInteger;

/**
 * Created by stefanmuecke on 17.10.16.
 */
public interface Team {

    String getId();

    String getName();

    void setName(String name);

    boolean getHasFifaBadge();

    void setHasFifaBadge(boolean hasFifaBadge);
}
