public class Cocinero extends Thread {

    private String nombre;
    private String especialidad;
    private Restaurante restaurante;

    public Cocinero(String nombre, String especialidad, Restaurante restaurante) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.restaurante = restaurante;
    }

    public boolean puedePreparar(Platillo p) {

        return p.getTipo().equalsIgnoreCase(especialidad);
    }

    @Override
    public void run() {

        while (true) {

            synchronized (restaurante) {

                for (Orden orden : restaurante.getOrdenes()) {

                    for (Platillo p : orden.getPlatillos()) {

                        if (!p.isPreparado() && puedePreparar(p)) {

                            try {

                                System.out.println("\n" + nombre + " esta preparando: " + p.getNombre());

                                Thread.sleep(p.getTiempoPreparacion() * 1000);

                                p.setPreparado(true);

                                System.out.println(nombre + " termino: " + p.getNombre());

                            } catch (InterruptedException e) {

                                System.out.println(e.getMessage()
                                );
                            }
                        }
                    }

                    if (orden.estaCompleta() && !orden.isGuardada()) {

                        orden.setGuardada(true);

                        restaurante.guardarTicket(orden);
                    }
                }
            }

            try {

                Thread.sleep(300);

            } catch (InterruptedException e) {

                System.out.println(e.getMessage());
            }
        }
    }
}
