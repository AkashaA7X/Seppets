import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Batalla extends JFrame {

	//private JPanel menu;
	private JPanel batalla;
	private boolean gana;
	private int inxC;
	private JProgressBar barraDCon,barraVCon;
	Fuentes tipoFuente;
	
	/*Labeles menu desplegable*/
	private JLabel lblDesMenu;
	private JLabel lblReanudar;
	private JLabel lblOpciones;
	private JLabel lblSalir;
	private JLabel lblDesOpciones;
	private JLabel lblVolumen;
	private JSlider jsVol;
	private JLabel lblVolver;
	private int vol;
	
	public Batalla() {
		setTitle("Seppets");
		tipoFuente=new Fuentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 596);
		batalla = new JPanel();
		batalla.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(batalla);
		batalla.setLayout(null);

		/* CARGAR MUSICA DE FONDO */
		try {
			String ruta = "src/sounds/fondoBatalla1.wav";
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			FloatControl controlVolumen =(FloatControl)sonido.getControl(FloatControl.Type.MASTER_GAIN);
			sonido.start();
			sonido.loop(Clip.LOOP_CONTINUOUSLY);

			/* CARGAR IMAGENES */
			ImageIcon imgFondo = new ImageIcon(MenuPrincipal.class.getResource("/img/vs3.jpg"));
			ImageIcon imgAtaque = new ImageIcon(MenuPrincipal.class.getResource("/img/espada.jpg"));
			ImageIcon imgDefensa = new ImageIcon(MenuPrincipal.class.getResource("/img/escudo.jpg"));
			ImageIcon imgCurar = new ImageIcon(MenuPrincipal.class.getResource("/img/pocion.jpg"));
			ImageIcon imgFondoO = new ImageIcon(MenuPrincipal.class.getResource("/img/opciones.jpg"));
			ImageIcon imgFondoM = new ImageIcon(MenuPrincipal.class.getResource("/img/menu.jpg"));
			
			// Recogemos el nombre del personaje elegido en la ventana de seleccion, para ponerlo en la casilla de nuestro personaje
			String nombre = "P" + VentanaJuego.getPersonaje().toLowerCase() + ".jpg";
			ImageIcon imgPersonaje = new ImageIcon(MenuPrincipal.class.getResource("/img/" + nombre));

			/* LABEL VOLUMEN*/
			lblVolumen =new JLabel("Volumen");
			lblVolumen.setBounds(297, 211, 140, 28);
			lblVolumen.setVisible(false);
			lblVolumen.setForeground(Color.WHITE);
			lblVolumen.setFont(tipoFuente.fuente(tipoFuente.adumu, 28));
			batalla.add(lblVolumen);
			
			/* SLIDER VOLUMEN*/
			jsVol = new JSlider(-80,6,-20);
			jsVol.setVisible(false);
			jsVol.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					//Recogemos en tiempo real el movimiento que hace el usuario en el Slider y lo colocamos en el controlVolumen
					vol=jsVol.getValue();
					controlVolumen.setValue(vol);
				}
			});
			jsVol.setBounds(478, 213, 200, 26);
			batalla.add(jsVol);
			
			/* LABEL VOLVER*/
			lblVolver =new JLabel("Volver");
			lblVolver.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					activarOpciones(false);
					activarMenu(true);
				}
			});
			lblVolver.setBounds(297, 390, 115, 28);
			lblVolver.setVisible(false);
			lblVolver.setForeground(Color.WHITE);
			lblVolver.setFont(tipoFuente.fuente(tipoFuente.adumu, 28));
			batalla.add(lblVolver);
			
			/* LABEL DESPLIEGUE OPCIONES*/
			lblDesOpciones = new JLabel("Menu Opciones");
			lblDesOpciones.setBounds(254, 79, 441, 360);
			lblDesOpciones.setVisible(false);
			Principal.escalarImagen(imgFondoO, lblDesOpciones);
			batalla.add(lblDesOpciones);
			
			/* LABEL REANUDAR*/
			lblReanudar = new JLabel("Reanudar");
			lblReanudar.setVisible(false);
			lblReanudar.setBackground(Color.DARK_GRAY);
			lblReanudar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//Volvemos a la pantalla de batalla,desactivando el despliegue del menu
					activarMenu(false);
				}
			});
			lblReanudar.setBounds(393, 187, 172, 52);
			lblReanudar.setForeground(Color.BLACK);
			lblReanudar.setFont(tipoFuente.fuente(tipoFuente.adumu, 30));
			batalla.add(lblReanudar);
			
			/* LABEL OPCIONES */
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setVisible(false);
			lblOpciones.setBackground(Color.DARK_GRAY);
			lblOpciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					//Se invisibiliza el menu, se abre el panel de opciones, el volver de opciones te lleva al menu
					activarMenu(false);
					activarOpciones(true);
				}
			});
			lblOpciones.setBounds(404, 270, 161, 52);
			lblOpciones.setForeground(Color.BLACK);
			lblOpciones.setFont(tipoFuente.fuente(tipoFuente.adumu, 30));
			batalla.add(lblOpciones);
			
			/* LABEL EXIT */
			lblSalir = new JLabel("Salir");
			lblSalir.setVisible(false);
			lblSalir.setBackground(Color.DARK_GRAY);
			lblSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					VentanaJuego.crearPersonajes();
					sonido.stop();
					dispose();
					MenuPrincipal m = new MenuPrincipal();
					m.setVisible(true);
				}
			});
			lblSalir.setBounds(425, 357, 113, 48);
			lblSalir.setForeground(Color.BLACK);
			lblSalir.setFont(tipoFuente.fuente(tipoFuente.adumu, 40));
			batalla.add(lblSalir);
			
			/* LABEL DESPLIGUE MENU*/
			lblDesMenu = new JLabel("Despliegue menu");
			lblDesMenu.setBounds(320, 67, 310, 391);
			lblDesMenu.setVisible(false);
			Principal.escalarImagen(imgFondoM, lblDesMenu);
			batalla.add(lblDesMenu);
			
			
			/* LABEL NOMBRE PERSONAJE */
			JLabel lblNombreP = new JLabel(VentanaJuego.getPersonaje());
			lblNombreP.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreP.setForeground(Color.BLACK);
			lblNombreP.setBackground(Color.DARK_GRAY);
			lblNombreP.setFont(tipoFuente.fuente(tipoFuente.adumu, 30));
			lblNombreP.setBounds(26, 28, 219, 28);
			batalla.add(lblNombreP);

			/* LABEL IMAGEN PERSONAJE */
			JLabel lblPersonajeElegido = new JLabel("Personaje elegido");
			lblPersonajeElegido.setBounds(20, 90, 464, 315);
			Principal.escalarImagen(imgPersonaje, lblPersonajeElegido);
			batalla.add(lblPersonajeElegido);

			/* BARRA DE VIDA PERSONAJE */
			JProgressBar barraVPer = new JProgressBar();
			barraVPer.setValue(VentanaJuego.personajeElegido.getVida());
			barraVPer.setForeground(Color.RED);
			barraVPer.setStringPainted(true);
			barraVPer.setBounds(244, 21, 146, 24);
			batalla.add(barraVPer);

			/* BARRA DEFENSA PERSONAJE */
			JProgressBar barraDPer = new JProgressBar();
			barraDPer.setValue(VentanaJuego.personajeElegido.getDefensa());
			barraDPer.setStringPainted(true);
			barraDPer.setForeground(new Color(0, 206, 209));
			barraDPer.setBounds(244, 55, 146, 24);
			batalla.add(barraDPer);

			/* COLOCAR CONTRINCANTE */
			String imgC = "";
			inxC = 12;
			int inxP = VentanaJuego.getInx(VentanaJuego.getPersonaje());
			System.out.println("Inx del personaje: " + inxP);

			if (inxP >= 0 && inxP <= 5) {
				System.out.println("EL personaje es del grupo Barrio Sesamo");
				inxC = 6;
				imgC = "P" + VentanaJuego.personajes[inxC].getNombre().toLowerCase() + ".jpg";
			} else if (inxP >= 6 && inxP <= 11) {
				System.out.println("El personaje es del grupo Muppets");
				inxC = 0;
				imgC = "P" + VentanaJuego.personajes[inxC].getNombre().toLowerCase() + ".jpg";
			}

			/* LABEL NOMBRE CONTRINCANTE */
			JLabel lblNombreC = new JLabel(VentanaJuego.personajes[inxC].getNombre());
			lblNombreC.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreC.setForeground(Color.BLACK);
			lblNombreC.setBackground(Color.DARK_GRAY);
			lblNombreC.setFont(tipoFuente.fuente(tipoFuente.adumu, 30));
			lblNombreC.setBounds(573, 21, 225, 35);
			batalla.add(lblNombreC);

			/* LABEL IMAGEN CONTRINCANTE */
			JLabel lblContrincante = new JLabel("Contrincante");
			ImageIcon imgContrincante = new ImageIcon(MenuPrincipal.class.getResource("/img/" + imgC));
			lblContrincante.setBounds(490, 90, 469, 315);
			Principal.escalarImagen(imgContrincante, lblContrincante);
			batalla.add(lblContrincante);

			/* BARRA DE VIDA CONTRINCANTE */
			//JProgressBar 
			barraVCon = new JProgressBar();
			barraVCon.setValue(VentanaJuego.personajes[inxC].getVida());
			barraVCon.setStringPainted(true);
			barraVCon.setForeground(Color.RED);
			barraVCon.setBounds(808, 21, 146, 24);
			batalla.add(barraVCon);

			/* BARRA DEFENSA CONTRINCANTE */
			// JProgressBar
			barraDCon = new JProgressBar();
			barraDCon.setValue(VentanaJuego.personajes[inxC].getDefensa());
			barraDCon.setStringPainted(true);
			barraDCon.setForeground(new Color(0, 206, 209));
			barraDCon.setBounds(808, 55, 146, 24);
			batalla.add(barraDCon);

			/* LABEL ATACAR */
			JLabel lblAtaque = new JLabel("Ataque");
			lblAtaque.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					System.out.println("Se activa atacar");
					int dPer = VentanaJuego.personajes[inxP].getDefensa();
					int dCon = VentanaJuego.personajes[inxC].getDefensa();
					int vPer = VentanaJuego.personajes[inxP].getVida();
					int vCon = VentanaJuego.personajes[inxC].getVida();
					System.out.println(dCon);
					// Se le modifica al personaje contrincante su defensa, restandole el ataque del personaje
					if (dCon >= 0) {
						int dConNew = dCon - VentanaJuego.personajes[inxP].getAtaque();
						VentanaJuego.personajes[inxC].setDefensa(dCon - VentanaJuego.personajes[inxP].getAtaque());
						barraDCon.setValue(dConNew);
					}else {
						barraDCon.setValue(0);
						System.out.println("El ataque afecta a la vida");
						int vConNew = vCon - VentanaJuego.personajes[inxP].getAtaque();
						VentanaJuego.personajes[inxC].setVida(vCon - VentanaJuego.personajes[inxP].getAtaque());
						barraVCon.setValue(vConNew);
					}
				}
			});
			lblAtaque.setBounds(71, 450, 85, 80);
			Principal.escalarImagen(imgAtaque, lblAtaque);
			batalla.add(lblAtaque);

			/* LABEL ESCUDO */
			JLabel lblDefensa = new JLabel("Defensa");
			lblDefensa.setBounds(208, 450, 85, 80);
			Principal.escalarImagen(imgDefensa, lblDefensa);
			batalla.add(lblDefensa);

			/* LABEL CURAR */
			JLabel lblCurar = new JLabel("Curar");
			lblCurar.setBounds(374, 450, 85, 80);
			Principal.escalarImagen(imgCurar, lblCurar);
			batalla.add(lblCurar);

//			/* LABEL EXIT */
//			JLabel lblExit = new JLabel("Exit");
//			lblExit.setBackground(Color.DARK_GRAY);
//			lblExit.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent arg0) {
//					VentanaJuego.crearPersonajes();
//					sonido.stop();
//					dispose();
//					MenuPrincipal m = new MenuPrincipal();
//					m.setVisible(true);
//				}
//			});
//			lblExit.setBounds(789, 475, 146, 55);
//			lblExit.setForeground(Color.BLACK);
//			lblExit.setFont(tipoFuente.fuente(tipoFuente.adumu, 40));
//			//Principal.escalarImagen(imgExit, lblExit);
//			batalla.add(lblExit);
			
			
			
			/* LABEL MENU*/
			JLabel lblMenu = new JLabel("Menu");
			lblMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//AÑADIR CAPA SUPERIOR DE MENU 
					lblDesMenu.setVisible(true);
					lblReanudar.setVisible(true);
					lblOpciones.setVisible(true);
					lblSalir.setVisible(true);
				}
			});
			lblMenu.setForeground(Color.BLACK);
			lblMenu.setFont(tipoFuente.fuente(tipoFuente.adumu,40));
			lblMenu.setBounds(791, 484, 134, 46);
			batalla.add(lblMenu);
			
			/* LABEL FONDO */
			JLabel lblFondo = new JLabel("Fondo");
			lblFondo.setBounds(0, 0, 980, 557);
			Principal.escalarImagen(imgFondo, lblFondo);
			batalla.add(lblFondo);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error");
		}
	}
	
	public void activarMenu(boolean activar) {
		this.lblDesMenu.setVisible(activar);
		this.lblReanudar.setVisible(activar);
		this.lblOpciones.setVisible(activar);
		this.lblSalir.setVisible(activar);
	}
	
	public void activarOpciones(boolean activar) {
		this.lblDesOpciones.setVisible(activar);
		this.lblVolumen.setVisible(activar);
		this.jsVol.setVisible(activar);
		this.lblVolver.setVisible(activar);
	}
}
