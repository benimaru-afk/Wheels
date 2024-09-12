package pack1;

import java.util.ArrayList;
public class Customers {
    private ArrayList<Customer> Customers = new ArrayList<>();
    
    public Customer searchCustomer(String name){
        for (Customer c : Customers){
            if (c.getName().equals(name)){
                return c;
            } 
        }
        return null;
    }
    public void addCustomer(Customer newCustomer){
        if (searchCustomer(newCustomer.getName()) != null){
            return;
        }
        Customers.add(newCustomer);
    }
    public void removeCustomer(Customer delCustomer){
        Customers.remove(delCustomer);
    }
}
