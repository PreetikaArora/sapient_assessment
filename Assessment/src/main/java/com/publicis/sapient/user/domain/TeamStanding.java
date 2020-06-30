package com.publicis.sapient.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamStanding {
    private Country country;
    private Team team;
    private League league;
    @JsonProperty("overallLeaguePosition")
    private String leaguePosition;

    public TeamStanding(Country country, Team team, League league, String leaguePosition) {
        this.country = country;
        this.team = team;
        this.league = league;
        this.leaguePosition = leaguePosition;
    }

    public TeamStanding() {

    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
    public String getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(String leaguePosition) {
        this.leaguePosition = leaguePosition;
    }


}
