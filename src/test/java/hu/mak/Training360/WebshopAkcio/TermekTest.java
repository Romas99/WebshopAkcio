package hu.mak.Training360.WebshopAkcio;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TermekTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreate1() {
        Termek termek1 = new Termek("téliszalámi",12000L,false);
        Assert.assertEquals("téliszalámi",termek1.getNev());
        Assert.assertEquals(12000L,termek1.getAr());
        Assert.assertFalse(termek1.isMegapack());

        Termek termek2 = new Termek("uborka",2800L,true);
        Assert.assertEquals("uborka",termek2.getNev());
        Assert.assertEquals(2800L,termek2.getAr());
        Assert.assertTrue(termek2.isMegapack());

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Rossz a termék árazása!");
        //exception.expectMessage("A termék nevének megadása kötelező!");
        Termek termek3 = new Termek("uborka",0L,true);

    }

    @Test
    public void testCreate2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("A termék nevének megadása kötelező!");
        Termek termek = new Termek(null,2800L,true);

    }
}
