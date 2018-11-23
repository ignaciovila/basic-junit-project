package estacionamiento;

import java.util.Collection;
import java.util.List;

public class PlayaDeEstacionamiento implements Playa{
    private List<Vehiculo> autos;
    private List<Utilitario> utilitarios;

    @Override
    public void estacionar(List<Vehiculo> vehiculos) {
        autos = vehiculos;
    }

    @Override
    public void salir(Vehiculo vehiculo) {
        autos.remove(vehiculo);
    }
}
