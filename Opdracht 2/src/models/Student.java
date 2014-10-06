/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.text.DecimalFormat;

/**
 *
 * @author duytran
 */
public class Student {
    
    private DecimalFormat formatter = new DecimalFormat("#.0");
    private int id = 50060001;
    private double cijfer;

    
    private Klas klas;
    
    
    public Student() {
   
    }

    public int getId() {
        return id;
    }

    public void incrementId(int id) {
        this.id += id;
    }

    public double getCijfer() {
        
        formatter.format(cijfer);
        
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        
        formatter.format(cijfer);
        this.cijfer = cijfer;
    }

    public Klas getKlas() {
        return klas;
    }

    public void setKlas(Klas klas) {
        this.klas = klas;
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", cijfer=" + formatter.format(cijfer) +  ", klas=" + klas.getKlas() +'}';
    }
    
}
