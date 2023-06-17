import junit.framework.TestCase;

public class DesenvolvedorTest extends TestCase {

    public void testPublicarJogo()
    {
        Jogo jogo = new Jogo(1, "far cry 4", "jogo de aventura e sobrevivência", 129, 2014, "14 anos", "4GB de RAM");
        Desenvolvedor dev = new Desenvolvedor("Valve","1234","rua pereira", "1233");

    }
}
