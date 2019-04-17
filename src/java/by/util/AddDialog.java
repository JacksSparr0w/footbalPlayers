package java.by.util;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddDialog extends JDialog {

    private JTextField name;

    private JTextField date;   //TODO: make date not text

    private JTextField teamName;

    private JTextField city;

    private JComboBox<Role> roleInTeam;

    private JTextField position;

    private JButton addBtn;

    private JButton exitBtn;


    AddDialog(JFrame frame, List<Player> info){
        super(frame, "Add new player", true);

        name = new JTextField("Full name");
        date = new JTextField("Date");
        teamName = new JTextField("Team name");
        city = new JTextField("City");
        roleInTeam = new JComboBox<>();
        roleInTeam.addItem(Role.Main);
        roleInTeam.addItem(Role.Reserve);
        position = new JTextField("Position");
        addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                info.add(new Player(name.getText().split(" "), date.getText(), teamName.getText(), city.getText(), (Role) roleInTeam.getSelectedItem(), Integer.getInteger(position.getText())));
            }
        });

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddDialog.super.dispose();
            }
        });

        add(name);
        add(date);
        add(teamName);
        add(city);
        add(roleInTeam);
        add(position);
        add(addBtn);
        add(exitBtn);
    }
}
