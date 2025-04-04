public class ListaPacientes {
    private Paciente cabeza;

    public ListaPacientes() {
        this.cabeza = null;
    }

    public void agregarPaciente(String nombre, String cedula, int edad, String enfermedad, String atendido) {
        Paciente nuevo = new Paciente(nombre, cedula, edad, enfermedad, atendido);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Paciente actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        System.out.println("Paciente agregado con éxito.");
    }

    public Paciente buscarPaciente(String cedula) {
        Paciente actual = cabeza;
        while (actual != null) {
            if (actual.getCedula().equals(cedula)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminarPaciente(String cedula) {
        if (cabeza == null) return false;

        if (cabeza.getCedula().equals(cedula)) {
            cabeza = cabeza.getSiguiente();
            System.out.println("Paciente eliminado con éxito.");
            return true;
        }

        Paciente actual = cabeza;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getCedula().equals(cedula)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
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
            System.out.println("Nombre: " + actual.getNombre() +
                    " | Cédula: " + actual.getCedula() +
                    " | Edad: " + actual.getEdad() +
                    " | Enfermedad: " + actual.getEnfermedad() +
                    " | Atendido: " + actual.getAtendido());

            // Mostrar el historial de consultas
            String historial = actual.getHistorialConsultas();
            if (!historial.isEmpty()) {
                System.out.println("Historial de consultas:");
                System.out.println(historial);
            } else {
                System.out.println("No hay consultas registradas.");
            }
            System.out.println("-----------------------------");
            actual = actual.getSiguiente();
        }
    }

    public void actualizarPaciente(String cedula, String consulta, String fecha) {
        Paciente paciente = buscarPaciente(cedula);
        String atendido = "Atendido";
        if (paciente != null) {
            paciente.setAtendido(atendido); // Actualiza el estado del paciente
            paciente.agregarConsulta(consulta, fecha); // Agrega la consulta con fecha al historial
            System.out.println("Se atendió al paciente: " + paciente.getNombre());
            System.out.println("Consulta agregada al historial.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }
    public Paciente getCabeza() {
        return cabeza;
    }
}