package model;

import java.util.ArrayList;
import java.util.List;

public class SeznamTiskaren {

    private List<Tiskarna> sezTiskaren = new ArrayList<>();

    public List<Tiskarna> getSeznam() {
        return sezTiskaren;
    }

    public void pridejPolozku(Tiskarna tiskarna) {
        sezTiskaren.add(tiskarna);
    }

    public Tiskarna getPolozka(int index) {
        if(index >= 0) {
            return sezTiskaren.get(index);
        }
        else return null;
    }

    public int getSize() {
        return sezTiskaren.size();
    }


    public int vratPocetTiskaren() {
        return sezTiskaren.size();
    }

    public void smazTiskarnu(int index) {
        if(index >= 0  ) {
            sezTiskaren.remove(index);
        }
    }

    public void pridejTiskarnu(int ind, Tiskarna t) {
        if(ind  >= 0) {
            sezTiskaren.add(ind, t);
        }
    }

}
