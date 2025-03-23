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

            try(BufferedReader BuffR = new BufferedReader(new FileReader("registro.csv"))){

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

    public static void main(String[] args){
        
    }
}
