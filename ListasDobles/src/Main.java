import java.util.Scanner;

class Nodo {
    int dato;
    Nodo prev, next;

    public Nodo(int dato) {
        this.dato = dato;
        this.prev = this.next = null;
    }
}

class ListaDoble {
    Nodo cabeza, cola;
    ListaDoble eliminados;

    // Constructor
    public ListaDoble() {
        this.cabeza = this.cola = null;
        this.eliminados = null; // Evitamos la recursión infinita
    }

    // Insertar al final
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.next = nuevo;
            nuevo.prev = cola;
            cola = nuevo;
        }
    }

    public void eliminarElemento(int valor) {
        Nodo actual = cabeza;

        while (actual != null && actual.dato != valor) {
            actual = actual.next;
        }

        if (actual == null) {
            System.out.println("El número no está en la lista.");
            return;
        }

        // Creamos la lista de eliminados solo cuando eliminamos el primer elemento
        if (eliminados == null) {
            eliminados = new ListaDoble();
        }
        eliminados.insertarAlFinal(actual.dato); // Guardamos el número eliminado

        // Si es el único elemento
        if (actual == cabeza && actual == cola) {
            cabeza = cola = null;
        }
        // Si es el primer elemento
        else if (actual == cabeza) {
            cabeza = actual.next;
            if (cabeza != null) cabeza.prev = null;
        }
        // Si es el último elemento
        else if (actual == cola) {
            cola = actual.prev;
            cola.next = null;
        }
        // Si está en el medio
        else {
            actual.prev.next = actual.next;
            actual.next.prev = actual.prev;
        }

        System.out.println("Número eliminado y almacenado: " + valor);
    }

    public void mostrarDesdeInicio() {
        Nodo actual = cabeza;
        System.out.println("\nLista actual:");
        while (actual != null) {
            System.out.print(actual.dato + " ⇄ ");
            actual = actual.next;
        }
        System.out.println("null");
    }

    // Mostrar la lista de eliminados
    public void mostrarEliminados() {
        if (eliminados == null || eliminados.cabeza == null) {
            System.out.println("\nNo hay números eliminados.");
            return;
        }

        Nodo actual = eliminados.cabeza;
        System.out.println("\nLista de eliminados:");
        while (actual != null) {
            System.out.print(actual.dato + " ⇄ ");
            actual = actual.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();

        System.out.println("Ingrese números para almacenar en la lista (ingrese -1 para salir):");

        while (true) {
            System.out.print("Número: ");
            int num = scanner.nextInt();
            if (num == -1) {
                break;
            }
            lista.insertarAlFinal(num);
        }

        lista.mostrarDesdeInicio();

        while (true) {
            System.out.print("\nIngrese el número a eliminar (-1 para salir): ");
            int eliminar = scanner.nextInt();
            if (eliminar == -1) {
                break;
            }
            lista.eliminarElemento(eliminar);
            lista.mostrarDesdeInicio();
        }

        lista.mostrarEliminados();
    }
}


