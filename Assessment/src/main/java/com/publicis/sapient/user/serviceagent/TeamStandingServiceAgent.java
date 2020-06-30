package com.publicis.sapient.user.serviceagent;

import com.publicis.sapient.user.domain.Country;
import com.publicis.sapient.user.domain.TeamStanding;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public interface TeamStandingServiceAgent {

    List<TeamStanding> getTeamStandings(String leagueId, String countryId, String teamName) throws IOException;

    Country getCountryIdFromName(String countryName) throws IOException;

    List<LinkedHashMap> getLeagues(String countryId, String leagueName);
}
