import java.util.Scanner;

class Estudiante {
    String nombre;
    int edad;
    double nota1, nota2, nota3, nota4, definitiva;

    public Estudiante(String nombre, int edad, double nota1, double nota2, double nota3, double nota4) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.definitiva = 0;
    }
}
class Nodo {
    Estudiante estudiante;
    Nodo siguiente;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
}
class Lista{
    Nodo cabeza;

    public void agregar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    public void mostrar() {
        Nodo actual = cabeza;
        if (cabeza == null) {
            System.out.println("Lista vacia");
        }
        while (actual != null) {
            Estudiante e = actual.estudiante;
            System.out.println("Nombre: " + e.nombre + ", Edad: " + e.edad + ", Notas: " +
                    e.nota1 + ", " + e.nota2 + ", " + e.nota3 + ", " + e.nota4);
            if (e.definitiva == 0 ){
                System.out.println("aun no se ha sacado la definitiva de este estudiante");
            }
            else {
                System.out.println("la definitiva de estudiante es " + e.definitiva);
            }
            actual = actual.siguiente;
        }
    }
    public Lista definitiva() {
        Nodo actual = cabeza;
        while (actual != null) {
            Estudiante estudiante = actual.estudiante;
            double nota1 = estudiante.nota1 * 0.23;
            double nota2 = estudiante.nota2 * 0.23;
            double nota3 = estudiante.nota3 * 0.23;
            double nota4 = estudiante.nota4 * 0.31;
            double total = nota1 + nota2 + nota3 + nota4;
            estudiante.definitiva=total;
            actual = actual.siguiente;
        }
        return null;
    }
    public Lista aprobados(){
        Lista aprobados = new Lista();
        Nodo actual = cabeza;
        double aprobado = 3.0;
        while (actual != null) {
            Estudiante estudiante = actual.estudiante;
            if (estudiante.definitiva >=aprobado){
                aprobados.agregar(estudiante);
                System.out.println("el estudiante: "  + estudiante.nombre + " aprobo la materia con una definitiva de: " + estudiante.definitiva);
            }
            actual = actual.siguiente;
        }
        return aprobados;
    }
}

public class Main {
    static Lista lista = new Lista();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char opcion;
        do {
            System.out.println("\nIngresar opción:");
            System.out.println("1. Agregar");
            System.out.println("2. Mostrar");
            System.out.println("3. calcular definitivas");
            System.out.println("4. mostrar aprobados");
            System.out.println("0. Salir");
            opcion = sc.next().charAt(0);

            switch (opcion) {
                case '1' -> RegistrarEstudiante();
                case '2' -> lista.mostrar();
                case '3' -> lista.definitiva();
                case '4' -> lista.aprobados();
//                case '4' ->Aprobados();
                case '0' -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != '0');
    }

//    private static void Aprobados() {
//        lista.aprobados().mostrar();
//    }


    public static void RegistrarEstudiante() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar Nombre:");
        String nombre = sc.next();
        System.out.println("Ingresar Edad:");
        int edad = sc.nextInt();
        System.out.println("Ingresar Nota 1:");
        double nota1 = sc.nextDouble();
        System.out.println("Ingresar Nota 2:");
        double nota2 = sc.nextDouble();
        System.out.println("Ingresar Nota 3:");
        double nota3 = sc.nextDouble();
        System.out.println("Ingresar Nota 4:");
        double nota4 = sc.nextDouble();
        Estudiante e = new Estudiante(nombre, edad, nota1, nota2, nota3, nota4);
        lista.agregar(e);
    }
}