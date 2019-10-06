//package proyectofinal.ui;

/**
 *
 * Ventana principal del programa
 * @author Juan Merino López
 *
 */



import javax.swing.*;
import java.util.*;
import java.awt.*;

public class JHome extends JFrame
{
	//private static final long serialVersionUID = 1L;
	private JButton btnBuscar;
    private JButton btnMiCuenta;

    private JComboBox comboBuscar;
    //private JTextField txtBuscar;
    //private JTextArea txtListado;

    //private HashMap mapaReservas;

    private ImageIcon logo = new ImageIcon("C:\\Users\\Nico\\eclipse-workspace\\Repear\\pp.jpg");

    public static void main(String[] args) 
    {
        new Menu();   
    }

    public JHome()
    {
        this.setTitle("RePear!");
        //this.setBounds(0,0,400,400);
        //this.setSize(800,600);
        this.setResizable(true);
        this.setLayout(new BorderLayout());

        JPanel pnlPrincipal = new JPanel();
        this.add(pnlPrincipal, BorderLayout.CENTER);
        pnlPrincipal.setLayout(new BorderLayout());

        Font fuente = new Font("Calibri", 3, 15);

        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.setBackground(new Color(127,236,117));

        //ImageIcon img1 = new ImageIcon(imagen1.getScaledInstance(50,30,Image.SCALE_SMOOTH));
        JLabel lblImagen = new JLabel(); 
        lblImagen.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace\\Repear\\pp.jpg"));
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        pnlNorte.add(lblImagen, BorderLayout.CENTER);

        JPanel pnlComponents = new JPanel(new BorderLayout());
        pnlComponents.setOpaque(false);

        JLabel lbl1 = new JLabel("      ");
        JLabel lbl2 = new JLabel("      ");
        JLabel lbl3 = new JLabel("      ");

        pnlComponents.add(lbl1, BorderLayout.NORTH);
        pnlComponents.add(lbl2, BorderLayout.SOUTH);
        pnlComponents.add(lbl3, BorderLayout.EAST);

        JPanel pnlGridComponents = new JPanel(new GridLayout(1,3,15,15));
        pnlGridComponents.setOpaque(false);
        pnlComponents.add(pnlGridComponents, BorderLayout.CENTER);

        comboBuscar = new JComboBox();
        comboBuscar.addItem("TODAS LAS CATEGORIAS                                  ");
        comboBuscar.addItem("CAMPA\u00D1AS Y OFERTAS");
        comboBuscar.addItem("INFORMATICA");
        comboBuscar.addItem("TELEFONIA");
        comboBuscar.addItem("TV Y AUDIO");
        comboBuscar.addItem("FOTOGRAFIA");
        comboBuscar.addItem("HOGAR");
        comboBuscar.addItem("ENTRETENIMIENTO Y DEPORTE");
        comboBuscar.setFont(fuente);
        pnlGridComponents.add(comboBuscar);

        //mapaReservas = IOReserva.leerFichero();

        btnBuscar = new JButton(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace\\Repear\\lupa.png"));
        //btnBuscar.setFont(fuente);
        //button.setForeground(new Color(127,236,117));
        btnBuscar.setBackground(new Color(127,236,117));
        /*btnBuscar.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    Collection reservas = (Collection) mapaReservas.get(comboInstalacion.getSelectedItem().toString());
                    Iterator it = reservas.iterator();
                    int numeroreservas = 0;
                    if (txtUsuario.getText().equals(""))
                    {
                        if(reservas==null)
                            JOptionPane.showMessageDialog(JHome.this, "Esta instalacion no tiene reservas");
                        else
                        {
                            while(it.hasNext())
                            {
                                Reserva reserva = (Reserva) it.next();
                                txtListado.append(comboInstalacion.getSelectedItem().toString() + "\n");
                                txtListado.append(reserva.toString() + "\n");
                            }
                        }
                    }
                    else
                    {
                        while(it.hasNext())
                        {
                            Reserva reserva = (Reserva) it.next();
                            if(reserva.getUsuario().equals(txtUsuario.getText()))
                            {
                                txtListado.append(comboInstalacion.getSelectedItem().toString() + "\n");
                                txtListado.append(reserva.toString() + "\n");
                                numeroreservas += 1;
                            }
                        }
                        if (numeroreservas == 0)
                        JOptionPane.showMessageDialog(JHome.this, "Esta instalacion no tiene reservas a nombre del usuario indicado");
                    }
                }
            });
            */

        pnlGridComponents.add(btnBuscar);

        btnMiCuenta = new JButton("Mi cuenta");
        btnMiCuenta.setFont(fuente);
        pnlGridComponents.add(btnMiCuenta);

        pnlNorte.add(pnlComponents, BorderLayout.EAST);
        pnlNorte.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        pnlPrincipal.add(pnlNorte, BorderLayout.NORTH);

        JPanel pnlOeste = new JPanel(new GridLayout(5,1,0,5));
        pnlOeste.setBackground(Color.WHITE);
        JLabel lblE1 = new JLabel("OFERTAS");
        JLabel lblE2 = new JLabel("SERVICIOS");
        JLabel lblE3 = new JLabel("EMPRESAS");
        JLabel lblE4 = new JLabel("     FORMACIONES     ");
        JLabel lblE5 = new JLabel("CONSEJOS");
        lblE1.setHorizontalAlignment(SwingConstants.CENTER);
        lblE2.setHorizontalAlignment(SwingConstants.CENTER);
        lblE3.setHorizontalAlignment(SwingConstants.CENTER);
        lblE4.setHorizontalAlignment(SwingConstants.CENTER);
        lblE5.setHorizontalAlignment(SwingConstants.CENTER);
        pnlOeste.add(lblE1);
        pnlOeste.add(lblE2);
        pnlOeste.add(lblE3);
        pnlOeste.add(lblE4);
        pnlOeste.add(lblE5);

        pnlOeste.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        pnlPrincipal.add(pnlOeste, BorderLayout.WEST);


        JPanel pnlCentro = new JPanel(new GridLayout(3,1));
        pnlCentro.setBackground(new Color(181,245,175));
        //pnlCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel lblC1 = new JLabel("SAL1");
        JLabel lblC2 = new JLabel("SAL2");
        JLabel lblC3 = new JLabel("SAL3");
        lblC1.setHorizontalAlignment(SwingConstants.CENTER);
        lblC2.setHorizontalAlignment(SwingConstants.CENTER);
        lblC3.setHorizontalAlignment(SwingConstants.CENTER);
        pnlCentro.add(lblC1);
        pnlCentro.add(lblC2);
        pnlCentro.add(lblC3);

        pnlCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        pnlPrincipal.add(pnlCentro, BorderLayout.CENTER);

        //this.add(txtListado, BorderLayout.CENTER);

        JPanel pnlSur = new JPanel(new GridLayout(2,1));
        JLabel lblS1 = new JLabel("\u00BFQUIERES TRABAJAR CON NOSOTROS? ENV\u00CDA TU SOLICITUD A reparaciones@repear.com Y NOS PONDREMOS EN CONTACTO CONTIGO");
        JLabel lblS2 = new JLabel("RePear! 2019 \u00A9 Todos los derechos reservados");
        lblS1.setHorizontalAlignment(SwingConstants.CENTER);
        lblS2.setHorizontalAlignment(SwingConstants.CENTER);
        pnlSur.add(lblS1);
        pnlSur.add(lblS2);
        pnlSur.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnlPrincipal.add(pnlSur,BorderLayout.SOUTH);

        this.setIconImage(logo.getImage());
        //this.setSize(1000,900);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}