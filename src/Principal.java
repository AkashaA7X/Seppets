import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Principal {

	public static void main(String[] args) {

		MenuPrincipal menuP = new MenuPrincipal();
		menuP.setVisible(true);

	}

	// metodo que escala la imagen de un label
	public static void escalarImagen(ImageIcon img, JLabel jl) {
		Image imgEscalada = img.getImage().getScaledInstance(jl.getWidth(), jl.getHeight(), Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		jl.setIcon(iconoEscalado);
	}

	// metodo que escala la imagen de un boton
	public static void escalarImagen(ImageIcon img, JButton jb) {
		Image imgEscalada = img.getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		jb.setIcon(iconoEscalado);
	}

	// metodo que reproduce un sonido del paquete WAV
	public static void sound(String nombreArchivo, boolean repetir) {
		try {
			String ruta = "src/sounds/" + nombreArchivo + ".wav";
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();
			if (repetir)
				sonido.loop(Clip.LOOP_CONTINUOUSLY); // repetir siempre
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error");
		}

	}

	// metodo seleccion de label ( la imagen cambia al pulsarla), junto con nuevas mecanicas de seleccion
	static boolean press = true;

	public static boolean seleccionar(String imgInicial, JLabel lbl) {

		// Cuando se selecciona un personaje se desmarca los personajes anteriormente clickeados
		if (press == true) {
			press = false;
			ImageIcon imgSinPress = new ImageIcon(MenuPrincipal.class.getResource("/img/" + imgInicial + ".jpg"));
			Principal.escalarImagen(imgSinPress, lbl);
			return false;
		} else if(press==false){
			press = true;
			String imgFinal = imgInicial + "Press";
			ImageIcon imgPress = new ImageIcon(MenuPrincipal.class.getResource("/img/" + imgFinal + ".jpg"));
			Principal.escalarImagen(imgPress, lbl);
			return true;
		}
		return press;

	}

	//Metodo que desmarca todas las casillas de personaje
	public static void desmarcar() {
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
		
		//Colocamos todos los labels de los personajes con su imagen desmarcada
		Principal.escalarImagen(imgPelmo, VentanaJuego.lblCelmo);
		Principal.escalarImagen(imgPgustavo,VentanaJuego.lblCgustavo);
		Principal.escalarImagen(imgPgalleta,VentanaJuego.lblCgalleta);
		Principal.escalarImagen(imgPpeggy,VentanaJuego.lblCpeggy);
		Principal.escalarImagen(imgPgonzo,VentanaJuego.lblCgonzo);
		Principal.escalarImagen(imgPcaponata,VentanaJuego.lblCcaponata);
		Principal.escalarImagen(imgPanimal,VentanaJuego.lblCanimal);
		Principal.escalarImagen(imgPepiblas,VentanaJuego.lblCepiblas);
		Principal.escalarImagen(imgPmimimi,VentanaJuego.lblCmimimi);
		Principal.escalarImagen(imgPcoco,VentanaJuego.lblCcoco);
		Principal.escalarImagen(imgPcrazyHarry,VentanaJuego.lblCcrazyHarry);
		Principal.escalarImagen(imgPgruñon,VentanaJuego.lblCgruñon);
	}
	
	
}
