package hu.mak.Training360.WebshopAkcio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kosar {

    private int lastTetelIndex = -1;
    private int maxAkcioIndex = -1;

    private long[] kosarKedv = new long[Akcio.getMaxIndex()+1];
    private long[] kosarEredetiAr = new long[Akcio.getMaxIndex()+1];

    List<Tetel> kosar = new ArrayList<>();

    public Kosar() {
        Arrays.fill(kosarKedv, 0L);
        Arrays.fill(kosarEredetiAr, 0L);
    }

    public Tetel getItem(int index) {
        return kosar.get(index);
    }

    public void addItem(Termek termek, int db) {
        Tetel aktTetel = new Tetel(termek.getNev(), termek.getAr(), termek.isMegapack());
        int ii = kosar.indexOf(aktTetel);
        if(ii == -1) {
            kosar.add(aktTetel);
            ii = kosar.indexOf(aktTetel);
        }
        else {
            kosarKedv[kosar.get(ii).getAkcioIndex()] -= kosar.get(ii).getKedvezmeny();
            kosarEredetiAr[kosar.get(ii).getAkcioIndex()] -= kosar.get(ii).getEredetiAr();

        }
        kosar.get(ii).setDb(db);
        kosar.get(ii).arSzamitas();
        kosarKedv[kosar.get(ii).getAkcioIndex()] += kosar.get(ii).getKedvezmeny();
        kosarEredetiAr[kosar.get(ii).getAkcioIndex()] += kosar.get(ii).getEredetiAr();
        this.lastTetelIndex = ii;

        long maxx = kosarKedv[0];
        maxAkcioIndex = 0;
        for (int i = 0; i < kosarKedv.length; i++) {
            if (maxx < kosarKedv[i]) {
                maxx = kosarKedv[i];
                maxAkcioIndex = i;
            }
        }
    }

    public int getLastTetelIndex() {
        return this.lastTetelIndex;
    }

    public Long getKosarEredetiAr() {
        return kosarEredetiAr[maxAkcioIndex];
    }

    public Long getKosarKedvezmeny() {
        return kosarKedv[maxAkcioIndex];
    }

    public Akcio getKosarAkcio() {
        return Akcio.values()[maxAkcioIndex];
    }

}
