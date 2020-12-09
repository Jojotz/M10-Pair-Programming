package com.pair.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.Flower;
import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

public class FlowerController {	
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();

	public FlowerController() {}
	
	//MÃ¨tode principal del controlador
	public void addFlower() {
		
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		
		//Chequear si s'ha creat alguna floristeria previament.
		if (flowershoprepository.isEmpty()) JOptionPane.showMessageDialog(null, "No hi cap floristeria creada !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
		
		else {			
			String flowershopname = flowershopcontroller.inputFlowerShopName();
			
			//Chequear que la floristeria existeix
			if (!flowershopcontroller.checkFlowerShopName(flowershopname)) 
				JOptionPane.showMessageDialog(null, "Floristeria inexistent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			else {
								
				String colour = inputColour();
				double price = flowershopcontroller.inputPreu("Introdueix el preu de la flor:");
				saveFlower(colour, price, flowershopname,flowershoprepository);
				
			}//end 2on if-else				
		}//end 1er 			
	}
	
	
	//Metode per guardar l'arbre al repositori
	private void saveFlower(String colour, double price,String flowershopname,List<FlowerShop> flowershoprepository) {
		for (FlowerShop l : flowershoprepository) {
			if (l.getName().equals(flowershopname)){
				Flower flower = new Flower (colour,price);
				if (l.getFlowers()== null) {
					ArrayList<Flower> flowers = new ArrayList<Flower>();
					flowers.add(flower);
					l.setFlowers(flowers);
				}
				else {
					l.getFlowers().add(flower);
				}//end  if-else
				break;
			}//end if
			
		}//end for
		
	}//end metode

	
	
	//Métode per controlar l'entrada del color
	private String inputColour() {
		String colour="";
		do {
			colour = JOptionPane.showInputDialog(null,"Introdueix el color de la flor:","ENTRADA",JOptionPane.QUESTION_MESSAGE);
			
			if (colour.isBlank() || colour.isEmpty()) JOptionPane.showMessageDialog(null, "El color no pot esgtar buit !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			
			
		}while(colour.isBlank() || colour.isEmpty());
		colour=colour.trim().toUpperCase();
		return colour;
	}// end metode

	//Métode per introudir el color
	
	
	
}