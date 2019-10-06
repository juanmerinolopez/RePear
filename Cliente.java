package Proyecto.dominio;

public class Cliente implements java.io.Serializable
{ 
    private String nif;
    private String nombre;
    private int pin;
    private int n_cuenta;
    private float efectivo;
    
    public Cliente(String nombre,String nif,int pin,int n_cuenta,float efectivo) 
    {
        this.nombre = nombre;
        this.nif = nif;
        this.pin = pin;
        this.n_cuenta = n_cuenta;
        this.efectivo = efectivo;
    }
    
    public String getNif()
    {
        return nif;
    }

    public void setNif(String nif)
    {
        this.nif = nif;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getPin()
    {
        return pin;
    }

    public void setPin(int pin)
    {
        this.pin = pin;
    }

    public float getEfectivo()
    {
        return efectivo;
    }

    public void setEfectivo(float efectivo)
    {
        this.efectivo = efectivo;
    }

    public int getCuenta()
    {
        return n_cuenta;
    }

    public void setCuenta(int n_cuenta)
    {
        this.n_cuenta = n_cuenta;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ")
          .append(nombre)
          .append("NIF: ")
          .append(nif)
          .append("Pin: ")
          .append(pin)
          .append("Numero de Cuenta: ")
          .append(n_cuenta)
          .append("Efectivo Disponible: ")
          .append(efectivo);
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) //Upcasting, el objeto que recibe lo vemos como un Objeto
    {
        if(obj instanceof Cliente) //Si la instancia del objeto es una Persona...
        {
            Cliente c = (Cliente) obj; //Hacemos un downcasting (explícito) y bajamos el inyerfaz
            if (nif.equals(c.getNif())) //Llama al equals de String, que funciona correctamente
                return true;
            else
                return false;
        }
        else
            return false;
    }
}