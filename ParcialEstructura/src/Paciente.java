public class Paciente {
    private String nombre;
    private String cedula;
    private int edad;
    private String enfermedad;
    private String atendido;
    private Paciente siguiente;
    private Consulta primeraConsulta;

    public Paciente(String nombre, String cedula, int edad, String enfermedad, String atendido) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.atendido = atendido;
        this.siguiente = null;
        this.primeraConsulta = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getAtendido() {
        return atendido;
    }

    public void setAtendido(String atendido) {
        this.atendido = atendido;
    }

    public Paciente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Paciente siguiente) {
        this.siguiente = siguiente;
    }

    public void agregarConsulta(String consulta, String fecha) {
        Consulta nuevaConsulta = new Consulta(consulta, fecha);
        if (primeraConsulta == null) {
            primeraConsulta = nuevaConsulta;
        } else {
            Consulta actual = primeraConsulta;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevaConsulta);
        }
    }

    public String getHistorialConsultas() {
        StringBuilder historial = new StringBuilder();
        Consulta actual = primeraConsulta;
        while (actual != null) {
            historial.append("- Fecha: ").append(actual.getFecha())
                    .append(" | Consulta: ").append(actual.getConsulta())
                    .append("\n");
            actual = actual.getSiguiente();
        }
        return historial.toString();
    }
}