/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce.system;

import e.commerce.system.interfaces.Expirable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Cart {
    
    private List<CartItem> items;
    
    public void addItem(Product product, int quantity) throws Exception {
        CartItem newItem;
        if(product.getQuantity() < quantity) {
            throw new Exception("Product is out of stock");
        } else if ((product instanceof Expirable) && ((Expirable) product).isExpired()) {
            throw new Exception("Product is Expired");
        } else {
            newItem = new CartItem(product, quantity);
            items.add(newItem);
        }
    }

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public void clearItems() {
        items.clear();
    }
}
