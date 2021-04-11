package app;

import app.personas.Director;
public class Episodio {

    public Episodio(int numero, String nombre){
        this.numero = numero;
        this.nombre = nombre;
    }

    public Episodio(int numero, String nombre, int duracion) {
        this(numero, nombre);
        this.duracion = duracion;
    }
    private int numero;
    private String nombre;
    private int duracion; //en minutos
    private Director director;
    private String sinopsis;

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return this.duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void reproducir(){
        System.out.println("Reproduciendo episodio " + nombre);
    }
}
