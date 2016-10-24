package de.fifa.planner.model;

import de.fifa.planner.persistence.MatchImpl;

/**
 * An interface for {@link MatchImpl}s
 *
 * Created by stefanmuecke on 19.10.16.
 */
public interface Match {

    /**
     * The match id
     *
     * @return a {@link String}
     */
    String getId();

    /**
     * Getter for the id of the home team
     *
     * @return a {@link String}
     */
    String getHome();

    /**
     * Setter for the id of the home team
     *
     * @param home the id of the home team
     */
    void setHome(String home);

    /**
     * Getter for the id of the away team
     *
     * @return a {@link String}
     */
    String getAway();

    /**
     * Setter for the id of the away team
     *
     * @param away the id of the away team
     */
    void setAway(String away);

    /**
     * Getter for the matchday
     *
     * @return a {@link Integer}
     */
    Integer getMatchday();

    /**
     * Setter for the matchday
     *
     * @param matchday the matchday
     */
    void setMatchday(Integer matchday);

    /**
     * Getter for the goals of the home team
     *
     * @return an {@link Integer}
     */
    Integer getHomeGoals();

    /**
     * Setter for the goals of the home team
     *
     * @param homeGoals the home goals
     */
    void setHomeGoals(Integer homeGoals);

    /**
     * Getter for the goals of the away team
     *
     * @return an {@link Integer}
     */
    Integer getAwayGoals();

    /**
     * Setter for the goals of the home team
     *
     * @param awayGoals the away goals
     */
    void setAwayGoals(Integer awayGoals);
}
