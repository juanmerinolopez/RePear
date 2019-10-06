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

public class JPin extends JFrame
{
	private JLabel lblBienvenida;
	private JLabel lblPin;
	private JLabel lblInferior;
	private JLabel lbl1;
	private JPasswordField txtPin;
	private int pin;

	private Cliente cliente;

	Util espera = new Util();

	public static void main(String args[])
	{
		new JPage2();
	}
	public JPin()
	{
		cliente = JPage1.exportarCliente();

		JLabel lblBienvenida = new JLabel("PASSWORD/MOT DE PASSE/PASSWORT\n");
		JLabel lblInferior = new JLabel("**El mejor sistema de pagos de 2019**");
		JLabel lblPin = new JLabel("INTRODUCIR CLAVE NUEVA");
		JPasswordField txtPin = new JPasswordField(5);
		JLabel lbl1 = new JLabel();

		this.setLayout(new BorderLayout());

		JPanel pnlSuperior = new JPanel(new FlowLayout());
		JPanel pnlCentral = new JPanel(new FlowLayout());
		JPanel pnlInferior = new JPanel(new FlowLayout());
		JPanel pnlCentralSur = new JPanel(new FlowLayout());

		ImageIcon fondo = new ImageIcon("Proyecto/imagenes/repear.png");

		lbl1.setIcon(fondo);
		lbl1.setSize(500,500);
		lbl1.setVisible(true); 
		lblBienvenida.setFont(new Font("Monaco",Font.BOLD,12));
		lblBienvenida.setForeground(Color.BLACK);
		lblPin.setFont(new Font("Monaco",Font.BOLD,15));
		lblPin.setForeground(Color.BLACK);
		lblInferior.setFont(new Font("Monaco",Font.BOLD,12));
		lblInferior.setForeground(Color.BLACK);

		pnlSuperior.add(lblBienvenida);
		pnlSuperior.setBackground(Color.WHITE);

		pnlCentral.add(lblPin);
		pnlCentral.add(txtPin);
		pnlCentral.add(lbl1);
		pnlCentral.setBackground(Color.WHITE);

		pnlInferior.add(lblInferior);
		pnlInferior.setBackground(Color.WHITE);

		this.add(pnlSuperior,BorderLayout.NORTH);
		this.add(pnlCentral,BorderLayout.CENTER);
		this.add(pnlInferior,BorderLayout.SOUTH);

		this.setSize(350,350);
		this.setTitle("Cambio Pin");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		KeyListener enterpin = new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
			}
			public void keyReleased(KeyEvent e)
			{
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{		
						pin = Integer.parseInt(txtPin.getText());
						cliente.setPin(pin);
						espera.wait(2);
						dispose();
						new JMenu();
					}
			}
			public void keyTyped(KeyEvent e)
			{
			}
		};
		txtPin.addKeyListener(enterpin);
	}
}
