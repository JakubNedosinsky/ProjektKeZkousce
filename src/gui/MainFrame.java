package gui;

import model.*;
import utils.FileUtil;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainFrame extends JFrame {

    private ModelTabulkyTiskarny modelTiskaren = new ModelTabulkyTiskarny();
    private ModelTabulkyTisky modelTisku = new ModelTabulkyTisky();
    private ModelTabulkyUzivatele modelTabulkyUzivatele = new ModelTabulkyUzivatele();
    private JPanel mainPanel;
    private JTable table1;
    private JButton btnPridejTiskarnu;
    private JButton btnPridejUzivatele;
    private JButton btnPridejTisk;
    private JButton btnUloz;
    private JButton btnNacti;
    private JButton btnSmaz;
    private JButton btnDolu;
    private JButton btnNahoru;
    private JButton btnZmenitModel;
    private SeznamUzivatelu suzi = new SeznamUzivatelu();
    private SeznamTiskaren stiskaren = new SeznamTiskaren();
    private SeznamTisku stisk = new SeznamTisku();
    private boolean zmeneno;

    private MainFrame mainFrame = this;

    public SeznamUzivatelu getSuzi() {
        return suzi;
    }

    public SeznamTiskaren getStiskaren() {
        return stiskaren;
    }
    public SeznamTisku getStisk() {
        return stisk;
    }

    public void setListTiskarenToModel(SeznamTiskaren stiskaren) {
        modelTiskaren.setSeznamTiskaren(stiskaren);
    }


    public MainFrame() {
        initFrame();
        initGui();
        initListeners();
    }

    private void initListeners() {
        btnPridejTiskarnu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PridejTiskarnuFrame(mainFrame);
            }
        });
        btnPridejTisk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PridejTiskFrame(mainFrame);
            }
        });
        btnPridejUzivatele.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PridejUzivateleFrame(mainFrame);
            }
        });

        btnUloz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StringBuilder sb = new StringBuilder();
                String pattern = "dd.MM.yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                for (int i = 0; i < stiskaren.vratPocetTiskaren(); i++) {
                    sb.append(stiskaren.getPolozka(i).getCisloTiskarny() + ";");
                    sb.append(stiskaren.getPolozka(i).getNazev() + ";");
                    sb.append(stiskaren.getPolozka(i).getCenaTiskarny() + ";");
                    sb.append(stiskaren.getPolozka(i).getCisloMistnosti() + ";");
                    sb.append(stiskaren.getPolozka(i).getNaklady() + ";");
                    if (i != stiskaren.vratPocetTiskaren() - 1) {
                        sb.append("\n");
                    }
                }
                try {
                    FileUtil.saveData(sb.toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNacti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String data = FileUtil.loadData();
                    String[] polozky = data.split("\n");
                    for (int i = 0; i < polozky.length; i++) {
                        String[] info = polozky[i].split(";");
                        Tiskarna ti = new Tiskarna(
                                Integer.parseInt(info[0]),
                                info[1],
                                Integer.parseInt(info[2]),
                                Integer.parseInt(info[3]),
                                Integer.parseInt(info[4])

                        );
                        stiskaren.pridejPolozku(ti);
                    }
                    //si.seradPodleVyreseni();
                    modelTiskaren.setSeznamTiskaren(stiskaren);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnSmaz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table1.getSelectedRow();
                modelTiskaren.deleteRow(row);

            }
        });

        btnNahoru.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = table1.getSelectedRow();
                    modelTiskaren.posunNahoru(row);
            }
        });

        btnDolu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table1.getSelectedRow();
                modelTiskaren.posunDolu(row);
            }
        });

        btnZmenitModel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    modelTabulkyUzivatele.setSeznamUzivatelu(suzi);
                    table1.setModel(modelTabulkyUzivatele);
//                modelTabulkyUzivatele.setSeznamTiskaren(stiskaren);
//                modelTabulkyUzivatele.setSeznamTisku(stisk);

                    table1.setAutoCreateRowSorter(true);
                    setContentPane(mainPanel);
                    setTitle("Model Uzivatele");




            }
        });
    }

    private void initGui() {
        table1.setModel(modelTiskaren);
        modelTiskaren.setSeznamTiskaren(stiskaren);
        modelTiskaren.setSeznamTisku(stisk);
        modelTiskaren.setSeznamUzivatelu(suzi);
        table1.setAutoCreateRowSorter(true);
        setContentPane(mainPanel);
    }

    private void initFrame() {
        setTitle("Tiskove ulohy");
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setListUzivatelToModel(SeznamUzivatelu sez) {
        modelTabulkyUzivatele.setSeznamUzivatelu(sez);
    }
}
