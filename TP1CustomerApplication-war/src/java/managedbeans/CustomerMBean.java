/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import sessions.CustomerManagerLocal;

/**
 *
 * @author cmduquer
 */
@Named(value = "customerMBean")
@SessionScoped
public class CustomerMBean implements Serializable {

    @EJB
    private CustomerManagerLocal customerManager;
    
    private Customer customer;
    private List<Customer> customers;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Customer> getCustomers() {
        if(customers == null || customers.isEmpty()){
            this.refresh();
        }
        return customers;
    }
    
    private void refresh(){
        customers = customerManager.getAllCustomers();
    }
    
    public String update(){
        System.out.println("managedbeans.CustomerMBean.update() " + "###UPDATE###");
        customer = customerManager.update(customer);
        return "Customer Update";
    }
    
    
    
    
    
}
