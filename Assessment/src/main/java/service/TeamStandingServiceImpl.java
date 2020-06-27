package service;

import domain.TeamStanding;
import domain.TeamStandingRequest;
import org.springframework.stereotype.Service;
import serviceagent.TeamStandingServiceAgent;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
@Service
public class TeamStandingServiceImpl implements TeamStandingService {
    @Inject
    TeamStandingServiceAgent teamStandingServiceAgent;
    @Override
    public Response getTeamStandings(TeamStandingRequest teamStandingRequest) {
        Response response=null;
        if(!validateRequest(teamStandingRequest)){
            response= Response.status(400).entity("Invalid Input").build();
        }
        else {
            TeamStanding standing= teamStandingServiceAgent.getTeamStandings(teamStandingRequest);
            response = Response.status(200).entity(standing).build();
        }
        return response;
    }

    private boolean validateRequest(TeamStandingRequest teamStandingRequest) {
        if(teamStandingRequest==null){
            return  false;
        }
        else if(teamStandingRequest.getCountryName()==null || teamStandingRequest.getTeamName()==null
                || teamStandingRequest.getLeagueName()==null){
            return false;
        }
        else {
            return true;
        }
    }
}
