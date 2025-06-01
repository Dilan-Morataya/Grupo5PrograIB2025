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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Ingrese una opcion");
        
        var opcion = input.nextInt();
        
        
        switch(opcion){
            case 1:
                System.out.println("opcion de agregar nuevo reptil");
                daoReptiles.AddReptil();
                break;
            default:
                System.out.println("no elegiste algo valido, elije 1 xdxdxd");
        }
        
        
    }
}
