package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;



public class Dialogo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String mensaje;
	private boolean ok, cancel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialogo dialog = new Dialogo("JAJA SOY YO LA PRUEBA", true, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialogo() 
	{
		this("Error inesperado", true,true);
	}
	public Dialogo(String men, boolean enableOk, boolean enableCancel) {
//		CONTROL DE LOS BOOLEANOS PARA LOS BOTONES Y DEL MENSAJE
			mensaje = men;
			ok = enableOk;
			cancel = enableCancel;
			
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JTextArea mensajeTxt = new JTextArea();
		mensajeTxt.setText(mensaje);
		mensajeTxt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mensajeTxt.setEditable(false);
		contentPanel.add(mensajeTxt);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				
				if(ok) 
				{
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				}
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				
				if(cancel) {
				buttonPane.add(cancelButton);
				}
			}
		}
	}
}
