package Interfaz;

import java.awt.*;
import javax.swing.*;


public class PanelBanner extends JPanel {

	private JLabel banner;
	
	
	public PanelBanner ()
	{	
	    setLayout( new BorderLayout( ) );
        setBackground( Color.WHITE );
        ImageIcon icono = new ImageIcon("./docs/images.jpg");
        banner = new JLabel( "" );
        banner.setIcon( icono );
        add(banner, BorderLayout.CENTER );
	
	}
	
}