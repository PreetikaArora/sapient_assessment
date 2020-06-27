package serviceagent;

import domain.TeamStanding;
import domain.TeamStandingRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.HashMap;

@Service
public class TeamStandingServiceAgentImpl implements TeamStandingServiceAgent {
    @Inject
    RestTemplate restTemplate;
    String url="https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    @Override
    public TeamStanding getTeamStandings(TeamStandingRequest teamStandingRequest) {
        //Get LeagueId using LeagueName in request
        HashMap<String,String> response =restTemplate.getForObject(url,HashMap.class); //Modify using input League Id Param
        TeamStanding teamStanding= new TeamStanding();
        //build object with response
        return teamStanding;
    }
}
