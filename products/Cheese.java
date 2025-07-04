/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce.system.products;

import e.commerce.system.Product;
import e.commerce.system.interfaces.Expirable;
import e.commerce.system.interfaces.Shippable;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Cheese extends Product implements Shippable, Expirable{

    private double weight;
    private LocalDate expirationDate; 
    
    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpired() {
        return (expirationDate.isBefore(LocalDate.now()));
    }

    public Cheese(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }
    
}
