package ProPlay.Clases.LoginRegister;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import ProPlay.Clases.Sql.Metodos_SQL;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class NoMeAcuerdo extends JFrame {

	private JPanel contentPane;
	private JTextField textGmail;
	private Metodos_SQL sql = new Metodos_SQL();
	private JTextPane textPane;


	/**
	 * Create the frame.
	 */
	public NoMeAcuerdo() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NoMeAcuerdo.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - No me Acuerdo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblG = new JLabel("Gmail:");
		lblG.setBounds(10, 11, 55, 33);
		lblG.setForeground(Color.WHITE);
		lblG.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblG);
		
		Register r = new Register();
		
		textGmail = new JTextField();
		textGmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (r.validEmail(textGmail.getText())) {//Utilizo este metodo del Register para validar el email
					
										
				}else {//Si no es valido saldra este mensaje
					JOptionPane.showMessageDialog(new JFrame(), "Error, Email no valido", "Proplay IT - Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		textGmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textGmail.setToolTipText("");
		textGmail.setColumns(10);
		textGmail.setBorder(null);
		textGmail.setBounds(75, 17, 189, 20);
		RestrictedTextField textGmailRestrict = new RestrictedTextField(textGmail);
		textGmailRestrict.setLimit(50);
		textGmailRestrict.setAcceptSpace(false);
		contentPane.add(textGmail);
		
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
		btnAtras.setBounds(172, 215, 102, 35);
		contentPane.add(btnAtras);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 52, 414, 152);
		textPane.setText("");
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 64, 414, 145);
		scrollPane.add(textPane);
		contentPane.add(scrollPane);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (sql.comprobGmail(textGmail.getText()) == "Gmail encontrado") {//Llamamos al metodo comproboGmail, si la salida del metodo en Smal encontrado. Mostrar los datos del usuario
					
					textPane.setText(sql.nomeacuerdoq(textGmail.getText()));//Se muestra en el textpane los datos del usuario.
					
				} else if(sql.comprobGmail(textGmail.getText()) == "Gmail no encontrado") {// Si no lo encuentra aparecera esta alarma
					JOptionPane.showMessageDialog(new JFrame(), "Error, Gmail no registrado", "ProPlay IT - Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnCheck.setForeground(Color.WHITE);
		btnCheck.setFocusTraversalKeysEnabled(false);
		btnCheck.setBorder(null);
		btnCheck.setBackground(Color.GRAY);
		btnCheck.setBounds(340, 11, 84, 35);
		contentPane.add(btnCheck);
		
	}
	
}
