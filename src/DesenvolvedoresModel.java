import java.sql.*;
import java.util.*;

public class DesenvolvedoresModel 
{
    static void create(Desenvolvedor desenvolvedor, Connection connection) throws SQLException   
    {
        PreparedStatement statement;

        statement = connection.prepareStatement("INSERT INTO desenvolvedores (nome, telefone, endereco, cnpj) VALUES (?, ?, ?, ?)");
        statement.setString(1, desenvolvedor.getNome());
        statement.setString(2,desenvolvedor.getTelefone());
        statement.setString(3, desenvolvedor.getEndereco());
        statement.setString(4, desenvolvedor.getCnpj());
        statement.execute();
		statement.close();
    } 

    static HashSet listAll(Connection connection) throws SQLException
    {
        Statement statement;
        HashSet desenvolvedores = new HashSet();

        statement = connection.createStatement();
        String sql = "SELECT * FROM desenvolvedores";
        ResultSet result = statement.executeQuery(sql);

        while(result.next())
        {
            desenvolvedores.add(new Desenvolvedor(result.getInt(1), result.getString(2), result.getString(3),result.getString(4), result.getString(5)));
        }

        return desenvolvedores;
    }
}
