package de.fifa.planner.model;

/**
 * Created by stefanmuecke on 17.10.16.
 */
public interface Team {

    /**
     * Getter for the id of the {@link Team}
     *
     * @return a {@link String}
     */
    String getId();

    /**
     * Getter for the name of the {@link Team}
     *
     * @return a {@link String}
     */
    String getName();

    /**
     * Setter for the name of the {@link Team}
     *
     * @param name the name of the team
     */
    void setName(String name);

    /**
     * Getter for the fifa badge
     *
     * @return a boolean
     */
    boolean getHasFifaBadge();

    /**
     * Setter for the fifa badge
     *
     * @param hasFifaBadge a boolean
     */
    void setHasFifaBadge(boolean hasFifaBadge);
}
