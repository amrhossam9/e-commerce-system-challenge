/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce.system;

import e.commerce.system.interfaces.Shippable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class ShippingService{
        
    public static void ship(List<Shippable> shippableItems) {
        System.out.println("** Shipment notice **");
        Map<String, Integer> countMap = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : shippableItems) {
            String name = item.getName();
            double weight = item.getWeight();

            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            totalWeight += weight;
        }
        
        for (Shippable item : shippableItems) {  
            String name = item.getName();
            int count = countMap.get(name);
            double weight = item.getWeight() * count;
            
            System.out.printf("%dx %s %.1fKg\n", count, name, weight);
        }
        
        System.out.printf("\nTotal package weight %.1fkg", totalWeight);
    }
    
}
