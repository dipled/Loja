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
	static Usuario login(Connection connection, String email, String senha) throws SQLException, Exception
	{
		PreparedStatement st;
		Exception exception = new Exception("UsuarioInvalido");
		st = connection.prepareStatement("select * from usuarios where usuarios.email = ? and usuarios.senha = ?");
		st.setString(1, email);
		st.setString(2, senha);
		ResultSet r = st.executeQuery();
		if(r.getString(1).equals(null))
			throw exception;
		Usuario u = new Usuario(r.getInt(1), r.getString(2), r.getString(3), r.getString(3));
		return u;
	}


}
