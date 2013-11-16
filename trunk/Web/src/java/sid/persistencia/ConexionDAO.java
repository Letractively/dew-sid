package sid.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionDAO{
	
	public static Connection obtenerConexion() throws SQLException {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/condominio","root", "root");
                        
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	

}
