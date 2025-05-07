public class ListaEstudiantes {
    Estudiante cabeza;

    public void agregarEstudiante(String codigo, String nombre, double nota1, double nota2, double nota3, double notaFinal, String carrera) {
        Estudiante nuevo = new Estudiante(codigo, nombre, nota1, nota2, nota3, notaFinal, carrera);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Estudiante actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void imprimirTodos() {
        Estudiante actual = cabeza;
        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        while (actual != null) {
            System.out.println("Código: " + actual.codigo + ", Nombre: " + actual.nombre);
            System.out.println("Notas: " + actual.nota1 + ", " + actual.nota2 + ", " + actual.nota3 + ", Final: " + actual.notaFinal);
            System.out.println("Carrera: " + actual.carrera);
            System.out.println("------------------------");
            actual = actual.siguiente;
        }
    }

    public void imprimirCodigosYNotaFinal() {
        Estudiante actual = cabeza;
        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Códigos y Nota Final:");
        while (actual != null) {
            System.out.println("Código: " + actual.codigo + " - Nota Final: " + actual.notaFinal);
            actual = actual.siguiente;
        }
    }

    public void imprimirNoIngenieria() {
        Estudiante actual = cabeza;
        boolean hayOtros = false;
        System.out.println("Estudiantes que NO pertenecen a Ingeniería de Sistemas:");
        while (actual != null) {
            if (!actual.carrera.equalsIgnoreCase("Ingeniería de Sistemas")) {
                hayOtros = true;
                System.out.println("Código: " + actual.codigo + ", Nombre: " + actual.nombre + ", Carrera: " + actual.carrera);
            }
            actual = actual.siguiente;
        }
        if (!hayOtros) {
            System.out.println("Todos los estudiantes son de Ingeniería de Sistemas.");
        }
    }
}
