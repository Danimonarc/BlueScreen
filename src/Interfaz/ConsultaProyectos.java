package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import prototype.Beneficiario;
import prototype.Proyecto;

public class ConsultaProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField entrada;
	private JTable table;
	private Object[] bena;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProyectos frame = new ConsultaProyectos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaProyectos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		entrada = new JTextField();
		panel.add(entrada);
		entrada.setColumns(10);
		
		JButton botonAceptar = new JButton("Buscar");
		panel.add(botonAceptar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "ID"}));
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		
		
		JButton eliminar = new JButton("Eliminar\r\n");
		panel_1.add(eliminar);
		
		JButton btnVolver = new JButton("Volver");
		panel_1.add(btnVolver);
		String[] colums = {"Nombre", "Lugar"};
		
		/*JButton modificar = new JButton("Modificar");
		panel_1.add(modificar);
		
		JButton btnAdd = new JButton("A\u00F1adir");
		panel_1.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new VistaProyecto(null).setVisible(true);
			}
		});*/
		
		JTable table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			colums
		));
		
		table.getColumnModel().getColumn(1).setPreferredWidth(53);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		for (Proyecto b :Proyecto.ProjectList()) 
		{
			Object[] bena = {b.getName(),b.getLocation()};
			modelo.addRow(bena);
		}
		
		
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ID = Integer.parseInt(entrada.getText());
				Proyecto ben = new Proyecto(ID);
				modelo.setRowCount(0);
				if(!ben.equals(null)) 
				{
					Object[] bena = {ben.getName(),ben.getLocation()};
					
					modelo.addRow(bena);
				}	
			}});
		
		
		
		/*modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
				new VistaProyecto(new Proyecto(id)).setVisible(true);
									
			}});*/

		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id;
				id = table.getValueAt(table.getSelectedRow(), 0).toString();
				
				}});
		
		
		contentPane.add(table, BorderLayout.CENTER);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	
	}

}
