package actividad3.intento;

/**
 * Utilizado por las pilas, son sus elementos
 */
public class B_NodoPila {

    private String id;
    private String producto;
    private String descripcion;
    private B_NodoPila next;

    /**
     * Crea un nodo nuevo
     */
    public B_NodoPila(String id, String producto, String descripcion) {
        this.id = id;
        this.producto = producto;
        this.descripcion = descripcion;
        this.next = null;
    }

    // == Getters y Setters de los atributos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public B_NodoPila getNext() {
        return next;
    }

    public void setNext(B_NodoPila next) {
        this.next = next;
    }
}
