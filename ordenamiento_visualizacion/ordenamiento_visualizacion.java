import java.util.Arrays;
import java.util.Comparator;

public class UtilidadesAnimales {

    public static void ordenarPorId(Animal[] animales, int cantidad, boolean ascendente) {
        Arrays.sort(animales, 0, cantidad, new Comparator<Animal>() {
            @Override
            public int compare(Animal a1, Animal a2) {
                return ascendente ? Integer.compare(a1.getIdAnimal(), a2.getIdAnimal())
                                  : Integer.compare(a2.getIdAnimal(), a1.getIdAnimal());
            }
        });
        System.out.println("Animales ordenados " + (ascendente ? "ascendentemente." : "descendentemente."));
    }

    public static void mostrarSoloIDs(Animal[] animales, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println("ID Animal: " + animales[i].getIdAnimal());
        }
    }
}
