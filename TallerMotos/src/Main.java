import java.util.Scanner;

class Almacen {
    String referencia;
    String nombreproducto;
    double precio;
    double cantidad;

    public Almacen(String referencia, String nombreproducto, double precio, double cantidad) {
        this.referencia = referencia;
        this.nombreproducto = nombreproducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}
class Factura{
    String referencia;
    double cantrespuestos;
    double tiempo;
    double totalfactura;

    public Factura(String referencia, double cantrespuestos, double tiempo) {
        this.referencia = referencia;
        this.cantrespuestos = cantrespuestos;
        this.tiempo = tiempo;
        this.totalfactura = totalfactura;
    }
}
class Nodoa{
    Almacen almacen;
    Nodoa siguiente;

    public Nodoa(Almacen almacen) {
        this.almacen = almacen;
        this.siguiente = null;
    }
}
class Nodob{
    Factura factura;
    Nodob siguiente;
    public Nodob(Factura factura) {
        this.factura = factura;
        this.siguiente = null;
    }
}
class Lista{
    Nodoa nodo1;
    Nodob nodo2;
    public void agregarA(Almacen almacen){
        Nodoa nuevo =new Nodoa(almacen);

        if (nodo1 == null ){
            nodo1 = nuevo;

        }
        else {
            Nodoa actual = nodo1;
            while (actual.siguiente != null  ){
                actual=actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    public void agregarf(Factura factura){
        Nodob nuevob = new Nodob(factura);
        if (nodo2 == null){
            nodo2 = nuevob;
        }else {
            Nodob actualb = nodo2;
            while (actualb.siguiente != null){
                actualb=actualb.siguiente;
            }
            actualb.siguiente = nuevob;
        }

    }
    public void mostrara(){
        Nodoa actual = nodo1;
        if (nodo1== null){
            System.out.println("no hay inventario");
        }
        while (actual != null){
            Almacen almacen = actual.almacen;
            System.out.println("referencia: " + almacen.referencia + " nombreproducto: " + almacen.nombreproducto + " precio: " + almacen.precio + " cantidad: " + almacen.cantidad );
            actual= actual.siguiente;
        }

    }

    public void mostrarb() {
        Nodoa actual = nodo1;
        Nodob actualb = nodo2;
        if (nodo1== null){
            System.out.println("no hay inventario por lo tanto no se puede hacer factura");
        } else if (nodo2 == null) {
            System.out.println("no hay datos de la factura");
        }
        else {
            while (actual != null && actualb!=null){
                Almacen almacen = actual.almacen;
                Factura factura = actualb.factura;
                double valorTiempo = 250;
                if (factura.referencia.equals(almacen.referencia)){
                    if (factura.cantrespuestos>almacen.cantidad){
                        System.out.println("no hay suficientes respuestos");
                    }
                    else {
                        almacen.cantidad=almacen.cantidad-factura.cantrespuestos;
                        double cantidad= factura.cantrespuestos * almacen.precio;
                        double precio=(valorTiempo* factura.tiempo) + cantidad;
                        System.out.println("el total a pagar es de la factura :" +factura.referencia+ " es de: " +  precio);
                    }
                }
                actual= actual.siguiente;
                actualb= actualb.siguiente;
            }
        }

    }
}

public class Main {
    static Lista lista = new Lista();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        char opcion;
        do {
            System.out.println("ingrese una opcion: ");
            System.out.println("1. Agregar al almacen");
            System.out.println("2. Agregar factura");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. generar factura");
            opcion = sc.next().charAt(0);
            switch (opcion){
                case '1'->agregarAlmacen();
                case '2'->agregarFactura();
                case '3'->lista.mostrara();
                case '4'->lista.mostrarb();
                default -> {
                    System.out.println("opcion no valida");
                }
            }
        }while(opcion!=0);
    }

    private static void agregarFactura() {
        System.out.println("ingrese los datos de la factura");
        sc.nextLine();
        System.out.println("referencia: ");
        String referencia = sc.next();
        System.out.println("cantidad de respuestos: ");
        double cantidad = sc.nextDouble();
        System.out.println("tiempo gastado en la reparacion (en minutos):");
        double tiempo = sc.nextDouble();
        Factura factura = new Factura(referencia, cantidad, tiempo);
        lista.agregarf(factura);
    }

    public static void agregarAlmacen() {
        System.out.println("ingrese los datos del producto a agregar:");
        sc.nextLine();
        System.out.println("referencia: ");
        String referencia = sc.nextLine();
        System.out.println("nombreproducto: ");
        String nombreproducto = sc.nextLine();
        System.out.println("precio: ");
        double precio = sc.nextDouble();
        System.out.println("cantidad: ");
        double cantidad = sc.nextDouble();
        Almacen a = new Almacen(referencia, nombreproducto, precio, cantidad);
        lista.agregarA(a);
    }
}