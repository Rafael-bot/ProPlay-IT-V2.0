package ProPlay.Clases.Libreria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ProPlay.Clases.Amigos.Amigos;
import ProPlay.Clases.AtencionCliente.AtencionClient;
import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;
import ProPlay.Clases.Tienda.FrameShopJuegos;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Libreria extends JFrame {

	private JPanel contentPane;
	public JLabel lblUser;
	private ImageIcon icon;
	private Image image;
	private Image modifiImage;
	private JLabel lblLogo;
	private MetodoFichero fich = new MetodoFichero();
	public JLabel labelMonedas;
	private static Metodos_SQL sql = new Metodos_SQL();
	private AtencionClient html = new AtencionClient();
	public JTextPane textListaJuegos;


	/**
	 * Create the frame.
	 */
	public Libreria() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Libreria.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - Libreria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1088, 732);
		
		contentPane = new JPanel();
		contentPane.setDoubleBuffered(false);
		contentPane.setFocusable(false);
		contentPane.setFocusTraversalKeysEnabled(false);
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUser = new JLabel("",SwingConstants.CENTER);
		lblUser.setOpaque(true);
		lblUser.setBackground(new Color(169, 169, 169));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBorder(null);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBounds(890, 22, 170, 53);
		contentPane.add(lblUser);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(169, 169, 169));
		panelMenu.setBounds(842, 115, 220, 544);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnLibrary = new JButton("Libreria");
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fich.vaciarLibreria();
				Libreria lib = new Libreria();
				lib.lblUser.setText(lblUser.getText());
				lib.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));//Mostramos la moneda
				fich.escribirLibreria(lblUser.getText());//Este metodo lo que hace es escribir en el fichero txt los juegos del usuario
				lib.textListaJuegos.setText(fich.leerLibreria());//Aqui lo que esta haciendo es escribir los juegos del usuario con el metodo leerLibreria
				lib.setVisible(true);
				dispose();//Miminizamos esta ventana
			}
		});
		btnLibrary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLibrary.setForeground(new Color(255, 255, 255));
		btnLibrary.setBackground(new Color(128, 128, 128));
		btnLibrary.setBorder(null);
		btnLibrary.setFocusable(false);
		btnLibrary.setFocusTraversalKeysEnabled(false);
		btnLibrary.setFocusPainted(false);
		btnLibrary.setBounds(10, 11, 200, 42);
		panelMenu.add(btnLibrary);
		
		JButton btnShop = new JButton("Tienda");
		btnShop.addActionListener(new ActionListener() {//Con este boton nos vamos a la tienda
			public void actionPerformed(ActionEvent e) {
				fich.vaciarLibreria();//Este metodo lo que hace es vaciar el fichero txt de la libreria
				FrameShopJuegos shop = new FrameShopJuegos();//Noss vamos a la ventana de Tienda
				shop.lblUser.setText(lblUser.getText());
				shop.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));//INgresamos las monedas
				shop.setVisible(true);
				dispose();
			}
		});
		btnShop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShop.setBackground(new Color(128, 128, 128));
		btnShop.setForeground(new Color(255, 255, 255));
		btnShop.setBorder(null);
		btnShop.setFocusPainted(false);
		btnShop.setFocusTraversalKeysEnabled(false);
		btnShop.setFocusable(false);
		btnShop.setBounds(10, 83, 200, 42);
		panelMenu.add(btnShop);
		
		JButton btnFriends = new JButton("Amigos");
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Amigos amg = new Amigos();
				amg.lblUser.setText(lblUser.getText());
				amg.lblUserId.setText(sql.actualizarUserId(lblUser.getText()));//insertamos el id del usuario en el label de la ventana de amigo, utilizamos el motodo actualizarUserId loq ue hace es obtener el Id del usuario
				amg.setVisible(true);
			}
		});
		btnFriends.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFriends.setForeground(new Color(255, 255, 255));
		btnFriends.setBackground(new Color(128, 128, 128));
		btnFriends.setBorder(null);
		btnFriends.setFocusTraversalKeysEnabled(false);
		btnFriends.setFocusPainted(false);
		btnFriends.setFocusable(false);
		btnFriends.setBounds(10, 159, 200, 42);
		panelMenu.add(btnFriends);
		
		JButton btnAtencionClient = new JButton("Atenci\u00F3n Client");
		btnAtencionClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				html.abrirhtml();//Abre la pagina de atencion al cliente
			}
		});
		btnAtencionClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtencionClient.setForeground(new Color(255, 255, 255));
		btnAtencionClient.setBackground(new Color(128, 128, 128));
		btnAtencionClient.setBorder(null);
		btnAtencionClient.setFocusPainted(false);
		btnAtencionClient.setFocusTraversalKeysEnabled(false);
		btnAtencionClient.setFocusable(false);
		btnAtencionClient.setBounds(10, 491, 200, 42);
		panelMenu.add(btnAtencionClient);
		
		JLabel lblNewLabel = new JLabel("By Rafael Oliva Ramirez");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(449, 629, 139, 30);
		contentPane.add(lblNewLabel);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Ventana_pagina_principal principal = new Ventana_pagina_principal();
				principal.lblUser.setText(lblUser.getText());
				principal.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));	
				principal.setVisible(true);
				dispose();				
				
			}
		});
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/logo_size_invert.jpg"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(180,100, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelLogo.setIcon(icon);
		labelLogo.setBounds(10, 22, 170, 71);
		contentPane.add(labelLogo);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Login l = new Login();
				
				fich.vaciarRecordar();//Llamamoa al metodo de vaciar Recordar que lo que hace es vaciar el archivo txt
				
				l.setVisible(true);//Nos vamos a l aventana de login
				dispose();				
				
			}
		});
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBounds(968, 73, 51, 20);
		contentPane.add(lblLogout);
		
		JPanel panelLibreria = new JPanel();
		panelLibreria.setBackground(new Color(169, 169, 169));
		panelLibreria.setBounds(181, 115, 651, 516);
		contentPane.add(panelLibreria);
		panelLibreria.setLayout(null);
		
		textListaJuegos = new JTextPane();
		textListaJuegos.setEditable(false);
		textListaJuegos.setBounds(10, 11, 483, 494);
		panelLibreria.add(textListaJuegos);
	
		JLabel lblLibPanelDerecha = new JLabel("");
		lblLibPanelDerecha.setOpaque(true);
		lblLibPanelDerecha.setBackground(new Color(128, 128, 128));
		lblLibPanelDerecha.setBorder(null);
		lblLibPanelDerecha.setBounds(503, 11, 138, 494);
		panelLibreria.add(lblLibPanelDerecha);
	       
	       
		JLabel lblLibreria = new JLabel("Libreria");
		lblLibreria.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLibreria.setForeground(new Color(255, 255, 255));
		lblLibreria.setBounds(449, 60, 96, 40);
		contentPane.add(lblLibreria);
		
		labelMonedas = new JLabel("");
		labelMonedas.setForeground(Color.WHITE);
		labelMonedas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMonedas.setBounds(829, 22, 66, 53);
		contentPane.add(labelMonedas);
		
		JButton btnEliminarCuenta = new JButton("Eliminar este Usuario");
		btnEliminarCuenta.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEliminarCuenta.setForeground(Color.WHITE);
		btnEliminarCuenta.setBackground(Color.RED);
		btnEliminarCuenta.setBorderPainted(false);
		btnEliminarCuenta.setFocusTraversalKeysEnabled(false);
		btnEliminarCuenta.setFocusPainted(false);
		btnEliminarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fich.vaciarRecordar();//Llamamoa al metodo de vaciar Recordar que lo que hace es vaciar el archivo txt
				sql.eliminarListaJuegos(lblUser.getText());//Eliminamos los juegos comparados por usuario eliminado 
				sql.eliminaramigos(lblUser.getText());//Eliminamos la relacion de amigos que tienes con otros usuarios
				sql.eliminarUser(lblUser.getText());//Eliminamos al usuario de la base de datos
				
				Login l = new Login();
				
				fich.vaciarRecordar();//Vaciomos  el archivo txt 
				
				l.setVisible(true);
				dispose();	
				
			}
		});
		btnEliminarCuenta.setBounds(852, 667, 208, 23);
		contentPane.add(btnEliminarCuenta);
		
		
	}
	
	
	
}
