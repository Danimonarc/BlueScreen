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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import prototype.Beneficiario;
import prototype.Coordinador;
import prototype.Persona;
import prototype.Proyecto;
import javax.swing.ScrollPaneConstants;

public class ConsultaAgente extends JFrame {

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
					ConsultaAgente frame = new ConsultaAgente();
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
	public ConsultaAgente() {
		setTitle("Coordinadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 400);
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
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Id", "Nombre", "Apellido", "Proyecto"}));
		panel.add(searchComboBox);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton addButton = new JButton("A\u00F1adir");
		panel_1.add(addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VistaAgente().setVisible(true);
			}
		});
		
		JButton updateButton = new JButton("Ver/Modificar");
		panel_1.add(updateButton);
		
		JButton deleteButton = new JButton("Eliminar\r\n");
		panel_1.add(deleteButton);
		
		JButton backButton = new JButton("Volver");
		panel_1.add(backButton);
		
		String[] colums = {"Id", "Nombre", "Apellidos", "Proyecto"};
		
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
		table.getColumnModel().getColumn(1).setPreferredWidth(53);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		for (Coordinador coordinator :Coordinador.AgentList()) 
		{
			Proyecto project = new Proyecto(coordinator.getProjectId());
			Persona person = new Persona(coordinator.getPersonId());
			
			Object[] entry = {
				person.getId(),person.getName(),person.getSurname(), project.getName()
			};
			
			modelo.addRow(entry);
		}
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ID = Integer.parseInt(searchText.getText());
				Coordinador ben = new Coordinador(ID);
				modelo.setRowCount(0);
				if(!ben.equals(null)) 
				{
					Object[] bena = {new Persona(ben.getPersonId()).getName(),ben.getPhoneNumber(),ben.getPersonId()};
					
					modelo.addRow(bena);
				}
				
				
			}});
		
		
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VistaAgente().setVisible(true);
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
				new Coordinador(id).DeleteAgent();
			}});
		
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}

}
