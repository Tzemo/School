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
import sorting.Sorting;

/**
 *
 * @author duytran
 */
public class Opdracht2 {

    public static double aantalKlassen(int aantalStudenten) {

        double aantalKlassen = ((double) aantalStudenten / 32) / 4;

        return Math.ceil(aantalKlassen) * 4;

    }

    public static Klas geefKlas(int x, int klasNummer) {

        Klas klas = new Klas();

        switch (x) {

            case 0: {
                klas.concatKlas("G" + klasNummer);
                break;
            }
            case 1: {
                klas.concatKlas("N" + klasNummer);
                break;
            }
            case 2: {
                klas.concatKlas("S" + klasNummer);
                break;
            }
            case 3: {
                klas.concatKlas("T" + klasNummer);
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
        final int AANTAL_LEERLINGEN = 200;
//        List<Student> studenten = new ArrayList();
        Student[] studenten = new Student[AANTAL_LEERLINGEN];

        //Maak studenten aan
        for (int i = 0; i < studenten.length; i++) {
            Student s = new Student();
            s.incrementId(i);
            double cijfer = generator.nextDouble() * 9 + 1;

            s.setCijfer(cijfer);
//            studenten.add(s);
            studenten[i] = s;

        }

        int counter = 0;
        int klasNummer = 200;
        Klas klas = new Klas();
        List<Klas> klassen = new ArrayList();

        //Genereer klassnen.
        for (int i = 0; i < (int) aantalKlassen(studenten.length); i++) {

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

        counter = 0;

        //Voeg student toe aan de klassen.
        for (int i = 0; i < studenten.length; i++) {
            if (counter < klassen.size()) {
                studenten[i].setKlas(klassen.get(counter));
                klassen.get(counter).addStudent(studenten[i]);
                counter++;
                if (counter == klassen.size()) {
                    counter = 0;
                }
            }
        }

        ArrayList<Klas> nieuweKlassen = new ArrayList();
        ArrayList<Klas> legeKlassen = new ArrayList();

        //Lijst zonder null waarden.
        for (int i = 0; i < klassen.size(); i++) {

            Klas current = klassen.get(i);
            Student[] s = current.geefStudentenTerug();

            Klas k = new Klas(current.size());
            k.setKlas(current.getKlas());

            Klas leeg = new Klas(current.size());
            leeg.setKlas(current.getKlas());

            for (int j = 0; j < k.size(); j++) {
                k.addStudent(s[j]);
                System.out.println(s[j]);
            }

            nieuweKlassen.add(k);
            legeKlassen.add(leeg);

        }

        /* Geeft aantal de leerlingen terug per klas. 
         for (int i = 0; i < nieuweKlassen.size(); i++) {

         Klas k = nieuweKlassen.get(i);
         Student[] s = k.geefStudentenTerug();

         for (int j = 0; j < s.length; j++) {
         System.out.println("Student " + j + ": " + s[j]);
                
         }

         System.out.println("-----------");
         }
         */
        System.out.println();
        System.out.println("SHUFFLE");

        StdRandom.shuffle(studenten);
        
        Student[] lijstVoorCijfers = studenten;

        studenten = Sorting.insertionSortCijfer(studenten);
        
        System.out.println("Gesorteerd op cijfers:");
        
        for (Student s : lijstVoorCijfers) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Gesorteerd op ID en klas");
        
        Sorting.bucketSort(studenten, legeKlassen);
        
        for (Student s : studenten) {
            System.out.println(s);
        }
    }

}
