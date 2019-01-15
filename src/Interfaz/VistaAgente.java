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
import java.awt.event.ActionEvent;
import java.awt.TextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class VistaAgente extends JFrame {

	private JPanel contentPane;
	private JTextField idText;
	private JTextField nameText;
	private JTextField surnameText;
	private JTextField addressText;
	private JTextField projectText;
	private JTextField phoneText;
	private JTextField jobText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAgente frame = new VistaAgente();
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
	public VistaAgente() {
		setTitle("Coordinador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idText = new JTextField();
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
		
		projectText = new JTextField(); //TODO: debe ser un combo box (prioridad media-baja)
		projectText.setColumns(10);
		projectText.setBounds(412, 21, 90, 32);
		contentPane.add(projectText);
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(141, 325, 361, 32);
		contentPane.add(phoneText);
		
		JButton acceptButton = new JButton("Aceptar");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * TODO: añadir el coordinador y cerrar la pestaña (¿Mensaje de confirmacion?)
				 */
			}
		});
		acceptButton.setBounds(141, 723, 141, 35);
		contentPane.add(acceptButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * TODO: Cerrar la ventana y volver a la anterior
				 */
			}
		});
		cancelButton.setBounds(303, 723, 141, 35);
		contentPane.add(cancelButton);
		
		JLabel IdLabel = new JLabel("Id:");
		IdLabel.setBounds(21, 24, 125, 26);
		contentPane.add(IdLabel);
		
		JLabel projectLabel = new JLabel("Proyecto:");
		projectLabel.setBounds(303, 24, 90, 26);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"hombre", "mujer"}));
		comboBox.setBounds(141, 180, 125, 32);
		contentPane.add(comboBox);
		
		JTextArea commentText = new JTextArea();
		commentText.setBounds(21, 600, 481, 88);
		contentPane.add(commentText);
		
	}
}
