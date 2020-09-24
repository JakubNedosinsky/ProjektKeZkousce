package model;

import java.util.ArrayList;
import java.util.List;

public class SeznamTisku {


    private List<Tisk> sezTisku = new ArrayList<>();

    public List<Tisk> getSeznam() {
        return sezTisku;
    }

    public void pridejPolozku(Tisk t) {
        sezTisku.add(t);
    }

    public Tisk getPolozka(int index) {
        return sezTisku.get(index);
    }

    public int getSize() {
        return sezTisku.size();
    }

    public int vratPocetTisku() {
        return sezTisku.size();
    }

    public void smazTisk(int index) {
        if(index > 0  ) {
            sezTisku.remove(index);
        }
    }

    public void pridejTisk(int ind, Tisk t) {
        sezTisku.add(ind, t);
    }
}
