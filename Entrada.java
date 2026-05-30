public class Entrada extends Platillo {

    boolean esParaCompartir;
    String tipoEntrada;

    public Entrada(String nombre, String descripcion, double precio, int tiempoPreparacion, boolean esParaCompartir,
            String tipoEntrada) {
        super(nombre, descripcion, precio, tiempoPreparacion);
        this.esParaCompartir = esParaCompartir;
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public String getMensajeCoccion() {
        return "Preparando una entrada: " + getNombre()+tipoEntrada + (esParaCompartir ? " ,para compartir." : ".");
    }

    @Override
    public String toString() {
        return super.toString()+
        "Es para compartir: " + (esParaCompartir ? "Si" : "No") + "\nTipo de entrada: " + tipoEntrada;
    }
    
}