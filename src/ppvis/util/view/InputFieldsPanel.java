package ppvis.util.view;

import ppvis.util.model.Role;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Date;

public class InputFieldsPanel {
    private JPanel panel;

    private JTextField firstName;
    private JTextField secondName;
    private JTextField lastName
            ;
    private DatePicker datePicker;
    private JTextField teamName;
    private JTextField city;
    private JComboBox<Role> roleInTeam;
    private JTextField position;

    private JButton actionBtn;
    private JButton exitBtn;


    InputFieldsPanel(){
        panel = new JPanel();
        firstName = new JTextField();
        secondName = new JTextField();
        lastName = new JTextField();
        datePicker = new DatePicker();
        teamName = new JTextField();
        city = new JTextField();
        roleInTeam = new JComboBox<>();
        position = new JTextField();
        actionBtn = new JButton();
        exitBtn = new JButton("Exit");
        tuneUp();
    }

    private void tuneUp(){
        panel.setLayout(new GridLayout(9, 2, 15, 15));
        roleInTeam.addItem(Role.Main);
        roleInTeam.addItem(Role.Reserve);

        addComponentsToPanel();
    }

    private void addComponentsToPanel(){
        String header[] = new String[]{"First name", "Second name", "Last Name", "Date", "Team name", "City", "Role", "Position"};
        Component[] components = {firstName, secondName, lastName, datePicker.getDatePicker(), teamName, city, roleInTeam, position};
        for(int i = 0; i < header.length; i++) {
            panel.add(new JLabel(header[i]));
            panel.add(components[i]);
        }

        panel.add(actionBtn);
        panel.add(exitBtn);
    }

    void addRole(Role role){
        roleInTeam.addItem(role);
    }

    JPanel getPanel(){
        return panel;
    }

    String getFirstName() {
        return firstName.getText().trim();
    }

    String getSecondName() {
        return secondName.getText().trim();
    }

    String getLastName() {
        return lastName.getText().trim();
    }

    Date getDate() throws ParseException {
        return datePicker.getDate();
    }

    String getTeamName() {
        return teamName.getText().trim();
    }

    String getCity() {
        return city.getText().trim();
    }

    Role getRoleInTeam() {
        return (Role) roleInTeam.getSelectedItem();
    }

    String getPosition() {
        return position.getText().trim();
    }

    JButton getActionBtn() {
        return actionBtn;
    }

    JButton getExitBtn() {
        return exitBtn;
    }
}

