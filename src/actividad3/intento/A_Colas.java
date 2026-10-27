package actividad3.intento;

import javax.swing.JTextArea;

/*Dos clases diferentes para cada tipo de cola
    Ambas contienen las mismas 4 funciones:
    - Agregar
    - Eliminar
    - Buscar
    - Mostrar
 */
/**
 * Nodos enlazados al siguiente, contienen un valor (pasos de proyecto).
 */
class A_Colas {

    NodoQueue cabeza; //nodo siguiente

    public A_Colas() {
        cabeza = null;
    }

    /**
     * Revisa si el nodo aún no existe según el ID
     *
     * @return False si ya existe / True si no
     */
    public boolean esNuevo(String dato) {
        NodoQueue temp = cabeza;
        while (temp != null) {
            if (temp.id.equals(dato)) {
                return false;
            }
            temp = temp.siguiente;

        }
        return true;
    }

    /**
     * Añade un nodo, con el valor señalado, al final de la cola.
     *
     * @param id id del producto.
     * @param reunion titulo corto o nombre de la reunión.
     * @param descripcion información, objetivo de la reunión,etc.
     */
    public void agregar(String id, String reunion, String descripcion) {
        NodoQueue nuevo = new NodoQueue(id, reunion, descripcion);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoQueue actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    /**
     * Elimina el primer nodo con el contacto señalado
     */
    public void eliminar(JTextArea TxtColas) {
        if (cabeza == null) {
            TxtColas.append("- No tienes reuniones pendientes.\n\n");
            return;
        }
        TxtColas.append("- Se elimino al objeto: #" + cabeza.id + " (" + cabeza.reunion + ")\n");
        cabeza = cabeza.siguiente; // Mueve el top al siguiente nodo
        return;
    }

    /**
     * Despliega la lista de contactos
     */
    public void mostrar(JTextArea TxtColas) {
        if (cabeza == null) {
            TxtColas.append("- No tienes reuniones pendientes.\n\n");
            return;
        }
        TxtColas.append(" == Lista de Contatos:\n");

        NodoQueue actual = cabeza;
        while (actual != null) {
            TxtColas.append(" -  #" + actual.id + ": " + actual.reunion + "\n");
            actual = actual.siguiente;
        }
        TxtColas.append("\n");
    }

    /**
     * Permite encontrar el número de un contacto
     *
     * @param nombre id que se quiere encontrar
     */
    public void buscar(String id, JTextArea TxtColas) {
        int contador = 1;
        if (cabeza == null) {
            TxtColas.append("- No tienes reuniones pendientes.\n\n");
            return;
        }

        // Si el nodo es la cabeza
        if (cabeza.id.toLowerCase().equals(id.toLowerCase())) {
            TxtColas.append("== Reunion pendiente no." + contador + "\n");
            TxtColas.append(" #" + cabeza.id + ": " + cabeza.reunion.toUpperCase() + "\n");
            TxtColas.append(" - " + cabeza.descripcion + "\n\n");
        }
        //Dirección siguiente
        NodoQueue actual = cabeza;

        //Primero verifica que exista
        while (!(id).toLowerCase().equals(actual.id.toLowerCase())) {
            if (actual.siguiente == null) {
                TxtColas.append("- El valor " + id + " no existe...\n\n");
                return;

            } else {
                actual = actual.siguiente;
                contador++;
            }

        }
        actual = cabeza;

        //lo busca          )
        while (actual.siguiente != null && (!(actual.siguiente.id.toLowerCase()).equals(id.toLowerCase()))) {
            actual = actual.siguiente;
        }
        // Si se encontró el nodo
        if (actual.siguiente != null) {
            TxtColas.append("== Reunion pendiente no." + contador + "\n");
            TxtColas.append(" #" + actual.siguiente.id + ": " + actual.siguiente.reunion.toUpperCase() + "\n");
            TxtColas.append(" - " + actual.siguiente.descripcion + "\n\n");
        }
    }
}

class ColasWprioridad {

    NodoWprioridad cabeza; //nodo siguiente

    public ColasWprioridad() {
        cabeza = null;
    }

    /**
     * Revisa si el nodo aún no existe según el ID
     *
     * @return False si ya existe / True si no
     */
    public boolean esNuevo(String dato) {
        NodoWprioridad temp = cabeza;
        while (temp != null) {
            if (temp.id.equals(dato)) {
                return false;
            }
            temp = temp.siguiente;

        }
        return true;
    }

    /**
     * Añade un nodo, con el valor señalado, al final de la lista.
     *
     * @param id id de la reunión nueva.
     * @param reunion nombre de la reunión.
     * @param descripcion detalles, objetivo, etc.
     * @param prioridad número del 1 (mayor) al 5 (menor).
     */
    public void agregar(String id, String reunion, String descripcion, int prioridad) {

        if (prioridad < 1) {
            prioridad = 1;
        }
        if (prioridad > 5) {
            prioridad = 5;
        }

        NodoWprioridad nuevo = new NodoWprioridad(id, reunion, descripcion, prioridad);
        if (cabeza == null) {
            cabeza = nuevo;

        } else {
            NodoWprioridad actual = cabeza;
            NodoWprioridad anterior = null; //vacío para almacenar (actual -1) :D

            while (actual != null && nuevo.prioridad >= actual.prioridad) { // >= para que no ponga en desorden
                anterior = actual;                                      // a pesar de respetar la prioridad :3
                actual = actual.siguiente;
            }

            if (anterior != null) {
                anterior.siguiente = nuevo;
                nuevo.siguiente = actual;

            } else {
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
            }
        }
    }

    /**
     * Elimina la reunión con más antiguedad
     */
    public void eliminar(JTextArea TxtColas) {
        if (cabeza == null) {
            TxtColas.append("- No tienes reuniones pendientes.\n\n");
            return;
        }
        TxtColas.append("- Se elimino al objeto: #" + cabeza.id + " (" + cabeza.reunion + ")\n");
        cabeza = cabeza.siguiente; // Mueve el top al siguiente nodo
        return;
    }

    /**
     * Despliega la lista de reuniones pendientes
     */
    public void mostrar(JTextArea TxtColas) {
        if (cabeza == null) {
            TxtColas.append("- No tienes reuniones pendientes.\n\n");
            return;
        }
        TxtColas.append(" == Lista de Reuniones:\n");

        NodoWprioridad actual = cabeza;
        while (actual != null) {
            TxtColas.append(" - [" + actual.prioridad + "] #" + actual.id + ": " + actual.reunion + "\n");
            actual = actual.siguiente;
        }
        TxtColas.append("\n");
    }

    /**
     * Permite encontrar una reunión y leer sus detalles
     *
     * @param id identificador de la reunión que se quiere consultar
     */
    public void buscar(String id, JTextArea TxtColas) {
        int contador = 1;
        if (cabeza == null) {
            TxtColas.append("- No tienes reuniones pendientes.\n\n");
            return;
        }

        // Si el nodo es la cabeza
        if (cabeza.id.toLowerCase().equals(id.toLowerCase())) {
            TxtColas.append("== Reunion pendiente no. 1\n");
            TxtColas.append(" #" + cabeza.id + ": " + cabeza.reunion.toUpperCase() + "\n");
            TxtColas.append(" - " + cabeza.descripcion + "\n\n");
            TxtColas.append(" - (Prioridad de reunión: ");
            switch (cabeza.prioridad) {
                case 1 ->
                    TxtColas.append("Muy alta.)\n\n");
                case 2 ->
                    TxtColas.append("Alta.)\n\n");
                case 3 ->
                    TxtColas.append("Media.)\n\n");
                case 4 ->
                    TxtColas.append("Baja.)\n\n");
                case 5 ->
                    TxtColas.append("Muy baja.)\n\n");
            }
        }
        //Si no es la cabeza, va por el siguiente
        NodoWprioridad actual = cabeza;

        //Primero verifica que exista
        while (!(id).toLowerCase().equals(actual.id.toLowerCase())) {
            if (actual.siguiente == null) {
                TxtColas.append("- La reunion " + id + " no existe...\n\n");
                return;

            } else {
                actual = actual.siguiente;
                contador++;
            }

        }
        actual = cabeza;

        //lo busca          )
        while (actual.siguiente != null && (!(actual.siguiente.id.toLowerCase()).equals(id.toLowerCase()))) {
            actual = actual.siguiente;
        }
        // Si se encontró el nodo
        if (actual.siguiente != null) {
            TxtColas.append("== Reunion pendiente no." + contador + "\n");
            TxtColas.append(" #" + actual.siguiente.id + ": " + actual.siguiente.reunion.toUpperCase() + "\n");
            TxtColas.append(" - " + actual.siguiente.descripcion + "\n\n");
            TxtColas.append(" - (Prioridad de reunión: ");
            switch (actual.siguiente.prioridad) {
                case 1 ->
                    TxtColas.append("Muy alta.)\n\n");
                case 2 ->
                    TxtColas.append("Alta.)\n\n");
                case 3 ->
                    TxtColas.append("Media.)\n\n");
                case 4 ->
                    TxtColas.append("Baja.)\n\n");
                case 5 ->
                    TxtColas.append("Muy baja.)\n\n");
            }
        }
    }
}
