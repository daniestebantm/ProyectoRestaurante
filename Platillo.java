public class Platillo {
    private String nombre;
    private String descripcion;
    private double precio;
    private int tiempoPreparacion;
    private boolean preparado;
    private boolean enPreparacion;

    public Platillo(String nombre, String descripcion, double precio, int tiempoPreparacion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.preparado = false;
        this.enPreparacion = false;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public boolean isPreparado() {
        return preparado;
    }

    public boolean isEnPreparacion() {
        return enPreparacion;
    }

    public void setPreparado(boolean preparado) {
        this.preparado = preparado;
    }

    public void setEnPreparacion(boolean enPreparacion) {
        this.enPreparacion = enPreparacion;
    }

    public String getTipo() {
        return "Platillo";
    }

    @Override
    public String toString() {

        return nombre +
                "\nDescripcion: " + descripcion +
                "\nPrecio: $" + precio +
                "\nTipo: " + getTipo();
    }
}