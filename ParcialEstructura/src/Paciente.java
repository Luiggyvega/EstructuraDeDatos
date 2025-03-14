public class Paciente {
    public String nombre;
    public String cedula;
    public int edad;
    public String enfermedad;
    public String atendido;
    public Paciente siguiente;

    public Paciente(String nombre, String cedula, int edad, String enfermedad, String atendido) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.atendido = atendido;
        this.siguiente = null;
    }

}
