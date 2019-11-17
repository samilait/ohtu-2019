
package ohtu;

public class Player implements Comparable<Player> {
    private String name, team, nationality;
    private int goals, assists, points;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return nationality;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getGoals() {
        return goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getAssists() {
        return assists;
    }
    
    public Integer getPoints() {
        this.points = goals + assists;
        return points;
    }           

    @Override
    public String toString() {
        return name + " " + team + " " + goals + " + " + assists + " = " + points;
    }

    @Override
    public int compareTo(Player o) {
        return this.getPoints().compareTo(o.getPoints());
    }
      
}
