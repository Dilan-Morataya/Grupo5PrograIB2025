/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra1.progra;

import Progra1_DB.Reptiles;
import java.math.BigInteger;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Junior Hernandez
 */
public class daoReptiles {
    
    public static boolean InsertarReptil(){
        var input = new Scanner(System.in);
        var reptil = new Reptiles();
        
        System.out.println("ingrese el nombre del reptil");
        reptil.setNombre(input.nextLine());
       
        System.out.println("ingrese la especie del reptil");
        reptil.setEspecie(input.nextLine());
        
        System.out.println("ingrese la edad del reptil");
        var edadInt = input.nextInt();
          BigInteger edadBigInt = BigInteger.valueOf(edadInt);
        
        reptil.setEdad(edadBigInt);
       
       
        System.out.println("ingrese la dieta del reptil");
        reptil.setDieta(input.nextLine());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ZooPersistent");
        
        
        EntityManager em = emf.createEntityManager();
        
        try{
            
            em.getTransaction().begin();
            em.persist(reptil);
            em.getTransaction().commit();
            
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.out.println("No se pudo completar la transacción");
        }finally{
            em.close();
        }
        
        
        
        return true;
    }
    
    
    
}
