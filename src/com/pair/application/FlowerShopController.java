package com.pair.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

public class FlowerShopController {

	private FlowerShopRepository flowershoprepository = new FlowerShopRepository();
	private FlowerShopRepository repository; 	
	
	public FlowerShopController(FlowerShopRepository repository){ 
		
		this.repository = repository;		
	}
	
	public FlowerShopController() {}

	//Mètode per donar d'alta una nova floristeria
	public void NewFlowerShop () {
		String flowershopname="";
		boolean existsflowershop=false;
		
			flowershopname=inputFlowerShopName(); //Crida al metode per introduir el nom de la floristeria
			if (flowershopname != "") {
				existsflowershop = checkFlowerShopName(flowershopname);
				
				if (!existsflowershop)  FlowerFhopCreated(flowershopname);
				else JOptionPane.showMessageDialog(null, "Floristeria existent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Operació cancel·lada", "Alerta", JOptionPane.ERROR_MESSAGE);
				
			}		
	}

	//Mètode per afegir una floristeria al repository
	private void FlowerFhopCreated(String flowershopname) {
		try {
			FlowerShop flowershop = new FlowerShop (flowershopname);
			flowershoprepository.add(flowershop);

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Operació cancel·lada, no s'ha pogut crear la floristeria", "Alerta", JOptionPane.ERROR_MESSAGE);

		}		
	}

	//Mètode per chequear si una floristeria ja está creada
	public boolean checkFlowerShopName(String flowershopname) {
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		boolean checkflowershopname=false;
		
		if (flowershoprepository.size()>0) {
			for (FlowerShop l : flowershoprepository) {
				if (l.getName().equals(flowershopname)){
					checkflowershopname=true;
					break;
				}				
			}
		}
		return checkflowershopname;	
	}
	
	//Mètode per entrar el nom de la floristeria
	public String inputFlowerShopName() {
		String flowershopname="";
		
		do {
			flowershopname=	JOptionPane.showInputDialog(null,"Introdueix el nom de la floristeria:","ENTRADA",JOptionPane.QUESTION_MESSAGE);	
			if (flowershopname != null)  flowershopname=flowershopname.trim().toUpperCase();
			else {
				flowershopname="";
				break;
			}
		}while(flowershopname.isBlank() || flowershopname.isEmpty()); //Chequear que s'introdueixi algun caràcter

		return flowershopname;
	}
	
	
	//M�tode per treure l'estoc d'una floristeria en concret
	public String stock () {
			
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		StringBuilder output = new StringBuilder();
		
		
		
		if (flowershoprepository.size()>0) {//comprabr si existeixen floristeries
			
			String flowershopname=inputFlowerShopName(); //Crida al mètode per introduïr el nom de la floristeria
			boolean existsflowershop=false;
			if (flowershopname != "") {
				existsflowershop = checkFlowerShopName(flowershopname);
			}
				
			if (existsflowershop) {
				
				for (FlowerShop l : flowershoprepository) {
					if (l.getName().equals(flowershopname)) {
						output.append("Floristeria: " + l.getName() + "." + "\n");
						output.append(showTrees(l));
						output.append(showFlowers(l));
						output.append(showDecorations(l));
						break;
			
					}//end if					
				}//end for
				
			} else {				
				JOptionPane.showMessageDialog(null, "La floristeria que demanes no existeix !!", "Alerta", JOptionPane.ERROR_MESSAGE);
			}
		} else {			
			JOptionPane.showMessageDialog(null, "No hi ha cap floristeria creada !!", "Alerta", JOptionPane.ERROR_MESSAGE);
		}				
		
		return output.toString();
	} //end metode stock
	
	
	//Metode per treure les dades de decoraci�
	private Object showDecorations(FlowerShop l) {
		String frase="";
		if (l.getDecoration() != null) frase = "\tDECORACI�: " + l.getDecorationString() + "." + "\n";
		else frase = "\tDECORACI�: Sense Stock.\n";
		return frase;
	}
	
	//Metode per treure les dades de flors
	private Object showFlowers(FlowerShop l) {
		String frase="";
		if (l.getFlowers() != null) frase = "\tFLORS: " + l.getFlowersString() + "." + "\n";
		else frase = "\tFLORS: Sense Stock.\n";
		return frase;
	}
	
	//Metode per treure les dades d'arbres
	private String showTrees(FlowerShop l) {
		String frase="";
		if (l.getTrees() != null) frase = "\tARBRES: " +  l.getTreesString() + "." + "\n";
		else frase = "\tARBRES: Sense Stock.\n";
		return frase;
	}
	
	
	
	//M�tode per introuduir els preus dels articles
	public double inputPreu(String frase) {
		double price=-1;
		do {
			try {
				price = Double.parseDouble(JOptionPane.showInputDialog(null,frase,"ENTRADA",JOptionPane.QUESTION_MESSAGE));
				if (price <= 0) JOptionPane.showMessageDialog(null, "El preu te que ser major que 0 !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			
			}catch(Exception e) {

				JOptionPane.showMessageDialog(null, "El preu te que ser un numero!!!", "Alerta", JOptionPane.ERROR_MESSAGE);
				price=-1;
			}
			
		}while (price <= 0);
		
		return price;
	}//end metode inputPreu

	
	//M�tode per veure tot l'estock gloabal
	public void stockGlobal() {

		WindoOutput window = new WindoOutput();
		window.frmStocks.setVisible(true);
		
	}//end metode stockGlobal
}