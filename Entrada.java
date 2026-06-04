public class Entrada extends Platillo {

    boolean esParaCompartir;
    String tipoEntrada;

    public Entrada(String nombre, String descripcion, double precio, int tiempoPreparacion, boolean esParaCompartir,
            String tipoEntrada) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.esParaCompartir = esParaCompartir;
        this.tipoEntrada = tipoEntrada;
    }

    //GETTERS
    
    @Override
    public String getMensajeCoccion() {
        return "Preparando una entrada: " + getNombre()+tipoEntrada + (esParaCompartir ? " ,para compartir." : ".");
    }

    @Override
    public String getTipo() {
        return "Entrada";
    }

    @Override
    public String toString() {
        return super.toString()+
        "\nEs para compartir: " + (esParaCompartir ? "Sí" : "No") + "\nTipo de entrada: " + tipoEntrada+"\n";
    }

    @Override
    public Platillo copiar() {
        return new Entrada(getNombre(), getDescripcion(), getPrecio(), getTiempoPreparacion(), esParaCompartir, tipoEntrada);
    }
    
}