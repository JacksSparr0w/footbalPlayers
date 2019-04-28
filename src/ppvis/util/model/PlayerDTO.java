package ppvis.util.model;

import java.util.Date;

public class PlayerDTO {
    private String name;
    private Date dateOfBirth;
    private String teamName;
    private String city;
    private Role roleInTeam;
    private String position;

    public PlayerDTO(String name, Date dateOfBirth, String teamName, String city, Role roleInTeam, String position){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.teamName = teamName;
        this.city = city;
        this.roleInTeam = roleInTeam;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Role getRoleInTeam() {
        return roleInTeam;
    }

    public void setRoleInTeam(Role roleInTeam) {
        this.roleInTeam = roleInTeam;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
