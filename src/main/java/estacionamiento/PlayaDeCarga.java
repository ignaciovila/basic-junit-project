package estacionamiento;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayaDeCarga implements Playa{
    private List<Utilitario> utilitarios;
    private List<Carga> cargas;

    public PlayaDeCarga(List<Carga> cargas) {
        this.cargas = cargas;
        this.utilitarios = Collections.emptyList();
    }

    boolean estaAbierto() {
        return cargas.size() > 0;
    }

    @Override
    public void estacionar(Vehiculo vehiculo) {
        if(estaAbierto())
            utilitarios.add((Utilitario) vehiculo);
    }

    public void cargar(){
        cargas.sort(Comparator.comparingInt(Carga::getPeso));

        while(!utilitarios.isEmpty() && !cargas.isEmpty()) {
            Utilitario utilitario = utilitarios.get(0);
            for (Carga carga :
                    cargas) {
                while(utilitario.getCargaDisponible() > carga.getPeso()) {
                    cargas.remove(carga);
                    utilitario.addCarga(carga);
                }
            }
        }
    }

    @Override
    public void salir(Vehiculo vehiculo) {
        Utilitario utilitario = (Utilitario) vehiculo;
        if (utilitario.getCargaDisponible() == 0){
            utilitarios.remove(utilitario);
        }
    }
}
