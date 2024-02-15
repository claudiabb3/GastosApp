/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.EntregaEpi;
import objetos.EntregaEpiDAO;

/**
 *
 * @author Claud
 */
public class VentanaConsultaEnt extends javax.swing.JPanel {
       
    //Instancias de objetos necesarios
    EntregaEpi entregaEpi = new EntregaEpi();
    EntregaEpiDAO entregaEpiDao = new EntregaEpiDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    public VentanaConsultaEnt() {
        initComponents();
        mostrarTablaEntregaEpi();
    }

    
     //Metodo para mostrar la tabla entrega_epi en la tabla visual
   public void mostrarTablaEntregaEpi(){
    
    List<EntregaEpi> lista = entregaEpiDao.entregaEpi();
    modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
    Object[] ob = new Object[10];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEntrega();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido1();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        ob[5]=lista.get(i).getDescripcion();
        ob[6]=lista.get(i).getFecha();
        ob[7]=lista.get(i).getIdEmpleado();
        ob[8]=lista.get(i).getIdEpi();
        ob[9]=lista.get(i).getUnd();
        
        modelo.addRow(ob);
    }
    
    tablaConsultaEntregasEpi.setModel(modelo);
    
    }
   
     //Metodo para filtrar por idEmpleado
   public void filtrarIdEmpleado(){
   List<EntregaEpi> lista = entregaEpiDao.filtrarIdEmp(Integer.parseInt(txIdEmp.getText()));
    modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
    Object[] ob = new Object[10];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEntrega();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido2();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        ob[5]=lista.get(i).getDescripcion();
        ob[6]=lista.get(i).getFecha();
        ob[7]=lista.get(i).getIdEmpleado();
        ob[8]=lista.get(i).getIdEpi();
        ob[9]=lista.get(i).getUnd();
        
        modelo.addRow(ob);
    }
    
    tablaConsultaEntregasEpi.setModel(modelo);
   
   
   
   
   }
   
   
     //Metodo para filtrar por idepi 
   public void filtrarIdEpi(){
   List<EntregaEpi> lista = entregaEpiDao.filtrarIdEpi(Integer.parseInt(txIdEpi.getText()));
    modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
    Object[] ob = new Object[10];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEntrega();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido2();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        ob[5]=lista.get(i).getDescripcion();
        ob[6]=lista.get(i).getFecha();
        ob[7]=lista.get(i).getIdEmpleado();
        ob[8]=lista.get(i).getIdEpi();
        ob[9]=lista.get(i).getUnd();
        
        modelo.addRow(ob);
    }
    
    tablaConsultaEntregasEpi.setModel(modelo);
   
   
   }
   
   //Metodo para filtrar por idEm  y idEpi
   
   public void filtrarIdes(){
   
    List<EntregaEpi> lista = entregaEpiDao.filtrarIdes(Integer.parseInt(txIdEmp.getText()),Integer.parseInt(txIdEpi.getText()));
    modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
    Object[] ob = new Object[10];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEntrega();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido2();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        ob[5]=lista.get(i).getDescripcion();
        ob[6]=lista.get(i).getFecha();
        ob[7]=lista.get(i).getIdEmpleado();
        ob[8]=lista.get(i).getIdEpi();
        ob[9]=lista.get(i).getUnd();
        
        modelo.addRow(ob);
    }
    
    tablaConsultaEntregasEpi.setModel(modelo);
   
   }
   
    //Metodo para limpiar tabla, se utiliza antes de cada filtro
   private void limpiarTabla() {
        for(int i =0 ; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;}}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultaEntregasEpi = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txIdEmp = new javax.swing.JTextField();
        txIdEpi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(999, 642));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(999, 642));

        jPanel1.setBackground(new java.awt.Color(11, 27, 54));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 680));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSULTA ENTREGAS DE EQUIPOS DE PROTECCION");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/consulta60px.png"))); // NOI18N

        tablaConsultaEntregasEpi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "1º Apellido", "2º Apellido", "Puesto", "Epi", "Fecha entrega", "Id empleado", "Id epi", "Und"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaConsultaEntregasEpi.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tablaConsultaEntregasEpi.setEnabled(false);
        tablaConsultaEntregasEpi.setFocusable(false);
        tablaConsultaEntregasEpi.setGridColor(new java.awt.Color(0, 0, 0));
        tablaConsultaEntregasEpi.setOpaque(false);
        tablaConsultaEntregasEpi.setSelectionBackground(new java.awt.Color(255, 204, 0));
        tablaConsultaEntregasEpi.setShowGrid(false);
        jScrollPane1.setViewportView(tablaConsultaEntregasEpi);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id Epi:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id Empleado:");

        txIdEmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txIdEmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txIdEpi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txIdEpi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar25px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txIdEpi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(274, 274, 274))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(txIdEpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
        if(txIdEmp.getText().isEmpty() && txIdEpi.getText().isEmpty()){
            limpiarTabla();
            mostrarTablaEntregaEpi();
        }
        else if(txIdEmp.getText()!=null && txIdEpi.getText().isEmpty()){
            limpiarTabla();
            filtrarIdEmpleado();
        } else if(txIdEpi.getText()!=null && txIdEmp.getText().isEmpty()){
             limpiarTabla();
            filtrarIdEpi();
        }else if(txIdEmp.getText()!=null &&txIdEpi.getText()!=null ){
             limpiarTabla();
             filtrarIdes();
        }else{
            JOptionPane.showMessageDialog(this,"Error en la actualizacion");
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaConsultaEntregasEpi;
    private javax.swing.JTextField txIdEmp;
    private javax.swing.JTextField txIdEpi;
    // End of variables declaration//GEN-END:variables
}
