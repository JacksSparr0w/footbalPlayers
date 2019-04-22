package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JFrame parent;
    private Logic logic;

    private JPanel panel;
    private JPanel panelForButtons;

    private Menu menu;
    private JScrollPane scroll;
    private JTableModel model;
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
        logic = new Logic();

        panel = new JPanel();
        menu = new Menu(logic);
        model = new JTableModel(logic);
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
        tuneUp();
    }

    private void tuneUp(){
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
                model.fireTableDataChanged();
            }
        });

        panelForButtons.setLayout(new GridLayout(2, 4, 10, 10));

        firstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setFirstPage();
                updateLabel();
                model.fireTableDataChanged();

            }
        });

        previousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.decPage();
                updateLabel();
                model.fireTableDataChanged();

            }
        });

        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.incPage();
                updateLabel();
                model.fireTableDataChanged();

            }
        });

        lastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setLastPage();
                updateLabel();
                model.fireTableDataChanged();

            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddDialog addDialog = new AddDialog(logic, parent);
                addDialog.display();
                updateLabel();
                model.fireTableDataChanged();

            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.fireTableDataChanged();
            }
        });

        addComponentsToPanels();
    }

    private void updateLabel(){
        showPages.setText("Now at " + logic.getPage() + " of " + logic.getPages() + " pages");
    }

    private void addComponentsToPanels(){
        parent.setJMenuBar(menu.getJMenuBar());

        panel.add(scroll);
        panel.add(showPages);
        panel.add(numberOfPlayerOnScreen);
        panel.add(panelForButtons);

        panelForButtons.add(firstPage);
        panelForButtons.add(previousPage);
        panelForButtons.add(nextPage);
        panelForButtons.add(lastPage);
        panelForButtons.add(addBtn);
        panelForButtons.add(searchBtn);
        panelForButtons.add(deleteBtn);
    }

    public JPanel getPanel(){
        return panel;
    }
}
