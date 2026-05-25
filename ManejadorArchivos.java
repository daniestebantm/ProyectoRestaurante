import java.io.*;
public class ManejadorArchivos {
    public static void guardarTicket(String texto) {
        try {
            FileWriter fw =
                    new FileWriter("bitacora_ventas.txt", true);
            fw.write(texto );
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar archivo");
        }
    }
    public static void leerBitacora() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("bitacora_ventas.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer la bitacora");
        }
    }
}