package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Panel {
    protected JDialog dialog;
    protected JFrame parent;
    protected ViewInfoPerPage logic;
    protected JPanel panel;
    protected JTextField name;
    protected JTextField date;   //TODO: make date not text
    protected JTextField teamName;
    protected JTextField city;
    protected JComboBox<Role> roleInTeam;
    protected JTextField position;
    protected JButton addBtn;
    protected JButton exitBtn;


    Panel(ViewInfoPerPage logic, JFrame parent){
        this.logic = logic;
        this.parent = parent;
        panel = new JPanel();
        name = new JTextField("Name");
        date = new JTextField("Date");
        teamName = new JTextField("Team name");
        city = new JTextField("City");
        roleInTeam = new JComboBox<>();

        position = new JTextField("Position");
        addBtn = new JButton("Add");
        customize();
    }
    void customize(){
        panel.setLayout(new FlowLayout());
        roleInTeam.addItem(Role.Main);
        roleInTeam.addItem(Role.Reserve);
        roleInTeam.setSelectedItem(Role.Main);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                makeAction(logic);
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        addComponentrsToPanel();
    }

    abstract void makeAction(ViewInfoPerPage logic);

    void addComponentrsToPanel(){
        panel.add(name);
        panel.add(date);
        panel.add(teamName);
        panel.add(city);
        panel.add(roleInTeam);
        panel.add(position);
        panel.add(addBtn);
        panel.add(exitBtn);
    }

    JPanel getPanel(){
        return panel;
    }

    void display (){
        dialog = new JDialog (parent, "Add new player", true);
        dialog.setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane (getPanel());
        dialog.setLocationRelativeTo (parent);
        dialog.setVisible (true);
    }


}
