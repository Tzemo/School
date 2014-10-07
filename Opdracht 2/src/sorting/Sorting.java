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
    
    public static Klas[] insertionSortKlas(Klas[] klassen) {
        
        for (int i = 1; i < klassen.length; i++) {
            
            Klas temp = klassen[i];
            int j = i;
            
            while (j > 0 && klassen[j-1].getKlas().compareTo(temp.getKlas()) > 0) {

                klassen[j] = klassen[j - 1];

                j--;
            }
            
            klassen[j] = temp;
        }
        
        return klassen;
        
    }
    
    public static Student[] bucketSort(Student[] studenten, ArrayList klassen) {

        Klas[] buckets = new Klas[klassen.size()];
    
        for (int i = 0; i < klassen.size(); i++) {
            buckets[i] = (Klas) klassen.get(i);
        }
        
        buckets = insertionSortKlas(buckets);
        
        for (int i = 0; i < buckets.length; i++) {
            System.out.println(buckets[i].getKlas());
        }
  
        for (int i = 0; i < buckets.length; i++) {
            
            for (int j = 0; j < studenten.length; j++) {
                
                if (studenten[j].getKlas().compareTo(buckets[i]) == 0) {
                    buckets[i].addStudent(studenten[j]);
                }
                
            }
            
        }
        
        int index = 0;
        
        for (int i = 0; i < buckets.length; i++) {
            
            Student[] s = buckets[i].geefStudentenTerug();
            
            for (int j = 0; j < s.length; j++) {
                studenten[index] = s[j];
                index++;
            }
            
        }
        
        return studenten;
        
        }
        
    }
     
        
        

