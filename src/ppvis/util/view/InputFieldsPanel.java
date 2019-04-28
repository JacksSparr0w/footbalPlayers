package ppvis.util.view;

import ppvis.util.model.Role;
import ppvis.util.model.Constants;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Date;

public class InputFieldsPanel {
    private JPanel panel;

    private JTextField name;
    private DatePicker datePicker;
    private JTextField teamName;
    private JTextField city;
    private JComboBox<Role> roleInTeam;
    private JTextField position;

    private JButton actionBtn;
    private JButton exitBtn;


    InputFieldsPanel(){
        panel = new JPanel();
        name = new JTextField();
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
        panel.setLayout(new GridLayout(7, 2, 15, 15));
        roleInTeam.addItem(Role.Main);
        roleInTeam.addItem(Role.Reserve);

        addComponentsToPanel();
    }

    private void addComponentsToPanel(){
        Component[] temp = {name, datePicker.getDatePicker(), teamName, city, roleInTeam, position};
        for(int i = 0; i < Constants.COUNT_OF_FIELDS; i++) {
            panel.add(new JLabel(Constants.header[i]));
            panel.add(temp[i]);
        }

        panel.add(actionBtn);
        panel.add(exitBtn);
    }

    public void addRole(Role role){
        roleInTeam.addItem(role);
    }

    public JPanel getPanel(){
        return panel;
    }

    public String getName() {
        return name.getText().trim();
    }

    public Date getDate() throws ParseException {
        return datePicker.getDate();
    }

    public String getTeamName() {
        return teamName.getText().trim();
    }

    public String getCity() {
        return city.getText().trim();
    }

    public Role getRoleInTeam() {
        return (Role) roleInTeam.getSelectedItem();
    }

    public String getPosition() {
        return position.getText().trim();
    }

    public JButton getActionBtn() {
        return actionBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }
}

