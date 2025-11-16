package Control;

import Vista.VistaPrincipal;
import Vista.VistaTabla;

public final class Gestor {

    public VistaPrincipal vistaPrin;
    public VistaTabla vistaTabla;

    public Gestor() {
        PagPrincipal();
    }

    public void PagPrincipal() {
        if (vistaTabla != null) {
            vistaTabla.dispose();
        }
        vistaPrin = new VistaPrincipal(this);
    }

    public void VistaTabla(int destinos, int fabricas, String Modelo) {
        vistaPrin.dispose();
        vistaTabla = new VistaTabla(this);
        vistaTabla.Title.setText("Modelo " + Modelo);
        vistaTabla.MostrarTabla(destinos, fabricas);
    }

    public void Resolver(int[] oferta,int[] demanda,int[][] costos) {
        Vogel metodoVogel=new Vogel();
        int[][] solucion= metodoVogel.vogelApproximation(costos, oferta, demanda);
        vistaTabla.TablaResuelta(solucion);
        vistaTabla.Title.setText("el costo total es de :"+metodoVogel.totalCost(solucion, costos) );
    }
}
