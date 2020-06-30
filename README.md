# sapient_assessment
It contains solutions to two assessmeents:
Saddle point
Football Team Standing Service:
It is a secured service, which needs user authentication token to access the service.
Invoke POST {uri}api/auth service with below credentials
{
  "username": "admin",
  "password": "password"
}
It will provide the authentication token to access Football standing service.
Invoke GET Request {uri}api/football/teamStandings?countryName=countryName&teamName=teamName&leagueName=leagueName. Add token to Authorization: Bearer
Response will be as below:
[
  {
    "country": {
      "country_id": "41",
      "country_name": "England"
    },
    "team": {
      "teamId": "2653",
      "teamName": "Leeds"
    },
    "league": {
      "league_id": "149",
      "league_name": "Championship"
    },
    "overallLeaguePosition": "1"
  }
]
