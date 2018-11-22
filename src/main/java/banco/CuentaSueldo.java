package banco;

public class CuentaSueldo extends CuentaBancaria {

    private int extracciones;

    public CuentaSueldo(Cliente cliente) {
        super(cliente);
    }

    public boolean depositar(int monto) {
        saldo += monto;

        return true;
    }

    public void extraer(int monto) {
        int suma = 0;

        if(extracciones % 5 == 4) {
            suma = 15;
        }
        suma += monto;

        if (saldo < suma) {
            throw new SaldoInsuficienteException();
        }
        saldo -= suma;
        extracciones++;
    }
}
