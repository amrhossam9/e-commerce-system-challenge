/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e.commerce.system;

import java.time.LocalDate;
import e.commerce.system.products.Biscuits;
import e.commerce.system.products.Cheese;
import e.commerce.system.products.Mobile;
import e.commerce.system.products.ScratchCard;
import e.commerce.system.products.TV;

/**
 *
 * @author user
 */
public class ECommerceSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Customer customer = new Customer("Ahmed", 4500);
        Product Cheese = new Cheese("Cheese", 50, 10, 2, LocalDate.of(2025, 9, 25));
        Product TV = new TV("TV", 1500, 5, 10);
        Product Mobile = new Mobile("Mobile", 1500, 5, 10);
        Product ScratchCard = new ScratchCard("ScratchCard", 100, 30);
        Product Biscuits = new Biscuits("Biscuits", 5, 60, 0.2, LocalDate.of(2025, 9, 25));
        
        Cart cart = new Cart();
        try {
            cart.addItem(Cheese, 5);
            cart.addItem(TV, 1);
            cart.addItem(ScratchCard, 5);
            cart.addItem(Mobile, 1);
            cart.addItem(Biscuits, 1);
            customer.checkout(cart);            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
