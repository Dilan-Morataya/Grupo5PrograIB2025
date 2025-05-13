package Grupo5PrograIB2025;

import java.util.*;

public class Program {
    static Scanner sc = new Scanner(System.in);
    static Animal[] animales = new Animal[10];
    static int contadorAnimales = 0;

    // --- FASE I + FASE II (POO, Arrays, Validaciones, Ordenamientos) ---

    //Definicion de clases
    abstract static class Animal {
        protected int idAnimal;
        protected String nombre;
        protected int edad;
        protected double peso;
        protected String dieta;

        public Animal(int idAnimal, String nombre, int edad, double peso, String dieta) {
            this.idAnimal = idAnimal;
            this.nombre = nombre;
            this.edad = edad;
            this.peso = peso;
            this.dieta = dieta;
        }

        public int getIdAnimal() {
            return idAnimal;
        }

        public abstract void mostrarInfo();
        public abstract void comer();

        @Override
        public String toString() {
            return "Animal{" +
                "ID de animal= "+idAnimal+
                   "nombre='" + nombre + '\'' +
                   ", edad=" + edad +
                   ", peso=" + peso + " kg" +
                   ", dieta='" + dieta + '\'' +
                   '}';
        }
    }


    //Definicion de clase Mamifero (Hereda de animal)
    static class Mamifero extends Animal {
        public Mamifero(int id, String nombre, int edad, double peso, String dieta) {
            super(id, nombre, edad, peso, dieta);
        }

        @Override
        public void mostrarInfo() {
            System.out.printf("Mamífero\t%-5d\t%-12s\t%-4d\t%-6.1f\t%s\n", idAnimal, nombre, edad, peso, dieta);
        }

        @Override
        public void comer() {
            System.out.println(nombre + " está comiendo según su dieta: " + dieta);
        }
    }
    
    //Definicion de clase Ave (Hereda de animal)
    static class Ave extends Animal {
        public Ave(int id, String nombre, int edad, double peso, String dieta) {
            super(id, nombre, edad, peso, dieta);
        }

        @Override
        public void mostrarInfo() {
            System.out.printf("Ave\t\t%-5d\t%-12s\t%-4d\t%-6.1f\t%s\n", idAnimal, nombre, edad, peso, dieta);
        }

        @Override
        public void comer() {
            System.out.println(nombre + " está comiendo según su dieta: " + dieta);
        }
    }
    
    //Definicion de clase Reptil (Hereda de animal)
    static class Reptil extends Animal {
        public Reptil(int id, String nombre, int edad, double peso, String dieta) {
            super(id, nombre, edad, peso, dieta);
        }

        @Override
        public void mostrarInfo() {
            System.out.printf("Reptil\t\t%-5d\t%-12s\t%-4d\t%-6.1f\t%s\n", idAnimal, nombre, edad, peso, dieta);
        }

        @Override
        public void comer() {
            System.out.println(nombre + " está comiendo según su dieta: " + dieta);
        }
    }







    
    public static void menu() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Zoo");
            System.out.println("2. Fase 2 - Arreglos");
            System.out.println("3. Fase III");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion;
            try{
                opcion = sc.nextInt();
            }catch(Exception ex){
                System.out.println("Debe ingresar un numero entero entre el 1 y el 4 ");
                opcion = 0;
                sc.nextLine();
            }
            switch (opcion) {
                case 1 -> menuZoo();
                case 2 -> menuArreglos();
                case 3 -> System.out.println("Fase III aún no implementada.");
                case 4 -> {
                    System.out.println("Adiós!");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public static void menuZoo() {
        System.out.println("Menú del Zoo (Fase I)");
    }

    public static void menuArreglos() {         //Menú de la Fase 2
        char opcion;
        do {
            System.out.println("\n--- Submenú Fase 2 ---");
            System.out.println("a. Agregar animal");
            System.out.println("b. Mostrar animales");
            System.out.println("c. Validar array lleno");
            System.out.println("d. Ordenar por ID");
            System.out.println("e. Mostrar solo IDs");
            System.out.println("f. Volver");
            System.out.print("Opción: ");
            opcion = sc.next().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a' -> agregarAnimal();
                case 'b' -> mostrarAnimales();
                case 'c' -> validarArrayLleno();
                case 'd' -> ordenarAnimales();
                case 'e' -> mostrarIds();
                case 'f' -> System.out.println("Regresando...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 'f');
    }





//                           Funcionalidades de la Fase 2

    // Agregar animales opcion " a "

    public static void agregarAnimal() {
        
        try{
    
            if (contadorAnimales >= animales.length) { //se valida que el array no esté lleno aún
                System.out.println("No se pueden agregar más animales. El array está lleno."); 
                return; // si el array está lleno se imprime el error y se termina la funcion
            }
        
            System.out.print("ID del animal: ");
            int id = sc.nextInt();
            if (existeId(id)) {
                System.out.println("El ID ya existe. Ingrese uno único.");
                return;
            }

            //Insert de datos sobre animales
            sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            System.out.print("Peso (kg): ");
            double peso = sc.nextDouble();
            sc.nextLine();
            System.out.print("Dieta: ");
            String dieta = sc.nextLine();

            System.out.print("Tipo [1. Mamífero, 2. Ave, 3. Reptil]: "); //Titulo del print
            int tipo = sc.nextInt();

            Animal nuevo;
            if (tipo == 1) nuevo = new Mamifero(id, nombre, edad, peso, dieta);
            else if (tipo == 2) nuevo = new Ave(id, nombre, edad, peso, dieta);
            else nuevo = new Reptil(id, nombre, edad, peso, dieta);

            animales[contadorAnimales++] = nuevo;
            System.out.println("Animal agregado correctamente.");
            
           
        }catch(Exception ex){
            System.out.println("lo sentimos algo salió mal, mensaje de erro: " + ex.getMessage());
            return;
        }
        
    }


    public static boolean existeId(int id) {
        for (int i = 0; i < contadorAnimales; i++) {
            if (animales[i].getIdAnimal() == id) return true;
        }
        return false;
    }

    // Agregar animales opcion " b "
    public static void mostrarAnimales() {
        if (contadorAnimales == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }
        System.out.println("\nTipo\t\tID\tNombre\t\tEdad\tPeso\tDieta");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < contadorAnimales; i++) {
            animales[i].mostrarInfo();
        }
    }

    //metodo para consultar los espacios disponibles en array opcion " c "
    public static void validarArrayLleno() { 
        if (contadorAnimales >= animales.length)
            System.out.println("El array está lleno.");
        else
            System.out.println("Espacios disponibles: " + (animales.length - contadorAnimales));
    }

    // Agregar animales opcion " d " con    Bubble sort
    public static void ordenarAnimales() {
        if (contadorAnimales == 0) {
            System.out.println("No hay animales para ordenar.");
            return;
        }

        System.out.print("Ordenar por ID (1 = ascendente, 2 = descendente): ");
        int orden = sc.nextInt();
        for (int i = 0; i < contadorAnimales - 1; i++) {
            for (int j = 0; j < contadorAnimales - 1 - i; j++) {
                boolean condicion = (orden == 1)
                        ? animales[j].getIdAnimal() > animales[j + 1].getIdAnimal()
                        : animales[j].getIdAnimal() < animales[j + 1].getIdAnimal();
                if (condicion) {
                    Animal temp = animales[j];
                    animales[j] = animales[j + 1];
                    animales[j + 1] = temp;
                }
            }
        }
        System.out.println("Animales ordenados correctamente.");
    }



    // Agregar animales opcion " e "
    public static void mostrarIds() {
        if (contadorAnimales == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }
        System.out.println("IDs de animales registrados:");
        for (int i = 0; i < contadorAnimales; i++) {
            System.out.println("- ID: " + animales[i].getIdAnimal());
        }
    }

    
    public static void main(String[] args) {
        menu(); 
    }



}










