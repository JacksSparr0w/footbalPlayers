package ppvis.util;

import java.util.Objects;

public class Player {

    private Name name;
    private String dateOfBirth;
    private String teamName;
    private String city;
    private Role roleInTeam;
    private int position;

    public static final String header[] = new String[]{"Name", "Date", "Team name", "City", "Role", "Position"};

    public static int getCountOfFields(){
        return 6;
    }
    public Player(String name, String dateOfBirth, String teamName, String city, Role roleInTeam, int position) {
        this.name = new Name(name);
        this.dateOfBirth = dateOfBirth;
        this.teamName = teamName;
        this.city = city;
        this.roleInTeam = roleInTeam;
        this.position = position;
     }


    public String getName(){
        return name.getName();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCity() {
        return city;
    }

    public Role getRoleInTeam() {
        return roleInTeam;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position &&
                name.equals(player.name) &&
                dateOfBirth.equals(player.dateOfBirth) &&
                Objects.equals(teamName, player.teamName) &&
                Objects.equals(city, player.city) &&
                roleInTeam == player.roleInTeam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, teamName, city, roleInTeam, position);
    }
}
