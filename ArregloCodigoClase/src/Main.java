//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        lista L1 = new lista();
        int num = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, introduzca un numero diferente a (0)");

        while(num != 0) {
            num = sc.nextInt();
            L1.ingresarDato(num);
        }

        System.out.println("los numeros digitados fueron: ");
        L1.desplegar();
    }
}