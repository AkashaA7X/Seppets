import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame {

	Fuentes tipoFuente;
	private JPanel Juego;
	public static JLabel lblCelmo,lblCgustavo,lblCgalleta,lblCpeggy,lblCgonzo,lblCcaponata,lblCanimal,lblCepiblas,lblCmimimi,lblCcoco,lblCcrazyHarry,lblCgruñon;
	public static Personajes[] personajes={
			new Personajes("Elmo",60,35),
			new Personajes("Galletas",45,45),
			new Personajes("Caponata",80,35),
			new Personajes("EpiBlas",100,25),
			new Personajes("Coco",60,40),
			new Personajes("Gruñon",100,30),
			new Personajes("Gustavo",50,55),
			new Personajes("Peggy",60,55),
			new Personajes("Gonzo",40,55),
			new Personajes("Animal",30,70),
			new Personajes("Mimimi",80,30),
			new Personajes("CrazyHarry",20,75)};
	
	public static Personajes personajeElegido=new Personajes("");
	
	public VentanaJuego() {

		tipoFuente=new Fuentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 596);
		Juego = new JPanel();
		Juego.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Juego);
		Juego.setLayout(null);

		/* CARGAR MUSICA DE FONDO */

		try {
			String ruta = "src/sounds/fondoSelecP.wav";
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();
			sonido.loop(Clip.LOOP_CONTINUOUSLY); // repetir siempre

			/* CARGAR IMAGENES */
			ImageIcon imgConfirmar = new ImageIcon(MenuPrincipal.class.getResource("/img/confirmar.jpg"));
			ImageIcon imgAltOn = new ImageIcon(MenuPrincipal.class.getResource("/img/altavozOn.jpg"));
			ImageIcon imgAltOff = new ImageIcon(MenuPrincipal.class.getResource("/img/altavozOff.jpg"));
			ImageIcon imgFondo = new ImageIcon(MenuPrincipal.class.getResource("/img/elmo.jpg"));
			ImageIcon imgTituloP = new ImageIcon(MenuPrincipal.class.getResource("/img/tituloSelecP.jpg"));
			ImageIcon imgVolver = new ImageIcon(MenuPrincipal.class.getResource("/img/volver.jpg"));
			/*PERSONAJES SIN PRESIONAR*/
			ImageIcon imgPelmo = new ImageIcon(MenuPrincipal.class.getResource("/img/Pelmo.jpg"));
			ImageIcon imgPgustavo = new ImageIcon(MenuPrincipal.class.getResource("/img/Pgustavo.jpg"));
			ImageIcon imgPgalleta = new ImageIcon(MenuPrincipal.class.getResource("/img/Pgalletas.jpg"));
			ImageIcon imgPpeggy = new ImageIcon(MenuPrincipal.class.getResource("/img/Ppeggy.jpg"));
			ImageIcon imgPgonzo = new ImageIcon(MenuPrincipal.class.getResource("/img/Pgonzo.jpg"));
			ImageIcon imgPcaponata = new ImageIcon(MenuPrincipal.class.getResource("/img/Pcaponata.jpg"));
			ImageIcon imgPanimal = new ImageIcon(MenuPrincipal.class.getResource("/img/Panimal.jpg"));
			ImageIcon imgPepiblas = new ImageIcon(MenuPrincipal.class.getResource("/img/Pepiblas.jpg"));
			ImageIcon imgPmimimi = new ImageIcon(MenuPrincipal.class.getResource("/img/Pmimimi.jpg"));
			ImageIcon imgPcoco = new ImageIcon(MenuPrincipal.class.getResource("/img/Pcoco.jpg"));
			ImageIcon imgPcrazyHarry = new ImageIcon(MenuPrincipal.class.getResource("/img/PcrazyHarry.jpg"));
			ImageIcon imgPgruñon = new ImageIcon(MenuPrincipal.class.getResource("/img/Pgruñon.jpg"));
			
			/*PERSONAJES*/
			
			/* LABEL SELECCION PERSONAJE*/
			JLabel lblPSelec = new JLabel("");
			lblPSelec.setForeground(Color.WHITE);
			lblPSelec.setBackground(Color.DARK_GRAY);
			lblPSelec.setHorizontalAlignment(SwingConstants.CENTER);
			lblPSelec.setFont(tipoFuente.fuente(tipoFuente.adumu, 20));
			lblPSelec.setBounds(292, 457, 309, 81);
			Juego.add(lblPSelec);
			
			/* LABEL TITULO */
			JLabel lblTitulo = new JLabel("Selecciona Personaje");
			lblTitulo.setBounds(149, 0, 637, 95);
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setFont(tipoFuente.fuente(tipoFuente.adumu, 50));
			//Principal.escalarImagen(imgTituloP, lblTitulo);
			Juego.add(lblTitulo);

			/* PERSONAJES BARRIO SESAMO */
			/* CASILLA 0-0 */
			
			lblCelmo = new JLabel("Casilla Elmo");
			lblCelmo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(Principal.seleccionar("Pelmo", lblCelmo)==false) {
						//Si devuelve true es que hay que desmarcar las imagenes presionadas
						System.out.println("press ha sido activado en otra casilla E");
						System.out.println("Se desmarcan casillas:");
						//Principal.desmarcar();
						Principal.seleccionar("Pelmo", lblCelmo);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[0];
						System.out.println(personajes[0].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[0].getNombre()+"</p><p>VIDA: "+personajes[0].getVida()+" DEFENSA: "+personajes[0].getDefensa()+"</p><p>ATAQUE: "+personajes[0].getAtaque()+"</p></html>");
						
					}
//					else {
//						System.out.println("La casilla esta desmarcada");
//						Principal.seleccionar("Pelmo", lblCelmo);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[0];
//						System.out.println(personajes[0].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[0].getNombre()+"</p><p>VIDA: "+personajes[0].getVida()+" DEFENSA: "+personajes[0].getDefensa()+"</p><p>ATAQUE: "+personajes[0].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCelmo.setBounds(43, 113, 117, 126);
			Principal.escalarImagen(imgPelmo, lblCelmo);
			Juego.add(lblCelmo);

			/* CASILLA 0-1 */
			
			lblCgalleta = new JLabel("Casilla Galleta");
			lblCgalleta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(Principal.seleccionar("Pgalletas", lblCgalleta)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pgalletas", lblCgalleta);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[1];
						System.out.println(personajes[1].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[1].getNombre()+"</p><p>VIDA: "+personajes[1].getVida()+" DEFENSA: "+personajes[1].getDefensa()+"</p><p>ATAQUE: "+personajes[1].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pgalletas", lblCgalleta);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[1];
//						System.out.println(personajes[1].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[1].getNombre()+"</p><p>VIDA: "+personajes[1].getVida()+" DEFENSA: "+personajes[1].getDefensa()+"</p><p>ATAQUE: "+personajes[1].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCgalleta.setBounds(190, 113, 117, 126);
			Principal.escalarImagen(imgPgalleta, lblCgalleta);
			Juego.add(lblCgalleta);

			/* CASILLA 0-2 */
			
			lblCcaponata = new JLabel("Casilla Caponata");
			lblCcaponata.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Pcaponata", lblCcaponata)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pcaponata", lblCcaponata);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[2];
						System.out.println(personajes[2].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[2].getNombre()+"</p><p>VIDA: "+personajes[2].getVida()+" DEFENSA: "+personajes[2].getDefensa()+"</p><p>ATAQUE: "+personajes[2].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pcaponata", lblCcaponata);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[2];
//						System.out.println(personajes[2].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[2].getNombre()+"</p><p>VIDA: "+personajes[2].getVida()+" DEFENSA: "+personajes[2].getDefensa()+"</p><p>ATAQUE: "+personajes[2].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCcaponata.setBounds(337, 113, 117, 126);
			Principal.escalarImagen(imgPcaponata, lblCcaponata);
			Juego.add(lblCcaponata);

			/* CASILLA 0-3 */
			
			lblCepiblas = new JLabel("Casilla EpiBlas");
			lblCepiblas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Pepiblas", lblCepiblas)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pepiblas", lblCepiblas);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[3];
						System.out.println(personajes[3].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[3].getNombre()+"</p><p>VIDA: "+personajes[3].getVida()+" DEFENSA: "+personajes[3].getDefensa()+"</p><p>ATAQUE: "+personajes[3].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pepiblas", lblCepiblas);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[3];
//						System.out.println(personajes[3].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[3].getNombre()+"</p><p>VIDA: "+personajes[3].getVida()+" DEFENSA: "+personajes[3].getDefensa()+"</p><p>ATAQUE: "+personajes[3].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCepiblas.setBounds(484, 113, 117, 126);
			Principal.escalarImagen(imgPepiblas, lblCepiblas);
			Juego.add(lblCepiblas);

			/* CASILLA 0-4 */
			
			lblCcoco = new JLabel("Casilla Coco");
			lblCcoco.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Pcoco", lblCcoco)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pcoco", lblCcoco);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[4];
						System.out.println(personajes[4].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[4].getNombre()+"</p><p>VIDA: "+personajes[4].getVida()+" DEFENSA: "+personajes[4].getDefensa()+"</p><p>ATAQUE: "+personajes[4].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pcoco", lblCcoco);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[4];
//						System.out.println(personajes[4].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[4].getNombre()+"</p><p>VIDA: "+personajes[4].getVida()+" DEFENSA: "+personajes[4].getDefensa()+"</p><p>ATAQUE: "+personajes[4].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCcoco.setBounds(631, 113, 117, 126);
			Principal.escalarImagen(imgPcoco, lblCcoco);
			Juego.add(lblCcoco);

			/* CASILLA 0-5 */
			
			lblCgruñon = new JLabel("Casilla Gruñon");
			lblCgruñon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Pgruñon", lblCgruñon)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pgruñon", lblCgruñon);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[5];
						System.out.println(personajes[5].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[5].getNombre()+"</p><p>VIDA: "+personajes[5].getVida()+" DEFENSA: "+personajes[5].getDefensa()+"</p><p>ATAQUE: "+personajes[5].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pgruñon", lblCgruñon);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[5];
//						System.out.println(personajes[5].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[5].getNombre()+"</p><p>VIDA: "+personajes[5].getVida()+" DEFENSA: "+personajes[5].getDefensa()+"</p><p>ATAQUE: "+personajes[5].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCgruñon.setBounds(778, 113, 117, 126);
			Principal.escalarImagen(imgPgruñon, lblCgruñon);
			Juego.add(lblCgruñon);

			/* PERSONAJES MUPPETS */

			/* CASILLA 1-0 */
			
			lblCgustavo = new JLabel("Casilla Gustavo");
			lblCgustavo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Pgustavo", lblCgustavo)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pgustavo", lblCgustavo);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[6];
						System.out.println(personajes[6].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[6].getNombre()+"</p><p>VIDA: "+personajes[6].getVida()+" DEFENSA: "+personajes[6].getDefensa()+"</p><p>ATAQUE: "+personajes[6].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pgustavo", lblCgustavo);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[6];
//						System.out.println(personajes[6].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[6].getNombre()+"</p><p>VIDA: "+personajes[6].getVida()+" DEFENSA: "+personajes[6].getDefensa()+"</p><p>ATAQUE: "+personajes[6].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCgustavo.setBounds(43, 289, 117, 126);
			Principal.escalarImagen(imgPgustavo, lblCgustavo);
			Juego.add(lblCgustavo);

			/* CASILLA 1-1 */
			
			lblCpeggy = new JLabel("Casilla Peggy");
			lblCpeggy.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Ppeggy", lblCpeggy)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Ppeggy", lblCpeggy);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[7];
						System.out.println(personajes[7].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[7].getNombre()+"</p><p>VIDA: "+personajes[7].getVida()+" DEFENSA: "+personajes[7].getDefensa()+"</p><p>ATAQUE: "+personajes[7].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Ppeggy", lblCpeggy);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[7];
//						System.out.println(personajes[7].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[7].getNombre()+"</p><p>VIDA: "+personajes[7].getVida()+" DEFENSA: "+personajes[7].getDefensa()+"</p><p>ATAQUE: "+personajes[7].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCpeggy.setBounds(190, 289, 117, 126);
			Principal.escalarImagen(imgPpeggy, lblCpeggy);
			Juego.add(lblCpeggy);

			/* CASILLA 1-2 */
			
			lblCgonzo = new JLabel("Casilla Gonzo");
			lblCgonzo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Pgonzo", lblCgonzo)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pgonzo", lblCgonzo);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[8];
						System.out.println(personajes[8].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[8].getNombre()+"</p><p>VIDA: "+personajes[8].getVida()+" DEFENSA: "+personajes[8].getDefensa()+"</p><p>ATAQUE: "+personajes[8].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pgonzo", lblCgonzo);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[8];
//						System.out.println(personajes[8].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[8].getNombre()+"</p><p>VIDA: "+personajes[8].getVida()+" DEFENSA: "+personajes[8].getDefensa()+"</p><p>ATAQUE: "+personajes[8].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCgonzo.setBounds(337, 289, 117, 126);
			Principal.escalarImagen(imgPgonzo, lblCgonzo);
			Juego.add(lblCgonzo);

			/* CASILLA 1-3 */
			
			lblCanimal = new JLabel("Casilla Animal");
			lblCanimal.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Panimal", lblCanimal)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Panimal", lblCanimal);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[9];
						System.out.println(personajes[9].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[9].getNombre()+"</p><p>VIDA: "+personajes[9].getVida()+" DEFENSA: "+personajes[9].getDefensa()+"</p><p>ATAQUE: "+personajes[9].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Panimal", lblCanimal);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[9];
//						System.out.println(personajes[9].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[9].getNombre()+"</p><p>VIDA: "+personajes[9].getVida()+" DEFENSA: "+personajes[9].getDefensa()+"</p><p>ATAQUE: "+personajes[9].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCanimal.setBounds(484, 289, 117, 126);
			Principal.escalarImagen(imgPanimal, lblCanimal);
			Juego.add(lblCanimal);

			/* CASILLA 1-4 */
			
			lblCmimimi = new JLabel("Casilla Mimimi");
			lblCmimimi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("Pmimimi", lblCmimimi)==false) {
						Principal.desmarcar();
						Principal.seleccionar("Pmimimi", lblCmimimi);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[10];
						System.out.println(personajes[10].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[10].getNombre()+"</p><p>VIDA: "+personajes[10].getVida()+" DEFENSA: "+personajes[10].getDefensa()+"</p><p>ATAQUE: "+personajes[10].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("Pmimimi", lblCmimimi);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[10];
//						System.out.println(personajes[10].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[10].getNombre()+"</p><p>VIDA: "+personajes[10].getVida()+" DEFENSA: "+personajes[10].getDefensa()+"</p><p>ATAQUE: "+personajes[10].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCmimimi.setBounds(631, 289, 117, 126);
			Principal.escalarImagen(imgPmimimi, lblCmimimi);
			Juego.add(lblCmimimi);

			/* CASILLA 1-5 */
			
			lblCcrazyHarry = new JLabel("Casilla crazy Harry");
			lblCcrazyHarry.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(Principal.seleccionar("PcrazyHarry", lblCcrazyHarry)==false) {
						Principal.desmarcar();
						Principal.seleccionar("PcrazyHarry", lblCcrazyHarry);
						/*CONEXION CON PERSONAJES*/
						personajeElegido=personajes[11];
						System.out.println(personajes[11].toString());
						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[11].getNombre()+"</p><p>VIDA: "+personajes[11].getVida()+" DEFENSA: "+personajes[11].getDefensa()+"</p><p>ATAQUE: "+personajes[11].getAtaque()+"</p></html>");
					}
//					else {
//						Principal.seleccionar("PcrazyHarry", lblCcrazyHarry);
//						/*CONEXION CON PERSONAJES*/
//						personajeElegido=personajes[11];
//						System.out.println(personajes[11].toString());
//						lblPSelec.setText("<html><p>PERSONAJE: "+personajes[11].getNombre()+"</p><p>VIDA: "+personajes[11].getVida()+" DEFENSA: "+personajes[11].getDefensa()+"</p><p>ATAQUE: "+personajes[11].getAtaque()+"</p></html>");
//					}
				}
			});
			lblCcrazyHarry.setBounds(778, 289, 117, 126);
			Principal.escalarImagen(imgPcrazyHarry, lblCcrazyHarry);
			Juego.add(lblCcrazyHarry);

			/* LABEL VOLVER */
			JLabel lblVolver = new JLabel("Volver");
			lblVolver.setForeground(Color.WHITE);
			lblVolver.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// Se cierra la ventana de juego y vuelve (abre) la ventana de menu principal
					sonido.stop();
					dispose();
					MenuPrincipal menuP = new MenuPrincipal();
					menuP.setVisible(true);
				}
			});
			lblVolver.setBounds(781, 473, 174, 73);
			lblVolver.setFont(tipoFuente.fuente(tipoFuente.adumu, 40));
			//Principal.escalarImagen(imgVolver, lblVolver);
			Juego.add(lblVolver);
			
			/*LABEL ALTAVOZ*/
			JLabel lblAltavoz = new JLabel("Altavoz");
			lblAltavoz.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					boolean on;
					if(sonido.isActive())
						on=true;
					else on=false;
					
					if(on==true) {
						//Si esta el sonido activado (on=true) paramos el sonido
						on=false;
						sonido.stop();
						Principal.escalarImagen(imgAltOff, lblAltavoz);
					}else {
						on=true;
						sonido.start();
						Principal.escalarImagen(imgAltOn, lblAltavoz);
					}
				}
			});
			lblAltavoz.setBounds(870, 21, 67, 52);
			Principal.escalarImagen(imgAltOn, lblAltavoz);
			Juego.add(lblAltavoz);
			
			/* LABEL CONFIRMAR */
			JLabel lblConfirmar = new JLabel("Confirmar");
			lblConfirmar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(personajeElegido.getNombre().equalsIgnoreCase("")) {
						System.out.println("No has elegido personaje");
					}else {
						// Se cierra la ventana de juego y abre la ventana de batalla
						sonido.stop();
						dispose();
						Batalla bat = new Batalla();
						bat.setVisible(true);
					}
				}
			});
			lblConfirmar.setBounds(43, 473, 236, 73);
			lblConfirmar.setForeground(Color.WHITE);
			lblConfirmar.setFont(tipoFuente.fuente(tipoFuente.adumu, 40));
			//Principal.escalarImagen(imgConfirmar, lblConfirmar);
			Juego.add(lblConfirmar);

			/* LABEL FONDO */
			JLabel lblFondo = new JLabel("Fondo");
			lblFondo.setBounds(0, 0, 980, 557);
			Principal.escalarImagen(imgFondo, lblFondo);
			Juego.add(lblFondo);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error");
		}
	}
	
	// Metodo que te devuelve el nombre del personaje elegido
	public static String getPersonaje() {
		return personajeElegido.getNombre(); 
	}
	
	// Metodo que te devuelve el indice el personaje que introduces
	public static int getInx(String nombre) {
		for(int i=0;i<personajes.length;i++) {
			if(personajes[i].getNombre().equalsIgnoreCase(nombre))
				return i;
		}
		return -1;
	}
	
	// Metodo que vuelve a poner a los personajes con sus atributos iniciales
	public static void crearPersonajes() {
		personajes[0]=new Personajes("Elmo",60,35);
		personajes[1]=new Personajes("Galletas",45,45);
		personajes[2]=new Personajes("Caponata",80,35);
		personajes[3]=new Personajes("EpiBlas",100,25);
		personajes[4]=new Personajes("Coco",60,40);
		personajes[5]=new Personajes("Gruñon",100,30);
		personajes[6]=new Personajes("Gustavo",50,55);
		personajes[7]=new Personajes("Peggy",60,55);
		personajes[8]=new Personajes("Gonzo",40,55);
		personajes[9]=new Personajes("Animal",30,70);
		personajes[10]=new Personajes("Mimimi",80,30);
		personajes[11]=new Personajes("CrazyHarry",20,75);
	}
}
