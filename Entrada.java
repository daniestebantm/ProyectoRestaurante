public class Entrada extends Platillo {

    private boolean esParaCompartir;
    private String tipoEntrada;

    public Entrada(String nombre, String descripcion, double precio, int tiempoPreparacion, boolean esParaCompartir,
            String tipoEntrada) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.esParaCompartir = esParaCompartir;
        this.tipoEntrada = tipoEntrada;
    }

    //GETTERS & SETTERS
    public boolean isEsParaCompartir() {
        return esParaCompartir;
    }

    public void setEsParaCompartir(boolean esParaCompartir) {
        this.esParaCompartir = esParaCompartir;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

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