package gui;

import model.*;

import javax.swing.table.AbstractTableModel;

public class ModelTabulkyTiskarny extends AbstractTableModel {

    private  SeznamTiskaren stiskaren;
    private  SeznamTisku stisk;
    private  SeznamUzivatelu suzi;

    public void setSeznamTiskaren(SeznamTiskaren stiskaren) {
        this.stiskaren = stiskaren;
        fireTableDataChanged();
    }

    public void setSeznamTisku(SeznamTisku stisk) {
        this.stisk = stisk;
        fireTableDataChanged();
    }

    public void setSeznamUzivatelu(SeznamUzivatelu suzi) {
        this.suzi = suzi;
        fireTableDataChanged();
    }

    public void deleteRow(int rowIndex) {
        stiskaren.smazTiskarnu(rowIndex);
        fireTableDataChanged();
    }

    public void posunNahoru(int index) {
        if (index != 0) {
            Tiskarna pom = stiskaren.getPolozka(index);
            stiskaren.smazTiskarnu(index);
            stiskaren.pridejTiskarnu(index - 1, pom);
            fireTableDataChanged();
        }
    }

    public void posunDolu(int index) {
        if (index != stiskaren.vratPocetTiskaren() - 1) {
            Tiskarna pom = stiskaren.getPolozka(index + 1);
            stiskaren.smazTiskarnu(index + 1);
            stiskaren.pridejTiskarnu(index , pom);
            fireTableDataChanged();
        }
    }


    @Override
    public int getRowCount() {
        return stiskaren.getSize()+stisk.getSize()+suzi.getSize();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        //Tisk t = stisk.getPolozka(i);
        Tiskarna tiskarna =stiskaren.getPolozka(i);
        //Uzivatel u = suzi.getPolozka(i);

                switch (i1) {
//                    case 0:
//                        return t.getDatumTisku();
//                    case 1:
//                        return t.getPocetStran();
                    case 2:
                        return tiskarna.getCenaTiskarny();
                    case 3:
                        return tiskarna.getCisloMistnosti();
                    case 4:
                        return tiskarna.getCisloTiskarny();
                    case 5:
                        return tiskarna.getNaklady();
                    case 6:
                        return tiskarna.getNazev();
                    case 7:
//                        return u.getIdOsoby();
//                    case 8:
//                        return u.getJmeno();
                    default:
                        return "";

            }
            }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Datum Tisku";
            case 1:
                return "Pocet stran";
            case 2:
                return "Cena Tiskarny";
            case 3:
                return "Cislo Mistnosti";
            case 4:
                return "Cislo Tiskarny";
            case 5:
                return "Naklady";
            case 6:
                return "Nazev";
            case 7:
                return "ID Osoby";
            case 8:
                return "Jmeno";
            default:
                return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
                return Integer.class;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return String.class;
            case 7:
                return Integer.class;
            case 8:
                return String.class;
            default:
                return null;

        }
    }
}
