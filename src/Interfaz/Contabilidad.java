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

public class Contabilidad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contabilidad frame = new Contabilidad();
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
	public Contabilidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
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
		ingresosBtn.setBounds(21, 21, 146, 35);
		ingresosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaIngresoEgreso().setVisible(true);
			}
		});
		
		JButton egresosBtn = new JButton("Egreso");
		egresosBtn.setBounds(246, 21, 147, 35);
		egresosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaIngresoEgreso().setVisible(true);
			}
		});
		
		JButton saldosBtn = new JButton("Saldos");
		saldosBtn.setBounds(21, 133, 146, 35);
		
		JButton proyectsosBtn = new JButton("Proyectos");
		proyectsosBtn.setBounds(21, 77, 146, 35);
		proyectsosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaProyectos().setVisible(true);
			}
		});
		
		JButton pagosBtn = new JButton("Ord. pagos");
		pagosBtn.setBounds(246, 133, 147, 35);
		
		JButton beneficiosBtn = new JButton("Beneficios");
		beneficiosBtn.setBounds(246, 77, 147, 35);
		panel_1.setLayout(null);
		panel_1.add(egresosBtn);
		panel_1.add(ingresosBtn);
		panel_1.add(saldosBtn);
		panel_1.add(proyectsosBtn);
		panel_1.add(pagosBtn);
		panel_1.add(beneficiosBtn);
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}

}
