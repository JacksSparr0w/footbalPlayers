package ppvis.util.view;

import ppvis.util.controller.PlayersDAO;
import ppvis.util.model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class AddPanel {

    AddPanel(PlayersDAO playersDAO, MainPanel mainPanel){
        JFrame frame = new JFrame();

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.getActionBtn().setText("Add new player");
        inputFields.getActionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Player p = new Player(inputFields.getName(), inputFields.getDate(), inputFields.getTeamName(),
                            inputFields.getCity(), inputFields.getRoleInTeam(), inputFields.getPosition());
                    playersDAO.addPlayer(p);
                    mainPanel.update();
                } catch (ParseException e) {
                    e.printStackTrace();
                }


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
