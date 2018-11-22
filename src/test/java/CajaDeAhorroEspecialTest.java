import banco.CajaDeAhorroEspecial;
import banco.Cliente;
import banco.SaldoInsuficienteException;
import org.junit.Assert;
import org.junit.Test;

public class CajaDeAhorroEspecialTest {

    @Test
    public void extraerAUnaCuentaSinSaldoConMontoMenorAlDescubierto(){
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(5000, new Cliente());
        cajaDeAhorroEspecial.extraer(1000);

        Assert.assertEquals(cajaDeAhorroEspecial.getSaldo(), -1000);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void extraerAUnaCuentaSinSaldoConMontoMayorAlDescubierto(){
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(5000, new Cliente());
        cajaDeAhorroEspecial.extraer(6000);
    }
}