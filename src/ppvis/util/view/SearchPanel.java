package ppvis.util.view;

import ppvis.util.controller.PlayersDAO;
import ppvis.util.model.PlayerDTO;
import ppvis.util.model.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class SearchPanel {
    private Table table;
    private PlayersDAO searchPlayersDAO;

    SearchPanel(PlayersDAO playersDAO){
        JFrame frame = new JFrame();
        searchPlayersDAO = new PlayersDAO();
        table = new Table(searchPlayersDAO);

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.addRole(Role.NoMatter);
        inputFields.getActionBtn().setText("Search players");
        inputFields.getActionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PlayerDTO playerDTO;
                try {
                    playerDTO = new PlayerDTO(inputFields.getFirstName(),
                            inputFields.getDate(),
                            inputFields.getTeamName(),
                            inputFields.getCity(),
                            inputFields.getRoleInTeam(),
                            inputFields.getPosition());

                    searchPlayersDAO.setInfo(playersDAO.search(playerDTO));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                table.update();
            }
        });

        inputFields.getExitBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(inputFields.getPanel());
        panel.add(table.getPanel());

        frame.getContentPane().add(panel);
        frame.setSize(new Dimension(500, 900));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
