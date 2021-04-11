package app;

import java.util.ArrayList;
import java.util.List;
import app.personas.*;

public class Metflix {

    public List<Pelicula> peliculas = new ArrayList<>();
    public List<Serie> series = new ArrayList<>();
    public List<INominable> nominados = new ArrayList<>();

    // Metodo que inicializa el catalogo cno las pelis/series qeu querramos
    public void inicializarCatalogo() {

        // Pelis: Titanic, Batman: El caballero de la noche
        Pelicula titanic; // declara una variable que apuntara a una Pelicula
        titanic = new Pelicula(); // Estas ultimoas 2 lineas: Pelicula titanic = new Pelicula();

        titanic.setNombre("Titanic");
        titanic.setAñoLanzamiento(1997);
        titanic.setDuracion(210); // 3hs 30

        Actor actor = new Actor();
        actor.setNombre("Leo DiCaprio");

        // Agrego a la lista de actores del objeto titanic
        titanic.getActores().add(actor); // metodo Add -> agregar a una lista

        // Recien ahora estoy agregando a Titanic al catalogo
        this.peliculas.add(titanic);

        // Otra Peli
        Pelicula batman = new Pelicula();
        batman.setNombre("Batman: el caballero de la noche");
        batman.setAñoLanzamiento(2008);
        batman.setDuracion(152);

        // No voy a declarar otra variable actor, voy a reusar
        // siempre primero antes de reusar
        // re instanciar
        actor = new Actor(); // Creo un nuevo actor, pero referenciado con la variable actor
        actor.setNombre("Christian Bale");

        batman.getActores().add(actor);

        this.peliculas.add(batman);

        this.nominados.add(batman);
        this.nominados.add(actor);

        Pelicula elResplandor = new Pelicula();
        elResplandor.setNombre("El Resplandor");
        elResplandor.setDirector(new Director());
        elResplandor.getDirector().setNombre("Stanley Kubrick");

        this.nominados.add(elResplandor);

        // How I met your mother. Serie

        Serie howIMetYM = new Serie();
        howIMetYM.setNombre("How I met your mother");
        howIMetYM.setAñoLanzamiento(2005);

        actor = new Actor();
        actor.setNombre("Neil Patrick Harris");

        howIMetYM.getActores().add(actor);

        actor = new Actor();
        actor.setNombre("Cobie Smulders");

        howIMetYM.getActores().add(actor);

        // T5:E11et
        // creo la temporada
        Temporada temporada = new Temporada();
        temporada.setNumero(5);

        // Creo el episodio
        Episodio episodio = new Episodio(11, "The last cigarette");
        episodio.setDuracion(43);

        // vinculo temporada con episodio
        temporada.getEpisodios().add(episodio);

        episodio = new Episodio(1, "Definitions", 41);
        // episodio.nombre = "Definitions";
        // episodio.numero = 1;

        temporada.getEpisodios().add(episodio);

        Websodio ws = new Websodio(35, "Nombre websodio en internet", "http://miepisodios.com/websodio.avi");
        ws.setDuracion(42);

        temporada.getEpisodios().add(ws);
        // Agrego la temporada
        howIMetYM.getTemporadas().add(temporada);

        // T3
        // creo la temporada
        temporada = new Temporada();
        temporada.setNumero(3);

        // Creo el episodio
        episodio = new Episodio(1, "Wait for it", 40);
        // episodio.nombre = "Wait for it";
        // episodio.numero = 1;

        // vinculo temporada con episodio
        temporada.getEpisodios().add(episodio);

        episodio = new Episodio(4, "Little Boys");
        // episodio.nombre = "Little Boys";
        // episodio.numero = 4;
        episodio.setDuracion(44);

        temporada.getEpisodios().add(episodio);

        // Agrego la temporada
        howIMetYM.getTemporadas().add(temporada);

        // Aca esta toda la serie con 2 temporadas y cada una con 2 episodios.
        this.series.add(howIMetYM);

        Serie bbt = new Serie();
        bbt.setNombre("The BigBang Theory");
        bbt.setAñoLanzamiento(2007);

        actor = new Actor();
        actor.setNombre("Kaley Cuoco");

        bbt.getActores().add(actor);

        // creo la temporada
        temporada = new Temporada();
        temporada.setNumero(1);

        // Creo el episodio
        episodio = new Episodio(1, "Pilot", 41);
        // episodio.nombre = "Pilot";
        // episodio.numero = 1;

        // vinculo temporada con episodio
        temporada.getEpisodios().add(episodio);

        episodio = new Episodio(13, "The Cooper-Hofstadter Polarization");
        // episodio.nombre = "The Cooper-Hofstadter Polarization";

        temporada.getEpisodios().add(episodio);

        // Agrego la temporada
        bbt.getTemporadas().add(temporada);

        this.series.add(bbt);

    }

    // Buscar Serie
    public Serie buscarSerie(String nombreABuscar) {

        // series = | serie1 | serie2 | serie25 | serie40 |
        // vamos a usar el foreach: que sirve para recorrer listas
        // este ciclo, tiene una variable, qeu apunta en cada vuelta
        // a cada elemento de la lista
        // o sea la primer vez, va a apuntar a serie1, despues a serie2 ddesp
        // serie25 hasta que termina.
        for (Serie serie : this.series) {
            // pregunto si el nombre de la serie actual
            // que estoy recorriendo es la que necesito
            if (serie.getNombre().equals(nombreABuscar))
                return serie; // devuelvo esta serie.
        }
        // si llego hasta aca, es porque no encontro la serie.
        return null;

    }

    public Serie buscarSerieV2(String nombreABuscar) {
        Serie serieBuscada = null;
        // En este caso se recorre TODO(aunque haya 1000 series)
        // y al final se devuelve si encontr una serie.
        // en el caso anterior, se devuelve una vez encontrada.
        // ej si hay 1000 series pero esta en la posicion 3, hace 3 vueltas
        for (Serie serie : this.series) {
            if (serie.getNombre().equals(nombreABuscar))
                serieBuscada = serie;
        }
        return serieBuscada;
        /*
         * if (serieBuscada == null) return null; else return serieBuscada;
         */

    }

    public void mostrarNominaciones(){
        int totalPelis = 0;
        int totalActores = 0;
        for(INominable nominado : this.nominados){
            nominado.reproducirTrailerNominación();

            if (nominado instanceof Pelicula)
            totalPelis++;
            if (nominado instanceof Actor)
            totalActores++;
        }
        System.out.println("Películas nominadas: "+ totalPelis);
        System.out.println("Actores nominados: " + totalActores);
    }

    public void reproducirEpisodioDeSerie(String nombreSerie, int nroTemporada, int nroEpisodio){
        Serie serie = this.buscarSerie(nombreSerie);
        Temporada temporada = serie.buscarTemporada(nroTemporada);
        Episodio episodio = temporada.buscarEpisodio(nroEpisodio);
        episodio.reproducir();
    }

    public void imprimirSeriesDondeActuaActor(String nombreActor) {
        System.out.println("Lista de Series donde actua: " + nombreActor);
        for (Serie serie : this.series) {
            for (Actor actor : serie.getActores()) {
                if (actor.getNombre().equals(nombreActor))
                    System.out.println("El actor " + actor.getNombre() + " actua en " + serie.getNombre());
            }
        }
    }

}
