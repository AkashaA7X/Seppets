import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MenuPrincipal extends JFrame {

	/* Labels de opciones*/
	private JLabel lblDesOpciones;
	private JLabel lblVolumen;
	//private JSlider jsVol;
	private JLabel lblVolver;
	private int vol;
	
	Fuentes tipoFuente;
	private JPanel menuPrincipal;
	static boolean clickBoton=false;
	
	public MenuPrincipal() {
		
		tipoFuente =new Fuentes();
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
		ImageIcon imgFondoO = new ImageIcon(MenuPrincipal.class.getResource("/img/opciones.jpg"));
		
		/* LABEL VOLUMEN*/
		lblVolumen =new JLabel("Volumen");
		lblVolumen.setBounds(297, 211, 140, 28);
		lblVolumen.setVisible(false);
		lblVolumen.setForeground(Color.WHITE);
		lblVolumen.setFont(tipoFuente.fuente(tipoFuente.adumu, 28));
		menuPrincipal.add(lblVolumen);
		
		
		/* LABEL VOLVER*/
		lblVolver =new JLabel("Volver");
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				activarOpciones(false);
			}
		});
		lblVolver.setBounds(297, 390, 115, 28);
		lblVolver.setVisible(false);
		lblVolver.setForeground(Color.WHITE);
		lblVolver.setFont(tipoFuente.fuente(tipoFuente.adumu, 28));
		menuPrincipal.add(lblVolver);
		
		/* LABEL DESPLIEGUE OPCIONES*/
		lblDesOpciones = new JLabel("Menu Opciones");
		lblDesOpciones.setBounds(254, 79, 441, 360);
		lblDesOpciones.setVisible(false);
		Principal.escalarImagen(imgFondoO, lblDesOpciones);
		menuPrincipal.add(lblDesOpciones);
		
		/*LABEL TITULO*/
		JLabel lblTitulo = new JLabel("titulo");
		lblTitulo.setBounds(0, 0, 325, 107);
		Principal.escalarImagen(imgTit,lblTitulo);
		menuPrincipal.add(lblTitulo);
		
		/*LABEL JUGAR*/
		JLabel lblJugar = new JLabel("Jugar");
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
		lblJugar.setBounds(32, 151, 269, 71);
		lblJugar.setForeground(Color.WHITE);
		lblJugar.setFont(tipoFuente.fuente(tipoFuente.adumu,60));
		menuPrincipal.add(lblJugar);
		
		/*LABEL OPCIONES*/
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			Principal.sound("boton",false);
		}			
		@Override
		public void mouseClicked(MouseEvent e) {
			activarOpciones(true);
		}
});
		lblOpciones.setBounds(32, 270, 318, 71);
		lblOpciones.setForeground(Color.WHITE);
		lblOpciones.setFont(tipoFuente.fuente(tipoFuente.adumu,60));
		menuPrincipal.add(lblOpciones);
		
		/*LABEL SALIR*/
		JLabel lblSalir = new JLabel("Salir");
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
		lblSalir.setBounds(32, 393, 269, 71);
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(tipoFuente.fuente(tipoFuente.adumu,60));
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
	
	public void activarOpciones(boolean activar) {
		this.lblDesOpciones.setVisible(activar);
		this.lblVolumen.setVisible(activar);
		//this.jsVol.setVisible(activar);
		this.lblVolver.setVisible(activar);
	}
	
}
