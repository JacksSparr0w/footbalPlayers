package java.by.util;

import javax.swing.*;
import java.awt.*;

public class CreateInputFields {

    static JPanel getInputFields(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JTextField("Name"));
        panel.add(new JTextField("Date"));
        panel.add(new JTextField("TeamName"));
        panel.add(new JTextField("City"));
        JComboBox<Role> role = new JComboBox<>();
        role.addItem(Role.Main);
        role.addItem(Role.Reserve);
        role.setSelectedItem(Role.Main);
        panel.add(role);
        panel.add(new JTextField("Position"));
        return panel;
    }
}
