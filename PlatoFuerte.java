public class PlatoFuerte extends Platillo {

    private String tipoProteina;

    public PlatoFuerte(String nombre, String descripcion, double precio, int tiempoPreparacion, String tipoProteina) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.tipoProteina = tipoProteina;
    }
    public String getTipoProteina() {
        return tipoProteina;
    }
    
    @Override
    public String getTipo() {
        return "PlatoFuerte";
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nProteína: " + tipoProteina+"\n";
    }
    
    @Override
    public String getMensajeCoccion() {
        return "El plato fuerte se está cocinando a fuego medio.";
    }

    @Override
    public Platillo copiar() {
        return new PlatoFuerte(getNombre(), getDescripcion(), getPrecio(), getTiempoPreparacion(), tipoProteina);
    }
}