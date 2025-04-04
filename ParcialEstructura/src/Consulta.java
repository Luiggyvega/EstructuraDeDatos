public class Consulta {
    private String consulta;
    private String fecha; // Nuevo campo para la fecha
    private Consulta siguiente;

    public Consulta(String consulta, String fecha) {
        this.consulta = consulta;
        this.fecha = fecha;
        this.siguiente = null;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Consulta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Consulta siguiente) {
        this.siguiente = siguiente;
    }
}