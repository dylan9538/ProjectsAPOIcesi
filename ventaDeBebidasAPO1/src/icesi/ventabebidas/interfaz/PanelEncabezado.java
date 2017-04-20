package icesi.ventabebidas.interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PanelEncabezado extends JPanel {

	private JLabel banner;
	
	
	public PanelEncabezado ()
	{
		
	    setLayout( new BorderLayout( ) );
        setBackground( Color.WHITE );

        ImageIcon icono = new ImageIcon( "./img/banner.PNG" );
        banner = new JLabel( "" );
        banner.setIcon( icono );
        banner.setHorizontalAlignment( JLabel.CENTER );
        banner.setVerticalAlignment( JLabel.CENTER );
        banner.setIcon( icono );
        

        add(banner, BorderLayout.CENTER );
		
		
		
		
	}
	
	
	
	
	
	
}
