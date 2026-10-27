
package actividad3.intento;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class A_Actividad3Intento {

    public static void main(String[] args) {
        
    // == Creación de listas, pilas y colas    
        
        // Listas
        C_ListasEnlazadas listaEn = new C_ListasEnlazadas();        // Listas Enlazadas
        ListasDobleEnlace listaDob = new ListasDobleEnlace();       // Listas con Doble Enlace
        ListasCirculares listaCir = new ListasCirculares();         // Listas Circulares
        
        // Pila
        B_Pila pila = new B_Pila();                                 // Pila
        
        // Colas
        A_Colas colaSen = new A_Colas();                            // Colas sencillas
        ColasWprioridad colaWprio = new ColasWprioridad();          // Colas con prioridad
        
        // Acciones para preparar programa
        Z_textoPredeterminado inicio = new Z_textoPredeterminado(); //Llenar con ejemplos
        inicio.fill(listaEn, listaDob, listaCir, pila, colaSen, colaWprio);        
        
    // == Creación de elementos para GUI
        A_Vprincipal ventana = new A_Vprincipal(listaEn, listaDob, listaCir, pila, colaSen, colaWprio);
        
        // == Ajustes de algunos elementos
            ventana.setResizable(false);
            ventana.setTitle("Gestión de Tareas Empresariales - Avance de Proyecto DHH");
            ventana.jCheckBox1.setFocusable(false);                 //Evita que se ilumine el texto
            
            //Evitar que el usuario escriba en el output
            ventana.TxtListas.setEnabled(false);
            ventana.TxtPilas.setEnabled(false);
            ventana.TxtColas.setEnabled(false);
            
            //Ocultar algunos elementos de listas
            ventana.menuListas.setVisible(false);
            ventana.ListasRead.setVisible(false);
            ventana.hide1Listas.setVisible(false);
            ventana.hide2Listas.setVisible(false);
            ventana.hide3Listas.setVisible(false);
            ventana.hideTlistas1.setVisible(false);
            ventana.hideTlistas2.setVisible(false);
            ventana.hideTlistas3.setVisible(false);
            
            // Ocultar algunos elementos de pilas
            ventana.PilasRead.setVisible(false);
            ventana.hide1Pilas.setVisible(false);
            ventana.hide2Pilas.setVisible(false);
            ventana.hideTpilas1.setVisible(false);
            ventana.hideTpilas2.setVisible(false);
            
            //Ocultar algunos elementos de colas
            ventana.ColasRead.setVisible(false);
            ventana.hide1Colas.setVisible(false);
            ventana.hide2Colas.setVisible(false);
            ventana.hide3Colas.setVisible(false);
            ventana.hideTcolas1.setVisible(false);
            ventana.hideTcolas2.setVisible(false);
            ventana.hideTcolas3.setVisible(false);
   
        ventana.setVisible(true);  
    }
    
}
