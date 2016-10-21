package de.scandio.fifa.planner.config;

/**
 * Created by stefanmuecke on 19.10.16.
 */
public class RestConstants {

    public static final String BASE_URI = "/rest/v1";

    public static final String ID = "id";

    // Team ===================================================================

    public static final String NAME = "name";

    public static final String TEAMS_URI = BASE_URI + "/teams";

    public static final String TEAM_URI = TEAMS_URI + "/{" + NAME + "}";

    public static final String TEAM_FIFA_BADGE_URI = TEAMS_URI + "/badge/{" + ID + "}";

    // Match ===================================================================

    public static final String MATCHDAY = "matchday";

    public static final String MATCHES_URI = BASE_URI + "/matches";

    public static final String MATCHES_GENERATE_URI = MATCHES_URI + "/generate";

    public static final String MATCHES_ON_MATCHDAY_URI = MATCHES_URI + "/{" + MATCHDAY + "}";

    public static final String MATCH_URI = BASE_URI + "/match/{" + ID + "}" ;

    // Table ===================================================================

    public static final String TABLE_GENERATE_URI = BASE_URI + "/table";
}
