package ordenamiento.metodos;

import ordenamiento.NumerosAlmacenados;

import java.util.ArrayList;

public class OrdenamientoBurbuja {

    public OrdenamientoBurbuja(ArrayList<NumerosAlmacenados> numeros) {
        int n = numeros.size();
        boolean intercambiado;

        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (numeros.get(j).getValor() > numeros.get(j + 1).getValor()) {
                    // Intercambiar los elementos
                    NumerosAlmacenados temp = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, temp);
                    intercambiado = true;
                }
            }
            if (!intercambiado) break;
    }}}

