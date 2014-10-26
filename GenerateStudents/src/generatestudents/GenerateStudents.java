
package generatestudents;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author breud
 */
public class GenerateStudents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //In de Student klas zit een hashCode method die we zelf moesten schrijven.
        //Hiermee halen we de Integer waarde op van een String literal.
        //De klasses GenerateStudents, StudentList en Student werden cadeau gegeven door school.
        StudentList students = new StudentList(10000);
        
//        System.out.println(students);
        
        //Haalt de array op van het object students.
        Student[] studentArray = students.getList();

        List<Integer> hashValues = new ArrayList();
        
        //Math.abs voor de absolute waarde van de hashcode die niet altijd positief is.
        //Modulo 97 staat in de opdracht waarom we dat doen.
        
        for (int i = 0; i < studentArray.length; i++) {
            int value = Math.abs(studentArray[i].hashCode() % 97);
            
            hashValues.add(value);
            
        }
        
        //Maakt een (Hash)Set aan met unieke waardes
        Set<Integer> uniqueValues = new HashSet(hashValues);
        
        //De frequentie
        int freq = 0;
        
 /*     Oude frequentie manier
        
        for (int i = 0; i < hashValues.size(); i++) {
            System.out.print("Hashvalue: " + hashValues.get(i));
            for (int j = 0; j < hashValues.size(); j++) {
                if (hashValues.get(i) == hashValues.get(j)) {
                    freq++;
                }
                    
            }
            System.out.println("\t freq: " + freq);
            freq = 0;
        }
        
*/       
        
        //Snellere frequentie manier
        for (int value : uniqueValues) {
            
            System.out.print("Hashvalue: " + value);
            for (int i = 0; i < hashValues.size(); i++) {
                if (value == hashValues.get(i)) {
                    ++freq;
                }
            }
            
            System.out.println("\t freq " + freq);
            
            //De frequentie moet weer op 0 zodat we opnieuw kunnen tellen bij de andere values.
            freq = 0;
            
        }
        
        SeperateChainingHashST sc = new SeperateChainingHashST();
    
        for (int i = 0; i < studentArray.length; i++) {
            int key = Math.abs(studentArray[i].hashCode() % 97);
            String value = studentArray[i].getLdap();
            
            sc.put(key, value);
            
            
        }

        sc.getAll(60);

    }
    
}
