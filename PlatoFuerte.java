public class PlatoFuerte extends Platillo {

    private String tipoProteina;

    public PlatoFuerte(String nombre, String descripcion, double precio, int tiempoPreparacion,
                       String tipoProteina) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.tipoProteina = tipoProteina;
    }
    public String getTipoProteina() {
        return tipoProteina;
    }
    
    @Override
    public String getTipo() {
        return "Plato fuerte";
    }
    @Override
    public String toString() {
        return super.toString() +
                "Proteína: " + tipoProteina;
    }
    
    @Override
    public String getMensajeCoccion() {
        return "El plato fuerte se está cocinando a fuego medio.";
    }
}