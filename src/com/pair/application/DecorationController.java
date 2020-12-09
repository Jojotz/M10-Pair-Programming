package com.pair.application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.pair.domain.Decoration;
import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

public class DecorationController {
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();

	public DecorationController() { }
	
	public void addDeco() {
		
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		
		//Chequear si s'ha creat alguna floristeria previament.
		if (flowershoprepository.isEmpty()) 
			JOptionPane.showMessageDialog(null, "No hi cap floristeria creada !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			
		else {
				
			String flowershopname = flowershopcontroller.inputFlowerShopName();
				
			//Chequear que la floristeria existeix
			if (!flowershopcontroller.checkFlowerShopName(flowershopname)) 
				JOptionPane.showMessageDialog(null, "Floristeria inexistent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			else {
						

				String material = inputMaterial();
				double price = flowershopcontroller.inputPreu("Introdueix el preu de la decoraciÛ:");
				saveDecoration(material,price,flowershopname,flowershoprepository);
			}				
		}			
	}

	//MÈtode per guardar la decoriacio a la llista
	private void saveDecoration(String material, double price, String flowershopname,List<FlowerShop> flowershoprepository) {
		for (FlowerShop l : flowershoprepository) {
			if (l.getName().equals(flowershopname)){
				Decoration decoration = new Decoration (material,price);
				
				if (l.getDecoration() == null) {  //Si floristeria no t√© cap decoraci√≥
					ArrayList<Decoration> decoList = new ArrayList<Decoration>();
					decoList.add(decoration);
					l.setDecoration(decoList);
				}
				else {
					l.getDecoration().add(decoration);
				}
				break;
			}					
		}
		
	}

	//Metode per controlar l'entrada del material
	private String inputMaterial() {
		String material="";
		Integer inputmaterial=2;
		do {
			try{
				inputmaterial = Integer.parseInt(JOptionPane.showInputDialog(null,"Introdueix el material de la decoraci√≥ (Fusta (0) Û Plastic(1)):","ENTRADA",JOptionPane.QUESTION_MESSAGE).trim());
					
				if ((inputmaterial != 0 ) && (inputmaterial != 1 )) 
					JOptionPane.showMessageDialog(null, "El material nomes pot ser Fusta (0) o Plastic(1) !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error El material nomes pot ser Fusta (0) Û Plastic(1) !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			}
		}while ((inputmaterial != 0) && (inputmaterial != 1));
		if (inputmaterial == 0) material = "FUSTA";
		else material = "PLASTIC";
		return material;
	}		
	
		
}