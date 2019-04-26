package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePanel {

    DeletePanel(Service logic, Table table){
        JFrame frame = new JFrame();

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.getActionBtn().setText("Add new player");
        inputFields.getActionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*Player p = new Player(inputFields.getName(), inputFields.getDate(), inputFields.getTeamName(),
                        inputFields.getCity(), inputFields.getRoleInTeam(), inputFields.getPosition());
                logic.addPlayer(p);*/
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
