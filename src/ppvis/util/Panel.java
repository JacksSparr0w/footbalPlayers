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
        name = new JTextField();
        date = new JTextField();
        teamName = new JTextField();
        city = new JTextField();
        roleInTeam = new JComboBox<>();
        position = new JTextField();

        addBtn = new JButton("Add");
        exitBtn = new JButton("Exit");
        customize();
    }
    void customize(){
        panel.setLayout(new GridLayout(2, 6));
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
        for(int i = 0; i < 6; i++) {
            panel.add(new JLabel(Player.header[i]));
        }
        panel.add(name);
        panel.add(date);
        panel.add(teamName);
        panel.add(city);
        panel.add(roleInTeam);
        panel.add(position);
        //panel.add(addBtn);
        //panel.add(exitBtn);
    }

    JPanel getPanel(){
        return panel;
    }

    void display (){
        dialog = new JDialog (parent, "Add new player", true);
        dialog.setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane (getPanel());
        dialog.pack();
        dialog.setLocationRelativeTo (parent);
        dialog.setVisible (true);
    }


}
