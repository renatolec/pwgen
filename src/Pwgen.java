import javax.swing.*;
import java.awt.*;

public class Pwgen extends JFrame {

    PasswordPanel pwpanel;

    {
        pwpanel = new PasswordPanel();
    }

    public Pwgen() throws HeadlessException {
        this("Default");
    }

    public Pwgen(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pwpanel);
        setResizable(false);
        setVisible(true);
        pack();

        // CENTER THE FRAME ON SCREEN
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        double width = gd.getDisplayMode().getWidth();
        double height = gd.getDisplayMode().getHeight();
        setLocation((int) (width/2-pwpanel.getPreferredSize().getWidth()/2), (int) (height/2-pwpanel.getPreferredSize().getHeight()/2));
    }

    public static void main(String[] args) {
        new Pwgen("Password Generator");
    }
}