
package modelo;

public class EsquinaNoroeste {

    // Método que aplica la esquina noroeste y devuelve la matriz de asignaciones
    public int[][] esquinaNoroeste(int[][] cost, int[] oferta, int[] demand) {

        int m = oferta.length;
        int n = demand.length;

        int[][] allocation = new int[m][n];

        // Copias para no modificar los vectores originales
        int[] S = oferta.clone();
        int[] D = demand.clone();

        int i = 0; // fila
        int j = 0; // columna

        while (i < m && j < n) {
            int quantity = Math.min(S[i], D[j]); // lo que se puede asignar
            allocation[i][j] = quantity;

            S[i] -= quantity;
            D[j] -= quantity;

            // si se agotó la oferta de la fila
            if (S[i] == 0) {
                i++; // avanzar a la siguiente fila
            }

            // si se agotó la demanda de la columna
            if (D[j] == 0) {
                j++; // avanzar a la siguiente columna
            }
        }

        return allocation;
    }

    // Calcular costo total
    public int totalCost(int[][] allocation, int[][] cost) {
        int total = 0;
        for (int i = 0; i < allocation.length; i++) {
            for (int j = 0; j < allocation[0].length; j++) {
                total += allocation[i][j] * cost[i][j];
            }
        }
        return total;
    }

}

