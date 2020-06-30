package com.publicis.sapient.user.service;

import com.publicis.sapient.user.domain.TeamStandingRequest;

import javax.ws.rs.core.Response;
import java.io.IOException;

public interface TeamStandingService {
    Response getTeamStandings(TeamStandingRequest teamStandingRequest) throws IOException;
}
