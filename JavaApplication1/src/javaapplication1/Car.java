/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author celalberkeakyol
 */
public class Car {
    String brand;
    String model; 
    int year; 
    
    public Car(String brand, String model, int year){
        this.brand = brand; 
        this.model = model;
        this.year = year; 
    }
    public void displayInfo(){
        System.out.println("Brand "+ brand);
        System.out.println("model "+ model);
        System.out.println("year "+ year);
    }
}
