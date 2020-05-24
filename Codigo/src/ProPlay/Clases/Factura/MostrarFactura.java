package ProPlay.Clases.Factura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import Atxy2k.CustomTextField.RestrictedTextField;
import ProPlay.Clases.LoginRegister.Login;
import ProPlay.Clases.LoginRegister.NoMeAcuerdo;
import ProPlay.Clases.LoginRegister.Register;
import ProPlay.Clases.MetodosFicheros.MetodoFichero;
import ProPlay.Clases.Tienda.FrameShopJuegos;

public class MostrarFactura extends JFrame {

	private JPanel contentPane;
	public JTextComponent textPane;

	/**
	 * Create the frame.
	 */
	public MostrarFactura() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NoMeAcuerdo.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setTitle("ProPlay IT - Mostrar Factura");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		textPane = new JTextPane();//En este textpane se mostrara la factura
		textPane.setEditable(false);
		textPane.setBounds(10, 52, 414, 152);
		textPane.setText("");
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 64, 414, 145);
		scrollPane.add(textPane);
		contentPane.add(scrollPane);
		
		JButton btnAtras = new JButton("Atras");//El usuario le pulsara este boton para irse a la tienda
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoFichero fich = new MetodoFichero();
				fich.vaciarfactura();//Con este metodo vaciaremos el fcihero txt donde estaba la factura p
				dispose();//Mimminizamos esta ventana
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFocusTraversalKeysEnabled(false);
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.GRAY);
		btnAtras.setBounds(172, 215, 102, 35);
		contentPane.add(btnAtras);
	}

}
