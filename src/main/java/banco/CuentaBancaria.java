package banco;

public abstract class CuentaBancaria {
    protected int saldo;

    public abstract boolean depositar(int monto);
    public abstract void extraer(int monto);

    public int getSaldo() {
        return saldo;
    }
}
