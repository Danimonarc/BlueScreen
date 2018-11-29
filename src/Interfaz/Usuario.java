package Interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textTlf;
	private JTextField faxTlf;
	private JTextField textWeb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
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
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(volverBtn, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblEmail = new JLabel("email");
		
		JLabel lblTlf = new JLabel("tlf");
		
		JLabel lblFax = new JLabel("fax");
		
		JLabel lblWeb = new JLabel("web");
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		textTlf = new JTextField();
		textTlf.setColumns(10);
		
		faxTlf = new JTextField();
		faxTlf.setColumns(10);
		
		textWeb = new JTextField();
		textWeb.setColumns(10);
		
		JButton cartasBtn = new JButton("Cartas");
		
		JButton Niños = new JButton("Ni\u00F1os");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblEmail)
						.addComponent(lblTlf)
						.addComponent(lblFax)
						.addComponent(lblWeb)
						.addComponent(cartasBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textWeb, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
								.addComponent(faxTlf)
								.addComponent(textTlf)
								.addComponent(textEmail))
							.addContainerGap(133, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Niños, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(55))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(cartasBtn)
						.addComponent(Niños))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTlf)
						.addComponent(textTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFax)
						.addComponent(faxTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeb)
						.addComponent(textWeb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		panel_1.setLayout(gl_panel_1);
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}
}
