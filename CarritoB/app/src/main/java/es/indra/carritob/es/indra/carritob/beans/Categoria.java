package es.indra.carritob.es.indra.carritob.beans;

public class Categoria {

    int id;
    String nombre;
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
