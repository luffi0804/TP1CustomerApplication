/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cmduquer
 */
@Local
public interface DiscountCodeManagerLocal {

    List<entities.DiscountCode> getDiscountCodes();
    
}
