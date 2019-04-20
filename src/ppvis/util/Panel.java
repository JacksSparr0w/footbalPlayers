package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Panel {
    protected JDialog dialog;
    protected JFrame parent;
    protected Logic logic;
    protected JPanel panel;
    protected JTextField name;
    protected DatePicker datePicker;
    protected JTextField date;   //TODO: make date not text
    protected JTextField teamName;
    protected JTextField city;
    protected JComboBox<Role> roleInTeam;
    protected JTextField position;
    protected JButton addBtn;
    protected JButton exitBtn;


    Panel(Logic logic, JFrame parent){
        this.logic = logic;
        this.parent = parent;

        panel = new JPanel();
        name = new JTextField("q w e");
        datePicker = new DatePicker();
        date = new JTextField("123");
        teamName = new JTextField("team");
        city = new JTextField("moscow");
        roleInTeam = new JComboBox<>();
        position = new JTextField("2");

        addBtn = new JButton("Add");
        exitBtn = new JButton("Exit");
        customize();
    }

    void customize(){
        panel.setLayout(new GridLayout(3, 6, 10, 10));
        roleInTeam.addItem(Role.Main);
        roleInTeam.addItem(Role.Reserve);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                makeAction(logic);
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dialog.dispose();
            }
        });

        addComponentsToPanel();
    }

    abstract void makeAction(Logic logic);

    void addComponentsToPanel(){
        for(int i = 0; i < 6; i++) {
            panel.add(new JLabel(Player.header[i]));
        }
        panel.add(name);
        panel.add(datePicker.getDatePicker());
        //panel.add(date);
        panel.add(teamName);
        panel.add(city);
        panel.add(roleInTeam);
        panel.add(position);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(addBtn);
        panel.add(exitBtn);

        display ();
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
