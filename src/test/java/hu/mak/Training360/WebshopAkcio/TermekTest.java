package hu.mak.Training360.WebshopAkcio;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TermekTest {
    @Test
    public void testCreate() {
        Termek termek1 = new Termek("téliszalámi",12000L,false);
        assertThat(termek1.getNev(), equalTo("téliszalámi"));
        assertThat(termek1.getAr(), equalTo(12000L));
        assertThat(termek1.isMegapack(), is(false));
        Termek termek2 = new Termek("uborka",2800L,true);
        assertThat(termek2.getNev(), equalTo("uborka"));
        assertThat(termek2.getAr(), equalTo(2800L));
        assertThat(termek2.isMegapack(), is(true));
    }
}
