package de.fifa.planner.model;

import java.util.List;

/**
 * Created by stefanmuecke on 19.01.17.
 */
public interface League {

    /**
     * The league id
     *
     * @return a {@link String}
     */
    String getId();

    /**
     * The matches of the league
     *
     * @return a {@link List} with matches
     */
    List<? extends Match> getMatches();

    /**
     * Set the
     * @param matches
     */
    void setMatches(List<Match> matches);

    /**
     * The teams of the league
     *
     * @return a {@link List} with teams
     */
    List<? extends Team> getTeams();
}
