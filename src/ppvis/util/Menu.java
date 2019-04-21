package ppvis.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private Logic logic;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem exit;

    Menu(Logic logic){
        this.logic = logic;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        tuneUp();
    }

    private void tuneUp(){
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //XMLAdapter.open(logic);
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //XMLAdapter.save(logic);

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

    public JMenuBar getJMenuBar(){
        return menuBar;
    }
}
