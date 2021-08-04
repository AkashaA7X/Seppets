import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class prueba extends JFrame {
	
	private static JLabel lblJugar;
	private static JLabel lblOpcion;
	
	public prueba() {
		ImageIcon imgM = new ImageIcon(MenuPrincipal.class.getResource("/img/menu.jpg"));
		//ImageIcon imgM = new ImageIcon(MenuPrincipal.class.getResource("/img/.jpg"));
		getContentPane().setLayout(null);
		
		/* LABEL DESPLIGUE MENU*/
		JLabel lblDesMenu = new JLabel("Despliegue menu");
		lblDesMenu.setBounds(320, 67, 310, 391);
		lblDesMenu.setVisible(false);
		//lblDesMenu.setIcon(imgFondoM);
		Principal.escalarImagen(imgM, lblDesMenu);
		add(lblDesMenu);
		
		
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		// La ventana y el layered pane.
				JFrame v = new JFrame("Ejemplo de JLayeredPane");
				JLayeredPane layered = new JLayeredPane();

				// La imagen de fondo metida en un JLabel, dandole el
				// tamano adecuado.
				JLabel fondo = new JLabel();
				ImageIcon imagen = new ImageIcon(MenuPrincipal.class.getResource("/img/menu.jpg"));
				ImageIcon imgM = new ImageIcon(MenuPrincipal.class.getResource("/img/elmo.jpg"));
				fondo.setIcon(imagen);
				fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

				// La etiqueta que ira encima de la imagen.
				JLabel primerPlano = new JLabel("Primer plano");
				primerPlano.setSize(200, 40);
				
				//La etiqueta que ira de segundo plano
				JLabel segundoPlano = lblJugar;
				//segundoPlano.setSize(300, 20);
				//segundoPlano =lblOpcion;
				
				// Se mete imagen y etiqueta en el JLayeredPane. Debe ser Integer, no vale int.
				// Los Integer bajos corresponden a capas del fondo.
				layered.add(fondo, new Integer(1));
				layered.add(primerPlano, new Integer(2));
				//layered.add(segundoPlano, new Integer(3));
				//layered.add(lblJugar, new Integer(3));
				
				// Se visualiza todo.
				v.getContentPane().add(layered);
				v.setSize(imagen.getIconWidth(), imagen.getIconHeight());
				v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				v.setVisible(true);
	}

	

}
