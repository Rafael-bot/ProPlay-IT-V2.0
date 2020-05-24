package ProPlay.Clases.LoginRegister;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;

import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textPassw;
	private static Metodos_SQL sql = new Metodos_SQL();//Objeto para llamar lo metodo sql
	private static ImageIcon icon;
	private static Image image;
	private static Image modifiImage;
	private static MetodoFichero mf;

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
			
		setTitle("ProPlay IT - Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 402, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(153, 153, 153));
		panelLogin.setBounds(10, 11, 376, 386);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		icon = new ImageIcon(Login.class.getResource("/ProPlay/RecursoMultimedia/logo_size_invert.jpg"));
		image = icon.getImage();
		modifiImage = image.getScaledInstance(120,100, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiImage);
		lblLogo.setIcon(icon);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogo.setBorder(null);
		lblLogo.setBounds(134, 0, 129, 111);
		panelLogin.add(lblLogo);
		lblLogo.setBackground(new Color(128, 128, 128));
		
		JLabel lblUsuario = new JLabel("User:");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(16, 115, 102, 35);
		panelLogin.add(lblUsuario);
		
		JLabel lblPassw = new JLabel("Passw:");
		lblPassw.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassw.setForeground(new Color(255, 255, 255));
		lblPassw.setBounds(16, 143, 97, 35);
		panelLogin.add(lblPassw);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsuario.setBorder(null);
		textUsuario.setToolTipText("");
		textUsuario.setBounds(123, 122, 144, 20);
		textUsuario.setColumns(10);
		RestrictedTextField textUserRestrict = new RestrictedTextField(textUsuario);
		textUserRestrict.setLimit(12);
		textUserRestrict.setAcceptSpace(false);
		panelLogin.add(textUsuario);
		
		
		textPassw = new JPasswordField();
		textPassw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassw.setBorder(null);
		textPassw.setToolTipText("");
		textPassw.setColumns(10);
		textPassw.setBounds(123, 150, 144, 20);
		RestrictedTextField textPasswdRestrict = new RestrictedTextField(textPassw);
		textPasswdRestrict.setLimit(12);
		textPasswdRestrict.setAcceptSpace(false);
		panelLogin.add(textPassw);
		
		JButton btnNoMeAcuerdo = new JButton("No me acuerdo");//Este boton esta para cuando el usuario no se acuerda de sus datos, es decir, que le lleva a una ventana para recuperar los datos
		btnNoMeAcuerdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 NoMeAcuerdo nomeacuerdo = new NoMeAcuerdo();
				 
				 setVisible(false);
				 nomeacuerdo.setVisible(true);
				 
			}
		});
		btnNoMeAcuerdo.setBorderPainted(false);
		btnNoMeAcuerdo.setContentAreaFilled(false);
		btnNoMeAcuerdo.setForeground(new Color(255, 255, 255));
		btnNoMeAcuerdo.setFocusTraversalKeysEnabled(false);
		btnNoMeAcuerdo.setBackground(new Color(128, 128, 128));
		btnNoMeAcuerdo.setOpaque(false);
		btnNoMeAcuerdo.setBounds(134, 181, 129, 20);
		panelLogin.add(btnNoMeAcuerdo);
		
		JCheckBox chckbxRecordar = new JCheckBox("Recordar");
		chckbxRecordar.setForeground(new Color(255, 255, 255));
		chckbxRecordar.setOpaque(false);
		chckbxRecordar.setBounds(159, 207, 97, 23);
		panelLogin.add(chckbxRecordar);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				String busque = sql.comprobUser(textUsuario.getText(), textPassw.getText());//Llamammos a este metodo que lo que hace es comprobar si el usuario esta registrado(Usuario encontrado o usuario no encontrado)		
				Ventana_pagina_principal principal = new Ventana_pagina_principal();
				
				
				if(textUsuario.getText().equals("") || textPassw.getText().equals("")) {//SI el usuario no rellena uno de los campos , le saltara una alarma 
					
					JOptionPane.showMessageDialog(new JFrame(), "Error, rellena los campos", "ProPlay It - Error", JOptionPane.WARNING_MESSAGE);
					
				} else {
									
				if (busque.equals("Usuario encontrado")) {//Si sale usuario encontrado se logueeara
					
					if (chckbxRecordar.isSelected() == true) {//Si el checkbox esta selecionado se guadara en el archivo txt
					
						mf.escribRecordar(textUsuario.getText(), textPassw.getText());//este metod lo que hara es escribir el archivo txt con los datos del logueo para iniciar automaticamente
						
						busque = sql.login(textUsuario.getText());//Aqui es donde se realiza el logue de usuario
						JOptionPane.showMessageDialog(null, "Login realizado correctamente, como "+busque+".");
						principal.labelMonedas.setText(sql.actualizarmoneda(textUsuario.getText()));//Ingresamos en el label las monedas que tiene el usuario
						principal.lblUser.setText(textUsuario.getText());//Ingresmor el nombre del usuario en el label de la pagina principal
						principal.setVisible(true);
						dispose();
						
					} else {
												
						busque = sql.login(textUsuario.getText());//Aqui es donde se realiza el logue de usuario
						JOptionPane.showMessageDialog(null, "Login realizado correctamente, como "+busque+".");
						
						principal.labelMonedas.setText(sql.actualizarmoneda(textUsuario.getText()));//Ingresamos en el label las monedas que tiene el usuario
						principal.lblUser.setText(textUsuario.getText());
						principal.setVisible(true);
						dispose();
					}				

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "ERROR, usuario o la contraseña", "ERROR - Login", JOptionPane.WARNING_MESSAGE);
				}
				
				}
			}
		});
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFocusTraversalKeysEnabled(false);
		btnLogin.setBounds(287, 115, 79, 63);
		panelLogin.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Nos vamos a la ventana de registrar usuario.
				Register reg = new Register();
				reg.setVisible(true);
				dispose();
				
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFocusTraversalKeysEnabled(false);
		btnRegister.setBorder(null);
		btnRegister.setBackground(Color.GRAY);
		btnRegister.setBounds(100, 275, 194, 50);
		panelLogin.add(btnRegister);
		
	
	}
	
	
	
}
