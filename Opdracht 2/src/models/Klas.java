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
public class Klas implements Comparable<Klas> {

    private String klas = "I";
    private Student[] studenten;
    private int index;

    public Klas() {
        studenten = new Student[32];
        index = 0;
    }

    public Klas(int max) {

        if (max <= 32) {
            studenten = new Student[max];
        } else {
            System.out.println("Error");
        }
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

    public int size() {
        return index;
    }

    public Student[] geefStudentenTerug() {
        return studenten;
    }

    public void concatKlas(String klas) {
        this.klas += klas;
    }

    public void setKlas(String klas) {
        this.klas = klas;
    }

    @Override
    public int compareTo(Klas klas) {
        return this.getKlas().compareTo(klas.getKlas());
    }

}
