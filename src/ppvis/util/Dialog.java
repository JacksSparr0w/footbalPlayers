package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Dialog {
    private JDialog dialog;
    private JFrame parent;
    //private Logic logic;

    //private Table table;
    private JPanel panel;

    private JTextField name;
    private DatePicker datePicker;
    private JTextField teamName;
    private JTextField city;
    private JComboBox<Role> roleInTeam;
    private JTextField position;

    private JButton actionBtn;
    private JButton exitBtn;


    Dialog(JFrame parent){
        //this.logic = logic;
        this.parent = parent;
        //this.table = table;

        panel = new JPanel();
        name = new JTextField("q w e");
        datePicker = new DatePicker();
        teamName = new JTextField("team");
        city = new JTextField("moscow");
        roleInTeam = new JComboBox<>();
        position = new JTextField("2");
        actionBtn = new JButton();
        exitBtn = new JButton("Exit");
        tuneUp();
    }

    private void tuneUp(){
        panel.setLayout(new GridLayout(7, 2, 15, 15));
        roleInTeam.addItem(Role.Main);
        roleInTeam.addItem(Role.Reserve);

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dialog.dispose();
            }
        });

        addComponentsToPanel();
    }

    private void addComponentsToPanel(){
        Component[] temp = {name, datePicker.getDatePicker(), teamName, city, roleInTeam, position};
        for(int i = 0; i < 6; i++) {
            panel.add(new JLabel(Player.header[i]));
            panel.add(temp[i]);
        }

        panel.add(actionBtn);
        panel.add(exitBtn);

        //display();

    }



    public void display (){
        dialog = new JDialog (parent, "Add new player", true);
        dialog.setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane (getPanel());
        dialog.pack();
        //dialog.setSize(new Dimension(400, 250));
        dialog.setLocationRelativeTo (parent);
        dialog.setVisible (true);
    }

    public JPanel getPanel(){
        return panel;
    }

    public String getName() {
        return name.getText();
    }

    public Date getDate() {
        return datePicker.getDate();
    }

    public String getTeamName() {
        return teamName.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public Role getRoleInTeam() {
        return (Role) roleInTeam.getSelectedItem();
    }

    public int getPosition() {
        return Integer.parseInt(position.getText());
    }

    public JButton getActionBtn() {
        return actionBtn;
    }
}

