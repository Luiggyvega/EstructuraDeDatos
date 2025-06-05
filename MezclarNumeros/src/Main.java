import java.util.Scanner;
class nodorem {
    int rem;
    nodorem siguiente;

    public nodorem(int rem) {
        this.rem = rem;
        this.siguiente = null;
    }
}

class nodocal {
    int cal;
    nodocal siguiente;

    public nodocal(int cal) {
        this.cal = cal;
        this.siguiente = null;
    }
}

class nodores {
    int rem;
    int cal;
    nodores siguiente;

    public nodores(int rem, int cal) {
        this.rem = rem;
        this.cal = cal;
        this.siguiente = null;
    }
}

class Lista {
    nodorem cabezaRem;
    nodocal cabezaCal;
    nodores cabezaRes;

    public void agregarRem(int rem) {
        nodorem nuevo = new nodorem(rem);
        if (cabezaRem == null) {
            cabezaRem = nuevo;
        } else {
            nodorem aux = cabezaRem;
            while (aux.siguiente != null) aux = aux.siguiente;
            aux.siguiente = nuevo;
        }
    }

    public void agregarCal(int cal) {
        nodocal nuevo = new nodocal(cal);
        if (cabezaCal == null) {
            cabezaCal = nuevo;
        } else {
            nodocal aux = cabezaCal;
            while (aux.siguiente != null) aux = aux.siguiente;
            aux.siguiente = nuevo;
        }
    }

    public void crearListaRes() {
        nodorem actualrem = cabezaRem;
        nodocal actualcal = cabezaCal;
        cabezaRes = null;
        nodores ultimo = null;

        while (actualrem != null && actualcal != null) {
            nodores nuevo = new nodores(actualrem.rem, actualcal.cal);
            if (cabezaRes == null) {
                cabezaRes = nuevo;
                ultimo = nuevo;
            } else {
                ultimo.siguiente = nuevo;
                ultimo = nuevo;
            }
            actualrem = actualrem.siguiente;
            actualcal = actualcal.siguiente;
        }
    }

    public void mostrarRes() {
        System.out.println("Lista RES ");
        nodores aux = cabezaRes;
        nodorem actualrem = cabezaRem;
        nodocal actualcal = cabezaCal;

        if (actualrem == null && actualcal == null) {
            System.out.println("Las listas están vacías.");

        }

        if (actualrem == null) {
            while (actualcal != null) {
                System.out.println("null, " + actualcal.cal);
                actualcal = actualcal.siguiente;
            }

        }
        if (actualcal == null) {
            while (actualrem != null) {
                System.out.println(actualrem.rem + ", null");
                actualrem = actualrem.siguiente;
            }

        }
        else {
            while (aux != null) {
                System.out.print( aux.rem + ", " + aux.cal );
                aux = aux.siguiente;
        }
    }
    }}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        System.out.println("oprima 0 cuando ya tenga la lista completa");
        System.out.println("Ingrese valores para la lista REM ");
        while (true) {
            int rem = scanner.nextInt();
            if (rem == 0) break;
            lista.agregarRem(rem);
        }

        System.out.println("Ingrese valores para la lista CAL ");
        while (true) {
            int cal = scanner.nextInt();
            if (cal == 0) break;
            lista.agregarCal(cal);
        }

        lista.crearListaRes();
        lista.mostrarRes();
    }
}





