/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;


import entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Casa
 */
@Stateless
@LocalBean
public class CustomerManager {
    @PersistenceContext(unitName = "TP1CustomerApplication-ejbPU")
    private EntityManager em;

    public List<Customer> getAllCustomer() {
        Query query = (Query) em.createNamedQuery("customer.findAll");
        return query.resulLIst();
    }

    public Customer updateCustomer(Customer customer){
        Customer c =em.merge(customer);
        return c;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    private static class Query {

        public Query() {
        }

        private List<Customer> resulLIst() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    

