package ppvis.util.view;

import ppvis.util.controller.PlayersDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JFrame frame;
    private Container container;
    private PlayersDAO playersDAO;

    private JPanel panel;
    private JPanel panelForButtons;

    private Table table;
    private JButton addBtn;
    private JButton searchBtn;
    private JButton deleteBtn;

    public MainPanel(){
        frame = new JFrame();
        container = frame.getContentPane();

        playersDAO = new PlayersDAO();

        panel = new JPanel();
        table = new Table(playersDAO);
        panelForButtons = new JPanel();

        addBtn = new JButton("Add");
        searchBtn = new JButton("Search");
        deleteBtn = new JButton("Delete");

        tuneUp();
    }

    private void tuneUp(){
        frame.setJMenuBar(new Menu(playersDAO, table).getJMenuBar());

        MainPanel mainPanel = this;
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddPanel(playersDAO, mainPanel);
                table.update();
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SearchPanel(playersDAO);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DeletePanel(playersDAO, mainPanel);
            }
        });

        panel.add(table.getPanel());
        panel.add(panelForButtons);
        panelForButtons.add(addBtn);
        panelForButtons.add(searchBtn);
        panelForButtons.add(deleteBtn);

        container.add(panel);
        frame.setSize(new Dimension(510, 550));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void update(){
        table.update();
    }

}