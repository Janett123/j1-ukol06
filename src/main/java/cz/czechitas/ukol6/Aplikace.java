package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JTextField husyField;
    private JTextField kraliciField;


    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    private JButton vypocitatButton;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);

        add(createButtonBar(), "center, span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(husyField);
        add(pocetHlavLabel);
        add(pocetHlavField, "right");
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);


        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('N');
        pocetNohouLabel.setLabelFor(husyField);
        add(pocetNohouLabel);
        add(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel();
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent) {

        int cislo1 = Integer.parseInt(husyField.getText());
        int cislo2 = Integer.parseInt(kraliciField.getText());
        int vysledek1 = cislo1 + cislo2;
        String text1 = Integer.toString(vysledek1);
        pocetHlavField.setText(text1);

        int vysledek2 = (cislo1 * 2) + (cislo2 * 4);
        String text2 = Integer.toString(vysledek2);
        pocetNohouField.setText(text2);
    }
}
