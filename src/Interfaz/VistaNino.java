package Interfaz;
import prototype.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

public class VistaNino extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField proyecto;
	private JTextField lugarNac;
	private JTextField lugarRes;
	private JTextField beca;
	private JTextField nota;

	private String name, lugarN, lugarR, project, bec, comentario;
	private float mark;
	private Date birthDate, entryDate, exitDate;
	private boolean nombreO, fechaEnO, proyectoO;
	private Persona be;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNino frame = new VistaNino(null);
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
	
	public VistaNino(Beneficiario ben) {
//				DEFINICIÓN BASE DE LAS FECHAS
		birthDate = null;
		entryDate = null;
		exitDate = null;
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//
//				GENERADO PR LAS LIBRERÍAS, TOCAR LO MENENOS POSIBLE
//
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton guardarBtn = new JButton("Guardar datos");
		panel.add(guardarBtn);
		
		JButton btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		
		JButton añadir = new JButton("A\u00F1adir");
		añadir.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(añadir);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre*");
		
		nombre = new JTextField();
		nombre.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de \r\n");
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		
		JLabel lblNewLabel = new JLabel("Proyecto*");
		
		proyecto = new JTextField();
		proyecto.setColumns(10);
		
		JLabel lblLugarDe = new JLabel("Lugar de");
		
		JLabel lblNacimiento_1 = new JLabel("Nacimiento");
		
		lugarNac = new JTextField();
		lugarNac.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Residencia");
		
		lugarRes = new JTextField();
		lugarRes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de");
		
		JLabel lblNewLabel_3 = new JLabel("Entrada*");
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de");
		
		JLabel lblNewLabel_5 = new JLabel("Salida");
		
		JLabel lblBeca = new JLabel("Beca");
		
		beca = new JTextField();
		beca.setColumns(10);
		
		JLabel lblNota = new JLabel("Nota");
		
		nota = new JTextField();
		nota.setColumns(10);
		
		JTextArea observaciones = new JTextArea();
		
		JLabel lblNewLabel_6 = new JLabel("Observacones");
		
		JLabel labelO = new JLabel("*  Campos obligatorios");
		
		JDateChooser fechaEn = new JDateChooser();
		
		JDateChooser fechaSal = new JDateChooser();
		
		JDateChooser fechaNac = new JDateChooser();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNacimiento)
								.addComponent(lblNombre)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(lblLugarDe)
									.addComponent(lblNewLabel_3)
									.addComponent(lblNewLabel_2)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblBeca)
										.addComponent(lblNacimiento_1)))
								.addComponent(lblFecha))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lugarNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(fechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(26)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1, Alignment.TRAILING)
												.addComponent(lblNewLabel, Alignment.TRAILING)))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(beca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(fechaEn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_4)
												.addComponent(lblNewLabel_5)
												.addComponent(lblNota))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(fechaSal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addComponent(nota, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lugarRes, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
												.addComponent(proyecto)))))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(134)
							.addComponent(lblNewLabel_6)
							.addGap(18)
							.addComponent(observaciones, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(184)
							.addComponent(labelO)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(proyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(fechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblFecha)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNacimiento)))))
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lugarNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)
							.addComponent(lugarRes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblLugarDe)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNacimiento_1)))
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3))
						.addComponent(fechaEn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaSal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBeca)
						.addComponent(beca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNota)
						.addComponent(nota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(observaciones, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelO)
					.addContainerGap(55, Short.MAX_VALUE))
		);
//
//		FIN DEL GENERADO POR LAS LIBRERÍAS
//

//CONTROL DE SI ESTAMOS EN MODO EDICION O EN MODO AÑADIR
		if(ben==null) 
		{
			guardarBtn.setEnabled(false);
		}
		else 
		{
			añadir.setEnabled(false);
			be = new Persona(ben.getPersonId());
		}
		
//		INICIALIZACIÓN DE VARIABLES MODO EDITAR
		if(!(ben==null)) 
		{
			name = be.getName();
			birthDate = be.getBirthDate();
			entryDate = be.getEntryDate();
			mark = ben.getMark();
			lugarN = ben.getBirthCommunity();
			lugarR = ben.getLivingCommunity();
			project = new Proyecto(ben.getProjectId()).getName();
			bec=ben.getScolarship();
			exitDate = ben.getProjectExitDate();
			comentario = be.getComments();
			
			
			nombre.setText(name);
			fechaNac.setDate(birthDate);
			fechaEn.setDate(entryDate);
			nota.setText(mark+"");
			lugarNac.setText(lugarN);
			lugarRes.setText(lugarR);
			proyecto.setText(project);
			beca.setText(bec);
			observaciones.setText(comentario);
		
			if(exitDate!=null) 
			{
				fechaSal.setDate(exitDate);
			}
			
		
			
			
		}
		
//			AÑADIDO A LA BASE DE DATOS EN MODO AÑADIR
		
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreO = nombre.getText().equals("");
				fechaEnO= fechaEn.getDate() == null;
				proyectoO = proyecto.getText().equals("");
				if((nombreO||proyectoO||fechaEnO)) 
				{
					labelO.setForeground(Color.RED);
				}
				else {	
					try {
						
						if(! (fechaNac.getDate()== null)) {
							birthDate = fechaNac.getDate();
						}
						if(!(fechaEn.getDate()==null)) {
							entryDate = fechaEn.getDate();  //Controlamos si las fechas son nulas 
						}
						if(!(fechaSal.getDate()==null)) {
							exitDate = fechaSal.getDate();
						}
						
						name = nombre.getText();
						bec = beca.getText();
						project = proyecto.getText();
						mark = Float.parseFloat(nota.getText());
						lugarN = lugarNac.getText();
						lugarR = lugarRes.getText();
						comentario = observaciones.getText();
						
						Persona auxi =new Persona(name,"","Male",1,birthDate,entryDate,exitDate,comentario);
						new Beneficiario(auxi.getId(), 1, 1, entryDate, exitDate, bec, mark, lugarN, lugarR);
						;
						
					} catch (NumberFormatException e) {
						new Dialogo(e.getMessage(),true, true);
					} 
					}
				
				}});
//		
//			Botón guardar para editar los valores de la base de datos
//
		guardarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreO = nombre.getText().equals("");
				fechaEnO= (fechaEn.getDate()==null);
				proyectoO = proyecto.getText().equals("");
				if((nombreO||proyectoO||fechaEnO)) 
				{
					labelO.setForeground(Color.RED);
				}
				else {
				
				
				be.setName(nombre.getText());
				be.setBirthDate(fechaNac.getDate());
				ben.setProjectEntryDate(fechaEn.getDate());
				ben.setMark(Float.parseFloat(nota.getText()));
				ben.setBirthCommunity(lugarNac.getText());
				ben.setLivingCommunity(lugarRes.getText());
				//ben.setPro(new Proyecto(proyecto.getText()));
				ben.setScolarship(beca.getText());
				
				if(!(fechaSal.getDate()==null) && ben.getProjectExitDate().toString().equals("")) 
				{
					ben.setProjectExitDate(fechaSal.getDate());
				
				}
				;}}});
		
//			BOTON DE VOLVER
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				}});
		panel_1.setLayout(gl_panel_1);
	}
}
