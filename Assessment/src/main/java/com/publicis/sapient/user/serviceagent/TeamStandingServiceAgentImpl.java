package com.publicis.sapient.user.serviceagent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.publicis.sapient.user.domain.*;
import com.publicis.sapient.user.service.TeamStandingServiceImpl;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamStandingServiceAgentImpl implements TeamStandingServiceAgent {

    private static final String FOOTBALL_STANDING_API = "https://apiv2.apifootball.com";
    private static final String APIKEY = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    private static final Logger log = LoggerFactory.getLogger(TeamStandingServiceImpl.class);
    @Override
    public List<TeamStanding> getTeamStandings(String leagueId, String countryId, String teamName) throws IOException {
        log.info("Inside getTeamStandings");
        List<TeamStanding> teamStanding = new ArrayList<>();
        Client client = ClientBuilder.newClient(new ClientConfig().register(JacksonFeature.class));
        WebTarget webTarget = client.target(FOOTBALL_STANDING_API).queryParam("action", "get_standings")
                .queryParam("league_id", leagueId)
                .queryParam("APIkey", APIKEY);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        byte[] jsonData = response.readEntity(byte[].class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Standings> standings = objectMapper.readValue(jsonData, new TypeReference<List<Standings>>() {});
        standings=standings.parallelStream().filter(standing->standing.getTeamName().equalsIgnoreCase(teamName)).collect(Collectors.toList());
        if (standings!=null ) {
            teamStanding = buildTeamStandingResponse(standings, countryId);
        }
        log.info("Returning from getTeamStandings:"+teamStanding);
        return teamStanding;
    }

    @Override
    public Country getCountryIdFromName(String countryName) throws IOException {
        log.info("Inside getCountryIdFromName for "+countryName);
        Country countryResponse = new Country();
        Client client = ClientBuilder.newClient(new ClientConfig().register(JacksonFeature.class));
        WebTarget webTarget = client.target(FOOTBALL_STANDING_API).queryParam("action", "get_countries")
                .queryParam("APIkey", APIKEY);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get(Response.class);
        byte[] jsonData = response.readEntity(byte[].class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Country> countries = objectMapper.readValue(jsonData, new TypeReference<List<Country>>() {});
        if (countries != null) {
            for (Country country : countries) {
                if (country.getCountryName().equalsIgnoreCase(countryName)) {
                    countryResponse = country;
                    break;
                }
            }
        }
        log.info("Returning from getCountryIdFromName:"+countryResponse);
        return countryResponse;
    }

    @Override
    public List<LinkedHashMap> getLeagues(String countryId, String leagueName) {
        log.info("Inside getLeagues");
        Client client = ClientBuilder.newClient(new ClientConfig().register(JacksonFeature.class));
        WebTarget webTarget = client.target(FOOTBALL_STANDING_API).queryParam("action", "get_leagues")
                .queryParam("country_id", countryId)
                .queryParam("APIkey", APIKEY);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        List<LinkedHashMap> leagues = response.readEntity(List.class);
        leagues = leagues.stream().filter(league -> league.containsValue(leagueName))
                .collect(Collectors.toList());
        log.info("Returning from getLeagues:"+leagues);
        return leagues;
    }

    private List<TeamStanding> buildTeamStandingResponse(List<Standings> standings, String countryId) {
        List<TeamStanding> teamStandings= new ArrayList<>();
        standings.parallelStream().forEach(standing->{
            TeamStanding teamStanding = new TeamStanding(new Country(countryId, standing.getCountryName()), new Team(standing.getTeamId(), standing.getTeamName()),
                    new League(standing.getLeagueId(), standing.getLeagueName()), standing.getOverallLeaguePosition());
            teamStandings.add(teamStanding);
        });
        return teamStandings;
    }
}
