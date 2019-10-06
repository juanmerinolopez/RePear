package Proyecto.io;

import Proyecto.dominio.Cliente;

import java.util.*;
import java.io.*;

public class IOCliente
{

    public static void exportarClientes2Texto(ArrayList clientes)
    {
        try
        {
            FileWriter fw = new FileWriter("output.html");
            PrintWriter pw = new PrintWriter(fw);

            Iterator it = clientes.iterator();
            while(it.hasNext())
            {
                Cliente c = (Cliente) it.next();
                pw.println(c);
            }
           
            pw.close();
            fw.close();

        }
        catch(IOException ioe)
        {
            javax.swing.JOptionPane.showMessageDialog(null, "No se pudo escribir en el fichero", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void importarClientesFromTexto(ArrayList clientes)
    {
        try
        {
            FileReader fr = new FileReader("Clientes.txt");
            BufferedReader br = new BufferedReader(fr);

            String s = br.readLine();
            while(s!=null)
            {
                System.out.println(s);
                try
                {
                    String datos[] = s.split(" ");
                    String nombre = datos[0];
                    String nif = datos[1];
                    int pin = Integer.parseInt(datos[2]);                   
                    int n_cuenta = Integer.parseInt(datos[3]);
                    float efectivo = Integer.parseInt(datos[4]);

                    clientes.add(new Cliente(nombre,nif,pin,n_cuenta,efectivo));
                }
                catch(NumberFormatException nfe)
                {
                    System.out.println("No se importó este cliente porque uno de los elementos no se  introdujo bien");
                }                

                s = br.readLine();
            }

            System.out.println(clientes);
            br.close();
            fr.close();
           
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el fichero", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos/personas.obj"));
    }

    /*public static void escribirClientes(Collection clientes)
    {
        try
        {
            File fichero = new File("Clientes.obj");
            if(fichero.exists())
                javax.swing.JOptionPane.showMessageDialog(null, "El fichero se sobreescribirá", "Aviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            FileOutputStream fos = new FileOutputStream("Clientes.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Iterator it = personas.iterator();
            while(it.hasNext())
                oos.writeObject(it.next());

            oos.close();
            fos.close();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "No se pudo escribir en el fichero", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos/personas.obj"));
    }
    */

    public static ArrayList leerClientes()
    {
        ArrayList clientes = new ArrayList();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try
        {
            File fichero = new File("Clientes.obj");
            fis = new FileInputStream ("Clientes.obj");
            ois = new ObjectInputStream(fis);
            while(true)
                clientes.add(ois.readObject());
        }
        catch(EOFException eof)
        {
            try
            {
                ois.close();
                fis.close();
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();       
            }
        }
        catch(ClassNotFoundException ioe)
        {
           //ioe.printStackTrace();
           //System.out.println("Clase no encontrada");
            javax.swing.JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }   
        catch(FileNotFoundException fnfe)
        {
           //ioe.printStackTrace();
           //System.out.println("No se encuentra el fichero");
            //javax.swing.JOptionPane.showMessageDialog(null, "No se encuentra el fichero", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ioe)
        {
           //ioe.printStackTrace();
           //System.out.println("Error leyendo del fichero");
        }

        return clientes;
    }
}
