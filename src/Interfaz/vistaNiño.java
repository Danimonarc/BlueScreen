package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
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
		
		JLabel lblNombre = new JLabel("Nombre");
		
		nombre = new JTextField();
		nombre.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de \r\n");
		
		fechaNac = new JTextField();
		fechaNac.setColumns(10);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		
		JLabel lblNewLabel = new JLabel("Proyecto");
		
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
		
		JLabel lblNewLabel_3 = new JLabel("Entrada");
		
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
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
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
									.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
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
									.addComponent(proyecto)))))
					.addContainerGap(75, Short.MAX_VALUE))
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
					.addContainerGap(212, Short.MAX_VALUE))
		);
		if(!(ben==null)) 
		{
			nombre.setText(ben.getName());
			fechaNac.setText(ben.getBirthDate().toString());
			fechaEn.setText(ben.getEntryDate().toString());
			nota.setText(ben.getCourseGrade()+"");
			lugarNac.setText(ben.getBirthPlace());
			lugarRes.setText(ben.getLivingPlace());
			proyecto.setText(ben.getProject());
			beca.setText(ben.getBeca());
			if(!ben.getExitDate().equals(null)) 
			{
				fechaSal.setText(ben.getExitDate().toString());
			}
			
		
			
			
		}
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
				new Beneficiario(1,nombre.getText(),"","Male",format.parse(fechaNac.getText()),format.parse(fechaEn.getText()),
						null,format.parse("10-10-2018"),null,beca.getText(),proyecto.getText(),Float.parseFloat(nota.getText()),
						lugarNac.getText(),lugarRes.getText(),"");
				}catch(ParseException e) 
				{
					
				}
				
				}});
		guardarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				ben.setName(nombre.getText());
				ben.setBirthDate(format.parse(fechaNac.getText()));
				ben.setEntryDate(format.parse(fechaEn.getText()));
				ben.setCourseGrade(Float.parseFloat(nota.getText()));
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
					
				}
				;}});
		if(ben==null) 
		{
			guardarBtn.setEnabled(false);
		}
		else 
		{
			añadir.setEnabled(false);
		}
		panel_1.setLayout(gl_panel_1);
	}
}
