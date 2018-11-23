package estacionamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayaDeCarga implements Playa{
    private List<Utilitario> utilitarios;
    private List<Carga> cargas;
    private int cantidadDespachada;

    public PlayaDeCarga(List<Carga> cargas) {
        this.cargas = cargas;
        this.utilitarios = new ArrayList<Utilitario>();
    }

    public boolean estaAbierto() {
        return cargas.size() > 0;
    }

    public List<Utilitario> getUtilitarios(){
        return this.utilitarios;
    }

    @Override
    public void estacionar(List<Vehiculo> vehiculos) {
        if(estaAbierto()) {
            for (Vehiculo vehiculo : vehiculos)  utilitarios.add((Utilitario) vehiculo);
        }
    }

    public int utilitarioVacios(){
        int cantidadUtilitariosVacios = 0;
        for (Utilitario utilitario : utilitarios) {
            if (utilitario.getCargas().isEmpty()) cantidadUtilitariosVacios++;
        }
        return cantidadUtilitariosVacios;
    }

    public void cargar(){
      //  cargas.sort(Comparator.comparingInt(Carga::getPeso));

        while(!utilitarios.isEmpty() && !cargas.isEmpty()) {
            Utilitario utilitario = utilitarios.get(0);
            List<Carga> cargaDespachada = new ArrayList<>();
            for (Carga carga : cargas) {
                if(utilitario.getCargaDisponible() > carga.getPeso()) {
                    utilitario.addCarga(carga);
                    cargaDespachada.add(carga);
                    cantidadDespachada++;
                }
                salir(utilitario);
                //utilitarios.remove(utilitario);
            }

            cargas.removeAll(cargaDespachada);

        }
    }

    @Override
    public void salir(Vehiculo vehiculo) {
        Utilitario utilitario = (Utilitario) vehiculo;
            utilitarios.remove(utilitario);
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public int getCantidadDespachada() {
        return cantidadDespachada + 1;
    }
}
