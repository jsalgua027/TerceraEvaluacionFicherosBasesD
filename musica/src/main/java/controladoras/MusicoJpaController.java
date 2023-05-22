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
import entidades.Instrumento;
import entidades.Biografia;
import entidades.Musico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class MusicoJpaController implements Serializable {

    public MusicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MusicoJpaController() {

        emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Musico musico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Instrumento idInstrumento = musico.getIdInstrumento();
            if (idInstrumento != null) {
                idInstrumento = em.getReference(idInstrumento.getClass(), idInstrumento.getIdInstrumento());
                musico.setIdInstrumento(idInstrumento);
            }
            Biografia biografia = musico.getBiografia();
            if (biografia != null) {
                biografia = em.getReference(biografia.getClass(), biografia.getIdBiografia());
                musico.setBiografia(biografia);
            }
            em.persist(musico);
            if (idInstrumento != null) {
                idInstrumento.getMusicoList().add(musico);
                idInstrumento = em.merge(idInstrumento);
            }
            if (biografia != null) {
                Musico oldIdMusicoOfBiografia = biografia.getIdMusico();
                if (oldIdMusicoOfBiografia != null) {
                    oldIdMusicoOfBiografia.setBiografia(null);
                    oldIdMusicoOfBiografia = em.merge(oldIdMusicoOfBiografia);
                }
                biografia.setIdMusico(musico);
                biografia = em.merge(biografia);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Musico musico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Musico persistentMusico = em.find(Musico.class, musico.getIdMusico());
            Instrumento idInstrumentoOld = persistentMusico.getIdInstrumento();
            Instrumento idInstrumentoNew = musico.getIdInstrumento();
            Biografia biografiaOld = persistentMusico.getBiografia();
            Biografia biografiaNew = musico.getBiografia();
            if (idInstrumentoNew != null) {
                idInstrumentoNew = em.getReference(idInstrumentoNew.getClass(), idInstrumentoNew.getIdInstrumento());
                musico.setIdInstrumento(idInstrumentoNew);
            }
            if (biografiaNew != null) {
                biografiaNew = em.getReference(biografiaNew.getClass(), biografiaNew.getIdBiografia());
                musico.setBiografia(biografiaNew);
            }
            musico = em.merge(musico);
            if (idInstrumentoOld != null && !idInstrumentoOld.equals(idInstrumentoNew)) {
                idInstrumentoOld.getMusicoList().remove(musico);
                idInstrumentoOld = em.merge(idInstrumentoOld);
            }
            if (idInstrumentoNew != null && !idInstrumentoNew.equals(idInstrumentoOld)) {
                idInstrumentoNew.getMusicoList().add(musico);
                idInstrumentoNew = em.merge(idInstrumentoNew);
            }
            if (biografiaOld != null && !biografiaOld.equals(biografiaNew)) {
                biografiaOld.setIdMusico(null);
                biografiaOld = em.merge(biografiaOld);
            }
            if (biografiaNew != null && !biografiaNew.equals(biografiaOld)) {
                Musico oldIdMusicoOfBiografia = biografiaNew.getIdMusico();
                if (oldIdMusicoOfBiografia != null) {
                    oldIdMusicoOfBiografia.setBiografia(null);
                    oldIdMusicoOfBiografia = em.merge(oldIdMusicoOfBiografia);
                }
                biografiaNew.setIdMusico(musico);
                biografiaNew = em.merge(biografiaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = musico.getIdMusico();
                if (findMusico(id) == null) {
                    throw new NonexistentEntityException("The musico with id " + id + " no longer exists.");
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
            Musico musico;
            try {
                musico = em.getReference(Musico.class, id);
                musico.getIdMusico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The musico with id " + id + " no longer exists.", enfe);
            }
            Instrumento idInstrumento = musico.getIdInstrumento();
            if (idInstrumento != null) {
                idInstrumento.getMusicoList().remove(musico);
                idInstrumento = em.merge(idInstrumento);
            }
            Biografia biografia = musico.getBiografia();
            if (biografia != null) {
                biografia.setIdMusico(null);
                biografia = em.merge(biografia);
            }
            em.remove(musico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Musico> findMusicoEntities() {
        return findMusicoEntities(true, -1, -1);
    }

    public List<Musico> findMusicoEntities(int maxResults, int firstResult) {
        return findMusicoEntities(false, maxResults, firstResult);
    }

    private List<Musico> findMusicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Musico.class));
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

    public Musico findMusico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Musico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMusicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Musico> rt = cq.from(Musico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    // busqueda usando name query para los musicos----buscamos por nombre

    public Musico encontraMusicoNombre(String nombre) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Musico.findByNombre");
        q.setParameter("nombre", nombre);
        return (Musico) q.getSingleResult();

    }
    
    // busqueda usando name query para los musicos----buscamos por genero

    public Musico encontraMusicoGenero(String genero) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Musico.findByGenero");
        q.setParameter("genero", genero);
        return (Musico) q.getSingleResult();

    }

}
