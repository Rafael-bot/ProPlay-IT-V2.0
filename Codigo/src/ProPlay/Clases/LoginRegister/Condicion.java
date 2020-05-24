package ProPlay.Clases.LoginRegister;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class Condicion extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Condicion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Condicion.class.getResource("/ProPlay/RecursoMultimedia/logo_size.jpg")));
		setResizable(false);
		setTitle("ProPlay IT - Condici\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextPane textCondText = new JTextPane();//Terminos de condiciones
		textCondText.setText("Parte de nuestra misi\u00F3n es:\r\n\r\n    Capacitar y atraer personas alrededor del mundo a \r\n    recopilar y desarrollar contenido educativo y publicarlo bien bajo \r\n    licencia libre o bien don\u00E1ndolo al dominio p\u00FAblico.\r\n    Diseminar ese contenido de manera efectiva y global, sin costes.\r\n\r\nUsted es libre de:\r\n\r\n    Leer e imprimir nuestros art\u00EDculos y otros recursos de \r\n    manera gratuita.\r\n    Compartir y reutilizar nuestros art\u00EDculos y otros\r\n    recursos siempre bajo licencias libres y abiertas.\r\n    Contribuir y editar en nuestros proyectos.\r\n\r\n\r\nBajo las siguientes condiciones:\r\n\r\n      Responsabilidad \u2014 Usted es responsable de sus ediciones.\r\n\tUrbanidad \u2014 Usted apoyar\u00E1 un entorno c\u00EDvico y no hostigar\u00E1 ni atacar\u00E1 a otros \tusuarios.\r\n    \tComportamiento legal \u2014 Usted no infringir\u00E1 las leyes de derechos de autor ni otras \tleyes.\r\n    \tNo da\u00F1os \u2014 Usted no da\u00F1ar\u00E1 nuestra infraestructura tecnol\u00F3gica.\r\n    \tT\u00E9rminos y condiciones de uso y pol\u00EDticas \u2014 Usted adhiere a los siguientes T\u00E9rminos y \t       condiciones y a las pol\u00EDticas de la comunidad aplicables cuando usted visita nuestros \t       sitios o participa en nuestras comunidades.\r\n\r\n\r\nCon el entendimiento de que:\r\n\r\n    \tUsted libera sus contribuciones bajo licencia libre \u2014 usted generalmente deber\u00E1 \t       licenciar sus ediciones y contribuciones a nuestros proyectos bajo \r\n       licencias libres y abiertas, salvo que sus contribuciones est\u00E9n en el dominio p\u00FAblico.\r\n    \tNo es consejo profesional \u2014 el contenido de los art\u00EDculos y otros proyectos es con \t              prop\u00F3sitos informativos y no constituye consejo profesional.");
		textCondText.setBounds(10, 11, 414, 239);
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 10, 424, 221);
		scrollPane.add(textCondText);
		contentPane.add(scrollPane);
		
		JButton btnAtras = new JButton("Atras");//Vamos hacia atra, es decir lo miminizamos
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFocusTraversalKeysEnabled(false);
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.GRAY);
		btnAtras.setBounds(153, 237, 143, 23);
		contentPane.add(btnAtras);
	
		
	}
}
