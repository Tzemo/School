/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author duytran
 */
public class Klas {

    private String klas = "I";
//    private Student[] studenten = new Student[32];
    private ArrayList<Student> studentenLijst = new ArrayList();
    private int index = 0;
    private int size = 0;

    public String getKlas() {
        return klas;
    }

    public void addStudent(Student student) {

//        if (index == studenten.length) {
//            System.out.println("klas is vol.");
//        } else {
//            studenten[index] = student;
            index++;
            size++;
//
//        }
        
        if (studentenLijst.size() == 32) {
            System.out.println("rot maar op");
        } else {
            studentenLijst.add(student);
        }
        
    }

    public int size() {
        
        return size;
        
    }
    
    
    public ArrayList geefStudentenTerug(){
        return studentenLijst;
    }
            
    public void setKlas(String klas) {
        this.klas += klas;
    }
    
    public void print() {
        for (int i = 0; i < studentenLijst.size(); i++) {
            System.out.println(studentenLijst.get(i));
        }
    }

}
