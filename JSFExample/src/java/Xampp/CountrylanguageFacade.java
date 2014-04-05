/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Xampp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fotakkihe
 */
@Stateless
public class CountrylanguageFacade extends AbstractFacade<Countrylanguage> {
    @PersistenceContext(unitName = "JSFExamplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountrylanguageFacade() {
        super(Countrylanguage.class);
    }
    
}
