package Grupo5PrograIB2025;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program{
 
        abstract static class Animal {
    
            protected String nombre;
    
            protected int edad;
    
            protected double peso;
    
            protected String dieta;
    
    
    
            public Animal(String nombre, int edad, double peso, String dieta) {
    
                this.nombre = nombre;
    
                this.edad = edad;
    
                this.peso = peso;
    
                this.dieta = dieta;
    
            }
    
    
    
            public abstract void alimentar();
    
    
    
            public double calcularAlimento(int días) {
    
                if (días == 0) {
    
                    return 0;
    
                }
    
                return consumoDiario() + calcularAlimento(días - 1);
    
            }
    
    
    
            protected abstract double consumoDiario();   
    
            @Override
    
            public String toString() {
    
                return nombre + " - " + edad + " años - " + peso + " kg - " + dieta;
    
            }
    
        }
    
    
    
        static class Mamifero extends Animal {
    
            public Mamifero(String nombre, int edad, double peso, String dieta) {
    
                super(nombre, edad, peso, dieta);
    
            }
    
    
    
            @Override
    
            public void alimentar() {
    
                System.out.println(nombre + " (mamífero) ha sido alimentado.");
    
            }
    
    
    
            @Override
    
            public double consumoDiario() {
    
                return 10; // Ejemplo: 10 kg de alimento al día
    
            }
    
        }
    
    
    
        static class Ave extends Animal {
    
            public Ave(String nombre, int edad, double peso, String dieta) {
    
                super(nombre, edad, peso, dieta);
    
            }
    
    
    
            @Override
    
            public void alimentar() {
    
                System.out.println(nombre + " (ave) ha sido alimentado.");
    
            }
    
    
    
            @Override
    
            public double consumoDiario() {
    
                return 2; // Ejemplo: 2 kg de alimento al día
    
            }
    
        }
    
    
    
        static class Reptil extends Animal {
    
            public Reptil(String nombre, int edad, double peso, String dieta) {
    
                super(nombre, edad, peso, dieta);
    
            }
    
    
    
            @Override
    
            public void alimentar() {
    
                System.out.println(nombre + " (reptil) ha sido alimentado.");
    
            }
    
    
    
            @Override
    
            public double consumoDiario() {
    
                return 5; // Ejemplo: 5 kg de alimento al día
    
            }
    
        } 





        
    //  --clase para manejar archivos CSV (aún en desarrollo*)-.
    // @autor Junior-Hernandez 
    public static class ManejoDeCsv{

        // funcion para escribir en archivos csv (hace falta añadir el nombre de las clases para guardarlas cuando las haya)
        public static void escribirCsv(){
            try(BufferedWriter BuffW=new BufferedWriter(new FileWriter("registro.csv", true))){ 
                String line; //aqui voy a alzar los atributos de las clases
                BuffW.write("prueba,xd");
                BuffW.newLine();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        // funcion para leer archivos csv
        public static void leerCsv(String filepath){
            String line;

            try(BufferedReader BuffR = new BufferedReader(new FileReader(filepath))){

                while((line=BuffR.readLine())!=null){
                    String[] values=line.split(",");
                    for(String value : values){
                        System.out.println(value+" ");
                    }
                    System.out.println();
                }
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("\"Error pues\"");
            }
        }
    }


    public static void menu(){
        Scanner sc = new Scanner(System.in);
            System.out.print("ingrese su opcion:");
        int eleccion= sc.nextInt();
        do{
           System.out.println(" Menu Principal ");
           System.out.println("1.Zoo");
           System.out.println("2. Fase II");
           System.out.println("3. Fase III");
           System.out.println("4. Salir");
           System.out.println("Ingrese un numero para elegir una Opcion");
           
           eleccion = sc.nextInt();
           
           switch (eleccion) {
               case 1:
                   menuZoo(sc);
                   break;
               case 2:
                   ManejoDeCsv.leerCsv("registro.csv");
                   break;
               case 3:
                   ManejoDeCsv.escribirCsv();
                   break;
               case 4:
                   System.out.println("Saliendo del programa");
                   System.out.println("Adios, vuelve pronto");
                   break;
               default:
                   System.out.println("opcion no valida, selecciona un numero del 1 al 4");
                             }
           
           }while (eleccion !=4);
        
      
        }
    
    public static void menuZoo(Scanner sc) {
        int opcion;
        // Archivo ob = new Archivo();
        // Leer le = new Leer();
        do {
            System.out.println("\n Menú Zoo ");
            System.out.println("1. Agregar nuevo animal y cantidad de comida que come");
            System.out.println("2. Ver todos los animales del Zoo");
            System.out.println("3. Exportar datos a CSV");
            System.out.println("4. Volver al menú principal");
            System.out.print("Ingrese un numero para elegir una Opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Opción 1: Agregar nuevo animal y la cantidad de comida que come.");
                    //   Archivo.abrirArchivo();
                    //   Archivo.agregarRegistros();
                    //   Archivo.cerrarArchivos();
                    
                    break;
                case 2:
                    System.out.println("Opción 2: Mostrar todos los animales del Zoo.");
                    ManejoDeCsv.leerCsv("registro.csv");
                    //   Leer.abrirArchivo();
                    //   Leer.leerRegistros();
                    //   Leer.cerrarArchivo();
                    break;
                case 3:
                    System.out.println("Opción 3: Exportar datos a CSV.");
                    // Aquí iría el código para exportar los datos a un archivo CSV.
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor seleccione entre 1 y 4.");
            }
        } while (opcion != 4);
    }


    public static void main(String[] args){
        menu();
    }
}
