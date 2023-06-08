import junit.framework.TestCase;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioTest extends TestCase {

    public void testUser() throws ClassNotFoundException, SQLException {
        Connection connection = new ConnectTest().getConnection();
        Usuario u1 = new Usuario("Pedro", "pedro", "123");
        Usuario u2 = new Usuario("Fernando", "fer", "123");
        Usuario u3 = new Usuario("Fernando2", "fer", "123");
        try {
            UsuarioModel.create(u1, connection);
            UsuarioModel.create(u2, connection);
            UsuarioModel.create(u3, connection);
        } catch (SQLException e) {
        }
        ArrayList<Usuario> vet = UsuarioModel.listAll(connection);
        assertEquals(true, vet.contains(u1)); // Garantiu que cadastramos o primeiro Usuario
        assertEquals(true, vet.contains(u2)); // Garantiu que cadastramos o segundo Usuario
        assertEquals(2, vet.size()); // Garantiu que nao cadastramos o terceiro Usuario (tamanho do vetor 2)
        assertEquals(true, UsuarioModel.login("pedro", "123", connection).equals(u1)); // Testando Login
        assertEquals(true, UsuarioModel.login("pedro", "122", connection) == null); // Testando falha ao logar com
                                                                                    // credenciais erradas

        Desenvolvedor d1 = new Desenvolvedor("Valve", "1", "1", "1");
        Desenvolvedor d2 = new Desenvolvedor("Pixar", "1", "1", "2");
        Desenvolvedor d3 = new Desenvolvedor("Pixar", "1", "1", "2");
        try {
            DesenvolvedorModel.create(d1, connection);
            DesenvolvedorModel.create(d2, connection);
            DesenvolvedorModel.create(d3, connection);
        } catch (SQLException e) {
        }
        ArrayList<Desenvolvedor> dvet = DesenvolvedorModel.listAll(connection);
        assertEquals(true, dvet.contains(d1)); // Garantiu que cadastramos o primeiro desenvolvedor
        assertEquals(true, dvet.contains(d2)); // Garantiu que cadastramos o segundo desenvolvedor
        assertEquals(2, dvet.size()); // Garantiu que nao cadastramos o terceiro desenvolvedor (tamanho do dvetor 2)
        Jogo j1 = new Jogo(dvet.get(0).getId(), "half-life", "nad", 0, 1999);
        Jogo j2 = new Jogo(dvet.get(0).getId(), "half-life2", "nad", 0, 2004);
        Jogo j3 = new Jogo(dvet.get(1).getId(), "toystory", "nad", 0, 1998);
        Jogo j4 = new Jogo(dvet.get(1).getId(), "toystory", "nad", 0, 1998);
        try {
            JogoModel.create(j1, connection);
            JogoModel.create(j2, connection);
            JogoModel.create(j3, connection);
            JogoModel.create(j4, connection);

        } catch (SQLException e) {
        }

        ArrayList<Jogo> jvet = JogoModel.listAll(connection);
        // Vamos garantir que os 3 primeiros jogos foram cadastrados, porem o quarto nao
        assertEquals(true, jvet.contains(j1));
        assertEquals(true, jvet.contains(j2));
        assertEquals(true, jvet.contains(j3));
        assertEquals(3, jvet.size());
        ArrayList<Jogo> jogosDev1 = JogoModel.listAllFromDeveloper(connection, dvet.get(0).getId());
        // Vamos garantir que os dois primeiros jogos foram cadastrados ao dev1
        assertEquals(true, jogosDev1.contains(j1));
        assertEquals(true, jogosDev1.contains(j2));
        assertEquals(false, jogosDev1.contains(j3));

        UsuarioModel.comprar(vet.get(0).getId(), jvet.get(0).getId(), connection);
        ArrayList<Jogo> jogosU1 = JogoModel.listAllFromUser(connection, vet.get(0).getId());
        // Teste de comprar jogo
        assertEquals(true, jogosU1.contains(j1));
        assertEquals(false, jogosU1.contains(j2));
        try {
            UsuarioModel.avaliar(vet.get(0).getId(), jvet.get(0).getId(), 10, "muito bom", connection);
            UsuarioModel.avaliar(vet.get(0).getId(), jvet.get(1).getId(), 10, "muito bom", connection);
        } catch (SQLException e) {
        }
        Avaliacao av = UsuarioModel.mostrarAvaliacoes(jvet.get(0).getId(), connection);
        assertEquals("10.0", String.valueOf(av.getNota()));
        assertEquals(true, av.getAvaliacoes().equals("\nPedro: muito bom. Nota: 10.0\n"));

        Jogo jogo = UsuarioModel.jogoMaisAntigo(connection);
        assertEquals(jogo, jvet.get(2));
        Statement statement;
        statement = connection.createStatement();
        String sql = "delete from avaliacoes; delete from biblioteca; delete from usuarios;delete from jogos; delete from desenvolvedores";
        statement.executeUpdate(sql);

    }
}
