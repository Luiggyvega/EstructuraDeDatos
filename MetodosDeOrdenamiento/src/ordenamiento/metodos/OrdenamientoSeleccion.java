package ordenamiento.metodos;

import ordenamiento.NumerosAlmacenados;

import java.util.ArrayList;

public class OrdenamientoSeleccion {

    public OrdenamientoSeleccion(ArrayList<NumerosAlmacenados> numeros) {
        int n = numeros.size();

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            // Buscar el menor en el resto de la lista
            for (int j = i + 1; j < n; j++) {
                if (numeros.get(j).getValor() < numeros.get(indiceMenor).getValor()) {
                    indiceMenor = j;
                }
            }

            // Intercambiar el menor con el primer elemento no ordenado
            if (indiceMenor != i) {
                NumerosAlmacenados temp = numeros.get(i);
                numeros.set(i, numeros.get(indiceMenor));
                numeros.set(indiceMenor, temp);
            }
    }
}}
