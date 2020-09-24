package gui;

import model.*;

import javax.swing.table.AbstractTableModel;

public class ModelTabulkyTisky extends AbstractTableModel {


    private  SeznamTisku stisk;


    public void setSeznamTisku(SeznamTisku stisk) {
        this.stisk = stisk;
        fireTableDataChanged();
    }

    public void deleteRow(int rowIndex) {
        stisk.smazTisk(rowIndex);
        fireTableDataChanged();
    }

    public void posunNahoru(int index) {
        if (index != 0) {
            Tisk pom = stisk.getPolozka(index);
            stisk.smazTisk(index);
            stisk.pridejTisk(index - 1, pom);
            fireTableDataChanged();
        }
    }

    public void posunDolu(int index) {
        if (index != stisk.vratPocetTisku() - 1) {
            Tisk pom = stisk.getPolozka(index + 1);
            stisk.smazTisk(index + 1);
            stisk.pridejTisk(index , pom);
            fireTableDataChanged();
        }
    }


    @Override
    public int getRowCount() {
        return stisk.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Tisk t = stisk.getPolozka(i);

        switch (i1) {
                    case 0:
                        return t.getDatumTisku();
                    case 1:
                        return t.getPocetStran();
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
            default:
                return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            default:
                return null;

        }
    }
}
