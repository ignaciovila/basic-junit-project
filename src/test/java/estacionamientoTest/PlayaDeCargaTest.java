package estacionamientoTest;

import estacionamiento.*;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;


public class PlayaDeCargaTest {

    List<Vehiculo> utilitarioList;
    PlayaDeCarga playaDeCarga;
    Carga carga;
    Camion camion;
    Camioneta camioneta;

    @Before
    public void setup() {
        utilitarioList = new ArrayList<>();
        camioneta = new Camioneta(10);
        camion = new Camion(10);
        utilitarioList.add(camion);
        utilitarioList.add(camioneta);
        carga = new Carga(1);
        List<Carga> cargaList = new ArrayList<>();
        cargaList.add(carga);
        playaDeCarga = new PlayaDeCarga(cargaList);
        playaDeCarga.estacionar(utilitarioList);
    }

    @Test
    public void informarVacios() {
        int cantVacios = playaDeCarga.utilitarioVacios();
        Assert.assertTrue(cantVacios == 2);
    }

    @Test
    public void estacionarUnCamionesyDosCamionetas(){
        utilitarioList.clear();
        Camioneta camioneta = new Camioneta(2);
        utilitarioList.add(camioneta);
        playaDeCarga.estacionar(utilitarioList);
        Assert.assertTrue(playaDeCarga.getUtilitarios().size()==3);
    }

    @Test
    public void depacharUtilitarioDeLaPlayaDeCarga(){
        utilitarioList.clear();

        Camioneta camioneta = new Camioneta(2);
        utilitarioList.add(camioneta);
        playaDeCarga.estacionar(utilitarioList);

        playaDeCarga.salir(camioneta);

        Assert.assertTrue(playaDeCarga.getUtilitarios().size()==2);
    }

    @Test
    public void alCargarDejaDeExistirCargaEnLaPlaya() {
        playaDeCarga.cargar();

        Assert.assertTrue(!playaDeCarga.getCargas().contains(carga));
    }

    @Test
    public void alCargarDosCargasLaCantidadDespachadaEsDos() {
        Carga carga = new Carga(2);
        playaDeCarga.getCargas().add(carga);
        playaDeCarga.cargar();

        Assert.assertThat(playaDeCarga.getCantidadDespachada(), is(3));
    }

    @Test
    public void sinCargasLaPlayaEstaCerrada(){
        playaDeCarga.cargar();

        Assert.assertTrue(!playaDeCarga.estaAbierto());
    }

    @Test
    public void vehiculoPoseeCargaCuandoAsigna(){
        playaDeCarga.cargar();
        Assert.assertTrue(camion.getCargas().size()==1);
    }
}
