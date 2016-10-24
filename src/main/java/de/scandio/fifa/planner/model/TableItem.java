package de.scandio.fifa.planner.model;

/**
 * An interface for {@link TableItem}s
 *
 * Created by stefanmuecke on 19.10.16.
 */
public interface TableItem {

    /**
     * The id of the {@link Team}
     *
     * @return a {@link String}
     */
    String getId();

    /**
     * Setter for the id of the {@link Team}
     *
     * @param id the team id
     */
    void setId(String id);

    /**
     * Getter for the played matches of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getPlayed();

    /**
     * Setter for the played matches of the {@link Team}
     *
     * @param played the amount of played matches
     */
    void setPlayed(Integer played);

    /**
     * Getter for the won matches of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getWon();

    /**
     * Setter for the won matches of the {@link Team}
     *
     * @param won the amount of won matches
     */
    void setWon(Integer won);

    /**
     * Getter for the drawn matches of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getDrawn();

    /**
     * Setter for the drwan matches of the {@link Team}
     *
     * @param drawn the amount of drwan matches
     */
    void setDrawn(Integer drawn);

    /**
     * Getter for the lost matches of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getLost();

    /**
     * Setter for the lost matches of the {@link Team}
     *
     * @param lost the amount of lost matches
     */
    void setLost(Integer lost);

    /**
     * Getter for the goals of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getGoals();

    /**
     * Setter for the goals of the {@link Team}
     *
     * @param goals the amount of goals
     */
    void setGoals(Integer goals);

    /**
     * Getter for the against goals of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getAgainst();

    /**
     * Setter for the against of the {@link Team}
     *
     * @param against the amount of against goals
     */
    void setAgainst(Integer against);

    /**
     * Getter for the points of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getPoints();

    /**
     * Getter for the goal differnece of the {@link Team}
     *
     * @return an {@link Integer}
     */
    Integer getDiff();
}
