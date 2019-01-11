package Interfaz;
import prototype.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class VistaInEg extends JFrame {

	private JPanel contentPane;
	private JTextField importetxt;
	private JTextField idtxt;
	private JTextField proyectotxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInEg frame = new VistaInEg(null);
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
	public VistaInEg(Movimiento m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel botones = new JPanel();
		contentPane.add(botones, BorderLayout.SOUTH);
		
		JButton cancelarBtn = new JButton("Volver");
		
		botones.add(cancelarBtn);
		
		JButton btnEliminar = new JButton("Eliminar");
		
		botones.add(btnEliminar);
		
		JButton btnModificar = new JButton("Aceptar");
		
		botones.add(btnModificar);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
		importetxt = new JTextField();
		importetxt.setColumns(10);
		
		JLabel lblImporte = new JLabel("Importe*");
		
		JDateChooser fechaEje = new JDateChooser();
		
		JLabel lblFechaDeEjecucin = new JLabel("Fecha de ejecuci\u00F3n");
		
		idtxt = new JTextField();
		idtxt.setColumns(10);
		
		proyectotxt = new JTextField();
		proyectotxt.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		btnEliminar.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Proyecto");
		if(m !=null ) 
		{
			importetxt.setText(m.getQuantity()+"");
			proyectotxt.setText(new Proyecto(m.getProject_id()).getName());
			idtxt.setText(m.getId()+"");
			fechaEje.setDate(m.getTransactionDate());
			btnEliminar.setEnabled(true);
		}
		JLabel warning = new JLabel("Los campos con *  son obligatorios");
		warning.setForeground(SystemColor.menu);
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(123)
					.addComponent(warning)
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblId)
					.addGap(165)
					.addComponent(lblNewLabel)
					.addContainerGap(171, Short.MAX_VALUE))
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(proyectotxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaDeEjecucin)
						.addComponent(fechaEje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImporte)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addGap(10)
							.addComponent(importetxt, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
					.addGap(72))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(proyectotxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeEjecucin)
						.addComponent(lblImporte))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING)
						.addComponent(fechaEje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(importetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
					.addComponent(warning)
					.addContainerGap())
		);
		panelCentral.setLayout(gl_panelCentral);
		
		//Edited
		idtxt.setEnabled(false);
		if(m!=null) {
			btnEliminar.setEnabled(true);
			btnModificar.setEnabled(false);
		}
		
		//
		//Listeners
		//
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m==null) {
					
					if(importetxt.getText().equals("")) 
					{
						warning.setForeground(SystemColor.RED);
					}
					else 
					{
						new Movimiento(Integer.parseInt(proyectotxt.getText()), fechaEje.getDate(), Float.parseFloat(importetxt.getText()), "");
						dispose();
					}
				}
			}
		});
		cancelarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
