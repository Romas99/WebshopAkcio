package hu.mak.Training360.WebshopAkcio;

import java.util.Objects;

public class Termek {
    private String nev;
    private long ar;
    private boolean megapack;

    public Termek(String nev, long ar, boolean megapack) {
        if (nev == null) throw new IllegalArgumentException("A termék nevének megadása kötelező!");
        else if(ar <= 0L) throw new IllegalArgumentException("Rossz a termék árazása!");

        this.nev = nev;
        this.ar = ar;
        this.megapack = megapack;

    }

    public String getNev() {
        return nev;
    }

    public long getAr() {
        return ar;
    }

    public boolean isMegapack() {
        return megapack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Termek)) return false;
        Termek termek = (Termek) o;
        return ar == termek.ar &&
                megapack == termek.megapack &&
                nev.equals(termek.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, ar, megapack);
    }

}