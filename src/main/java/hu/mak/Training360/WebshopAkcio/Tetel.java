package hu.mak.Training360.WebshopAkcio;

import java.util.Objects;

public class Tetel extends Termek {

    private int db = 0;
    private Long eredetiAr;
    private Long kedvezmeny;
    private Akcio akcio;

    public Tetel(String nev, long ar, boolean megapack) {

        super(nev, ar, megapack);

        if (megapack) this.akcio = Akcio.A_MEGA;
        else this.akcio = Akcio.A_23;
    }

    public void arSzamitas() {
        this.eredetiAr = this.getAr() * this.db;
        if (db < akcio.getAkcioDb()) this.kedvezmeny = 0L;  // Nincs kedvezmény
        else {
            if (akcio.getAkcioTipus() == "MEGA") this.kedvezmeny = akcio.getAkcioFixKedv() * (db / akcio.getAkcioDb());
            else this.kedvezmeny = this.getAr() * (db / akcio.getAkcioDb());
        }
    }

    public int getDb() {
        return db;
    }

    public Long getEredetiAr() {
        return eredetiAr;
    }

    public Long getKedvezmeny() {
        return kedvezmeny;
    }

    public void setDb(int db) {
        if (this.db + db >= 0) this.db += db;
        else throw new IllegalArgumentException("Nem megengedett darabszám!");
    }

    public String toStringAkcio() {
        return akcio.toString();
    }

    public int getAkcioIndex() {
        return akcio.ordinal();
    }

    @Override
    public String toString() {
        return "Tetel{" +
                "név=" + this.getNev() +
                ", ára=" + this.getAr() +
                ", db=" + db +
                ", eredeti tétel ára=" + eredetiAr +
                ", kedvezmény=" + kedvezmeny +
                ", kedvezmény megnevezése='" + akcio.getAkcioNev() + '\'' +
                '}';
    }
}