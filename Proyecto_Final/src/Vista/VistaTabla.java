package Vista;

import Control.Gestor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaTabla extends javax.swing.JFrame {

    public static int destinos, fabricas;
    DefaultTableModel modelotabla;
    private Gestor gestor;
    private String modelo;

    public VistaTabla(Gestor gestor, String modelo) {
        this.gestor = gestor;
        this.modelo = modelo;
        initComponents();
        customizeUI();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void customizeUI() {
        setTitle("Problema de Transporte - " + modelo);

        // Encabezado tipo bloque con explicación
        Title.setText("<html><b>Matriz de costos y resultados - Modelo: " + modelo + "</b><br/>"
                + "Complete la tabla con los costos, la producción por fábrica y la demanda por destino; "
                + "luego presione \"Calcular solución\"." + "</html>");
        Title.setHorizontalAlignment(SwingConstants.LEFT);
        Title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Tabla.setFillsViewportHeight(true);
      
        bResolver.setToolTipText("Resuelve el problema de transporte usando el modelo seleccionado");
        bVolver.setToolTipText("Regresa a la pantalla de configuración del problema");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bResolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Title = new javax.swing.JLabel();
        bVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bResolver.setText("Calcular solucion");
        bResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResolverActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla.setAutoscrolls(false);
        Tabla.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(Tabla);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("jLabel1");

        bVolver.setText("Volver al inicio");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(bVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bResolver, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(bVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //me debuelve a la paguina principal
    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        gestor.PagPrincipal();
    }//GEN-LAST:event_bVolverActionPerformed
    //Dependiendo de el modelo escogido me saca la informacion de la tabla y la manda a su respectivo metodo
    private void bResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResolverActionPerformed
        int[][] cost = new int[Tabla.getRowCount() - 1][Tabla.getColumnCount() - 2];
        int[] oferta = new int[Tabla.getRowCount() - 1];
        int[] demand = new int[Tabla.getColumnCount() - 2];
        //Separa las ofertas
        for (int i = 0; i < Tabla.getRowCount() - 1; i++) {
            Object valor = Tabla.getValueAt(i, Tabla.getColumnCount() - 1);
            if (valor == null || valor.toString().isEmpty()) {
                oferta[i] = 0; // evitar errores con celdas vacías
            } else {
                oferta[i] = Integer.parseInt(valor.toString());
            }
        }
        //Separa las demandas
        for (int i = 0; i < Tabla.getColumnCount() - 2; i++) {
            Object valor = Tabla.getValueAt(Tabla.getRowCount() - 1, i + 1);
            if (valor == null || valor.toString().isEmpty()) {
                demand[i] = 0; // evitar errores con celdas vacías
            } else {
                demand[i] = Integer.parseInt(valor.toString());
            }
        }
        //Separa los costos
        for (int i = 0; i < Tabla.getRowCount() - 1; i++) {
            for (int j = 1; j < Tabla.getColumnCount() - 1; j++) {
                Object valor = Tabla.getValueAt(i, j);
                if (valor == null || valor.toString().isEmpty()) {
                    cost[i][j - 1] = 0; // evitar errores con celdas vacías
                } else {
                    cost[i][j - 1] = Integer.parseInt(valor.toString());
                }

            }
        }
        if ("vogel".equals(modelo)) {
            gestor.ResolverVogel(oferta, demand, cost);
        } else {
            gestor.ResolverEsquina(oferta, demand, cost);
        }
    }//GEN-LAST:event_bResolverActionPerformed

    //muesctra la tabla con los destinos y las fabricas asignados
    public void MostrarTabla(int destinos, int fabricas) {
        String[] columnas = new String[destinos + 2];
        columnas[0] = "Fábricas";
        for (int i = 1; i <= destinos; i++) {
            columnas[i] = "Destino " + i;
        }
        columnas[destinos + 1] = "Produccion";
        modelotabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                if (row == fabricas && column == destinos + 1) {
                    return false;
                }
                return true;
            }
        };

        for (int i = 1; i <= fabricas; i++) {
            Object[] fila = new Object[columnas.length];
            fila[0] = "Fábrica " + i;
            modelotabla.addRow(fila);
        }
        Object[] fila = new Object[columnas.length];
        fila[0] = "Demanda";
        modelotabla.addRow(fila);
        Tabla.setModel(modelotabla);
        Tabla.setRowHeight((int) (389 / (fabricas + 1)));
    }

    //me modifica la tabla para q se mestren los valores asignado a cada celda
    public void TablaResuelta(int[][] solucion) {
        for (int i = 0; i < Tabla.getRowCount() - 1; i++) {
            for (int j = 0; j < Tabla.getColumnCount() - 2; j++) {
                int valor = solucion[i][j];
                Tabla.setValueAt(valor, i, j + 1);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    public javax.swing.JLabel Title;
    private javax.swing.JButton bResolver;
    private javax.swing.JButton bVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
