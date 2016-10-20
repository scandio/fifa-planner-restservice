package de.scandio.fifa.planner.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.scandio.fifa.planner.model.Match;
import de.scandio.fifa.planner.model.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by stefanmuecke on 17.10.16.
 */
@Document
public class MatchImpl implements Match, Serializable {

    @Id
    private String id;

    @JsonProperty
    private String home;
    @JsonProperty
    private String away;
    @JsonProperty
    private Integer matchday;
    @JsonProperty
    private Integer homeGoals;
    @JsonProperty
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
