package ppvis.util;

import javax.swing.*;

public class AddPanel extends Panel{

    AddPanel(ViewInfoPerPage logic, JFrame parent){
        super(logic, parent);
    }

    @Override
    void makeAction(ViewInfoPerPage logic) {
        Player p = new Player(name.getText().split(" "), date.getText(), teamName.getText(), city.getText(), (Role) roleInTeam.getSelectedItem(), Integer.parseInt(position.getText()));
        logic.addPlayer(p);
    }
}
