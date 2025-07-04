/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce.system.products;

import e.commerce.system.Product;
import e.commerce.system.interfaces.Shippable;

/**
 *
 * @author user
 */
public class TV extends Product implements Shippable {

    private double weight;
    
    @Override
    public double getWeight() {
        return weight;
    }

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    
}
