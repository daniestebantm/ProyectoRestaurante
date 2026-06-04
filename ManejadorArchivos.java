import java.io.*;
import javax.swing.JOptionPane;

public class ManejadorArchivos {

    //GUARDAR TICKET DE VENTA
    public static void guardarTicket(String texto) {
        try (FileWriter fw = new FileWriter("bitacora_ventas.txt", true)) {
            fw.write(texto);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo");
        }
    }

    //LEER ÓRDENES COMPLETADAS
    public static void leerBitacora() {
        try (BufferedReader br = new BufferedReader(new FileReader("bitacora_ventas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el historial");
        }
    }

    //LEER ÓRDENES COMPLETADAS EN UNA FECHA ESPECÍFICA
    public static void leerBitacoraPorFecha(String fecha) {
        int ordenesEnFecha = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("bitacora_ventas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals(fecha)) {
                    ordenesEnFecha++;
                    while ((linea = br.readLine()) != null && !linea.startsWith("=========== TICKET")) {
                        System.out.println(linea);
                    }
                } 
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el historial");
        }
        JOptionPane.showMessageDialog(null, "Total de órdenes en la fecha " + fecha + ": " + ordenesEnFecha);
    }

    //LEER MENÚ DESDE ARCHIVO DE TEXTO
    public static void leerMenu() throws IOException {
        
        try(BufferedReader br = new BufferedReader(new FileReader("menu.txt"))){
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }

    //OBTENER CONTADOR HISTÓRICO DE ÓRDENES COMPLETADAS
    public static int obtenerContadorHistorico() {
        int ordenesPrevias=0;
        try(BufferedReader br = new BufferedReader(new FileReader("bitacora_ventas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("=========== TICKET")) {
                    ordenesPrevias++;
                }
            }
        } catch (IOException e) {
            System.out.println("No hay historial previo. Iniciando contador en 1.");
        }
        return ordenesPrevias;
    }
}