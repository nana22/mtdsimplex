/*
 * @charset "utf-8";
 * @(#)VentanaPrincipal.java 1.9.1 10/10/09
 *
 * Created on 5/10/2009, 03:50:48 PM
 */
package mx.uacam.fdi.io.simplex.ui;

import javax.swing.JOptionPane;
import mx.uacam.fdi.io.simplex.resolvedor.SimplexTabular;
import mx.uacam.fdi.io.simplex.resolvedor.mate.Conversiones;
import mx.uacam.fdi.io.simplex.resolvedor.mate.Ecuacion;
import mx.uacam.fdi.io.simplex.ui.recursos.ValidadorEcuacion;

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButtonMaximizar;
    private javax.swing.JRadioButton jRadioButtonMetodoM;
    private javax.swing.JRadioButton jRadioButtonMetodoTabular;
    private javax.swing.JRadioButton jRadioButtonMinimizar;
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
        jRadioButtonMetodoTabular = new javax.swing.JRadioButton();
        jRadioButtonMetodoM = new javax.swing.JRadioButton();
        jRadioButtonMaximizar = new javax.swing.JRadioButton();
        jRadioButtonMinimizar = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Método simplex");

        backgroundJPanel1.setFondoImagenIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/uacam/fdi/io/simplex/ui/recursos/imagenes/design519_4_1024.jpg"))); // NOI18N

        fondoJPanel1.setAlpha(130);
        fondoJPanel1.setBackground(java.awt.Color.white);

        jLabelTitulo.setFont(new java.awt.Font("Gill Sans MT", 1, 24));
        jLabelTitulo.setForeground(new java.awt.Color(102, 0, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Método simplex");

        fondoJPanel2.setAlpha(200);
        fondoJPanel2.setBackground(java.awt.Color.white);

        jLabel2.setText("Función objetivo");

        jLabel3.setText("Restricciones");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        buttonGroup1.add(jRadioButtonMetodoTabular);
        jRadioButtonMetodoTabular.setSelected(true);
        jRadioButtonMetodoTabular.setText("Método tabular");
        jRadioButtonMetodoTabular.setOpaque(false);

        buttonGroup1.add(jRadioButtonMetodoM);
        jRadioButtonMetodoM.setText("Método de la M");
        jRadioButtonMetodoM.setOpaque(false);

        buttonGroup2.add(jRadioButtonMaximizar);
        jRadioButtonMaximizar.setSelected(true);
        jRadioButtonMaximizar.setText("Maximizar");
        jRadioButtonMaximizar.setOpaque(false);

        buttonGroup2.add(jRadioButtonMinimizar);
        jRadioButtonMinimizar.setText("Minimizar");
        jRadioButtonMinimizar.setOpaque(false);

        jButton1.setText("Resolver");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoJPanel2Layout = new javax.swing.GroupLayout(fondoJPanel2);
        fondoJPanel2.setLayout(fondoJPanel2Layout);
        fondoJPanel2Layout.setHorizontalGroup(
            fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoJPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondoJPanel2Layout.createSequentialGroup()
                        .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonMetodoTabular)
                            .addComponent(jRadioButtonMetodoM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonMaximizar)))
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        fondoJPanel2Layout.setVerticalGroup(
            fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(fondoJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButtonMaximizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonMinimizar))
                    .addGroup(fondoJPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButtonMetodoTabular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonMetodoM)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "No. de Ecuación", "Variable básica", "x1", "x2", "x3", "b"
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fondoJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)))
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
            if (jRadioButtonMetodoTabular.isSelected()) {
                metodoTabular();
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar al menos una"
                    + " restricción y la función objetivo"
                    , "Faltan elementos restrición o función objetivo"
                    , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    @Override
    public void run() {
        setVisible(true);
    }

    public void metodoTabular() {
        jTextArea1.setText(jTextArea1.getText().toLowerCase());
        jTextField1.setText(jTextField1.getText().toLowerCase());

        String[] lineas = jTextArea1.getText().split("\n");
        Ecuacion fo = new ValidadorEcuacion().validar(jTextField1.getText());
        Ecuacion[] restricciones = new Ecuacion[lineas.length];

        for (int i = 0; i < restricciones.length; i++) {
            restricciones[i] = new ValidadorEcuacion().validar(lineas[i]);
        }

        jTable1.setModel((new Conversiones().conversiones(fo, restricciones)));

        double[] d = jRadioButtonMinimizar.isSelected() ?
            new SimplexTabular().minimizar(fo, restricciones) :
            new SimplexTabular().maximizar(fo, restricciones);
        String s = "";

        for (int i = 0; i < d.length - 1; i++) {
            s += d[i] + " ";
        }

        s += "z=" + d[d.length - 1];

        JOptionPane.showMessageDialog(null, "Los resultados de son: " + s);
    }
}
