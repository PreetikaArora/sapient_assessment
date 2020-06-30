package com.publicis.sapient.user.api.resource;

import com.publicis.sapient.user.domain.TeamStandingRequest;
import com.publicis.sapient.user.service.TeamStandingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Path("football")
public class FootballResource {
    @Context
    private UriInfo uriInfo;
    @Inject
    private TeamStandingService teamStandingService;
    private static final Logger log = LoggerFactory.getLogger(FootballResource.class);

    /**
     * Get Team Standings
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("teamStandings")

    @PreAuthorize("hasAuthority('ADMIN')")
    public Response getTeamStandings(@BeanParam TeamStandingRequest teamStandingRequest) {
        log.info("Inside getTeamStandings");
        log.info("URI:"+uriInfo.getRequestUri().toString());
        Response response=null;
        try {
            response=teamStandingService.getTeamStandings(teamStandingRequest);
        }
        catch(Exception e){
            log.error("Error while executing teamStandings service");
            e.printStackTrace();
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error while executing teamStandings service").build();
        }
        return response;
    }
}
