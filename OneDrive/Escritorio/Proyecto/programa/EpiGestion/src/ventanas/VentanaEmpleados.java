/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Empleado;
import objetos.EmpleadoDAO;

/**
 *
 * @author Claud
 */
public class VentanaEmpleados extends javax.swing.JPanel {
    
    //Instancias de los objetos necesarios
    DefaultTableModel modelo = new DefaultTableModel();
    EmpleadoDAO empDao = new EmpleadoDAO();
    Empleado emp = new Empleado();
    
    public VentanaEmpleados() {
        initComponents();
        mostrarTablaEmpleado();
    }

    //Metodo para mostrar la tabla de empleados al inciar programa
    public void mostrarTablaEmpleado(){
    
    List<Empleado> lista = empDao.listaTablaEmpleado();
    modelo = (DefaultTableModel)tablaEmpleados.getModel();
    Object[] ob = new Object[5];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEmpleado();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido1();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        
        modelo.addRow(ob);
    }
    
    tablaEmpleados.setModel(modelo);
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        txId = new javax.swing.JTextField();

        setInheritsPopupMenu(true);
        setMinimumSize(new java.awt.Dimension(1000, 680));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 680));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(11, 27, 54));
        jPanel2.setMinimumSize(new java.awt.Dimension(680, 760));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empleados");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 140, 40));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "1º Apellido", "2º Apellido", "Puesto"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 730, 510));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ingeniero60px.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar25px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(255, 153, 0));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 80, 30));

        txId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 80, -1));

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        if(txId.getText().isEmpty()){
       
           limpiarTabla();
           mostrarTablaEmpleado();
       }else{
        limpiarTabla();
        filtrarIdEmpleado();
        
        }
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked
   
    //Metodo para filtrar por id en la tabla de empleados
    public void filtrarIdEmpleado(){
    List<Empleado> lista = empDao.filtrarId(Integer.parseInt(txId.getText()));
    modelo = (DefaultTableModel)tablaEmpleados.getModel();
    Object[] ob = new Object[5];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEmpleado();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido1();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        
        modelo.addRow(ob);
    }
    
    tablaEmpleados.setModel(modelo);
    
       
    }
    
 
    //Metodo para limpiar la tabla 
    private void limpiarTabla() {
        for(int i =0 ; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
    
    
    }}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txId;
    // End of variables declaration//GEN-END:variables
}
