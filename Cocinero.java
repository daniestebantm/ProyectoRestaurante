public class Cocinero extends Empleado {

    private String especialidad;
    private Restaurante restaurante;

    public Cocinero(String nombre, int id,String especialidad, Restaurante restaurante) {
        super(nombre, id);
        this.especialidad = especialidad;
        this.restaurante = restaurante;
    }

    public boolean puedePreparar(Platillo p) {

        return p.getTipo().equalsIgnoreCase(especialidad);
    }

    @Override
    public void run() {

        while (!restaurante.debeCerrar()) {
                Platillo platilloApartado = null;
                Orden ordenDelPlatillo = null;

                synchronized (restaurante.getOrdenes()) {
                    for (Orden orden : restaurante.getOrdenes()) {

                        for (Platillo p : orden.getPlatillos()) {
                            // Verificar si el platillo no está preparado y si el cocinero puede prepararlo

                            synchronized (p) {
                                if (!p.isEstaPreparado() && puedePreparar(p)) {

                                platilloApartado = p;
                                ordenDelPlatillo = orden;

                                p.setEstaPreparado(true); // Marcar el platillo como apartado para prepararlo.
                                break; // Salir del ciclo de platillos para preparar este platillo
                                } // if
                            } // synchronized (p)
                        } 
                        if (platilloApartado != null) {
                            break; // Salir del ciclo de órdenes para preparar el platillo apartado
                        }
                    } // for orden
                } // synchronized (restaurante.getOrdenes())

                // Si se ha apartado un platillo para preparar
                if (platilloApartado != null) {
                    try{
                        System.out.println("\n"+getNombre() +"( "+ especialidad +" ) comenzó a preparar: " + platilloApartado.getNombre());
                        Thread.sleep(platilloApartado.getTiempoPreparacion() * 1000); // Simula tiempo de preparación
                        System.out.println("\n" + getNombre() + " (" + especialidad + ") terminó de preparar: " + platilloApartado.getNombre());
                        
                        synchronized (ordenDelPlatillo) {
                            if (ordenDelPlatillo.estaCompleta() && !ordenDelPlatillo.isGuardada()) {
                                ordenDelPlatillo.setGuardada(true);
                                restaurante.guardarTicket(ordenDelPlatillo);
                            }
                        }

                    } catch (InterruptedException e) {
                        System.out.println("El hilo del cocinero " + getNombre() + " fue interrumpido: " + e.getMessage());
                    }
                } else {
                    // Si no se encontró ningún platillo para preparar de su especialidad, se duerme el hilo.
                    try {
                        Thread.sleep(300); // Dormir por un segundo
                    } catch (InterruptedException e) {
                        System.out.println("El hilo del cocinero " + getNombre() + " fue interrumpido: " + e.getMessage());
                    }
                }
            }
            System.out.println("\n" + getNombre() + " ha terminado su turno.");
        }

    }