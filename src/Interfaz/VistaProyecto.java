package Interfaz;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import prototype.*;

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
	private JTextField nameText;

	//Global variables
	private Proyecto project = null;
	private Sede headquarter = null;
	private JTextField provinceText;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaProyecto frame = new VistaProyecto(-1);
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
	public VistaProyecto(int id) {
		//initialization of all the objects related with this project (only update mode)
		if(id != -1) {
			project = new Proyecto(id);
			try {
				headquarter = new Sede(id);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel botones = new JPanel();
		contentPane.add(botones, BorderLayout.SOUTH);
		
		JLabel warning = new JLabel("Los campos con *  son obligatorios");
		warning.setForeground(SystemColor.menu);
		
		JButton exitButton = new JButton("Volver");
		
		botones.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
		locationText = new JTextField();
		locationText.setColumns(10);
		//Disable province text in Update mode
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		
		JLabel idLabel = new JLabel("Id:");
		
		JLabel nameLabel = new JLabel("Nombre:");
		
		JLabel locationLabel = new JLabel("Localizacion:");
		
		JCheckBox headquarterCheckBox = new JCheckBox("Sede");	
		
		//Making the checkbox enable and disable the province field (only enabled for headquarter)
		headquarterCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(provinceText.isEditable()) {
					provinceText.setEditable(false);
				} else {
					provinceText.setEditable(true);
				}
			}
		});
		
		JLabel provinceLabel = new JLabel("Provincia:");
		
		JButton acceptButton = new JButton("Aceptar");
		
		botones.add(acceptButton);
		acceptButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			
				//Checking for mandatory data not filled
				if(locationText.getText().contentEquals("") || nameText.getText().contentEquals("")) {
					warning.setText("Los campos nombre y localizacion son obligatorios");
					warning.setForeground(SystemColor.RED);
					
				} else {
					//Form data into variables
					String name = nameText.getText();
					String location = locationText.getText();
					String province = provinceText.getText();
					boolean headquarterBool = headquarterCheckBox.isSelected();
										
					/*
					 * TODO: (¿Mensaje de confirmacion?)
					 */
					if(id != -1) {  //Update mode (existing data)
						project.setName(name);
						project.setLocation(location);
						
						//Close the window
						dispose();
						
					} else {  //Add mode (non-existing data)
						if(headquarterBool) {
							if(!province.contentEquals("")) {
								//public Proyecto(String location, String name)
								new Proyecto(location, name);
								
								//public Sede(int id, String province)
								new Sede(id, province);						
								
								//Close the window
								dispose();
							} else {
								warning.setText("Debe añadir una provincia para la sede");
								warning.setBackground(SystemColor.RED);
							}
							
						} else {
							//public Proyecto(String location, String name)
							new Proyecto(location, name);
							
							//Close the window
							dispose();
						}					
					}
					
				}
			}
		});
		
		
		
		
		provinceText = new JTextField();
		provinceText.setColumns(10);
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(warning, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panelCentral.createSequentialGroup()
							.addComponent(idLabel)
							.addGap(99)
							.addComponent(idText, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(headquarterCheckBox))
						.addGroup(Alignment.LEADING, gl_panelCentral.createSequentialGroup()
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addComponent(locationLabel)
								.addComponent(nameLabel)
								.addComponent(provinceLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addComponent(provinceText, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
								.addComponent(locationText, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
								.addComponent(nameText, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))))
					.addGap(30))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(headquarterCheckBox))
					.addGap(26)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel)
						.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationLabel)
						.addComponent(locationText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(provinceLabel)
						.addComponent(provinceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(warning)
					.addGap(17))
		);
		panelCentral.setLayout(gl_panelCentral);
		
		//Initialize all the fields when updating data
		if(id != -1) {  //Update mode
			headquarterCheckBox.setEnabled(false);
			provinceText.setEditable(false);
			
			//Non-editable
			idText.setText(Integer.toString(id));
			
			//Text boxes
			nameText.setText(project.getName());
			locationText.setText(project.getLocation());
			if(headquarter!=null) {
				provinceText.setText(headquarter.getProvince());
			}
				
			//Check Boxes
			headquarterCheckBox.setSelected(headquarter != null);
		}	
	}	
}