/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.Klas;
import models.Student;
import nl.hva.dmci.ict.inf.ads.lib.StdRandom;

/**
 *
 * @author duytran
 */
public class Opdracht2 {

    public static Student[] insertionSort(ArrayList<Student> studenten){
        
        Student[] gesorteerd = (Student[]) studenten.toArray();
        
        
        for (int i = 1; i < gesorteerd.length; i++) {
          
                Student temp = gesorteerd[i];
                int j = i;   
                System.out.println(i);
                while(j>0 && gesorteerd[j-1].getCijfer() < temp.getCijfer()){
                    
                    gesorteerd[j] = gesorteerd[j-1];
              
                    System.out.println(j);
                    j--;
                }

                gesorteerd[j] = temp;
                
        }
        
        return gesorteerd;
    }


    public static double aantalKlassen(int aantalStudenten) {

        double aantalKlassen = ((double) aantalStudenten / 32) / 4;

        return Math.ceil(aantalKlassen) * 4;

    }

    public static Klas geefKlas(int x, int klasNummer) {

        Klas klas = new Klas();

        switch (x) {

            case 0: {
                klas.setKlas("G" + klasNummer);
                break;
            }
            case 1: {
                klas.setKlas("N" + klasNummer);
                break;
            }
            case 2: {
                klas.setKlas("S" + klasNummer);
                break;
            }
            case 3: {
                klas.setKlas("T" + klasNummer);
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

        Random generator = new Random();
        List<Student> studenten = new ArrayList();
 
        for (int i = 0; i < 200; i++) {
            Student s = new Student();
            s.incrementId(i);
            double cijfer = generator.nextDouble() * 9 + 1;
         
           s.setCijfer(cijfer);
           studenten.add(s);
            
        }
        
        int counter = 0;
        int klasNummer = 200;
        Klas klas = new Klas();
        List<Klas> klassen = new ArrayList();

        for (int i = 0; i < (int) aantalKlassen(studenten.size()); i++) {

            if (counter <= 3) {
                if (counter == 0) {
                    klasNummer++;
                }
                klas = geefKlas(counter, klasNummer);
                klassen.add(klas);

                counter++;

                if (counter == 4) {
                    counter = 0;
                }
            }

        }
        
        for (int i = 0; i < klassen.size(); i++) {
            System.out.println(klassen.get(i).getKlas());
            
        }

        counter = 0;
        
        for (int i = 0; i < studenten.size(); i++) {
            if (counter < klassen.size()) {
                studenten.get(i).setKlas(klassen.get(counter));
                klassen.get(counter).addStudent(studenten.get(i));
                counter++;
                if (counter==klassen.size()) {
                    counter = 0;
                }
               
                        
            }
        }
        
        for (int i = 0; i < klassen.size(); i++) {
            StdRandom.shuffle(klassen.get(i).geefStudentenTerug().toArray());
        }
 
//        
//        for (Student s : studenten) {
//            System.out.println(s);
//        }
//
//        for (int i = 0; i < klassen.size(); i++) {
//            klassen.get(i).print();
//        }
//      
      
        
        Student[] lijst = insertionSort(klassen.get(0).geefStudentenTerug());
        
        
        for (Student s : lijst) {
            System.out.println(s);
        }
        
    }

}
