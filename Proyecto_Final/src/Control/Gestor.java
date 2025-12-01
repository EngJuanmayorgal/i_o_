package Control;

import modelo.Vogel;
import Vista.VistaPrincipal;
import Vista.VistaTabla;
import modelo.EsquinaNoroeste;

public final class Gestor {

    public VistaPrincipal vistaPrin;
    public VistaTabla vistaTabla;

    public Gestor() {
        PagPrincipal();
    }

    //aca se crea la vista principal donde se escogen el modelo, las fabricas y los destinos
    public void PagPrincipal() {
        if (vistaTabla != null) {
            vistaTabla.dispose();
        }
        vistaPrin = new VistaPrincipal(this);
    }

    //me crea la vista de la tabla con la cantidad de fabricas y destinos
    public void VistaTabla(int destinos, int fabricas, String Modelo) {
        vistaPrin.dispose();
        vistaTabla = new VistaTabla(this, Modelo);
        vistaTabla.MostrarTabla(destinos, fabricas);
    }

    //crea una clase vogel para poder resolver el problema y me configura la tabla visible para q se vea el resultado
    public void ResolverVogel(int[] oferta, int[] demanda, int[][] costos) {
        int[][] solucion = Vogel.vogelApproximation(costos, oferta, demanda);
        vistaTabla.TablaResuelta(solucion);
        vistaTabla.Title.setText("el costo total es de :" + Vogel.totalCost(solucion, costos));
    }

    //crea una clase esquinaNoroeste para poder resolver el problema y me configura la tabla visible para q se vea el resultado
    public void ResolverEsquina(int[] oferta, int[] demanda, int[][] costos) {
        int[][] solucion = EsquinaNoroeste.esquinaNoroeste(costos, oferta, demanda);
        vistaTabla.TablaResuelta(solucion);
        vistaTabla.Title.setText("El costo total es de :" + EsquinaNoroeste.totalCost(solucion, costos));
    }
}
