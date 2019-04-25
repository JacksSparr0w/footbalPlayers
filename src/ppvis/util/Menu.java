package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu {
    private Logic logic;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem exit;

    Menu(Logic logic, JTableModel model){
        this.logic = logic;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        tuneUp(model);
    }

    private void tuneUp(JTableModel model){
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                XMLAdapter.open(logic, getChosenFile("Открыть файл"));
                model.fireTableDataChanged();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                XMLAdapter.save(logic.getInfo(), getChosenFile("Сохранить файл"));

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
