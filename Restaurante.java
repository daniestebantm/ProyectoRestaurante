import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurante {
        private ArrayList<Platillo> menu;
        private List<Orden> ordenes;
        private volatile boolean cierreSolicitado;

    public Restaurante() {
        menu = new ArrayList<>();
                //Utilizar una lista sincronizada para permitir el acceso concurrente seguro desde hilos
                ordenes = Collections.synchronizedList(new ArrayList<>());
                cierreSolicitado = false;
        cargarMenu();
    }

    public void cargarMenu() {
        menu.add(
                new Entrada(
                        "\nCarpaccio ",
                        "Láminas finísimas de carne de ternera o pescado crudo," +
                                " servidas con queso parmesano y aceite de oliva.",
                        250,
                        5, true,"Fría"
                )
        );
        menu.add(
                new Entrada(
                        "\nProvolone al forno "
                        , "Queso provolone fundido en horno de piedra, a menudo acompañado de especias y tomates.",
                        280,
                        4, false, "Caliente"
                )
        );

        menu.add(
                new PlatoFuerte(
                        "\nLasagna bolognesa ",
                        "Consiste en capas alternas de láminas de pasta, salsa boloñesa (ragú de carne)," +
                                " cremosa salsa bechamel y queso gratinado," +
                                " todo ello horneado hasta alcanzar una textura crujiente por fuera y jugosa por dentro.",
                        350,
                        7,
                        "Res"
                )

        );

        menu.add(
                new PlatoFuerte(
                        "\nRisotto ai Frutti di Mare ",
                        "Arroz cremoso italiano cocinado en un caldo de mariscos y servido con una generosa selección de pescado" +
                                ", mejillones y camarones.",
                        330,
                        8,
                        "Mariscos"
                )

        );

        menu.add(
                new PlatoFuerte(
                        "\nPollo a la parmesana ",
                        "Pechuga empanizada, frita y cubierta con salsa marinara," +
                                " queso mozzarella derretido y parmesano.",
                        380,
                        6,
                        "Pollo"
                )
        );

        menu.add(
                new Postre(
                        "\nTiramisú ",
                        "Capas de bizcochos humedecidos en café espresso" +
                                ", intercalados con una suave crema de queso mascarpone y espolvoreados con cacao amargo",
                        200,
                        3,true,
                        false
                )
        );

        menu.add(
                new Postre(
                        "\nGelato ",
                        "Helado de sabores de frutas de temporada a base de agua",
                        120,
                        2,true,
                        true
                )
        );
    }

    // Getters y métodos para manejar órdenes y cierre del restaurante
    public ArrayList<Platillo> getMenu() {

        return menu;
    }

        public List<Orden> getOrdenes() {

                return ordenes;
        }

    public void agregarOrden(Orden orden) {

        ordenes.add(orden);
    }

        public void solicitarCierre() {

                cierreSolicitado = true;
        }

        public boolean debeCerrar() {

                if (!cierreSolicitado) {
                        return false;
                }

                synchronized (ordenes) {
                        for (Orden orden : ordenes) {
                                if (!orden.estaCompleta()) {
                                        return false;
                                }
                        }
                }

                return true;
        }

    public void mostrarMenu() {

        for (int i = 0; i < menu.size(); i++) {

            System.out.println("\n" + (i + 1) + ". " + menu.get(i));
        }
    }

    public void guardarTicket(Orden orden) {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy"
                ); // Formato de fecha para el ticket, se puede ajustar según preferencias o requerimientos específicos.

        String fecha =
                LocalDate.now().format(formato); // Obtener la fecha actual formateada para incluirla en el ticket.

        orden.setFechaVenta(LocalDate.now()); // Registrar la fecha de venta en la orden para mantener un registro completo de cuándo se completó cada orden.

        String ticket =
                "\n=========== TICKET ===========\n" +
                        "Fecha:\n" + fecha + "\nOrden #" + orden.getId() + "\n\n" + orden +
                        "\n==============================\n";

        ManejadorArchivos.guardarTicket(ticket);

        System.out.println(
                " Orden #" + orden.getId() + " completada."
        );
    }

}
