import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Platillo> menu;
    private ArrayList<Orden> ordenes;

    public Restaurante() {
        menu = new ArrayList<>();
        ordenes = new ArrayList<>();
        cargarMenu();
    }

    public void cargarMenu() {
        menu.add(
                new Entrada(
                        "Carpaccio ",
                        " Láminas finísimas de carne de ternera o pescado crudo," +
                                " servidas con queso parmesano y aceite de oliva.",
                        250,
                        5
                )
        );
        menu.add(
                new Entrada(
                        "Provolone al forno "
                        , " Queso provolone fundido en horno de piedra, a menudo acompañado de especias y tomates.",
                        280,
                        4
                )
        );

        menu.add(
                new PlatoFuerte(
                        "Lasagna bolognesa ",
                        " Consiste en capas alternas de láminas de pasta, salsa boloñesa (ragú de carne)," +
                                " cremosa salsa bechamel y queso gratinado," +
                                " todo ello horneado hasta alcanzar una textura crujiente por fuera y jugosa por dentro.",
                        350,
                        7,
                        "Res"
                )

        );

        menu.add(
                new PlatoFuerte(
                        "Risotto ai Frutti di Mare ",
                        " Arroz cremoso italiano cocinado en un caldo de mariscos y servido con una generosa selección de pescado" +
                                ", mejillones y camarones.",
                        330,
                        8,
                        "Mariscos"
                )

        );

        menu.add(
                new PlatoFuerte(
                        "Pollo a la parmesana ",
                        " Pechuga empanizada, frita y cubierta con salsa marinara," +
                                " queso mozzarella derretido y parmesano.",
                        380,
                        6,
                        "Pollo"
                )
        );

        menu.add(
                new Postre(
                        "Tiramisu ",
                        " Capas de bizcochos humedecidos en café espresso" +
                                ", intercalados con una suave crema de queso mascarpone y espolvoreados con cacao amargo",
                        200,
                        3,
                        false
                )
        );

        menu.add(
                new Postre(
                        "Gelato ",
                        "Helado de sabroes de frutas de temporada a base de agua",
                        120,
                        2,
                        true
                )
        );
    }

    public ArrayList<Platillo> getMenu() {

        return menu;
    }

    public ArrayList<Orden> getOrdenes() {

        return ordenes;
    }

    public void agregarOrden(Orden o) {

        ordenes.add(o);
    }

    public void mostrarMenu() {
        System.out.println("\n========== MENU ==========");

        for (int i = 0; i < menu.size(); i++) {

            System.out.println("\n" + (i + 1) + ". " + menu.get(i));
        }
    }

    public void guardarTicket(Orden orden) {

        String ticket =
                "\n=========== TICKET ===========\n" +
                        "Orden #" + orden.getId() + "\n\n" +
                        orden +
                        "\n==============================\n";

        ManejadorArchivos.guardarTicket(ticket);
    }

}
