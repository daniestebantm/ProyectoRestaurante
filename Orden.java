import java.util.ArrayList;
import java.time.LocalDate;

public class Orden { // Asgina último ID registrado en la bitácora de ventas para asegurar que cada orden tenga un ID único
//  incluso después de reiniciar el programa, evitando así conflictos de ID entre órdenes nuevas y las ya registradas en la bitácora
    
    private static int contador = ManejadorArchivos.obtenerContadorHistorico() + 1;
    private int id;
    private ArrayList<Platillo> platillos;
    private LocalDate fechaVenta;
    private boolean guardada;

    public Orden(ArrayList<Platillo> platillos) {
        id = contador++;
        this.platillos = new ArrayList<>(platillos);
        guardada = false;
    }
    public void agregarPlatillo(Platillo p) {
        platillos.add(p);
    }

    //GETTERS
    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }
    public int getId() {
        return id;
    }
    public boolean isGuardada() {
        return guardada;
    }

    //SETTERS
    public void setGuardada(boolean guardada) {
        this.guardada = guardada;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean estaCompleta() {
        for (Platillo p : platillos) {
            if (!p.isEstaPreparado()) {

                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String texto = "===== ORDEN #" + id + " =====\n";
        for (Platillo p : platillos) {
            texto += p;
        }
        return texto;
    }
}