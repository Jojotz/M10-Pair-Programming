package com.pair.application;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;

public class WindoOutput {

	JFrame frmStocks;
	private JTable treetable;
	List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindoOutput window = new WindoOutput();
					window.frmStocks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindoOutput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStocks = new JFrame();
		frmStocks.setTitle("Stocks");
		frmStocks.setBounds(100, 100, 644, 375);
		frmStocks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStocks.getContentPane().setLayout(null);
		
		treetable = new JTable();
		treetable.setColumnSelectionAllowed(true);
		treetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		treetable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			
			
			new String[] {
				"Tipus material", "Preu"
			}
		));
		treetable.getColumnModel().getColumn(0).setPreferredWidth(118);
		treetable.getColumnModel().getColumn(1).setPreferredWidth(151);
		treetable.setBounds(10, 69, 416, 67);
		frmStocks.getContentPane().add(treetable);
		
		JComboBox flowershopcombobox = new JComboBox();
		flowershopcombobox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});
		flowershopcombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			DefaultTableModel modelo = (DefaultTableModel)treetable.getModel();
			String flowershopname = (String) flowershopcombobox.getSelectedItem();
				System.out.println(flowershopname);
			/********************************************************************************/
			for (FlowerShop l : flowershoprepository) {
				if (l.getName().equals(flowershopname)){	
					for (int i= 0; i< l.getTrees().size();i++) {
						System.out.println(l.getTrees().get(i));
					//	modelo.addRow(l.getTrees().get(i));
					}
				}
			}//end for
				
				
				
				
			}
		});
		flowershopcombobox.setBounds(80, 10, 168, 21);
		frmStocks.getContentPane().add(flowershopcombobox);
		
		
		/**********************************************************************************************************************************/
		for(FlowerShop l : flowershoprepository) {
			flowershopcombobox.addItem(l.getName());
			}
		
		JLabel lblNewLabel = new JLabel("Floristeria:");
		lblNewLabel.setBounds(22, 14, 56, 13);
		frmStocks.getContentPane().add(lblNewLabel);
		
		JLabel lblArbres = new JLabel("Arbres:");
		lblArbres.setBounds(10, 46, 56, 13);
		frmStocks.getContentPane().add(lblArbres);
	}
}
