package actividad3.intento;

import javax.swing.JTextArea;

/**
 * Nodos enlazados, se accede desde arriba.
 */
public class B_Pila {

    protected B_NodoPila top; //nodo de arriba

    public B_Pila() {
        this.top = null;
    }

    /**
     * Getter para nodo superior (más reciente)
     *
     * @return devuelve el producto
     */
    public B_NodoPila getTop() {
        return top;
    }

    /**
     * Revisa si el nodo aún no existe según el ID
     *
     * @return False si ya existe / True si no
     */
    public boolean esNuevo(String dato) {
        B_NodoPila temp = top;
        while (temp != null) {
            if (temp.getId().equals(dato)) {
                return false;
            }
            temp = temp.getNext();

        }
        return true;
    }

    /**
     * Revisa si el almacén tiene productos o no
     *
     * @return True: la pila está vacía / False: tiene elementos
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Crea y agrega encima de la pila un nodo nuevo con id
     *
     * @param id fecha/id del producto
     * @param nombre tema de la reunión
     * @param descripcion empresa o ersona
     */
    public void push(String id, String nombre, String descripcion) {
        B_NodoPila newNode = new B_NodoPila(id, nombre, descripcion);
        newNode.setNext(top); // El nuevo nodo apunta al que era el top
        top = newNode;        // El nuevo nodo se convierte en el top
    }

    /**
     * Elimina el producto más reciente del almacen
     */
    public void pop(JTextArea TxtPilas) {
        if (isEmpty()) {
            TxtPilas.append("- El inventario esta vacio.\n\n");
            return;
        }
        TxtPilas.append("- Se retiro el producto: #" + top.getId() + " (" + top.getProducto() + ")\n\n");
        top = top.getNext(); // Mueve el top al siguiente nodo
    }

    /**
     * Revisa el valor hexadecimal de top (color más reciente)
     */
    public void peek(JTextArea TxtPilas) {
        if (isEmpty()) {
            TxtPilas.append("- El inventario esta vacio.\n\n");
            return;
        }
        TxtPilas.append(" = Producto recien agregado:\n");
        TxtPilas.append(" #" + top.getId() + ": " + top.getProducto().toUpperCase() + "\n");
        TxtPilas.append(" - " + top.getDescripcion() + "\n\n");
    }

    /**
     * Imprime la pila entera (de arriba hacia abajo) y muestra los productos,
     * uno por uno, con su descripción.
     */
    public void printStack(JTextArea TxtPilas) {
        if (isEmpty()) {
            TxtPilas.append("- El inventario esta vacio.\n\n");
            return;
        }
        B_NodoPila temp = top;
        TxtPilas.append(" + Productos almacenados: \n");
        while (temp != null) {
            TxtPilas.append("#" + (temp.getId()) + " -> ");
            temp = temp.getNext();
        }
        TxtPilas.append("null\n\n");
        TxtPilas.append(" == Lista de Productos:\n\n");

        temp = top;
        while (temp != null) {
            TxtPilas.append(" #" + temp.getId() + ": " + temp.getProducto().toUpperCase() + "\n");
            TxtPilas.append(" - " + temp.getDescripcion() + "\n\n");
            temp = temp.getNext();
        }
        TxtPilas.append("\n");
    }
}
