import org.junit.Test;
import org.junit.Assert;


public class TesteSaudacao2 {

    @Test
    public void testar2() {
        Main main = new Main();
        Assert.assertEquals("Hello World: Me livrei da maldicão",main.saudacao2());
    }
}
