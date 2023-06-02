import java.sql.*;
import java.text.*;
import java.util.*;

public class UsuariosController 
{
    public static Scanner input = new Scanner(System.in);

    public void createUsuario(Connection connection) throws SQLException, ParseException
	{
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
    
    }

    void listarItens(Connection connection) throws SQLException
    {
        HashSet usuarios = UsuarioModel.listAll(connection);
        Iterator<Usuario> iterator = usuarios.iterator();

        System.out.println();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }
    Usuario login(Connection connection) throws SQLException, Exception
    {
        System.out.println("Digite seu email");
        String email = input.nextLine();
        System.out.println("Digite sua senha");
        String senha = input.nextLine();
        return UsuarioModel.login(connection, email,senha);
    }
}
