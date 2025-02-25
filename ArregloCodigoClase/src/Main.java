import java.util.Scanner;

public class Main {
    public static  class nodo {
        int nodo;
        nodo sig;
    }
    public static class lista{
        nodo primero;
        public lista(){
            primero = null;
        }
    }
    public static void main(String[] args) {
        lista i = new lista();
        int num=1;
        Scanner sc = new Scanner(System.in);
        System.out.printf("ingrese un numero diferente de cero");
        while(num!=0){
            num=sc.nextInt();
            ingresardato(num);
        }
        System.out.println("numeros ingresados fueron");
        i.desplegar;
    }
    public void ingresardato(int num){
        nodo nuevo = new dato();
        nuevo.dato=dato;
        nuevo.sig=prev;
        primero = nuevo;
    }
    public void desplegar(){
        nodo acutal = new nodo();
        acutal= primero;
        while(acutal!=null){
            System.out.println(acutal.dato);
            acutal=acutal.sig;
        }
    }
    }
