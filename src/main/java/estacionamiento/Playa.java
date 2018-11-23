package estacionamiento;

import java.util.List;

public interface Playa {
    void estacionar(List<Vehiculo> vehiculos);
    void salir(Vehiculo vehiculo);
}
