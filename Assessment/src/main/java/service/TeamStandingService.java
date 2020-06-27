package service;

import domain.TeamStandingRequest;

import javax.ws.rs.core.Response;

public interface TeamStandingService {
    Response getTeamStandings(TeamStandingRequest teamStandingRequest);
}
