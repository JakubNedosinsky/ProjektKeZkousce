package gui;

import model.*;

import javax.swing.table.AbstractTableModel;

public class ModelTabulkyUzivatele extends AbstractTableModel {

    private  SeznamUzivatelu suzi;



    public void setSeznamUzivatelu(SeznamUzivatelu suzi) {
        this.suzi = suzi;
        fireTableDataChanged();
    }

    public void deleteRow(int rowIndex) {
        suzi.smazUzivatele(rowIndex);
        fireTableDataChanged();
    }

    public void posunNahoru(int index) {
        if (index != 0) {
            Uzivatel pom = suzi.getPolozka(index);
            suzi.smazUzivatele(index);
            suzi.pridejUzivatele(index - 1, pom);
            fireTableDataChanged();
        }
    }

    public void posunDolu(int index) {
        if (index != suzi.vratPocetUzivatelu() - 1) {
            Uzivatel pom = suzi.getPolozka(index + 1);
            suzi.smazUzivatele(index + 1);
            suzi.pridejUzivatele(index , pom);
            fireTableDataChanged();
        }
    }


    @Override
    public int getRowCount() {
        return suzi.getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        //Tisk t = stisk.getPolozka(i);
        Uzivatel uzivatel = suzi.getPolozka(i);
        //Uzivatel u = suzi.getPolozka(i);

        switch (i1) {
            case 0:
                        return uzivatel.getIdOsoby();
            case 1:
                        return uzivatel.getJmeno();
            default:
                return "";

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Osoby";
            case 1:
                return "Jmeno";
            default:
                return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            default:
                return null;

        }
    }
}
