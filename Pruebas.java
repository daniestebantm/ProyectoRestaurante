import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Pruebas {
    
    public static void agregarOrden(Restaurante restaurante) {
        Orden orden = new Orden();
        while(true) {
            int opPlato=-1;
            String[] opcionesPlato = new String[]{"Entrada", "Plato Fuerte", "Postre","Confirmar orden"};
            opPlato = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de platillo:",
                "Agregar Orden",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcionesPlato,
                opcionesPlato[0]);
            switch(opPlato) {
                case 0:
                //ENTRADA
                    String[] opcionesEntradas = new String[]{"Carpaccio","Provolone al forno"};
                    int opEntrada = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione la entrada:",
                            "Agregar Orden",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opcionesEntradas,
                            opcionesEntradas[0]);
                    switch(opEntrada) {
                        case 0:
                            orden.agregarPlatillo(restaurante.getMenu().get(0));
                            break;
                        case 1:
                            orden.agregarPlatillo(restaurante.getMenu().get(1));
                            break;
                        default:
                            break;
                    }
                    break;
                case 1:
                //PLATO FUERTE
                    String[] opcionesFuertes = new String[]{"Lasagna bolognesa","Risotto ai Frutti di Mare"};
                    int opFuerte = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione el plato fuerte:",
                            "Agregar Orden",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opcionesFuertes,
                            opcionesFuertes[0]);
                    switch(opFuerte) {
                        case 0:
                            orden.agregarPlatillo(restaurante.getMenu().get(2));
                            restaurante.agregarOrden(orden);
                            break;
                        case 1:
                            orden.agregarPlatillo(restaurante.getMenu().get(3));
                            restaurante.agregarOrden(orden);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                //POSTRE
                    String[] opcionesPostres = new String[]{"Tiramisu","Gelato"};
                    int opPostre = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione el postre:",
                            "Agregar Orden",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opcionesPostres,
                            opcionesPostres[0]);
                    switch(opPostre) {
                        case 0:
                            orden.agregarPlatillo(restaurante.getMenu().get(4));
                            break;
                        case 1:
                            orden.agregarPlatillo(restaurante.getMenu().get(5));
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    try {
                        if(orden.getPlatillos().isEmpty()) {
                            throw new OrdenVaciaException("No se han agregado platillos a la orden.");
                        }
                        String nombresOrden = "";
                        for(Platillo p : orden.getPlatillos()) {
                            nombresOrden += p.getNombre() + "\n";
                        }
                        boolean confirmacion = JOptionPane.showConfirmDialog(
                                null,
                                "===== ORDEN #" + orden.getId() + " =====\n" + nombresOrden + "¿Desea confirmar la orden?",
                                "Confirmar Orden",
                                JOptionPane.YES_NO_OPTION
                        ) == JOptionPane.YES_OPTION;
                        if(confirmacion) {
                            restaurante.agregarOrden(orden);
                            JOptionPane.showMessageDialog(null,"Orden confirmada!");
                        } else {
                            JOptionPane.showMessageDialog(null,"Orden cancelada.");
                        }
                    } catch (OrdenVaciaException e) {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                default:
                    //orden.setContador(-1);
                    return;
            }
        }
    }
    public static void verOrdenesCompletadas(Restaurante restaurante) {
        ArrayList<Orden> completadas = new ArrayList<>();
        for (Orden o : restaurante.getOrdenes()) {
            if (o.estaCompleta()) {
                completadas.add(o);
            }
        }
        // Mostrar las órdenes completadas
        for (Orden o : completadas) {
            JOptionPane.showMessageDialog(null, o.toString());
        }
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        Cocinero CEntradas1 = new Cocinero("Giovanni","Entrada",restaurante);
        Cocinero CFuertes1 = new Cocinero("Luca","PlatoFuerte",restaurante);
        Cocinero CPostres1 = new Cocinero("Sofia","Postre",restaurante);

        JOptionPane.showMessageDialog(null,"Bienvenido al restaurante italiano!");
        boolean salir = false;
        while(!salir) {
            String[] opciones = {"Ver Menú", "Agregar Orden", "Ver órdenes completadas","Ver órdenes por fecha","Salir"};
            int accion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Restaurante Italiano",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch(accion) {
                case 0:
                //VER MENÚ
                    restaurante.mostrarMenu();
                    break;
                case 1:
                //AGREGAR ORDEN
                    agregarOrden(restaurante);
                    break;
                case 2:
                //VER ÓRDENES COMPLETADAS
                    verOrdenesCompletadas(restaurante);
                    break;
                case 3:
                //VER ÓRDENES POR FECHA
                    break;
                case 4:
                    salir=true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }
}
