package Grupo5PrograIB2025;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program{
    static Scanner sc = new Scanner(System.in);
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
        // fin
    
    
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
       
        public static void escribirCsvReptil(Reptil reptilxd){
            try(BufferedWriter BuffW=new BufferedWriter(new FileWriter("registro.csv", true))){ 
                String line = reptilxd.nombre+","+reptilxd.edad+","+reptilxd.peso+","+reptilxd.dieta;
                BuffW.write(line);
                BuffW.newLine();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        public static void escribirCsvAve(Ave avexd){
            try(BufferedWriter BuffW=new BufferedWriter(new FileWriter("registro.csv", true))){ 
                String line = avexd.nombre+","+avexd.edad+","+avexd.peso+","+avexd.dieta;
                BuffW.write(line);
                BuffW.newLine();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        public static void escribirCsvMamifero(Mamifero mamiferoxd){
            try(BufferedWriter BuffW=new BufferedWriter(new FileWriter("registro.csv", true))){ 
                String line = mamiferoxd.nombre+","+mamiferoxd.edad+","+mamiferoxd.peso+","+mamiferoxd.dieta;
                BuffW.write(line);
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
                        System.out.print(value+" ");
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
        do{
           System.out.println(" Menu Principal ");
           System.out.println("1.Zoo");
           System.out.println("2. Fase II");
           System.out.println("3. Fase III");
           System.out.println("4. Salir");
           System.out.print("ingrese su opcion:");

           int eleccion= sc.nextInt();
           
           switch (eleccion) {
               case 1:
                   menuZoo();
                   break;
               case 2:
                   System.out.println("FASE II");
                   break;
               case 3:
                   System.out.println("FASE III");
                   break;
               case 4:
                   System.out.println("Saliendo del programa");
                   System.out.println("Adios, vuelve pronto");
                   return;
               default:
                   System.out.println("opcion no valida, selecciona un numero del 1 al 4");
                             }
           
           }while (true);
        
      
        }
    
        public static void agregarAnimal(){
            System.out.println("elija el tipo de animal que quiere agregar: "+"\n"+"1. mamifero"+"\n"+"2. ave"+"\n"+"3. eptil");
            int tipoAnimal=sc.nextInt();
            switch(tipoAnimal){
                case 1:
                    System.out.print("ingrese el nombre del mamifero: ");
                    sc.nextLine();
                    String nombreMamifero=sc.nextLine();
                    System.out.print("ingrese la edad de mamifero: ");
                    int edadMamifero=sc.nextInt();
                    System.out.print("ingrese el peso del mamifero: ");
                    double pesoMamifero=sc.nextDouble();
                    System.out.print("ingrese la dieta del mamifero: ");
                    String dietaMamifero=sc.nextLine();
                    sc.nextLine();
                    Mamifero mamifero =new Mamifero(nombreMamifero,edadMamifero,pesoMamifero,dietaMamifero);
                    ManejoDeCsv.escribirCsvMamifero(mamifero);
                   
                    break;
                case 2:
                    System.out.print("ingrese el nombre del ave: ");
                    sc.nextLine();
                    String nombreAve=sc.nextLine();
                    System.out.print("ingrese la edad del ave: ");
                    int edadAve=sc.nextInt();
                    System.out.print("ingrese el peso del ave: ");
                    double pesoAve=sc.nextDouble();
                    System.out.print("ingrese la dieta del ave: ");
                    String dietaAve=sc.nextLine();
                    sc.nextLine();
                    Ave ave =new Ave(nombreAve,edadAve,pesoAve,dietaAve);
                    ManejoDeCsv.escribirCsvAve(ave);
                    break;
                case 3:
                    System.out.print("ingrese el nombre del reptil: ");
                    sc.nextLine();
                    String nombreReptil=sc.nextLine();
                    System.out.print("ingrese la edad del reptil: ");
                    int edadReptil=sc.nextInt();
                    System.out.print("ingrese el peso del reptil: ");
                    double pesoReptil=sc.nextDouble();
                    System.out.print("ingrese la dieta del reptil: ");
                    String dietaReptil=sc.nextLine();
                    sc.nextLine();
                    Reptil reptil =new Reptil(nombreReptil,edadReptil,pesoReptil,dietaReptil);
                    ManejoDeCsv.escribirCsvReptil(reptil);
                    break;
            }
        }

    public static void menuZoo() {
        do {
            System.out.println("\n Menú Zoo ");
            System.out.println("1. Agregar nuevo animal y cantidad de comida que come");
            System.out.println("2. Ver todos los animales del Zoo");
            System.out.println("3. Exportar datos a CSV");
            System.out.println("4. Volver al menú principal");
            System.out.print("Ingrese un numero para elegir una Opcion");
            // sc.nextInt();
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Opción 1: Agregar nuevo animal y la cantidad de comida que come.");
                    agregarAnimal();
                    break;
                case 2:
                    System.out.println("Opción 2: Mostrar todos los animales del Zoo.");
                    ManejoDeCsv.leerCsv("registro.csv");
                    break;
                case 3:
                    System.out.println("Opción 3: Exportar datos a CSV.");
                    // ManejoDeCsv.escribirCsv();
                    // Aquí iría el código para exportar los datos a un archivo CSV.
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    return;
                default:
                    System.out.println("Opción inválida, por favor seleccione entre 1 y 4.");
            }
        } while (true);
    }


    public static void main(String[] args){
        menu();
    }
}
