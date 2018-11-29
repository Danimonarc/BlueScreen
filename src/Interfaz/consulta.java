package Interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prototype.Beneficiario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;

public class consulta extends JFrame {

	private JPanel contentPane;
	private JTextField entrada;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consulta frame = new consulta();
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
	public consulta() {
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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton modificar = new JButton("Modificar");
		panel_1.add(modificar);
		
		JButton eliminar = new JButton("Eliminar\r\n");
		panel_1.add(eliminar);
		
		JButton btnVolver = new JButton("Volver");
		panel_1.add(btnVolver);
		
		Vector rowData = new Vector();
		Vector colData;
		String[] col= {"","",""};
		for(int i =0; i<1; i++) 
		{
			colData = new Vector(Arrays.asList(col));
			rowData.add(colData);
		}
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Beneficiario ben = new Beneficiario(Integer.parseInt(entrada.getText()));
				//col[0] = ben.getName()+" "+ben.getSurname();
				//col[1] = ben.getBirthDate().toString();
				//col[2] = ben.getSex();
				col[0] = "a";
				col[1] = "c";
				col[2] = "b";
				
			}});
		
		
		String[] colums = {"Nombre", "Fecha de nacimiento", "Localidad"};
		Vector columnames = new Vector(Arrays.asList(colums));
		JTable table = new JTable(rowData, columnames);
		table.
		contentPane.add(table, BorderLayout.CENTER);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}

}
