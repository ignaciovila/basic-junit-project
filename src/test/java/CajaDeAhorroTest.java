import banco.CajaDeAhorro;
import banco.Cliente;
import banco.SaldoInsuficienteException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CajaDeAhorroTest {

    @Test
    public void depositarCajaDeAhorro(){
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(new Cliente());
        cajaDeAhorro.depositar(100);
        assertThat(cajaDeAhorro.getSaldo(), is(100));
    }

    @Test
    public void extraerSaldoSuficiente() {
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(new Cliente());
        cajaDeAhorro.depositar(100);

        cajaDeAhorro.extraer(25);

        assertThat(cajaDeAhorro.getSaldo(), is(75));
    }


    @Test(expected = SaldoInsuficienteException.class)
    public void cuentaSinSaldoLanzaSaldoInsuficienteException(){
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(new Cliente());
        cajaDeAhorro.extraer(1000);
    }

}