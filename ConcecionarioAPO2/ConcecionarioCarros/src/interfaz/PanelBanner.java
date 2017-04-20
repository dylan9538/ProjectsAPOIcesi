package interfaz;

import java.awt.*;
import javax.swing.*;


public class PanelBanner extends JPanel {




		private JLabel banner;
		
		
		public PanelBanner ()
		{	
		    setLayout( new BorderLayout( ) );
	        setBackground( Color.WHITE );
	        ImageIcon icono = new ImageIcon("./data/misCarritos.png");
	        banner = new JLabel( "" );
	        banner.setIcon( icono );
	        add(banner, BorderLayout.CENTER );
		
		}
		
	}
	

