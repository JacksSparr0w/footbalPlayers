package java.by.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel {
    private JFrame parent;
    private JDialog dialog;
    private Player player;

    AddPanel (JFrame parent){
        this.parent = parent;
    }

    private JPanel createPanel (){
        JPanel panel = CreateInputFields.getInputFields();
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //
            }
        });

        panel.add(addBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //dispose();??
            }
        });

    }
}
