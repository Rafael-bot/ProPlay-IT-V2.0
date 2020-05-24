package ProPlay.Clases.Sql;



import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import ProPlay.Clases.Factura.MostrarFactura;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.Sql.Conexion;
import ProPlay.Clases.Tienda.FrameMonedas;

public class Metodos_SQL {
	
		
	private static PreparedStatement sentencia_preparada;
	private static ResultSet resultado;
	private static String sql;
	private static int resultado_numero = 0;
	

	
	// ----------------------------Register / Login
	public static void comprob_register(String user, String gmail, String passwd) {//Aqui comporbamos si los datos ya estan registrados o no 
		
		Connection conexion = null;
		
		
		try {
			
			conexion =  Conexion.conex();
			
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT User FROM usuarios WHERE Email = '"+gmail+"' OR User = '"+user+"';");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				JOptionPane.showMessageDialog(new JFrame(), "ERROR, El usuario o el gmail ya esta registrado","ERROR - Register", JOptionPane.WARNING_MESSAGE);
			} else {
				register(user, gmail, passwd);//Si nop esta registrado le llevara al metodo para registrar usuario
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static int register(String user, String gmail, String passwd) {
		
		int result = 0;
		Connection conexion = null;
				
		try {
				
				conexion = Conexion.conex();
				

				int id = (int) (Math.random()*9999+1);//Genera un id random
				double cred = 10.00;
				boolean control = false;
				
				while(control == false) {//Bucle para que no se repita la id
					sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM usuarios WHERE Id = '"+id+"';");//Comprueba el id
					resultado = sentencia_preparada.executeQuery();
					if (resultado.next()) {//Si se repite se genera otro id
						id = (int) (Math.random()*9999+1);
						control = true;
					} else {
						control = true;
					}
				}
				
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("INSERT INTO usuarios(`Id`, `User`, `Passwd`, `Credito`, `Email`) VALUES ('"+id+"','"+user+"','"+passwd+"','"+cred+"','"+gmail+"');");
				result = sentencia_preparada.executeUpdate();
				sentencia_preparada.close();
				JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
				
		} catch (Exception e) {
			
			System.out.println("Error, No se ha  podido registrar el usuario.");
			JOptionPane.showMessageDialog(new JFrame(), "ERROR, No se a podido registrar el usuario", "ERROR - Register", JOptionPane.WARNING_MESSAGE);
			System.out.println(e);
						
		}
		
		
		return result;
		
	}
	
	public static String login(String user) {//Este es el metodo donde se realiza el login
		
		String busqueda_nombre = null;
		Connection conexion = null;
		ResultSet resultloginuser;
		
		try {
			
			conexion = Conexion.conex();
		
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT User FROM usuarios WHERE Email = '"+user+"' OR User = '"+user+"';");
			resultloginuser = sentencia_preparada.executeQuery();
			if (resultloginuser.next()) {
				busqueda_nombre =  resultloginuser.getString("User");
			}
			
			conexion.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return busqueda_nombre;
		
	}
	
	public static String comprobUser(String user, String passwd) {//Este metodxo comprueba si esta en la base de datos.
		
		String busqueda_login = null;
		Connection conexion = null;
		
		try {
			
			conexion = Conexion.conex();
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT User,Passwd FROM usuarios WHERE User = '"+user+"' AND Passwd = '"+passwd+"';");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {//Si lo encuentra
				busqueda_login = "Usuario encontrado";
			} else {//Si no lo encuentra
				busqueda_login = "Usuario no encontrado";
			}
			
			conexion.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return busqueda_login;
		
	}
	
	public static String comprobGmail(String gmail) {//Metodo para el nome acuerdo
		String busqueda_gmail = null;
		Connection conexion = null;
		
		try {
			
			conexion = Conexion.conex();
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Email FROM usuarios WHERE Email = '"+gmail+"';");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				busqueda_gmail = "Gmail encontrado";
			} else {
				busqueda_gmail = "Gmail no encontrado";
			}
			
			conexion.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return busqueda_gmail;
		
	}
	
	public static String nomeacuerdoq(String gmail) {//Este metodo extrae los del usuario
		
		String busqueda_recup = null;
		
		String u = null;
		String p = null;
		String e = null;
		
		Connection conexion = null;
		ResultSet resultRecup;
		
		try {
			
			conexion = Conexion.conex();
		
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT User,Passwd,Email FROM usuarios WHERE Email = '"+gmail+"';");
			resultRecup = sentencia_preparada.executeQuery();
			if (resultRecup.next()) {
				u = resultRecup.getString("User");
				p = resultRecup.getString("Passwd");
				e = resultRecup.getString("Email");
			} else {
				System.out.println("No existe este gmail.");
			}
			
			
			busqueda_recup = "User: "+u+"\nPassword: "+p+"\nGmail: "+e;
			
			conexion.close();
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		return busqueda_recup;
		
	}
	//----------------------------------------------------
	
	
	//---------------------------------------Eliminar Usuario
	public void eliminarUser(String user){//Eliminar el usuario
		Connection conexion = null;
		
		try {
				conexion = Conexion.conex();
						
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("DELETE FROM usuarios WHERE User = '"+user+"';");
				sentencia_preparada.executeUpdate();
				
				sentencia_preparada.close();
				
				
								
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el usuario.");
			System.out.println(e);
						
		}
	}
	
	private int sacarelid(String user) {//Metodo nos da el id del usuario
		Connection conexion = null;
		int result = 0;
		try {
				conexion = Conexion.conex();
								
				PreparedStatement sentencia_userid = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM usuarios WHERE User = '"+user+"';");
				ResultSet resultUserId = sentencia_userid.executeQuery();
				
				if (resultUserId.next()) {
					result = resultUserId.getInt("Id");
				}
				
				sentencia_userid.close();
		} catch (Exception e) {
			System.out.println("No se ha encontrado el Id del usuario.");
			System.out.println(e);
							
		}
		
		return result;
			
	}
	
	public void eliminaramigos(String user){//Eliminar la relacion de sus amigos con el
		Connection conexion = null;
		
		try {
				conexion = Conexion.conex();
															
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("DELETE FROM amigos WHERE id_user1 = "+sacarelid(user)+" OR id_user2 = "+sacarelid(user)+" ;");
				sentencia_preparada.executeUpdate();
				
				sentencia_preparada.close();
		} catch (Exception e) {
			System.out.println("No se pudo eliminar los amigos.");
			System.out.println(e);
						
		}
	}
	
	public void eliminarListaJuegos(String user){//Metodo para eliminar los juegos de usuario
		Connection conexion = null;
		
		try {
				conexion = Conexion.conex();
															
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("DELETE FROM listas_juegos WHERE id_usuarios = "+sacarelid(user)+";");
				sentencia_preparada.executeUpdate();
				
				sentencia_preparada.close();
		} catch (Exception e) {
			System.out.println("No se pudo eliminar la lista de juegos del usuario.");
			System.out.println(e);
						
		}
	}
	//---------------------------------------------------------------------
		
		
	public void ingresarMoneda(double puntos,String user) {//Metodo obtiene la moneda
		Connection conexion = null;
		
		try {
				conexion = Conexion.conex();
				
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT SUM(Credito+"+puntos+") AS MonedaAct FROM usuarios WHERE User = '"+user+"';");
				ResultSet monedauser = sentencia_preparada.executeQuery();
				double result = 0;
				if (monedauser.next()) {
					result = monedauser.getDouble("MonedaAct");
				}
					
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("update usuarios SET Credito = "+result+" WHERE User = '"+user+"';");
				sentencia_preparada.executeUpdate();
				
				
				
				sentencia_preparada.close();
				

		} catch (Exception e) {
			System.out.println("No se pudo almacenar el dinero.");
			System.out.println(e);
						
		}
		
	}
	//--------------------------------------------Juegos
	public String getFotojuego(String titulo) {//Metodo que obtiene la ruta de la imagen del juegos
		Connection conexion = null;
		String result = null;
		
		
		try {
				conexion = Conexion.conex();
				
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Imagen FROM juegos WHERE Titulo = '"+titulo+"';");
				resultado = sentencia_preparada.executeQuery();
				if (resultado.next()) {
					result = resultado.getString("Imagen");
				}
				
				sentencia_preparada.close();
				
		} catch (Exception e) {
			System.out.println("No se pudo obtener la imagen.");
			System.out.println(e);
						
		}
		
		return result;
	}
	
	public String getPreciojuego(String titulo) {//Obtiene el precio del juegos
		Connection conexion = null;
		String result = null;
		
		
		try {
				conexion = Conexion.conex();
				
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Precio FROM juegos WHERE Titulo = '"+titulo+"';");
				resultado = sentencia_preparada.executeQuery();
				if (resultado.next()) {
					result = resultado.getString("Precio");
				}
				
				sentencia_preparada.close();
				
		} catch (Exception e) {
			System.out.println("No se pudo obtener la imagen.");
			System.out.println(e);
						
		}
		
		return result;
	}
	
	
	
	
	public String getPreciojuegoSumaTotal(String titulo) {
		Connection conexion = null;
		String result = null;
		
		
		try {
				conexion = Conexion.conex();
				
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT SUM(Precio+1.80) AS Precio FROM juegos WHERE Titulo = '"+titulo+"';");
				resultado = sentencia_preparada.executeQuery();
				if (resultado.next()) {
					result = resultado.getString("Precio");
				}
				
				sentencia_preparada.close();
				
		} catch (Exception e) {
			System.out.println("No se pudo hacer la suma.");
			System.out.println(e);
						
		}
		
		return result;
	}
	//----------------------------------------------------------------------------------------------------------
	
	

	//------------------------------------------------------------Monedas
	public static String actualizarmoneda(String user) {
		String result = null;
		
		Connection conexion = null;
		
		try {
			
			conexion = Conexion.conex();
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Credito FROM usuarios WHERE User = '"+user+"';");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				result = resultado.getString("Credito");
			}
			
			conexion.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return result;
	}
		
	public static String actualizarUserId(String user) {
		String result = null;
		
		Connection conexion = null;
		
		try {
			
			conexion = Conexion.conex();
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM usuarios WHERE User = '"+user+"';");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				result = resultado.getString("Id");
			}
			
			conexion.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return result;
	}
	
	
	//----------------------------------------------------------------------------Factura
	
	public void comprobjuegosfact(String user, double moneytotal, String titulojuego, String preciojuego,String credituser) {
		Connection conexion = null;
		MetodoFichero fich = new MetodoFichero();
		MostrarFactura mostfact = new MostrarFactura();
		
		try {
			
			conexion = Conexion.conex();
			
			//Id - usuarios
			int idusuarios = 0;
			PreparedStatement sentencia_idusuarios = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM usuarios WHERE User = '"+user+"';");
			ResultSet idusuariosResult = sentencia_idusuarios.executeQuery();
			if (idusuariosResult.next()) {
				idusuarios = idusuariosResult.getInt("Id");
			}
						
			//Id - juegos
			int idjuegos = 0;
			PreparedStatement sentencia_idjuegos = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM juegos WHERE Titulo = '"+titulojuego+"';");
			ResultSet idjuegosResult = sentencia_idjuegos.executeQuery();
			if (idjuegosResult.next()) {
				idjuegos = idjuegosResult.getInt("Id");
			}
								
			//id_usuarios,id_juegos,estado - listas_juegos
			PreparedStatement sentencia_idusuario_lista = (PreparedStatement) conexion.prepareStatement("INSERT INTO listas_juegos(`id_usuarios`, `id_juegos`) VALUES ('"+idusuarios+"','"+idjuegos+"');");
			int sentencia_idusuario_ = sentencia_idusuario_lista.executeUpdate();
			
			pagar1(titulojuego);
			pagar2(user, moneytotal);			
						
			JOptionPane.showMessageDialog(new JFrame(), "Juego comprado.", "ProPlay IT - Comprar", JOptionPane.INFORMATION_MESSAGE);
			
			fich.escribirFactura(preciojuego,"1.80",titulojuego,credituser,user);
			mostfact.textPane.setText(fich.leerfactura());
			mostfact.setVisible(true);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Ya tienes el juego", "ProPlay IT -Error - Juego", JOptionPane.WARNING_MESSAGE);
			
		}


	}
	

		
	public void pagar(String user, double moneytotal, String titulojuego) {
		Connection conexion = null;
		
		try {
			
			conexion = Conexion.conex();
			
			//Id - usuarios
			int idusuarios = 0;
			PreparedStatement sentencia_idusuarios = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM usuarios WHERE User = '"+user+"';");
			ResultSet idusuariosResult = sentencia_idusuarios.executeQuery();
			if (idusuariosResult.next()) {
				idusuarios = idusuariosResult.getInt("Id");
			}
						
			//Id - juegos
			int idjuegos = 0;
			PreparedStatement sentencia_idjuegos = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM juegos WHERE Titulo = '"+titulojuego+"';");
			ResultSet idjuegosResult = sentencia_idjuegos.executeQuery();
			if (idjuegosResult.next()) {
				idjuegos = idjuegosResult.getInt("Id");
			}
								
			//id_usuarios,id_juegos,estado - listas_juegos
			PreparedStatement sentencia_idusuario_lista = (PreparedStatement) conexion.prepareStatement("INSERT INTO listas_juegos(`id_usuarios`, `id_juegos`) VALUES ('"+idusuarios+"','"+idjuegos+"');");
			int sentencia_idusuario_ = sentencia_idusuario_lista.executeUpdate();
			
			pagar1(titulojuego);
			pagar2(user, moneytotal);
			
			JOptionPane.showMessageDialog(new JFrame(), "Juego comprado.", "ProPlay IT - Comprar", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Ya tienes el juego", "ProPlay IT -Error - Juego", JOptionPane.WARNING_MESSAGE);
			
		}

	}
	
	public void pagar1(String titulojuego) {
		Connection conexion = null;
		
		try {
			
			conexion = Conexion.conex();
			
			//Stock - juegos
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT sum(Stock)-sum(1) AS Stock FROM juegos WHERE Titulo = '"+titulojuego+"';");
			resultado = sentencia_preparada.executeQuery();
			int resultstock = 0;
			if (resultado.next()) {
				resultstock = resultado.getInt("Stock");
			}
						
			PreparedStatement sentencia_stock_update = (PreparedStatement) conexion.prepareStatement("UPDATE juegos SET Stock = "+resultstock+"  WHERE Titulo = '"+titulojuego+"';");
			int eliminarstock = sentencia_stock_update.executeUpdate();
			
			sentencia_preparada.close();
			sentencia_stock_update.close();
			
		} catch (Exception e) {
			System.out.println("Juegos");
			System.out.println(e);
		}
		
	}
	
	public void pagar2(String user, double moneytotal) {
		Connection conexion = null;
		
		try {
			
			conexion = Conexion.conex();
			
			//Credito - usuarios
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT sum(Credito)-sum("+moneytotal+") AS CreditoACt FROM usuarios WHERE User = '"+user+"';");
			resultado = sentencia_preparada.executeQuery();
			double resultcredito = 0;
			if (resultado.next()) {
				resultcredito = resultado.getDouble("CreditoACt");
			}		
						
			PreparedStatement sentencia_credito = (PreparedStatement) conexion.prepareStatement("UPDATE usuarios SET Credito = "+resultcredito+"  WHERE User = '"+user+"';");
			int credito = sentencia_credito.executeUpdate();
			
			sentencia_preparada.close();
			sentencia_credito.close();
			
		} catch (Exception e) {
			System.out.println("Credito");
			System.out.println(e);
		}
		
	}
		
		
	public int Stock(String titulojuego) {
		Connection conexion = null;
		int result = 0;
		
		try {
			
			conexion = Conexion.conex();
			
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("Select Stock From juegos Where Titulo = '"+titulojuego+"';");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				result = resultado.getInt("Stock");
			}		
			
			
		} catch (Exception e) {
			
			System.out.println("No se ha encontrado el Stock");
			System.out.println(e);
		}
		return result;
	}
	//----------------------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------Amigos
	
	//------Añadir AMigos
	public void comprobUserIDAñadir(String idAmigo, String miId) {
		Connection conexion = null;
		int int_idAmigo = Integer.parseInt(idAmigo);
		String result = null;
		
		try {
			
			conexion = Conexion.conex();
			
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM usuarios WHERE Id="+int_idAmigo+";");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				comprobAmigos(idAmigo, miId);
			}else {
				JOptionPane.showMessageDialog(new JFrame(), "El ID no existe","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);
			}
			
			
			sentencia_preparada.close();
			
		} catch (Exception e) {
			
			System.out.println("No se ha podido comprobar los amigos.");
			System.out.println(e);
		}
	}
	
	private void comprobAmigos(String idAmigo, String miId) {
		Connection conexion = null;
		int int_miId = Integer.parseInt(miId);
		int int_idAmigo = Integer.parseInt(idAmigo);
		String select = null;
		
		try {
			
			conexion = Conexion.conex();
			
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT * FROM amigos WHERE id_user2 = "+int_miId+" AND id_user1 = "+int_idAmigo+";");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				JOptionPane.showMessageDialog(new JFrame(), "El ID introducido ya lo tienes como amigo.","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);
			} else {
				añadirAmigos(idAmigo, miId);
			}
						
			sentencia_preparada.close();
			
		} catch (Exception e) {
			
			System.out.println("No se ha podido comprobar los amigos.");
			System.out.println(e);
		}
	}
	

	
	private void añadirAmigos(String idAmigo, String miId) {
			Connection conexion = null;
			
			int int_idAmigos = Integer.parseInt(idAmigo);
			int int_miId = Integer.parseInt(miId);
			
			try {
					conexion = Conexion.conex();
									
					sentencia_preparada = (PreparedStatement) conexion.prepareStatement("INSERT INTO `amigos` VALUES ("+int_idAmigos+","+int_miId+");");
					int resultado_amigos = sentencia_preparada.executeUpdate();
					
					JOptionPane.showMessageDialog(new JFrame(), "Amigo añadido", "ProPlay IT - Amigo", JOptionPane.INFORMATION_MESSAGE);
					
					sentencia_preparada.close();
					
			
				
			} catch (SQLException e) {
				System.out.println("No se a podido añadi rel amigo");
				System.out.println(e);
			}

	}
	//------------------EliminarAMigo
	
	public void comprobUserIDEliminar(String idAmigo, String miId) {
		Connection conexion = null;
		int int_idAmigo = Integer.parseInt(idAmigo);
		String result = null;
		
		try {
			
			conexion = Conexion.conex();
			
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT Id FROM usuarios WHERE Id="+int_idAmigo+";");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				comprobAmigosEliminar(idAmigo, miId);
			}else {
				JOptionPane.showMessageDialog(new JFrame(), "El ID no existe","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);
			}
			
			
			sentencia_preparada.close();
			
		} catch (Exception e) {
			
			System.out.println("No se ha podido comprobar los amigos.");
			System.out.println(e);
		}
	}
	
	private void comprobAmigosEliminar(String idAmigo, String miId) {
		Connection conexion = null;
		int int_inAmigo = Integer.parseInt(idAmigo);
		String select = null;
		
		try {
			
			conexion = Conexion.conex();
			
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT id_user1 FROM amigos WHERE id_user1 = "+int_inAmigo+";");
			resultado = sentencia_preparada.executeQuery();
			if (resultado.next()) {
				eliminarAmigos(idAmigo, miId);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "El ID no es tu amigo.","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);

			}
						
			sentencia_preparada.close();
			
		} catch (Exception e) {
			
			System.out.println("No se ha podido comprobar los amigos.");
			System.out.println(e);
		}
	}
	
	private void eliminarAmigos(String idAmigo, String miId) {
		Connection conexion = null;
		
		int int_idAmigos = Integer.parseInt(idAmigo);
		int int_miId = Integer.parseInt(miId);
		
		try {
				conexion = Conexion.conex();
								
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("DELETE FROM `amigos` WHERE id_user1 = "+int_idAmigos+" AND id_user2 = "+miId+";");
				int resultado_amigos = sentencia_preparada.executeUpdate();
				
				JOptionPane.showMessageDialog(new JFrame(), "Amigo Eliminado", "ProPlay IT - Amigo", JOptionPane.INFORMATION_MESSAGE);
				
				sentencia_preparada.close();
				
		
			
		} catch (SQLException e) {
			System.out.println("No se a podido añadi rel amigo");
			System.out.println(e);
		}

}
	
	
	
	//-------------------------------------Tabla Amigo
	public void mostrarTablaAMigo(JTable tabla, String miId) {
	
	Connection conexion = null;
	int int_miId = Integer.parseInt(miId);
	DefaultTableModel model = new DefaultTableModel();
	
	
	try {
		
		model.addColumn("Usuario");
		model.addColumn("Id");
		
		tabla.setModel(model);
		
		String [] dato = new String[2];
		
			conexion = Conexion.conex();
			
			PreparedStatement sentencia_userid = (PreparedStatement) conexion.prepareStatement("SELECT id_user1 FROM amigos WHERE id_user2="+int_miId+";");
			ResultSet resultado_userid = sentencia_userid.executeQuery();
			int id_user1 = 0;
			while (resultado_userid.next()) {
				id_user1=resultado_userid.getInt(1);
				
				sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT User,Id FROM `usuarios` WHERE  Id ="+id_user1+";");
				resultado = sentencia_preparada.executeQuery();
				if (resultado.next()) {
					
						dato[0]=resultado.getString("User");
						dato[1]=resultado.getString("Id");
						model.addRow(dato);
						
				}
				
			}			
			
			sentencia_preparada.close();
			sentencia_userid.close();
			
	
		
	} catch (SQLException e) {
		System.out.println("No se a podido mostrar la tabla");
		System.out.println(e);
	}
	
	}
	
	
	//---------------------------------------
	
	//---------------------------------------Libreria
	public String listaLibreria(String user) {
		
		Connection conexion = null;
		String result = "";
	
		
		
		try {
			
			PreparedStatement sentencia_lib = null;
			conexion = Conexion.conex();
			int id_user = sacarelid(user);	
			int id_juegos = 0;	
			
			
			sentencia_preparada = (PreparedStatement) conexion.prepareStatement("SELECT id_juegos FROM listas_juegos WHERE id_usuarios="+id_user+";");
			resultado = sentencia_preparada.executeQuery();
			while (resultado.next()) {		
				id_juegos = resultado.getInt(1);
				sentencia_lib = (PreparedStatement) conexion.prepareStatement("SELECT Titulo, Descripcion FROM juegos WHERE Id="+id_juegos+";");
				ResultSet result_lib = sentencia_lib.executeQuery();
				if (result_lib.next()) {
					result += "- "+result_lib.getString(1)+":\n"+result_lib.getString(2)+"\n";		
				}
			}
				
		sentencia_lib.close();
		sentencia_preparada.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "No tienes juegos", "ProPlay IT - Libreria", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(e);
		} 
		
		return result;
		
	}
	//-------------------------------------------------------
	
}
	
	