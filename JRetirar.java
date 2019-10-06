package Proyecto.ui;

import Proyecto.dominio.Cliente;
import Proyecto.io.IOCliente;
import Proyecto.util.Util;
import Proyecto.ui.JPage2;
import Proyecto.ui.JMenu;
import Proyecto.ui.JPage1;


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

public class JRetirar extends JFrame
{
	private JButton btnveinte;
	private JButton btncincuenta;
	private JButton btncien;
	private JButton btndoscientos;
	private JButton btnquinientos;
	private JLabel lblOpc;
	private JTextField txtInfo;
	private JButton btnvolver;
	private JLabel lbl1;

	private Cliente cliente;

	Util espera = new Util();

	public static void main(String args[])
	{
		new JRetirar();
	}
	public JRetirar()
	{
		cliente = JPage1.exportarCliente();

		btnveinte = new JButton("20");
		btncincuenta = new JButton("50");
		btncien = new JButton("100");
		btndoscientos = new JButton("200");
		btnquinientos = new JButton("500");
		lblOpc = new JLabel("ESCOGER UNA OPCION DE RETIRADA:");
		txtInfo = new JTextField(75);
		btnvolver = new JButton("VOLVER");
		lbl1 = new JLabel();

		this.setLayout(new BorderLayout());

		JPanel pnl1 = new JPanel(new FlowLayout());
		JPanel pnl2 = new JPanel(new FlowLayout());
		JPanel pnl3 = new JPanel(new FlowLayout());
 
		btnveinte.setFont(new Font("Monaco",Font.BOLD,12));
		btnveinte.setForeground(Color.BLACK);
		btnveinte.setBackground(Color.GRAY);
		btncincuenta.setFont(new Font("Monaco",Font.BOLD,12));
		btncincuenta.setForeground(Color.BLACK);
		btncincuenta.setBackground(Color.GRAY);
		btncien.setFont(new Font("Monaco",Font.BOLD,12));
		btncien.setForeground(Color.BLACK);
		btncien.setBackground(Color.GRAY);
		btndoscientos.setFont(new Font("Monaco",Font.BOLD,12));
		btndoscientos.setForeground(Color.BLACK);
		btndoscientos.setBackground(Color.GRAY);
		btnquinientos.setFont(new Font("Monaco",Font.BOLD,12));
		btnquinientos.setForeground(Color.BLACK);
		btnquinientos.setBackground(Color.GRAY);
		lblOpc.setFont(new Font("Monaco",Font.BOLD,11));
		lblOpc.setForeground(Color.BLACK);


		lbl1.setSize(250,250);
		lbl1.setVisible(true); 

		pnl1.setLayout(null);
		pnl2.setLayout(null);
		pnl3.setLayout(null);

		btnveinte.setBounds(-5,75,120,50);
		btncincuenta.setBounds(-5,150,120,50);
		btncien.setBounds(220,75,150,40);
		btndoscientos.setBounds(220,118,150,40);
		btnquinientos.setBounds(220,160,150,40);
		txtInfo.setBounds(50,250,250,75);
		btnvolver.setBounds(50,225,60,15);

		lbl1.setBounds(120,100,79,100);

		lblOpc.setBounds(68,20,250,20);

		pnl1.add(btnveinte);
		pnl1.add(btncincuenta);
		pnl1.add(btncien);
		pnl1.add(btndoscientos);
		pnl1.add(btnquinientos);
		pnl1.add(lblOpc);
		pnl1.add(txtInfo);
		pnl1.add(btnvolver);
		pnl1.add(lbl1);

		pnl1.setBackground(Color.RED);

		this.add(pnl1,BorderLayout.CENTER);
		this.add(pnl2,BorderLayout.SOUTH);


		this.setSize(350,350);
		this.setTitle("Retirar");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

        
		ActionListener cincuenta = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cliente.setEfectivo(cliente.getEfectivo() - 50);
				txtInfo.setText("50€ EXITO");
	
			}
		};

		btncincuenta.addActionListener(cincuenta);	

		ActionListener cien = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cliente.setEfectivo(cliente.getEfectivo() - 100);
				txtInfo.setText("100€ EXITO");
			}
		};
		btncien.addActionListener(cien);

		ActionListener doscientos = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cliente.setEfectivo(cliente.getEfectivo() - 200);
				txtInfo.setText("200€ EXITO");
			}
		};
		btndoscientos.addActionListener(doscientos);

		ActionListener quinientos = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cliente.setEfectivo(cliente.getEfectivo() - 500);
				txtInfo.setText("500€ EXITO");
			}
		};
		btnquinientos.addActionListener(quinientos);

		ActionListener veinte = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cliente.setEfectivo(cliente.getEfectivo() - 20);
				txtInfo.setText("20€ EXITO");
			}
		};
		btnveinte.addActionListener(veinte);

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
