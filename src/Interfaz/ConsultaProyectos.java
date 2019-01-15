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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import prototype.Beneficiario;
import prototype.Proyecto;

public class ConsultaProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField searchText;
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
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		searchText = new JTextField();
		panel.add(searchText);
		searchText.setColumns(10);
		
		JButton searchButton = new JButton("Buscar");
		panel.add(searchButton);
		
		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "ID", "Lugar de nacimiento", "Lugar de residencia"}));
		panel.add(searchComboBox);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton addButton = new JButton("A\u00F1adir");
		panel_1.add(addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new VistaProyecto(null).setVisible(true);
			}
		});
		
		JButton updateButton = new JButton("Ver/Modificar");
		panel_1.add(updateButton);
		
		JButton deleteButton = new JButton("Eliminar\r\n");
		panel_1.add(deleteButton);
		
		JButton backButton = new JButton("Volver");
		panel_1.add(backButton);
		
		String[] colums = {"Id", "Nombre", "Lugar"};
		
		JScrollPane scrollPane = new JScrollPane(); //scroll containing the table
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JTable table = new JTable();
		scrollPane.setViewportView(table); //to contain the table
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			colums
		));
		//cambiar aqui a proyecto
		table.getColumnModel().getColumn(1).setPreferredWidth(53);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		for (Proyecto b :Proyecto.ProjectList()) 
		{
			Object[] bena = {b.getId(),b.getName(),b.getLocation()};
			modelo.addRow(bena);
		}
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ID = Integer.parseInt(searchText.getText());
				Proyecto ben = new Proyecto(ID);
				modelo.setRowCount(0);
				if(!ben.equals(null)) 
				{
					Object[] bena = {ben.getName(),ben.getLocation()};
					
					modelo.addRow(bena);
				}
				
				
			}});
		
		
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
				new VistaNino(new Beneficiario(id)).setVisible(true);
				
				
				
				
			}});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				new Proyecto(id).DeleteProject();
				}});
		
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	
	}

}
