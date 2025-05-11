package menu_de_control;

public class menu_de_control {
    import java.util.ArrayList;
import java.util.Scanner;

class Zoo {
    private ArrayList<Animal> animales = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void agregarAnimal(Animal a) {
        animales.add(a);
        System.out.println("Animal agregado con éxito.");
    }

    public void listarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animal a : animales) {
                System.out.println(a);
            }
        }
    }

    public void calcularConsumoTotal(int dias) {
        double total = 0;
        for (Animal a : animales) {
            total += a.calcularAlimento(dias);
        }
        System.out.println("Total de alimento requerido por " + dias + " días: " + total + " kg");
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n1. Agregar Animal\n2. Listar Animales\n3. Calcular Consumo\n4. Exportar CSV\n5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> menuAgregar();
                case 2 -> listarAnimales();
                case 3 -> {
                    System.out.print("Ingrese cantidad de días: ");
                    int dias = sc.nextInt();
                    calcularConsumoTotal(dias);
                }
                case 4 -> ArchivoCSV.exportar(animales);
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void menuAgregar() {
        System.out.print("Tipo (1. Mamífero, 2. Ave, 3. Reptil): ");
        int tipo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Especie: ");
        String especie = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Comida diaria (kg): ");
        double comida = sc.nextDouble();

        switch (tipo) {
            case 1 -> agregarAnimal(new Mamifero(nombre, especie, edad, comida));
            case 2 -> agregarAnimal(new Ave(nombre, especie, edad, comida));
            case 3 -> agregarAnimal(new Reptil(nombre, especie, edad, comida));
            default -> System.out.println("Tipo inválido.");
        }
    }
}
}
