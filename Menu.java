import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener
{
	//private static final long serialVersionUID = -4323519366376105154L;
	JButton btnIniciarSesion = new JButton("Iniciar Sesion");
    JButton btnCancelar = new JButton("Cancelar");
    JButton btnRegistrarse = new JButton("Registrarse");
    JLabel lblUsuario = new JLabel("Usuario: ");
    JTextField txtUsuario = new JTextField(20);
    JLabel lblClave = new JLabel("Clave: ");
    JTextField txtClave = new JTextField(20);
    JLabel lblRegistrarse = new JLabel("¿Aun no tienes cuenta? Registrate: ");

    public Menu()
    {
    	btnIniciarSesion.addActionListener(this);
    	btnCancelar.addActionListener(this);
    	btnRegistrarse.addActionListener(this);

        JPanel panelCentro = new JPanel(new FlowLayout());
        panelCentro.add(btnIniciarSesion);
        panelCentro.add(btnCancelar);
        
        JPanel panelNorte = new JPanel(new FlowLayout());
        panelNorte.add(lblUsuario);
        panelNorte.add(txtUsuario);
        panelNorte.add(lblClave);
        panelNorte.add(txtClave);
        
        JPanel panelSur = new JPanel(new FlowLayout());
        panelSur.add(lblRegistrarse);
        panelSur.add(btnRegistrarse);
        
        this.setLayout(new BorderLayout());
        this.setTitle("Iniciar sesion");
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelCentro, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

        this.pack();
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }    

    public void actionPerformed(ActionEvent e)
    {
        Object target = e.getSource();
        if(target == btnIniciarSesion)
        {
        	if(LeerFichero.leeUsuarios(txtUsuario.getText(), txtClave.getText()) == true)
        	{
        		new JHome();
        		this.dispose();
        	}
        	else
        		JOptionPane.showMessageDialog(this, "Usuario o clave incorrectas");
        }
        else if(target == btnCancelar)
            this.dispose();
        else if(target == btnRegistrarse)
            new Registro();
    }
}