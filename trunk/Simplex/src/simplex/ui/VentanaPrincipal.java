/*
 * @charset "utf-8";
 * @(#)VentanaPrincipal.java 1.9.1 10/10/09
 *
 * Created on 5/10/2009, 03:50:48 PM
 */
package simplex.ui;

import javax.swing.JOptionPane;
import simplex.resolvedor.Simplex;
import simplex.resolvedor.SimplexTabular;
import simplex.resolvedor.mate.Conversiones;
import simplex.resolvedor.mate.Ecuacion;
import simplex.ui.recursos.ValidadorEcuacion;

/**
 *
 * @author Mari-ppita
 * @version 1.9.1, 10/10/09
 */
public class VentanaPrincipal extends javax.swing.JFrame implements Runnable {
    private static final long serialVersionUID = 8044275911936374960L;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.neocs.beans.panel.BackgroundJPanel backgroundJPanel1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private org.neocs.beans.panel.FondoJPanel fondoJPanel1;
    private org.neocs.beans.panel.FondoJPanel fondoJPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
    /** Creates new form VentanaPrincipal */
    public VentanaPrincipal() {
        initComponents();
        rootPane.setDefaultButton(jButton1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        backgroundJPanel1 = new org.neocs.beans.panel.BackgroundJPanel();
        fondoJPanel1 = new org.neocs.beans.panel.FondoJPanel();
        jLabelTitulo = new javax.swing.JLabel();
        fondoJPanel2 = new org.neocs.beans.panel.FondoJPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Método simplex");

        backgroundJPanel1.setFondoImagenIcon(new javax.swing.ImageIcon(getClass().getResource("/simplex/ui/recursos/imagenes/design519_4_1024.jpg"))); // NOI18N

        fondoJPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabelTitulo.setFont(new java.awt.Font("Agency FB", 1, 24));
        jLabelTitulo.setForeground(new java.awt.Color(102, 0, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("MÉTODO SIMPLEX");

        jLabel2.setText("Función objetivo");

        jLabel3.setText("Restricciones");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Metodo tabular");
        jRadioButton1.setOpaque(false);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Metodo de la M");
        jRadioButton2.setOpaque(false);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Maximizar");
        jRadioButton3.setOpaque(false);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Minimizar");
        jRadioButton4.setOpaque(false);

        jButton1.setText("Resolver");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoJPanel2Layout = new javax.swing.GroupLayout(fondoJPanel2);
        fondoJPanel2.setLayout(fondoJPanel2Layout);
        fondoJPanel2Layout.setHorizontalGroup(
            fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJPanel2Layout.createSequentialGroup()
                .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoJPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jButton1))
                                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))))
                            .addComponent(jRadioButton3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoJPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fondoJPanel2Layout.setVerticalGroup(
            fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoJPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondoJPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoJPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jButton2)))
                            .addGroup(fondoJPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondoJPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Variable básica", "No. de Ecuación", "x1", "x2", "x3", "b"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout fondoJPanel1Layout = new javax.swing.GroupLayout(fondoJPanel1);
        fondoJPanel1.setLayout(fondoJPanel1Layout);
        fondoJPanel1Layout.setHorizontalGroup(
            fondoJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(fondoJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoJPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoJPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fondoJPanel1Layout.setVerticalGroup(
            fondoJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(fondoJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fondoJPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fondoJPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundJPanel1Layout = new javax.swing.GroupLayout(backgroundJPanel1);
        backgroundJPanel1.setLayout(backgroundJPanel1Layout);
        backgroundJPanel1Layout.setHorizontalGroup(
            backgroundJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundJPanel1Layout.setVerticalGroup(
            backgroundJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(backgroundJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(backgroundJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-824)/2, (screenSize.height-508)/2, 824, 508);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextArea1.getText().isEmpty() && !jTextField1.getText().isEmpty()) {
            jTextArea1.setText(jTextArea1.getText().toLowerCase());
            jTextField1.setText(jTextField1.getText().toLowerCase());
            String[] t = jTextArea1.getText().split("\n");
            Conversiones con = new Conversiones();
            Ecuacion fo = new ValidadorEcuacion().validar(jTextField1.getText());
            Ecuacion[] rest = new Ecuacion[t.length];

            for (int i = 0; i < rest.length; i++) {
                rest[i] = new ValidadorEcuacion().validar(t[i]);
            }
	    
            changeTable(con.conversiones(fo, rest));

            Simplex simplexTabular = new SimplexTabular();

            simplexTabular.maximizar(fo, rest);
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar al menos una restricción y la función objetivo", "Faltan elementos restrición o función objetivo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void changeTable(javax.swing.table.DefaultTableModel model) {
        jTable1.setModel(model);
    }

    @Override
    public void run() {
        setVisible(true);
    }
}
