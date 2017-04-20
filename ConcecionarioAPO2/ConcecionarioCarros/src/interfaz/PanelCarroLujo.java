package interfaz;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextMeasurer;
import java.util.ArrayList;

import javax.swing.*;

import mundo.Accesorios;
import mundo.Cliente;

public class PanelCarroLujo extends JPanel implements ActionListener {

	private final static String PEDIR = "Pedir";
	private final static String ANADIR = "Añadir";
	private final static String CANCELAR = " Cancelar ";
	
	
	DialogoCarroLujo carro;
	private ArrayList accesorios;
	private JButton butPedir,butCancelar,butAñadir;
	private JLabel labCombustion,labCilindraje,labTraccion,labTransmision,labColor,labTapiceria,labAire,labAccesorios,labMensaje,labClientes;
	private JComboBox<String> combCombustion,combTraccion,combTransmision,combAire,combClientes;
	private JTextField textCilindraje, textColor,textTapiceria;
	private JTextArea areaAccesorios;
	
	public PanelCarroLujo(DialogoCarroLujo e, ArrayList<Cliente> clientes, ArrayList accesorios)
	{
		carro = e;
		
   setLayout( new GridBagLayout( ) );
	
		GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.fill = GridBagConstraints.BOTH;
        
        labCombustion = new JLabel("Tipo de Combustión: ");
        add(labCombustion,gbc);
        
        combCombustion = new JComboBox<>();
        combCombustion.addItem("Gasolina");
        combCombustion.addItem("Diesel");
        gbc.gridx = 1;
        add(combCombustion,gbc);
        
        textCilindraje = new JTextField();
        gbc.gridy = 1;
        add(textCilindraje,gbc);
        
        labCilindraje = new JLabel("Cilindraje: ");
        gbc.gridx = 0;
        add(labCilindraje,gbc);
        
        labTraccion = new JLabel("Tipo de Tracción: ");
        gbc.gridy = 2;
        add(labTraccion,gbc);
        
        combTraccion = new JComboBox<>();
        combTraccion.addItem("4x4");
        combTraccion.addItem("2x4");
        gbc.gridx = 1;
        add(combTraccion,gbc);
        
        combTransmision = new JComboBox<>();
        combTransmision.addItem("Automática");
        combTransmision.addItem("Manual");
        gbc.gridy = 3;
        add(combTransmision,gbc);
        
        labTransmision = new JLabel("Transmisión: ");
        gbc.gridx = 0;
        add(labTransmision,gbc);
        
        labColor = new JLabel("Color: ");
        gbc.gridy = 4;
        add(labColor,gbc);
        
        textColor = new JTextField();
        gbc.gridx = 1;
        add(textColor,gbc);
        
        textTapiceria = new JTextField();
        gbc.gridy = 5;
        add(textTapiceria, gbc);
        
        labTapiceria = new JLabel("Tipo de tapicería: ");
        gbc.gridx = 0;
        add(labTapiceria,gbc);
        
        labAire = new JLabel("Tiene Aire acondicionado? ");
        gbc.gridy = 6;
        add(labAire,gbc);
        
        combAire = new JComboBox<>();
        combAire.addItem("Sí");
        combAire.addItem("No");
        gbc.gridx = 1;
        add(combAire,gbc);
        
        butCancelar = new JButton(CANCELAR);
		butCancelar.setActionCommand(CANCELAR);
		butCancelar.addActionListener(this);
		gbc.gridy = 11;
		add(butCancelar, gbc);
		
		butPedir = new JButton(PEDIR);
		butPedir.setActionCommand(PEDIR);
		butPedir.addActionListener(this);
		gbc.gridx = 0;
		add(butPedir,gbc);
        
        areaAccesorios= new JTextArea();
        areaAccesorios.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(areaAccesorios);
        scrollPane.setPreferredSize(new Dimension(300, 100));
        this.accesorios = accesorios;
        inicializarArea(this.accesorios);
        gbc.gridy = 8;
        gbc.gridx = 1;
        add(scrollPane,gbc);
        
        labAccesorios = new JLabel("Accesorios: ");
        gbc.gridx = 0;
        add(labAccesorios,gbc);
        
        gbc.gridy = 10;
        butAñadir = new JButton(ANADIR);
        butAñadir.setActionCommand(ANADIR);
        butAñadir.addActionListener(this);
        add(butAñadir,gbc);
        
        
        combClientes = new JComboBox<>();
        inicializarComboBox(combClientes, clientes);
        gbc.gridy = 7;
        gbc.gridx = 1;
        add(combClientes,gbc);
        
        labClientes = new JLabel("Clientes: ");
        gbc.gridx = 0;
        add(labClientes,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        labMensaje = new JLabel("Si usted desea un artículo que no se encuentra en la lista o varias por favor undir el boton añadir");
        gbc.gridy = 9;
        add(labMensaje,gbc);
        
        
       
	}

	
	private void inicializarArea(ArrayList accesorios)
	{
		String lista = "";
		for(int i = 0; i<accesorios.size();i++)
		{
			Accesorios a = (Accesorios) accesorios.get(i);
			
			lista += a.getNombre() + ";" + a.darDescripcion() + a.getCodigo() + ";" + a.getRestriciones() + ";" + a.getCosto() ;
		}
		
		refrescarArea(lista);
	}
	
	public void refrescarArea(String lista)
	{
		areaAccesorios.setText(lista);
	}
	
	private void inicializarComboBox(JComboBox combo, ArrayList<Cliente> clientes)
	{
		for(int i=0; i < clientes.size(); i++ )
		{
			
			Cliente cliente = clientes.get(i);
			String cadena = cliente.getNombre() +" " + cliente.getApellido() + "-" + cliente.getNumeroId();
			combo.addItem(cadena);
		}
	}
	
	public ArrayList darArrayListAccesorios()
	{
		return accesorios;
	}
	
	private String darCedulaCliente(String cadena)
	{
		String[] split = cadena.split("-");
		
		return split[1];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals(CANCELAR))
		{
			carro.dispose();
		}
		
		else if(comando.equals(ANADIR)){
			String accesorio = JOptionPane.showInputDialog(this, "dijite el nuevo accesorio que quiere agregar", "accesorio nuevo", JOptionPane.INFORMATION_MESSAGE);
			if(accesorio!= null && !accesorio.equals("")){
				String lista = areaAccesorios.getText();
				lista +="\n" + accesorio;
				accesorios.add(accesorio);
				
				areaAccesorios.setText(lista);
			}
		}
		else
		{
            boolean aire = false;
			if(combAire.getSelectedItem().equals("Sí"))
			{
				aire = true;
			}
			carro.generarPedido((String)combCombustion.getSelectedItem(),(String) combTraccion.getSelectedItem(), textColor.getText(), 
				(String)combTransmision.getSelectedItem(), textTapiceria.getText(), aire, textCilindraje.getText(), accesorios,darCedulaCliente((String) combClientes.getSelectedItem()));
		}
		
	}
	
}
