package Interfaz;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import prototype.Beneficiario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
public class VistaProyecto extends JFrame {

	private JPanel contentPane;
	private JTextField locationText;
	private JTextField idText;
	private JTextField projectText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaProyecto frame = new VistaProyecto();
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
	public VistaProyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel botones = new JPanel();
		contentPane.add(botones, BorderLayout.SOUTH);
		
		JLabel warning = new JLabel("Los campos con *  son obligatorios");
		warning.setForeground(SystemColor.menu);
		
		JButton acceptButton = new JButton("Aceptar");
		
		botones.add(acceptButton);
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idText.getText().equals("") || projectText.getText().equals("") || locationText.getText().equals("")) 
				{
					warning.setForeground(SystemColor.RED);
				}
				else 
				{
					//TODO: añadir el proyecto y cerrar la ventana (¿Notificacion de exito?)
				}
			}
		});
		
		JButton cancelButton = new JButton("Cancelar");
		
		botones.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Cerrar la ventana y volver a la anterior
			}
		});
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
		locationText = new JTextField();
		locationText.setColumns(10);
		
		idText = new JTextField();
		idText.setColumns(10);
		
		projectText = new JTextField();
		projectText.setColumns(10);
		
		JLabel idLabel = new JLabel("*Id:");
		
		JLabel nameLabel = new JLabel("*Nombre:");
		
		JLabel locationLabel = new JLabel("*Localizacion:");
		
		JCheckBox chckbxSede = new JCheckBox("Sede");
		chckbxSede.setSelected(true);
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
										.addComponent(locationLabel)
										.addComponent(nameLabel))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
										.addComponent(locationText, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
										.addComponent(projectText, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addComponent(idLabel)
									.addGap(99)
									.addComponent(idText, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
									.addComponent(chckbxSede)
									.addGap(72))))
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addGap(123)
							.addComponent(warning)))
					.addContainerGap())
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxSede))
					.addGap(26)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel)
						.addComponent(projectText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationLabel)
						.addComponent(locationText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addComponent(warning)
					.addContainerGap())
		);
		panelCentral.setLayout(gl_panelCentral);
}	
}