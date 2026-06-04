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
    
    

    @Override
    public String toString() {

        return nombre +
                "\nDescripcion: " + descripcion +
                "\nPrecio: $" + precio +
                "\nTipo: " + getTipo();
    }

    public abstract String getMensajeCoccion();

    //GETTERS
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

    public String getTipo() {
        return "Platillo";
    }

    public boolean isEstaPreparado() {
        return estaPreparado;
    }

    //SETTERS

    public void setEstaPreparado(boolean estaPreparado) {
        this.estaPreparado = estaPreparado;
    }

    //Regresa una nueva copia de este platillo (usado para que las ordenes no compartan instancias del menú)
    public abstract Platillo copiar();
}