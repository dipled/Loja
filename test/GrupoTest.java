import org.junit.Test;

import junit.framework.TestCase;

public class GrupoTest extends TestCase {

    @Test
    public void testAdicionarUsuario() {
        Grupo grupo = new Grupo("Doidos", "Chino, Dip, Fefe");
        Usuario dip = new Usuario("Dip", "pe@gmail", "123", "999", "Rua La Ele Da Silva");
        grupo.adicionarUsuario(dip);
        assertTrue(grupo.getParticipantes().contains(dip));
        boolean repetido = grupo.adicionarUsuario(dip);
        assertFalse(repetido);
    }

    @Test
    public void testFazerPost() {
        Grupo grupo = new Grupo("os palhaços da noite", "aqui só entra os joker maluco!");
        Post post = new Post(1, "Eu amo jogar no PC!", "Jogar no computador me traz uma paz única. s2", grupo);

        grupo.fazerPost(post);
        assertTrue(grupo.getPosts().contains(post));
    }
}
