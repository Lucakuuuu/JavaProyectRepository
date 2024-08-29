package tarea;

public class Pregunta 
{
	private String pregunta;
	private boolean opcionA;
	private boolean opcionB;
	private boolean opcionC;
	private boolean opcionD;
	
	public Pregunta(String pregunta, boolean opcionA, boolean opcionB, boolean opcionC, boolean opcionD)
	{
		this.pregunta = pregunta;
		this.opcionA = opcionA;
		this.opcionB = opcionB;
		this.opcionC = opcionC;
		this.opcionD = opcionD;
	}
	
	public void setPregunta(String pregunta)
	{
		this.pregunta = pregunta;
	}
	public void setOpcionA(boolean opcionA)
	{
		this.opcionA = opcionA;
	}
	public void setOpcionB(boolean opcionB)
	{
		this.opcionB = opcionB;
	}
	public void setOpcionC(boolean opcionC)
	{
		this.opcionC = opcionC;
	}
	public void setOpcionD(boolean opcionD)
	{
		this.opcionD = opcionD;
	}
	public String getPregunta()
	{
		return pregunta;
	}
	public boolean getOpcionA()
	{
		return opcionA;
	}
	public boolean getOpcionB()
	{
		return opcionB;
	}
	public boolean getOpcionC()
	{
		return opcionC;
	}
	public boolean getOpcionD()
	{
		return opcionD;
	}
}