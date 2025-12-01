package Vista;

import Control.Gestor;
import javax.swing.*;

public class VistaPrincipal extends javax.swing.JFrame {

    private Gestor gestor;

    public VistaPrincipal(Gestor gestor) {
        this.gestor = gestor;
        initComponents();
        customizeUI();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void customizeUI() {
        setTitle("Problema de Transporte - Configuración");

        // Fondo general claro
        getContentPane().setBackground(new java.awt.Color(240, 240, 240));

        // Tarjeta central similar a "Datos de usuario"
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22));
      

        bntSeguir.setText("Crear tabla");
        bntSeguir.setToolTipText("Generar la tabla para ingresar costos, oferta y demanda");
        Nfabricas.setToolTipText("Número de fábricas (orígenes)");
        Ndestinos.setToolTipText("Número de destinos (demandas)");
        modelo.setToolTipText("Seleccione el método inicial: Vogel o Esquina Noroeste");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Ndestinos = new javax.swing.JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
        modelo = new javax.swing.JComboBox<>();
        Nfabricas = new javax.swing.JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bntSeguir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("METODO VOGEL / ESQUINA NOROESTE");

        Ndestinos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        modelo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vogel", "Esquina noroeste" }));

        Nfabricas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Modelo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("N. Destinos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("N. Fabricas");

        bntSeguir.setText("SIGUIENTE");
        bntSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSeguirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ndestinos)
                            .addComponent(modelo, 0, 231, Short.MAX_VALUE)
                            .addComponent(Nfabricas))
                        .addGap(317, 317, 317))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(bntSeguir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(64, 64, 64)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nfabricas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(66, 66, 66)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Ndestinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(68, 68, 68)
                .addComponent(bntSeguir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSeguirActionPerformed
        int destinos=Integer.parseInt(""+Ndestinos.getValue());
        int fabricas=Integer.parseInt(""+Nfabricas.getValue());
        gestor.VistaTabla(destinos,fabricas,modelo.getSelectedItem().toString());
    }//GEN-LAST:event_bntSeguirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Ndestinos;
    private javax.swing.JSpinner Nfabricas;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton bntSeguir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> modelo;
    // End of variables declaration//GEN-END:variables
}
