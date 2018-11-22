package estacionamiento;

import java.util.List;

public class PlayaDeEstacionamiento implements Playa{
    private List<Auto>autos;

    @Override
    public void estacionar(Vehiculo vehiculo) {
        autos.add((Auto) vehiculo);
    }

    @Override
    public void salir(Vehiculo vehiculo) {
        autos.remove(vehiculo);
    }
}
