package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog {
    private JDialog dialog;
    private JFrame parent;
    private Logic logic;
    private JPanel panel;
    private JTextField name;
    private DatePicker datePicker;
    private JTextField teamName;
    private JTextField city;
    private JComboBox<Role> roleInTeam;
    private JTextField position;
    private JButton addBtn;
    private JButton exitBtn;


    AddDialog(Logic logic, JFrame parent){
        this.logic = logic;
        this.parent = parent;

        panel = new JPanel();
        name = new JTextField("q w e");
        datePicker = new DatePicker();
        teamName = new JTextField("team");
        city = new JTextField("moscow");
        roleInTeam = new JComboBox<>();
        position = new JTextField("2");

        addBtn = new JButton("Add");
        exitBtn = new JButton("Exit");
        customize();
    }

    private void customize(){
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

    private void makeAction(Logic logic){
        Player p = new Player(name.getText(), datePicker.getDate(), teamName.getText(), city.getText(), (Role) roleInTeam.getSelectedItem(), Integer.parseInt(position.getText()));
        logic.addPlayer(p);
    }

    private void addComponentsToPanel(){
        for(int i = 0; i < 6; i++) {
            panel.add(new JLabel(Player.header[i]));
        }
        panel.add(name);
        panel.add(datePicker.getDatePicker());
        panel.add(teamName);
        panel.add(city);
        panel.add(roleInTeam);
        panel.add(position);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(addBtn);
        panel.add(exitBtn);

    }

    public JPanel getPanel(){
        return panel;
    }

    public void display (){
        dialog = new JDialog (parent, "Add new player", true);
        dialog.setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane (getPanel());
        dialog.pack();
        dialog.setLocationRelativeTo (parent);
        dialog.setVisible (true);
    }


}
