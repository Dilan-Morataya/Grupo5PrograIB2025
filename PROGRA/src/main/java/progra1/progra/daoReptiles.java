/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra1.progra;

import Progra1_DB.Reptiles;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Junior Hernandez
 */
public class daoReptiles {
    
    public static boolean AddReptil(){
        var input = new Scanner(System.in);
        var reptil = new Reptiles();
        
        System.out.println("ingrese el nombre del reptil");
        reptil.setNombre(input.nextLine());
       
        System.out.println("ingrese la edad del reptil");
        reptil.setEdad(input.nextBigInteger());
       
        System.out.println("ingrese la especie del reptil");
        reptil.setEspecie(input.nextLine());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ZooPersistent");
        
        
        EntityManager em = emf.createEntityManager();
        
        try{
            
        }catch(Exception ex){
            System.out.println("No se pudo completar la transacción");
        }
        
        
        
        return true;
    }
    
    
    
}
