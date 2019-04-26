package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel {
    private Table table;
    private Service service;

    SearchPanel(Service logic){
        JFrame frame = new JFrame();
        service = new Service();
        table = new Table(service);

        InputFieldsPanel inputFields = new InputFieldsPanel();
        inputFields.getActionBtn().setText("Search players");
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

        JPanel panel = new JPanel();
        panel.add(inputFields.getPanel());
        panel.add(table.getPanel());

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
