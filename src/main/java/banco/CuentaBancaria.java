package banco;

public abstract class CuentaBancaria {
    protected int saldo;

    public CuentaBancaria(Cliente cliente) {

    }

    protected CuentaBancaria() {
    }

    public abstract boolean depositar(int monto);
    public abstract void extraer(int monto);

    public int getSaldo() {
        return saldo;
    }
}
