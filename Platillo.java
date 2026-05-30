public abstract class Platillo {
    private String nombre;
    private double precio; 
    private int tiempoPreparacion;
    private boolean estaPreparado;
    private String descripcion;

    public Platillo(String nombre, String descripcion, double precio, int tiempoPreparacion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.estaPreparado = false;
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

    public boolean isEstaPreparado() {
        return estaPreparado;
    }

    public void setEstaPreparado(boolean estaPreparado) {
        this.estaPreparado = estaPreparado;
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

    public abstract String getMensajeCoccion();
}