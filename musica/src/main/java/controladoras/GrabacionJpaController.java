/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoras;

import controladoras.exceptions.NonexistentEntityException;
import entidades.musica.Grabacion;
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
public class GrabacionJpaController implements Serializable {

    public GrabacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public GrabacionJpaController() {

        emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU"); //com.mycompany_musica_jar_1.0-SNAPSHOTPU
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Grabacion grabacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(grabacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Grabacion grabacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            grabacion = em.merge(grabacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = grabacion.getIdGrabacion();
                if (findGrabacion(id) == null) {
                    throw new NonexistentEntityException("The grabacion with id " + id + " no longer exists.");
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
            Grabacion grabacion;
            try {
                grabacion = em.getReference(Grabacion.class, id);
                grabacion.getIdGrabacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grabacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(grabacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Grabacion> findGrabacionEntities() {
        return findGrabacionEntities(true, -1, -1);
    }

    public List<Grabacion> findGrabacionEntities(int maxResults, int firstResult) {
        return findGrabacionEntities(false, maxResults, firstResult);
    }

    private List<Grabacion> findGrabacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Grabacion.class));
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

    public Grabacion findGrabacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Grabacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getGrabacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Grabacion> rt = cq.from(Grabacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
