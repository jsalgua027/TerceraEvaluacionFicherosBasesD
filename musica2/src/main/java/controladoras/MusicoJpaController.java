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
import entidades.Musico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Windows10
 */
public class MusicoJpaController implements Serializable {

    public MusicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MusicoJpaController() {

        emf = Persistence.createEntityManagerFactory("com.mycompany_musica2_jar_1.0-SNAPSHOTPU");
    }

    public void create(Musico musico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Instrumento instrumento = musico.getInstrumento();
            if (instrumento != null) {
                instrumento = em.getReference(instrumento.getClass(), instrumento.getIdInstrumento());
                musico.setInstrumento(instrumento);
            }
            em.persist(musico);
            if (instrumento != null) {
                Musico oldIdMusicoOfInstrumento = instrumento.getIdMusico();
                if (oldIdMusicoOfInstrumento != null) {
                    oldIdMusicoOfInstrumento.setInstrumento(null);
                    oldIdMusicoOfInstrumento = em.merge(oldIdMusicoOfInstrumento);
                }
                instrumento.setIdMusico(musico);
                instrumento = em.merge(instrumento);
            }
            //   Utilidades.LecturaYEscritura.controlarIds(musico);
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
            Instrumento instrumentoOld = persistentMusico.getInstrumento();
            Instrumento instrumentoNew = musico.getInstrumento();
            if (instrumentoNew != null) {
                instrumentoNew = em.getReference(instrumentoNew.getClass(), instrumentoNew.getIdInstrumento());
                musico.setInstrumento(instrumentoNew);
            }
            musico = em.merge(musico);
            if (instrumentoOld != null && !instrumentoOld.equals(instrumentoNew)) {
                instrumentoOld.setIdMusico(null);
                instrumentoOld = em.merge(instrumentoOld);
            }
            if (instrumentoNew != null && !instrumentoNew.equals(instrumentoOld)) {
                Musico oldIdMusicoOfInstrumento = instrumentoNew.getIdMusico();
                if (oldIdMusicoOfInstrumento != null) {
                    oldIdMusicoOfInstrumento.setInstrumento(null);
                    oldIdMusicoOfInstrumento = em.merge(oldIdMusicoOfInstrumento);
                }
                instrumentoNew.setIdMusico(musico);
                instrumentoNew = em.merge(instrumentoNew);
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
            Instrumento instrumento = musico.getInstrumento();
            if (instrumento != null) {
                instrumento.setIdMusico(null);
                instrumento = em.merge(instrumento);
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
// metodo para controlar los autoIncrement
    public void modificarAutoIncrement(Musico auxMusi) {

        int idMusico = auxMusi.getIdMusico();
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            
            String consulta = "ALTER TABLE  musico AUTO_INCREMENT = "+ idMusico;
            em.createNativeQuery(consulta).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("No se ha podido modificar");
            
        }finally{
        
        em.close();
        }
        

    }
}
