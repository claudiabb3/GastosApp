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
import objetos.EntregaEpi;
import objetos.EntregaEpiDAO;
import objetos.Epi;
import objetos.EpiDAO;


/**
 *
 * @author Claud
 */
public class VentanaEntregas extends javax.swing.JPanel {
    
    //Instancias de los objetos que se van a necesitar
    EmpleadoDAO empleadoDao= new EmpleadoDAO();
    Empleado empleado = new Empleado();
    EpiDAO epiDao= new EpiDAO();
    Epi epi = new Epi();
    EntregaEpi entregaEpi = new EntregaEpi();
    EntregaEpiDAO entregaEpiDao = new EntregaEpiDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    public VentanaEntregas() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlIdEmpleado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlApellido1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlPuesto = new javax.swing.JLabel();
        jlApellido2 = new javax.swing.JLabel();
        tfIdEmp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlIdEpi = new javax.swing.JLabel();
        jlIdEpi1 = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfUd = new javax.swing.JTextField();
        txIdEpi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnEntregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEntregas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 92, 137));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(11, 27, 54));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Selecciona empleado");

        jlIdEmpleado.setText("Codigo:");

        jLabel5.setText("Nombre:");

        jLabel7.setText("Puesto:");

        jlApellido1.setBackground(new java.awt.Color(255, 255, 255));
        jlApellido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("2º Apellido");

        jlNombre.setBackground(new java.awt.Color(255, 255, 255));
        jlNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("1º Apellido");

        jlPuesto.setBackground(new java.awt.Color(255, 255, 255));
        jlPuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlApellido2.setBackground(new java.awt.Color(255, 255, 255));
        jlApellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfIdEmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfIdEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfIdEmpMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jlIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdEmpleado)
                    .addComponent(tfIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jlPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 280, 200));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setAutoscrolls(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Selecciona epi");

        jlIdEpi.setText("Codigo:");

        jlIdEpi1.setText("Descripcion:");

        jlDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        jlDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("Unidades");

        tfUd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txIdEpi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txIdEpi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txIdEpiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlIdEpi1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jlIdEpi, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUd, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(txIdEpi)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlIdEpi)
                    .addComponent(txIdEpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlIdEpi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 280, 200));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Mediante la firma del presente, el empleado acepta la recepcion del material de seguridad \npara  cumplir la legislacion del Real Derecho 664/1197, de 12 de Mayo, sobre la protección \nde los trabajadores contra los riesgos relacionados con la exposición de agentes biológicos\ndurante el trabajo.");
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jTextArea1.setSelectionColor(new java.awt.Color(255, 148, 31));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 350, 90));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 230, 90));

        btnEntregar.setBackground(new java.awt.Color(255, 153, 0));
        btnEntregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntregar.setText("Entregar");
        btnEntregar.setBorder(null);
        btnEntregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntregarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEntregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, 110, 30));

        tablaEntregas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tablaEntregas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripcion", "Und"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaEntregas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaEntregas.setSelectionBackground(new java.awt.Color(119, 200, 255));
        jScrollPane3.setViewportView(tablaEntregas);
        if (tablaEntregas.getColumnModel().getColumnCount() > 0) {
            tablaEntregas.getColumnModel().getColumn(0).setMinWidth(30);
            tablaEntregas.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaEntregas.getColumnModel().getColumn(0).setMaxWidth(30);
            tablaEntregas.getColumnModel().getColumn(2).setMinWidth(35);
            tablaEntregas.getColumnModel().getColumn(2).setPreferredWidth(35);
            tablaEntregas.getColumnModel().getColumn(2).setMaxWidth(35);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 340, 240));

        jLabel2.setBackground(new java.awt.Color(218, 234, 219));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Entrega de Epi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 279, 43));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Firma:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 153, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setBorder(null);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 80, 30));

        btnAdd1.setBackground(new java.awt.Color(255, 153, 0));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd1.setText("Añadir");
        btnAdd1.setBorder(null);
        btnAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdd1MouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Seleccionar datos:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Material a entregar:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/documento60px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar25px.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para mostrar en la tabla los epis que se entregan
    public void insertarTablaEntregas(){
     modelo =  (DefaultTableModel) tablaEntregas.getModel();
 
    String id= txIdEpi.getText();
    String descripcion = jlDescripcion.getText();
    String unidades = tfUd.getText();
    
    Object[] obj = new Object[3];
    
    obj[0]=id;
    obj[1]=descripcion;
    obj[2]= unidades;
    
    modelo.addRow(obj);
    tablaEntregas.setModel(modelo);
    }
    
    //Metodo para eliminar filas de la tabla entregas
    //Eliminar algun epi que finalmente no se entrega
    public void eliminarFila(){
        modelo =  (DefaultTableModel) tablaEntregas.getModel();
        
        if(tablaEntregas.getSelectedRow()==-1){
        JOptionPane.showMessageDialog(this, "Hay que seleccionar fila");
        }else{
         modelo.removeRow(tablaEntregas.getSelectedRow());
        }
    }
    private void btnEntregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregarMouseClicked
       
        //Declaramos una variable para recoger la fila
        String fila ="";
        
        //recorremos la tabla para coger el valor de la fila, columna 1
        for(int f=0; f<tablaEntregas.getRowCount();f++){
        
            fila= tablaEntregas.getValueAt(f, 0).toString();
        }
        
        //si el valor de la fila y la columna 1 esta vacia, mostrar un dialogo de alerta y si no, se actualizan las unidades
        // y se realiza la entrega insertando los datos mediante el metodo actualizarTabEntrega()
        if(fila.isEmpty()){
        
         JOptionPane.showMessageDialog(this, "Tienes que introducir epi a entregar ");
        
        }
        
        
        else{
          actualizarUnidades();
          actualizarTabEntrega();
          JOptionPane.showMessageDialog(this, "Entrega realiada");
        }
        
        
       
    }//GEN-LAST:event_btnEntregarMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
       eliminarFila();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseClicked
       if(txIdEpi.getText().isEmpty() || tfUd.getText().isEmpty()){
       JOptionPane.showMessageDialog(this, "Tienes que introducir el codigo de epi y las unidades");
       
       }else{
        insertarTablaEntregas();
       }
    }//GEN-LAST:event_btnAdd1MouseClicked

    private void tfIdEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfIdEmpMouseExited
       
        if(tfIdEmp.getText().isEmpty()){
             System.out.println("No hay dato introducido.");
        }else{
          try{
                listarEmpleado();
            }catch(Exception e){
               System.out.println("Error en seleccion empleado") ;
        }}
       
    }//GEN-LAST:event_tfIdEmpMouseExited

    private void txIdEpiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txIdEpiMouseExited
        
        if(txIdEpi.getText().isEmpty()){
         System.out.println("No hay dato introducido.");
        }else{
             listarEpi();
        try{
            
            
        }catch(Exception e){
              System.out.println("Error en seleccion epi");
        }
        } 
       
    }//GEN-LAST:event_txIdEpiMouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked
    
    //Metodo para actualizar las unidades de los epis tras realizar un entrega
    //Descontar las undades entregadas
    public void actualizarUnidades(){
     epiDao.actualizarUnidades(Integer.parseInt(tfUd.getText()), Integer.parseInt(txIdEpi.getText()));
    
    }
    
    //Metodo para insertar datos en la tabla entregas_epi de la base de datos
    //tras realizar una entrega de epi
    public void actualizarTabEntrega(){
        
        
         for(int f=0; f<tablaEntregas.getRowCount();f++){
         entregaEpiDao.InsertarEntregasEpi(jlNombre.getText(),jlApellido1.getText(), jlApellido2.getText(), 
         jlPuesto.getText(),tablaEntregas.getValueAt(f, 1).toString(), Integer.parseInt((tfIdEmp.getText())), 
         Integer.parseInt(tablaEntregas.getValueAt(f,0).toString()),Integer.parseInt(tablaEntregas.getValueAt(f, 2).toString()));
        
        }
    }
    
    //Metodo para mostrar datos del epi seleccionado mediante el id
    public void listarEpi(){
    
        Epi epi = epiDao.epi(Integer.parseInt(txIdEpi.getText()));
        jlDescripcion.setText(epi.getDescripcion() + ", talla: " +  epi.getTalla());
    
    }
    
    //Metodo para mostrar los datos del empleado tras introducir el id
    public void listarEmpleado(){

        Empleado empleado = empleadoDao.idEmpleado(Integer.parseInt(tfIdEmp.getText()));
        
        jlNombre.setText(empleado.getNombre());
        jlApellido1.setText(empleado.getApellido1());
        jlApellido2.setText(empleado.getApellido2());
        jlPuesto.setText(empleado.getPuesto());
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEntregar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel jlApellido1;
    private javax.swing.JLabel jlApellido2;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlIdEmpleado;
    private javax.swing.JLabel jlIdEpi;
    private javax.swing.JLabel jlIdEpi1;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPuesto;
    private javax.swing.JTable tablaEntregas;
    private javax.swing.JTextField tfIdEmp;
    private javax.swing.JTextField tfUd;
    private javax.swing.JTextField txIdEpi;
    // End of variables declaration//GEN-END:variables
}
