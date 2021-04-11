package app.personas;

import app.INominable;

public class Actor extends Persona implements INominable {

    @Override
    public boolean ganoPreviamente(){
        return false;
    }

    @Override
    public void reproducirTrailerNominación() {

        System.out.println("Mostrando trailer de escenas para el actor" + this.getNombre());

    }
    
}
