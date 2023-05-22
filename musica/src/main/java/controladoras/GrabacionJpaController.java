/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoras;

import controladoras.exceptions.NonexistentEntityException;
import entidades.Grabacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Instrumento;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class GrabacionJpaController implements Serializable {
    
    public GrabacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public GrabacionJpaController() {
        
        emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
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
            Instrumento idInstrumento = grabacion.getIdInstrumento();
            if (idInstrumento != null) {
                idInstrumento = em.getReference(idInstrumento.getClass(), idInstrumento.getIdInstrumento());
                grabacion.setIdInstrumento(idInstrumento);
            }
            em.persist(grabacion);
            if (idInstrumento != null) {
                idInstrumento.getGrabacionList().add(grabacion);
                idInstrumento = em.merge(idInstrumento);
            }
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
            Grabacion persistentGrabacion = em.find(Grabacion.class, grabacion.getIdGrabacion());
            Instrumento idInstrumentoOld = persistentGrabacion.getIdInstrumento();
            Instrumento idInstrumentoNew = grabacion.getIdInstrumento();
            if (idInstrumentoNew != null) {
                idInstrumentoNew = em.getReference(idInstrumentoNew.getClass(), idInstrumentoNew.getIdInstrumento());
                grabacion.setIdInstrumento(idInstrumentoNew);
            }
            grabacion = em.merge(grabacion);
            if (idInstrumentoOld != null && !idInstrumentoOld.equals(idInstrumentoNew)) {
                idInstrumentoOld.getGrabacionList().remove(grabacion);
                idInstrumentoOld = em.merge(idInstrumentoOld);
            }
            if (idInstrumentoNew != null && !idInstrumentoNew.equals(idInstrumentoOld)) {
                idInstrumentoNew.getGrabacionList().add(grabacion);
                idInstrumentoNew = em.merge(idInstrumentoNew);
            }
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
            Instrumento idInstrumento = grabacion.getIdInstrumento();
            if (idInstrumento != null) {
                idInstrumento.getGrabacionList().remove(grabacion);
                idInstrumento = em.merge(idInstrumento);
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

    // busqueda usando name query para los musicos----buscamos por nombre
    public Grabacion encontraGrabaciTitulo(String titulo) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Grabacion.findByTitulo");
        q.setParameter("titulo", titulo);
        return (Grabacion) q.getSingleResult();
        
    }

    // busqueda por fecha
    
    public Grabacion encontraGrabaciFecha(LocalDate fecha) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Grabacion.findByFecha");
        q.setParameter("fecha", Utilidades.Utilidades.LocalADate(fecha));
        return (Grabacion) q.getSingleResult();
        
    }
}
