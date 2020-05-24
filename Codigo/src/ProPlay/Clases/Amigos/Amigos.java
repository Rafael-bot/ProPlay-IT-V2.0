package ProPlay.Clases.Amigos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import ProPlay.Clases.Libreria.Libreria;
import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.PagPrincipal.Ventana_pagina_principal;
import ProPlay.Clases.Sql.Metodos_SQL;
import ProPlay.Clases.Tienda.FrameShopJuegos;
import javax.swing.JTextField;

public class Amigos extends JFrame {

	private JPanel contentPane;
	public JLabel lblUser;
	private ImageIcon icon;//Estas tres variable son las que utilizo para resiceear la imagen
	private Image image;
	private Image modifiImage;
	public  JLabel lblUserId;//Este label es donde va a parecer el id del usuario
	private JTextField textFriends;
	private JTextField textEliminarFriends;
	private Metodos_SQL sql = new Metodos_SQL();//Objeto para llamar a los metodo sql para interactuar con la base de datos

	/**
	 * Create the frame.
	 */
	public Amigos() {
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(Amigos.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - Amigos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 100, 338, 467);
		
		contentPane = new JPanel();
		contentPane.setDoubleBuffered(false);
		contentPane.setFocusable(false);
		contentPane.setFocusTraversalKeysEnabled(false);
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUser = new JLabel("", SwingConstants.CENTER);
		lblUser.setBackground(new Color(169, 169, 169));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBorder(null);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBounds(132, 11, 172, 26);
		contentPane.add(lblUser);
		
		lblUserId = new JLabel("",SwingConstants.CENTER);
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserId.setBorder(null);
		lblUserId.setBackground(new Color(169, 169, 169));
		lblUserId.setBounds(32, 11, 68, 26);
		contentPane.add(lblUserId);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(20, 11, 32, 26);
		contentPane.add(lblId);
		
		JLabel lblUser_1 = new JLabel("USER:");
		lblUser_1.setForeground(Color.WHITE);
		lblUser_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser_1.setBounds(144, 11, 50, 26);
		contentPane.add(lblUser_1);
		
		JLabel labelPanelSup = new JLabel("");
		labelPanelSup.setOpaque(true);
		labelPanelSup.setBackground(new Color(128, 128, 128));
		labelPanelSup.setBounds(10, 11, 296, 26);
		contentPane.add(labelPanelSup);
		
		
		
		textFriends = new JTextField();
		textFriends.setHorizontalAlignment(SwingConstants.CENTER);
		textFriends.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFriends.setBounds(53, 60, 129, 20);
		textFriends.setColumns(10);
		RestrictedTextField textFrriendsRestrict = new RestrictedTextField(textFriends);//Utilizo un libreria externa que lo que hace es poner restricciones a los textfield.
		textFrriendsRestrict.setLimit(4);//Solo va a dejar escribir maximo 4 caracteres
		textFrriendsRestrict.setOnlyNums(true);//Con esta restriccion hacemos que, Solo se puede escribir numeros
		textFrriendsRestrict.setAcceptSpace(false);//No acepta espacios
		contentPane.add(textFriends);
		
		JButton btnAadirAmigo = new JButton("A\u00F1adir Amigo");
		btnAadirAmigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
									
				if (textFriends.getText().equals("")) {//Si el usuario no ha escrito nada y le da al boton, le saltara este JoptionPane de alarma diciendo que el campo id esta vacio
					JOptionPane.showMessageDialog(new JFrame(), "El ID esta vacio","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);
				} else if (textFriends.getText().equals(lblUserId.getText())) {//Si el usuario introduce su Id l saltar este JoptionPane como alarma
					JOptionPane.showMessageDialog(new JFrame(), "No puede poner tu ID.","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);
					textFriends.setText("");//Despues del mensaje de alarma se vaciara el textfield 
				} else {
					sql.comprobUserIDAñadir(textFriends.getText(), lblUserId.getText());//llamo al metodo que comprueba el id introducid, si es correcto el usuario agregara el usuario
					textFriends.setText("");//Vacia el textfield del Id
				}

			}
		});
		btnAadirAmigo.setBorderPainted(false);
		btnAadirAmigo.setBackground(Color.GRAY);
		btnAadirAmigo.setForeground(Color.WHITE);
		btnAadirAmigo.setFocusTraversalKeysEnabled(false);
		btnAadirAmigo.setFocusPainted(false);
		btnAadirAmigo.setBounds(194, 59, 110, 23);
		contentPane.add(btnAadirAmigo);
		
		JLabel lblIdFriend = new JLabel("ID:",SwingConstants.CENTER);
		lblIdFriend.setForeground(Color.WHITE);
		lblIdFriend.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdFriend.setBounds(20, 55, 32, 26);
		contentPane.add(lblIdFriend);
		
		
		
		JLabel lblIdFriend_1 = new JLabel("ID:", SwingConstants.CENTER);
		lblIdFriend_1.setForeground(Color.WHITE);
		lblIdFriend_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdFriend_1.setBounds(20, 89, 32, 26);
		contentPane.add(lblIdFriend_1);
		
		textEliminarFriends = new JTextField();
		textEliminarFriends.setHorizontalAlignment(SwingConstants.CENTER);//El text se centra
		textEliminarFriends.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEliminarFriends.setColumns(10);
		textEliminarFriends.setBounds(53, 91, 129, 20);
		RestrictedTextField textEliminarAmigoRestrict = new RestrictedTextField(textEliminarFriends);//Aqui hemos creado la variable para restriccione del textfield
		textEliminarAmigoRestrict.setLimit(4);//Max 4caracteres
		textEliminarAmigoRestrict.setOnlyNums(true);//Solo numeros
		textEliminarAmigoRestrict.setAcceptSpace(false);//No Acepta espacios
		contentPane.add(textEliminarFriends);
		
		JButton btnEliminarAmigos = new JButton("Eliminar Amigo");
		btnEliminarAmigos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textEliminarFriends.getText().equals("")) {//Si el usuario no ha escrito nada y le da al boton, le saltara este JoptionPane de alarma diciendo que el campo id esta vacio
					JOptionPane.showMessageDialog(new JFrame(), "El ID esta vacio","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);
				} else if (textEliminarFriends.getText().equals(lblUserId.getText())) {//Si el usuario introduce su propio Id, le saltara un JoptionPane como alarma
					JOptionPane.showMessageDialog(new JFrame(), "No puede poner tu ID.","ProPlay IT - Error - Amigos",JOptionPane.WARNING_MESSAGE);
					textEliminarFriends.setText("");//se vacia el textfield
				} else {
					sql.comprobUserIDEliminar(textEliminarFriends.getText(), lblUserId.getText());//Llamamos al metodo para que compruebe si el Id que ha introducido es correcto, si no saltara un mensaje de alarma
					textEliminarFriends.setText("");//se vacia el textfield
				}
			}
		});
		btnEliminarAmigos.setForeground(Color.WHITE);
		btnEliminarAmigos.setFocusTraversalKeysEnabled(false);
		btnEliminarAmigos.setFocusPainted(false);
		btnEliminarAmigos.setBorderPainted(false);
		btnEliminarAmigos.setBackground(Color.GRAY);
		btnEliminarAmigos.setBounds(194, 93, 121, 23);
		contentPane.add(btnEliminarAmigos);
		
		JTable tableFriends = new JTable(){//Creamos la variable de un Jtable, donde aparecera los amigos del usuario
			@Override
			public boolean isCellEditable(int row, int column) {//En esta parte de codigo estamos haciendo que el usuario no pueda editar los campos de la tabla.
				return false;
			}
		};
		JScrollPane scrollPane = new JScrollPane(tableFriends);//Añadimos la tabla en ScrollPane, por que SI NO NO SE VE.
	    scrollPane.setBounds(20, 161, 284, 266);
	    contentPane.add(scrollPane);
	       
	    JButton btnMostrarAmigos = new JButton("Mostrar Amiguos");//Con este metod lo que hacemos es mostrar la tabla con los amigos del usuario
	    btnMostrarAmigos.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sql.mostrarTablaAMigo(tableFriends, lblUserId.getText());//COn este metodo lo que haceemos es editar la tabla con los datos de los amigos del usuario
	    	}
	    });
		btnMostrarAmigos.setForeground(Color.WHITE);
		btnMostrarAmigos.setFocusTraversalKeysEnabled(false);
		btnMostrarAmigos.setFocusPainted(false);
		btnMostrarAmigos.setBorderPainted(false);
		btnMostrarAmigos.setBackground(Color.GRAY);
		btnMostrarAmigos.setBounds(94, 127, 140, 23);
		contentPane.add(btnMostrarAmigos);
		
		
	}
}
