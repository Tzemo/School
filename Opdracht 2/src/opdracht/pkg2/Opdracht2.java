package opdracht.pkg2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.Klas;
import models.Student;
import nl.hva.dmci.ict.inf.ads.lib.StdRandom;
import sorting.Sorting;

/**
 * @author duytran, tzemochan
 */
public class Opdracht2 {

    public static double aantalKlassen(int aantalStudenten) {

        double aantalKlassen = ((double) aantalStudenten / 32) / 4;

        return Math.ceil(aantalKlassen) * 4;

    }

    public static Klas geefKlas(int sectie, int klasNummer) {

        Klas klas = new Klas();

        switch (sectie) {

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
                System.out.println("Geen klas beschikbaar.");
                break;

        }

        return klas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random generator = new Random();
        final int AANTAL_LEERLINGEN = 800;
        Student[] studenten = new Student[AANTAL_LEERLINGEN];

        //Maak studenten aan
        for (int i = 0; i < studenten.length; i++) {
            Student s = new Student();
            s.incrementId(i);
            double cijfer = generator.nextDouble() * 9 + 1;
            s.setCijfer(cijfer);
            studenten[i] = s;

        }

        int counter = 0;
        int klasNummer = 200;
        Klas klas = new Klas();
        List<Klas> klassen = new ArrayList();

        //Genereer klassen.
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

        ArrayList<Klas> legeKlassen = new ArrayList();

        for (int i = 0; i < klassen.size(); i++) {

            Klas current = klassen.get(i);
            Student[] s = current.geefStudentenTerug();
            
            Klas leeg = new Klas(current.size());
            leeg.setKlas(current.getKlas());

            legeKlassen.add(leeg);

        }
      
        System.out.println();
        System.out.println("SHUFFLE");

        StdRandom.shuffle(studenten);

        studenten = Sorting.insertionSortCijfer(studenten);
        
        System.out.println("Gesorteerd op cijfers:");
        
        for (Student s : studenten) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Gesorteerd op ID en klas");
        System.out.println("Aantal studenten:" + studenten.length);
        Sorting.bucketSort(studenten, legeKlassen);
        
        for (Student s : studenten) {
            System.out.println(s);
        }
    }

}
