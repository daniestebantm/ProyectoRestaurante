import java.util.ArrayList;

public class Orden {
    private static int contador = 1;
    private int id;
    private ArrayList<Platillo> platillos;

    public Orden() {
        id = contador++;
        platillos = new ArrayList<>();
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
    public void setContador(int paso) {
        contador += paso;
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
            texto += p ;
        }
        return texto;
    }
}