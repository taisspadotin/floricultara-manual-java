package Classes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import bancodedados.*;
 
 public class Plantas
 {
 	public ResultSet getPlantas() 
 	{
		Connection oConn = BancoDeDados.Conectar();//variavel de conexão
		try 
		{
			Statement stmt = oConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM plantas ORDER BY nome");//seleciona de plantas e ordena pelo nome
			return (rs);//retorna o q selecionou
		} 
		catch (SQLException sqle) 
		{
			sqle.getMessage();
			return (null);
		}
	}
	
	public ResultSet obterRegistro(String sCodigoPlanta)
    {
    	Connection oConn = BancoDeDados.Conectar();
    	try
    	{
    		Statement stmt = oConn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM plantas WHERE codigo = '"+sCodigoPlanta+"'");
    		return(rs);
    	}
    	catch (SQLException sqle)
    	{
    		sqle.getMessage();
    		return (null);
    	}
    }

	public int numRegistro() 
	{
		Connection oConn = BancoDeDados.Conectar();
		try 
		{
			Statement stmt = oConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT count(*) as Total from plantas");
			int totalAgenda = 0;
			if (rs.next())
			{
			  totalAgenda = rs.getInt("Total");
			}
			return (totalAgenda);
		} 
		catch (SQLException sqle) 
		{
			System.out.println(sqle.getMessage());
			return (-1);
		}
		finally
		{
		 	BancoDeDados.FecharConn(oConn);	
		}
   }
	
	public boolean novaPlantas(String sCodigoPlanta, String sNome, String sEspecie,
	                          String sCategoria, String sPreco)  
	{
		Connection oConn = BancoDeDados.Conectar();
		try 
		{
			Statement stmt = oConn.createStatement();
			stmt.executeUpdate("INSERT INTO plantas (codigo, nome, especie, categoria, preco) VALUES ('" 
			+ sCodigoPlanta + "', '"+ sNome + "', '" + sEspecie + "', '" + sCategoria + "', '" + sPreco+"')");   	
			return (true);
		} 
		catch (SQLException sqle) 
		{
			System.out.println("Erro em plantas.novaPlantas():" + sqle.getMessage());
			return (false);
		} 
		finally 
		{
			BancoDeDados.FecharConn(oConn);
		}
	}

	public boolean ExcluirPlanta(String sCodigoPlanta) 
	{
		Connection oConn = BancoDeDados.Conectar();
		try 
		{
			Statement stmt = oConn.createStatement();
			boolean result = stmt.execute("DELETE FROM plantas WHERE codigo = '"+sCodigoPlanta +"'");
			return (true);
		} 
		
		catch (SQLException sqle) 
		{
			System.out.println("Erro Plantas.ExcluirPlanta():" + sqle.getMessage());
			return (false);
		} 
		
		finally 
		{
			BancoDeDados.FecharConn(oConn);
		}
	}

	public boolean AtualizaPlanta(String sCodigoPlanta, String sNome, String sEspecie,
	                          String sCategoria, String sPreco) 
	{
		Connection oConn = BancoDeDados.Conectar();
		try 
		{
			Statement stmt = oConn.createStatement();

			boolean result = stmt.execute("UPDATE plantas SET nome= '"+sNome +"', especie= '"+sEspecie + "',categoria= '"+sCategoria +"',preco= '"+sPreco+"'WHERE codigo = '"+sCodigoPlanta +"'");
			return (true);
		} 
		catch (SQLException sqle) 
		{
			System.out.println("Erro em Plantas.AtualizaPlanta:" + sqle.getMessage());
			return (false);
		} 
		finally 
		{
			BancoDeDados.FecharConn(oConn);
		}
    } 	
 }

