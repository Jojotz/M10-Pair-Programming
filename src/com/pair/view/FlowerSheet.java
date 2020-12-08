package com.pair.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.pair.application.FlowerShopController;
import com.pair.application.TreeController;
import com.pair.application.DecorationController;
import com.pair.application.FlowerController;


public class FlowerSheet extends JPanel {
	
	private JPanel mySheet2;
	private JButton screen;
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();
	private TreeController treeController = new TreeController();
	private FlowerController flowerController = new FlowerController();
	private DecorationController decorationController = new DecorationController();
	
	public FlowerSheet () {
	
		setLayout(new BorderLayout ());
		screen = new JButton("");
		screen.setEnabled(false);
		add(screen,BorderLayout.NORTH); 
		mySheet2 = new JPanel();
		
		ActionListener insertar = new InstertOrder ();
		
		ponerBoton("Crear Floristeria", insertar);
		ponerBoton("Afegir Arbre", insertar);
		ponerBoton("Afegir Flor", insertar);
		ponerBoton("Afegir Decoració", insertar);
		ponerBoton("Stock", insertar);
								
		add(mySheet2, BorderLayout.SOUTH);
	}
 
	private void ponerBoton(String tittle, ActionListener listener) {
		
		JButton button = new JButton (tittle);
		button.addActionListener(listener);
		mySheet2.add(button);
	}	
	
	private class InstertOrder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String entrada = e.getActionCommand();	
			screen.setText(entrada);			
					
			if (entrada.equals("Crear Floristeria")) flowershopcontroller.NewFlowerShop();
			else if (entrada.equals("Afegir Arbre")) treeController.addTree();
			else if (entrada.equals("Afegir Flor")) flowerController.addFlower();
			else if (entrada.equals("Afegir Decoració"))decorationController.addDeco();
			else if (entrada.equals("Stock")) {
				String output="";
				output = flowershopcontroller.stock();
				System.out.println(output);
			}
		}	
	}
}