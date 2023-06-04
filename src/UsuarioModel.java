import java.sql.*;
import java.util.*;

import org.postgresql.core.SqlCommand;

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

    static ArrayList<Usuario> listAll(Connection connection) throws SQLException
	{
		Statement statement;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		statement = connection.createStatement();
		String sql = "SELECT * FROM usuarios";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			usuarios.add(new Usuario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
		}

		return usuarios;
	}
	static Usuario login(String email, String senha, Connection connection) throws SQLException
	{
		PreparedStatement st;
		st = connection.prepareStatement("select * from usuarios where email = ? and senha = ?");
		st.setString(1, email);
		st.setString(2, senha);
		ResultSet result = st.executeQuery();
		if(!result.next())
			return null;
		return new Usuario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));

	}
	static void comprar(int idU, int idJ, Connection connection) throws SQLException
	{
		PreparedStatement st;
		st = connection.prepareStatement("INSERT into biblioteca (user_id, jogo_id) values (?,?)");
		st.setInt(1,idU);
		st.setInt(2, idJ);
		st.execute();
	}
	static void avaliar (int idU, int idJ, float nota, String aval, Connection connection) throws SQLException
	{
		PreparedStatement st;
		st = connection.prepareStatement("insert into avaliacoes (avaliacao, user_id, jogo_id, nota) values (?,?,?,?)");
		st.setString(1,aval);
		st.setInt(2,idU);
		st.setInt(3, idJ);
		st.setFloat(4, nota);
		st.execute();
	}
	static Avaliacao mostrarAvaliacoes(int idJ, Connection connection) throws SQLException
	{
		Avaliacao aval = new Avaliacao();
		PreparedStatement st;
		st = connection.prepareStatement("select avaliacao, nota, nome from (avaliacoes join usuarios on avaliacoes.user_id = usuarios.id) where jogo_id = ?");
		st.setInt(1, idJ);
		ResultSet r = st.executeQuery();
		String avali = "\n";
		float notaSum = 0;
		int c = 0;
		while(r.next())
		{
			float nota = r.getFloat(2);
			notaSum += nota;
			c += 1;
			avali += r.getString(3) + ": "+  r.getString(1) + ". Nota: "+ String.valueOf(nota) +"\n";
		}
		aval.setAvaliacoes(avali);
		aval.setNota(notaSum/c);
		return aval;
	}
}
