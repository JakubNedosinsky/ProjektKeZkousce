package model;

public class Uzivatel {

    private String jmeno;
    private int idOsoby;

    public Uzivatel(String jmeno, int idOsoby) {
        this.jmeno = jmeno;
        this.idOsoby = idOsoby;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(int idOsoby) {
        this.idOsoby = idOsoby;
    }
}
