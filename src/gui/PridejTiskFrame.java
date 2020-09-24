package gui;

import model.Tisk;
import model.Uzivatel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

public class PridejTiskFrame extends JFrame {
    private JTextField tfID;
    private JTextField tfPocetStran;
    private JPanel mainPanel;
    private JLabel lbl1;
    private JButton btnPridejTisk;
    private MainFrame mainFrame;


    public PridejTiskFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initFrame();
        initGui();
        initListeners();
    }

    private void initListeners() {
        btnPridejTisk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Tisk t = null;
                t = new Tisk(
                        null,
                        Integer.parseInt(tfID.getText()),
                        Integer.parseInt(tfPocetStran.getText())
                );

                mainFrame.getStisk().pridejPolozku(t);
                mainFrame.setListTiskarenToModel((mainFrame.getStiskaren()));
            }
        });

    }

    private void initGui() {
        setContentPane(mainPanel);
    }

    private void initFrame() {
        setTitle("Pridat Tisk");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
