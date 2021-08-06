import java.awt.Font;
import java.io.InputStream;

public class Fuentes {

	public Font font = null;
	public String adumu="/fonts/Adumu.ttf";
	
	public Font fuente(String nombreFuente,float tamano) {
		try {
			//Se carga la fuente
			InputStream is= getClass().getResourceAsStream(nombreFuente);
			font=Font.createFont(font.TRUETYPE_FONT,is);
			
		}catch(Exception ex) {
			//Si existe un error se carga la fuente por defecto ARIAL
			System.err.println(nombreFuente + " No se cargo la fuente");
			font = new Font("Arial", Font.PLAIN, 14);
		}
		Font tfont= font.deriveFont(Font.BOLD, tamano);
		return tfont;
	}
	
	
}
