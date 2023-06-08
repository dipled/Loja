import junit.framework.TestCase;
import java.sql.*;
import java.util.ArrayList;

public class DesenvolvedorTest extends TestCase {

    public void testeCadastroEListAll() throws ClassNotFoundException, SQLException {
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
        Statement statement;
        statement = connection.createStatement();
        String sql = "delete from avaliacoes; delete from biblioteca; delete from usuarios;delete from jogos; delete from desenvolvedores";
        statement.executeUpdate(sql);
    }
}
