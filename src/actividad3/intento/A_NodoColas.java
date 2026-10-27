package actividad3.intento;

/**
 * Utilizado por Colas sin prioridad
 */
class NodoQueue {

    String id;
    String reunion;
    String descripcion;
    NodoQueue siguiente;

    public NodoQueue(String id, String reunion, String descripcion) {
        this.siguiente = null;
        this.id = id;
        this.reunion = reunion;
        this.descripcion = descripcion;
    }

}

/**
 * Utilizado por Colas con prioridad
 */
class NodoWprioridad {

    String id;
    String reunion;
    String descripcion;
    NodoWprioridad siguiente;
    int prioridad;

    public NodoWprioridad(String id, String reunion, String descripcion, int prioridad) {
        this.siguiente = null;
        this.id = id;
        this.reunion = reunion;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public NodoWprioridad(String id, String reunion, String descripcion) {
        this.siguiente = null;
        this.id = id;
        this.reunion = reunion;
        this.descripcion = descripcion;
        this.prioridad = 5;
    }

}
