package banco;

import java.util.List;

public class CajaDeAhorroMulticliente extends CuentaBancaria {
    private List<Cliente> cotitulares;

    public CajaDeAhorroMulticliente(List<Cliente> cliente) {
        cotitulares = cliente;
    }

    @Override
    public boolean depositar(int monto) {
        return false;
    }

    @Override
    public void extraer(int monto) {

    }
}
