package com.publicis.sapient.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League {
    @JsonProperty("league_id")
    private String leagueId;
    @JsonProperty("league_name")
    private String leagueName;

    public League() {
    }

    public League(String leagueId, String leagueName) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
}
