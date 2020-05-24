package ProPlay.Clases.PagPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import ProPlay.Clases.Amigos.Amigos;
import ProPlay.Clases.AtencionCliente.AtencionClient;
import ProPlay.Clases.Libreria.Libreria;
import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.Sql.Metodos_SQL;
import ProPlay.Clases.Tienda.FrameShopJuegos;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana_pagina_principal extends JFrame {

	/*
	 * En esta App hay labels vacios que se van llenado al llamarlo
	 */
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
	
	/**
	 * Create the frame.
	 */
	
	public Ventana_pagina_principal() {
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_pagina_principal.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - Inicio");
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
		
		JButton btnLibrary = new JButton("Libreria");//Boton para acceder a la ventana de Libreria
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libreria lib = new Libreria();//Objeto de la libreria
				
				fich.escribirLibreria(lblUser.getText());//Llamamos al metodo que va a escribir los juegos en el archivo md de libreria
				lib.textListaJuegos.setText(fich.leerLibreria());//utilizamos el metodo leerLibreria para escribir el texxtPane de la ventana libreria, gracias a que el elemento esta Publico
				
				lib.lblUser.setText(lblUser.getText());//Pasamos el nombre del usuario al label de la otra ventana 
				lib.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));//Utilizamos el metodo actualizarmoneda para llenar el label de la moneda de la  ventana de libreria.
				
				lib.setVisible(true);//ponemos la ventana visible
				dispose();//minimizamos esta ventana
				
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
		
		JButton btnShop = new JButton("Tienda");// Boton de la tienda
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameShopJuegos shop = new FrameShopJuegos();//Objeto de la tienda de juegos
				shop.lblUser.setText(lblUser.getText());
				shop.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));	
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
				amg.lblUserId.setText(sql.actualizarUserId(lblUser.getText()));//Actualizamos la moneda
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
				html.abrirhtml();//utilizamos este metod de la clase AtencionCliente para abrir ekl html del formulario de la APP
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
		
		JPanel panelNovedades = new JPanel();
		panelNovedades.setBackground(new Color(169, 169, 169));
		panelNovedades.setBounds(190, 95, 641, 564);
		contentPane.add(panelNovedades);
		panelNovedades.setLayout(null);
		
		JTextPane txtpnActualizacion = new JTextPane();//Novedades
		txtpnActualizacion.setEditable(false);
		txtpnActualizacion.setBounds(10, 52, 414, 152);
		txtpnActualizacion.setText("- Actualizacion 2.0:\r\nEsta actualizacion tarta de cambiar la interfaz, a\u00E1dir mas juegos.\r\n\r\n\r\n- Contratos:\r\nVamos a contratar a mas programadores.\r\n\r\n\r\nAndro4all: noticias, apps, juegos, smartphones, trucos y tutoriales para Android\r\n\r\n    Ofertas m\u00F3vilesNoticiasAn\u00E1lisisTrucosGu\u00EDasComprasListasM\u00F3vilesAppsJuegosPersonalizaci\u00F3n \r\n\r\nPortada \u00BB Noticias \u00BB Aplicaciones\r\n\u00D7\r\n\u00A1Destacado! Samsung Galaxy Z Flip, tres meses despu\u00E9s: algo m\u00E1s que un experimento\r\nNoticias de apps para m\u00F3viles Android: \u00FAltimas novedades\r\n\r\nConoce la \u00FAltima hora sobre las aplicaciones para Android: noticias, actualizaciones, nuevas incorporaciones a Google Play, y mucho m\u00E1s.\r\n\r\nSi quieres leer las \u00FAltimas novedades sobre WhatsApp, visita nuestra secci\u00F3n dedicada.\r\n\r\nY si lo que te interesan son los juegos, visitas nuestra secci\u00F3n de noticias de juegos Android para estar al tanto de las \u00FAltimas novedades del sector.\r\nNoticias sobre Aplicaciones\r\nDRAGON QUEST, Bulb Boy y muchos otros juegazos (y apps) de pago para Android en oferta o gratis\r\n\r\nPublicado por Christian Collado el 22/05/2020 @ 19:01\r\nGoogle Play Store, apps y juegos\r\n\r\n0\r\n\r\nComo cada viernes, antes de despedir la semana, llega el momento de seleccionar las mejores ofertas en apps y juegos de pago para Android que los desarrolladores que dan forma a Google Play han decidido brindarnos en esta ocasi\u00F3n. En esta ocasi\u00F3n, entre los chollos seleccionados, es posible encontrar juegazos como los de la saga DRAGON QUEST o Bulb Boy, as\u00ED como aplicaciones como CryptoTab Browser, PDF Editor y otras... Continuar leyendo...\r\nLos mejores juegos y apps nuevos para Android de esta semana\r\n\r\nPublicado por Christian Collado el 22/05/2020 @ 14:12\r\nApps Android en el Realme X50 Pro\r\n\r\n0\r\n\r\nSi lo que est\u00E1s buscando son nuevas apps y juegos para probar este fin de semana, est\u00E1s de enhorabuena porque te traemos unas cuentas que no dejar\u00E1n indiferente a nadie. Como hemos hecho todos los viernes de cada semana durante los \u00FAltimos meses, una vez m\u00E1s vamos en busca de las mejores novedades que han aterrizado en Google Play estos \u00FAltimos d\u00EDas. Cada semana \u2013siempre y cuando los nuevos lanzamientos... Continuar leyendo...\r\nFacebook lanza Shops, una nueva forma de comprar m\u00E1s y mejor en la red social\r\n\r\nPublicado por Nacho Casta\u00F1\u00F3n el 20/05/2020 @ 11:01\r\nFacebook Shops\r\n\r\n0\r\n\r\nFacebook, que recientemente ha cambiado pro completo su dise\u00F1o, sigue trabajando en la llegada de nuevo contenido con el que mantener a sus usuarios. Tras estrenar una app para su plataforma de juegos; la compa\u00F1\u00EDa formada por Mark Zuckerberg ha lanzado Shops, una nueva forma de comprar m\u00E1s y mejor en la red social, y de la que te contamos qu\u00E9 es y todo lo que debes saber. Una nueva... Continuar leyendo...\r\nAverigua cu\u00E1ndo y c\u00F3mo puedes salir de casa con esta app para la desescalada del coronavirus\r\n\r\nPublicado por Dami\u00E1n Garc\u00EDa el 19/05/2020 @ 17:01\r\n\r\n0\r\n\r\nSeguro que estos d\u00EDas escuchando a Pedro S\u00E1nchez, Fernando Sim\u00F3n o Salvador Illa, durante sus m\u00FAltiples conferencias de prensa para explicar la evoluci\u00F3n de la pandemia provocada por la COVID-19, habr\u00E1s pensado que hace falta un t\u00EDtulo universitario de epidemi\u00F3logo o similar para entender c\u00F3mo demonios funciona esto de la desescalada en Espa\u00F1a. Y no es para menos, porque este sistema de fases asim\u00E9tricas asignadas casi por zonas o municipios... Continuar leyendo...\r\n53 apps y juegos en oferta o gratis en Google Play: PDF Editor, Kensh\u014D, Siege of Dragonspear y m\u00E1s\r\n\r\nPublicado por Christian Collado el 19/05/2020 @ 12:05\r\nTema oscuro en Google Play Store\r\n\r\n0\r\n\r\nComo cada inicio de semana, los desarrolladores que dan vida a Google Play Store han querido obsequiarnos con nuevas ofertas en algunas de sus mejores aplicaciones, juegos y herramientas de personalizaci\u00F3n para Android. En esta ocasi\u00F3n, entre los chollos seleccionados podemos encontrar juegazos como Black Paradox, Binary Fun, Siege of Dragonspear y muchos otros t\u00EDtulos, as\u00ED como aplicaciones y herramientas \u00FAtiles que podr\u00E1s conseguir con descuento o totalmente gratis, solo... Continuar leyendo...");
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 46, 621, 508);
		scrollPane.add(txtpnActualizacion);
		panelNovedades.add(scrollPane);
		
		JLabel lblTitle = new JLabel("Novedades");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(279, 11, 95, 29);
		panelNovedades.add(lblTitle);
		
		JLabel lblNewLabel = new JLabel("By Rafael Oliva Ramirez");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(451, 662, 139, 30);
		contentPane.add(lblNewLabel);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {//Si le clickeamos al logo nos llevara a la pagina principal
				
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
		
		JLabel lblLogout = new JLabel("Logout");//Boton para desloguears
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				fich.vaciarRecordar();//Vacia el contenido del fichero txt
				
				Login l = new Login();//Y te lleva a la ventana de login
				l.setVisible(true);
				dispose();				
				
			}
		});
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBounds(918, 74, 51, 20);
		contentPane.add(lblLogout);
		
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
				
				fich.vaciarRecordar();
				sql.eliminarListaJuegos(lblUser.getText());
				sql.eliminaramigos(lblUser.getText());
				sql.eliminarUser(lblUser.getText());
				Login l = new Login();
				
				fich.vaciarRecordar();
				
				l.setVisible(true);
				dispose();	
				
			}
		});
		btnEliminarCuenta.setBounds(842, 670, 208, 23);
		contentPane.add(btnEliminarCuenta);
		
		
	}
}
