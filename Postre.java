public class Postre extends Platillo {

    private boolean esDulce;
    private boolean esVegano;

    public Postre(String nombre, String descripcion, double precio, int tiempoPreparacion, boolean esDulce,boolean esVegano) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.esDulce = esDulce;
        this.esVegano = esVegano;
    }

    //GETTERS

    public boolean esVegano() {
        return esVegano;
    }
    
    public boolean esDulce() {
        return esDulce;
    }

    @Override
    public String getTipo() {
        return "Postre";
    }

    @Override
    public String getMensajeCoccion() {
        String mensaje= (esVegano()? "Preparando un postre vegano: " : "Preparando un postre: ") + getNombre();
        return mensaje;
    }

    //SETTERS

    public void setEsDulce(boolean esDulce) {
        this.esDulce = esDulce;
    }

    public void setEsVegano(boolean esVegano) {
        this.esVegano = esVegano;
    }

    

    @Override
    public String toString() {
        return super.toString() +"\nEs dulce: "+(esDulce ? "Sí" : "No") +
                "\nVegano: " + (esVegano ? "Sí" : "No") +"\n";
    }

    @Override
    public Platillo copiar() {
        return new Postre(getNombre(), getDescripcion(), getPrecio(), getTiempoPreparacion(), esDulce(), esVegano());
    }
}