public class Cocinero extends Empleado {

    private String especialidad;
    //private Platillo platilloActual;
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
                //Iterar sobre la colección compartida de órdenes mientras esté sincronizada para evitar modificaciones simultáneas cuando se agreguen nuevas órdenes
                synchronized (restaurante.getOrdenes()) {
                    for (Orden orden : restaurante.getOrdenes()) {

                        for (Platillo p : orden.getPlatillos()) {

                            //Bloquea cada platillo individualmente para asegurarnos de que solo un cocinero lo prepare y evitar competencia entre varios cocineros
                            synchronized (p) {
                                if (!p.isEstaPreparado() && puedePreparar(p)) {
                                    try {
                                        System.out.println("\n" + getNombre() + " está preparando: " + p.getNombre());
                                        Thread.sleep(p.getTiempoPreparacion() * 1000);
                                        p.setEstaPreparado(true);
                                        System.out.println("\n" + getNombre() + " terminó: " + p.getNombre());
                                    } catch (InterruptedException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                        }

                        //Asegurar que la verificación de orden completa y el guardado del ticket se realicen de manera atómica para evitar que un cocinero intente guardar un ticket mientras otro cocinero aún está preparando platillos para esa orden
                        synchronized (orden) {
                            if (orden.estaCompleta() && !orden.isGuardada()) {
                                orden.setGuardada(true);
                                restaurante.guardarTicket(orden);
                            }
                        }
                    }
                }
            

            try {

                Thread.sleep(300);

            } catch (InterruptedException e) {

                System.out.println(e.getMessage());
            }
        }

        System.out.println(getNombre() + " terminó su turno.");
    }
}
