package Interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class contabilidad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contabilidad frame = new contabilidad();
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
	public contabilidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton volverBtn = new JButton("Volver");
		panel.add(volverBtn, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton ingresosBtn = new JButton("Ingresos");
		ingresosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new consultaIngresoEgreso().setVisible(true);
			}
		});
		
		JButton egresosBtn = new JButton("Egreso");
		egresosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new consultaIngresoEgreso().setVisible(true);
			}
		});
		
		JButton saldosBtn = new JButton("Saldos");
		
		JButton proyectsosBtn = new JButton("Proyectos");
		proyectsosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaProyectos().setVisible(true);
			}
		});
		
		JButton pagosBtn = new JButton("Ord. pagos");
		
		JButton beneficiosBtn = new JButton("Beneficios");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(egresosBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ingresosBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(saldosBtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(proyectsosBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pagosBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(beneficiosBtn))
					.addGap(55))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(ingresosBtn)
						.addComponent(proyectsosBtn))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(egresosBtn)
						.addComponent(pagosBtn))
					.addGap(38)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(saldosBtn)
						.addComponent(beneficiosBtn))
					.addGap(39))
		);
		panel_1.setLayout(gl_panel_1);
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}

}
