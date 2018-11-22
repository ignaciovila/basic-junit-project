package banco;

public class CajaDeAhorroEspecial extends CajaDeAhorro {

    private int limite;

    CajaDeAhorroEspecial(int limite, Cliente cliente){
        super(cliente);
        this.limite = limite;
    }

    @Override
    public void extraer(int monto) {
        if (monto < saldo) {
            saldo -= monto;
        } else if(monto < saldo + limite) {
            saldo-=monto;
            titular.notificarGiroDescubierto(this);
        } else {
            throw new SaldoInsuficienteException();
        }
    }
}
