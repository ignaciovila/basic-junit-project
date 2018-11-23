package estacionamiento;

import java.util.ArrayList;
import java.util.List;

public abstract class Utilitario extends Vehiculo {
    private int cargaMaxima;
    private List<Carga> cargas = new ArrayList<>();

    public Utilitario(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
        cargas = new ArrayList<>();
    }

    public int getCargaMaxima(){
        return cargaMaxima;
    }

    public int getCargaDisponible() {
        return  cargaMaxima - cargas.stream().mapToInt(Carga::getPeso).sum();
    }

    public void addCarga(Carga carga) {
        cargas.add(carga);
    }

    public List<Carga> getCargas() {
        return cargas;
    }
}
