public class Estudiante {
    String codigo;
    String nombre;
    double nota1, nota2, nota3, notaFinal;
    String carrera;
    Estudiante siguiente;

    public Estudiante(String codigo, String nombre, double nota1, double nota2, double nota3, double notaFinal, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaFinal = notaFinal;
        this.carrera = carrera;
        this.siguiente = null;
    }
}
