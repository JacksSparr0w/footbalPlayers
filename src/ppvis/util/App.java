package ppvis.util;

import javax.swing.*;
import java.awt.*;

public class App {
    private JFrame frame;
    private Container container;
    private MainPanel mainPanel;

     public App(){
        frame = new JFrame();
        container = frame.getContentPane();
        mainPanel = new MainPanel(frame);

        customize();
    }

    private void customize(){
        frame.setTitle("Lab2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        container.add(mainPanel.getPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
