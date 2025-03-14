//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class lista {
    nodo primero = null;

    public lista() {
    }

    public void ingresarDato(int dato) {
        nodo nuevo = new nodo();
        nuevo.dato = dato;
        nuevo.sig = this.primero;
        this.primero = nuevo;
    }

    public void desplegar() {
        new nodo();

        for(nodo actual = this.primero; actual != null; actual = actual.sig) {
            System.out.println(actual.dato);
        }

    }

    public static class nodo {
        int dato;
        nodo sig;

        public nodo() {
        }
    }
}