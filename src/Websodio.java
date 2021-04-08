public class Websodio extends Episodio{

    public Websodio(int numero, String nombre, String link) {
        super(numero, nombre);
        this.setLink(link);
    }

    private String link;

    public String getLink() {
        return this.link;
    }

    public void setLink(String link){
        this.link = link;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo websodio del link " + this.link);
    }
    
}
