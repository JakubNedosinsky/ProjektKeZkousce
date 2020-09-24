package model;

import java.util.ArrayList;
import java.util.List;

public class SeznamUzivatelu {

    private List<Uzivatel> sezUzivatelu = new ArrayList<>();

    public List<Uzivatel> getSeznam() {
        return sezUzivatelu;
    }

    public void pridejPolozku(Uzivatel u) {
        sezUzivatelu.add(u);
    }

    public Uzivatel getPolozka(int index) {
        return sezUzivatelu.get(index);
    }

    public int getSize() {
        return sezUzivatelu.size();
    }

    public int vratPocetUzivatelu() {
        return sezUzivatelu.size();
    }

    public void smazUzivatele(int index) {
        if(index > 0  ) {
            sezUzivatelu.remove(index);
        }
    }

    public void pridejUzivatele(int ind, Uzivatel u) {
        sezUzivatelu.add(ind, u);
    }
}
