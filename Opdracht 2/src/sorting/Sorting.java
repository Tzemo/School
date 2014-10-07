/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;

import java.util.ArrayList;
import java.util.List;
import models.Klas;
import models.Student;

/**
 *
 * @author duytran
 */
public class Sorting {
    
    public static Student[] insertionSort(Student[] studenten) {

        
        for (int i = 1; i < studenten.length; i++) {

            Student temp = studenten[i];
            int j = i;

            while (j > 0 && studenten[j - 1].getCijfer() < temp.getCijfer()) {

                studenten[j] = studenten[j - 1];

                j--;
            }

            studenten[j] = temp;

        }

        return studenten;
        
    }
    
    public static void bucketSort(Student[] studenten, List klassen) {

        int[] buckets = new int[klassen.size()];
        
        System.out.println(klassen.size());
        
        for (int i = 1; i < studenten.length; i++) {
            
            if (studenten[i].getKlas().compareTo(studenten[i-1].getKlas()) == 0) {
                
//                System.out.println(studenten[i].getId() + " zit in dezelfde klas als " +studenten[i-1].getId());
                
            } 
            
            
            
            
        }
        
    }
     
        
        
}
