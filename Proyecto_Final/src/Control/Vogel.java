package Control;

import java.util.Arrays;

public final class Vogel {

    public Vogel() {
    }

    // Ejecuta el método de Vogel y devuelve la matriz de asignaciones
    public int[][] vogelApproximation(int[][] cost, int[] oferta, int[] demand) {
        // Copias para no modificar entradas originales
        int m = oferta.length;
        int n = demand.length;

        // Balancear si oferta != demand
        int sumOferta = Arrays.stream(oferta).sum();
        int sumDemand = Arrays.stream(demand).sum();

        int[][] C = cost;
        int[] S = Arrays.copyOf(oferta, oferta.length);
        int[] D = Arrays.copyOf(demand, demand.length);

        if (sumOferta != sumDemand) {
            if (sumOferta > sumDemand) {
                // añadir columna para balancear la demanda
                n = demand.length + 1;
                int[][] newC = new int[m][n];
                for (int i = 0; i < m; i++) {
                    System.arraycopy(C[i], 0, newC[i], 0, C[i].length);
                    newC[i][n - 1] = 0;
                }
                C = newC;
                D = Arrays.copyOf(D, n);
                D[n - 1] = sumOferta - sumDemand;
            } else {
                // añadir fila para balancear la oferta
                m = oferta.length + 1;
                int[][] newC = new int[m][n];
                for (int i = 0; i < cost.length; i++) {
                    System.arraycopy(C[i], 0, newC[i], 0, C[i].length);
                }
                for (int j = 0; j < n; j++) {
                    newC[m - 1][j] = 0;
                }
                C = newC;
                S = Arrays.copyOf(S, m);
                S[m - 1] = sumDemand - sumOferta;
            }
        }

        // Inicializar asignaciones con ceros y marcas de filas/columnas agotadas
        int[][] allocation = new int[m][n];
        boolean[] rowDone = new boolean[m];
        boolean[] colDone = new boolean[n];
        // para romper cuando todas las filas y columnas procesadas

        int rowsLeft = m;
        int colsLeft = n;

        while (rowsLeft > 0 && colsLeft > 0) {
            // Calcular penalizaciones para filas y columnas
            int[] rowPenalty = new int[m];
            int[] colPenalty = new int[n];

            for (int i = 0; i < m; i++) {
                if (rowDone[i]) {
                    rowPenalty[i] = -1; // inactivo
                    continue;
                }
                // encontrar dos menores costos en la fila i entre columnas no agotadas
                int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (colDone[j]) {
                        continue;
                    }
                    int val = C[i][j];
                    if (val < min1) {
                        min2 = min1;
                        min1 = val;
                    } else if (val < min2) {
                        min2 = val;
                    }
                }
                if (min1 == Integer.MAX_VALUE) {
                    rowPenalty[i] = -1; // fila sin columnas disponibles
                } else if (min2 == Integer.MAX_VALUE) {
                    rowPenalty[i] = Integer.MAX_VALUE / 4; // solo una opción -> gran pen
                } else {
                    rowPenalty[i] = min2 - min1;
                }
            }

            for (int j = 0; j < n; j++) {
                if (colDone[j]) {
                    colPenalty[j] = -1;
                    continue;
                }
                int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    if (rowDone[i]) {
                        continue;
                    }
                    int val = C[i][j];
                    if (val < min1) {
                        min2 = min1;
                        min1 = val;
                    } else if (val < min2) {
                        min2 = val;
                    }
                }
                if (min1 == Integer.MAX_VALUE) {
                    colPenalty[j] = -1;
                } else if (min2 == Integer.MAX_VALUE) {
                    colPenalty[j] = Integer.MAX_VALUE / 4;
                } else {
                    colPenalty[j] = min2 - min1;
                }
            }

            // Encontrar la mayor penalización
            int maxRowPen = -1, maxRowIdx = -1;
            for (int i = 0; i < m; i++) {
                if (rowPenalty[i] > maxRowPen) {
                    maxRowPen = rowPenalty[i];
                    maxRowIdx = i;
                }
            }
            int maxColPen = -1, maxColIdx = -1;
            for (int j = 0; j < n; j++) {
                if (colPenalty[j] > maxColPen) {
                    maxColPen = colPenalty[j];
                    maxColIdx = j;
                }
            }

            boolean chooseRow;
            int chosenIndex;
            if (maxRowPen > maxColPen) {
                chooseRow = true;
                chosenIndex = maxRowIdx;
            } else {
                chooseRow = false;
                chosenIndex = maxColIdx;
            }

            // Encontrar la celda (i,j) con menor costo en la fila o columna elegida
            int pickI = -1, pickJ = -1;
            if (chooseRow) {
                int i = chosenIndex;
                int minCost = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (colDone[j]) {
                        continue;
                    }
                    if (C[i][j] < minCost) {
                        minCost = C[i][j];
                        pickI = i;
                        pickJ = j;
                    }
                }
            } else {
                int j = chosenIndex;
                int minCost = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    if (rowDone[i]) {
                        continue;
                    }
                    if (C[i][j] < minCost) {
                        minCost = C[i][j];
                        pickI = i;
                        pickJ = j;
                    }
                }
            }

            if (pickI == -1 || pickJ == -1) {
                break; // seguridad
            }
            // Asignar la cantidad mínima entre oferta y demand
            int quantity = Math.min(S[pickI], D[pickJ]);
            allocation[pickI][pickJ] = quantity;
            S[pickI] -= quantity;
            D[pickJ] -= quantity;

            // Marcar fila/col si se agotaron
            if (S[pickI] == 0 && !rowDone[pickI]) {
                rowDone[pickI] = true;
                rowsLeft--;
            }
            if (D[pickJ] == 0 && !colDone[pickJ]) {
                colDone[pickJ] = true;
                colsLeft--;
            }

            // En caso de degeneración (ambos 0), se puede marcar una sola (por convención marcamos la columna)
            if (S[pickI] == 0 && D[pickJ] == 0) {
                // Para mantener número correcto de celdas básicas, se deja una asignación cero en siguiente elección.
                // Marcamos la columna como agotada (ya está marcado arriba). Si quieres otra convención, cámbiala.
            }
        }

        return allocation;
    }

    // Calcula el costo total de la matriz de asignaciones
    public int totalCost(int[][] allocation, int[][] cost) {
        int total = 0;
        int m = allocation.length;
        int n = allocation[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += allocation[i][j] * cost[i][j];
            }
        }
        return total;
    }

}
