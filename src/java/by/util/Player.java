package java.by.util;

import java.util.Date;
import java.util.Objects;

public class Player {

    private String firstName;
    private String secondName;
    private String lastName;

    private String dateOfBirth;
    private String teamName;
    private String city;
    private Role roleInTeam;
    private int position;

    public static final String header[] = new String[]{"Name", "Date", "Team name", "City", "Role", "Position"};

    public static int getCountOfFields(){
        return 6;
    }
    public Player(String name[], String dateOfBirth, String teamName, String city, Role roleInTeam, int position) {
        firstName = name[0];
        secondName = name[1];
        lastName = name[2];
        this.dateOfBirth = dateOfBirth;
        this.teamName = teamName;
        this.city = city;
        this.roleInTeam = roleInTeam;
        this.position = position;
     }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
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

    public String getFullName(){
        return firstName + " " + secondName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position &&
                firstName.equals(player.firstName) &&
                secondName.equals(player.secondName) &&
                lastName.equals(player.lastName) &&
                dateOfBirth.equals(player.dateOfBirth) &&
                Objects.equals(teamName, player.teamName) &&
                Objects.equals(city, player.city) &&
                roleInTeam == player.roleInTeam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName, dateOfBirth, teamName, city, roleInTeam, position);
    }
}
