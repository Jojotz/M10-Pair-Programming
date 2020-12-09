package com.pair.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.FlowerShop;
import com.pair.domain.Tree;
import com.pair.persistence.FlowerShopRepository;

public class TreeController {	
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();

	public TreeController() {}
	
	//MÃ¨tode principal del controlador
	public void addTree() {
		
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		
		//Chequear si s'ha creat alguna floristeria previament.
		if (flowershoprepository.isEmpty()) JOptionPane.showMessageDialog(null, "No hi cap floristeria creada !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
		
		else {
			
			String flowershopname = flowershopcontroller.inputFlowerShopName();
			
			//Chequear que la floristeria existeix
			if (!flowershopcontroller.checkFlowerShopName(flowershopname)) 
				JOptionPane.showMessageDialog(null, "Floristeria inexistent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			else {
					
				int height=0;
				double price = 0;
					
				height = inputheight();
				price = flowershopcontroller.inputPreu("Introdueix el preu de l'arbre:");
				saveTree(height,price,flowershopname,flowershoprepository);
			}				
		}			
	}

	//Metode per guardar l'arbre.
	private void saveTree(int height, double price, String flowershopname, List<FlowerShop> flowershoprepository) {
		for (FlowerShop l : flowershoprepository) {
			if (l.getName().equals(flowershopname)){
				Tree tree = new Tree (height,price);
				
				if (l.getTrees()== null) {
					ArrayList<Tree> trees = new ArrayList<Tree>();
					trees.add(tree);
					l.setTrees(trees);
				}
				else {
					l.getTrees().add(tree);
				}
				break;
			}					
		}				
		
	}

	//Métode per introduir l'alçada
	private int inputheight() {
		int height=-1;
		do {
			try {
			
				height=Integer.parseInt(JOptionPane.showInputDialog(null,"Introdueix l'alÃ§ada de l'arbre:","ENTRADA",JOptionPane.QUESTION_MESSAGE));
				if (height <= 0 ) JOptionPane.showMessageDialog(null, "L'alçada te ser major que 0 !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
	
			}catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "L'alçada te que ser un numero !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
				height=-1;
			}
		
		}while(height <= 0);
		return height;
	}		
}