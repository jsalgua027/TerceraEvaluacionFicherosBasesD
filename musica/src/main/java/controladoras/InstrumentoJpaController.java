/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoras;

import controladoras.exceptions.NonexistentEntityException;
import entidades.musica.Instrumento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author nacho
 */
public class InstrumentoJpaController implements Serializable {

    public InstrumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public InstrumentoJpaController() {

        emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Instrumento instrumento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(instrumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Instrumento instrumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            instrumento = em.merge(instrumento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = instrumento.getIdInstrumento();
                if (findInstrumento(id) == null) {
                    throw new NonexistentEntityException("The instrumento with id " + id + " no longer exists.");
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
            Instrumento instrumento;
            try {
                instrumento = em.getReference(Instrumento.class, id);
                instrumento.getIdInstrumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The instrumento with id " + id + " no longer exists.", enfe);
            }
            em.remove(instrumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Instrumento> findInstrumentoEntities() {
        return findInstrumentoEntities(true, -1, -1);
    }

    public List<Instrumento> findInstrumentoEntities(int maxResults, int firstResult) {
        return findInstrumentoEntities(false, maxResults, firstResult);
    }

    private List<Instrumento> findInstrumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Instrumento.class));
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

    public Instrumento findInstrumento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Instrumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getInstrumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Instrumento> rt = cq.from(Instrumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
