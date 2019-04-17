package java.by.util;

import javax.swing.*;
import java.awt.*;

public class App {
    private JFrame frame;
    private Container container;
    private MainPanel mainPanel;

    App(){
        frame = new JFrame();
        container = frame.getContentPane();
        mainPanel = new MainPanel();

        customize();
    }

    private void customize(){
        frame.setTitle("Lab2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(mainPanel.getPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
