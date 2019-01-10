package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class VistaAgente extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	private JTextField proyectotxt;

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
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblImporte = new JLabel("Fecha de fin");
		
		JDateChooser fechaIni = new JDateChooser();
		
		JLabel lblFechaDeEjecucin = new JLabel("Fecha de inicio");
		
		idtxt = new JTextField();
		idtxt.setColumns(10);
		
		proyectotxt = new JTextField();
		proyectotxt.setColumns(10);
		
		JLabel lblId = new JLabel("ID*");
		
		JLabel lblNewLabel = new JLabel("Nombre*");
		
		JLabel warning = new JLabel("Los campos con *  son obligatorios");
		warning.setForeground(SystemColor.menu);
		
		JDateChooser FechaFin = new JDateChooser();
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(123)
					.addComponent(warning)
					.addContainerGap(136, Short.MAX_VALUE))
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(lblId)
							.addContainerGap())
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelCentral.createSequentialGroup()
								.addComponent(lblFechaDeEjecucin)
								.addContainerGap())
							.addGroup(gl_panelCentral.createSequentialGroup()
								.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING)
									.addComponent(fechaIni, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panelCentral.createSequentialGroup()
										.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
										.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
											.addComponent(proyectotxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblImporte)
											.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel))))
								.addGap(74)))))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(proyectotxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeEjecucin)
						.addComponent(lblImporte))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(fechaIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(warning)
					.addContainerGap())
		);
		panelCentral.setLayout(gl_panelCentral);
		
		//
		//Listeners
		//
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idtxt.getText().equals("") || proyectotxt.getText().equals("") || beneficiariotxt.getText().equals("")) 
				{
					warning.setForeground(SystemColor.RED);
				}
				else 
				{
					
				}
			}
		});
		cancelarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
}	
	}


