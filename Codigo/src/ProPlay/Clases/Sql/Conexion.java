package ProPlay.Clases.Sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Conexion {
	private static String timeZone = "UTC";
	private static String dbName = "proplayit";//Nombre de la base de datos
	private static String user = "Rafael";//nombre del usuario
	private static String pass = "manolo";//contraseña
	private static String driver = "com.mysql.cj.jdbc.Driver";//Driver
	
	private static MysqlDataSource miconexion;
	private static Connection conexion;
	private static Statement consulta;
	private static ResultSet resultado;
	
		
	public static Connection conex() throws SQLException {
		
		try {
			
			miconexion = new MysqlDataSource();

			//Configuracion de la conecxion de a la base de datos
			miconexion.setUseSSL(false);
			miconexion.setServerTimezone(timeZone);
			miconexion.setAllowPublicKeyRetrieval(true);
			miconexion.setUseLegacyDatetimeCode(false);
			miconexion.setServerName("rafael");
			miconexion.setPortNumber(3306);
			miconexion.setDatabaseName(dbName);
	        miconexion.setUser(user);
	        miconexion.setPassword(pass);
	        
	        
		}catch (Exception e) {
			System.out.println("Error, no sea conseguido conectar con la base de datos.");//Mensaje de error
			System.out.println(e);
			
		}
		
		return miconexion.getConnection();
		
	}
	
}
