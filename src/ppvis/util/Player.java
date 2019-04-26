package ppvis.util;

import java.util.Date;
import java.util.Objects;

public class Player {

    private Name name;
    private Date dateOfBirth;
    private String teamName;
    private String city;
    private Role roleInTeam;
    private int position;

    public Player(Name name, Date dateOfBirth, String teamName, String city, String roleInTeam, int i){

    }

    public Player(Name name, Date dateOfBirth, String teamName, String city, Role roleInTeam, int position) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.teamName = teamName;
        this.city = city;
        this.roleInTeam = roleInTeam;
        setPosition(position);
     }

     public Player(String name, Date dateOfBirth, String teamName, String city, Role roleInTeam, String position){
        this(new Name(name), dateOfBirth, teamName, city, roleInTeam,
                position.equalsIgnoreCase("") ? 0 : Integer.parseInt(position));
     }

     public Player(PlayerDTO playerDto) {
        this(playerDto.getName(),
                playerDto.getDateOfBirth(),
                playerDto.getTeamName(),
                playerDto.getCity(),
                playerDto.getRoleInTeam(),
                playerDto.getPosition());
     }


    public String getName(){
        return name.getName();
    }

    public String getDateOfBirthBeautiful() {
        return Constants.sdf.format(dateOfBirth);
    }

    public Date getDateOfBirth(){
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

    public void setPosition(int position) {
        if (position > 0)
            this.position = position;
        else this.position = 0;
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
