import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class PasswordPanel extends JPanel implements ChangeListener,
        MouseListener {

    private final JTextField password;
    private final JButton generate;
    private final JSlider length;
    private final JLabel lblength;
    private final JCheckBox uppercase;
    private final JCheckBox numbers;
    private final JCheckBox symbols;

    {
        password = new JTextField();
        generate = new JButton("Generate");
        length = new JSlider(JSlider.HORIZONTAL, 8, 32, 20);
        lblength = new JLabel("Password Length: 0");
        uppercase = new JCheckBox("A-Z");
        numbers = new JCheckBox("0-9");
        symbols = new JCheckBox("!@#");
    }

    public PasswordPanel() {
        setOpaque(true);
        setVisible(true);
        configure();
        length.addChangeListener(this);
        generate.addMouseListener(this);
    }

    private void configure(){
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        password.setHorizontalAlignment(SwingConstants.CENTER);
        password.setColumns(32);
        password.setFont(new Font("SansSerif",Font.PLAIN,16));
        generate.setFocusable(false);
        uppercase.setFocusable(false);
        numbers.setFocusable(false);
        symbols.setFocusable(false);
        length.setMinorTickSpacing(1);
        lblength.setText("Password Length: " + length.getValue());

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(password)
                        .addComponent(length)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblength)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uppercase)
                                .addComponent(numbers)
                                .addComponent(symbols)
                        )
                )
                .addComponent(generate)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(password)
                        .addComponent(generate)
                )
                .addComponent(length)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblength)
                        .addComponent(uppercase)
                        .addComponent(numbers)
                        .addComponent(symbols)
                )
        );

        layout.linkSize(SwingConstants.VERTICAL, password, generate);
        layout.linkSize(SwingConstants.HORIZONTAL, uppercase, numbers, symbols);

        Arrays.stream(this.getComponents()).
                forEach(comp -> comp.setFont(new Font("SansSerif",Font.BOLD,16)));
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == length){
            lblength.setText("Password Length: " + length.getValue());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == generate){
            String s = PasswordGenerator.generate(
                    length.getValue(),
                    uppercase.isSelected(),
                    numbers.isSelected(),
                    symbols.isSelected()
                    );
            password.setText(s);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
