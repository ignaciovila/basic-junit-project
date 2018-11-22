package estacionamiento;

import java.util.List;

public class Utilitario extends Vehiculo {
    private int cargaMaxima;
    private List<Carga> cargas;

    public int getCargaMaxima(){
        return cargaMaxima;
    }

    public int getCargaDisponible() {
        return  cargaMaxima - cargas.stream().mapToInt(Carga::getPeso).sum();
    }

    public void addCarga(Carga carga) {
        cargas.add(carga);
    }
}
