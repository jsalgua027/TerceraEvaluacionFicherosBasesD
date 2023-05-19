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
import entidades.Grabacion;
import entidades.Instrumento;
import entidades.Musico;
import java.time.LocalDate;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class CreacionModificacionBorradoEntidades {
    
    public static void asignarMusicoABiografia(Biografia auxB, Musico auxA) {
        
        auxB.setIdMusico(auxA);
        
    }
    
    public static void asignarInstrumentoAMusica(Musico auxM, Instrumento auxI) {
        auxM.setIdInstrumento(auxI);
        
    }

    /**
     * @param args the command line arguments
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);
    private static final BiografiaJpaController bc = new BiografiaJpaController(emf);
    
    public static void main(String[] args) throws IllegalOrphanException, NonexistentEntityException {
        Biografia bioPrueba = new Biografia("hhhhhhhh", Utilidades.Utilidades.LocalADate(LocalDate.of(2000, 3, 4)), "Madrid", null);
        
        Biografia bio1 = new Biografia("Biografía 1", Utilidades.Utilidades.LocalADate(LocalDate.of(1990, 5, 10)), "Ciudad 1", null);
        Biografia bio2 = new Biografia("Biografía 2", Utilidades.Utilidades.LocalADate(LocalDate.of(1985, 8, 20)), "Ciudad 2", null);
        Biografia bio3 = new Biografia("Biografía 3", Utilidades.Utilidades.LocalADate(LocalDate.of(1978, 2, 15)), "Ciudad 3", null);
        Biografia bio4 = new Biografia("Biografía 4", Utilidades.Utilidades.LocalADate(LocalDate.of(1995, 11, 7)), "Ciudad 4", null);
        Biografia bio5 = new Biografia("Biografía 5", Utilidades.Utilidades.LocalADate(LocalDate.of(1982, 6, 25)), "Ciudad 5", null);
        Biografia bio6 = new Biografia("Biografía 6", Utilidades.Utilidades.LocalADate(LocalDate.of(1974, 9, 18)), "Ciudad 6", null);
        Biografia bio7 = new Biografia("Biografía 7", Utilidades.Utilidades.LocalADate(LocalDate.of(1988, 4, 30)), "Ciudad 7", null);
        Biografia bio8 = new Biografia("Biografía 8", Utilidades.Utilidades.LocalADate(LocalDate.of(1992, 10, 12)), "Ciudad 8", null);
        Biografia bio9 = new Biografia("Biografía 9", Utilidades.Utilidades.LocalADate(LocalDate.of(1979, 7, 3)), "Ciudad 9", null);
        Biografia bio10 = new Biografia("Biografía 10", Utilidades.Utilidades.LocalADate(LocalDate.of(1987, 12, 22)), "Ciudad 10", null);

//          bc.create(bioPrueba);
//          bc.create(bio1);
//          bc.create(bio2);
//          bc.create(bio3);
//          bc.create(bio4);
//          bc.create(bio5);
//          bc.create(bio6);
//          bc.create(bio7);
//          bc.create(bio8);
//          bc.create(bio9);
//          bc.create(bio10);
        Musico musicoPrueba = new Musico("Paco", "Rap", null, bioPrueba);
        
        Musico musico1 = new Musico("Paco", "Rap", null, bio1);
        Musico musico2 = new Musico("Juan", "Rock", null, bio2);
        Musico musico3 = new Musico("Luisa", "Pop", null, bio3);
        Musico musico4 = new Musico("Ana", "Jazz", null, bio4);
        Musico musico5 = new Musico("Carlos", "Reggae", null, bio5);
        Musico musico6 = new Musico("María", "Salsa", null, bio6);
        Musico musico7 = new Musico("Pedro", "Country", null, bio7);
        Musico musico8 = new Musico("Laura", "Blues", null, bio8);
        Musico musico9 = new Musico("Manuel", "Funk", null, bio9);
        Musico musico10 = new Musico("Sofía", "Hip Hop", null, bio10);

//         mc.create(musicoPrueba);
//         mc.create(musico1);
//         mc.create(musico2);
//         mc.create(musico3);
//         mc.create(musico4);
//         mc.create(musico5);
//         mc.create(musico6);
//         mc.create(musico7);
//         mc.create(musico8);
//         mc.create(musico9);
//         mc.create(musico10);
//         
        Consultas.mostrarBiografia();
        Consultas.mostarMusicos();
        //  bc.destroy(bioPrueba.getIdBiografia());
        //  mc.destroy(musicoPrueba.getIdMusico());

        Instrumento instruPrueba = new Instrumento("Piano", "Prueba");
        
        Instrumento instrumento1 = new Instrumento("Guitarra", "Cuerda");
        Instrumento instrumento2 = new Instrumento("Batería", "Percusión");
        Instrumento instrumento3 = new Instrumento("Violín", "Cuerda");
        Instrumento instrumento4 = new Instrumento("Saxofón", "Viento");
        Instrumento instrumento5 = new Instrumento("Flauta", "Viento");
        Instrumento instrumento6 = new Instrumento("Bajo", "Cuerda");
        Instrumento instrumento7 = new Instrumento("Trompeta", "Viento");
        Instrumento instrumento8 = new Instrumento("Teclado", "Prueba");
        Instrumento instrumento9 = new Instrumento("Trombón", "Viento");
        Instrumento instrumento10 = new Instrumento("Clarinete", "Viento");

//         ic.create(instruPrueba);
//         ic.create(instrumento1);
//         ic.create(instrumento2);
//         ic.create(instrumento3);
//         ic.create(instrumento4);
//         ic.create(instrumento5);
//         ic.create(instrumento6);
//         ic.create(instrumento7);
//         ic.create(instrumento8);
//         ic.create(instrumento9);
//         ic.create(instrumento10);
        // ic.destroy(2);
        Consultas.mostrarInstrumentos();
        
        Grabacion grabaciPrue = new Grabacion("Primera Grabacion", Utilidades.Utilidades.LocalADate(LocalDate.now()), instruPrueba);
        Consultas.mostrarGrabaciones();
    }
    
}
