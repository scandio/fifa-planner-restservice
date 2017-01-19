package de.fifa.planner.config;

/**
 * The rest constants for all controllers.
 *
 * Created by stefanmuecke on 19.10.16.
 */
public class RestConstants {

    /**
     * The base uri of the application
     */
    public static final String BASE_URI = "/rest/v1";

    // Path variables

    /**
     * An id pathvariable
     */
    public static final String ID = "id";

    /**
     * A name path variable
     */
    public static final String NAME = "name";

    /**
     * A matchday path variable
     */
    public static final String MATCHDAY = "matchday";

    // Request Parameter ======================================================

    /**
     * A result size variable
     */
    public static final String RESULT_SIZE= "resultSize";

    /**
     * A default result size variable
     */
    public static final String DEFAULT_RESULT_SIZE= "5";

    // Team ===================================================================

    /**
     * The base uri for team actions
     */
    public static final String TEAMS_URI = BASE_URI + "/teams";

    /**
     * The uri for creating a team
     */
    public static final String TEAM_URI = TEAMS_URI + "/{" + NAME + "}";

    /**
     * The uri to set the FIFA badge for a team
     */
    public static final String TEAM_FIFA_BADGE_URI = TEAMS_URI + "/badge/{" + ID + "}";

    // Match ===================================================================

    /**
     * The base uri for match actions
     */
    public static final String MATCHES_URI = BASE_URI + "/matches";

    /**
     * The uri for generating the matchdays
     */
    public static final String MATCHES_GENERATE_URI = MATCHES_URI + "/generate";

    /**
     * The uri to retrieve matches for a matchday
     */
    public static final String MATCHES_ON_MATCHDAY_URI = MATCHES_URI + "/{" + MATCHDAY + "}";

    /**
     * The uri to retrieve the match information
     */
    public static final String MATCH_URI = BASE_URI + "/match/{" + ID + "}" ;

    // Table ===================================================================

    /**
     * The uri to generate the table
     */
    public static final String TABLE_GENERATE_URI = BASE_URI + "/table";

    // Stats ====================================================================

    /**
     * The uri to show statistics
     */
    public static final String STATS_BASE_URI = BASE_URI + "/stats";

    /**
     * The uri to show last matches
     */
    public static final String STATS_TEAM_HISTORY_URI = STATS_BASE_URI + "/history/{" + ID + "}";

    /**
     * The uri to show next matches
     */
    public static final String STATS_TEAM_FUTURE_URI = STATS_BASE_URI + "/future/{" + ID + "}";
}
