import java.sql.*;
import java.text.*;
import java.util.*;

public class App {  
    static Usuario user = new Usuario();
    public static void main(String[] args)throws SQLException, ParseException, ClassNotFoundException {
        Connection connection = new Connect().getConnection();
        try{
            new UsuariosController().login(connection);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}
