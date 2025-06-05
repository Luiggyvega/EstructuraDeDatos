import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class Lista {
    Nodo cabeza;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
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
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public Lista filtrarMenores(int mm) {
        Lista menores = new Lista();
        Nodo actual = cabeza;
        while (actual != null) {
            if (mm>actual.dato) {
                menores.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return menores;
    }

    public Lista filtrarMayores(int tt) {
        Lista mayores = new Lista();
        Nodo actual = cabeza;
        while (actual != null) {
            if (tt<actual.dato) {
                mayores.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return mayores;
    }
    public Lista buscar(int buscador) {
    Lista encontrado = new Lista();
        Nodo actual = cabeza;
        while (actual != null) {
            if (buscador==actual.dato) {
                encontrado.agregar(actual.dato);
            }
            actual = actual.siguiente;

        }
        return encontrado;
    }
}

public class ListaNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista listaOriginal = new Lista();

        System.out.println("ingrese un numero");
        int num=1;
        while (num!=0){
            num=sc.nextInt();
            listaOriginal.agregar(num);
        }

        System.out.print("Ingresa el número mm : ");
        int mm = sc.nextInt();

        System.out.print("Ingresa el número tt : ");
        int tt = sc.nextInt();

        System.out.println("ingrese el numero a buscar");
        int buscador = sc.nextInt();

        System.out.println("\nLista Original:");
        listaOriginal.mostrar();

        System.out.println("Números menores a " + mm + ":");
        listaOriginal.filtrarMenores(mm).mostrar();

        System.out.println("Números mayores a " + tt + ":");
        listaOriginal.filtrarMayores(tt).mostrar();

        System.out.println("el buscador: ");
        listaOriginal.buscar(buscador).mostrar();

    }
}
