import java.sql.*;
import java.util.logging.*;
public class ConnectTest {
    

	private Connection connection = null;
	
	public ConnectTest() throws ClassNotFoundException
	{
		String username = "postgres";
		String password = "udesc";
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/postgres";

		try
		{
			Class.forName(driver);
			this.connection = (Connection) DriverManager.getConnection(url, username, password);
		}
		
		catch(ClassNotFoundException exception)
		{
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, exception);
			exception.printStackTrace();
			System.exit(1);
		}
		
		catch(SQLException exception)
		{
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, exception);
			exception.printStackTrace();
			System.exit(1);
		}
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public void closeConnection()
	{
		try
		{
			this.connection.close();
		}
		
		catch(SQLException exception)
		{
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, exception);
			exception.printStackTrace();
			System.exit(1);
		}
	}
}
