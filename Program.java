package Grupo5PrograIB2025;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program{
    public static class ManejoDeCsv{

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
    public static void main(String[] args){
        ManejoDeCsv.leerCsv("Archivo.csv");
        
    }
}
