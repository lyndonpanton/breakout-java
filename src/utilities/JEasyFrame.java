package utilities;

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.BorderLayout;

public class JEasyFrame extends JFrame {
    public Component component;

    public JEasyFrame(Component component, String title) {
        super(title);
        this.component = component;
        getContentPane().add(BorderLayout.CENTER, component);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
    }
}
