package gui;

import model.Tiskarna;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PridejTiskarnuFrame extends JFrame{
    private JTextField tfCisloTiskarny;
    private JTextField tfNazev;
    private JTextField tfCenaTiskarny;
    private JTextField tfCisloMistnosti;
    private JTextField tfNaklady;
    private JButton btnPridejTiskarnu;
    private JPanel mainPanel;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;
    private MainFrame mainFrame;


    public PridejTiskarnuFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initFrame();
        initGui();
        initListeners();
    }

    private void initListeners() {
        btnPridejTiskarnu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Tiskarna t = null;
                t = new Tiskarna(
                        Integer.parseInt(tfCisloTiskarny.getText()),
                        tfNazev.getText(),
                        Integer.parseInt(tfCenaTiskarny.getText()),
                        Integer.parseInt(tfCisloMistnosti.getText()),
                        Integer.parseInt(tfNaklady.getText())
                );

                mainFrame.getStiskaren().pridejPolozku(t);
                mainFrame.setListTiskarenToModel((mainFrame.getStiskaren()));
            }
        });

    }

    private void initGui() {
        setContentPane(mainPanel);
    }

    private void initFrame() {
        setTitle("Pridat Tiskarnu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
