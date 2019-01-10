package Interfaz;
import prototype.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class consultaIngresoEgreso extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultaIngresoEgreso frame = new consultaIngresoEgreso();
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
	public consultaIngresoEgreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		panel.add(dateChooser);
		
		JButton botonAceptar = new JButton("Buscar");
		panel.add(botonAceptar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 mes", "1 a\u00F1o", "1 semana"}));
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton modificar = new JButton("Modificar");
		panel_1.add(modificar);
		
		JButton eliminar = new JButton("Eliminar\r\n");
		panel_1.add(eliminar);
		
		JButton btnVolver = new JButton("Volver");
		panel_1.add(btnVolver);
		String[] colums = {"Cantidad", "Fecha", "ID"};
		
		JButton btnAdd = new JButton("A\u00F1adir");
		panel_1.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VistaNino(null).setVisible(true);
			}
		});
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			colums
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(53);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		for(Movimiento m : Movimiento.TransactionList()) 
		{
			
			Object[] bena = {m.getQuantity(),m.getTransactionDate(), m.getDescription(),};
			modelo.addRow(bena);
		}
		
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}});
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
				new VistaInEg(new Movimiento(id)).setVisible(true);
				
				
				
				
			}});

		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
				new Movimiento(id).DeleteTransaction();;
				}});
		
		
		contentPane.add(table, BorderLayout.CENTER);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}
	}


