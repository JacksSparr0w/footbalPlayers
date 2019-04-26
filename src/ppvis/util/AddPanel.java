package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class AddPanel {

    AddPanel(Service logic, Table table){
        JFrame frame = new JFrame();

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.getActionBtn().setText("Add new player");
        inputFields.getActionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Player p = null;
                try {
                    p = new Player(inputFields.getName(), inputFields.getDate(), inputFields.getTeamName(),
                            inputFields.getCity(), inputFields.getRoleInTeam(), inputFields.getPosition());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                logic.addPlayer(p);
                table.getModel().fireTableDataChanged();
                table.updateCounter();
            }
        });

        inputFields.getExitBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

        frame.getContentPane().add(inputFields.getPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
