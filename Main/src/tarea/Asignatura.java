package tarea;

public class Asignatura
  {
    private String nombre;
    private int codigo;
    private int nota;
    
    public Asignatura(String nombre, int codigo)
    {
      this.nombre = nombre;
      this.codigo = codigo;
      this.nota = 0;
    }

	public void setNombre(String nombre)
    {
      this.nombre = nombre;
    }
    
    public void setCodigo(int codigo)
    {
      this.codigo = codigo;
    }

    public void setNota(int nota)
    {
      this.nota = nota;
    }

    String getNombre()
    {
      return nombre;
    }

    int getCodigo()
    {
      return codigo;
    }

    int getNota()
    {
      return nota;
    }
    
    public void mostrarAsignatura() {
    	System.out.println(" ---------- " + nombre + " ----------\n"
    			+ "Código: " + codigo + "\n"
    					+ "Nota: " + nota + " \n---------- ");
    }
  }
