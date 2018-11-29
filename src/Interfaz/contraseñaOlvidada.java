package Interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class contraseñaOlvidada extends JFrame {

	private JPanel contentPane;
	private JTextField texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contraseñaOlvidada frame = new contraseñaOlvidada();
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
	public contraseñaOlvidada() {
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
		
		texto = new JTextField();
		texto.setColumns(10);
		
		JLabel lblIntoduzcaSuCorreo = new JLabel("Intoduzca su correo electr\u00F3nico y le enviaresmos\r\n\r\n");
		
		JLabel lblUnEmailCon = new JLabel("un email con los pasos que ha de seguir");
		
		JButton btnEnviar = new JButton("Enviar");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblUnEmailCon)
							.addGap(115))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblIntoduzcaSuCorreo)
							.addGap(93))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(texto, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addGap(100))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnEnviar)
							.addGap(178))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(42)
					.addComponent(lblIntoduzcaSuCorreo)
					.addGap(18)
					.addComponent(lblUnEmailCon)
					.addGap(34)
					.addComponent(texto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEnviar)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();}});
	}

}
