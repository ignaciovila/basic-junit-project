import banco.Cliente;
import banco.CuentaSueldo;
import banco.SaldoInsuficienteException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class CuentaSueldoTest {
    @Test(expected = SaldoInsuficienteException.class)
    public void cuentaSinSaldoLanzaSaldoInsuficienteException(){
        CuentaSueldo cuentaSueldo = new CuentaSueldo(new Cliente());
        cuentaSueldo.extraer(1000);
    }

    @Test
    public void quintaExtraccionCobraComision() {
        CuentaSueldo cuentaSueldo = new CuentaSueldo(new Cliente());
        cuentaSueldo.depositar(1000);
        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(10);
        assertThat(cuentaSueldo.getSaldo(), is(935));
    }

    @Test
    public void siSeLanzaExcepcionNoCuentaComoExtraccion(){
        CuentaSueldo cuentaSueldo = new CuentaSueldo(new Cliente());
        cuentaSueldo.depositar(1000);
        try {
            cuentaSueldo.extraer(10000);
        } catch (SaldoInsuficienteException e) {
            cuentaSueldo.extraer(10);
            cuentaSueldo.extraer(10);
            cuentaSueldo.extraer(10);
            cuentaSueldo.extraer(10);
            assertThat(cuentaSueldo.getSaldo(), is(960));
            return;
        }
        fail();
    }
}