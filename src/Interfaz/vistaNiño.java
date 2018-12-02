package Interfaz;

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

import prototype.Beneficiario;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class vistaNiño extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField fechaNac;
	private JTextField proyecto;
	private JTextField lugarNac;
	private JTextField lugarRes;
	private JTextField fechaEn;
	private JTextField fechaSal;
	private JTextField beca;
	private JTextField nota;

	private String name, lugarN, lugarR, project, bec, comentario;
	private int mark;
	private Date birthDate, entryDate, exitDate;
	private boolean nombreO, fechaEnO, proyectoO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaNiño frame = new vistaNiño(null);
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
	
	public vistaNiño(Beneficiario ben) {
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
		
		fechaNac = new JTextField();
		fechaNac.setColumns(10);
		
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
		
		fechaEn = new JTextField();
		fechaEn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Entrada*");
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de");
		
		fechaSal = new JTextField();
		fechaSal.setColumns(10);
		
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
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lugarNac, Alignment.LEADING)
												.addComponent(fechaNac, Alignment.LEADING))
											.addGap(35)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1, Alignment.TRAILING)
												.addComponent(lblNewLabel, Alignment.TRAILING)))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(beca, Alignment.LEADING)
												.addComponent(fechaEn, Alignment.LEADING))
											.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_4)
												.addComponent(lblNewLabel_5)
												.addComponent(lblNota))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(nota, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addComponent(fechaSal, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
											.addComponent(lugarRes, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
											.addComponent(proyecto))))))
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
							.addGap(37)
							.addComponent(lblFecha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNacimiento))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(fechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(proyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(fechaEn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fechaSal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_5))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_3)))))
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
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		}
		
//		INICIALIZACIÓN DE VARIABLES MODO EDITAR
		if(!(ben==null)) 
		{
			name = ben.getName();
			birthDate = ben.getBirthDate();
			entryDate = ben.getEntryDate();
			mark = ben.getCourseGrade();
			lugarN = ben.getBirthPlace();
			lugarR = ben.getLivingPlace();
			project = ben.getProject();
			bec=ben.getBeca();
			exitDate = ben.getExitDate();
			comentario = ben.getComments();
			
			
			nombre.setText(name);
			fechaNac.setText(birthDate.toString());
			fechaEn.setText(entryDate.toString());
			nota.setText(mark+"");
			lugarNac.setText(lugarN);
			lugarRes.setText(lugarR);
			proyecto.setText(project);
			beca.setText(bec);
			observaciones.setText(comentario);
		
			if(exitDate!=null) 
			{
				fechaSal.setText(exitDate.toString());
			}
			
		
			
			
		}
		
//			AÑADIDO A LA BASE DE DATOS EN MODO AÑADIR
		
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreO = nombre.getText().equals("");
				fechaEnO= fechaEn.getText().equals("");
				proyectoO = proyecto.getText().equals("");
				if((nombreO||proyectoO||fechaEnO)) 
				{
					labelO.setForeground(Color.RED);
				}
				else {	
					try {
						
						if(!fechaNac.getText().equals("")) {
							birthDate = format.parse(fechaNac.getText());
						}
						if(!fechaEn.getText().equals("")) {
							entryDate = format.parse(fechaEn.getText());  //Controlamos si las fechas son nulas 
						} 												  //para controlar excepciones
						if(!fechaSal.getText().equals("")) {
							exitDate = format.parse(fechaSal.getText());
						}
						
						name = nombre.getText();
						bec = beca.getText();
						project = proyecto.getText();
						mark = Integer.parseInt(nota.getText());
						lugarN = lugarNac.getText();
						lugarR = lugarRes.getText();
						comentario = observaciones.getText();
						
						new Beneficiario(1, name, "", "Female", birthDate, entryDate, exitDate,
								format.parse("10/10/2018"), format.parse("10/10/2018"), bec, project,
								mark, lugarN, lugarR, comentario);
						
					} catch (NumberFormatException e) {
						new Dialogo(e.getMessage(),true, true);
					} catch (ParseException e) {
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
				fechaEnO= fechaEn.getText().equals("");
				proyectoO = proyecto.getText().equals("");
				if((nombreO||proyectoO||fechaEnO)) 
				{
					labelO.setForeground(Color.RED);
				}
				else {
				try {
				
				ben.setName(nombre.getText());
				ben.setBirthDate(format.parse(fechaNac.getText()));
				ben.setEntryDate(format.parse(fechaEn.getText()));
				ben.setCourseGrade(Integer.parseInt(nota.getText()));
				ben.setBirthPlace(lugarNac.getText());
				ben.setLivingPlace(lugarRes.getText());
				ben.setProject(proyecto.getText());
				ben.setBeca(beca.getText());
				
				
				if(!(fechaSal.getText().equals("") && ben.getExitDate().toString().equals(""))) 
				{
					ben.setExitDate(format.parse(fechaSal.getText()));
				}
				}catch(ParseException e)
				{
					e.printStackTrace();
				}}
				;}});
		
//			BOTON DE VOLVER
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
		panel_1.setLayout(gl_panel_1);
	}
}
