package ordenamiento.metodos;

import ordenamiento.NumerosAlmacenados;

import java.util.ArrayList;

public class OrdenamientoInserccion {

    public OrdenamientoInserccion(ArrayList<NumerosAlmacenados> numeros) {
        int n = numeros.size();

        for (int i = 1; i < n; i++) {
            NumerosAlmacenados clave = numeros.get(i);
            int j = i - 1;

            // Mover los elementos mayores que clave una posición adelante
            while (j >= 0 && numeros.get(j).getValor() > clave.getValor()) {
                numeros.set(j + 1, numeros.get(j));
                j--;
            }

            // Insertar clave en su posición correcta
            numeros.set(j + 1, clave);
        }
    }
}
