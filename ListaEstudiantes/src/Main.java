import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEstudiantes lista = new ListaEstudiantes();

        System.out.print("¿Cuántos estudiantes desea ingresar? ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante #" + (i + 1));

            System.out.print("Código: ");
            String codigo = scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nota 1: ");
            double nota1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota 2: ");
            double nota2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota 3: ");
            double nota3 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota Final: ");
            double notaFinal = Double.parseDouble(scanner.nextLine());

            System.out.print("Carrera: ");
            String carrera = scanner.nextLine();

            lista.agregarEstudiante(codigo, nombre, nota1, nota2, nota3, notaFinal, carrera);
        }

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar todos los estudiantes");
            System.out.println("2. Mostrar códigos y nota final");
            System.out.println("3. Mostrar estudiantes que NO son de Ingeniería de Sistemas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    lista.imprimirTodos();
                    break;
                case 2:
                    lista.imprimirCodigosYNotaFinal();
                    break;
                case 3:
                    lista.imprimirNoIngenieria();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}