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
public class Klas implements Comparable<Klas>{

    private String klas = "I";
    private Student[] studenten;
    
    //Zal een array bevatten zonder Null waarden.
    private Student[] lijstZonderNull;
    private int index;
    
    public Klas() {
        studenten = new Student[32];
        index = 0;
    }
    
    public Klas(int max) {
        lijstZonderNull = new Student[max];
        index = 0;
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
        
        if (index == lijstZonderNull.length) {
            System.out.println("klas is vol.");
        } else {
            lijstZonderNull[index] = student;
            index++;
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

    @Override
    public int compareTo(Klas o) {
        return this.getKlas().compareTo(o.getKlas());
    }

}
