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
    
    public static void bucketSort(Student[] studenten) {

        
        
        for (Student s : studenten) {
            
            
            
        }
        
    }
     
        
        
}
