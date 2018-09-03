/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

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
public class DiscountCodeManager implements DiscountCodeManagerLocal {

    @PersistenceContext(unitName = "TP1CustomerApplication-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }


    @Override
    public List<entities.DiscountCode> getDiscountCodes() {
        Query query = em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }
}
