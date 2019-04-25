package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog {

    private Dialog inputFields;

    AddDialog(Logic logic, JFrame parent, Table table){
        inputFields = new Dialog(parent);
        inputFields.getActionBtn().setText("Add new player");
        inputFields.getActionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Player p = new Player(inputFields.getName(), inputFields.getDate(), inputFields.getTeamName(),
                        inputFields.getCity(), inputFields.getRoleInTeam(), inputFields.getPosition());
                logic.addPlayer(p);
                table.getModel().fireTableDataChanged();
                table.updateCounter();
            }
        });

        inputFields.display();
    }




}
