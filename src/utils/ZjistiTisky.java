package utils;

import model.SeznamTisku;
import model.Tisk;

public class ZjistiTisky {
    public static int vypoctiTisky(SeznamTisku seznamTisku) {
        int celkovaCena = 0;

        for (Tisk t : seznamTisku.getSeznam()) {

            int strany = t.getPocetStran();
            //prozatim 10, později provázat s tiskarnami
            int cenaZaStranku = 10;

        }
            return celkovaCena;

    }
}
