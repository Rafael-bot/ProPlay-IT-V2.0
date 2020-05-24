package ProPlay.Clases.Videos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import ProPlay.Clases.Sql.Conexion;
import ProPlay.Clases.Sql.Metodos_SQL;
import ProPlay.Clases.Tienda.FrameMonedas;
import ProPlay.Clases.Tienda.FrameShopJuegos;


public class Videos{
	
	private Metodos_SQL sql = new Metodos_SQL();
	private FrameMonedas money;
		
	
	public void video1(String user) {//metodo para ver los videos
		  
	      String url = "src\\ProPlay\\Ficheros\\Video1.html"; 
		 
	        ProcessBuilder p = new ProcessBuilder();
	        p.command("cmd.exe", "/c", url);
	        try {
	        p.start();
	        
	        cronoVideos(69, 5.00,user);
	        
	        money = new FrameMonedas();//Te lleva al apartado de videos con la moneda actualizada
			money.labelMonedas.setText(sql.actualizarmoneda(user));
			money.lblUser.setText(user);
			money.setVisible(true);
	        		
	        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        }
	 }
		
	public void video2(String user) {
		  
	      String url = "src\\ProPlay\\Ficheros\\Video2.html"; 
		 
	        ProcessBuilder p = new ProcessBuilder();
	        p.command("cmd.exe", "/c", url);
	        try {
	        p.start();
	        
	        cronoVideos(21, 10.00,user);
	        
	        money = new FrameMonedas();
			money.labelMonedas.setText(sql.actualizarmoneda(user));
			money.lblUser.setText(user);
			money.setVisible(true);
			
	        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        }
	 }
	
	public void video3(String user) {
		  
	      String url = "src\\ProPlay\\Ficheros\\Video3.html"; 
		 
	        ProcessBuilder p = new ProcessBuilder();
	        p.command("cmd.exe", "/c", url);
	        try {
	        p.start();
	        
	        cronoVideos(24, 7.00,user);
	        
	        
	        money = new FrameMonedas();
			money.labelMonedas.setText(sql.actualizarmoneda(user));
			money.lblUser.setText(user);
			money.setVisible(true);
			
	        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        }
	 }
	
	public void video4(String user) {
		  
	      String url = "src\\ProPlay\\Ficheros\\Video4.html"; 
		 
	        ProcessBuilder p = new ProcessBuilder();
	        p.command("cmd.exe", "/c", url);
	        try {
	        p.start();
	        
	        cronoVideos(50, 15.00, user);
	        
	        money = new FrameMonedas();
			money.labelMonedas.setText(sql.actualizarmoneda(user));
			money.lblUser.setText(user);
			money.setVisible(true);
	        
	        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        }
	 }
	
	public void video5(String user) {
		  
	      String url = "src\\ProPlay\\Ficheros\\Video5.html"; 
		 
	        ProcessBuilder p = new ProcessBuilder();
	        p.command("cmd.exe", "/c", url);
	        try {
	        p.start();
	        
	        cronoVideos(5, 14.00, user);
	        
	        money = new FrameMonedas();
			money.labelMonedas.setText(sql.actualizarmoneda(user));
			money.lblUser.setText(user);
			money.setVisible(true);
	        
	        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        }
	 }
	
	public void video6(String user) {
		  
	      String url = "src\\ProPlay\\Ficheros\\Video6.html"; 
		 
	        ProcessBuilder p = new ProcessBuilder();
	        p.command("cmd.exe", "/c", url);
	        try {
	        p.start();
	        
	        cronoVideos(9, 2.00, user);
	        
	        money = new FrameMonedas();
			money.labelMonedas.setText(sql.actualizarmoneda(user));
			money.lblUser.setText(user);
			money.setVisible(true);
	        
	        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        }
	 }
	
	public void cronoVideos(int segundos, double puntos, String user) {
				
		for (int cont = 0; cont <= segundos; cont++) {//temporizador
			try {
				
				Thread.sleep(1000);
				
			} catch (Exception e) {}
		}
			
		JOptionPane.showMessageDialog(new JFrame(), "Video visto correctamente. Has ganado "+puntos+" Puntos.","ProPlay IT - Obtencion de Monedas",JOptionPane.INFORMATION_MESSAGE);
		sql.ingresarMoneda(puntos, user);	
		
		
	}		
	
}
