/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2edd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import static proyecto2edd.ManejoArchivo.lecturaArchivo;

/**
 *
 * @author ernes
 */
public class Interfaz extends javax.swing.JFrame {

    public static Lista listaAutores = new Lista();
    public static Articulo articulo = new Articulo();

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonAgregar = new javax.swing.JButton();
        BotonBPAutor = new javax.swing.JButton();
        BotonBPPC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonAgregar.setText("Agregar archivo");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 180, 60));

        BotonBPAutor.setText("Autor");
        jPanel1.add(BotonBPAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        BotonBPPC.setText("Palabras claves");
        jPanel1.add(BotonBPPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Selecciona un archivo de texto (.txt)");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);

        //Si el usuario agrega un txt.
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String auxpath = jfc.getSelectedFile().getPath();
            System.out.println(jfc.getSelectedFile().getPath());

            //Empezamos a leer el archivo cargado
            StringBuilder sb = new StringBuilder();
            String txt = "";

            try ( BufferedReader br = Files.newBufferedReader(Paths.get(auxpath))) {

                //Lectura linea por linea
                String line;

                while ((line = br.readLine()) != null) {

                    if (!line.isEmpty()) {
                        txt += line + "\n";
                    }

                }

                lecturaArchivo(txt, articulo);

//                if (!"".equals(txt) && !txt.isEmpty()) {
//                    String[] txt_split = txt.split("\n");
//                    for (int i = 0; i < txt_split.length; i++) {
//                        if (txt_split[i].equals("Autores") || txt_split[i].equals("autores")) {
//                            System.out.println("Conseguimos autores\n");
//                        }
//
//                        if (txt_split[i].equals("Resumen") || txt_split[i].equals("resumen")) {
//                            System.out.println("Conseguimos resumen");
//                        }
//                        if (txt_split[i].equals("Palabras Claves:")) {
//                            
//                        }
//                    }
//
//                }
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }

        }

    }//GEN-LAST:event_BotonAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonBPAutor;
    private javax.swing.JButton BotonBPPC;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
