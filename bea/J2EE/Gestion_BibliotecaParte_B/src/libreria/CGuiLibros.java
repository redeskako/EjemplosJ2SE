/*
 *   CARLOS LUIS SÁNCHEZ BOCANEGRA
                            DNI: 26017022C
             Expediente UNED: 55­04­00458
Domicilio: C/Cura Merino 2 2ºD 29011 Málaga

 */
package libreria;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import libreria.error.*;
import libreria.lenguaje.*;

public class CGuiLibros extends JInternalFrame implements ActionListener{
	private CLibros libreria;
	private JTable tabla;
	private String txtBoton[];
	public final static String [] accion={"ACEPTAR","CANCELAR","NUEVO","LIMPIAR"};
	private JButton [] botonera;
	private JScrollPane stabla;
	private JTextArea area;
	private JScrollPane sarea;
	//private JButton cambialeng;
	private Config idioma;

	public CGuiLibros(String titulo,String local){
		super(titulo,
			          true, //resizable
			          true, //closable
			          true, //maximizable
			          false);//iconifiable	
		this.idioma= new Config(local);
		this.txtBoton=new String [4];
		this.txtBoton[0]=this.idioma.traduce("_ACEPTAR");
		this.txtBoton[1]=this.idioma.traduce("_CANCELAR");
		this.txtBoton[2]=this.idioma.traduce("_NUEVO");
		this.txtBoton[3]=this.idioma.traduce("_LIMPIARLOG");
	/*
	 * Creacion de los elementos básicos de comunicacion con bbdd
	 */
		// Creacion del map que conecta con JTable
		this.libreria = new CLibros(this.idioma);
	/*
	 * Creacion de componentes gráficos que veremos
	 */
		// Creacion de la botonera
		this.botonera = new JButton[txtBoton.length];
		for (int i= 0; i<txtBoton.length;i++){
			this.botonera[i]= new JButton(txtBoton[i]);
//System.out.println("Accion"+CGuiLibros.accion[i]);
			this.botonera[i].setActionCommand(CGuiLibros.accion[i]);
//System.out.println("Botonera: "+i+"- "+this.botonera[i].getActionCommand());			
			this.botonera[i].addActionListener(this);
		}
		//CHECK para idioma
//		this.cambialeng= new JButton(this.idioma.traduce("_CAMBIAIDIOMA"));
//		this.cambialeng.setActionCommand("Idioma");
//		this.cambialeng.addActionListener(this);
		//JTable
		this.tabla= new JTable(this.libreria);
		this.tabla.getModel().addTableModelListener(this.libreria);
		this.stabla= new JScrollPane(this.tabla);

		//Contendores
		
		Container panel= this.getContentPane();
		panel.setLayout(new BorderLayout());
		JPanel p1= new JPanel(new FlowLayout(this.botonera.length));
		//p1.add(this.cambialeng);
		for (int i=0;i<this.botonera.length;i++){
			p1.add(this.botonera[i]);
		}
		panel.add(p1,BorderLayout.NORTH);
		panel.add(stabla,BorderLayout.CENTER);
		
		//Area
		this.area=new JTextArea(15,800);
		this.area.setFont(new Font("Serif", Font.ITALIC, 9));
		this.area.setLineWrap(true);
		this.area.setEditable(false);
		this.sarea=new JScrollPane(this.area);
		panel.add(sarea,BorderLayout.SOUTH );
		
		super.setSize(new Dimension(800,600));
		//super.pack();
		super.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		super.setVisible(false);
		this.area.append(this.libreria.mensajeSocket);
	}
	public String toString(){
		String str=this.idioma.traduce("_LIBRERIA")+":\n";
		str+=this.libreria.toString()+ "\n";
		str+= this.libreria.toString();
		return str;
	}
	public void actionPerformed(ActionEvent e){
		char c=((String) e.getActionCommand()).charAt(0);
		try{
			switch (c){
				case 'A':
						int [] i=this.libreria.aceptar();
						this.area.append("--------------------------------------------\n");
						this.area.append(this.idioma.traduce("_REGISTROSNUEVOS")+":"+i[0]+"\n");
						this.area.append(this.idioma.traduce("_REGISTROSBORRADOS")+":"+i[1]+"\n");
						this.area.append(this.idioma.traduce("_REGISTROSACTUALIZADOS")+": "+i[2]+"\n");
						this.area.append("--------------------------------------------\n");
					break;
				case 'C':
					i= this.libreria.cancela();
					this.area.append("--------------------------------------------\n");
					this.area.append(this.idioma.traduce("_NUEVOSCANCELADOS")+": "+i[0]+"\n");
					this.area.append(this.idioma.traduce("_ELIMINACIONESCANCELADAS")+": "+i[1]+"\n");
					this.area.append(this.idioma.traduce("_ACTUALIZACIONESCANCELADAS")+":"+i[2]+"\n");
					this.area.append("--------------------------------------------\n");
					break;
				case 'N':
					this.libreria.nuevo();
					this.area.append("--------------------------------------------\n");
					this.area.append(this.idioma.traduce("_PERMITIDOINSERTAR")+"\n");
					this.area.append("--------------------------------------------\n");
					break;
				case 'L':
					this.area.setText(this.idioma.traduce("_LIMPIADO")+"\n");
					break;
				case 'I':
					this.actualizaIdioma(this.cambiaIdioma());
					this.area.setText(this.idioma.traduce("_IDIOMACAMBIADO"));
					break;
				default:
			}
		}catch(ErrorLibreriaException err){
			this.area.append("--------------------------------------------\n");
			this.area.append(this.idioma.traduce("_ERROR")+": "+err+"\n");
			this.area.append("--------------------------------------------\n");
		}
	}
	public void actualizaIdioma(String local){
		this.idioma= new Config(local);
		this.setTitle(this.idioma.traduce("_LIBROS"));
		this.txtBoton=new String [4];
		this.txtBoton[0]=this.idioma.traduce("_ACEPTAR");
		this.txtBoton[1]=this.idioma.traduce("_CANCELAR");
		this.txtBoton[2]=this.idioma.traduce("_NUEVO");
		this.txtBoton[3]=this.idioma.traduce("_LIMPIARLOG");    	
    	for (int i=0;i<this.botonera.length;i++){
    		this.botonera[i].setText(this.txtBoton[i]);
    	}
    	//this.cambialeng.setText(this.idioma.traduce("_CAMBIAIDIOMA"));
    	this.libreria.actualizaIdioma(this.idioma.idioma());
	}
	private String cambiaIdioma(){
	//System.out.println("Locale:"+this.idioma.locale());
		String idioma="";
		if(this.idioma.locale().equals("español")){
			this.idioma.cambiaIdioma("en");
			idioma="en";
		}else{
			this.idioma.cambiaIdioma("es");
			idioma="es";
		}
		return idioma;
	}
}