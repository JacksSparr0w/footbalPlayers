package ppvis.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {
    private Logic logic;

    private JPanel panel;
    private JScrollPane scroll;
    private JTableModel model;
    private JTable table;

    private JPanel panelForButtons;
    private JButton firstPage;
    private JButton previousPage;
    private JButton nextPage;
    private JButton lastPage;

    private JLabel counter;
    private JComboBox<Integer> numberOfPlayerOnScreen;

    Table(Logic logic){
        this.logic = logic;
        panel = new JPanel();

        model = new JTableModel(logic);
        table = new JTable(model);
        scroll = new JScrollPane(table);
        numberOfPlayerOnScreen = new JComboBox<>();
        counter = new JLabel();

        panelForButtons = new JPanel();

        firstPage = new JButton("FIRST PAGE");
        previousPage = new JButton("<");
        nextPage = new JButton(">");
        lastPage = new JButton("LAST PAGE");

        counter = new JLabel();

        tuneUp();
    }

    private void tuneUp(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.black));
        panel.setBounds(15,15, 15, 15);

        int[] numbers = {2, 5, 10, 15, 25};
        for (int x : numbers) {
            numberOfPlayerOnScreen.addItem(x);
        }
        updateCounter();
        numberOfPlayerOnScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setCountOfPlayerOnScreen((Integer) numberOfPlayerOnScreen.getSelectedItem());
                updateCounter();
                model.fireTableDataChanged();
            }
        });

        panelForButtons.setLayout(new GridLayout(1, 4, 10, 10));

        firstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setFirstPage();
                updateCounter();
                model.fireTableDataChanged();

            }
        });

        previousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.decPage();
                updateCounter();
                model.fireTableDataChanged();

            }
        });

        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.incPage();
                updateCounter();
                model.fireTableDataChanged();

            }
        });

        lastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setLastPage();
                updateCounter();
                model.fireTableDataChanged();

            }
        });

        addComponentsToPanels();
    }

    public void updateCounter(){
        counter.setText("Now at " + logic.getPage() + " of " + logic.getPages() + " pages");
    }

    private void addComponentsToPanels(){

        panel.add(scroll);
        panel.add(counter);
        panel.add(numberOfPlayerOnScreen);
        panel.add(panelForButtons);

        panelForButtons.add(firstPage);
        panelForButtons.add(previousPage);
        panelForButtons.add(nextPage);
        panelForButtons.add(lastPage);

    }

    public JTableModel getModel() {
        return model;
    }

    public JPanel getPanel(){
        return panel;
    }

}
