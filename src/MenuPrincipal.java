import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MenuPrincipal extends JFrame {

	private JPanel menuPrincipal;
	static boolean clickBoton=false;
	
	public MenuPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 596);
		menuPrincipal = new JPanel();
		menuPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menuPrincipal);
		menuPrincipal.setLayout(null);
		
		/*CARGAR IMAGENES*/
		ImageIcon imgFondo = new ImageIcon(MenuPrincipal.class.getResource("/img/fondoJuego.jpg"));
		ImageIcon imgJugar = new ImageIcon(MenuPrincipal.class.getResource("/img/jugar.jpg"));
		ImageIcon imgOpc = new ImageIcon(MenuPrincipal.class.getResource("/img/opciones.jpg"));
		ImageIcon imgTit = new ImageIcon(MenuPrincipal.class.getResource("/img/titulo.jpg"));
		ImageIcon imgSalir = new ImageIcon(MenuPrincipal.class.getResource("/img/salir.jpg"));
		
		/*LABEL TITULO*/
		JLabel lblTitulo = new JLabel("titulo");
		lblTitulo.setBounds(0, 0, 325, 107);
		Principal.escalarImagen(imgTit,lblTitulo);
		menuPrincipal.add(lblTitulo);
		
		/*LABEL JUGAR*/
		JLabel lblJugar = new JLabel("jugar");
		lblJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Se cierra la ventana menu principal y se abre la ventana de juego
				dispose();
				VentanaJuego ventJ = new VentanaJuego();
				ventJ.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Principal.sound("botonJ",false);
			}
		});
		lblJugar.setBounds(20, 151, 281, 71);
		Principal.escalarImagen(imgJugar,lblJugar);
		menuPrincipal.add(lblJugar);
		
		/*LABEL OPCIONES*/
		JLabel lblOpciones = new JLabel("opciones");
		lblOpciones.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			Principal.sound("boton",false);
		}});
		lblOpciones.setBounds(20, 270, 281, 71);
		Principal.escalarImagen(imgOpc,lblOpciones);
		menuPrincipal.add(lblOpciones);
		
		/*LABEL SALIR*/
		JLabel lblSalir = new JLabel("salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Principal.sound("botonS",false);
			}
		});
		lblSalir.setBounds(20, 393, 281, 71);
		Principal.escalarImagen(imgSalir,lblSalir);
		menuPrincipal.add(lblSalir);
		
		
		
		/*LABEL FONDO*/
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setBounds(0, 0, 980, 557);
		Principal.escalarImagen(imgFondo,lblFondo);
		menuPrincipal.add(lblFondo);
		
	}
	
	public boolean getClickBoton() {
		return clickBoton;
	}
	
}
