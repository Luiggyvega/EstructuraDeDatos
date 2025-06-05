import java.util.Scanner;

class Nodo{
    int dato;
    Nodo izquiera,derecha;

    public Nodo(int dato) {
        this.dato = dato;
        izquiera=derecha=null;
    }
}
class Arbol{
    Nodo raiz;

    public void insertar(int dato){
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if(raiz==null){
            return new Nodo(dato);
        }
        if(dato<raiz.dato){
            raiz.izquiera=insertarRec(raiz.izquiera, dato);
        }
        else {
            raiz.derecha=insertarRec(raiz.derecha, dato);
        }
        return raiz;
    }

    public void MostrarInOrden(){
        Inorden(raiz);
        System.out.println();
    }

    private void Inorden(Nodo nodo) {
        if (nodo!=null){
            Inorden(nodo.izquiera);
            System.out.println(nodo.dato + " ");
            Inorden(nodo.derecha);
        }
    }
}

class ListaArbol{
    public static void main(String[] args) {
    Arbol arbol = new Arbol();
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese los numeros de la lista, cero para terminar");
        int opcion;
        do{
            opcion = sc.nextInt();
            if (opcion!=0){
                arbol.insertar(opcion);
            }
        }while (opcion!=0);
        System.out.println("los numeros ingresados fueron: ");
        arbol.MostrarInOrden();
    }
}