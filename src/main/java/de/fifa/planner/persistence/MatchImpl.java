package de.fifa.planner.persistence;

import de.fifa.planner.model.Match;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A basic {@link Match} implementation
 *
 * Created by stefanmuecke on 17.10.16.
 */
@Document
public class MatchImpl implements Match, Serializable {

    /**
     * A unique id of the {@link Match}
     */
    @Id
    private String id;
    /**
     * the id of the home team
     */
    private String home;
    /**
     * the id of the away team
     */
    private String away;
    /**
     * the matchday
     */
    private Integer matchday;
    /**
     * the amount of home goals
     */
    private Integer homeGoals;
    /**
     * the amount of away goals
     */
    private Integer awayGoals;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getHome() {
        return home;
    }

    @Override
    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String getAway() {
        return away;
    }

    @Override
    public void setAway(String away) {
        this.away = away;
    }

    @Override
    public Integer getMatchday() {
        return matchday;
    }

    @Override
    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    @Override
    public Integer getHomeGoals() {
        return homeGoals;
    }

    @Override
    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    @Override
    public Integer getAwayGoals() {
        return awayGoals;
    }

    @Override
    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }
}
