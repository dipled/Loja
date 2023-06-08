import junit.framework.TestCase;
import java.sql.*;
import java.util.ArrayList;
public class JogoTest extends TestCase{

    public void testeCadastroEListAll() throws ClassNotFoundException, SQLException
    {
        Connection connection = new ConnectTest().getConnection();
        Desenvolvedor d1 = new Desenvolvedor("Valve", "1", "1", "1");
        Desenvolvedor d2 = new Desenvolvedor("Pixar", "1", "1", "2");
        Desenvolvedor d3 = new Desenvolvedor("Pixar", "1", "1", "2");
        try {
            DesenvolvedorModel.create(d1, connection);
            DesenvolvedorModel.create(d2, connection);
            DesenvolvedorModel.create(d3, connection);
        } catch (SQLException e) {
        }
        ArrayList<Desenvolvedor> vet = DesenvolvedorModel.listAll(connection);
        assertEquals(true, vet.contains(d1)); // Garantiu que cadastramos o primeiro desenvolvedor
        assertEquals(true, vet.contains(d2)); // Garantiu que cadastramos o segundo desenvolvedor
        assertEquals(2, vet.size()); // Garantiu que nao cadastramos o terceiro desenvolvedor (tamanho do vetor 2)
        Jogo j1 = new Jogo(vet.get(0).getId(), "half-life", "nad", 0, 1999);
        Jogo j2 = new Jogo(vet.get(0).getId(), "half-life2", "nad", 0, 2004);
        Jogo j3 = new Jogo(vet.get(1).getId(), "toystory", "nad", 0, 1998);
        Jogo j4 = new Jogo(vet.get(1).getId(), "toystory", "nad", 0, 1998);
        try {
            JogoModel.create(j1, connection);
            JogoModel.create(j2, connection);
            JogoModel.create(j3, connection);
            JogoModel.create(j4, connection);

        } catch (SQLException e) {
        }

        ArrayList<Jogo> jvet = JogoModel.listAll(connection);
        //Vamos garantir que os 3 primeiros jogos foram cadastrados, porem o quarto nao
        assertEquals(true, jvet.contains(j1));
        assertEquals(true, jvet.contains(j2));
        assertEquals(true, jvet.contains(j3));
        assertEquals(3,jvet.size());
        ArrayList<Jogo> jogosDev1 = JogoModel.listAllFromDeveloper(connection, vet.get(0).getId());
        //Vamos garantir que os dois primeiros jogos foram cadastrados ao dev1
        assertEquals(true, jogosDev1.contains(j1));
        assertEquals(true, jogosDev1.contains(j2));
        assertEquals(false, jogosDev1.contains(j3));



        Statement statement;
        statement = connection.createStatement();
        String sql = "delete from avaliacoes; delete from biblioteca; delete from usuarios;delete from jogos; delete from desenvolvedores";
        statement.executeUpdate(sql);
    }
    
}
