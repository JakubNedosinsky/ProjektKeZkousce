package model;

import java.sql.Date;

public class Tisk {
    private Date datumTisku;
    private int pocetStran;
    private int IdOsoby;

    public Tisk(Date datumTisku, int pocetStran,int idOsoby) {
        this.datumTisku = datumTisku;
        this.pocetStran = pocetStran;
        this.IdOsoby = idOsoby;
    }

    public Date getDatumTisku() {
        return datumTisku;
    }

    public void setDatumTisku(Date datumTisku) {
        this.datumTisku = datumTisku;
    }

    public int getPocetStran() {
        return pocetStran;
    }

    public void setPocetStran(int pocetStran) {
        this.pocetStran = pocetStran;
    }

    public int getIdOsoby() {
        return IdOsoby;
    }

    public void setIdOsoby(int idOsoby) {
        IdOsoby = idOsoby;
    }
}
