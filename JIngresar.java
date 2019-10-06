package Proyecto.ui;

import Proyecto.dominio.Cliente;
import Proyecto.io.IOCliente;
import Proyecto.util.Util;
import Proyecto.ui.JPage2;
import Proyecto.ui.JMenu;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import java.util.*;

public class JIngresar extends JFrame
{
	private JButton btningresar;
	private JLabel lblingresar;
	private JLabel lbl1;
	private JLabel lbldestinatario;
	private JTextField txtingresar;
	private JTextField txt1;
	private JButton btnvolver;
	private JTextField txtdestinatario;
	
	private static ArrayList clientes;
	private Cliente cliente;

	Util espera = new Util();

	public static void main(String args[])
	{
		new JIngresar();
	}
	public JIngresar()
	{
		cliente = JPage1.exportarCliente();
		clientes = JPage1.exportarLista();

		lblingresar = new JLabel("TRANSFERIR CANTIDAD: ");
		lbl1 = new JLabel();
		txtingresar = new JTextField(20);
		txt1 = new JTextField(100);
		btnvolver = new JButton("VOLVER");
		txtdestinatario = new JTextField(30);
		lbldestinatario = new JLabel("NUMERO CUENTA: ");


		this.setLayout(new BorderLayout());

		JPanel pnl1 = new JPanel(new FlowLayout());
 
		lblingresar.setFont(new Font("Monaco",Font.BOLD,12));
		lblingresar.setForeground(Color.BLACK);
		lblingresar.setBackground(Color.GRAY);
		txtingresar.setVisible(false);

		ImageIcon logo = new ImageIcon("Proyecto/imagenes/earthport.jpeg");

		lbl1.setIcon(logo);
		lbl1.setSize(125,125);
		lbl1.setVisible(true); 

		pnl1.setLayout(null);
		

		lblingresar.setBounds(0,20,160,30);
		lbl1.setBounds(50,50,200,125);
		txtingresar.setBounds(135,25,70,20);
		txt1.setBounds(180,100,166,50);
		btnvolver.setBounds(220,50,60,15);
		txtdestinatario.setBounds(120,180,225,30);
		lbldestinatario.setBounds(0,180,160,30);



		pnl1.add(lblingresar);
		pnl1.add(lbl1);
		pnl1.add(txtingresar);
		pnl1.add(txt1);
		pnl1.add(btnvolver);
		pnl1.add(txtdestinatario);
		pnl1.add(lbldestinatario);

		pnl1.setBackground(Color.RED);

		this.add(pnl1,BorderLayout.CENTER);
		this.setSize(350,350);
		this.setTitle("Transferencias");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		KeyListener ingresar = new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
			}
			public void keyReleased(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					float d = Float.parseFloat(txtingresar.getText());

					for(int i=0;i<clientes.size();i++)
					{
						Cliente cliente = (Cliente)clientes.get(i);

						if(txtdestinatario.getText().equals(cliente.getCuenta()))
						{
							cliente.setEfectivo(cliente.getEfectivo() + d);

							if(d < 0)
							{
								JOptionPane.showMessageDialog(JIngresar.this, "ERROR, CANTIDAD DEBE SER POSITIVA");
							}
							else
							{
								txt1.setText(d+"€ EXITO");
							}
						}
					}
				}
			}
			public void keyTyped(KeyEvent e)
			{
			}
		};
		txtingresar.addKeyListener(ingresar);



		KeyListener transferir = new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
			}
			public void keyReleased(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					int n = Integer.parseInt(txtdestinatario.getText());

					for(int i=0;i<clientes.size();i++)
					{
						Cliente cliente = (Cliente)clientes.get(i);

						if(txtdestinatario.getText().equals(cliente.getCuenta()))
						{
							txtingresar.setVisible(true);
							JOptionPane.showMessageDialog(JIngresar.this, "INSERTAR CANTIDAD A TRANSFERIR");
						}

						else
						{
							JOptionPane.showMessageDialog(JIngresar.this, "ERROR, NO SE ENCUENTRA DESTINATARIO EN EL SISTEMA");
						}
					}
				}
			}
			public void keyTyped(KeyEvent e)
			{
			}
		};
		txtdestinatario.addKeyListener(transferir);



		ActionListener volver = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				espera.wait(2);
				dispose();
				new JMenu();
			}
		};
		btnvolver.addActionListener(volver);
	}
}