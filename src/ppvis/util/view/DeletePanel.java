package ppvis.util.view;

import ppvis.util.controller.PlayersDAO;
import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;
import ppvis.util.model.Role;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class DeletePanel {

    DeletePanel(PlayersDAO playersDAO, MainPanel mainPanel){
        JFrame frame = new JFrame();

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.addRole(Role.NoMatter);
        inputFields.getActionBtn().setText("Delete player");
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

                    List<Player> find = playersDAO.search(playerDTO);
                    showDialog(find.size());
                    playersDAO.delPlayers(find);
                    mainPanel.update();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                mainPanel.update();
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

    private void showDialog(int size){
        String s;
        if (size == 0){
            s = "Не найдено записей удовлетворяющих условию";
        }
        else
            s = "Было удалено " + size + " записей";

        JOptionPane.showMessageDialog(new JDialog(), s);
    }

}
