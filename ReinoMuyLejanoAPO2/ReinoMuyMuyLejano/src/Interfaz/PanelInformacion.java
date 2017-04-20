package Interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import org.omg.CORBA.portable.ValueOutputStream;

import Mundo.Personificacion;

import java.awt.event.*;
import java.util.ArrayList;

public class PanelInformacion extends JPanel implements ActionListener {

	public final static String DESEM = "GenerarDesempleados";
	public final static String HOMBRE = "GenerarHombres";
	public final static String MUJER = "GenerarMujeres";
	public final static String EDAD = "GenerarPorEdad";
	
	private InterfazReino principal;
	
	private JButton butGenDesempleados;
	private JButton butGenHombres;
	private JButton butGenMujeres;
	private JButton butEdad;
	private JPanel panelBotones;
	private JPanel panelInfo;
    public JTextArea txtArea;
    public DefaultListModel actual;
    
    
	
	public PanelInformacion (InterfazReino p){
		actual = new DefaultListModel();
		principal = p ;
		
		setLayout(new BorderLayout());	
		panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1,1,1,1));	
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información"));

        
        txtArea = new JTextArea();
        panelInfo.add(txtArea);
  
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setPreferredSize(new Dimension(50, 400));
        panelInfo.add(scrollPane);
       
		setLayout(new BorderLayout());	
		panelBotones =  new JPanel();
		panelBotones.setLayout(new GridLayout(3,2,1,1));
		panelBotones.setBorder(BorderFactory.createTitledBorder("Opciones de generado"));
		
		butGenDesempleados = new JButton("Generar Lista Desempleados Con Hijos");
		butGenDesempleados.setActionCommand(DESEM);
		butGenDesempleados.addActionListener(this);


		butGenHombres = new JButton("Generar Lista de Hombres por RH");
		butGenHombres.setActionCommand(HOMBRE);
		butGenHombres.addActionListener(this);
		
		butGenMujeres = new JButton("Generar Lista de Mujeres por RH");
		butGenMujeres.setActionCommand(MUJER);
		butGenMujeres.addActionListener(this);

		butEdad = new JButton("Organizar por edad");
		butEdad.setActionCommand(EDAD);
		butEdad.addActionListener(this);
		
		panelBotones.add(butGenDesempleados);
		panelBotones.add(butGenHombres);
		panelBotones.add(butGenMujeres);
		panelBotones.add(butEdad);
		
		add(panelInfo, BorderLayout.NORTH);
		add(panelBotones, BorderLayout.SOUTH);
		
	}
	
	// Metodo de refresco
  public void refrescar(String cadena)
	{
		String acumulado="";
		acumulado += cadena+"\n";
		
	}
    //Metodo de refrescar el area
 public void refrescarArea(String nLista)
    {
	   txtArea.setText(nLista);
    }

 //Metodo Que da el area
 public String darArea()
	{
		return txtArea.getText();
	}
	
	
 //Action perfomed
  public void actionPerformed(ActionEvent even) {
		
		String comando = even.getActionCommand();
		
//Botones		
		if (comando.equals(DESEM)) {
            principal.listaDesempleadosConHijos();
		}
		
		if (comando.equals(HOMBRE)) {
			   
			principal.organizarPorRH(Personificacion.SEXO_MASCULINO);
		}
		
		if (comando.equals(MUJER)) {
			principal.organizarPorRH(Personificacion.SEXO_FEMENINO);
		}
		
		if (comando.equals(EDAD)) {
			principal.organizarEdad();
		}
   }
}
