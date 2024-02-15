/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;
import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Claud
 */
public class Inicio extends javax.swing.JFrame {
      
  
    public Inicio() {
        initComponents();
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        this.setLocation(0,0);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        imgEmpleados = new javax.swing.JLabel();
        imgEntregasEpi = new javax.swing.JLabel();
        imgEpi = new javax.swing.JLabel();
        imgConsulta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        vi = new javax.swing.JPanel();
        imgCerrar = new javax.swing.JLabel();
        imgFabrica = new javax.swing.JLabel();
        imgStock = new javax.swing.JLabel();
        imgEmp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1137, 750));
        setMinimumSize(new java.awt.Dimension(1137, 650));
        setName("menuPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1137, 750));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 10));

        imgEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        imgEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ingeniero60px.png"))); // NOI18N
        imgEmpleados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                imgEmpleadosMouseMoved(evt);
            }
        });
        imgEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgEmpleadosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgEmpleadosMouseExited(evt);
            }
        });
        getContentPane().add(imgEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 70, 58));

        imgEntregasEpi.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        imgEntregasEpi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/documento60px.png"))); // NOI18N
        imgEntregasEpi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                imgEntregasEpiMouseMoved(evt);
            }
        });
        imgEntregasEpi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgEntregasEpiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgEntregasEpiMouseExited(evt);
            }
        });
        getContentPane().add(imgEntregasEpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 70, 60));

        imgEpi.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        imgEpi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ropa60px.png"))); // NOI18N
        imgEpi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                imgEpiMouseMoved(evt);
            }
        });
        imgEpi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgEpiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgEpiMouseExited(evt);
            }
        });
        getContentPane().add(imgEpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 70, -1));

        imgConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/consulta60px.png"))); // NOI18N
        imgConsulta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                imgConsultaMouseMoved(evt);
            }
        });
        imgConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgConsultaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgConsultaMouseExited(evt);
            }
        });
        getContentPane().add(imgConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 70, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MENU");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        vi.setBackground(new java.awt.Color(11, 27, 54));
        vi.setAutoscrolls(true);
        vi.setDoubleBuffered(false);

        imgCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar25px.png"))); // NOI18N
        imgCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCerrarMouseClicked(evt);
            }
        });

        imgFabrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fabrica60px.png"))); // NOI18N

        imgStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/stock60px.png"))); // NOI18N

        imgEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trabajador60px.png"))); // NOI18N

        javax.swing.GroupLayout viLayout = new javax.swing.GroupLayout(vi);
        vi.setLayout(viLayout);
        viLayout.setHorizontalGroup(
            viLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(imgFabrica, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(imgStock, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(imgEmp)
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgCerrar)
                .addGap(59, 59, 59))
        );
        viLayout.setVerticalGroup(
            viLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(imgCerrar)
                .addGap(291, 291, 291)
                .addGroup(viLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgStock)
                    .addComponent(imgFabrica)
                    .addComponent(imgEmp))
                .addContainerGap(357, Short.MAX_VALUE))
        );

        getContentPane().add(vi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 1020, 750));

        jLabel6.setText("Consulta entregas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        jLabel7.setText("Empleados");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel8.setText("Realizar entregas");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel9.setText("Epis");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imgEpiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEpiMouseClicked
         VentanaEpi ventanaEpi = new VentanaEpi();
         cambioPanel(ventanaEpi);
    }//GEN-LAST:event_imgEpiMouseClicked

    private void imgEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEmpleadosMouseClicked
        VentanaEmpleados emp = new VentanaEmpleados();
        cambioPanel(emp);
    }//GEN-LAST:event_imgEmpleadosMouseClicked

    private void imgEntregasEpiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEntregasEpiMouseClicked
        VentanaEntregas ventanaEntregas = new VentanaEntregas();
        cambioPanel(ventanaEntregas);
    }//GEN-LAST:event_imgEntregasEpiMouseClicked

    private void imgConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgConsultaMouseClicked
        VentanaConsultaEnt cons = new VentanaConsultaEnt();
        cambioPanel(cons);
    }//GEN-LAST:event_imgConsultaMouseClicked

    private void imgEmpleadosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEmpleadosMouseMoved
       imgEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11,7,54)));
    }//GEN-LAST:event_imgEmpleadosMouseMoved

    private void imgEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEmpleadosMouseExited
        imgEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_imgEmpleadosMouseExited

    private void imgEntregasEpiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEntregasEpiMouseMoved
       imgEntregasEpi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11,7,54)));
    }//GEN-LAST:event_imgEntregasEpiMouseMoved

    private void imgEntregasEpiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEntregasEpiMouseExited
        imgEntregasEpi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_imgEntregasEpiMouseExited

    private void imgEpiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEpiMouseMoved
        imgEpi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11,7,54)));
    }//GEN-LAST:event_imgEpiMouseMoved

    private void imgEpiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEpiMouseExited
         imgEpi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_imgEpiMouseExited

    private void imgConsultaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgConsultaMouseMoved
          imgConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11,7,54)));
    }//GEN-LAST:event_imgConsultaMouseMoved

    private void imgConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgConsultaMouseExited
        imgConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_imgConsultaMouseExited

    private void imgCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_imgCerrarMouseClicked
    //Dejar el panel como al inicio del programa
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
     
     vi.setSize(1050, 720);
     vi.setLocation(0,0);
     
     vi.removeAll();
     vi.add(imgFabrica);
     vi.add(imgStock);
     vi.add(imgEmp);
     vi.revalidate();
     vi.repaint(1050, 720,1050, 720);
     
    }//GEN-LAST:event_jLabel1MouseClicked

    //Metodo para cambiar de panel
    public void cambioPanel(JPanel panel){
    
    panel.setSize(1050, 720);
    panel.setLocation(0,0);
    
    vi.removeAll();
    vi.add(panel);
    vi.revalidate();
    vi.repaint(1050, 720,1050, 720);
    
    }
    
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgCerrar;
    private javax.swing.JLabel imgConsulta;
    private javax.swing.JLabel imgEmp;
    private javax.swing.JLabel imgEmpleados;
    private javax.swing.JLabel imgEntregasEpi;
    private javax.swing.JLabel imgEpi;
    private javax.swing.JLabel imgFabrica;
    private javax.swing.JLabel imgStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel vi;
    // End of variables declaration//GEN-END:variables
}
