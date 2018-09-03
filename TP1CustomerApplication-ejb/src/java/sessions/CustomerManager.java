/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Customer;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cmduquer
 */
@Stateless
@LocalBean
public class CustomerManager implements CustomerManagerLocal {

    @PersistenceContext(unitName = "TP1CustomerApplication-ejbPU")
    private EntityManager em;

    @Override
    public List<entities.Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    @Override
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
}
