import java.io.FileWriter;
import java.io.IOException;
public class ManejadorArchivos {
    public static void guardarTicket(String texto) {
        try {
            FileWriter fw =
                    new FileWriter(
                            "ventas.txt",
                            true
                    );
            fw.write(texto + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println(
                    "Error al guardar archivo"
            );
        }
    }
}