package domain;

public class TeamStanding {
    private Country country;
    private Team team;
    private League league;
    private String leaguePosition;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
    public String getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(String leaguePosition) {
        this.leaguePosition = leaguePosition;
    }


}
