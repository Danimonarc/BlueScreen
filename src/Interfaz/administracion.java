package Interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;*/
import javax.swing.LayoutStyle.ComponentPlacement;

public class administracion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administracion frame = new administracion();
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
	public administracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton backBtn = new JButton("Volver");
		panel.add(backBtn, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton niñosBtn = new JButton("Ni\u00F1os");
		niñosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new consulta().setVisible(true);;}});
		
		JButton agenteBtn = new JButton("Agente");
		agenteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaAgente().setVisible(true);
			}
		});
		
		JButton edificioBtn = new JButton("Proyectos");
		edificioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaProyectos().setVisible(true);
			}
		});
		
		JButton btnApadrinamiento = new JButton("Apadrinamientos");
		btnApadrinamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnSocios = new JButton("Socios");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(niñosBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(edificioBtn, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(agenteBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSocios, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnApadrinamiento, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
							.addGap(87))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(niñosBtn)
						.addComponent(btnSocios))
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(agenteBtn)
						.addComponent(edificioBtn))
					.addGap(49)
					.addComponent(btnApadrinamiento)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
		panel_1.setLayout(gl_panel_1);
	}
}
