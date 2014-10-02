/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opdracht.pkg2;

import java.util.ArrayList;
import java.util.List;
import models.Klas;
import models.Student;

/**
 *
 * @author duytran
 */
public class Opdracht2 {
    
    public List studentLijst(int aantal) {
        
        Student student = new Student();
        
        List<Student> list = new ArrayList();
        
        return list;
    }
    
    public static double aantalKlassen(int aantalStudenten) {
        
        double aantalKlassen = ((double) aantalStudenten / 32) / 4;
        
        return Math.ceil(aantalKlassen) * 4;
        
    }
    
    public static Klas geefKlas(int x) {
        
        Klas klas = new Klas();
        
        switch(x) {
            
            case 0: {
                klas.setKlas("G");
                break;
            }
            case 1: {
                klas.setKlas("N");
                break;
            }
            case 2: {
                klas.setKlas("S");
                break;
            }
            case 3: {
                klas.setKlas("T");
                break;
            }
            default:
                System.out.println("fsf");
                break;
            
        }
        
        
        return klas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int counter = 0; 
        Klas klas = new Klas();
        List<Klas> klassen = new ArrayList();
        
        for (int i = 0; i <= (int) aantalKlassen(800); i++) {
            if (counter < 4) {
                
                klas = geefKlas(counter);
                klassen.add(klas);
                
                counter++;
            } else {
                counter = 0;
                
            }
        }
        
        int i = 1;
        
        for (Klas k : klassen) {
            System.out.print(i + " ");
            System.out.println(k.getKlas());
            i++;
        }
        
    }
    
}
