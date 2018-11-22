package banco;

public class CajaDeAhorro extends CuentaBancaria {

    protected Cliente titular;

    public CajaDeAhorro(Cliente cliente){
        this.titular = cliente;
    }

    public boolean depositar(int monto) {
        saldo += monto;
        return true;
    }

    public void extraer(int monto) {
        if (monto <= saldo){
            saldo -= monto;
        } else {
            throw new SaldoInsuficienteException();
        }

    }
}
