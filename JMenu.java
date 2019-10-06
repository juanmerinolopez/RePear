package Proyecto.ui;

import Proyecto.dominio.Cliente;
import Proyecto.io.IOCliente;
import Proyecto.util.Util;
import Proyecto.ui.JPage2;
import Proyecto.ui.JPage1;
import Proyecto.ui.JRetirar;
import Proyecto.ui.JIngresar;
import Proyecto.ui.JPin;


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

public class JMenu extends JFrame
{
	private JButton btnSacar;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JButton btnFactura;
	private JButton btnPin;
	private JLabel lblBienvenida;
	private JTextField txtInfo;
	private JLabel lblWarning;


	private Cliente cliente;

	Util espera = new Util();

	public static void main(String args[])
	{
		new JMenu();
	}
	public JMenu()
	{
		cliente = JPage1.exportarCliente();

		btnSacar = new JButton("RETIRAR DINERO CUENTA");
		btnIngresar = new JButton("TRANSFERIR DINERO");
		btnFactura = new JButton("COMPROBAR SALDO");
		btnSalir = new JButton("SALIR");
		btnPin = new JButton("CAMBIAR CLAVE");
		lblBienvenida = new JLabel("BIENVENIDO,SEÑOR/SEÑORA:" + cliente.getNombre());
		lblWarning = new JLabel("POR FAVOR,CUIDE DE SU PRIVACIDAD");
		txtInfo = new JTextField(75);


		this.setLayout(new BorderLayout());

		JPanel pnl1 = new JPanel(new FlowLayout());
		JPanel pnl2 = new JPanel(new FlowLayout());
		JPanel pnl3 = new JPanel(new FlowLayout());
 
		btnSacar.setFont(new Font("Monaco",Font.BOLD,12));
		btnSacar.setForeground(Color.BLACK);
		btnSacar.setBackground(Color.GRAY);
		btnIngresar.setFont(new Font("Monaco",Font.BOLD,12));
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setBackground(Color.GRAY);
		btnSalir.setFont(new Font("Monaco",Font.BOLD,12));
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setBackground(Color.GRAY);
		btnFactura.setFont(new Font("Monaco",Font.BOLD,12));
		btnFactura.setForeground(Color.BLACK);
		btnFactura.setBackground(Color.GRAY);
		btnPin.setFont(new Font("Monaco",Font.BOLD,12));
		btnPin.setForeground(Color.BLACK);
		btnPin.setBackground(Color.GRAY);
		lblBienvenida.setFont(new Font("Monaco",Font.BOLD,11));
		lblBienvenida.setForeground(Color.BLACK);
		lblWarning.setFont(new Font("Monaco",Font.BOLD,11));
		lblWarning.setForeground(Color.BLACK);

		pnl1.setLayout(null);
		pnl2.setLayout(null);
		pnl3.setLayout(null);

		btnSacar.setBounds(-5,75,160,50);
		btnIngresar.setBounds(-5,150,160,50);
		btnSalir.setBounds(220,75,150,40);
		btnFactura.setBounds(220,118,150,40);
		btnPin.setBounds(220,160,150,40);
		txtInfo.setBounds(68,250,210,70);

		lblBienvenida.setBounds(68,20,250,20);
		lblWarning.setBounds(63,197,350,40);

		pnl1.add(lblBienvenida);
		pnl1.add(btnSacar);
		pnl1.add(btnIngresar);
		pnl1.add(btnSalir);
		pnl1.add(btnFactura);
		pnl1.add(btnPin);
		pnl1.add(txtInfo);
		pnl1.add(lblWarning);

		pnl1.setBackground(Color.RED);

		this.add(pnl1,BorderLayout.CENTER);
		this.add(pnl2,BorderLayout.SOUTH);


		this.setSize(350,350);
		this.setTitle("Menu");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

        
		ActionListener sacar = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new JRetirar();
			}
		};
		btnSacar.addActionListener(sacar);	

		ActionListener ingresar = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new JIngresar();
			}
		};
		btnIngresar.addActionListener(ingresar);

		ActionListener consultar = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				txtInfo.setText("Saldo disponible: " + cliente.getEfectivo() + " € ");
			}
		};
		btnFactura.addActionListener(consultar);

		ActionListener salir = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new JPage1();
			}
		};
		btnSalir.addActionListener(salir);

		ActionListener pinnuevo = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new JPin();
			}
		};
		btnPin.addActionListener(pinnuevo);
	}
}
