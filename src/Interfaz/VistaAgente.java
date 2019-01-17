package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import com.toedter.calendar.JDateChooser;

import prototype.*;

import javax.swing.JTextArea;

public class VistaAgente extends JFrame {

	private JPanel contentPane;
	private JTextField idText;
	private JTextField nameText;
	private JTextField surnameText;
	private JTextField addressText;
	private JTextField phoneText;
	private JTextField jobText;
	
	//global variables
	private Coordinador coordinator = null;
	private Persona person = null;
	private Proyecto project = null;
	private int[] projectIdList = new int[100];
	private String[] projectNameList = new String[100];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAgente frame = new VistaAgente(-1);
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
	public VistaAgente(int id) {
		//initialization of all the objects related with this person (only update mode)
		if(id != -1) {
			coordinator = new Coordinador(id);
			person = new Persona(id);
			project = new Proyecto(coordinator.getProjectId());
		}
		
		setTitle("Coordinador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(141, 21, 90, 32);
		contentPane.add(idText);
		idText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(141, 74, 361, 32);
		contentPane.add(nameText);
		
		surnameText = new JTextField();
		surnameText.setColumns(10);
		surnameText.setBounds(141, 127, 361, 32);
		contentPane.add(surnameText);
		
		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(141, 277, 361, 32);
		contentPane.add(addressText);
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(141, 325, 361, 32);
		contentPane.add(phoneText);
		
		JButton exitButton = new JButton("Salir");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		exitButton.setBounds(303, 723, 141, 35);
		contentPane.add(exitButton);
		
		JLabel IdLabel = new JLabel("Id:");
		IdLabel.setBounds(21, 24, 125, 26);
		contentPane.add(IdLabel);
		
		JLabel projectLabel = new JLabel("Proyecto:");
		projectLabel.setBounds(270, 24, 90, 26);
		contentPane.add(projectLabel);
		
		JLabel addressLabel = new JLabel("Direccion:");
		addressLabel.setBounds(21, 280, 99, 26);
		contentPane.add(addressLabel);
		
		JLabel phoneLabel = new JLabel("Telefono:");
		phoneLabel.setBounds(21, 328, 92, 26);
		contentPane.add(phoneLabel);
		
		JLabel jobLabel = new JLabel("Posicion:");
		jobLabel.setBounds(21, 375, 92, 26);
		contentPane.add(jobLabel);
		
		JLabel privilegeLabel = new JLabel("Permisos:");
		privilegeLabel.setBounds(21, 425, 92, 26);
		contentPane.add(privilegeLabel);
		
		JLabel nameLabel = new JLabel("Nombre: ");
		nameLabel.setBounds(21, 77, 92, 26);
		contentPane.add(nameLabel);
		
		JLabel surnameLabel = new JLabel("Apellidos:");
		surnameLabel.setBounds(21, 130, 92, 26);
		contentPane.add(surnameLabel);
		
		jobText = new JTextField();
		jobText.setColumns(10);
		jobText.setBounds(141, 372, 361, 32);
		contentPane.add(jobText);
		
		JComboBox privilegeComboBox = new JComboBox();
		privilegeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Socio", "Agente", "Administrador"}));
		privilegeComboBox.setBounds(141, 422, 125, 32);
		contentPane.add(privilegeComboBox);
		
		JLabel commentsLabel = new JLabel("Comentarios:");
		commentsLabel.setBounds(21, 566, 125, 26);
		contentPane.add(commentsLabel);
		
		JLabel entryDateLabel = new JLabel("Fecha alta:");
		entryDateLabel.setBounds(21, 472, 112, 26);
		contentPane.add(entryDateLabel);
		
		JLabel exitDateLabel = new JLabel("Fecha baja:");
		exitDateLabel.setBounds(21, 519, 112, 26);
		contentPane.add(exitDateLabel);
		
		JLabel birthDateLabel = new JLabel("Nacimiento:");
		birthDateLabel.setBounds(21, 233, 119, 26);
		contentPane.add(birthDateLabel);
		
		JLabel sexLabel = new JLabel("Sexo:");
		sexLabel.setBounds(21, 183, 92, 26);
		contentPane.add(sexLabel);
		
		JDateChooser birthDateChooser = new JDateChooser();
		birthDateChooser.setBounds(141, 233, 147, 32);
		contentPane.add(birthDateChooser);
		
		JDateChooser entryDateChooser = new JDateChooser();
		entryDateChooser.setBounds(141, 466, 147, 32);
		contentPane.add(entryDateChooser);
		
		JDateChooser exitDateChooser = new JDateChooser();
		exitDateChooser.setBounds(141, 513, 147, 32);
		contentPane.add(exitDateChooser);
		
		JComboBox sexComboBox = new JComboBox();
		sexComboBox.setModel(new DefaultComboBoxModel(new String[] {"hombre", "mujer"}));
		sexComboBox.setBounds(141, 180, 125, 32);
		contentPane.add(sexComboBox);
		
		JTextArea commentText = new JTextArea();
		commentText.setBounds(21, 600, 481, 88);
		contentPane.add(commentText);
		
		JComboBox projectComboBox = new JComboBox();
		projectComboBox.setBounds(369, 21, 133, 32);
		contentPane.add(projectComboBox);
		
		//set the list of projects in the comboBox
		int i = 0;
		for(Proyecto p : Proyecto.ProjectList()) {
	  		projectNameList[i] = p.getName();
	  		projectIdList[i] = p.getId();
	  		i++;
		}
		
		String[] model = new String[i];
		for(int j=0; j<i;j++) {
			model[j] = projectNameList[j];
		}
		projectComboBox.setModel(new DefaultComboBoxModel(model));
		
		JButton acceptButton = new JButton("Aceptar");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				//Checking for mandatory data not filled
				if(idText.getText() == "" || entryDateChooser.getDate() == null || jobText.getText() == "") {
					//WARNING
				} else {
					//Form data into variables
					int projectId = projectIdList[projectComboBox.getSelectedIndex()];
					String name = nameText.getText();
					String surname = surnameText.getText();
					String sex = sexComboBox.getSelectedItem().toString();
					Date birthDate = birthDateChooser.getDate();
					String address = addressText.getText();
					String phoneNumber = phoneText.getText();
					String job = jobText.getText();
					int privilege = privilegeComboBox.getSelectedIndex();
					Date entryDate = entryDateChooser.getDate();
					Date exitDate = exitDateChooser.getDate();
					String comment = commentText.getText();
					
					/*
					 * TODO: (¿Mensaje de confirmacion?)
					 */
					if(id != -1) {  //Update mode (existing data)
						//Person data update
						person.setName(name);
						person.setSurname(surname);
						person.setSex(sex);
						person.setBirthDate(birthDate);
						person.setEntryDate(entryDate);
						person.setEntryDate(entryDate);
						person.setComments(comment);
						
						//Coordinator data update
						coordinator.setProjectId(projectId);
						coordinator.setPrivilege(privilege);
						coordinator.setJob(job);
						coordinator.setPhoneNumber(phoneNumber);
						coordinator.setAddress(address);
						
						//Close the window
						dispose();
						
					} else {  //Add mode (non-existing data)
						//Persona(String name, String surname, String sex, int image, Date birthDate, Date entryDate, Date exitDate, String comments)
						new Persona(name, surname, sex, 7, birthDate, entryDate, exitDate, comment);

						//Coordinador(int person_id, int project_id, int privilege, String job, String phoneNumber, String address)
						new Coordinador(id, projectId, privilege, job, phoneNumber, address);
						
						//Close the window
						dispose();
					}
					
				}
			}
		});
		acceptButton.setBounds(141, 723, 141, 35);
		contentPane.add(acceptButton);
		
		//Initialize all the fields when updating data
		if(id != -1) {  //Update mode
			//Non-editable
			idText.setText(Integer.toString(id));
			
			//Text boxes
			nameText.setText(person.getName());
			surnameText.setText(person.getSurname());
			addressText.setText(coordinator.getAddress());
			phoneText.setText(coordinator.getPhoneNumber());
			jobText.setText(coordinator.getJob());
			commentText.setText(person.getComments());
			
			//Dates
			birthDateChooser.setDate(person.getBirthDate());
			entryDateChooser.setDate(person.getEntryDate());
			exitDateChooser.setDate(person.getExitDate());
			
			//Combo Boxes
			sexComboBox.setSelectedItem(person.getSex());
			privilegeComboBox.setSelectedIndex(coordinator.getPrivilege()); //0=socio, 1=agente, 2=administrador  (privilegios temporales)
		}	
	}
}
