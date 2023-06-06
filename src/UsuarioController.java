import java.sql.*;
import java.text.*;
import java.util.*;

public class UsuarioController 
{
    public static Scanner input = new Scanner(System.in);

    public void createUsuario(Connection connection) throws SQLException, ParseException
	{
        System.out.println();
		System.out.println("\nInsira os seguintes dados para a criar um novo Usuario: \n");
        
        System.out.println("Nome: ");
        String nome = input.nextLine();

        System.out.println("Email: ");
        String email = input.nextLine();

        System.out.println("Senha: ");
        String senha = input.nextLine();

        Usuario usuario = new Usuario(nome, email, senha);
        UsuarioModel.create(usuario, connection);

        System.out.println("\nUsuario criado com sucesso\n");
        System.out.println();
    
    }

    void listarItens(Connection connection) throws SQLException
    {
        ArrayList<Usuario> usuarios = UsuarioModel.listAll(connection);
        Iterator<Usuario> iterator = usuarios.iterator();

        System.out.println();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
        System.out.println();
    }
    Usuario login(Connection connection) throws SQLException
    {
        System.out.println();
        System.out.println("Digite o email");
        String email = input.nextLine();
        System.out.println("Digite a senha");
        String senha = input.nextLine();
        Usuario r = UsuarioModel.login(email, senha, connection);
        System.out.println();
        return r;
    }
    void comprar(Connection connection, int idU)throws SQLException
    {
        System.out.println("Digite o id do jogo que voce deseja comprar");
        int idJ = Integer.parseInt(input.nextLine());
        UsuarioModel.comprar(idU,idJ,connection);
    }
    void avaliar(Connection connection, int idU) throws SQLException
    {
        System.out.println();
        System.out.println("Digite o id do jogo que voce deseja avaliar");
        int idJ = Integer.parseInt(input.nextLine());
        System.out.println("Digite a sua avaliacao");
        String aval = input.nextLine();
        System.out.println("Digite a nota");
        float nota = Float.parseFloat(input.nextLine());
        UsuarioModel.avaliar(idU, idJ, nota, aval, connection);
        System.out.println();

    }
    void mostrarAvaliacoes(Connection connection) throws SQLException
    {
        System.out.println();
        System.out.println("Digite o id do jogo que deseja");
        int idJ = Integer.parseInt(input.nextLine());
        Avaliacao aval = UsuarioModel.mostrarAvaliacoes(idJ, connection);
        System.out.println("Avaliacoes: "+aval.getAvaliacoes());
        System.out.println("Nota media: "+String.valueOf(aval.getNota()));
        System.out.println();
    }
}
