import java.sql.*;
import java.util.*;

public class JogoModel
{
	static void create(Jogo jogo, Connection connection) throws SQLException
	{
		PreparedStatement statement;

		statement = connection.prepareStatement("INSERT INTO jogos (desenvolvedor, titulo, descricao, preco, ano) VALUES (?, ?, ?, ?, ?)");
		statement.setInt(1, jogo.getDesenvolvedor());
		statement.setString(2, jogo.getTitulo());
        statement.setString(3,jogo.getDescricao());
        statement.setFloat(4, jogo.getPreco());
        statement.setInt(5,jogo.getAno());
		statement.execute();
		statement.close();
	}

	static ArrayList<Jogo> listAll(Connection connection) throws SQLException
	{
		Statement statement;
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();

		statement = connection.createStatement();
		String sql = "SELECT id, desenvolvedor, titulo, descricao, preco, ano FROM jogos order by desenvolvedor";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			jogos.add(new Jogo(result.getInt(1), result.getInt(2), result.getString(3), 
            result.getString(4), result.getFloat(5),
            result.getInt(6)));
		}

		return jogos;
	}
	static ArrayList<Jogo> listAllFromDeveloper(Connection connection, int id) throws SQLException
	{
		PreparedStatement statement;
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();

		statement = connection.prepareStatement("SELECT * FROM jogos where jogos.desenvolvedor = ? order by desenvolvedor");
		statement.setInt(1,id);
		ResultSet result = statement.executeQuery();
		
		while(result.next())
		{
			jogos.add(new Jogo(result.getInt(1), result.getInt(2), result.getString(3), 
            result.getString(4), result.getFloat(5),
            result.getInt(6)));
		}

		return jogos;
	}
	static ArrayList<Jogo> listAllFromUser(Connection connection, int id) throws SQLException
	{
		PreparedStatement statement;
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();

		statement = connection.prepareStatement("SELECT * FROM jogos where id in (select jogo_id from biblioteca where user_id = ?) order by desenvolvedor");
		statement.setInt(1,id);
		ResultSet result = statement.executeQuery();
		
		while(result.next())
		{
			jogos.add(new Jogo(result.getInt(1), result.getInt(2), result.getString(3), 
            result.getString(4), result.getFloat(5), 
            result.getInt(6)));
		}

		return jogos;
	}
}