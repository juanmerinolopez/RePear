import java.util.*;

public class Usuario
{
	String nombre;
	String correo;
	float saldo;
	List dispositivos = new ArrayList();
	
	public Usuario(String nombre, String correo)
	{
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public void nuevoDispositivo(Dispositivo dispositivo)
	{
		dispositivos.add(dispositivo);
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getNombre()
	{
		return nombre;
	}
	
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}
	public String getCorreo()
	{
		return correo;
	}
	
	public void cargarSaldo(float saldo)
	{
		this.saldo = saldo;
	}
	public String getSaldo()
	{
		return saldo;
	}
	
	public String mostrar()
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<dispositivos.size(); i++)
        {
            sb.append(dispositivos.get(i));
        }
        return sb.toString();
    }
}