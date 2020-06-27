package resource;

import domain.TeamStandingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TeamStandingService;
import service.TeamStandingServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/football")
public class FootBallResource {
    @Inject
    TeamStandingServiceImpl teamStandingService;
    @GET
    @Produces("application/json")
    @Path("/teamStandings")
    public Response getTeamStandings(@BeanParam TeamStandingRequest teamStandingRequest){
        Response response=null;
        try {
           response=teamStandingService.getTeamStandings(teamStandingRequest);
        }
        catch(Exception e){
            Response.status(500).entity(null).build();
        }
        return response;
    }
}
