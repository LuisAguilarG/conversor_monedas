package app;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BienvenidaPanel extends JPanel {

	public BienvenidaPanel() {
		setBounds(new Rectangle(0, 0, 784, 299));
		setLayout(null);
		
		JPanel contenedorPrincipalPanel = new JPanel();
		contenedorPrincipalPanel.setBackground(new Color(0, 29, 48));
		contenedorPrincipalPanel.setBounds(0, 0, 784, 299);
		add(contenedorPrincipalPanel);
		contenedorPrincipalPanel.setLayout(null);
		
		JLabel esperandoGif = new JLabel("");
		esperandoGif.setIcon(new ImageIcon(BienvenidaPanel.class.getResource("/img/animacion-recortada.gif")));
		esperandoGif.setBounds(92, 0, 600, 205);
		contenedorPrincipalPanel.add(esperandoGif);
		
		JLabel bienvenidaIndicacion = new JLabel("Seleccione un conversor para comenzar");
		bienvenidaIndicacion.setForeground(new Color(255, 255, 255));
		bienvenidaIndicacion.setFont(new Font("Arial Black", Font.BOLD, 20));
		bienvenidaIndicacion.setHorizontalTextPosition(SwingConstants.CENTER);
		bienvenidaIndicacion.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenidaIndicacion.setBounds(152, 200, 481, 46);
		contenedorPrincipalPanel.add(bienvenidaIndicacion);
		
	}
}
