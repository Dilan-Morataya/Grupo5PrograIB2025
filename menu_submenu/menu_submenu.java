
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;
        
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Zoo");
            System.out.println("2. Fase 2 - Arreglos");
            System.out.println("3. Fase III");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcionPrincipal) {
                case 1:
                    System.out.println("Has seleccionado: Zoo");
                    // Aquí puedes agregar la lógica de Zoo
                    break;
                case 2:
                    mostrarSubmenuArreglos(scanner);
                    break;
                case 3:
                    System.out.println("Has seleccionado: Fase III");
                    // Aquí puedes agregar la lógica de Fase III
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Vuela a intentarlo nuevamente.");
            }
        } while (opcionPrincipal != 4);
        
        scanner.close();
    }

    public static void mostrarSubmenuArreglos(Scanner scanner) {
        char opcionSubmenu;
        do {
            System.out.println("\n--- SUBMENÚ FASE 2 - ARREGLOS ---");
            System.out.println("a. Agregar datos");
            System.out.println("b. Mostrar datos");
            System.out.println("c. Buscar elemento");
            System.out.println("d. Modificar elemento");
            System.out.println("e. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionSubmenu = scanner.nextLine().toLowerCase().charAt(0);

            switch (opcionSubmenu) {
                case 'a':
                    System.out.println("Has seleccionado: Agregar datos");
                    // Aquí puedes agregar código para agregar datos al arreglo
                    break;
                case 'b':
                    System.out.println("Has seleccionado: Mostrar datos");
                    // Aquí puedes mostrar el contenido del arreglo
                    break;
                case 'c':
                    System.out.println("Has seleccionado: Buscar elemento");
                    // Código para buscar un elemento
                    break;
                case 'd':
                    System.out.println("Has seleccionado: Modificar elemento");
                    // Código para modificar elementos
                    break;
                case 'e':
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcionSubmenu != 'e');
    }
}
