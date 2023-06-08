import junit.framework.TestCase;
import java.sql.*;
import java.util.ArrayList;
public class DesenvolvedorTest extends TestCase{

    public void testeCadastro() throws ClassNotFoundException, SQLException
    {
        Connection connection = new ConnectTest().getConnection();
        Desenvolvedor desenvolvedor = new Desenvolvedor("getName()", "1", "1", "1");
        DesenvolvedorModel.create(desenvolvedor, connection);
        ArrayList<Desenvolvedor> vet = DesenvolvedorModel.listAll(connection);
    }
    
}
