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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 530);
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
		addressText.setBounds(141, 180, 361, 32);
		contentPane.add(addressText);
		
		projectText = new JTextField();
		projectText.setColumns(10);
		projectText.setBounds(412, 21, 90, 32);
		contentPane.add(projectText);
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(141, 230, 361, 32);
		contentPane.add(phoneText);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * TODO: añadir el coordinador y cerrar la pestaña (¿Mensaje de confirmacion?)
				 */
			}
		});
		btnAceptar.setBounds(141, 403, 141, 35);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * TODO: Cerrar la ventana y volver a la anterior
				 */
			}
		});
		btnCancelar.setBounds(303, 403, 141, 35);
		contentPane.add(btnCancelar);
		
		JLabel IdLabel = new JLabel("Id:");
		IdLabel.setBounds(21, 24, 125, 26);
		contentPane.add(IdLabel);
		
		JLabel projectLabel = new JLabel("Proyecto:");
		projectLabel.setBounds(303, 24, 90, 26);
		contentPane.add(projectLabel);
		
		JLabel addressLabel = new JLabel("Direccion:");
		addressLabel.setBounds(21, 186, 99, 26);
		contentPane.add(addressLabel);
		
		JLabel phoneLabel = new JLabel("Telefono:");
		phoneLabel.setBounds(21, 233, 92, 26);
		contentPane.add(phoneLabel);
		
		JLabel jobLabel = new JLabel("Posicion:");
		jobLabel.setBounds(21, 284, 92, 26);
		contentPane.add(jobLabel);
		
		JLabel privilegeLabel = new JLabel("Permisos");
		privilegeLabel.setBounds(21, 331, 92, 26);
		contentPane.add(privilegeLabel);
		
		JLabel nameLabel = new JLabel("Nombre: ");
		nameLabel.setBounds(21, 77, 92, 26);
		contentPane.add(nameLabel);
		
		JLabel surnameLabel = new JLabel("Apellidos:");
		surnameLabel.setBounds(21, 130, 92, 26);
		contentPane.add(surnameLabel);
		
		jobText = new JTextField();
		jobText.setColumns(10);
		jobText.setBounds(141, 283, 361, 32);
		contentPane.add(jobText);
		
		JComboBox privilegeComboBox = new JComboBox();
		privilegeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Socio", "Agente", "Administrador"}));
		privilegeComboBox.setBounds(141, 328, 125, 32);
		contentPane.add(privilegeComboBox);
		
	}
}
