package ProPlay.Clases.AtencionCliente;

public class AtencionClient {
	
	public void abrirhtml() {
		  
	      String url = "src\\ProPlay\\Ficheros\\Contacta.html"; //Ruta del archivo html
		 
	        ProcessBuilder p = new ProcessBuilder();//Aqui he creado la variable para despues ejecutar el comando
	        p.command("cmd.exe", "/c", url);//Ejecuta el comando en la cmd 
	        try {
	        p.start();//Se abre la pagina web
	        } catch (Exception e) {
	        System.out.println("no se ha encontrado el archivo");//Mensaje si peta
	        e.printStackTrace();
	        }
	        }
	
	 }
	
	

