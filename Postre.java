public class Postre extends Platillo {
    private boolean vegano;
    public Postre(String nombre, String descripcion, double precio, int tiempoPreparacion,
                  boolean vegano) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.vegano = vegano;
    }
    public boolean isVegano() {
        return vegano;
    }
    @Override
    public String getTipo() {
        return "Postre";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Vegano: " + vegano;
    }
}