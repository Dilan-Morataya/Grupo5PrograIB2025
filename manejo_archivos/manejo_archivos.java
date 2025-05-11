package manejo_archivos;

public class manejo_archivos {
    import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class ArchivoCSV {
    public static void exportar(List<Animal> animales) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("animales.csv"))) {
            for (Animal a : animales) {
                writer.write(a.getTipo() + "," + a.getNombre() + "," + a.especie + "," + a.edad + "," + a.cantidadComidaDiaria);
                writer.newLine();
            }
            System.out.println("Datos exportados exitosamente a animales.csv");
        } catch (IOException e) {
            System.out.println("Error al exportar archivo CSV: " + e.getMessage());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.menu();
    }
}
}
