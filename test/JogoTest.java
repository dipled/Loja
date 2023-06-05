import junit.*;
import junit.framework.TestCase;
public class JogoTest extends TestCase{
    Jogo jogo = new Jogo();
    public void testContemTermo()
    {
        jogo.setTitulo("macarrao com salsicha");
        assertEquals(true, jogo.contemTermo("macarrao"));
        assertEquals(false, jogo.contemTermo("pao com linguica"));
    }
}
