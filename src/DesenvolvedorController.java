import java.sql.*;
import java.text.*;
import java.util.*;

public class DesenvolvedorController {
    
    public static Scanner input = new Scanner(System.in);

	public void createDesenvolvedor(Connection connection) throws SQLException, ParseException
	{

		System.out.println("\nInsira os seguintes dados para a criar um novo Desenvolvedor: \n");

        System.out.print("Nome: ");
		String nome = input.nextLine();

        System.out.print("Telefone: ");
		String telefone = input.nextLine();

        System.out.print("Endereço: ");
		String endereco = input.nextLine();

        System.out.print("CNPJ: ");
		String cnpj = input.nextLine();
        
        Desenvolvedor desenvolvedor = new Desenvolvedor(nome, telefone, endereco, cnpj);
        DesenvolvedorModel.create(desenvolvedor, connection);

        System.out.println("\nDesenvolvedor crido com sucesso!\n");
    }

    void listarItens(Connection connection) throws SQLException
    {
        ArrayList<Desenvolvedor> desenvolvedores = DesenvolvedorModel.listAll(connection);
        Iterator<Desenvolvedor> iterator = desenvolvedores.iterator();
        System.out.println();
        System.out.println();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
        System.out.println();
    }
}
