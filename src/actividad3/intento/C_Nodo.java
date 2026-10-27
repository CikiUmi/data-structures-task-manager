package actividad3.intento;

/**
 * Utilizado por Listas con Enlaces
 */
class NodoSencillo {

    String id;
    String nombre;
    String encargado;
    String descripcion;
    NodoSencillo siguiente;

    public NodoSencillo(String id, String nombre, String encargado, String descripcion) {
        this.siguiente = null;
        this.id = id;
        this.nombre = nombre;
        this.encargado = encargado;
        this.descripcion = descripcion;
    }

}

/**
 * Utilizado por Listas con Enlaces Dobles y Circulares
 */
class C_Nodo {

    String id;
    String nombre; //nombre de la tarea
    String encargado;
    String descripcion;
    C_Nodo siguiente;
    C_Nodo anterior;

    public C_Nodo(String id, String nombre, String encargado, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.encargado = encargado;
        this.descripcion = descripcion;
        this.siguiente = null;
        this.anterior = null;
    }

    public C_Nodo(String id, String nombre, String encargado, String descripcion, C_Nodo anterior, C_Nodo siguiente) {
        this.id = id;
        this.nombre = nombre;
        this.encargado = encargado;
        this.descripcion = descripcion;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
}
