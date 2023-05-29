/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Windows10
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica2_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);

       public static void mostarMusicos() {
        System.out.println("-------Listado de Músicos------");
        mc.findMusicoEntities().forEach(System.out::println);
        System.out.println("---------------------------------------");

    }
    public static void main(String[] args) {
        mostarMusicos();
        
        
        
    }
    
}
