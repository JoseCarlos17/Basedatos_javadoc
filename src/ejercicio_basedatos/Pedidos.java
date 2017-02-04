/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_basedatos;
import static ejercicio_basedatos.Clientes.r;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 * La clase Pedidos almacena toda la información de la tabla Pedidos y en ella se encuentran los pedidos que han realizado los clientes.
 * @author Jose Carlos
 * @version 1.0 - Alpha
 */
public class Pedidos extends javax.swing.JFrame {
    /** Creación de los ResultSet y el Connection.*/
    static public ResultSet r;
    static public ResultSet r2;
       static public ResultSet r3;
       static public Connection connection;
    /**
     * Establecemos la conexión con la base de datos para obtener los primeros datos de la tabla Pedidos (Número Pedido, Fecha y Cliente).
     * En esta clase también almacenamos el combobox y la consulta realizada dentro del combobox para obtener el código del cliente y el nombre del
     * cliente. Como anteriormente, también hacemos invisibles los botones Aceptar y Cancelar.
     * @throws SQLException - Si nos ocurriese algún error, SQLException lo trataría.
     */
    public Pedidos() throws SQLException {
        initComponents();
        aceptar.setVisible(false);
        cancelar.setVisible(false);
        /** Conexión con la base de datos usando el usuario "Root" y sin contraseña establecida.*/
        String url ="jdbc:mysql://localhost:3306/base_datos_ej1";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url,user,pass);
        
        Statement s = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        /** Consulta almacenada en el primer ResulSet.*/
        String query = "select * from pedidos";
        r = s.executeQuery(query);
        r.first();
        numpedido.setText(r.getString("NUM_PEDIDO"));
        fecha.setText(r.getString("FECHA"));
        
        /**
         * Consulta realizada en el segundo ResulSet que nos devuelve el nombre del cliente y el código del cliente.
         */
        String query2 = "select * from clientes";
          
            Statement s2 = connection.createStatement();
            r2 = s2.executeQuery(query2);
            DefaultComboBoxModel value1 = new DefaultComboBoxModel();

            while (r2.next()) {
                   value1.addElement(r2.getString("NOMBRE"));
            }
            cliente1.setModel(value1);
            cliente1.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        
        /**
         * El método getNombreCliente nos devuelve el nombre del cliente utilizando el código del Cliente, en este caso es el NIF.
         * @param codigo - Código del Cliente.
         * @return name - Nombre del cliente.
         */    
    }
    public static String getNombreCliente(String codigo){
                       
               String name="";
               try {
               String queryNombre = "select nombre from clientes WHERE NIF='"+codigo+"'";
               
               Statement s3 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               r3= s3.executeQuery(queryNombre);
               r3.first();
               name= r3.getString("NOMBRE");              
           }   catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
            return name;
            
        /**
         * El método getNifCLiente nos devuelve el NIF del cliente utilizando el nombre del cliente.
         * @param nombre - Nombre del Cliente.
         * @return codigo - Código del Cliente.
         */    
    
    }
     public static String getNifCliente(String nombre){
                          
               String codigo="";
               try {
               String queryCodigo = "select NIF from clientes WHERE nombre='"+nombre+"'";
              
               Statement s3 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               r3= s3.executeQuery(queryCodigo);
               r3.first();
               codigo= r3.getString("NIF");
           } catch (SQLException ex) {
               Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
           }
        return codigo;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numpedido = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        anterior = new javax.swing.JToggleButton();
        siguiente = new javax.swing.JToggleButton();
        nuevo = new javax.swing.JToggleButton();
        modificar = new javax.swing.JToggleButton();
        primero = new javax.swing.JToggleButton();
        ultimo = new javax.swing.JToggleButton();
        borrar = new javax.swing.JToggleButton();
        volver = new javax.swing.JToggleButton();
        aceptar = new javax.swing.JToggleButton();
        cancelar = new javax.swing.JToggleButton();
        cliente1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Pedidos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Numero Pedido");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Cliente");

        numpedido.setEditable(false);
        numpedido.setToolTipText("");

        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        primero.setText("Primero");
        primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeroActionPerformed(evt);
            }
        });

        ultimo.setText("Ultimo");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        volver.setText("Volver al Menu");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.setEnabled(false);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        cliente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volver, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(primero)
                .addGap(10, 10, 10)
                .addComponent(ultimo)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numpedido, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(fecha)
                            .addComponent(cliente1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(aceptar)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)
                        .addGap(83, 83, 83)
                        .addComponent(cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4))
                    .addComponent(cliente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar)
                    .addComponent(nuevo)
                    .addComponent(modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(ultimo)
                    .addComponent(anterior)
                    .addComponent(siguiente)
                    .addComponent(primero))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if(r.previous()){
                numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
                cliente1.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
            } } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
  try {
               if(r.next()){
                numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
                cliente1.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
               } } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }       
    }//GEN-LAST:event_siguienteActionPerformed

    private void primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeroActionPerformed
        try {
            r.first();
            numpedido.setText(r.getString("NUM_PEDIDO"));
            fecha.setText(r.getString("FECHA"));
            cliente1.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_primeroActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            r.last();
            numpedido.setText(r.getString("NUM_PEDIDO"));
            fecha.setText(r.getString("FECHA"));
            cliente1.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
         cliente1.setEnabled(true);
        numpedido.setEditable(true);
        borrar.setEnabled(false);
        nuevo.setEnabled(false);
        modificar.setEnabled(false);
        anterior.setEnabled(false);         
        siguiente.setEnabled(false);
        primero.setEnabled(false);
        ultimo.setEnabled(false);
        aceptar.setVisible(true);
        cancelar.setVisible(true);
        aceptar.setEnabled(true);
        cancelar.setEnabled(true);
        numpedido.setText(null);
        fecha.setText(null);
    }//GEN-LAST:event_nuevoActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {       
        String vNumpedido, vFecha, vCliente, cliente;
               vNumpedido = numpedido.getText();
               vFecha = fecha.getText();
               vCliente= (String) cliente1.getSelectedItem();
               cliente= getNifCliente(vCliente);
               String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
               String user = "root";
               String pass = "";
               Connection connection = DriverManager.getConnection(url, user, pass);
               Statement s = connection.createStatement();
               if (numpedido.getText().length()==0) JOptionPane.showMessageDialog(null,"No has asignado un Código");
               else {
               String query = "insert into pedidos values ('" + vNumpedido + "','" + vFecha + "','" + cliente + "')";
               int resultado = s.executeUpdate(query);
                String query2 = "select * from pedidos";
                r = s.executeQuery(query2);
                r.first();
                      }
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }       
        
        try {
            Pedidos ped = new Pedidos ();            
            ped.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
                  Menu cli = new Menu();
                  cli.setLocationRelativeTo (null);
                  this.setVisible(false);
                  cli.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
                     try {
               String vNumpedido, vFecha, vCliente, cliente;
               vNumpedido = numpedido.getText();
               vFecha = fecha.getText();
               vCliente= (String) cliente1.getSelectedItem();
               cliente= getNifCliente(vCliente);
               String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
               String user = "root";
               String pass = "";
               Connection connection = DriverManager.getConnection(url, user, pass);
               Statement s = connection.createStatement();
               String query = "update pedidos set FECHA='" + vFecha + "',CLIENTE='" +cliente+"' WHERE NUM_PEDIDO='"+ vNumpedido +"'";
               int resultado = s.executeUpdate(query);
               r.refreshRow();
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);              
           }
    }//GEN-LAST:event_modificarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
                 try {            
               String vNumpedido;
               vNumpedido = numpedido.getText();
               String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
               String user = "root";
               String pass = "";
               Connection connection = DriverManager.getConnection(url, user, pass);
               Statement s = connection.createStatement();
               String query = "delete FROM pedidos WHERE NUM_PEDIDO='"+vNumpedido+"'";
               int resultado = s.executeUpdate(query);
               String query2 = "select * from pedidos";
               r = s.executeQuery(query2);
               r.first();
               numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_borrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
             try {          
            numpedido.setEditable(false);
            borrar.setEnabled(true);
            nuevo.setEnabled(true);
            modificar.setEnabled(true);
            anterior.setEnabled(true);
            siguiente.setEnabled(true);
            primero.setEnabled(true);
            ultimo.setEnabled(true);
            aceptar.setVisible(false);
            cancelar.setVisible(false);
            aceptar.setEnabled(false);
            cancelar.setEnabled(false);
            r.first();
             numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
                cliente1.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pedidos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton aceptar;
    private javax.swing.JToggleButton anterior;
    private javax.swing.JToggleButton borrar;
    private javax.swing.JToggleButton cancelar;
    private javax.swing.JComboBox<String> cliente1;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton modificar;
    private javax.swing.JToggleButton nuevo;
    private javax.swing.JTextField numpedido;
    private javax.swing.JToggleButton primero;
    private javax.swing.JToggleButton siguiente;
    private javax.swing.JToggleButton ultimo;
    private javax.swing.JToggleButton volver;
    // End of variables declaration//GEN-END:variables
}
