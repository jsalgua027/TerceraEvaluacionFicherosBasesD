/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import controladoras.exceptions.IllegalOrphanException;
import controladoras.exceptions.NonexistentEntityException;
import entidades.Biografia;
import entidades.Musico;
import java.time.LocalDate;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class CreacionModificacionBorradoEntidades {

    /**
     * @param args the command line arguments
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);
    private static final BiografiaJpaController bc = new BiografiaJpaController(emf);

    public static void crearBiografia() {
        Biografia b = new Biografia();
        b.setDescripcion("Artista Español uno de los precursores del Rap en este pais");
        b.setFechaNacimientoLocalDate(LocalDate.of(1981, 2, 2));
        b.setLugarNacimiento("Cadiz");

        bc.create(b);

    }

    public static void borrarBiografia(Integer id) throws IllegalOrphanException, NonexistentEntityException {

        bc.destroy(id);
    }

    public static void crearMusico() {
        Musico m = new Musico();

        m.setNombre("Nacho");
        m.setGenero("Rap");

        mc.create(m);

    }
    
     public static void borrarMusico(Integer id)throws  IllegalOrphanException, NonexistentEntityException{
    
        mc.destroy(id);
    }
    

    public static void main(String[] args) throws IllegalOrphanException, NonexistentEntityException {
        // TODO code application logic here
          // crearBiografia();
        //  borrarBiografia(6);

       // crearMusico();
//        borrarMusico(3);
//        borrarMusico(4);
//        borrarMusico(5);
//        borrarMusico(6);
//        borrarMusico(7);
// 

        Consultas.mostrarBiografia();
        Consultas.mostarMusicos();
    }

}
