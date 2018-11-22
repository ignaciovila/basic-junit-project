public class Cerradura {

    private boolean abierto;
    private int intentos;
    private int claveDeApertura;
    private int cantidadDeFallosConsecutivosQueLaBloquean;
    private int aperturasExitosas, aperturasFallidas;

    public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
        abierto = false;
        intentos = 0;
        this.claveDeApertura = claveDeApertura;
        this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
    }

    public boolean abrir(int clave) {
        if (intentos < cantidadDeFallosConsecutivosQueLaBloquean & !abierto) {
            if (clave == claveDeApertura) {
                abierto = true;
                aperturasExitosas++;
            } else {
                intentos++;
                aperturasFallidas++;
            }
        }
        return abierto;
    }

    public void cerrar() {
        abierto = false;
    }

    public boolean estaAbierta(){
        return abierto;
    }

    public boolean estaCerrada(){
        return !abierto;
    }

    public boolean fueBloqueada(){
        return intentos == 3;
    }

    public int contarAperturasExitosas(){
        return aperturasExitosas;
    }

    public int contarAperturasFallidas(){
        return aperturasFallidas;
    }

    public int getIntentos(){
        return intentos;
    }
}


