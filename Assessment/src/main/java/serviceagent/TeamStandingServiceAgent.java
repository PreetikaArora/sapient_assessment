package serviceagent;

import domain.TeamStanding;
import domain.TeamStandingRequest;

public interface TeamStandingServiceAgent {

    TeamStanding getTeamStandings(TeamStandingRequest teamStandingRequest);
}
