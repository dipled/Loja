import junit.framework.TestCase;

public class JogoTest extends TestCase{
    public void testFazerAvaliacao()
    {
        Jogo game = new Jogo(1, "far cry 4", "jogo de aventura e sobrevivência", 129, 2014, "14 anos", "4GB de RAM");
        Usuario user = new Usuario(1, "cleber", "cleber@gmail.com", "123", "123456", "rua udesc, 103");
        Avaliacao av = new Avaliacao("jogo perfeito, me diverti por horas!", 10, user, game);
    
        boolean avaliacaoCerta = game.fazerAvaliacao(av);
        boolean avaliacaoRepetida = game.fazerAvaliacao(av);
        assertTrue(game.getAvaliacoes().contains(av));
        assertTrue(avaliacaoCerta);
        assertFalse(avaliacaoRepetida);
    }

    public void testCalculaMediaAvaliacoes()
    {
        Jogo game = new Jogo(1, "far cry 4", "jogo de aventura e sobrevivência", 129, 2014, "14 anos", "4GB de RAM");
        Usuario user1 = new Usuario(1, "cleber", "cleber@gmail.com", "123", "123456", "rua udesc, 103");
        Usuario user2 = new Usuario(2, "silva", "silva@gmail.com", "123", "123456", "rua udesc, 103");
        Usuario user3 = new Usuario(3, "robson", "robson@gmail.com", "123", "123456", "rua udesc, 103");
        Avaliacao av1 = new Avaliacao("jogo perfeito, me diverti por horas!", 10, user1, game);
        Avaliacao av2 = new Avaliacao("jogo mais ou menos",5, user2, game);
        Avaliacao av3 = new Avaliacao("jogo lixo, me diverti por horas!", 0, user3, game);
        game.fazerAvaliacao(av1);
        game.fazerAvaliacao(av2);
        game.fazerAvaliacao(av3);
        assertEquals(5,game.calculaMediaAvaliacoes(),0.001);
    }
    
    
}
