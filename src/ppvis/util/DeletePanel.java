package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class DeletePanel {

    DeletePanel(Service logic, Table table){
        JFrame frame = new JFrame();

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.addRole(Role.NoMatter);
        inputFields.getActionBtn().setText("Delete player");
        inputFields.getActionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PlayerDTO playerDTO;
                try {
                    playerDTO = new PlayerDTO(inputFields.getName(),
                            inputFields.getDate(),
                            inputFields.getTeamName(),
                            inputFields.getCity(),
                            inputFields.getRoleInTeam(),
                            inputFields.getPosition());

                    logic.delPlayers(logic.search(playerDTO));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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
