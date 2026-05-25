import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Restaurante {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "¡Bienvenido al Restaurante ____!","Nombre del restaurante",JOptionPane.INFORMATION_MESSAGE);
        boolean salida=false;
        while(!salida) {
            String[] opciones = {"Mostrar Menú", "Agregar Platillo", "Ver órdenes completadas", "Ver órdenes completadas por fecha", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Por favor, seleccione una opción:", "Menú del Restaurante",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    //Mostrar Menú
                    break;
                case 1:
                    //Agregar nueva orden
                    break;
                case 2:
                    //Ver órdenes completadas
                    break;
                case 3:
                    //Ver órdenes completadas por fecha
                    break;
                case 4:
                    //Salir del programa
                    JOptionPane.showMessageDialog(null, "Gracias por visitar el Restaurante ____. ¡Hasta luego!");
                    salida=true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción del menú.");
            }
        }
    }
    
}