import java.util.Scanner;

public class Menu {
    private ListaPacientes lista;
    private Scanner scanner;

    public Menu() {
        this.lista = new ListaPacientes();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        char opcion;
        do {
            System.out.println(" Menú de la Agenda del Doctor ");
            System.out.println("1️ Agregar paciente");
            System.out.println("2️ Buscar paciente por cédula");
            System.out.println("3️ Atender paciente");
            System.out.println("4️ Eliminar paciente");
            System.out.println("5️ Mostrar lista de pacientes");
            System.out.println("6️ Guardar pacientes en archivo");
            System.out.println("7️ Cargar pacientes desde archivo");
            System.out.println("0️ Salir");
            System.out.print(" Elija una opción: ");
            opcion = scanner.next().charAt(0);
            scanner.nextLine(); // Limpiar el buffer del Scanner

            switch (opcion) {
                case '1' -> agregarPaciente();
                case '2' -> buscarPaciente();
                case '3' -> actualizarPaciente();
                case '4' -> eliminarPaciente();
                case '5' -> lista.mostrarPacientes();
                case '6' -> guardarPacientesEnArchivo();
                case '7' -> cargarPacientesDesdeArchivo();
                case '0' -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != '0');
    }

    private void agregarPaciente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del Scanner
        System.out.print("Enfermedad: ");
        String enfermedad = scanner.nextLine();
        String atendido = "No atendido";
        lista.agregarPaciente(nombre, cedula, edad, enfermedad, atendido);
    }

    private void buscarPaciente() {
        System.out.print("Ingrese la cédula del paciente: ");
        String cedula = scanner.nextLine();
        Paciente paciente = lista.buscarPaciente(cedula);
        if (paciente != null) {
            System.out.println("Paciente encontrado:");
            System.out.println("Nombre: " + paciente.getNombre());
            System.out.println("Cédula: " + paciente.getCedula());
            System.out.println("Edad: " + paciente.getEdad());
            System.out.println("Enfermedad: " + paciente.getEnfermedad());
            System.out.println("Atendido: " + paciente.getAtendido());
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private void actualizarPaciente() {
        System.out.print("Ingrese la cédula del paciente a atender: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese la consulta: ");
        String consulta = scanner.nextLine();
        System.out.print("Ingrese la fecha de la consulta (dd/MM/yyyy): ");
        String fecha = scanner.nextLine();
        lista.actualizarPaciente(cedula, consulta, fecha);
    }

    private void eliminarPaciente() {
        System.out.print("Ingrese la cédula del paciente a eliminar: ");
        String cedula = scanner.nextLine();
        lista.eliminarPaciente(cedula);
    }

    private void guardarPacientesEnArchivo() {
        System.out.print("Ingrese el nombre del archivo para guardar los datos: ");
        String nombreArchivo = scanner.nextLine();
        ManejadorArchivos.guardarPacientes(lista, nombreArchivo);
    }

    private void cargarPacientesDesdeArchivo() {
        System.out.print("Ingrese el nombre del archivo para cargar los datos: ");
        String nombreArchivo = scanner.nextLine();
        lista = ManejadorArchivos.cargarPacientes(nombreArchivo);
    }
}