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
public class Student {
    
    private int id;
    private double cijfer;
    private Klas klas;

    public Student(int id, double cijfer, Klas klas) {
        this.id = id;
        this.cijfer = cijfer;
        this.klas = klas;
    }
    
}
