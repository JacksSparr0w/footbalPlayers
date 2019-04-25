package ppvis.util;

import javax.swing.*;

public class SearchDialog{
    private Logic logic;
    private Table table;

    SearchDialog(Logic logic, JFrame parent, Table table) {
        //super(logic, parent, table);
        logic = new Logic();
        table = new Table(logic);
    }


    void makeAction() {

    }
}
