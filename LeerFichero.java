import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class LeerFichero
{
	public static boolean leeUsuarios(String correo, String clave)
	{
		boolean existeUsuario = false;
		try
		{
			FileReader fr = new FileReader("C:\\Users\\Nico\\eclipse-workspace\\Repear\\src\\Usuarios.txt");
			BufferedReader br = new BufferedReader(fr);
			

			String linea = br.readLine();
			while(linea!=null && existeUsuario == false)
			{
				String correoFichero = linea.substring(0, linea.indexOf("#"));
				String claveFichero = linea.substring(linea.indexOf("#")+1, linea.length());
				if(correoFichero.equals(correo) || claveFichero.equals(clave))
					existeUsuario = true;
				linea = br.readLine();
				
			}
			br.close();
			fr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return existeUsuario;
	}

}

