package java.by.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private ViewInfoPerPage logic;

    private JPanel panel;
    private JPanel panelForButtons;

    private JTableModel model;
    private JTable table;
    private JScrollPane scroll;
    private JComboBox<Integer> numberOfPlayerOnScreen;
    private JLabel showPages;

    private JButton firstPage;
    private JButton previousPage;
    private JButton nextPage;
    private JButton lastPage;

    private int[] numbers = {2, 5, 10, 15, 25};


    MainPanel(){
        //String[] numbers = {"2", "5", "10", "25"};
        //int[] number = {2, 5, 10, 15, 25};
        logic = new ViewInfoPerPage();
        panel = new JPanel();
        model = new JTableModel(logic.getInfoOnScreen());
        table = new JTable(model);
        scroll = new JScrollPane(table);
        numberOfPlayerOnScreen = new JComboBox<>();
        showPages = new JLabel();
        panelForButtons = new JPanel();
        firstPage = new JButton("FIRST PAGE");
        previousPage = new JButton("PREVIOUS PAGE");
        nextPage = new JButton("NEXT PAGE");
        lastPage = new JButton("LAST PAGE");
        customize();
    }

    private void customize(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int x : numbers) {
            numberOfPlayerOnScreen.addItem(x);
        }
        numberOfPlayerOnScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setCountOfPlayerOnScreen((Integer) numberOfPlayerOnScreen.getSelectedItem());
                updateLabel();
            }
        });

        panelForButtons.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        firstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setFirstPage();
                updateLabel();
                //table.repaint();
            }
        });

        previousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.decPage();
                updateLabel();
            }
        });

        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.incPage();
                updateLabel();
            }
        });

        lastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setLastPage();
                updateLabel();
            }
        });

        addComponentsToPanels();
    }

    private void updateLabel(){
        showPages.setText("Now " + logic.getPage() + " of " + logic.getPages());
    }

    private void addComponentsToPanels(){
        panel.add(scroll);
        panel.add(panelForButtons);
        panelForButtons.add(firstPage);
        panelForButtons.add(previousPage);
        panelForButtons.add(nextPage);
        panelForButtons.add(lastPage);
    }

    public JPanel getPanel(){
        return panel;
    }
}
