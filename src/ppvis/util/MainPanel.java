package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JFrame parent;
    private Logic logic;

    private JPanel panel;
    private JPanel panelForButtons;

    private Menu menu;

    private Table table;
    private JButton addBtn;
    private JButton searchBtn;
    private JButton deleteBtn;

    MainPanel(JFrame parent){
        this.parent = parent;
        logic = new Logic();

        panel = new JPanel();

        table = new Table(logic);
        menu = new Menu(logic, table.getModel());
        panelForButtons = new JPanel();

        addBtn = new JButton("Add");
        searchBtn = new JButton("Search");
        deleteBtn = new JButton("Delete");

        tuneUp();
    }

    private void tuneUp(){

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddDialog(logic, parent, table);
                table.getModel().fireTableDataChanged();
                //addDialog.display();
                table.updateCounter();

            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //searchDialog
            }
        });

        addComponentsToPanels();
    }

    private void addComponentsToPanels(){
        parent.setJMenuBar(menu.getJMenuBar());

        panel.add(table.getPanel());
        panel.add(panelForButtons);
        panelForButtons.add(addBtn);
        panelForButtons.add(searchBtn);
        panelForButtons.add(deleteBtn);
    }

    public JPanel getPanel(){
        return panel;
    }
}