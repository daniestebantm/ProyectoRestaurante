public class Postre extends Platillo {

    private boolean esDulce;
    private boolean esVegano;

    public Postre(String nombre, String descripcion, double precio, int tiempoPreparacion,
                  boolean esVegano) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.esVegano = esVegano;
    }

    public boolean esVegano() {
        return esVegano;
    }
    
    public boolean esDulce() {
        return esDulce;
    }

    public void setEsDulce(boolean esDulce) {
        this.esDulce = esDulce;
    }

    public void setEsVegano(boolean esVegano) {
        this.esVegano = esVegano;
    }

    @Override
    public String getTipo() {
        return "Postre";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Vegano: " + esVegano;
    }

    @Override
    public String getMensajeCoccion() {
        String mensaje= (esVegano()? "Preparando un postre vegano: " : "Preparando un postre: ") + getNombre();
        return mensaje;
    }
}