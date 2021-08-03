import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
//import Fuentes;
public class Batalla extends JFrame {

	private JPanel menu;
	private JPanel batalla;
	private boolean gana;
	private int inxC;
	private JProgressBar barraDCon,barraVCon;
	Fuentes tipoFuente;
	
	public Batalla() {
		setTitle("Seppets");
		
		menu=new Menu();
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
			sonido.start();
			sonido.loop(Clip.LOOP_CONTINUOUSLY);

			/* CARGAR IMAGENES */
			ImageIcon imgFondo = new ImageIcon(MenuPrincipal.class.getResource("/img/vs3.jpg"));
			ImageIcon imgAtaque = new ImageIcon(MenuPrincipal.class.getResource("/img/espada.jpg"));
			ImageIcon imgDefensa = new ImageIcon(MenuPrincipal.class.getResource("/img/escudo.jpg"));
			ImageIcon imgCurar = new ImageIcon(MenuPrincipal.class.getResource("/img/pocion.jpg"));
			ImageIcon imgExit = new ImageIcon(MenuPrincipal.class.getResource("/img/exit.jpg"));
			ImageIcon imgFondoM = new ImageIcon(MenuPrincipal.class.getResource("/img/menu.jpg"));
			
			// Recogemos el nombre del personaje elegido en la ventana de seleccion, para
			// ponerlo en la casilla de nuestro personaje
			String nombre = "P" + VentanaJuego.getPersonaje().toLowerCase() + ".jpg";
			ImageIcon imgPersonaje = new ImageIcon(MenuPrincipal.class.getResource("/img/" + nombre));

			
			
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
						VentanaJuego.personajes[inxC].setDefensa(dCon - VentanaJuego.personajes[inxP].getAtaque());
						int dConNew = dCon;
						barraDCon.setValue(dConNew);
					}else {
						barraDCon.setValue(0);
						System.out.println("El ataque afecta a la vida");
						VentanaJuego.personajes[inxC].setVida(vCon - VentanaJuego.personajes[inxP].getAtaque());
						barraVCon.setValue(vCon);
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

			/* LABEL EXIT */
			JLabel lblExit = new JLabel("Exit");
			lblExit.setBackground(Color.DARK_GRAY);
			lblExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					VentanaJuego.crearPersonajes();
					sonido.stop();
					dispose();
					MenuPrincipal m = new MenuPrincipal();
					m.setVisible(true);
				}
			});
			lblExit.setBounds(789, 475, 146, 55);
			lblExit.setForeground(Color.BLACK);
			lblExit.setFont(tipoFuente.fuente(tipoFuente.adumu, 40));
			//Principal.escalarImagen(imgExit, lblExit);
			batalla.add(lblExit);
			
			//menu.setVisible(true);
			/* LABEL MENU*/
			JLabel lblMenu = new JLabel("Menu");
			lblMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//AÑADIR CAPA SUPERIOR DE MENU 
					JLayeredPane layered= new JLayeredPane();
					JLabel menuFondo=new JLabel();
					menuFondo.setIcon(imgFondoM);
					menuFondo.setSize(imgFondo.getIconWidth(),imgFondo.getIconHeight());
					layered.add(getContentPane(), new Integer(1));
					layered.add(menuFondo, new Integer(2));
					
					//setContentPane(batalla).add(layered);
				}
			});
			lblMenu.setForeground(Color.BLACK);
			lblMenu.setFont(tipoFuente.fuente(tipoFuente.adumu,40));
			lblMenu.setBounds(789, 426, 134, 46);
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
}
