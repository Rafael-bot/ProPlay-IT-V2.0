package ProPlay.Clases.MetodosFicheros;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;

public class MetodoFichero {
	
	private static Ventana_pagina_principal principal = new Ventana_pagina_principal();// Objeto que utilizamos para anrir la ventana de la pagina principal.
	private static Metodos_SQL sql = new Metodos_SQL();//Objeto de donde extraemos y utilizamos los metodo sql
	
//-------------------------------------------Login
	public static void recordar() {//Metodo donde lee los dos archivos de texto y almacena en un string el usuario.
		
		try {
			
			FileReader leerUser = new FileReader("src/ProPlay/Ficheros/Recordar_login_user.txt");//indicamos la ruta del archivo
			BufferedReader br = new BufferedReader(leerUser);

			FileReader leerPasswd = new FileReader("src/ProPlay/Ficheros/Recordar_login_passwd.txt");//indicamos la ruta del archivo
				
				int c=0;
				String texto = "";//Aqui se guarda la lina de texto que esta leyendo
				String text = "";//Aqui se va a almacenar
				
				while((texto=br.readLine())!=null){//Con este while se va rellenando la variable
			            text = texto;
			    }
									
				principal.labelMonedas.setText(sql.actualizarmoneda(text));//El label de la moneda no tiene nada. Se lo llenamos que el settext que lo extraemos de la base de datos gracias al metodo actualizarmoneda
				principal.lblUser.setText(text);//Utilizamos la variable text para poner el nombre del usuario en el label de la pagina principal
				principal.setVisible(true);	//Para que se vea la pagina
				
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
	
	}
	
	public static void escribRecordar(String user, String passwd) {
		
		
		FileWriter escribirUser;
		FileWriter escribirPasswd;
		
		BufferedWriter buferUser;
		BufferedWriter buferPasswd;
		
		PrintWriter printUser;
		PrintWriter printPasswd;
		
		try {
			
			escribirUser = new FileWriter("src/ProPlay/Ficheros/Recordar_login_user.txt");
			escribirPasswd = new FileWriter("src/ProPlay/Ficheros/Recordar_login_passwd.txt");
			
			buferUser = new BufferedWriter(escribirUser);
			printUser = new PrintWriter(escribirUser);
			escribirUser.write(user);
			
			escribirUser.close();
			buferUser.close();
			
			buferPasswd = new BufferedWriter(escribirPasswd);
			printPasswd = new PrintWriter(escribirPasswd);
			escribirPasswd.write(passwd);
			
			escribirPasswd.close();
			buferPasswd.close();
			
			
						
		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}
	}
	
	public static void vaciarRecordar() {
		
		
		FileWriter escribirUser;
		FileWriter escribirPasswd;
		
		BufferedWriter buferUser;
		BufferedWriter buferPasswd;
		
		PrintWriter printUser;
		PrintWriter printPasswd;
		
		try {
			
			escribirUser = new FileWriter("src/ProPlay/Ficheros/Recordar_login_user.txt");
			escribirPasswd = new FileWriter("src/ProPlay/Ficheros/Recordar_login_passwd.txt");
			
			buferUser = new BufferedWriter(escribirUser);
			printUser = new PrintWriter(escribirUser);
			escribirUser.write("");
			
			escribirUser.close();
			buferUser.close();
			
			buferPasswd = new BufferedWriter(escribirPasswd);
			printPasswd = new PrintWriter(escribirPasswd);
			escribirPasswd.write("");
			
			escribirPasswd.close();
			buferPasswd.close();
			
			
						
		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}
	}
	//-----------------------------------------------------------------------------------------
	
	//-------------------------------------Factura
	public void escribirFactura(String moneyjuego, String moneyiva, String titulo, String creditouser, String user) {
	
		FileWriter escribirFactura;
		BufferedWriter buferFactura;
		PrintWriter printFactura;
		
		try {
			
			double total = Double.parseDouble(sql.getPreciojuegoSumaTotal(titulo));
			
			escribirFactura = new FileWriter("src/ProPlay/Ficheros/Factura_compra.md");
			
			buferFactura = new BufferedWriter(escribirFactura);
			printFactura = new PrintWriter(escribirFactura);
			escribirFactura.write(" Juego: "+moneyjuego+"\n Iva:"+moneyiva+"\n Total:"+sql.getPreciojuegoSumaTotal(titulo)+"\n Dinero del usuario: "+creditouser+"\n Cuenta: "+sql.getPreciojuegoSumaTotal(titulo)+"-"+creditouser+"="+sql.actualizarmoneda(user));

			escribirFactura.close();
			buferFactura.close();
			
			
						
		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}
	}
	
	public void vaciarfactura() {
		
		FileWriter escribirFactura;
		BufferedWriter buferFactura;
		PrintWriter printFactura;
		
		try {
			
			escribirFactura = new FileWriter("src/ProPlay/Ficheros/Factura_compra.md");
			
			buferFactura = new BufferedWriter(escribirFactura);
			printFactura = new PrintWriter(escribirFactura);
			escribirFactura.write("");

			escribirFactura.close();
			buferFactura.close();
			
			
						
		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}
	}
	
	public String leerfactura() {
		
		String result = "";
		
		try {
			
			FileReader leerUser = new FileReader("src/ProPlay/Ficheros/Factura_compra.md");
			BufferedReader br = new BufferedReader(leerUser);

			
				
				int c=0;
				String texto = "";
								
				while((texto=br.readLine())!=null) {
					result+=texto+"\n";
				}
				
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
		
		return result;		
		
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	//-------------------------------------------------------Libreria
	public void escribirLibreria(String user) {
		
		FileWriter escribirFactura;
		BufferedWriter buferFactura;
		PrintWriter printFactura;
		
		try {
			
			escribirFactura = new FileWriter("src/ProPlay/Ficheros/Lista_juegos_usuario.md");
			
			buferFactura = new BufferedWriter(escribirFactura);
			printFactura = new PrintWriter(escribirFactura);
			escribirFactura.write(sql.listaLibreria(user));

			escribirFactura.close();
			buferFactura.close();
			
			
						
		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}
		
	}
	
	public String leerLibreria() {
		
		String result = "";
		
		try {
			
			FileReader leerUser = new FileReader("src/ProPlay/Ficheros/Lista_juegos_usuario.md");
			BufferedReader br = new BufferedReader(leerUser);

			
				
				int c=0;
				String texto = "";
								
				while((texto=br.readLine())!=null) {
					result+=texto+"\n";
				}
				
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
		
		return result;		
		
	}
	
	public void vaciarLibreria() {
		
		FileWriter escribirFactura;
		BufferedWriter buferFactura;
		PrintWriter printFactura;
		
		try {
			
			escribirFactura = new FileWriter("src/ProPlay/Ficheros/Lista_juegos_usuario.md");
			
			buferFactura = new BufferedWriter(escribirFactura);
			printFactura = new PrintWriter(escribirFactura);
			escribirFactura.write("");

			escribirFactura.close();
			buferFactura.close();
			
			
						
		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}
	}
	
	
	//-----------------------------------------------
	
	

}
