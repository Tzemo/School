/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg2;

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

    public static Student[] insertionSort(Klas klas) {

        Student[] lijst = klas.geefStudentenZonderNullTerug();

        for (int i = 1; i < lijst.length; i++) {

            Student temp = lijst[i];
            int j = i;

            while (j > 0 && lijst[j - 1].getCijfer() < temp.getCijfer()) {

                lijst[j] = lijst[j - 1];

                j--;
            }

            lijst[j] = temp;

        }

        return lijst;
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
        int aantalLeerlingen = 200;
        
        for (int i = 0; i < aantalLeerlingen; i++) {
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

//        for (int i = 0; i < klassen.size(); i++) {
//            System.out.println(klassen.get(i).getKlas());
//            
//        }
        counter = 0;

        for (int i = 0; i < studenten.size(); i++) {
            if (counter < klassen.size()) {
                studenten.get(i).setKlas(klassen.get(counter));
                klassen.get(counter).addStudent(studenten.get(i));
                counter++;
                if (counter == klassen.size()) {
                    counter = 0;
                }

            }
        }

        List<Klas> nieuweKlassen = new ArrayList();

        //Lijst zonder null waarden.
        for (int i = 0; i < klassen.size(); i++) {

            Klas k = klassen.get(i);
            Student[] s = k.geefStudentenTerug();

            Klas k2 = new Klas(k.size());

            for (int j = 0; j < k.size(); j++) {
                k2.addStudentToNewList(s[j]);
//                System.out.println(s[j]);
            }

            nieuweKlassen.add(k2);

        }

//        for (int i = 0; i < nieuweKlassen.size(); i++) {
//            Klas k = nieuweKlassen.get(i);
//            Student[] s = k.geefStudentenZonderNullTerug();
//            
//            for (int j = 0; j < s.length; j++) {
//                System.out.println(s[j]);
//            }
//            
//            System.out.println("-----------");
//        }
        
//        for (int i = 0; i < nieuweKlassen.size(); i++) {
//
//            StdRandom.shuffle(nieuweKlassen.get(i).geefStudentenZonderNullTerug());
//        }

        for (int i = 0; i < nieuweKlassen.size(); i++) {

            Klas k = nieuweKlassen.get(i);
            Student[] s = k.geefStudentenZonderNullTerug();

            for (int j = 0; j < s.length; j++) {
                System.out.println(s[j]);
            }

            System.out.println("-----------");
        }

//        System.out.println();
//        System.out.println("Beginning insertion sort...");
//        System.out.println();
//
//
//        for (int i = 0; i < nieuweKlassen.size(); i++) {
//
//            Student[] lijst = insertionSort(nieuweKlassen.get(i));
//
//            for (Student s : lijst) {
//                System.out.println(s);
//            }
//
//        }

        System.out.println();
        System.out.println();
        
        Student[] studentLijst = new Student[aantalLeerlingen];
        int index = 0;
        
        for (int i = 0; i < nieuweKlassen.size(); i++) {
            
            Klas k = nieuweKlassen.get(i);
            Student[] s = k.geefStudentenZonderNullTerug();
            
            for (int j = 0; j < s.length; j++) {
                studentLijst[index] = s[j];
                System.out.println("Counter " + index + ": " + s[j]);
                index++;
                
            }
            
        }
        
        System.out.println();
        
        for (Student s : studenten) {
            System.out.println(s);
        }
        
        
    }

}
