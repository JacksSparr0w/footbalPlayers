package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JFrame frame;
    private Container container;
    private Service logic;

    private JPanel panel;
    private JPanel panelForButtons;

    private Table table;
    private JButton addBtn;
    private JButton searchBtn;
    private JButton deleteBtn;

    public MainPanel(){
        frame = new JFrame();
        container = frame.getContentPane();

        logic = new Service();

        panel = new JPanel();
        table = new Table(logic);
        panelForButtons = new JPanel();

        addBtn = new JButton("Add");
        searchBtn = new JButton("Search");
        deleteBtn = new JButton("Delete");

        tuneUp();
    }

    private void tuneUp(){
        frame.setJMenuBar(new Menu(logic, table.getModel()).getJMenuBar());

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddPanel(logic, table);
                table.getModel().fireTableDataChanged();
                table.updateCounter();
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SearchPanel(logic);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DeletePanel(logic, table);
            }
        });

        panel.add(table.getPanel());
        panel.add(panelForButtons);
        panelForButtons.add(addBtn);
        panelForButtons.add(searchBtn);
        panelForButtons.add(deleteBtn);

        container.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}