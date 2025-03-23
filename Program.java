package Grupo5PrograIB2025;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program{

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
