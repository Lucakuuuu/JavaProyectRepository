package tarea;

public class Asignatura 
{
	private String nombre;
    private int algo;
    private int nota;
    
    public Asignatura(String nombre, int algo, int nota)
    {
      this.nombre = nombre;
      this.algo = algo;
      this.nota = nota;
    }

    public void setNombre(String nombre)
    {
      this.nombre = nombre;
    }
    
    public void setAlgo(int algo)
    {
      this.algo = algo;
    }

    public void setNota(int nota)
    {
      this.nota = nota;
    }

    String getNombre()
    {
      return nombre;
    }

    int getAlgo()
    {
      return algo;
    }

    int getNota()
    {
      return nota;
    }
}
