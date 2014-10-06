/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author duytran
 */
public class Klas {

    private String klas = "I";
    private Student[] studenten;
    private Student[] lijstZonderNull;
    private int index = 0;
    private int index2 = 0;
    
    public Klas() {
        studenten = new Student[32];
    }
    
    public Klas(int max) {
        lijstZonderNull = new Student[max];
    }

    public String getKlas() {
        return klas;
    }

    public void addStudent(Student student) {

        if (index == studenten.length) {
            System.out.println("klas is vol.");
        } else {
            studenten[index] = student;
            index++;
        }
        
    }
    
    public void addStudentToNewList(Student student) {
        
        if (index2 == lijstZonderNull.length) {
            System.out.println("klas is vol.");
        } else {
            lijstZonderNull[index2] = student;
            index2++;
        }
        
    }

    public int size() {
        
        return index;
        
    }
    
    
    public Student[] geefStudentenTerug(){
        return studenten;
    }
    
    public Student[] geefStudentenZonderNullTerug() {
        return lijstZonderNull;
    }
            
    public void setKlas(String klas) {
        this.klas += klas;
    }
    
    public void print() {
        for (int i = 0; i < studenten.length; i++) {
            System.out.println(studenten[i]);
        }
    }

}
