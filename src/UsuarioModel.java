import java.sql.*;
import java.util.*;

public class UsuarioModel 
{
    static void create(Usuario usuario, Connection connection) throws SQLException
	{
		PreparedStatement statement;

		statement = connection.prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getSenha());
		statement.execute();
		statement.close();
	}

    static HashSet listAll(Connection connection) throws SQLException
	{
		Statement statement;
		HashSet usuarios = new HashSet();

		statement = connection.createStatement();
		String sql = "SELECT * FROM jogos";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			usuarios.add(new Usuario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
		}

		return usuarios;
	}


}
