
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
            int value = Math.abs(studentArray[i].hashCode() %97);
            hashValues.add(value);
            
        }
        
        //Maakt een (Hash)Set aan met unieke waardes
        Set<Integer> uniqueValues = new HashSet(hashValues);
        
        //De frequentie
        int freq = 0;
        int sum = 0;
        
        for (int value : uniqueValues) {
            
            System.out.print("Hashvalue: " + value);
            for (int i = 0; i < hashValues.size(); i++) {
                if (value == hashValues.get(i)) {
                    freq++;
                }
                
            }
            
            System.out.println("\t freq " + freq);
            sum += freq;
            
            //De frequentie moet weer op 0 zodat we opnieuw kunnen tellen bij de andere values.
            freq = 0;
            
        }
        
        System.out.println("Gemiddelde is " + sum / 96);
        
        SeperateChainingHashST sc = new SeperateChainingHashST();
        LinearProbing lp = new LinearProbing();
        QuadraticProbing qp = new QuadraticProbing();
        
  
        for (int i = 0; i < studentArray.length; i++) {

//            String key = studentArray[i].getLdap();
            Student key = studentArray[i];
            int value = studentArray[i].getEcts();
            
            sc.put(key, value);
            lp.put(key, value);
            qp.put(key, value);

        } 
       
        for (int i = 0; i < studentArray.length; i++) {
            
            sc.printCollisionsForKey(i);
            
        }
        
        int firstKey = sc.firstKey();

        lp.printCol();
        qp.printCol();
//        sc.printCollisionsForKey(firstKey);
        System.out.println("Separate Chaining Collisions: " + sc.printCol());
    }
    
}
