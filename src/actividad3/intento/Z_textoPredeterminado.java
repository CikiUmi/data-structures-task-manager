/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3.intento;

import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 *
 * @author fluff
 */
public class Z_textoPredeterminado {

    /**
     * Genera una serie de datos (tareas, reuniones, pasos) predeterminados para
     * el usuario
     *
     * @param lE lista enlazada con tareas.
     * @param lD lista doblemente enlazada con tareas.
     * @param lC lista circular con enlace doble, con tareas.
     * @param p pila con reuniones.
     * @param cS cola sencillal con pasos de proyecto.
     * @param cWp cola con prioridades, con pasos de proyecto.
     */
    public void fill(C_ListasEnlazadas lE, ListasDobleEnlace lD, ListasCirculares lC, B_Pila p, A_Colas cS, ColasWprioridad cWp) {
    // formato listas: TAREAS PENDIENTES
        // == ID - NOMBRE - ENCARGADO - DESCRIPCIÓN
        lE.agregar("TEW54", "Crear una presentacion de la empresa", "Luis Flores", "Para la junta del viernes, incluir mision, valores, etc.");
        lE.agregar("T884F", "Actualizar el sitio web", "Maria Gomez", "Revisar contenido y subir nuevas imagenes de productos.");
        lE.agregar("T8593", "Organizar y planificar taller", "Carlos Gomez", "Coordinar fecha y lugar para el taller de liderazgo.");

        lD.agregar("T4324", "Actualizar base de clientes", "Mike Miller", "Revisar y corregir datos de contacto en el sistema CRM.");
        lD.agregar("TAAAW", "Organizar archivos digitales", "Rosa Ramirez", "Clasificar documentos escaneados por fecha y tipo.");
        lD.agregar("TAL99", "Verificar inventario en sistema", "Alfredo Sombras", "Comparar registros digitales con inventario fisico.");

        lC.agregar("TRER3", "Coordinar reunion con directivos", "Alfredo Sombras", "Agendar cita con el equipo legal y financiero para revision de contratos.");
        lC.agregar("TH0L4", "Solicitar cotizacion a proveedor", "Mike Miller", "Enviar requerimientos tecnicos y recibir propuesta formal.");
        lC.agregar("TFRD9", "Llegada de nuevo personal", "Sofia Herrera", "Crear carpeta de bienvenida y asignar mentor interno.");

    // formato pilas: INVENTARIO EN ALMACEN
        // == ID - PRODUCTO - DESCRIPCION
        p.push("P567S", "Playeras basicas", "Colores variados, Tallas: S,M,XL");
        p.push("PM053", "Vestidos con listones", "Modelo nuevo, Tallas: M,X,XL");
        p.push("P002F", "Botas de cuero", "Incluyen cadenas, Tallas: 20 - 29");
        
    // formato colas: REUNIONES SIGUIENTES
        // == ID - REUNION - DESCRIPCIÓN - PRIORIDAD
        cS.agregar("R4S01", "Revision de presupuesto", "Analizar gastos del trimestre y ajustar proyecciones.");
        cS.agregar("RS032", "Actualizacion de proyectos", "Cada equipo presentara avances y bloqueos.");
        cS.agregar("RSH03", "Planificacion de publicidad", "Definir objetivos y canales para el lanzamiento de producto.");

        cWp.agregar("R6701", "Evaluacion de proveedores", "Comparar desempeño y costos de los ultimos seis meses.", 4);
        cWp.agregar("RG450", "Capacitacion interna", "Organizar sesiones para el uso del nuevo sistema ERP.", 1);
        cWp.agregar("RL512", "Auditoria externa", "Preparar documentacion y coordinar con el equipo contable.", 4);
    }

}
