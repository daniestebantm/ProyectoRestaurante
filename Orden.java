import java.util.ArrayList;

public class Orden {
    private static int contador = 1;
    private int id;
    private ArrayList<Platillo> platillos;
    private boolean guardada;
    public Orden() {
        id = contador++;
        platillos = new ArrayList<>();
        guardada = false;
    }
    public void agregarPlatillo(Platillo p) {
        platillos.add(p);
    }
    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }
    public int getId() {
        return id;
    }
    public boolean isGuardada() {
        return guardada;
    }
    public void setGuardada(boolean guardada) {

        this.guardada = guardada;
    }
    public boolean estaCompleta() {
        for (Platillo p : platillos) {
            if (!p.isPreparado()) {

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