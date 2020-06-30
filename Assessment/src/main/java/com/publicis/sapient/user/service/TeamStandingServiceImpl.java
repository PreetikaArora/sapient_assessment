package com.publicis.sapient.user.service;

import com.publicis.sapient.user.domain.Country;
import com.publicis.sapient.user.domain.TeamStanding;
import com.publicis.sapient.user.domain.TeamStandingRequest;
import com.publicis.sapient.user.serviceagent.TeamStandingServiceAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TeamStandingServiceImpl implements TeamStandingService {
    @Inject
    TeamStandingServiceAgent teamStandingServiceAgent;
    private static final Logger log = LoggerFactory.getLogger(TeamStandingServiceImpl.class);
    @Override
    public Response getTeamStandings(TeamStandingRequest teamStandingRequest) throws IOException {
        log.info("Inside getTeamStandings");
        Response response = null;

        if (!validateRequest(teamStandingRequest)) {
            log.info("Bad Request");
            response = Response.status(Response.Status.BAD_REQUEST).entity("Invalid Input").build();
        } else {
            List<TeamStanding> teamStandingResponse = new ArrayList<>();
            log.info("Getting Country details");
            Country country = teamStandingServiceAgent.getCountryIdFromName(teamStandingRequest.getCountryName());
            log.info("Response for Country details:"+country);
            if (country != null && country.getCountryId() != null) {
                List<LinkedHashMap> leagues = teamStandingServiceAgent.getLeagues(country.getCountryId(), teamStandingRequest.getLeagueName());
                log.info("Response for League details:"+leagues);
                if (!CollectionUtils.isEmpty(leagues)) {
                    for (LinkedHashMap league : leagues) {
                        teamStandingResponse = teamStandingServiceAgent.getTeamStandings(league.get("league_id").toString(), league.get("country_id").toString(), teamStandingRequest.getTeamName());
                        log.info("teamStandingResponse:"+teamStandingResponse);
                    }
                }
                response = Response.status(Response.Status.OK).entity(teamStandingResponse).build();
            }

        }
        log.info("Returning from getTeamStandings service:"+response);
        return response;
    }

    private boolean validateRequest(TeamStandingRequest teamStandingRequest) {
        if (teamStandingRequest == null) {
            return false;
        } else if (teamStandingRequest.getCountryName() == null || teamStandingRequest.getTeamName() == null
                || teamStandingRequest.getLeagueName() == null) {
            return false;
        } else {
            return true;
        }
    }
}
