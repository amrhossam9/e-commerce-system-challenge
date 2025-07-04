/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce.system;

import e.commerce.system.interfaces.Shippable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }
    
    public void checkout(Cart cart) throws Exception {
        
        if(cart.isEmpty()) {
            throw new Exception("Cart is Empty");
        }
        
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product instanceof Shippable) {
                shippableItems.add((Shippable) product);
            }
        }
        
        ShippingService.ship(shippableItems);
        
        checkoutReceipt(cart);
        
        System.out.printf("Your current balance %.1f\n", this.balance);
    }
    
    public void checkoutReceipt(Cart cart) throws Exception {
        System.out.println("\n\n** Checkout receipt **");
        double subtotal = 0.0, shipping = 0.0, amt;
        
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            subtotal += (product.getPrice() * item.getQuantity());
        }
        shipping = subtotal*0.15;
        amt = subtotal + shipping;
        
        if(amt > this.balance) {
            throw new Exception("No Enough balance");
        }
        
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            product.reduceQuantity(item.getQuantity());
            System.out.printf("%dx %s %.1f\n", item.getQuantity(), product.getName(), product.getPrice()*item.getQuantity());
        }
        
        
        System.out.println("\n------------------------------\n");
        System.out.printf("Subtotal       %.1f\n", subtotal);
        System.out.printf("Shipping       %.1f\n", shipping);
        System.out.printf("Amount         %.1f\n", amt);
        this.balance -= amt;       
    }
}
