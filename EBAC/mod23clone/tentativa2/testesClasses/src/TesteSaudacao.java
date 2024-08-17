import org.junit.Test;
import org.junit.Assert;

public class TesteSaudacao {

    @Test
    public void testar() {
        Main main = new Main();
        Assert.assertEquals("Hello World:", main.saudacao());
    }
}
