public class Dispositivo
{
	String marca;
	String modelo;
	String tipo;
	String estado;
	
	public Dispositivo(String marca, String modelo, String tipo, String estado)
	{
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	public String getMarca()
	{
		return marca;
	}
	
	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
	public String getModelo()
	{
		return modelo;
	}
	
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public String getTipo()
	{
		return tipo;
	}
	
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
	public String getEstado()
	{
		return estado;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
        sb.append("\nMarca: ")
          .append(marca)
          .append("\nModelo: ")
          .append(modelo)
          .append("\ntipo: ")
          .append(tipo)
          .append("\nEstado: ")
          .append(estado)
          .append("\n");
        return sb.toString();
	}
}