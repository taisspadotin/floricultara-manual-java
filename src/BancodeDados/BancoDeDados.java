package bancodedados;
import java.sql.*;

public class BancoDeDados 
{
	public static Connection Conectar() 
	{
	   String USUARIO = "postgres";
           String SENHA = "06121998";
           String URL = "jdbc:postgresql://localhost:5433/floriculturamao";
           String DRIVER = "org.postgresql.Driver";	
            
            
            /*String url = "jdbc:odbc:agenda.gdb";
	*/	
           try 
		{
			Class.forName(DRIVER);
			Connection Conn = DriverManager.getConnection(URL, USUARIO, SENHA);//atributo do tipo de conexao recebe o JDBC Driver padrão
			return (Conn);
		} 
		
		catch (java.lang.Exception ex) 
		{
			ex.printStackTrace();
			return (null);
		}
                        
	}

	public static void FecharConn(Connection Conn) 
	{
		try 
		{
			if (!Conn.isClosed()) 
			{
				Conn.close();
			}

		} 
		
		catch (SQLException sqlEx) 
		{
			sqlEx.getMessage();
		}
	}
}


