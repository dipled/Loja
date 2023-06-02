import java.sql.*;
import java.text.*;
import java.util.*;

public class JogosController
{
	public static Scanner input = new Scanner(System.in);

	public void createjogo(Connection connection) throws SQLException, ParseException
	{
		System.out.println();
		System.out.println("Insira os seguintes dados para a criar um novo jogo: ");
		System.out.println();

        System.out.println("Desenvolvedor: ");
        int desenvolvedor = Integer.parseInt(input.nextLine());

		System.out.print("Titulo: ");
		String nome = input.nextLine();

		System.out.print("Descrição: ");
		String descricao = input.nextLine();

        System.out.print("Preco: ");
		float preco = Float.parseFloat(input.nextLine());

        System.out.print("Desconto: ");
		float desconto = Float.parseFloat(input.nextLine());

        System.out.print("Nota: ");
		float nota = Float.parseFloat(input.nextLine());

        System.out.print("Ano: ");
		int ano = Integer.parseInt(input.nextLine()); 
        
		
		Jogo jogo = new Jogo(desenvolvedor, nome, descricao, preco,desconto,nota,ano);
		JogosModel.create(jogo, connection);

		System.out.println();
		System.out.println("jogo criado com sucesso!");
		System.out.println();
	}

	void listarItens(Connection connection) throws SQLException
	{
		HashSet jogos = JogosModel.listAll(connection);
		Iterator<Jogo> iterator = jogos.iterator();
		
		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}
}