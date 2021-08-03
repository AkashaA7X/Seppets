import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	/**
	 * Create the panel.
	 */
	public Menu() {
		ImageIcon imgFondo = new ImageIcon(MenuPrincipal.class.getResource("/img/menu.jpg"));
		setSize(324,384);
		setLayout(null);
		
		/* LABEL FONDO */
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setBounds(0, 0, 254, 300);
		Principal.escalarImagen(imgFondo, lblFondo);
		add(lblFondo);
	}

}
