package tarea;

public class Pregunta {
    private String enunciado;
    private String[] respuestas;
    private String respuestaCorrecta;

    public Pregunta(String enunciado, String[] respuestas, String respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

	public String getEnunciado() {
        return enunciado;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public boolean esCorrecta(String respuestaUsuario) {
        return respuestaUsuario.equals(respuestaCorrecta);
    }
}
