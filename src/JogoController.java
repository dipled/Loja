import java.sql.*;
import java.text.*;
import java.util.*;

public class JogoController
{
	public static Scanner input = new Scanner(System.in);

	public void createjogo(Connection connection) throws SQLException, ParseException
	{
		System.out.println();
		System.out.println("Insira os seguintes dados para a criar um novo jogo: ");
		System.out.println();

        System.out.println("Id do desenvolvedor: ");
        int desenvolvedor = Integer.parseInt(input.nextLine());

		System.out.print("Titulo: ");
		String nome = input.nextLine();

		System.out.print("Descrição: ");
		String descricao = input.nextLine();

        System.out.print("Preco: ");
		float preco = Float.parseFloat(input.nextLine());

        System.out.print("Ano: ");
		int ano = Integer.parseInt(input.nextLine()); 
        
		
		Jogo jogo = new Jogo(desenvolvedor, nome, descricao, preco,ano);
		JogoModel.create(jogo, connection);

		System.out.println();
		System.out.println("jogo criado com sucesso!");
		System.out.println();
	}

	void listarJogos(Connection connection) throws SQLException
	{
		ArrayList<Jogo> jogos = JogoModel.listAll(connection);
		Iterator<Jogo> iterator = jogos.iterator();
		
		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}
	void listarDosDesenvolvedores(Connection connection) throws SQLException
	{
		System.out.println("Digite o id do desenvolvedor desejado");
		int id = Integer.parseInt(input.nextLine());
		ArrayList<Jogo> jogos = JogoModel.listAllFromDeveloper(connection, id);
		Iterator<Jogo> iterator = jogos.iterator();
		
		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}
	void listarDoUsuario(Connection connection, int id) throws SQLException
	{
		ArrayList<Jogo> jogos = JogoModel.listAllFromUser(connection, id);
		Iterator<Jogo> iterator = jogos.iterator();
		
		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}
}