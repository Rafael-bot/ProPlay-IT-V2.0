package ProPlay.Clases.Tienda;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ProPlay.Clases.Amigos.Amigos;
import ProPlay.Clases.AtencionCliente.AtencionClient;
import ProPlay.Clases.Libreria.Libreria;
import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;
import ProPlay.Clases.Videos.Videos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class FrameMonedas extends JFrame {
	
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
	private Videos v = new Videos();
	
	/**
	 * Create the frame.
	 */
	public FrameMonedas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameShopJuegos.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - Tienda - Obtener Moneda");
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
		
		
		
		
			
		JButton btnJuegos = new JButton("Juegos");
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
				
				FrameShopJuegos shop = new FrameShopJuegos();
				
				shop.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
				shop.lblUser.setText(lblUser.getText());
				shop.setVisible(true);
				dispose();
				
			}
		});
		
		
		btnJuegos.setBounds(0, 0, 437, 37);
		panelShop.add(btnJuegos);
		
		JButton btnObtenerMonedas = new JButton("Obtener Monedas");
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
		btnObtenerMonedas.setBounds(438, 0, 374, 37);
		panelShop.add(btnObtenerMonedas);
		
		JPanel panelObtMonedas = new JPanel();
		panelObtMonedas.setBounds(0, 38, 812, 480);
		panelShop.add(panelObtMonedas);
		
		labelMonedas = new JLabel("");
		labelMonedas.setForeground(Color.WHITE);
		labelMonedas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMonedas.setBounds(829, 22, 66, 53);
		contentPane.add(labelMonedas);
		
		JLabel labelFotoVideo1 = new JLabel("");
		icon = new ImageIcon(FrameMonedas.class.getResource("/ProPlay/RecursoMultimedia/Screenshot_Video1.png"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(218,200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		panelObtMonedas.setLayout(null);
		
		JLabel lblTituloVideo1 = new JLabel("Gameplay Juego de Movil", SwingConstants.CENTER);
		lblTituloVideo1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloVideo1.setForeground(Color.WHITE);
		lblTituloVideo1.setBounds(49, 11, 166, 19);
		panelObtMonedas.add(lblTituloVideo1);
		labelFotoVideo1.setIcon(icon);
		labelFotoVideo1.setBounds(10, 35, 218, 172);
		panelObtMonedas.add(labelFotoVideo1);
		
		JLabel lblObtMonedaVideo1 = new JLabel("+5",SwingConstants.CENTER);
		lblObtMonedaVideo1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblObtMonedaVideo1.setForeground(Color.WHITE);
		lblObtMonedaVideo1.setBounds(10, 206, 43, 25);
		panelObtMonedas.add(lblObtMonedaVideo1);
		
		JButton btnVerVideo1 = new JButton("Ver Video");
		btnVerVideo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				v.video1(lblUser.getText());
				
			}
		});
		btnVerVideo1.setFocusable(false);//Ver video 1
		btnVerVideo1.setFocusTraversalKeysEnabled(false);
		btnVerVideo1.setFocusPainted(false);
		btnVerVideo1.setBackground(new Color(128, 128, 128));
		btnVerVideo1.setForeground(new Color(255, 255, 255));
		btnVerVideo1.setBorderPainted(false);
		btnVerVideo1.setBounds(75, 209, 96, 22);
		panelObtMonedas.add(btnVerVideo1);
		
		
		JLabel lblTituloVideo2 = new JLabel("Realidad Virtual", SwingConstants.CENTER);
		lblTituloVideo2.setForeground(Color.WHITE);
		lblTituloVideo2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloVideo2.setBounds(344, 11, 97, 19);
		panelObtMonedas.add(lblTituloVideo2);
		
		JLabel labelFotoVideo2 = new JLabel("");
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/Screenshot_Video2.png"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(218,200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoVideo2.setIcon(icon);
		labelFotoVideo2.setBounds(288, 35, 218, 172);
		panelObtMonedas.add(labelFotoVideo2);
		
		JLabel lblObtMonedaVideo2 = new JLabel("+10", SwingConstants.CENTER);
		lblObtMonedaVideo2.setForeground(Color.WHITE);
		lblObtMonedaVideo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblObtMonedaVideo2.setBounds(298, 209, 33, 22);
		panelObtMonedas.add(lblObtMonedaVideo2);
		
		JButton btnVerVideo2 = new JButton("Ver Video");//Ver video 2
		btnVerVideo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				v.video2(lblUser.getText());
			}
		});
		btnVerVideo2.setFocusable(false);
		btnVerVideo2.setFocusTraversalKeysEnabled(false);
		btnVerVideo2.setFocusPainted(false);
		btnVerVideo2.setBackground(new Color(128, 128, 128));
		btnVerVideo2.setForeground(new Color(255, 255, 255));
		btnVerVideo2.setBorderPainted(false);
		btnVerVideo2.setBounds(344, 210, 96, 22);
		panelObtMonedas.add(btnVerVideo2);
		
		JLabel lblTituloVideo3 = new JLabel("Unboxing de Accesorio Movil", SwingConstants.CENTER);
		lblTituloVideo3.setForeground(Color.WHITE);
		lblTituloVideo3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloVideo3.setBounds(577, 11, 184, 19);
		panelObtMonedas.add(lblTituloVideo3);
		
		JLabel labelFotoVideo3 = new JLabel("");
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/Screenshot_Video3.png"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(218,200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoVideo3.setIcon(icon);
		labelFotoVideo3.setBounds(564, 35, 218, 172);
		panelObtMonedas.add(labelFotoVideo3);
		
		JButton btnVerVideo3 = new JButton("Ver Video");
		btnVerVideo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				v.video3(lblUser.getText());
			}
		});
		
		JLabel lblObtMonedaVideo3 = new JLabel("+7", SwingConstants.CENTER);//Ver video 3
		lblObtMonedaVideo3.setForeground(Color.WHITE);
		lblObtMonedaVideo3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblObtMonedaVideo3.setBounds(577, 209, 23, 22);
		panelObtMonedas.add(lblObtMonedaVideo3);
		btnVerVideo3.setFocusable(false);
		btnVerVideo3.setFocusTraversalKeysEnabled(false);
		btnVerVideo3.setFocusPainted(false);
		btnVerVideo3.setBackground(new Color(128, 128, 128));
		btnVerVideo3.setForeground(new Color(255, 255, 255));
		btnVerVideo3.setBorderPainted(false);
		btnVerVideo3.setBounds(622, 210, 96, 22);
		panelObtMonedas.add(btnVerVideo3);
		
		JLabel lblTituloVideo4 = new JLabel("Teclado y Raton\r\n", SwingConstants.CENTER);
		lblTituloVideo4.setForeground(Color.WHITE);
		lblTituloVideo4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloVideo4.setBounds(64, 259, 107, 19);
		panelObtMonedas.add(lblTituloVideo4);
		
		JLabel labelFotoVideo4 = new JLabel("");
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/Screenshot_Video4.png"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(218,200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoVideo4.setIcon(icon);
		labelFotoVideo4.setBounds(10, 279, 218, 155);
		panelObtMonedas.add(labelFotoVideo4);
		
		JLabel lblObtMonedaVideo4 = new JLabel("+15", SwingConstants.CENTER);
		lblObtMonedaVideo4.setForeground(Color.WHITE);
		lblObtMonedaVideo4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblObtMonedaVideo4.setBounds(20, 435, 33, 22);
		panelObtMonedas.add(lblObtMonedaVideo4);
		
		JButton btnVerVideo4 = new JButton("Ver Video");//Ver video 4
		btnVerVideo4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				v.video4(lblUser.getText());
			}
		});
		btnVerVideo4.setFocusable(false);
		btnVerVideo4.setFocusTraversalKeysEnabled(false);
		btnVerVideo4.setFocusPainted(false);
		btnVerVideo4.setBackground(new Color(128, 128, 128));
		btnVerVideo4.setForeground(new Color(255, 255, 255));
		btnVerVideo4.setBorderPainted(false);
		btnVerVideo4.setBounds(75, 432, 96, 34);
		panelObtMonedas.add(btnVerVideo4);
		
		JLabel lblTituloVideo5 = new JLabel("SetUp Gaming", SwingConstants.CENTER);
		lblTituloVideo5.setForeground(Color.WHITE);
		lblTituloVideo5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloVideo5.setBounds(344, 259, 93, 19);
		panelObtMonedas.add(lblTituloVideo5);
		
		JLabel labelFotoVideo5 = new JLabel("");
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/Screenshot_Video5.png"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(218,200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoVideo5.setIcon(icon);
		labelFotoVideo5.setBounds(288, 279, 218, 155);
		panelObtMonedas.add(labelFotoVideo5);
		
		JLabel lblObtMonedaVideo5 = new JLabel("+14", SwingConstants.CENTER);
		lblObtMonedaVideo5.setForeground(Color.WHITE);
		lblObtMonedaVideo5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblObtMonedaVideo5.setBounds(288, 435, 42, 34);
		panelObtMonedas.add(lblObtMonedaVideo5);
		
		JButton btnVerVideo5 = new JButton("Ver Video");//Ver video 5
		btnVerVideo5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				v.video5(lblUser.getText());
			}
		});
		btnVerVideo5.setFocusable(false);
		btnVerVideo5.setFocusTraversalKeysEnabled(false);
		btnVerVideo5.setFocusPainted(false);
		btnVerVideo5.setBackground(new Color(128, 128, 128));
		btnVerVideo5.setForeground(new Color(255, 255, 255));
		btnVerVideo5.setBorderPainted(false);
		btnVerVideo5.setBounds(344, 434, 96, 31);
		panelObtMonedas.add(btnVerVideo5);
		
		JLabel lblTituloVideo6 = new JLabel("Mando PS4", SwingConstants.CENTER);
		lblTituloVideo6.setForeground(Color.WHITE);
		lblTituloVideo6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloVideo6.setBounds(635, 259, 73, 19);
		panelObtMonedas.add(lblTituloVideo6);
		
		JLabel labelFotoVideo6 = new JLabel("");
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/Screenshot_Video6.png"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(218,200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelFotoVideo6.setIcon(icon);
		labelFotoVideo6.setBounds(564, 279, 218, 155);
		panelObtMonedas.add(labelFotoVideo6);
		
		JLabel lblObtMonedaVideo6 = new JLabel("+2", SwingConstants.CENTER);
		lblObtMonedaVideo6.setForeground(Color.WHITE);
		lblObtMonedaVideo6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblObtMonedaVideo6.setBounds(577, 438, 23, 22);
		panelObtMonedas.add(lblObtMonedaVideo6);
		
		JButton btnVerVideo6 = new JButton("Ver Video");//Ver video 6
		btnVerVideo6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				v.video6(lblUser.getText());
				
			}
		});
		btnVerVideo6.setFocusable(false);
		btnVerVideo6.setFocusTraversalKeysEnabled(false);
		btnVerVideo6.setFocusPainted(false);
		btnVerVideo6.setBackground(new Color(128, 128, 128));
		btnVerVideo6.setForeground(new Color(255, 255, 255));
		btnVerVideo6.setBorderPainted(false);
		btnVerVideo6.setBounds(635, 435, 107, 28);
		panelObtMonedas.add(btnVerVideo6);
		
		JLabel labelFondoVideo1 = new JLabel("");
		labelFondoVideo1.setBackground(Color.GRAY);
		labelFondoVideo1.setOpaque(true);
		labelFondoVideo1.setBounds(10, 11, 218, 225);
		panelObtMonedas.add(labelFondoVideo1);
		
		JLabel labelFondoVideo2 = new JLabel("");
		labelFondoVideo2.setOpaque(true);
		labelFondoVideo2.setBackground(Color.GRAY);
		labelFondoVideo2.setBounds(288, 11, 218, 225);
		panelObtMonedas.add(labelFondoVideo2);
		
		JLabel labelFondoVideo3 = new JLabel("");
		labelFondoVideo3.setOpaque(true);
		labelFondoVideo3.setBackground(Color.GRAY);
		labelFondoVideo3.setBounds(564, 11, 218, 225);
		panelObtMonedas.add(labelFondoVideo3);
		
		JLabel labelFondoVideo4 = new JLabel("");
		labelFondoVideo4.setOpaque(true);
		labelFondoVideo4.setBackground(Color.GRAY);
		labelFondoVideo4.setBounds(10, 253, 218, 216);
		panelObtMonedas.add(labelFondoVideo4);
		
		JLabel labelFondoVideo5 = new JLabel("");
		labelFondoVideo5.setOpaque(true);
		labelFondoVideo5.setBackground(Color.GRAY);
		labelFondoVideo5.setBounds(288, 253, 218, 216);
		panelObtMonedas.add(labelFondoVideo5);
		
		JLabel labelFondoVideo6 = new JLabel("");
		labelFondoVideo6.setOpaque(true);
		labelFondoVideo6.setBackground(Color.GRAY);
		labelFondoVideo6.setBounds(564, 253, 218, 216);
		panelObtMonedas.add(labelFondoVideo6);
		
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
