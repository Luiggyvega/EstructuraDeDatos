import java.io.*;

public class ManejadorArchivos {

    public static void guardarPacientes(ListaPacientes lista, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Paciente actual = lista.getCabeza();
            while (actual != null) {
                // Guardar los datos del paciente
                writer.write(actual.getNombre() + "," +
                        actual.getCedula() + "," +
                        actual.getEdad() + "," +
                        actual.getEnfermedad() + "," +
                        actual.getAtendido());
                writer.newLine();

                String historial = actual.getHistorialConsultas();
                if (!historial.isEmpty()) {
                    writer.write("Historial:");
                    writer.newLine();
                    writer.write(historial);
                    writer.newLine();
                }

                actual = actual.getSiguiente();
            }
            System.out.println("Datos de pacientes guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }

    public static ListaPacientes cargarPacientes(String nombreArchivo) {
        ListaPacientes lista = new ListaPacientes();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            Paciente ultimoPaciente = null;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Historial:")) {
                    // Leer el historial de consultas con fecha
                    StringBuilder historial = new StringBuilder();
                    while ((linea = reader.readLine()) != null && !linea.isEmpty()) {
                        historial.append(linea).append("\n");
                    }
                    // Asignar el historial al último paciente agregado
                    if (ultimoPaciente != null) {
                        String[] consultas = historial.toString().split("\n");
                        for (String consulta : consultas) {
                            String[] partes = consulta.split(" \\| ");
                            String fecha = partes[0].replace("- Fecha: ", "");
                            String descripcion = partes[1].replace("Consulta: ", "");
                            ultimoPaciente.agregarConsulta(descripcion, fecha);
                        }
                    }
                } else {
                    // Leer los datos del paciente
                    String[] datos = linea.split(",");
                    if (datos.length == 5) {
                        lista.agregarPaciente(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
                        ultimoPaciente = lista.buscarPaciente(datos[1]); // Obtener el último paciente agregado
                    }
                }
            }
            System.out.println("Datos de pacientes cargados desde " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo: " + e.getMessage());
        }
        return lista;
    }
}
