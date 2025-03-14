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
            System.out.println("3️ paciente que va a atender");
            System.out.println("4️ Eliminar paciente");
            System.out.println("5️ Mostrar lista de pacientes");
            System.out.println("0️ Salir");
            System.out.print(" Elija una opción: ");
            opcion = scanner.next().charAt(0);
            switch (opcion) {
                case '1'->agregarPaciente();
                case '2'-> buscarPaciente();
                case '3'-> actualizarPaciente();
                case '4'-> eliminarPaciente();
                case '5'-> lista.mostrarPacientes();
                default-> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private void agregarPaciente() {
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        if (lista.equals(new ListaPacientes())) {}
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enfermedad: ");
        String enfermedad = scanner.nextLine();
        String atendido = "no atendido";
        lista.agregarPaciente(nombre, cedula, edad, enfermedad, atendido);
    }

    private void buscarPaciente() {
        scanner.nextLine();
        System.out.print("Ingrese la cédula del paciente: ");
        String cedula = scanner.nextLine();
        var paciente = lista.buscarPaciente(cedula);
        if (paciente != null) {
            System.out.println("Paciente encontrado:");
            System.out.println("Nombre: " + paciente.nombre);
            System.out.println("Edad: " + paciente.edad);
            System.out.println("Enfermedad: " + paciente.enfermedad);
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private void actualizarPaciente() {
        scanner.nextLine();
        System.out.print(" Ingrese la cédula del paciente a atender: ");
        String cedula = scanner.nextLine();
        String consulta= "";
        if (lista.buscarPaciente(cedula) != null) {
            System.out.println("cual es la consulta para el paciente");
            consulta = scanner.nextLine();
        }
        lista.actualizarPaciente(cedula,consulta);
    }
    private void eliminarPaciente() {
        scanner.nextLine();
        System.out.print("🗑️ Ingrese la cédula del paciente a eliminar: ");
        String cedula = scanner.nextLine();
        lista.eliminarPaciente(cedula);
    }
}