/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tarea4guinachosalcedo;

import java.awt.FlowLayout;

/**
 *
 * @author Windows10
 */
public class Calculadora extends javax.swing.JFrame {

    /**
     * Creates new form Calculadora
     */
    public Calculadora() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonUno = new javax.swing.JButton();
        Boton2 = new javax.swing.JButton();
        BotonSumar = new javax.swing.JButton();
        LabelPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonUno.setText("1");
        BotonUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUnoActionPerformed(evt);
            }
        });

        Boton2.setText("2");
        Boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2ActionPerformed(evt);
            }
        });

        BotonSumar.setText("+");
        BotonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSumarActionPerformed(evt);
            }
        });

        LabelPantalla.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(BotonUno)
                        .addGap(53, 53, 53)
                        .addComponent(Boton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(LabelPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(BotonSumar)))
                .addContainerGap(412, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(LabelPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonUno)
                    .addComponent(Boton2))
                .addGap(18, 18, 18)
                .addComponent(BotonSumar)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUnoActionPerformed
        // TODO add your handling code here:
        BotonUno.setText(String.valueOf(1));
        LabelPantalla.setText(String.valueOf(1));
    }//GEN-LAST:event_BotonUnoActionPerformed

    private void Boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2ActionPerformed
     Boton2.setText(String.valueOf(2));
         LabelPantalla.setText(String.valueOf(2));
    }//GEN-LAST:event_Boton2ActionPerformed

    private void BotonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSumarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSumarActionPerformed

    
     
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton2;
    private javax.swing.JButton BotonSumar;
    private javax.swing.JButton BotonUno;
    private javax.swing.JLabel LabelPantalla;
    // End of variables declaration//GEN-END:variables
}
