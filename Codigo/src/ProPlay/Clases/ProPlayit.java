package ProPlay.Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;

public class ProPlayit {
	
	private static Login log = new Login();
	private static MetodoFichero mf;//Metodo de fichero
	
	public static void inicio() {
		
		try {
			
			FileReader leerUser = new FileReader("src/ProPlay/Ficheros/Recordar_login_user.txt");//Archivo de texto para recordar el usuario
			FileReader leerPasswd = new FileReader("src/ProPlay/Ficheros/Recordar_login_passwd.txt");//Archivo de texto para recordar la contraseña

			int comprobUser = leerUser.read();//Esta leyendo el archivo donde se almacena el usuario. Formtao Int
			int comprobPasswd = leerPasswd.read();//Esta leyendo el archivo donde se almacena la contraseña del usuario. Formato Int
			
			if (comprobUser > 0 || comprobPasswd > 0) {//Si tiene dato abre el metodo recordar de la clase MetodoFichero
								
				mf.recordar();
					
			} else {//Si no se abre la pagina para loguearse
				
				log.setVisible(true);
			
			}
						
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
		
	}
	
}
