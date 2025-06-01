/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package progra1.progra;

import java.util.Scanner;

/**
 *
 * @author Junior Hernandez
 */
public class PROGRA {

    public static Scanner input = new Scanner(System.in);
    
           
    public static void main(String[] args) {
        
        menuPrincipal();
        
    }
    
    
    public static void menuPrincipal(){
        while(true){
            
        System.out.println("Z O O L O G I C O");
        
        System.out.println("1. FASE I ");
        System.out.println("2. FASE I I ");
        System.out.println("3. FASE I I I ");
        System.out.println("4. Salir ");
        
        System.out.println("Ingrese una opcion");
        
        var opcion = input.nextInt();
        
        
        switch(opcion){
            
            case 1:
                System.out.println("Opcion ya no disponible");
            break;
            case 2:
                System.out.println("Opcion ya no disponible");
            break;
            
            case 3:
                SubmenuFASE3(); //OPERACIONES PERO CON CONEXION A BASE DE DATOS
            break;
            
            case 4:
                return;
            
            default:
                System.out.println("opcion no valida elige una entre 1 y 4");
            break;
        }
        }
        
    }
    
    
    public static void SubmenuFASE3(){
        while(true){
            
        System.out.println("ADMINISTRAR ANIMALES");
        System.out.println("1. Trabajar con Reptiles");
        System.out.println("2. Trabajar con Mamiferos");
        System.out.println("3. Trabajar con Aves");
        System.out.println("4. Volver al menú anterior");
        
        System.out.println("Ingrese una opcion");
         
        var opcion = input.nextInt();
        
        switch(opcion){
            case 1:
                F3Reptiles();
            break;
                
            case 2: 
                System.out.println("A elegido la opcion trabajar con Mamiferos. ");
            break;
            
            case 3: 
                 System.out.println("A elegido la opcion trabajar con Aves. ");
            break;
            
            case 4: 
                menuPrincipal();
            break;
            
            default:
                System.out.println("opcion no valida elige una entre 1 y 4");
            break;
        }
        }
    }
    
    
//    trabajar con reptiles
    public static void F3Reptiles(){
        while(true){
            
        System.out.println("TRABAJAR CON REPTILES");
        System.out.println("C. Insertar un nuevo Reptil");
        System.out.println("R. Consultar Reptiles");
        System.out.println("U. Actualizar Reptil");
        System.out.println("D. Eliminar Reptil");
        System.out.println("B. Volver al menú anterior");
        
        System.out.println("\n Ingrese una opcion:");
                 
        var opcion = input.nextLine();
        
        switch(opcion){
            case "C", "c":
                System.out.println("Insertar nuevo reptil");
                daoReptiles.InsertarReptil();
            break;
            
            case "R","r":
                System.out.println("Consultar reptiles");
            break;
            
            case "U","u":
                System.out.println("Actualizar reptiles");
            break;
            
            
            case "D","d":
                System.out.println("Eliminar reptiles");
            break;
            
            case "B", "b":
                SubmenuFASE3();
            break;
            
            default:
                System.out.println("Opcion no valida elige una opcion de las anteriores");
            break;
        }
        
        }
    }
      
}
