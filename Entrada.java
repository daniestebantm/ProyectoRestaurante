public class Entrada extends Platillo {
    public Entrada(String nombre, String descripcion, double precio, int tiempoPreparacion) {
        super(nombre, descripcion, precio, tiempoPreparacion);
    }
    @Override
    public String getTipo() {
        return "Entrada";
    }
}