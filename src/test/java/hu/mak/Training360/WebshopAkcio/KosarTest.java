package hu.mak.Training360.WebshopAkcio;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class KosarTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testVasarlas() {

        Kosar kosar = new Kosar();

        kosar.addItem(new Termek("téliszalámi",12000L,false), 2);
        Assert.assertEquals(2,kosar.getItem(kosar.getLastTetelIndex()).getDb());
        Assert.assertEquals(24000L, (long) kosar.getKosarEredetiAr());
        Assert.assertEquals(0L, (long) kosar.getKosarKedvezmeny());

        kosar.addItem(new Termek("gumikacsa",3000L,false), 10);
        Assert.assertEquals(10,kosar.getItem(kosar.getLastTetelIndex()).getDb());
        Assert.assertEquals(54000L, (long) kosar.getKosarEredetiAr());
        Assert.assertEquals(9000L, (long) kosar.getKosarKedvezmeny());
        Assert.assertEquals("2=3 akció", kosar.getKosarAkcio().getAkcioNev());

        kosar.addItem(new Termek("uborka",2800L,true), 20);
        Assert.assertEquals(20,kosar.getItem(kosar.getLastTetelIndex()).getDb());
        Assert.assertEquals(54000L, (long) kosar.getKosarEredetiAr());
        Assert.assertEquals(9000L, (long) kosar.getKosarKedvezmeny());
        Assert.assertEquals("2=3 akció", kosar.getKosarAkcio().getAkcioNev());

        kosar.addItem(new Termek("gesztenye",1000L,true), 25);
        Assert.assertEquals(25,kosar.getItem(kosar.getLastTetelIndex()).getDb());
        Assert.assertEquals(81000L, (long) kosar.getKosarEredetiAr());
        Assert.assertEquals(18000L, (long) kosar.getKosarKedvezmeny());
        Assert.assertEquals("Megapack akció", kosar.getKosarAkcio().getAkcioNev());

        kosar.addItem(new Termek("gesztenye",1000L,true), -15);
        Assert.assertEquals(10,kosar.getItem(kosar.getLastTetelIndex()).getDb());
        Assert.assertEquals(54000L, (long) kosar.getKosarEredetiAr());
        Assert.assertEquals(9000L, (long) kosar.getKosarKedvezmeny());
        Assert.assertEquals("2=3 akció", kosar.getKosarAkcio().getAkcioNev());

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Nem megengedett darabszám!");
        kosar.addItem(new Termek("gesztenye",1000L,true), -12);
    }
}
