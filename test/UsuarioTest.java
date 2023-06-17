import junit.framework.TestCase;

public class UsuarioTest extends TestCase {

    public void testComprarJogo() {

        Usuario u = new Usuario(1, "cleber", "cleber@gmail.com", "123", "123456", "rua udesc, 103");
        Jogo jogo = new Jogo(1, "far cry 4", "jogo de aventura e sobrevivência", 129, 2014, "14 anos", "4GB de RAM");
        boolean primeiraCompra = u.comprarJogo(jogo);
        boolean compraRepetida = u.comprarJogo(jogo);

        assertTrue(primeiraCompra);
        assertFalse(compraRepetida);
    }

    public void testFazerAmizade() {
        Usuario u1 = new Usuario(1, "cleber", "cleber@gmail.com", "123", "123456", "rua udesc, 103");
        Usuario u2 = new Usuario(2, "anderson", "anderson@gmail.com", "123", "765432", "rua antonieta, 56");
    
        boolean pedidoAceito = u1.adicionarAmigo(u2);
        boolean pedidoRepetido = u2.adicionarAmigo(u1);

        assertTrue(u1.getAmigos().contains(u2));
        assertTrue(u2.getAmigos().contains(u1));
        assertTrue(pedidoAceito);
        assertFalse(pedidoRepetido);
    }

    public void testFazerAvaliacao() {
        Jogo game = new Jogo(1, "far cry 4", "jogo de aventura e sobrevivência", 129, 2014, "14 anos", "4GB de RAM");
        Usuario user = new Usuario(1, "cleber", "cleber@gmail.com", "123", "123456", "rua udesc, 103");
        Avaliacao av = new Avaliacao("jogo perfeito, me diverti por horas!", 10, user, game);
    
        boolean avaliacaoCerta = user.fazerAvaliacao(av);
        boolean avaliacaoRepetida = user.fazerAvaliacao(av);

        assertTrue(avaliacaoCerta);
        assertFalse(avaliacaoRepetida);
    }

    public void fazerPost() {
        Grupo grupo = new Grupo("os palhaços da noite", "aqui só entra os joker maluco!");
        Usuario user = new Usuario(1, "cleber", "cleber@gmail.com", "123", "123456", "rua udesc, 103");
        Post post = new Post(1, "Eu amo jogar no PC!", "Jogar no computador me traz uma paz única. s2", grupo);

        user.fazerPost(post);
        assertTrue(user.getPosts().contains(post));
    }
}
