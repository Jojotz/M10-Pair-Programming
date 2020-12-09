package com.pair.application;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;
import com.pair.view.FrameShop;

import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

//public class WindoOutput{
public class WindoOutput {
	
	List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
	private JTable treetable;
	private JTable flowertable;
	private JTable decorationtable;
	JFrame frmStocks;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	
	public WindoOutput() {
		
		initialize();
	}

	/**
	 * Inicialitzar continguts del frame
	 */
	private void initialize() {
		frmStocks = new JFrame();
		frmStocks.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmStocks.setResizable(false);
		frmStocks.setTitle("Stocks");
		frmStocks.setBounds(600, 200, 359, 468);
		frmStocks.getContentPane().setLayout(null);
		
		
		/** taula i associats a  arbres**/
		treetable = new JTable();
		treetable.setColumnSelectionAllowed(true);
		treetable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				
			},
		
			new String[]  {
				"ALÇADA", "PREU"
			}
		));
		treetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		treetable.getColumnModel().getColumn(0).setPreferredWidth(180);
		treetable.getColumnModel().getColumn(1).setPreferredWidth(80);
		treetable.setBounds(22, 69, 416, 67);
		treetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		treetable.getTableHeader().setBackground(Color.cyan);
		treetable.getTableHeader().setFont(new Font("Sans Serif", 1, 12));
		
				
		JScrollPane jsTree=new JScrollPane(treetable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsTree.setVisible(true);
		
		jsTree.setBounds(22, 69, 272, 84);
		frmStocks.getContentPane().add(jsTree);
		
		/** taula i associats a  decoració**/
	
		decorationtable = new JTable();
		
		decorationtable.setColumnSelectionAllowed(true);
		
		decorationtable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				
			},
			
			new String[]  {
				"MATERIAL", "PREU"
			}
		));
		
		decorationtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		decorationtable.getColumnModel().getColumn(0).setPreferredWidth(180);
		decorationtable.getColumnModel().getColumn(1).setPreferredWidth(80);
		decorationtable.setBounds(22, 330, 269, 67);
		decorationtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		decorationtable.getTableHeader().setBackground(Color.cyan);
		decorationtable.getTableHeader().setFont(new Font("Sans Serif", 1, 12));
		
		JScrollPane jsDecoration=new JScrollPane(decorationtable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsDecoration.setVisible(true);
		jsDecoration.setBounds(22, 330, 272, 84);
		frmStocks.getContentPane().add(jsDecoration);
		
		/** taula i associats a flors**/

		flowertable = new JTable();
		flowertable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		flowertable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"COLOR", "PREU"
			}
		));
		flowertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		flowertable.getColumnModel().getColumn(0).setPreferredWidth(180);
		flowertable.getColumnModel().getColumn(1).setPreferredWidth(80);
		flowertable.setColumnSelectionAllowed(true);
		flowertable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		flowertable.setBounds(111, 69, 269, 64);
		flowertable.getTableHeader().setBackground(Color.cyan);
		flowertable.getTableHeader().setFont(new Font("Sans Serif", 1, 12));
		
		frmStocks.getContentPane().add(flowertable);
		
		JScrollPane jsFlower=new JScrollPane(flowertable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsFlower.setVisible(true);
		
		jsFlower.setBounds(22, 189, 272, 84);
		frmStocks.getContentPane().add(jsFlower);
		


		
		JLabel lblNewLabel = new JLabel("FLORISTERIA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(22, 14, 105, 13);
		frmStocks.getContentPane().add(lblNewLabel);
		
		JLabel lbDecoration = new JLabel("Decoraci\u00F3:");
		lbDecoration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDecoration.setBounds(10, 295, 105, 13);
		frmStocks.getContentPane().add(lbDecoration);
		
		JLabel lblTree = new JLabel("Arbres:");
		lblTree.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTree.setBounds(10, 46, 56, 13);
		frmStocks.getContentPane().add(lblTree);
		
		JLabel lblFlower = new JLabel("Flors:");
		lblFlower.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFlower.setBounds(10, 163, 105, 13);
		frmStocks.getContentPane().add(lblFlower);
		
		
		/** Afegir etiquetes sense stock**/
		JLabel lblsensesstockflower = new JLabel("SENSE STOCK");
		lblsensesstockflower.setForeground(Color.RED);
		lblsensesstockflower.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblsensesstockflower.setBounds(188, 163, 106, 13);
		lblsensesstockflower.setVisible(false);
		frmStocks.getContentPane().add(lblsensesstockflower);
		
		JLabel lblsensesstockdecoration = new JLabel("SENSE STOCK");
		lblsensesstockdecoration.setForeground(Color.RED);
		lblsensesstockdecoration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblsensesstockdecoration.setBounds(188, 293, 106, 13);
		lblsensesstockdecoration.setVisible(false);
		frmStocks.getContentPane().add(lblsensesstockdecoration);
		
		JLabel labelsensestocktree = new JLabel("SENSE STOCK");
		labelsensestocktree.setForeground(Color.RED);
		labelsensestocktree.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		labelsensestocktree.setBounds(188, 46, 106, 13);
		labelsensestocktree.setVisible(false);
		frmStocks.getContentPane().add(labelsensestocktree);
		/** End afegir etiquetes **/
		
		
		
		JComboBox<String> flowershopcombobox = new JComboBox();
		flowershopcombobox.setFont(new Font("SansSerif", Font.PLAIN, 13));
		flowershopcombobox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		
		//Accions sobre el metode de seleccionar del combobox
		flowershopcombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				deleteTables();//Esbrorrar continguts de les taules
				visiblestock(); //Ocultar les opcions sense stock
				
				String flowershopname = (String) flowershopcombobox.getSelectedItem();//Obtindre el nom de la floristeria escollida
						
				for (FlowerShop l : flowershoprepository) {
					if (l.getName().equals(flowershopname)){
						//Trucada als diferents metodes per omplir les taules
						puttreedatesintable(l);
						putflowerdatesintable(l);
						putdecorationdatesintable(l);
					}//end if (l.getName().equals(flowershopname)
				}//end for
				
			}
			
			//Métode per omplir la taula de decoracio
			private void putdecorationdatesintable(FlowerShop l) {
				DefaultTableModel modelodecoration = (DefaultTableModel)decorationtable.getModel();
				String deccorationdates[] = new String[2];
				if (l.getDecoration()==null) lblsensesstockdecoration.setVisible(true);
				else {
					for (int i= 0; i< l.getDecoration().size();i++) {
						deccorationdates[0]=l.getDecoration().get(i).getMaterial();
						deccorationdates[1]= Double.toString(l.getDecoration().get(i).getPrice());
						modelodecoration.addRow(deccorationdates);
						modelodecoration.setValueAt(l.getDecoration().get(i).getMaterial(), i, 0);
						modelodecoration.setValueAt(l.getDecoration().get(i).getPrice(), i, 1);
			
					}//end for
				}//end if-else
				
			}

			//Métode per omplir la taula de flors
			private void putflowerdatesintable(FlowerShop l) {
				DefaultTableModel modeloflower = (DefaultTableModel)flowertable.getModel();
				String flowerdates[] = new String[2];
				if (l.getFlowers()==null) lblsensesstockflower.setVisible(true);
				else {
					for (int i= 0; i< l.getFlowers().size();i++) {
						flowerdates[0]=l.getFlowers().get(i).getColour();
						flowerdates[1]= Double.toString(l.getFlowers().get(i).getPrice());
						modeloflower.addRow(flowerdates);
						modeloflower.setValueAt(l.getFlowers().get(i).getColour(), i, 0);
						modeloflower.setValueAt(l.getFlowers().get(i).getPrice(), i, 1);
			
					}//end for
				}//end if-else
							
			}//end metode

			
			//Métode per omplir la taula d'arbres
			private void puttreedatesintable(FlowerShop l) {
				DefaultTableModel modelotree = (DefaultTableModel)treetable.getModel();
				String treedates[] = new String[2];
				if (l.getTrees()==null) labelsensestocktree.setVisible(true);
				else {
					for (int i= 0; i< l.getTrees().size();i++) {
						treedates[0]=Integer.toString(l.getTrees().get(i).getHeight());
						treedates[1]= Double.toString(l.getTrees().get(i).getPrice());
						modelotree.addRow(treedates);
						modelotree.setValueAt(l.getTrees().get(i).getHeight(), i, 0);
						modelotree.setValueAt(l.getTrees().get(i).getPrice(), i, 1);
						
					}//end for
				}//end if-else
				
			}//end metode
			

			//Metode per ocultar sense decoració
			private void visiblestock() {
				labelsensestocktree.setVisible(false);
				lblsensesstockflower.setVisible(false);
				lblsensesstockdecoration.setVisible(false);
				
			}

			//Métode per "buidar" les tables. Truquem a un metode per esborrar una taulka determinada 
			private void deleteTables() {
				removetable(treetable);
				removetable(flowertable);
				removetable(decorationtable);
			}//end metode

			//Métode per esborrar una taula
			private void removetable(JTable table) {
				DefaultTableModel modelo = (DefaultTableModel)table.getModel();
				
				while (table.getRowCount() > 0)	modelo.removeRow(0);
			
			}//end metode 
		});
		
		
		flowershopcombobox.setBounds(137, 10, 168, 21);
		frmStocks.getContentPane().add(flowershopcombobox);
		
		
		/**********************************************************************************************************************************/
		if (!flowershoprepository.isEmpty()) { //Control conforme hay alguna floristeria creada.
			for(FlowerShop l : flowershoprepository) {
				flowershopcombobox.addItem(l.getName());
				}
		}
		
	}
	
	
	
}
