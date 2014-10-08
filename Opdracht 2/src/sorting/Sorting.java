/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;

import java.util.ArrayList;
import models.Klas;
import models.Student;

/**
 *
 * @author duytran
 */
public class Sorting {
    
    public static Student[] insertionSortCijfer(Student[] studenten) {
        
        double t1 = System.nanoTime();
        System.out.println("Aantal studenten: " + studenten.length);
        
        for (int i = 1; i < studenten.length; i++) {

            Student temp = studenten[i];
            int j = i;

            while (j > 0 && studenten[j - 1].getCijfer() < temp.getCijfer()) {

                studenten[j] = studenten[j - 1];

                j--;
            }

            studenten[j] = temp;

        }
        
        double t2 = System.nanoTime();
        
        System.out.println("Tijd benodigd = " + (t2-t1) / 1000000000);

        return studenten;
        
    }
    
    
    public static Klas insertionSortID(Klas bucket) {
        Student[] s = bucket.geefStudentenTerug();
        
        Klas k = new Klas(bucket.geefStudentenTerug().length);      
                
        for (int i = 0; i <s.length ; i++) {
            Student temp = s[i];
            int j = i;

            while (j > 0 && s[j - 1].getId()>temp.getId()) {

                s[j] = s[j - 1];

                j--;
            }

            s[j] = temp;

        }
        
        for (int i = 0; i < s.length; i++) {
            k.addStudent(s[i]);
        }
        
        return k;
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

        double t1 = System.nanoTime();
        
        Klas[] buckets = new Klas[klassen.size()];
    
        for (int i = 0; i < klassen.size(); i++) {
            buckets[i] = (Klas) klassen.get(i);
        }
        
        buckets = insertionSortKlas(buckets);
          
        for (int i = 0; i < buckets.length; i++) {
            
            for (int j = 0; j < studenten.length; j++) {
                
                if (studenten[j].getKlas().compareTo(buckets[i]) == 0) {
                    buckets[i].addStudent(studenten[j]);
                }
                
            }
            
            buckets[i] = insertionSortID(buckets[i]);
            
        }
       
//        for (int i = 0; i < buckets.length; i++) {
//            buckets[i] = insertionSortID(buckets[i]);
//        }
        
        int index = 0;
        
        for (int i = 0; i < buckets.length; i++) {
            
            Student[] s = buckets[i].geefStudentenTerug();
            
            for (int j = 0; j < s.length; j++) {
                studenten[index] = s[j];
                index++;
            }
            
        }
        
        double t2 = System.nanoTime();
        
        System.out.println("Tijd benodigd: " + (t2-t1) / 1000000000);
        
        return studenten;
        
        }
        
    }