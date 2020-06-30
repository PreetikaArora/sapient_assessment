package com.publicis.sapient.user.domain;

import javax.ws.rs.QueryParam;

public class TeamStandingRequest {
    @QueryParam("countryName")
    private String countryName;
    @QueryParam("teamName")
    private String teamName;
    @QueryParam("leagueName")
    private String leagueName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
}
