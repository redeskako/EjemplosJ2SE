import javax.swing.*;
import java.awt.FlowLayout;

public class SimpleCalculator {
	
	public static void main(String[] args){
		//Crear un paneel
		JPanel windowContent= new JPanel();
		
		//Definir un administrador de dise�o para este panel
		FlowLayout f1 = new FlowLayout();
		windowContent.setLayout(f1);
		
		//Crear controles en memoria
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField(10);
		
		JLabel label2 = new JLabel("Number 2:");
		JTextField field2 = new JTextField(10);
		
		JLabel label3 = new JLabel ("Sum");
		JTextField result = new JTextField(10);
		JButton go = new JButton("Add");
		
		//A�adir controles al panel
		windowContent.add(label1);
		windowContent.add(field1);
		
		windowContent.add(label2);
		windowContent.add(field2);
		
		windowContent.add(label3);
		windowContent.add(result);
		
		windowContent.add(go);
		
		//Crear el marco y a�adirle el panel 
		JFrame frame = new JFrame("Mi calculadora con FlowLayout");
		
		//A�adir el panel al contenedor de nivel superior
		frame.setContentPane(windowContent);
		
		//definir el tama�o y mostrar la ventana
		frame.setSize(400,100);
		frame.setVisible(true);
	}

}