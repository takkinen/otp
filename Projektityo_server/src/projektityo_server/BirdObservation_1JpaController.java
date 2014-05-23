/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektityo_server;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import projektityo_server.exceptions.NonexistentEntityException;

/**
 *
 * @author henri
 */
public class BirdObservation_1JpaController implements Serializable {

    public BirdObservation_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BirdObservation_1 birdObservation_1) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(birdObservation_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BirdObservation_1 birdObservation_1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            birdObservation_1 = em.merge(birdObservation_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = birdObservation_1.getId();
                if (findBirdObservation_1(id) == null) {
                    throw new NonexistentEntityException("The birdObservation_1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BirdObservation_1 birdObservation_1;
            try {
                birdObservation_1 = em.getReference(BirdObservation_1.class, id);
                birdObservation_1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The birdObservation_1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(birdObservation_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BirdObservation_1> findBirdObservation_1Entities() {
        return findBirdObservation_1Entities(true, -1, -1);
    }

    public List<BirdObservation_1> findBirdObservation_1Entities(int maxResults, int firstResult) {
        return findBirdObservation_1Entities(false, maxResults, firstResult);
    }

    private List<BirdObservation_1> findBirdObservation_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BirdObservation_1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public BirdObservation_1 findBirdObservation_1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BirdObservation_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getBirdObservation_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BirdObservation_1> rt = cq.from(BirdObservation_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
