package ProPlay.Clases.Tienda;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ProPlay.Clases.Amigos.Amigos;
import ProPlay.Clases.AtencionCliente.AtencionClient;
import ProPlay.Clases.Factura.Factura;
import ProPlay.Clases.Libreria.Libreria;
import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;


import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JTextField;

public class FrameShopJuegos extends JFrame {

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
	private Factura fact = new Factura();
	
		
	
	/**
	 * Create the frame.
	 */
	public FrameShopJuegos() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameShopJuegos.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - Tienda - Juegos");
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
				Libreria lib = new Libreria();
				lib.lblUser.setText(lblUser.getText());
				lib.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));	
				fich.escribirLibreria(lblUser.getText());
				lib.textListaJuegos.setText(fich.leerLibreria());
				lib.setVisible(true);
				dispose();
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
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameShopJuegos shop = new FrameShopJuegos();
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
				amg.lblUserId.setText(sql.actualizarUserId(lblUser.getText()));
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
				html.abrirhtml();
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
				
				fich.vaciarRecordar();
				
				l.setVisible(true);
				dispose();				
				
			}
		});
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBounds(954, 74, 51, 20);
		contentPane.add(lblLogout);
		
		JLabel lblTienda = new JLabel("Tienda");
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTienda.setForeground(new Color(255, 255, 255));
		lblTienda.setBounds(449, 60, 96, 40);
		contentPane.add(lblTienda);
		
		JPanel panelShop = new JPanel();
		panelShop.setBackground(new Color(169, 169, 169));
		panelShop.setBounds(20, 112, 812, 518);
		contentPane.add(panelShop);
		panelShop.setLayout(null);
		
		
		JPanel panelJuegos = new JPanel();
		panelJuegos.setBounds(0, 38, 812, 480);
		panelShop.add(panelJuegos);
		panelJuegos.setLayout(null);
		
		
		//Juego 1
		
		JLabel lblTituloJuego1 = new JLabel("Brawhalla", SwingConstants.CENTER);
		lblTituloJuego1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloJuego1.setForeground(new Color(255, 255, 255));
		lblTituloJuego1.setBounds(10, 11, 203, 26);
		panelJuegos.add(lblTituloJuego1);
		
		JLabel labelFotoJuego1 = new JLabel("");
		icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego1.getText())));//Obtenemos la ruta desde la base de datos
		image = icon.getImage();
		modifiImage = image.getScaledInstance(200,180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoJuego1.setIcon(icon);
		labelFotoJuego1.setBounds(10, 35, 203, 136);
		panelJuegos.add(labelFotoJuego1);
		
		JLabel lblPrecioJ1 = new JLabel("Precio:");
		lblPrecioJ1.setForeground(new Color(255, 255, 255));
		lblPrecioJ1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioJ1.setBounds(20, 172, 46, 14);
		panelJuegos.add(lblPrecioJ1);
		
		JLabel labelPrecioSimbolo = new JLabel("\u20AC");
		labelPrecioSimbolo.setForeground(Color.WHITE);
		labelPrecioSimbolo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioSimbolo.setBounds(110, 173, 18, 13);
		panelJuegos.add(labelPrecioSimbolo);
		
		JLabel labelPrecioJuego1 = new JLabel("");
		labelPrecioJuego1.setForeground(new Color(255, 255, 255));
		labelPrecioJuego1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioJuego1.setText(sql.getPreciojuego(lblTituloJuego1.getText()));
		labelPrecioJuego1.setBounds(71, 174, 46, 12);
		panelJuegos.add(labelPrecioJuego1);
		
		JButton btnComprar1 = new JButton("Comprar");
		btnComprar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sql.Stock(lblTituloJuego1.getText()) == 0) {//Si el juegos no se le ha acabado el stock , le saltara un mensaje
					JOptionPane.showMessageDialog(new JFrame(), "Stock vacio", "ProPlay IT - Error - Stock", JOptionPane.WARNING_MESSAGE);
				}else {
					icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego1.getText())));
					image = icon.getImage();
					modifiImage = image.getScaledInstance(230,180, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(modifiImage);
					fact.labelFotoJuego.setIcon(icon);//Le pasamos la imagen del juego al label de la foto del juego en la factura
					fact.labelTituloJuegos2.setText(lblTituloJuego1.getText());
					fact.labelPrecioJuego.setText(sql.getPreciojuego(lblTituloJuego1.getText()));//le pasamos el precio del juego
					fact.labelPreciJuego.setText(sql.getPreciojuego(lblTituloJuego1.getText()));//le pasamos el precio del juego
					fact.labelTituloJuegos.setText(lblTituloJuego1.getText());//le pasamos el titulo del juego
					fact.labelPrecioTotal.setText(sql.getPreciojuegoSumaTotal(lblTituloJuego1.getText()));				
					fact.lblUser.setText(lblUser.getText());				
					fact.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					fact.setVisible(true);
					dispose();
				}	
					
			}
		});
		btnComprar1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar1.setForeground(new Color(255, 255, 255));
		btnComprar1.setContentAreaFilled(false);
		btnComprar1.setFocusPainted(false);
		btnComprar1.setFocusTraversalKeysEnabled(false);
		btnComprar1.setFocusable(false);
		btnComprar1.setBounds(51, 197, 109, 23);
		panelJuegos.add(btnComprar1);
		
		//Juego 2
		
		JLabel lblTituloJuego2 = new JLabel("GTA V", SwingConstants.CENTER);
		lblTituloJuego2.setForeground(Color.WHITE);
		lblTituloJuego2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloJuego2.setBounds(261, 11, 203, 26);
		panelJuegos.add(lblTituloJuego2);
		

		JLabel labelFotoJuego2 = new JLabel("");
		icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego2.getText())));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(200,180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoJuego2.setIcon(icon);
		labelFotoJuego2.setBounds(261, 35, 203, 136);
		panelJuegos.add(labelFotoJuego2);
		
		JLabel lblPrecioJ2 = new JLabel("Precio:");
		lblPrecioJ2.setForeground(new Color(255, 255, 255));
		lblPrecioJ2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioJ2.setBounds(271, 172, 46, 14);
		panelJuegos.add(lblPrecioJ2);
		
		JLabel labelPrecioJuego2 = new JLabel("");
		labelPrecioJuego2.setForeground(new Color(255, 255, 255));
		labelPrecioJuego2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioJuego2.setText(sql.getPreciojuego(lblTituloJuego2.getText()));
		labelPrecioJuego2.setBounds(336, 173, 46, 12);
		panelJuegos.add(labelPrecioJuego2);
		
		JButton btnComprar2 = new JButton("Comprar");
		btnComprar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sql.Stock(lblTituloJuego2.getText()) == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Stock vacio", "ProPlay IT - Error - Stock", JOptionPane.WARNING_MESSAGE);
				}else {
					icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego2.getText())));
					image = icon.getImage();
					modifiImage = image.getScaledInstance(230,180, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(modifiImage);
					fact.labelFotoJuego.setIcon(icon);
					fact.labelTituloJuegos2.setText(lblTituloJuego2.getText());
					fact.labelPrecioJuego.setText(sql.getPreciojuego(lblTituloJuego2.getText()));
					fact.labelPreciJuego.setText(sql.getPreciojuego(lblTituloJuego2.getText()));
					fact.labelTituloJuegos.setText(lblTituloJuego2.getText());
					fact.labelPrecioTotal.setText(sql.getPreciojuegoSumaTotal(lblTituloJuego2.getText()));				
					fact.lblUser.setText(lblUser.getText());				
					fact.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					fact.setVisible(true);
					dispose();
				}	
					
			}
		});
		btnComprar2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar2.setForeground(new Color(255, 255, 255));
		btnComprar2.setContentAreaFilled(false);
		btnComprar2.setFocusPainted(false);
		btnComprar2.setFocusTraversalKeysEnabled(false);
		btnComprar2.setFocusable(false);
		btnComprar2.setBounds(306, 197, 109, 23);
		panelJuegos.add(btnComprar2);
		
		JLabel labelPrecioSimbolo2 = new JLabel("\u20AC");
		labelPrecioSimbolo2.setForeground(Color.WHITE);
		labelPrecioSimbolo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioSimbolo2.setBounds(380, 174, 18, 13);
		panelJuegos.add(labelPrecioSimbolo2);
		
		// JUego 3
				
		JLabel lblTituloJuego3 = new JLabel("Mario Kart", SwingConstants.CENTER);
		lblTituloJuego3.setForeground(Color.WHITE);
		lblTituloJuego3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloJuego3.setBounds(536, 11, 203, 26);
		panelJuegos.add(lblTituloJuego3);
		
		JLabel labelFotoJuego3 = new JLabel("");
		icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego3.getText())));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(200,180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoJuego3.setIcon(icon);
		labelFotoJuego3.setBounds(536, 35, 203, 136);
		panelJuegos.add(labelFotoJuego3);
		
		JLabel lblPrecioJ3 = new JLabel("Precio:");
		lblPrecioJ3.setForeground(new Color(255, 255, 255));
		lblPrecioJ3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioJ3.setBounds(546, 172, 46, 14);
		panelJuegos.add(lblPrecioJ3);
		
		JLabel labelPrecioJuego3 = new JLabel("");
		labelPrecioJuego3.setForeground(new Color(255, 255, 255));
		labelPrecioJuego3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioJuego3.setText(sql.getPreciojuego(lblTituloJuego3.getText()));
		labelPrecioJuego3.setBounds(602, 173, 46, 12);
		panelJuegos.add(labelPrecioJuego3);
		
		JButton btnComprar3 = new JButton("Comprar");
		btnComprar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sql.Stock(lblTituloJuego3.getText()) == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Stock vacio", "ProPlay IT - Error - Stock", JOptionPane.WARNING_MESSAGE);
				}else {
					icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego3.getText())));
					image = icon.getImage();
					modifiImage = image.getScaledInstance(230,180, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(modifiImage);
					fact.labelFotoJuego.setIcon(icon);
					fact.labelTituloJuegos2.setText(lblTituloJuego3.getText());
					fact.labelPrecioJuego.setText(sql.getPreciojuego(lblTituloJuego3.getText()));
					fact.labelPreciJuego.setText(sql.getPreciojuego(lblTituloJuego3.getText()));
					fact.labelTituloJuegos.setText(lblTituloJuego3.getText());
					fact.labelPrecioTotal.setText(sql.getPreciojuegoSumaTotal(lblTituloJuego3.getText()));				
					fact.lblUser.setText(lblUser.getText());				
					fact.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					fact.setVisible(true);
					dispose();
				}	
					
			}
		});
		btnComprar3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar3.setForeground(new Color(255, 255, 255));
		btnComprar3.setContentAreaFilled(false);
		btnComprar3.setFocusPainted(false);
		btnComprar3.setFocusTraversalKeysEnabled(false);
		btnComprar3.setFocusable(false);
		btnComprar3.setBounds(582, 197, 109, 23);
		panelJuegos.add(btnComprar3);
		
		JLabel labelPrecioSimbolo3 = new JLabel("\u20AC");
		labelPrecioSimbolo3.setForeground(Color.WHITE);
		labelPrecioSimbolo3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioSimbolo3.setBounds(649, 173, 18, 13);
		panelJuegos.add(labelPrecioSimbolo3);
		
		//Juego 4
		
		JLabel lblTituloJuego4 = new JLabel("Tetris", SwingConstants.CENTER);
		lblTituloJuego4.setForeground(Color.WHITE);
		lblTituloJuego4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloJuego4.setBounds(10, 247, 203, 26);
		panelJuegos.add(lblTituloJuego4);
		
		JLabel labelFotoJuego4 = new JLabel("");
		icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego4.getText())));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(200,180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoJuego4.setIcon(icon);
		labelFotoJuego4.setBounds(10, 272, 203, 136);
		panelJuegos.add(labelFotoJuego4);
		
		JLabel lblPrecioJ4 = new JLabel("Precio:");
		lblPrecioJ4.setForeground(new Color(255, 255, 255));
		lblPrecioJ4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioJ4.setBounds(10, 419, 46, 14);
		panelJuegos.add(lblPrecioJ4);
		
		JLabel labelPrecioJuego4 = new JLabel("");
		labelPrecioJuego4.setForeground(new Color(255, 255, 255));
		labelPrecioJuego4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioJuego4.setText(sql.getPreciojuego(lblTituloJuego4.getText()));
		labelPrecioJuego4.setBounds(71, 420, 46, 12);
		panelJuegos.add(labelPrecioJuego4);
		
		JButton btnComprar4 = new JButton("Comprar");
		btnComprar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sql.Stock(lblTituloJuego4.getText()) == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Stock vacio", "ProPlay IT - Error - Stock", JOptionPane.WARNING_MESSAGE);
				}else {
					icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego4.getText())));
					image = icon.getImage();
					modifiImage = image.getScaledInstance(230,180, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(modifiImage);
					fact.labelFotoJuego.setIcon(icon);
					fact.labelTituloJuegos2.setText(lblTituloJuego4.getText());
					fact.labelPrecioJuego.setText(sql.getPreciojuego(lblTituloJuego4.getText()));
					fact.labelPreciJuego.setText(sql.getPreciojuego(lblTituloJuego4.getText()));
					fact.labelTituloJuegos.setText(lblTituloJuego4.getText());
					fact.labelPrecioTotal.setText(sql.getPreciojuegoSumaTotal(lblTituloJuego4.getText()));				
					fact.lblUser.setText(lblUser.getText());				
					fact.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					fact.setVisible(true);
					dispose();
				}	
					
			}
		});
		btnComprar4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar4.setForeground(new Color(255, 255, 255));
		btnComprar4.setContentAreaFilled(false);
		btnComprar4.setFocusPainted(false);
		btnComprar4.setFocusTraversalKeysEnabled(false);
		btnComprar4.setFocusable(false);
		btnComprar4.setBounds(51, 432, 109, 23);
		panelJuegos.add(btnComprar4);
		
		JLabel labelPrecioSimbolo4 = new JLabel("\u20AC");
		labelPrecioSimbolo4.setForeground(Color.WHITE);
		labelPrecioSimbolo4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioSimbolo4.setBounds(110, 419, 18, 13);
		panelJuegos.add(labelPrecioSimbolo4);
		
		//Juego 5
		
		JLabel lblTituloJuego5 = new JLabel("Far Cry 4", SwingConstants.CENTER);
		lblTituloJuego5.setForeground(Color.WHITE);
		lblTituloJuego5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloJuego5.setBounds(261, 247, 203, 26);
		panelJuegos.add(lblTituloJuego5);
		
		JLabel labelFotoJuego5 = new JLabel("");
		icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego5.getText())));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(200,180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoJuego5.setIcon(icon);
		labelFotoJuego5.setBounds(261, 272, 203, 136);
		panelJuegos.add(labelFotoJuego5);
		
		JLabel lblPrecioJ5 = new JLabel("Precio:");
		lblPrecioJ5.setForeground(new Color(255, 255, 255));
		lblPrecioJ5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioJ5.setBounds(271, 419, 46, 14);
		panelJuegos.add(lblPrecioJ5);
		
		JLabel labelPrecioJuego5 = new JLabel("");
		labelPrecioJuego5.setForeground(new Color(255, 255, 255));
		labelPrecioJuego5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioJuego5.setText(sql.getPreciojuego(lblTituloJuego5.getText()));
		labelPrecioJuego5.setBounds(327, 420, 46, 12);
		panelJuegos.add(labelPrecioJuego5);
		
		JButton btnComprar5 = new JButton("Comprar");
		btnComprar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sql.Stock(lblTituloJuego4.getText()) == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Stock vacio", "ProPlay IT - Error - Stock", JOptionPane.WARNING_MESSAGE);
				}else {
					icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego5.getText())));
					image = icon.getImage();
					modifiImage = image.getScaledInstance(230,180, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(modifiImage);
					fact.labelFotoJuego.setIcon(icon);
					fact.labelTituloJuegos2.setText(lblTituloJuego5.getText());
					fact.labelPrecioJuego.setText(sql.getPreciojuego(lblTituloJuego5.getText()));
					fact.labelPreciJuego.setText(sql.getPreciojuego(lblTituloJuego5.getText()));
					fact.labelTituloJuegos.setText(lblTituloJuego5.getText());
					fact.labelPrecioTotal.setText(sql.getPreciojuegoSumaTotal(lblTituloJuego5.getText()));				
					fact.lblUser.setText(lblUser.getText());				
					fact.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					fact.setVisible(true);
					dispose();
				}	
					
			}
		});
		btnComprar5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar5.setForeground(new Color(255, 255, 255));
		btnComprar5.setContentAreaFilled(false);
		btnComprar5.setFocusPainted(false);
		btnComprar5.setFocusTraversalKeysEnabled(false);
		btnComprar5.setFocusable(false);
		btnComprar5.setBounds(306, 432, 109, 23);
		panelJuegos.add(btnComprar5);
		
		JLabel labelPrecioSimbolo5 = new JLabel("\u20AC");
		labelPrecioSimbolo5.setForeground(Color.WHITE);
		labelPrecioSimbolo5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioSimbolo5.setBounds(368, 420, 18, 13);
		panelJuegos.add(labelPrecioSimbolo5);		
		
		//Juego 6
		
		JLabel lblTituloJuego6 = new JLabel("Fornite", SwingConstants.CENTER);
		lblTituloJuego6.setForeground(Color.WHITE);
		lblTituloJuego6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloJuego6.setBounds(536, 247, 203, 26);
		panelJuegos.add(lblTituloJuego6);
		
		JLabel labelFotoJuego6 = new JLabel("");
		icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego6.getText())));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(200,180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoJuego6.setIcon(icon);
		labelFotoJuego6.setBounds(536, 272, 203, 136);
		panelJuegos.add(labelFotoJuego6);
		
		JLabel lblPrecioJ6 = new JLabel("Precio:");
		lblPrecioJ6.setForeground(new Color(255, 255, 255));
		lblPrecioJ6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioJ6.setBounds(546, 419, 46, 14);
		panelJuegos.add(lblPrecioJ6);
		
		JLabel labelPrecioJuego6 = new JLabel("");
		labelPrecioJuego6.setForeground(new Color(255, 255, 255));
		labelPrecioJuego6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioJuego6.setText(sql.getPreciojuego(lblTituloJuego6.getText()));
		labelPrecioJuego6.setBounds(621, 420, 46, 12);
		panelJuegos.add(labelPrecioJuego6);
		
		JButton btnComprar6 = new JButton("Comprar");
		btnComprar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sql.Stock(lblTituloJuego6.getText()) == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Stock vacio", "ProPlay IT - Error - Stock", JOptionPane.WARNING_MESSAGE);
				}else {
					icon = new ImageIcon(FrameMonedas.class.getResource(sql.getFotojuego(lblTituloJuego6.getText())));
					image = icon.getImage();
					modifiImage = image.getScaledInstance(230,180, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(modifiImage);
					fact.labelFotoJuego.setIcon(icon);
					fact.labelTituloJuegos2.setText(lblTituloJuego6.getText());
					fact.labelPrecioJuego.setText(sql.getPreciojuego(lblTituloJuego6.getText()));
					fact.labelPreciJuego.setText(sql.getPreciojuego(lblTituloJuego6.getText()));
					fact.labelTituloJuegos.setText(lblTituloJuego6.getText());
					fact.labelPrecioTotal.setText(sql.getPreciojuegoSumaTotal(lblTituloJuego6.getText()));				
					fact.lblUser.setText(lblUser.getText());				
					fact.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					fact.setVisible(true);
					dispose();
				}	
					
			}
		});
		btnComprar6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar6.setForeground(new Color(255, 255, 255));
		btnComprar6.setContentAreaFilled(false);
		btnComprar6.setFocusPainted(false);
		btnComprar6.setFocusTraversalKeysEnabled(false);
		btnComprar6.setFocusable(false);
		btnComprar6.setBounds(582, 432, 109, 23);
		panelJuegos.add(btnComprar6);
		
		JLabel labelPrecioSimbolo6 = new JLabel("\u20AC");
		labelPrecioSimbolo6.setForeground(Color.WHITE);
		labelPrecioSimbolo6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioSimbolo6.setBounds(661, 420, 18, 13);
		panelJuegos.add(labelPrecioSimbolo6);
		
		JLabel labelFondoJuego1 = new JLabel("");
		labelFondoJuego1.setOpaque(true);
		labelFondoJuego1.setBackground(new Color(169, 169, 169));
		labelFondoJuego1.setBounds(10, 11, 203, 209);
		panelJuegos.add(labelFondoJuego1);
		
		JLabel labelFondoJuego2 = new JLabel("");
		labelFondoJuego2.setOpaque(true);
		labelFondoJuego2.setBackground(new Color(169, 169, 169));
		labelFondoJuego2.setBounds(261, 11, 203, 209);
		panelJuegos.add(labelFondoJuego2);
		
		JLabel labelFondoJuego3 = new JLabel("");
		labelFondoJuego3.setOpaque(true);
		labelFondoJuego3.setBackground(new Color(169, 169, 169));
		labelFondoJuego3.setBounds(536, 11, 203, 209);
		panelJuegos.add(labelFondoJuego3);
		
		JLabel labelFondoJuego4 = new JLabel("");
		labelFondoJuego4.setOpaque(true);
		labelFondoJuego4.setBackground(new Color(169, 169, 169));
		labelFondoJuego4.setBounds(10, 247, 203, 209);
		panelJuegos.add(labelFondoJuego4);
		
		JLabel labelFondoJuego5 = new JLabel("");
		labelFondoJuego5.setOpaque(true);
		labelFondoJuego5.setBackground(new Color(169, 169, 169));
		labelFondoJuego5.setBounds(261, 247, 203, 209);
		panelJuegos.add(labelFondoJuego5);
		
		JLabel labelFondoJuego6 = new JLabel("");
		labelFondoJuego6.setOpaque(true);
		labelFondoJuego6.setBackground(new Color(169, 169, 169));
		labelFondoJuego6.setBounds(536, 247, 203, 209);
		panelJuegos.add(labelFondoJuego6);
					
		JButton btnJuegos = new JButton("Juegos");
		btnJuegos.setBounds(0, 0, 437, 37);
		btnJuegos.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnJuegos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnJuegos.setContentAreaFilled(false);
		btnJuegos.setBackground(Color.GRAY);
		btnJuegos.setForeground(Color.WHITE);
		btnJuegos.setFocusable(false);
		btnJuegos.setFocusTraversalKeysEnabled(false);
		btnJuegos.setFocusPainted(false);
		btnJuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameShopJuegos juegos = new FrameShopJuegos();
				
				juegos.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
				juegos.lblUser.setText(lblUser.getText());
				juegos.setVisible(true);
				dispose();
			}
		});
		panelShop.add(btnJuegos);
		
		JButton btnObtenerMonedas = new JButton("Obtener Monedas");
		btnObtenerMonedas.setBounds(438, 0, 374, 37);
		btnObtenerMonedas.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnObtenerMonedas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnObtenerMonedas.setForeground(Color.WHITE);
		btnObtenerMonedas.setFocusable(false);
		btnObtenerMonedas.setFocusTraversalKeysEnabled(false);
		btnObtenerMonedas.setFocusPainted(false);
		btnObtenerMonedas.setContentAreaFilled(false);
		btnObtenerMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameMonedas money = new FrameMonedas();
				
				money.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
				money.lblUser.setText(lblUser.getText());
				money.setVisible(true);
				dispose();
		
			}
		});
		panelShop.add(btnObtenerMonedas);
		
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
				sql.eliminarListaJuegos(lblUser.getText());
				sql.eliminarUser(lblUser.getText());
				
				Login l = new Login();
				
				fich.vaciarRecordar();
				
				l.setVisible(true);
				dispose();	
				
			}
		});
		btnEliminarCuenta.setBounds(852, 667, 208, 23);
		contentPane.add(btnEliminarCuenta);
	}
}
