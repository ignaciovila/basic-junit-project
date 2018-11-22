import org.junit.Assert;
import org.junit.Test;

public class PrimerTest {
    @Test
    public void primerTest() {
        // preparación
        String aCortar = "el que voy a cortar";
        // ejecución
        String cortado = aCortar.substring(0, 6);
        // validación
        Assert.assertEquals("el que", cortado);
    }

    @Test
    public void abrirConClaveCorrecta(){
        Cerradura primerCerradura = new Cerradura(1234,3);
        int clave = 1234;
        primerCerradura.abrir(clave);
        Assert.assertEquals(true, primerCerradura.estaAbierta());
    }

    @Test
    public void abrirConClaveIncorrecta() {
        Cerradura primerCerradura = new Cerradura(1234,3);
        int clave = 5678;
        primerCerradura.abrir(clave);
        Assert.assertEquals(false, primerCerradura.estaAbierta());
    }

    @Test
    public void aperturaCerraduraBloqueada() {
        Cerradura primerCerradura = new Cerradura(1234,3);
        int clave = 5678;
        primerCerradura.abrir(clave);
        primerCerradura.abrir(clave);
        primerCerradura.abrir(clave);
        primerCerradura.abrir(1234);

        Assert.assertEquals(false, primerCerradura.estaAbierta());
    }

    @Test
    public void aperturaCerradura2IntentosIncorrectosSinBloquearse(){
        Cerradura primerCerradura = new Cerradura(1234,3);
        int clave = 5678;
        primerCerradura.abrir(clave);
        primerCerradura.abrir(clave);
        primerCerradura.abrir(1234);

        Assert.assertEquals(true, primerCerradura.estaAbierta());
    }

    @Test
    public void contarUnaAperturaExitosa(){
        Cerradura primerCerradura = new Cerradura(1234,3);
        int clave = 1234;
        primerCerradura.abrir(clave);
        Assert.assertEquals(1, primerCerradura.contarAperturasExitosas());
    }

    @Test
    public void contarDosAperturaFallidas(){
        Cerradura primerCerradura = new Cerradura(1234,3);
        int clave = 5678;
        primerCerradura.abrir(clave);
        primerCerradura.abrir(clave);
        primerCerradura.abrir(1234);
        Assert.assertEquals(2, primerCerradura.contarAperturasFallidas());
    }

    @Test
    public void verificarCerraduraCerradaAlInicio(){
        Cerradura primerCerradura = new Cerradura(1234,3);
        Assert.assertTrue(primerCerradura.estaCerrada());
    }

    @Test
    public void abrirYCerrarCerradura(){
        Cerradura cerradura = new Cerradura(1234, 3);

        cerradura.abrir(1234);
        cerradura.cerrar();

        Assert.assertTrue(cerradura.estaCerrada());
    }
}
