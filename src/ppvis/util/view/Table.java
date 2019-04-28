package ppvis.util.view;

import ppvis.util.controller.PlayersDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {
    private PlayersDAO playersDAO;

    private PlayersDAO playersOnScreen;
    private int countOfPlayersOnScreen;
    private int currentPage;
    private int pages;


    private JPanel panel;
    private JScrollPane scroll;
    private JTableModel model;

    private JPanel panelForButtons;
    private JButton firstPage;
    private JButton previousPage;
    private JButton nextPage;
    private JButton lastPage;

    private JLabel counter;
    private JComboBox<Integer> numberOfPlayerOnScreen;

    Table(PlayersDAO playersDAO){
        this.playersDAO = playersDAO;
        playersOnScreen = new PlayersDAO();
        panel = new JPanel();

        model = new JTableModel(playersDAO.getPlayers());
        JTable table = new JTable(model);
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
        countOfPlayersOnScreen = numberOfPlayerOnScreen.getItemAt(0);
        update();
        numberOfPlayerOnScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                countOfPlayersOnScreen = (int) numberOfPlayerOnScreen.getSelectedItem();
                update();
            }
        });

        panelForButtons.setLayout(new GridLayout(1, 4, 10, 10));

        firstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setFirstPage();

            }
        });

        previousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                decPage();
            }
        });

        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                incPage();
            }
        });

        lastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setLastPage();
            }
        });

        addComponentsToPanels();
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

    void update(){
        updatePages();
        updateInfoOnScreen();
        model.fireTableDataChanged();
        counter.setText("In common: " + playersDAO.getSize() + " \t\tNow at " +
                currentPage + " of " + pages + " pages");
    }

    private void updatePages(){
        int temp = playersDAO.getSize() / countOfPlayersOnScreen;
        if (playersDAO.getSize() % countOfPlayersOnScreen == 0)
            pages = temp;
        else
            pages = ++temp;

        if (pages == 0)
            pages++;
    }

    private void updateInfoOnScreen(){
        int start = (currentPage - 1)*countOfPlayersOnScreen;
        int finish;
        if (playersDAO.getSize() >= currentPage*countOfPlayersOnScreen){
            finish = currentPage*countOfPlayersOnScreen;
        } else {
            finish = playersDAO.getSize();
        }
        playersOnScreen.clear();
        for (int i = start; i < finish; i++)
            playersOnScreen.addPlayer(playersDAO.getPlayer(i));
    }

    private void incPage(){
        if (currentPage < pages)
            currentPage++;
        update();
    }

    private void decPage(){
        if (currentPage > 1)
            currentPage--;
        update();
    }

    private void setLastPage(){
        currentPage = pages;
        update();
    }

    private void setFirstPage(){
        currentPage = 1;
        update();
    }

    public JTableModel getModel() {
        return model;
    }

    JPanel getPanel(){
        return panel;
    }

}
