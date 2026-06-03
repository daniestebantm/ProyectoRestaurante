import java.util.Scanner;

public class Main {
    public static int leerEntero(
            Scanner sc,
            String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero valido.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Restaurante restaurante = new Restaurante();

        Cocinero c1 = new Cocinero("Pepito", "Plato fuerte", restaurante);
        Cocinero c2 = new Cocinero("Pepita", "Postre", restaurante);
        Cocinero c3 = new Cocinero("Tilin", "Entrada", restaurante);
        c1.start();
        c2.start();
        c3.start();

        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n======= RESTAURANTE =======");
            System.out.println("1. Mostrar menu");
            System.out.println("2. Agregar orden");
            System.out.println("3. Ver ordenes actuales");
            System.out.println("4. Ver historial de ordenes");
            System.out.println("5. Salir");

            while (true) {

                opcion = leerEntero(sc, "Seleccione opcion: ");

                if (opcion >= 1 && opcion <= 5) {
                    break;
                }

                System.out.println("Opcion invalida. Intente nuevamente.");
            }

            switch (opcion) {

                case 1:

                    restaurante.mostrarMenu();
                    break;

                case 2:
                    Orden orden = new Orden();
                    restaurante.mostrarMenu();
                    int cantidad = 0;

                    while (true) {
                        try {

                            cantidad = leerEntero(sc, "\nCuantos platillos desea?: ");

                            if (cantidad <= 0) {

                                throw new OrdenVaciaException("La cantidad debe ser mayor a 0.");
                            }
                            if (cantidad > 20) {

                                throw new LimitePlatillosException("No se pueden ordenar mas de 20 platillos.");
                            }
                            break;

                        } catch (OrdenVaciaException e) {
                            System.out.println(e.getMessage());

                        } catch (LimitePlatillosException e) {

                            System.out.println(e.getMessage());
                        }
                    }

                    for (int i = 0; i < cantidad; i++) {

                        int opc;

                        while (true) {

                            opc = leerEntero(sc, "\nSeleccione platillo #" + (i + 1) + ": ");

                            if (opc >= 1 &&
                                    opc <= restaurante.getMenu().size()) {

                                break;
                            }

                            System.out.println("Opcion invalida, intenta nuevamente.");
                        }

                        orden.agregarPlatillo(restaurante.getMenu().get(opc - 1).copiar());
                    }

                    restaurante.agregarOrden(orden);

                    System.out.println("\nOrden agregada correctamente.");

                    while (!orden.estaCompleta()) {

                        try {
                            Thread.sleep(500);

                        } catch (InterruptedException e) {

                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 3:

                    if (restaurante.getOrdenes().isEmpty()) {

                        System.out.println("\nNo hay ordenes registradas.");

                    } else {

                        for (Orden o :
                                restaurante.getOrdenes()) {

                            System.out.println(o);
                        }
                    }

                    break;

                case 4:

                    System.out.println("\n======= HISTORIAL =======");

                    ManejadorArchivos.leerBitacora();

                    break;

                case 5:

                    System.out.println("\nPrograma finalizado.");
                    System.exit(0);

                    break;
            }
        }

        sc.close();
    }
}
