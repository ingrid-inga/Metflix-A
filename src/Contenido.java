import java.util.ArrayList;
import java.util.List;

public class Contenido {
    public String nombre;
    public Genero genero;
    //Idioma Origne
    public Idioma idiomaOrigen;
    public int añoLanzamiento;
    public List<Actor> actores = new ArrayList<>();

    public Actor existeActor(String nombreActor){
        for (Actor actor : this.actores){
            if(actor.nombre.equals(nombreActor))
                return actor;
            }
        
        return null;
    }

}
