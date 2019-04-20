package ppvis.util;

import javax.swing.JFrame;

public class AddPanel extends Panel{

    AddPanel(Logic logic, JFrame parent){
        super(logic, parent);
    }

    @Override
    void makeAction(Logic logic) {
        Player p = new Player(name.getText(), date.getText(), teamName.getText(), city.getText(), (Role) roleInTeam.getSelectedItem(), Integer.parseInt(position.getText()));
        logic.addPlayer(p);
    }
}
