package ppvis.util.view;

import ppvis.util.controller.PlayersDAO;
import ppvis.util.controller.XMLAdapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu {
    private PlayersDAO playersDAO;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem exit;

    Menu(PlayersDAO playersDAO, Table table){
        this.playersDAO = playersDAO;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        tuneUp(table);
    }

    private void tuneUp(Table table){
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File file = getChosenFile("Открыть файл");
                if (file != null) {
                    XMLAdapter.open(playersDAO, file);
                    table.update();
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                XMLAdapter.save(playersDAO, getChosenFile("Сохранить файл"));

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        menu.add(open);
        menu.add(save);
        menu.addSeparator();
        menu.add(exit);
        menuBar.add(menu);
    }

    private File getChosenFile(String att){
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, att
        );
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            return file;
        }
        return null;
    }
    public JMenuBar getJMenuBar(){
        return menuBar;
    }
}
