import java.sql.*;
import java.text.*;
import java.util.*;

public class App {  
    static Usuario user = new Usuario();
    public static void main(String[] args)throws SQLException, ParseException, ClassNotFoundException {
        Connection connection = new Connect().getConnection();
        new JogosController().listarJogos(connection);
        new UsuariosController().listarItens(connection);
        
    }
}
