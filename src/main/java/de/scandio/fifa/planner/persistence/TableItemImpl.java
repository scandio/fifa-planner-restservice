package de.scandio.fifa.planner.persistence;

import de.scandio.fifa.planner.model.TableItem;

import java.math.BigInteger;

/**
 * Created by stefanmuecke on 17.10.16.
 */
public class TableItemImpl implements TableItem {

    private String id;
    private Integer played;
    private Integer won;
    private Integer drawn;
    private Integer lost;
    private Integer goals;
    private Integer against;
    private Integer points;
    private Integer diff;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Integer getPlayed() {
        return played;
    }

    @Override
    public void setPlayed(Integer played) {
        if(this.played != null){
            this.played += played;
        }else{
            this.played = played;
        }
    }

    @Override
    public Integer getWon() {
        return won;
    }

    @Override
    public void setWon(Integer won) {
        if(this.won != null) {
            this.won += won;
        }else{
            this.won = won;
        }
    }

    @Override
    public Integer getDrawn() {
        return drawn;
    }

    @Override
    public void setDrawn(Integer drawn) {
        if(this.drawn != null){
            this.drawn += drawn;
        }else{
            this.drawn = drawn;
        }

    }

    @Override
    public Integer getLost() {
        return lost;
    }

    @Override
    public void setLost(Integer lost) {
        if(this.lost != null){
            this.lost += lost;
        }else{
            this.lost = lost;
        }

    }

    @Override
    public Integer getGoals() {
        return goals;
    }

    @Override
    public void setGoals(Integer goals) {
        if(this.goals != null){
            this.goals += goals;
        }else{
            this.goals = goals;
        }

    }

    @Override
    public Integer getAgainst() {
        return against;
    }

    @Override
    public void setAgainst(Integer against) {
        if(this.against != null){
            this.against += against;
        }else{
            this.against = against;
        }

    }

    @Override
    public Integer getPoints() {
        this.points = this.won * 3 + this.drawn * 1;
        return points;
    }

    @Override
    public Integer getDiff(){
        return this.goals - this.against;
    }
}
