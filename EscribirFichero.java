import java.io.*;

public class EscribirFichero 
{
	public static void registra(String correo, String clave)
	{
		try
		{
			File file = new File("C:\\Users\\Nico\\eclipse-workspace\\Repear\\src\\Usuarios.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.newLine();
	        bw.write(correo);
	        bw.write('#');
	        bw.write(clave);
	        bw.close();
	        fw.close();    
	    }
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
