package ordenamiento;

import ordenamiento.metodos.OrdenamientoBurbuja;
import ordenamiento.metodos.OrdenamientoInserccion;
import ordenamiento.metodos.OrdenamientoQuickSort;
import ordenamiento.metodos.OrdenamientoSeleccion;

import java.util.ArrayList;
import java.util.Scanner;

public class MetodosOrdenamiento {
    private Scanner sc;
    private ArrayList<NumerosAlmacenados> numeros;

    public MetodosOrdenamiento(ArrayList<NumerosAlmacenados> numeros) {
        this.numeros = numeros;
        sc = new Scanner(System.in);
    }

    public void menu(){
        char opcion;
        do {
            System.out.println("--- Ingrese una opción ---");
            System.out.println("1. Ordenamiento por método Burbuja");
            System.out.println("2. Ordenamiento por método Selección");
            System.out.println("3. Ordenamiento por método Inserción");
            System.out.println("4. Ordenamiento por método QuickSort");
            System.out.println("s. Salir");
            opcion = sc.next().charAt(0);
            switch (opcion) {
                case '1' -> {
                    OrdenamientoBurbuja ordenamiento = new OrdenamientoBurbuja(numeros);// Llamamos al método de ordenamiento
                    System.out.println("Números ordenados con Burbuja: " + numeros);
                }
                case '2' -> {
                    OrdenamientoSeleccion ordenamiento = new OrdenamientoSeleccion(numeros);
                    System.out.println("Números ordenados con Selección: " + numeros);
                }
                case '3' -> {
                    OrdenamientoInserccion ordenamiento = new OrdenamientoInserccion(numeros);
                    System.out.println("Números ordenados con Inserción: " + numeros);
                }
                case '4' -> {
                    OrdenamientoQuickSort ordenamiento = new OrdenamientoQuickSort(numeros);
                    System.out.println("Números ordenados con QuickSort: " + numeros);
                }
                default -> System.out.println("chau");
            }
        } while (opcion != 's');
    }
}

