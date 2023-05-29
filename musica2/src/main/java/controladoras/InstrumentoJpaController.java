/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoras;

import controladoras.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Musico;
import entidades.Grabacion;
import entidades.Instrumento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Windows10
 */
public class InstrumentoJpaController implements Serializable {

    public InstrumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
      public InstrumentoJpaController() {
        
        emf = Persistence.createEntityManagerFactory("com.mycompany_musica2_jar_1.0-SNAPSHOTPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Instrumento instrumento) {
        if (instrumento.getGrabacionList() == null) {
            instrumento.setGrabacionList(new ArrayList<Grabacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Musico idMusico = instrumento.getIdMusico();
            if (idMusico != null) {
                idMusico = em.getReference(idMusico.getClass(), idMusico.getIdMusico());
                instrumento.setIdMusico(idMusico);
            }
            List<Grabacion> attachedGrabacionList = new ArrayList<Grabacion>();
            for (Grabacion grabacionListGrabacionToAttach : instrumento.getGrabacionList()) {
                grabacionListGrabacionToAttach = em.getReference(grabacionListGrabacionToAttach.getClass(), grabacionListGrabacionToAttach.getIdGrabacion());
                attachedGrabacionList.add(grabacionListGrabacionToAttach);
            }
            instrumento.setGrabacionList(attachedGrabacionList);
            em.persist(instrumento);
            if (idMusico != null) {
                Instrumento oldInstrumentoOfIdMusico = idMusico.getInstrumento();
                if (oldInstrumentoOfIdMusico != null) {
                    oldInstrumentoOfIdMusico.setIdMusico(null);
                    oldInstrumentoOfIdMusico = em.merge(oldInstrumentoOfIdMusico);
                }
                idMusico.setInstrumento(instrumento);
                idMusico = em.merge(idMusico);
            }
            for (Grabacion grabacionListGrabacion : instrumento.getGrabacionList()) {
                Instrumento oldIdInstrumentoOfGrabacionListGrabacion = grabacionListGrabacion.getIdInstrumento();
                grabacionListGrabacion.setIdInstrumento(instrumento);
                grabacionListGrabacion = em.merge(grabacionListGrabacion);
                if (oldIdInstrumentoOfGrabacionListGrabacion != null) {
                    oldIdInstrumentoOfGrabacionListGrabacion.getGrabacionList().remove(grabacionListGrabacion);
                    oldIdInstrumentoOfGrabacionListGrabacion = em.merge(oldIdInstrumentoOfGrabacionListGrabacion);
                }
            }
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
            Instrumento persistentInstrumento = em.find(Instrumento.class, instrumento.getIdInstrumento());
            Musico idMusicoOld = persistentInstrumento.getIdMusico();
            Musico idMusicoNew = instrumento.getIdMusico();
            List<Grabacion> grabacionListOld = persistentInstrumento.getGrabacionList();
            List<Grabacion> grabacionListNew = instrumento.getGrabacionList();
            if (idMusicoNew != null) {
                idMusicoNew = em.getReference(idMusicoNew.getClass(), idMusicoNew.getIdMusico());
                instrumento.setIdMusico(idMusicoNew);
            }
            List<Grabacion> attachedGrabacionListNew = new ArrayList<Grabacion>();
            for (Grabacion grabacionListNewGrabacionToAttach : grabacionListNew) {
                grabacionListNewGrabacionToAttach = em.getReference(grabacionListNewGrabacionToAttach.getClass(), grabacionListNewGrabacionToAttach.getIdGrabacion());
                attachedGrabacionListNew.add(grabacionListNewGrabacionToAttach);
            }
            grabacionListNew = attachedGrabacionListNew;
            instrumento.setGrabacionList(grabacionListNew);
            instrumento = em.merge(instrumento);
            if (idMusicoOld != null && !idMusicoOld.equals(idMusicoNew)) {
                idMusicoOld.setInstrumento(null);
                idMusicoOld = em.merge(idMusicoOld);
            }
            if (idMusicoNew != null && !idMusicoNew.equals(idMusicoOld)) {
                Instrumento oldInstrumentoOfIdMusico = idMusicoNew.getInstrumento();
                if (oldInstrumentoOfIdMusico != null) {
                    oldInstrumentoOfIdMusico.setIdMusico(null);
                    oldInstrumentoOfIdMusico = em.merge(oldInstrumentoOfIdMusico);
                }
                idMusicoNew.setInstrumento(instrumento);
                idMusicoNew = em.merge(idMusicoNew);
            }
            for (Grabacion grabacionListOldGrabacion : grabacionListOld) {
                if (!grabacionListNew.contains(grabacionListOldGrabacion)) {
                    grabacionListOldGrabacion.setIdInstrumento(null);
                    grabacionListOldGrabacion = em.merge(grabacionListOldGrabacion);
                }
            }
            for (Grabacion grabacionListNewGrabacion : grabacionListNew) {
                if (!grabacionListOld.contains(grabacionListNewGrabacion)) {
                    Instrumento oldIdInstrumentoOfGrabacionListNewGrabacion = grabacionListNewGrabacion.getIdInstrumento();
                    grabacionListNewGrabacion.setIdInstrumento(instrumento);
                    grabacionListNewGrabacion = em.merge(grabacionListNewGrabacion);
                    if (oldIdInstrumentoOfGrabacionListNewGrabacion != null && !oldIdInstrumentoOfGrabacionListNewGrabacion.equals(instrumento)) {
                        oldIdInstrumentoOfGrabacionListNewGrabacion.getGrabacionList().remove(grabacionListNewGrabacion);
                        oldIdInstrumentoOfGrabacionListNewGrabacion = em.merge(oldIdInstrumentoOfGrabacionListNewGrabacion);
                    }
                }
            }
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
            Musico idMusico = instrumento.getIdMusico();
            if (idMusico != null) {
                idMusico.setInstrumento(null);
                idMusico = em.merge(idMusico);
            }
            List<Grabacion> grabacionList = instrumento.getGrabacionList();
            for (Grabacion grabacionListGrabacion : grabacionList) {
                grabacionListGrabacion.setIdInstrumento(null);
                grabacionListGrabacion = em.merge(grabacionListGrabacion);
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
    
     // busqueda usando name query para los instrumentos----buscamos por nombre

    public Instrumento encontraInstrumentoNombre(String nombre) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Instrumento.findByNombre");
        q.setParameter("nombre", nombre);
        return (Instrumento) q.getSingleResult();

    }
    // busqueda usando name query para los instrumentos----buscamos por tipo

    public Instrumento encontraInstrumentoTipo(String tipo) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Instrumento.findByTipo");
        q.setParameter("tipo", tipo);
        return (Instrumento) q.getSingleResult();

    }

    
    
}
