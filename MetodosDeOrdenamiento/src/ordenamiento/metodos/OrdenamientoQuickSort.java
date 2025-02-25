package ordenamiento.metodos;

import ordenamiento.NumerosAlmacenados;

import java.util.ArrayList;

public class OrdenamientoQuickSort {

    public OrdenamientoQuickSort(ArrayList<NumerosAlmacenados> numeros) {
        quickSort(numeros, 0, numeros.size() - 1);
    }

    private void quickSort(ArrayList<NumerosAlmacenados> lista, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(lista, inicio, fin);
            quickSort(lista, inicio, indicePivote - 1);
            quickSort(lista, indicePivote + 1, fin);
        }
    }

    private int particionar(ArrayList<NumerosAlmacenados> lista, int inicio, int fin) {
        NumerosAlmacenados pivote = lista.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista.get(j).getValor() <= pivote.getValor()) {
                i++;
                // Intercambiar elementos
                NumerosAlmacenados temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }
        // Colocar el pivote en su posición final
        NumerosAlmacenados temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fin));
        lista.set(fin, temp);

        return i + 1; // Retorna la posición del pivote
    }
}
