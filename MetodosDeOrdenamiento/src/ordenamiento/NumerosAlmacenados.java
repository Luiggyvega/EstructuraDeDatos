package ordenamiento;

public class NumerosAlmacenados {
    private int valor;

    public NumerosAlmacenados(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
