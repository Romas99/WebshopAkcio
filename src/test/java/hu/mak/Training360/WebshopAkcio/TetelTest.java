package hu.mak.Training360.WebshopAkcio;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TetelTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreate() {
        Termek termek = new Termek("téliszalámi",12000L,false);
        Tetel tetel = new Tetel(termek.getNev(),termek.getAr(),termek.isMegapack());
        tetel.setDb(5);
        Assert.assertEquals(5,tetel.getDb());
        tetel.setDb(7);
        Assert.assertEquals(12,tetel.getDb());
        tetel.setDb(-6);
        Assert.assertEquals(6,tetel.getDb());

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Nem megengedett darabszám!");
        tetel.setDb(-10);

    }
}
