package ordenamiento;

import java.util.ArrayList;
import java.util.Scanner;

public class OrdenamientoService {
    private ArrayList<NumerosAlmacenados>numeros;
    Scanner sc;

    public OrdenamientoService(){
        numeros = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public void menu(){
        char opcion;
        do {
            System.out.println("--- ingrese una opcion ---");
            System.out.println("1. almacenar un numero");
            System.out.println("2. metodos de ordenamiento disponibles");
            opcion = sc.next().charAt(0);
            switch (opcion) {
                case '1'-> AlmacenarNumero();
                case '2'-> OrdenamientoNumeros();
                default -> {
                    System.out.println("estamos hablando");}
            }
        }while(opcion != 's');
    }

    private void OrdenamientoNumeros() {

        if (numeros.isEmpty()) {
                System.out.println("No hay números almacenados.");
                return;
        }
        System.out.println("Números almacenados:");
        for (NumerosAlmacenados numero : numeros) {
            System.out.println(numero);
        }
        MetodosOrdenamiento metodosOrdenamiento = new MetodosOrdenamiento(numeros);
            metodosOrdenamiento.menu();
    }

    private void AlmacenarNumero() {
        System.out.println("ingrese un numero");
        int numero = sc.nextInt();
        numeros.add(new NumerosAlmacenados(numero));
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.size()<2){
                System.out.println("ingrese otro numero");
                numero = sc.nextInt();
                numeros.add(new NumerosAlmacenados(numero));
            }
        }
        System.out.println("numeros ingresados");
    }
}
