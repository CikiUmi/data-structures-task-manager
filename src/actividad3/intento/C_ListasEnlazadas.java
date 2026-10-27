package actividad3.intento;

import javax.swing.JTextArea;

/*Tres clases diferentes para cada tipo de lista
    Todas contienen las mismas 4 funciones:
    - Agregar
    - Eliminar
    - Buscar
    - Mostrar
 */
/**
 * Nodos enlazados al siguiente, contienen un valor (tarea).
 */
class C_ListasEnlazadas {

    NodoSencillo cabeza; //nodo siguiente

    public C_ListasEnlazadas() {
        cabeza = null;
    }

    /**
     * Revisa si el nodo aún no existe según el ID
     *
     * @return False si ya existe / True si no
     */
    public boolean esNuevo(String dato) {
        NodoSencillo temp = cabeza;
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
     * @param id identificador de la tarea
     * @param nombre nombre de la tarea.
     * @param encargado nombre del encargado.
     * @param descripcion breve información de la tarea.
     */
    public void agregar(String id, String nombre, String encargado, String descripcion) {
        NodoSencillo nuevo = new NodoSencillo(id, nombre, encargado, descripcion);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoSencillo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    /**
     * Elimina el primer nodo con la tarea señalado
     *
     * @param id pide al usuario la tarea a eliminar.
     */
    public void eliminar(String id, JTextArea TxtListas) {
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return;
        }
        NodoSencillo actual = cabeza;
        
        if ((actual.id).toLowerCase().equals(id.toLowerCase())) {
            TxtListas.append("* Tarea #" + id + " marcada como completada.\n\n");
            cabeza = cabeza.siguiente;
            return;
        }
        
        //existe??
        actual = cabeza;
        while (actual.siguiente != null && !(actual.siguiente.id).toLowerCase().equals(id.toLowerCase())) {
            actual = actual.siguiente; //compara textos, si no es igual, continnua
        }
        
        // Si se encontró el nodo
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            TxtListas.append("* Tarea #" + id + " marcada como completada.\n\n");
        } else {
    TxtListas.append("- La tarea " + id + " no existe...\n\n");
}
    }

    /**
     * Despliega la lista de tareas
     */
    public void mostrar(JTextArea TxtListas) {
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return;
        }
        TxtListas.append(" == Lista de Tareas:\n\n");

        NodoSencillo actual = cabeza;
        while (actual != null) {
            TxtListas.append(" = Tarea #" + actual.id + ":\n");
            TxtListas.append("  + " + actual.nombre + "\n  - Encargado: " + actual.encargado + "\n\n");
            actual = actual.siguiente;
        }
        TxtListas.append("\n");
    }

    /**
     * Permite encontrar una tarea
     *
     * @param id tarea que se quiere encontrar
     */
    public void buscar(String id, JTextArea TxtListas) {
        int contador = 1;
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return;
        }

        // Si el nodo es la cabeza
        if (cabeza.id.toLowerCase().equals(id.toLowerCase())) {
            TxtListas.append("== Tarea encontrada en posicion #1.\n");
            TxtListas.append(" + NOMBRE:" + cabeza.nombre + "\n");
            TxtListas.append(" + ENCARGADO: " + cabeza.encargado + "\n");
            TxtListas.append(" + DESCRIPCION: " + cabeza.descripcion + "\n\n");
        }
        //Dirección siguiente
        NodoSencillo actual = cabeza;

        //Primero verifica que exista
        while (!(id).toLowerCase().equals(actual.id.toLowerCase())) {
            if (actual.siguiente == null) {
                TxtListas.append("- La tarea " + id + " no existe...\n\n");
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
        if (contador == 1) {
            contador++;
        }
        // Si se encontró el nodo
        if (actual.siguiente != null) {
            TxtListas.append("== Tarea encontrada en posicion #" + contador + ".\n");
            TxtListas.append(" + NOMBRE:" + actual.siguiente.nombre + "\n");
            TxtListas.append(" + ENCARGADO: " + actual.siguiente.encargado + "\n");
            TxtListas.append(" + DESCRIPCION: " + actual.siguiente.descripcion + "\n\n");
        }
    }
}

/**
 * Nodos doblemente enlazados (anterior y siguiente).
 */
class ListasDobleEnlace {

    C_Nodo cabeza;    //primer nodo
    C_Nodo tail;      //último nodo

    /**
     * Un nodo contiene la dirección del anteior y el siguiente; estos se
     * almacenan en cabeza y tail respectivamente.
     */
    public ListasDobleEnlace() {
        cabeza = null;
        tail = null;
    }

    /**
     * Revisa si el nodo aún no existe según el ID
     *
     * @return False si ya existe / True si no
     */
    public boolean esNuevo(String dato) {
        C_Nodo temp = cabeza;
        while (temp != null) {
            if (temp.id.equals(dato)) {
                return false;
            }
            temp = temp.siguiente;

        }
        return true;
    }

    /**
     * Añade un nodo, con la tarea asignada, al final de la lista.
     *
     * @param id identificador de la tarea
     * @param nombre nombre de la tarea.
     * @param encargado nombre del encargado.
     * @param descripcion breve información de la tarea.
     */
    public C_Nodo agregar(String id, String dato, String telefono, String direccion) {
        C_Nodo nuevo = new C_Nodo(id, dato, telefono, direccion);
        if (cabeza == null) {
            cabeza = nuevo;
            tail = cabeza;

        } else {
            C_Nodo actual = cabeza;
            while (actual.siguiente != null) {
                tail = actual.siguiente;
                actual = actual.siguiente;
            }
            nuevo.anterior = actual;
            actual.siguiente = nuevo;
            nuevo.anterior = tail;

            C_Nodo tail = new C_Nodo(actual.siguiente.id, actual.siguiente.nombre, actual.siguiente.encargado, actual.siguiente.descripcion, actual, cabeza);
        }
        return tail;
    }

    /**
     * Elimina el primer nodo (de la cabeza a la cola) con la tarea señalada
     *
     * @param id pide al usuario el id de la tarea a eliminar.
     */
    public void eliminar(String id, JTextArea TxtListas) {
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return;
        }
        // Si el nodo a eliminar es la cabeza
        if (cabeza.id.toLowerCase().equals(id.toLowerCase())) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            TxtListas.append("* Tarea " + id + " marcada como completada.\n\n");
            return;
        }
        //Dirección siguiente
        C_Nodo actual = cabeza;

        //Revisa que exista
        while (!id.toLowerCase().equals(actual.id.toLowerCase())) {
            if (actual.siguiente == null) {
                TxtListas.append("- La tarea " + id + " no existe...\n\n");
                return;
            } else {
                actual = actual.siguiente;
            }

        }
        actual = cabeza;

        while (actual.siguiente != null && !actual.siguiente.id.toLowerCase().equals(id.toLowerCase())) {
            actual = actual.siguiente;
        }

        // Si se encontró el nodo
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            TxtListas.append("* Tarea " + id + " marcada como completada.\n\n");
        }
    }

    /**
     * Despliega la lista con todos los nodos y sus enlaces, posteriormente
     * imprime la lista de tareas
     */
    public void mostrar(JTextArea TxtListas) {
        //Muestra primero los enlaces y eso
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pentientes.\n\n");
            return;
        }

        TxtListas.append(" == Enlaces dobles en la lista:\n");
        C_Nodo actual = cabeza;
        C_Nodo ultimo = tail;
        TxtListas.append("null <-> ");
        while (actual != null) {
            TxtListas.append("#" + actual.id + " <-> ");
            ultimo = actual;
            actual = actual.siguiente;
        }
        TxtListas.append("null\n\n");

        //Imprime lista de tareas
        TxtListas.append(" == Lista de Tareas:\n\n");
        actual = cabeza;
        while (actual != null) {
            TxtListas.append(" = Tarea #" + actual.id + ":\n");
            TxtListas.append("  + " + actual.nombre + "\n  - Encargado: " + actual.encargado + "\n\n");
            actual = actual.siguiente;
        }

    }

    /**
     * Permite encontrar la posición de un nombre
     *
     * @param id nombre de la tarea que se quiere encontrar
     */
    public void buscar(String id, JTextArea TxtListas) {
        int contador = 1;
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return;
        }

        // Si el nodo es la cabeza
        if (cabeza.id.toLowerCase().equals(id.toLowerCase())) {
            TxtListas.append("== Tarea encontrada en posicion #1.\n");
            TxtListas.append(" + NOMBRE:" + cabeza.nombre + "\n");
            TxtListas.append(" + ENCARGADO: " + cabeza.encargado + "\n");
            TxtListas.append(" + DESCRIPCION: " + cabeza.descripcion + "\n\n");
        }
        //Dirección siguiente
        C_Nodo actual = cabeza;

        //Primero verifica que exista
        while (!id.toLowerCase().equals(actual.id.toLowerCase())) {
            if (actual.siguiente == null) {
                TxtListas.append("- La tarea " + id + " no existe...\n\n");
                return;

            } else {
                actual = actual.siguiente;
                contador++;
            }

        }
        actual = cabeza; //reinicia valor

        //lo busca
        while (actual.siguiente != null && !actual.siguiente.id.toLowerCase().equals(id.toLowerCase())) {
            actual = actual.siguiente;
            if (actual == cabeza) {
                contador++;
                break;
            }

        }
        // Si se encontró el nodo
        if (actual.siguiente != null) {
            TxtListas.append("== Tarea encontrada en posicion #" + contador + ".\n");
            TxtListas.append(" + NOMBRE:" + actual.siguiente.nombre + "\n");
            TxtListas.append(" + ENCARGADO: " + actual.siguiente.encargado + "\n");
            TxtListas.append(" + DESCRIPCION: " + actual.siguiente.descripcion + "\n\n");
/*            
//Dirección anterior
            actual = tail.siguiente;
            //BBuscar
            while (actual.anterior != null && !actual.anterior.id.toLowerCase().equals(id.toLowerCase())) {
                if (actual == cabeza) {
                    break;
                }
                actual = actual.anterior;

            }*/

        }

    }
}

/**
 * Nodos doblemente enlazados con conexión entre el primero y el último.
 */
class ListasCirculares {

    C_Nodo cabeza;    //primer nodo
    C_Nodo tail;      //último nodo
    int tamaño;       //tamaño de la lista

    /**
     * Un nodo contiene la dirección del anteior y el siguiente; estos se
     * almacenan en cabeza y tail respectivamente.
     */
    public ListasCirculares() {
        cabeza = null;
        tail = null;
    }

    /**
     * Revisa si el nodo aún no existe según el ID
     *
     * @return False si ya existe / True si no
     */
    public boolean esNuevo(String dato) {
        if (cabeza == null) {
            return true;
        }

        C_Nodo temp = cabeza;
        do {
            if (temp.id.equals(dato)) {
                return false;
            }
            temp = temp.siguiente;

        } while (temp != cabeza);
        return true;
    }

    /**
     * Añade un nodo, con la tarea asignada, al final de la lista.
     *
     * @param id identificador de la tarea
     * @param nombre nombre de la tarea.
     * @param encargado nombre del encargado.
     * @param descripcion breve información de la tarea.
     */
    public C_Nodo agregar(String id, String nombre, String encargado, String descripcion) {
        C_Nodo nuevo = new C_Nodo(id, nombre, encargado, descripcion);
        if (cabeza == null) {       //el primer nodo es la cabeza
            cabeza = nuevo;
            nuevo.siguiente = nuevo;   
            nuevo.anterior = nuevo;    //apunta a sí mismo
            tail = cabeza;

        } else {
            C_Nodo actual = cabeza;
            while (actual.siguiente != null && actual.siguiente != cabeza) {
                tail = actual.siguiente; //tail se recorre, es el último nodo
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            nuevo.anterior = tail;
            C_Nodo tail = new C_Nodo(actual.siguiente.id, actual.siguiente.nombre, actual.siguiente.encargado, actual.siguiente.descripcion, actual, cabeza);

            cabeza.anterior = nuevo;
            nuevo.siguiente = cabeza;
        }
        return tail;
    }

    /**
     * Elimina el primer nodo (de la cabeza a la cola) con la tarea señalada
     *
     * @param id pide al usuario el id de la tarea a eliminar.
     * @return Guarda y actualiza el valor de tail, el último nodo en la lista.
     */
    public C_Nodo eliminar(String id, JTextArea TxtListas) {

        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return tail;
        }

        // Si el nodo a eliminar es la cabeza
        
        
        if (cabeza.id.toLowerCase().equals(id.toLowerCase())) {
            
            if (cabeza.siguiente == cabeza || cabeza.siguiente == null){
                cabeza = null;
                tail = null;
                TxtListas.append("* Tarea " + id + " marcada como completada.\n\n");

                return tail;
            }
            cabeza = cabeza.siguiente;
            cabeza.anterior = cabeza.anterior.anterior; //La cabeza apunta al último,
            cabeza.anterior.siguiente = cabeza; //y el último a la cabeza
            tail = cabeza.anterior.anterior;
            
            TxtListas.append("* Tarea " + id + " marcada como completada.\n\n");
            return tail;

        // si es el que sigue pues entonces lo limpia para que 
}

        //Dirección siguiente
        C_Nodo actual = cabeza;

        //Primero verifica que exista
        while (!id.toLowerCase().equals(actual.id.toLowerCase())) {
            if (actual.siguiente == cabeza) {
                TxtListas.append("- La tarea " + id + " no existe...\n\n");
                return tail;

            } else {
                actual = actual.siguiente;

            }

        }
        actual = cabeza; //se reinicia el valor

        //busca nombre en cada nodo
        while (actual.siguiente != null && !actual.siguiente.id.toLowerCase().equals(id.toLowerCase())) {
            actual = actual.siguiente;
            if (actual == cabeza) {
                break;
            }
        }

        // Si se encontró el nodo_
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }

        actual = tail.siguiente; //se reinicia el valor

        //Busca de nuevo
        while (actual.anterior != null && !actual.anterior.id.toLowerCase().equals(id.toLowerCase())) {
            actual = actual.anterior;
            if (actual == cabeza) {
                break;
            }
        }
        //borrar dirección Anterior
        if (actual.anterior.id.toLowerCase().equals(id.toLowerCase())) {
            actual.anterior = actual.anterior.anterior;
        }
        actual = cabeza;
        tail = cabeza.anterior.anterior;
        TxtListas.append("* Tarea " + id + " marcada como completada.\n\n");
        return tail;
    }

    /**
     * Despliega la lista con todos los nodos y sus enlaces, posteriormente
     * imprime la lista de tareas
     */
    public void mostrar(JTextArea TxtListas) {
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return;
        }

        if (tail.siguiente == cabeza) {
            TxtListas.append("- Sólo tienes una tarea pendiente: ");
            TxtListas.append(" = Tarea #" + cabeza.id + ":\n");
            TxtListas.append("  + " + cabeza.nombre + "\n  - Encargado: " + cabeza.encargado + "\n\n");
            return;
        }

        if (tail.siguiente == null) {
            TxtListas.append("- Sólo tienes una tarea pendiente: ");
            TxtListas.append(" = Tarea #" + cabeza.id + ":\n");
            TxtListas.append("  + " + cabeza.nombre + "\n  - Encargado: " + cabeza.encargado + "\n\n");
            return;
        }

        C_Nodo actual = cabeza;
        C_Nodo ultimo = tail.siguiente;
        int contador = 0;
        int ronda = 0;
        boolean romper = false;

        TxtListas.append(" == Enlaces dobles en la lista:\n");
        while (actual != null && romper == false) {
            if (ronda == 0) {
                TxtListas.append("#" + actual.id + " <-> ");
                ultimo = actual;
                actual = actual.siguiente;
                contador++;
            }
            if (ultimo.anterior == tail && contador >= 1) {
                TxtListas.append("#" + ultimo.anterior.id + " <-> ");
                ultimo = ultimo.anterior;
                contador = -1;
                ronda = 1;
            }
            if (ronda == 1) {
                TxtListas.append("#" + ultimo.anterior.id + " <-> ");
                ultimo = ultimo.anterior;
                if (ultimo == cabeza) {
                    break;
                }
            }
        }

        TxtListas.append("etc..\n");

        TxtListas.append("\n == Enlaces circulares en la lista:\n");
        do {
            TxtListas.append("#" + actual.id + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        TxtListas.append("#" + actual.id + " -> etc...\n\n");

        TxtListas.append(" == Lista de Tareas:\n\n");
        actual = cabeza;

        do {
//            TxtListas.append(" = Tarea #" + actual.id + ":\n");
            TxtListas.append(" = Tarea #" + actual.id + ":\n");
            TxtListas.append("  + " + actual.nombre + "\n  - Encargado: " + actual.encargado + "\n\n");
            actual = actual.siguiente;
        } while (actual != null && actual != cabeza);
    }

    /**
     * Permite acceder a la lista de dos formas
     *
     * @param num tarea/posición que se quiere encontrar
     * @param tipoBusqueda False: por tarea(id) / True: por posición
     */
    public void buscar(String num, boolean tipoBusqueda, JTextArea TxtListas) {
        int posicion = 0;
        String valor = "0";
        boolean real = false;
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            return;
        }

        if (tipoBusqueda == true) {  //busqueda por posición
            try {
                posicion = Integer.parseInt(num);
            } catch (Exception e) {
                TxtListas.append(" * POSICION: Por favor ingresa un valor valido.\n");
                return;
            }

        } else {
            valor = num;            //busqueda por tarea
        }

        //Cuenta todos los valores en la lista para poder iterar :D
        int contador = 0;
        C_Nodo actual = cabeza;
        if (cabeza == null) {
            TxtListas.append("- No tienes tareas pendientes.\n\n");
            tamaño = 0;
            return;
        }
        do {
            actual = actual.siguiente;
            contador++;
        } while (actual != cabeza && actual != null);
        tamaño = contador;
        //SI SE VA A BUSCAR POR POSICION
        if (posicion != 0 && posicion <= tamaño) {
            for (int i = 2; i <= posicion; i++) {
                actual = actual.siguiente;
            }
            TxtListas.append("== Tarea en la posicion #" + num + ".\n");
            TxtListas.append(" + NOMBRE:" + actual.nombre + "\n");
            TxtListas.append(" + ENCARGADO: " + actual.encargado + "\n");
            TxtListas.append(" + DESCRIPCION: " + actual.descripcion + "\n\n");

        } else if (posicion != 0) {
            TxtListas.append("- No hay una tarea en la posicion #" + num + "...\n\n");
        }

        //busqueda por valor (id)
        if (posicion != 0) {
            return;
        } //evita que tome posicion como valor
        actual = cabeza;

        if (cabeza.id.equals(valor)) {
            TxtListas.append("== Informacion de #" + valor.toUpperCase() + ".\n");
            TxtListas.append(" + NOMBRE:" + cabeza.nombre + "\n");
            TxtListas.append(" + ENCARGADO: " + cabeza.encargado + "\n");
            TxtListas.append(" + DESCRIPCION: " + cabeza.descripcion + "\n\n");
            TxtListas.append(" + POSICION: 1\n");

            return;
        }

        //reivsa que exista
        while (!valor.toLowerCase().equals(actual.id.toLowerCase())) {

            if (actual.siguiente == cabeza) {
                TxtListas.append("- La tarea " + valor + " no existe...\n\n");
                return;
            } else {
                actual = actual.siguiente;
            }
        }
        real = true;
        actual = cabeza;
        contador = 1;
        if (real == true) {
            do {
                if (!actual.id.toLowerCase().equals(valor.toLowerCase())) {
                    actual = actual.siguiente;
                    contador++;
                } else {
                    TxtListas.append("== Informacion de " + valor + ".\n");
                    TxtListas.append(" + NOMBRE:" + actual.nombre + "\n");
                    TxtListas.append(" + ENCARGADO: " + actual.encargado + "\n");
                    TxtListas.append(" + DESCRIPCION: " + actual.descripcion + "\n\n");
                    TxtListas.append(" + POSICION: " + contador + "\n");
                    return;
                }
            } while (actual != cabeza);
        }
    }
}
