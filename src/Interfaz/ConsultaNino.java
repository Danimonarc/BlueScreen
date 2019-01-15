package Interfaz;
import prototype.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import prototype.Beneficiario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
import java.util.Arrays;
import java.util.Vector;
*/
import javax.swing.JTextField;
import javax.swing.JButton;
/*
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
*/
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ConsultaNino extends JFrame {

	private JPanel contentPane;
	private JTextField entrada;
	private JTable table;
	private Object[] bena;
	Persona aux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaNino frame = new ConsultaNino();
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
	public ConsultaNino() {
		
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "ID", "Lugar de nacimiento", "Lugar de residencia"}));
		panel.add(comboBox);
		//comboBox.getSelectedIndex()
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton modificar = new JButton("Modificar");
		panel_1.add(modificar);
		
		JButton eliminar = new JButton("Eliminar\r\n");
		panel_1.add(eliminar);
		
		JButton btnVolver = new JButton("Volver");
		panel_1.add(btnVolver);
		
		JButton btnAdd = new JButton("A\u00F1adir");
		panel_1.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VistaNino(null).setVisible(true);
			}
		});
		
		String[] colums = {"ID", "Cantidad", "Fecha", "Descripcion"};
		
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
		for (Beneficiario b :Beneficiario.BeneficiaryList()) 
		{
			aux = new Persona(b.getPersonId());
			Object[] bena = {aux.getName(),aux.getBirthDate(), aux.getId()};
			modelo.addRow(bena);
		}
		
		
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ID = Integer.parseInt(entrada.getText());
				Beneficiario ben = new Beneficiario(ID);
				modelo.setRowCount(0);  //Esto borra las entradas de la tabla
				if(!ben.equals(null)) 
				{
					aux = new Persona(ben.getPersonId());
					Object[] bena = {aux.getName(),aux.getBirthDate(), ben.getPersonId()};
					
					modelo.addRow(bena);
				}
				
				
			}});
		
		
		
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
				new VistaNino(new Beneficiario(id)).setVisible(true);
				
				
				
				
			}});

		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
				new Beneficiario(id).DeleteBeneficiary();
				}});
		
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}

}
