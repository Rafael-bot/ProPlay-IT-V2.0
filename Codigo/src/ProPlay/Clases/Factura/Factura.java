package ProPlay.Clases.Factura;

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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.LabelUI;

import ProPlay.Clases.Amigos.Amigos;
import ProPlay.Clases.Libreria.Libreria;
import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;
import ProPlay.Clases.Tienda.FrameMonedas;
import ProPlay.Clases.Tienda.FrameShopJuegos;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class Factura extends JFrame {

	private JPanel contentPane;
	public JLabel lblUser;
	private Metodos_SQL sql = new Metodos_SQL();//Objeto para llamar a los metodos sql
	private ImageIcon icon;
	private Image image;
	private Image modifiImage;
	private MetodoFichero fich = new MetodoFichero();//objeto que utilizo para llamar a los metodos de fichero
	public JLabel labelMonedas;
	public JLabel labelPrecioJuego;
	public JLabel labelTituloJuegos;
	public JLabel labelFotoJuego;
	public JLabel labelTituloJuegos2;
	public JLabel labelPrecioIva;
	public JLabel labelPreciJuego;
	private JLabel labelPrecioSimbolo2;
	private JLabel lblIva;
	private JLabel labelPrecioJuego2_1;
	private JLabel labelPrecioSimboloIva;
	private double precio_juego;
	private double precio_iva;
	public JLabel labelPrecioTotal; 
	private JButton btnGuardarFactura;

	/**
	 * Create the frame.
	 */
	public Factura() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameShopJuegos.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - Tienda - Factura");
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
		
		JLabel lblNewLabel = new JLabel("By Rafael Oliva Ramirez");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(449, 629, 139, 30);
		contentPane.add(lblNewLabel);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//pagina principal
				
				Ventana_pagina_principal principal = new Ventana_pagina_principal();
				principal.lblUser.setText(lblUser.getText());
				principal.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));	
				principal.setVisible(true);
				dispose();			
				
			}
		});
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/logo_size_invert.jpg"));//ruta de la imagen 
		image = icon.getImage();
		modifiImage = image.getScaledInstance(180,100, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		labelLogo.setIcon(icon);
		labelLogo.setBounds(10, 22, 170, 71);
		contentPane.add(labelLogo);
		
		JLabel lblTienda = new JLabel("Tienda");
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTienda.setForeground(new Color(255, 255, 255));
		lblTienda.setBounds(449, 60, 96, 40);
		contentPane.add(lblTienda);
		image = icon.getImage();
		modifiImage = image.getScaledInstance(200,180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		
		labelMonedas = new JLabel("");
		labelMonedas.setForeground(Color.WHITE);
		labelMonedas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMonedas.setBounds(829, 22, 66, 53);
		contentPane.add(labelMonedas);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(181, 100, 714, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");//Boton Cancelar
		btnCancelar.setFocusable(false);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameShopJuegos shop = new FrameShopJuegos();//Objeto para ir a la ventana de tienda
				shop.lblUser.setText(lblUser.getText());//Añadimos el nombre del usuario al label de la tienda
				shop.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));//Actualizamos la moneda  en el label, ya que el usuario en esta ventana gastara dinero en los juegos.
				shop.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.setBounds(615, 11, 89, 23);
		panel.add(btnCancelar);
		
		labelTituloJuegos = new JLabel("",SwingConstants.CENTER);
		labelTituloJuegos.setForeground(new Color(255, 255, 255));
		labelTituloJuegos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTituloJuegos.setBounds(492, 32, 212, 55);
		panel.add(labelTituloJuegos);
		
		labelFotoJuego = new JLabel("");
		labelFotoJuego.setBounds(492, 75, 212, 336);
		panel.add(labelFotoJuego);
		
		labelPrecioJuego = new JLabel("", SwingConstants.CENTER);
		labelPrecioJuego.setForeground(new Color(255, 255, 255));
		labelPrecioJuego.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioJuego.setBounds(492, 454, 212, 66);
		panel.add(labelPrecioJuego);
		
		JLabel labelPrecioSimbolo = new JLabel("\u20AC");
		labelPrecioSimbolo.setForeground(Color.WHITE);
		labelPrecioSimbolo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelPrecioSimbolo.setBounds(642, 471, 16, 30);
		panel.add(labelPrecioSimbolo);
		
		labelTituloJuegos2 = new JLabel("", SwingConstants.CENTER);
		labelTituloJuegos2.setForeground(Color.WHITE);
		labelTituloJuegos2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelTituloJuegos2.setBounds(10, 75, 267, 55);
		panel.add(labelTituloJuegos2);
		
		lblIva = new JLabel("IVA",SwingConstants.CENTER);
		lblIva.setForeground(new Color(255, 255, 255));
		lblIva.setFocusable(false);
		lblIva.setFocusTraversalKeysEnabled(false);
		lblIva.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIva.setBounds(104, 125, 61, 36);
		panel.add(lblIva);
		
		labelPrecioIva = new JLabel("1.80", SwingConstants.CENTER);
		labelPrecioIva.setForeground(Color.WHITE);
		labelPrecioIva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioIva.setBounds(201, 120, 55, 55);
		panel.add(labelPrecioIva);
		
		JLabel labelPanelDerecha = new JLabel("");
		labelPanelDerecha.setBackground(new Color(128, 128, 128));
		labelPanelDerecha.setOpaque(true);
		labelPanelDerecha.setBounds(492, 32, 212, 488);
		panel.add(labelPanelDerecha);
		
		labelPrecioSimbolo2 = new JLabel("\u20AC");
		labelPrecioSimbolo2.setForeground(Color.WHITE);
		labelPrecioSimbolo2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPrecioSimbolo2.setBounds(247, 75, 16, 55);
		panel.add(labelPrecioSimbolo2);
		
		labelPreciJuego = new JLabel("", SwingConstants.CENTER);
		labelPreciJuego.setForeground(Color.WHITE);
		labelPreciJuego.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPreciJuego.setBounds(201, 75, 55, 55);
		panel.add(labelPreciJuego);
		

		
		labelPrecioSimboloIva = new JLabel("\u20AC");
		labelPrecioSimboloIva.setForeground(Color.WHITE);
		labelPrecioSimboloIva.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPrecioSimboloIva.setBounds(247, 117, 16, 55);
		panel.add(labelPrecioSimboloIva);
		
		JLabel lblTotal = new JLabel("Total:",SwingConstants.CENTER);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTotal.setBounds(104, 223, 61, 55);
		panel.add(lblTotal);
		
		labelPrecioTotal = new JLabel("",SwingConstants.CENTER);
		labelPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecioTotal.setForeground(Color.WHITE);
		labelPrecioTotal.setBounds(195, 235, 61, 30);
		panel.add(labelPrecioTotal);
		
		JLabel labelPrecioSimboloIva_1 = new JLabel("\u20AC");
		labelPrecioSimboloIva_1.setForeground(Color.WHITE);
		labelPrecioSimboloIva_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPrecioSimboloIva_1.setBounds(247, 223, 16, 55);
		panel.add(labelPrecioSimboloIva_1);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				double moneyactual = Double.parseDouble(labelMonedas.getText());//Covertimos el texto que esta en el label de Moneda a Double
				double moneyjuego = Double.parseDouble(labelPrecioTotal.getText());//Convertimos el texto que tenemos en el label del precio del juegos a Double
				
				if (moneyactual >= moneyjuego) {//Si tenemos mas monedas de lo quie cuesta el juego podremos comprarlo
								
					sql.pagar(lblUser.getText(), moneyjuego, labelTituloJuegos.getText());//llamamos al metodo pagar para compar el juego 
					
					
					/*
					 * Una vez comprado el juego no llevara a la pagina de la tienda para comprar mas juegos o obtener monedas
					 */ 
					FrameShopJuegos shop = new FrameShopJuegos();
					
					shop.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					shop.lblUser.setText(lblUser.getText());
					shop.setVisible(true);
					dispose();
					
				} else if(moneyactual <= moneyjuego){//Si tenemos menos dinero que lo que cuesta el juego no saltara un mensaje de alarma diciendo que no tenemos dinero.
					JOptionPane.showMessageDialog(new JFrame(), "No tiene dinero suficiente.", "ProPlay IT - Error",JOptionPane.WARNING_MESSAGE);
				} 
				
			}
		});
				
		btnPagar.setFocusable(false);
		btnPagar.setFocusTraversalKeysEnabled(false);
		btnPagar.setFocusPainted(false);
		btnPagar.setBorderPainted(false);
		btnPagar.setBackground(Color.GRAY);
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setBounds(80, 435, 361, 66);
		panel.add(btnPagar);
		
		btnGuardarFactura = new JButton("Guardar Factura Y Pagar");
		btnGuardarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double moneyactual = Double.parseDouble(labelMonedas.getText());//Covertimos el texto que esta en el label de Moneda a Double
				double moneyjuego = Double.parseDouble(labelPrecioTotal.getText());//Convertimos el texto que tenemos en el label del precio del juegos a Double
				
				if (moneyactual >= moneyjuego) {
					
					sql.comprobjuegosfact(lblUser.getText(), moneyjuego, labelTituloJuegos.getText(),labelPreciJuego.getText(),labelMonedas.getText());//Llamamos a este metodo para comprar el juego y que se muestre la factura de la compra
					
					FrameShopJuegos shop = new FrameShopJuegos();
					
					shop.labelMonedas.setText(sql.actualizarmoneda(lblUser.getText()));
					shop.lblUser.setText(lblUser.getText());
					shop.setVisible(true);
					dispose();
					
				} else if(moneyactual <= moneyjuego){//Si tenemos menos dinero que lo que cuesta el juego no saltara un mensaje de alarma diciendo que no tenemos dinero.
					JOptionPane.showMessageDialog(new JFrame(), "No tiene dinero suficiente.", "ProPlay IT - Error",JOptionPane.WARNING_MESSAGE);
				} 
			}
		});
		btnGuardarFactura.setFocusable(false);
		btnGuardarFactura.setFocusTraversalKeysEnabled(false);
		btnGuardarFactura.setFocusPainted(false);
		btnGuardarFactura.setBorderPainted(false);
		btnGuardarFactura.setBackground(Color.GRAY);
		btnGuardarFactura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardarFactura.setForeground(Color.WHITE);
		btnGuardarFactura.setBounds(80, 371, 361, 40);
		panel.add(btnGuardarFactura);
	}	
}
