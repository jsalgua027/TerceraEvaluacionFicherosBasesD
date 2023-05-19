/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoras;

import controladoras.exceptions.NonexistentEntityException;
import entidades.Biografia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Musico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class BiografiaJpaController implements Serializable {

    public BiografiaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public BiografiaJpaController(){
      
      emf= Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
      }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Biografia biografia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Musico idMusico = biografia.getIdMusico();
            if (idMusico != null) {
                idMusico = em.getReference(idMusico.getClass(), idMusico.getIdMusico());
                biografia.setIdMusico(idMusico);
            }
            em.persist(biografia);
            if (idMusico != null) {
                Biografia oldBiografiaOfIdMusico = idMusico.getBiografia();
                if (oldBiografiaOfIdMusico != null) {
                    oldBiografiaOfIdMusico.setIdMusico(null);
                    oldBiografiaOfIdMusico = em.merge(oldBiografiaOfIdMusico);
                }
                idMusico.setBiografia(biografia);
                idMusico = em.merge(idMusico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Biografia biografia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Biografia persistentBiografia = em.find(Biografia.class, biografia.getIdBiografia());
            Musico idMusicoOld = persistentBiografia.getIdMusico();
            Musico idMusicoNew = biografia.getIdMusico();
            if (idMusicoNew != null) {
                idMusicoNew = em.getReference(idMusicoNew.getClass(), idMusicoNew.getIdMusico());
                biografia.setIdMusico(idMusicoNew);
            }
            biografia = em.merge(biografia);
            if (idMusicoOld != null && !idMusicoOld.equals(idMusicoNew)) {
                idMusicoOld.setBiografia(null);
                idMusicoOld = em.merge(idMusicoOld);
            }
            if (idMusicoNew != null && !idMusicoNew.equals(idMusicoOld)) {
                Biografia oldBiografiaOfIdMusico = idMusicoNew.getBiografia();
                if (oldBiografiaOfIdMusico != null) {
                    oldBiografiaOfIdMusico.setIdMusico(null);
                    oldBiografiaOfIdMusico = em.merge(oldBiografiaOfIdMusico);
                }
                idMusicoNew.setBiografia(biografia);
                idMusicoNew = em.merge(idMusicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = biografia.getIdBiografia();
                if (findBiografia(id) == null) {
                    throw new NonexistentEntityException("The biografia with id " + id + " no longer exists.");
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
            Biografia biografia;
            try {
                biografia = em.getReference(Biografia.class, id);
                biografia.getIdBiografia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The biografia with id " + id + " no longer exists.", enfe);
            }
            Musico idMusico = biografia.getIdMusico();
            if (idMusico != null) {
                idMusico.setBiografia(null);
                idMusico = em.merge(idMusico);
            }
            em.remove(biografia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Biografia> findBiografiaEntities() {
        return findBiografiaEntities(true, -1, -1);
    }

    public List<Biografia> findBiografiaEntities(int maxResults, int firstResult) {
        return findBiografiaEntities(false, maxResults, firstResult);
    }

    private List<Biografia> findBiografiaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Biografia.class));
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

    public Biografia findBiografia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Biografia.class, id);
        } finally {
            em.close();
        }
    }

    public int getBiografiaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Biografia> rt = cq.from(Biografia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
