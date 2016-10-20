package de.scandio.fifa.planner.model;

import java.math.BigInteger;

/**
 * Created by stefanmuecke on 19.10.16.
 */
public interface Match {

    String getId();

    String getHome();

    void setHome(String home);

    String getAway();

    void setAway(String away);

    Integer getMatchday();

    void setMatchday(Integer matchday);

    Integer getHomeGoals();

    void setHomeGoals(Integer homeGoals);

    Integer getAwayGoals();

    void setAwayGoals(Integer awayGoals);
}
