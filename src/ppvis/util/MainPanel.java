package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JFrame parent;
    private ViewInfoPerPage logic;

    private JPanel panel;
    private JPanel panelForButtons;

    private JScrollPane scroll;
    private JComboBox<Integer> numberOfPlayerOnScreen;
    private JLabel showPages;

    private JButton firstPage;
    private JButton previousPage;
    private JButton nextPage;
    private JButton lastPage;
    private JButton addBtn;
    private JButton searchBtn;
    private JButton deleteBtn;

    private int[] numbers = {2, 5, 10, 15, 25};


    MainPanel(JFrame parent){
        this.parent = parent;
        logic = new ViewInfoPerPage();
        panel = new JPanel();
        JTableModel model = new JTableModel(logic.getInfoOnScreen());
        JTable table = new JTable(model);
        scroll = new JScrollPane(table);
        numberOfPlayerOnScreen = new JComboBox<>();
        showPages = new JLabel();
        panelForButtons = new JPanel();
        firstPage = new JButton("FIRST PAGE");
        previousPage = new JButton("PREVIOUS PAGE");
        nextPage = new JButton("NEXT PAGE");
        lastPage = new JButton("LAST PAGE");
        addBtn = new JButton("Add");
        searchBtn = new JButton("Search");
        deleteBtn = new JButton("Delete");
        customize();
    }

    private void customize(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        updateLabel();
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

        panelForButtons.setLayout(new FlowLayout());
        firstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setFirstPage();
                updateLabel();
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

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddPanel add = new AddPanel(logic, parent);
                add.display();
            }
        });

        addComponentsToPanels();
    }

    private void updateLabel(){
        showPages.setText("Now " + logic.getPage() + " of " + logic.getPages());
    }

    private void addComponentsToPanels(){
        panel.add(scroll);
        panel.add(showPages);
        panel.add(numberOfPlayerOnScreen);
        panel.add(panelForButtons);
        panelForButtons.add(firstPage);
        panelForButtons.add(previousPage);
        panelForButtons.add(nextPage);
        panelForButtons.add(lastPage);
        panelForButtons.add(addBtn);
    }

    public JPanel getPanel(){
        return panel;
    }
}
