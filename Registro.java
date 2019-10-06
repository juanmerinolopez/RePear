import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Registro extends JFrame implements ActionListener
{
	//private static final long serialVersionUID = 1L;
	JButton btnRegistrarse = new JButton("Registrarse");
	JButton btnCancelar = new JButton("Cancelar");
	JLabel lblCorreo = new JLabel("Correo: ");
	JLabel lblNombre = new JLabel("Nombre: ");
	JLabel lblClave = new JLabel("Clave: ");
	JTextField txtCorreo = new JTextField(20);
	JTextField txtNombre = new JTextField(20);
	JTextField txtClave = new JTextField(20);
	
	public Registro()
	{
		btnRegistrarse.addActionListener(this);
		btnCancelar.addActionListener(this);
		
		JPanel panelNorteCentral = new JPanel(new FlowLayout());
		panelNorteCentral.add(lblCorreo);
		panelNorteCentral.add(txtCorreo);
		
		JPanel panelCentralCentral = new JPanel(new FlowLayout());
		panelCentralCentral.add(lblNombre);
		panelCentralCentral.add(txtNombre);
		
		JPanel panelSurCentral = new JPanel(new FlowLayout());
		panelSurCentral.add(lblClave);
		panelSurCentral.add(txtClave);
		
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.add(panelNorteCentral, BorderLayout.NORTH);
		panelCentral.add(panelCentralCentral, BorderLayout.CENTER);
		panelCentral.add(panelSurCentral, BorderLayout.SOUTH);
		
		JPanel panelSur = new JPanel(new FlowLayout());
		panelSur.add(btnRegistrarse);
		panelSur.add(btnCancelar);
		
		this.setLayout(new BorderLayout()); 
		this.setTitle("Registrarse");
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelSur, BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	@Override //Metodo para darles funciones a los botones
    public void actionPerformed(ActionEvent e)
    {
        Object target = e.getSource();
        if(target == btnRegistrarse)
        {
            EscribirFichero.registra(txtCorreo.getText(), txtClave.getText());
        	JOptionPane.showMessageDialog(this, "Usuario creado");
            this.dispose();
        }
        else if(target == btnCancelar)
            this.dispose();
    }
}
