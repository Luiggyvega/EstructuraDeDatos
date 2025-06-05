import java.util.ArrayList;
import java.util.Scanner;

class Paciente {
    String nombre;
    int edad;
    ArrayList<String> historial;

    public Paciente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.historial = new ArrayList<>();
    }

    public void agregarConsulta(String diagnostico) {
        historial.add(diagnostico);
    }

    public void mostrarHistorial() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Historial de Consultas:");
        if (historial.isEmpty()) {
            System.out.println("No hay consultas aún.");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
        System.out.println("-------------------------");
    }
}

class Nodo {
    Paciente paciente;
    Nodo izquierdo, derecho;

    public Nodo(Paciente paciente) {
        this.paciente = paciente;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class Agenda {
    Nodo raiz;

    public void registrarPaciente(Paciente nuevo) {
        raiz = insertar(raiz, nuevo);
    }

    private Nodo insertar(Nodo actual, Paciente nuevo) {
        if (actual == null) {
            return new Nodo(nuevo);
        }

        if (nuevo.nombre.compareToIgnoreCase(actual.paciente.nombre) < 0) {
            actual.izquierdo = insertar(actual.izquierdo, nuevo);
        } else if (nuevo.nombre.compareToIgnoreCase(actual.paciente.nombre) > 0) {
            actual.derecho = insertar(actual.derecho, nuevo);
        }

        return actual;
    }

    public Paciente buscarPaciente(String nombre) {
        return buscar(raiz, nombre);
    }

    private Paciente buscar(Nodo actual, String nombre) {
        if (actual == null) return null;

        if (nombre.equalsIgnoreCase(actual.paciente.nombre)) {
            return actual.paciente;
        } else if (nombre.compareToIgnoreCase(actual.paciente.nombre) < 0) {
            return buscar(actual.izquierdo, nombre);
        } else {
            return buscar(actual.derecho, nombre);
        }
    }

    public void mostrarTodos() {
        inOrden(raiz);
    }

    private void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            nodo.paciente.mostrarHistorial();
            inOrden(nodo.derecho);
        }
    }
}

class AgendaMedica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion;
        do {
            System.out.println("\n--- AGENDA DEL DOCTOR ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Consultar paciente (añadir diagnóstico)");
            System.out.println("3. Ver historial de un paciente");
            System.out.println("4. Mostrar todos los pacientes");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    Paciente nuevo = new Paciente(nombre, edad);
                    agenda.registrarPaciente(nuevo);
                    System.out.println("Paciente registrado.");
                    break;

                case 2:
                    System.out.print("Nombre del paciente: ");
                    String nombreConsulta = sc.nextLine();
                    Paciente pConsulta = agenda.buscarPaciente(nombreConsulta);
                    if (pConsulta != null) {
                        System.out.print("Escribe el diagnóstico: ");
                        String diagnostico = sc.nextLine();
                        pConsulta.agregarConsulta(diagnostico);
                        System.out.println("Consulta guardada.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del paciente: ");
                    String nombreHist = sc.nextLine();
                    Paciente pHist = agenda.buscarPaciente(nombreHist);
                    if (pHist != null) {
                        pHist.mostrarHistorial();
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Todos los pacientes ---");
                    agenda.mostrarTodos();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }
}
