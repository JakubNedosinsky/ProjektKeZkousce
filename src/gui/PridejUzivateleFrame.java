package gui;

import model.Tiskarna;
import model.Uzivatel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PridejUzivateleFrame extends JFrame{
    private JTextField tfJmeno;
    private JTextField tfID;
    private JLabel lbl1;
    private JLabel lbl2;
    private JButton btnPridejUzivatele;
    private JPanel mainPanel;
    private MainFrame mainFrame;


    public PridejUzivateleFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initFrame();
        initGui();
        initListeners();
    }

    private void initListeners() {
        btnPridejUzivatele.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Uzivatel u = null;
                u = new Uzivatel(
                        tfJmeno.getText(),
                        Integer.parseInt(tfID.getText())
                );

                mainFrame.getSuzi().pridejPolozku(u);
                mainFrame.setListUzivatelToModel((mainFrame.getSuzi()));
            }
        });

    }

    private void initGui() {
        setContentPane(mainPanel);
    }

    private void initFrame() {
        setTitle("Pridat Uzivatele");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
