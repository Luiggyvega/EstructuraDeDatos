import java.util.Scanner;

class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        }
        if (dato < raiz.dato) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        } else if (dato > raiz.dato) {
            raiz.derecho = insertarRec(raiz.derecho, dato);
        }
        return raiz;
    }

    public void mostrarInOrden() {
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.derecho);
        }
    }

    public void mostrarMenores(int valor) {
        mostrarMenoresRec(raiz, valor);
        System.out.println();
    }

    private void mostrarMenoresRec(Nodo nodo, int valor) {
        if (nodo != null) {
            mostrarMenoresRec(nodo.izquierdo, valor);
            if (nodo.dato < valor) {
                System.out.print(nodo.dato + " ");
                mostrarMenoresRec(nodo.derecho, valor);
            }
        }
    }

    public void mostrarMayores(int valor) {
        mostrarMayoresRec(raiz, valor);
        System.out.println();
    }

    private void mostrarMayoresRec(Nodo nodo, int valor) {
        if (nodo != null) {
            if (nodo.dato > valor) {
                mostrarMayoresRec(nodo.izquierdo, valor);
                System.out.print(nodo.dato + " ");
            }
            mostrarMayoresRec(nodo.derecho, valor);
        }
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.dato) return true;
        return valor < nodo.dato ? buscarRec(nodo.izquierdo, valor) : buscarRec(nodo.derecho, valor);
    }
}

class ArbolNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("Ingrese números (0 para terminar):");
        int num;
        do {
            num = sc.nextInt();
            if (num != 0) {
                arbol.insertar(num);
            }
        } while (num != 0);

        System.out.print("Ingresa el número mm (para mostrar menores): ");
        int mm = sc.nextInt();

        System.out.print("Ingresa el número tt (para mostrar mayores): ");
        int tt = sc.nextInt();

        System.out.print("Ingresa el número a buscar: ");
        int buscador = sc.nextInt();

        System.out.println("\nÁrbol en orden:");
        arbol.mostrarInOrden();

        System.out.println("Números menores a " + mm + ":");
        arbol.mostrarMenores(mm);

        System.out.println("Números mayores a " + tt + ":");
        arbol.mostrarMayores(tt);

        System.out.println("El número " + buscador + (arbol.buscar(buscador) ? " fue encontrado." : " no fue encontrado."));
    }
}
