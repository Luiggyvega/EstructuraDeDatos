import java.util.Scanner;

public class lista {
    Scanner sc = new Scanner(System.in);
    nodo primero;
    public lista() {
        primero = null;
    }

    public static class nodo{
        int dato;
        nodo sig;
    }

    public void ingresarDato(int dato) {
        nodo nuevo = new nodo();
        nuevo.dato = dato;
        nuevo.sig = primero;
        primero = nuevo;
    }

    public void desplegar() {
        nodo actual = new nodo();
        actual = primero;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.sig;
        }
    }
    public void buscar() {
        System.out.print("Qué número desea buscar ");
        int buscador = sc.nextInt();

        nodo actual = primero;
        int posicion = 1;
        boolean encontrado = false;

        while (actual != null) {
            if (actual.dato == buscador) {
                System.out.println("Se encontró el número " + buscador + " en la posición " + posicion);
                encontrado = true;
            }
            actual = actual.sig;
            posicion++;
        }

        if (!encontrado) {
            System.out.println("El número " + buscador + " no está en la lista.");
        }
    }
    public void modificar() {
        System.out.print("Ingrese el número que desea modificar: ");
        int buscador = sc.nextInt();

        nodo actual = primero;
        boolean encontrado = false;

        while (actual != null) {
            if (actual.dato == buscador) {
                System.out.print("Ingrese el nuevo valor: ");
                actual.dato = sc.nextInt();
                System.out.println("Número modificado con éxito.");
                encontrado = true;
            }
            actual = actual.sig;
        }

        if (!encontrado) {
            System.out.println("El número " + buscador + " no está en la lista.");
        }
    }



}
