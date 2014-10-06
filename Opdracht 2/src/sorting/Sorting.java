/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;

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
    
    public static void bucketSort(Student[] studenten, int elementen) {
        
        
        if (elementen <= 0) {
           return;
        }

        Student s = studenten[0];
        Student x = studenten[5];
        
        System.out.println(s.getKlas().getKlas());
        System.out.println(x.getKlas().getKlas());
        System.out.println(s.getKlas().compareTo(x.getKlas()));

//        for (int i = 0; i < elementen; i++) {
//            if (studenten[i].getKlas().getKlas().compareTo(last.getKlas().getKlas()) >= 1 ) {
//                last = studenten[i];
//            } else {
//                first = studenten[i];
//            }
//        }
       
    }
    
}
