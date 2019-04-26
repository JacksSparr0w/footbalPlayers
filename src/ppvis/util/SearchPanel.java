package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class SearchPanel {
    private Table table;
    private Service localService;

    SearchPanel(Service mainService){
        JFrame frame = new JFrame();
        localService = new Service();
        table = new Table(localService);

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.addRole(Role.NoMatter);
        inputFields.getActionBtn().setText("Search players");
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

                    localService.setInfo(mainService.search(playerDTO));
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

        JPanel panel = new JPanel();
        panel.add(inputFields.getPanel());
        panel.add(table.getPanel());

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
