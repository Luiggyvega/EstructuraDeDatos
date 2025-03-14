public class ListaPacientes {
    private Paciente cabeza;

    public ListaPacientes() {
        this.cabeza = null;
    }

    public void agregarPaciente(String nombre, String cedula, int edad, String enfermedad,String atendido) {
        Paciente nuevo = new Paciente(nombre, cedula, edad, enfermedad,atendido);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Paciente actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        System.out.println("Paciente agregado con éxito.");
    }

    public Paciente buscarPaciente(String cedula) {
        Paciente actual = cabeza;
        while (actual != null) {
            if (actual.cedula.equals(cedula)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }
    public boolean eliminarPaciente(String cedula) {
        if (cabeza == null) return false;

        if (cabeza.cedula.equals(cedula)) {
            cabeza = cabeza.siguiente;
            System.out.println("Paciente eliminado con éxito.");
            return true;
        }

        Paciente actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.cedula.equals(cedula)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("Paciente eliminado con éxito.");
            return true;
        }

        System.out.println("Paciente no encontrado.");
        return false;
    }

    public void mostrarPacientes() {
        if (cabeza == null) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        System.out.println("Lista de pacientes:");
        Paciente actual = cabeza;
        while (actual != null) {

            System.out.println("Nombre: " + actual.nombre +
                    " | Cédula: " + actual.cedula +
                    " | Edad: " + actual.edad +
                    " | Enfermedad: " + actual.enfermedad +
                    " | Atendido: " + actual.atendido);
            actual = actual.siguiente;
        }
    }

    public void actualizarPaciente(String cedula, String consulta) {
        if (cabeza.cedula.equals(cedula)) {
            System.out.println("se atendio al paciente" + cabeza.nombre);
            cabeza.atendido = consulta;
        }
        else System.out.println("Paciente no existe.");
    }
}