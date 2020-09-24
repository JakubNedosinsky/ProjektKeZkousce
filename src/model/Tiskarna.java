package model;

public class Tiskarna {
    private int cisloTiskarny;
    private String nazev;
    private int cenaTiskarny;
    private int cisloMistnosti;
    private int nakladyNaJednuStranku;


    public Tiskarna(int cisloTiskarny, String nazev, int cenaTiskarny, int cisloMistnosti, int nakladyNaJednuStranku) {
        this.cisloTiskarny = cisloTiskarny;
        this.nazev = nazev;
        this.cenaTiskarny = cenaTiskarny;
        this.cisloMistnosti = cisloMistnosti;
        this.nakladyNaJednuStranku = nakladyNaJednuStranku;
    }

    public int getCisloTiskarny() {
        return cisloTiskarny;
    }

    public void setCisloTiskarny(int cisloTiskarny) {
        this.cisloTiskarny = cisloTiskarny;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getCenaTiskarny() {
        return cenaTiskarny;
    }

    public void setCenaTiskarny(int cenaTiskarny) {
        this.cenaTiskarny = cenaTiskarny;
    }

    public int getCisloMistnosti() {
        return cisloMistnosti;
    }

    public void setCisloMistnosti(int cisloMistnosti) {
        this.cisloMistnosti = cisloMistnosti;
    }

    public int getNaklady() {
        return nakladyNaJednuStranku;
    }

    public void setNaklady(int naklady) {
        this.nakladyNaJednuStranku = naklady;
    }
}
