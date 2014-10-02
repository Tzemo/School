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
        
        
        for (int i = 0; i < 10; i++) {
            
        }
        
        int counter = 0;
        int klasNummer = 200;
        Klas klas = new Klas();
        List<Klas> klassen = new ArrayList();

        for (int i = 0; i < (int) aantalKlassen(800); i++) {

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

//        int i = 1;
//
//        for (Klas k : klassen) {
//            System.out.print(i + " ");
//            System.out.println(k.getKlas());
//            i++;
//        }

    }

}
