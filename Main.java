import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        Cocinero c1 = new Cocinero("Pepito", "Plato fuerte", restaurante);
        Cocinero c2 = new Cocinero("Ppepita", "Postre", restaurante);
        Cocinero c3 = new Cocinero("tilin", "Entrada", restaurante);
        c1.start();
        c2.start();
        c3.start();
        int opcion = 0;

        while(opcion != 5) {
            System.out.println("======= RESTAURANTE =======");
            System.out.println("1. Mostrar menu");
            System.out.println("2. Agregar orden");
            System.out.println("3. Ver ordenes actuales");
            System.out.println("4. Ver historial de ordenes");
            System.out.println("5. Salir");
            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    restaurante.mostrarMenu();
                    break;
                case 2:
                    Orden orden = new Orden();
                    restaurante.mostrarMenu();
                    int cantidad = 0;

                    while(true) {
                        try {
                            System.out.print("\nCuantos platillos desea?: ");
                            cantidad = sc.nextInt();
                            if (cantidad > 0) {
                                break;
                            }

                            System.out.println("La cantidad debe ser mayor a 0.");
                        } catch (Exception var13) {
                            System.out.println("Ingrese un numero valido.");
                            sc.nextLine();
                        }
                    }

                    for(int i = 0; i < cantidad; ++i) {
                        int opc = 0;

                        while(true) {
                            try {
                                System.out.print("\nSeleccione platillo #" + (i + 1) + ": ");
                                opc = sc.nextInt();
                                if (opc >= 1 && opc <= restaurante.getMenu().size()) {
                                    break;
                                }

                                System.out.println("Opcion invalida, intenta nuevamente.");
                            } catch (Exception var12) {
                                System.out.println("Ingrese un numero valido.");
                                sc.nextLine();
                            }
                        }

                        orden.agregarPlatillo((Platillo)restaurante.getMenu().get(opc - 1));
                    }

                    restaurante.agregarOrden(orden);
                    System.out.println("\nOrden agregada correctamente");
                    break;
                case 3:
                    for(Orden o : restaurante.getOrdenes()) {
                        System.out.println(o);
                    }
                    break;
                case 4:
                    System.out.println("====== HISTORIAL ======");
                    ManejadorArchivos.leerBitacora();
                    break;
                case 5:
                    System.out.println("Programa finalizado");
                    System.exit(0);
                default:
                    System.out.println("Opcion invalida");
            }
        }

    }
}
