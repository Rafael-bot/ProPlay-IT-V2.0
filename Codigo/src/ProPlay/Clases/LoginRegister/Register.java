package ProPlay.Clases.LoginRegister;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



import Atxy2k.CustomTextField.RestrictedTextField;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Conexion;
import ProPlay.Clases.Sql.Metodos_SQL;
import ProPlay.Clases.Sql.Metodos_SQL;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class Register extends JFrame implements ChangeListener,ActionListener {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textGmail;
	private JPasswordField textPasswd;
	private JPasswordField textPasswd2;
	private Metodos_SQL sql = new Metodos_SQL();
	private JCheckBox chckbxAceptarCondiciones;
	private JButton btnRegister;
	private static ImageIcon icon;
	private static Image image;
	private static Image modifiImage;

	/**
	 * Create the frame.
	 */
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setResizable(false);
		setTitle("ProPlay IT - Register");
		
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
		lblLogo.setBounds(152, 11, 120, 69);
		panelLogin.add(lblLogo);
		lblLogo.setBackground(new Color(128, 128, 128));
		
		JLabel lblUser = new JLabel("*Usuario(12):");
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(16, 81, 102, 35);
		panelLogin.add(lblUser);
		
		JLabel lblGmail = new JLabel("*Gmail:");
		lblGmail.setForeground(Color.WHITE);
		lblGmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGmail.setBounds(16, 127, 102, 35);
		panelLogin.add(lblGmail);
		
		JLabel lblPasswd = new JLabel("*Passwd(12):");
		lblPasswd.setForeground(Color.WHITE);
		lblPasswd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPasswd.setBounds(16, 173, 102, 35);
		panelLogin.add(lblPasswd);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUser.setBorder(null);
		textUser.setToolTipText("");
		textUser.setBounds(122, 89, 189, 20);
		textUser.setColumns(10);
		RestrictedTextField textUserRestrict = new RestrictedTextField(textUser);//resttriccion al textfield
		textUserRestrict.setLimit(12);
		textUserRestrict.setAcceptSpace(false);
		panelLogin.add(textUser);
		
		
		textGmail = new JTextField();
		textGmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (validEmail(textGmail.getText())) {
					
				}else {//si no es valido aparecera este mensaje
					JOptionPane.showMessageDialog(new JFrame(), "Error, Email no valido", "Proplay IT - Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		textGmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textGmail.setToolTipText("");
		textGmail.setColumns(10);
		textGmail.setBorder(null);
		textGmail.setBounds(122, 135, 189, 20);
		RestrictedTextField textGmailRestrict = new RestrictedTextField(textGmail);//resttriccion al textfield
		textGmailRestrict.setLimit(50);
		textGmailRestrict.setAcceptSpace(false);
		panelLogin.add(textGmail);
		
		textPasswd = new JPasswordField();
		textPasswd.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPasswd.setToolTipText("");
		textPasswd.setColumns(10);
		textPasswd.setBorder(null);
		textPasswd.setBounds(122, 182, 189, 20);
		RestrictedTextField textPasswRestrict = new RestrictedTextField(textPasswd);//resttriccion al textfield
		textPasswRestrict.setLimit(12);
		textPasswRestrict.setAcceptSpace(false);
		panelLogin.add(textPasswd);
		
		textPasswd2 = new JPasswordField();
		textPasswd2.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPasswd2.setToolTipText("");
		textPasswd2.setColumns(10);
		textPasswd2.setBorder(null);
		textPasswd2.setBounds(122, 213, 189, 20);
		RestrictedTextField textPassw2Restrict = new RestrictedTextField(textPasswd2);//resttriccion al textfield
		textPassw2Restrict.setLimit(12);//max 12 caracteeres
		textPassw2Restrict.setAcceptSpace(false);//no se acepta espacios
		panelLogin.add(textPasswd2);
		
		chckbxAceptarCondiciones = new JCheckBox("Aceptar Condiciones");
		chckbxAceptarCondiciones.setOpaque(false);
		chckbxAceptarCondiciones.setForeground(Color.WHITE);
		chckbxAceptarCondiciones.setBounds(152, 254, 159, 23);
		chckbxAceptarCondiciones.addChangeListener((ChangeListener) this);//Para el boton register
		panelLogin.add(chckbxAceptarCondiciones);
		
		
		JLabel lblNewLabel = new JLabel("Mostrar");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Condicion cond = new Condicion();
				cond.setVisible(true);
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(196, 276, 46, 14);
		panelLogin.add(lblNewLabel);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFocusTraversalKeysEnabled(false);
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.GRAY);
		btnAtras.setBounds(47, 322, 102, 35);
		panelLogin.add(btnAtras);
				
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setBorderPainted(false);
		btnRegister.setBorder(null);
		btnRegister.setBackground(new Color(128, 128, 128));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textUser.getText().equals("") || textGmail.getText().equals("") || textPasswd.getText().equals("") || textPasswd2.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Error, rellena los campos", "ProPlay It - Error", JOptionPane.WARNING_MESSAGE);
				} else {
					
					if(textPasswd2.getText().equals(textPasswd.getText()) || textPasswd.getText().equals(textPasswd2.getText())) {
						sql.comprob_register(textUser.getText(), textGmail.getText(), textPasswd2.getText());//Llamamos a este metodo para comprobar si ya esta regsitrado y comprobar si es valido
						
						Login l = new Login();
						l.setVisible(true);
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Error,Las passwd no coinciden", "ProPlay It - Error", JOptionPane.WARNING_MESSAGE);
					} 
					
					
					
				}
				
				

			}
		});
		btnRegister.setBounds(247, 313, 102, 53);
		btnRegister.addChangeListener(this);
		btnRegister.setEnabled(false);
		panelLogin.add(btnRegister);
		
	}
	
	public static boolean validEmail(String email) {//Este metodo lo utilizo para validar el gmail.
		
		Pattern pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
		Matcher mat = pat.matcher(email);
		
		if(mat.find()) {
			return true;
		} else {
			return false;
		}
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {//Si el checkbox se seleciona el boton register se activa
		if (chckbxAceptarCondiciones.isSelected() == true) {
			btnRegister.setEnabled(true);
		} else {
			btnRegister.setEnabled(false);
		}
		
	}
}
