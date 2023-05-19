/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import entidades.Biografia;
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

    public static  void crearBiografia(){
   Biografia b = new Biografia();
   
    
    
    }
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
