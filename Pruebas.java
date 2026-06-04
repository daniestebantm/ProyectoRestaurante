import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Pruebas {
    
    //AGREGAR ORDEN
    public static void agregarOrden(Restaurante restaurante) {
        ArrayList<Platillo> platillosOrden = new ArrayList<>();
        int nPlatillos = 0;
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
                    try {
                        if(nPlatillos >= 20) {
                            throw new LimitePlatillosException("No se pueden agregar más de 20 platillos a una orden.");
                        }
                    } catch (LimitePlatillosException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(),"La Cucharetta",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    String[] opcionesEntradas = new String[]{"Carpaccio","Provolone al forno"};
                    int opEntrada = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione la entrada:",
                            "Agregar Orden",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcionesEntradas,
                            opcionesEntradas[0]);
                    switch(opEntrada) {
                        case 0:
                            platillosOrden.add(restaurante.getMenu().get(0).copiar());
                            nPlatillos++;
                            break;
                        case 1:
                            platillosOrden.add(restaurante.getMenu().get(1).copiar());
                            nPlatillos++;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1:
                //PLATO FUERTE
                    try {
                        if(nPlatillos >= 20) {
                            throw new LimitePlatillosException("No se pueden agregar más de 20 platillos a una orden.");
                        }
                    } catch (LimitePlatillosException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(),"La Cucharetta",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    String[] opcionesFuertes = new String[]{"Lasagna bolognesa","Risotto ai Frutti di Mare","Pollo a la parmesana"};
                    int opFuerte = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione el plato fuerte:",
                            "Agregar Orden",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcionesFuertes,
                            opcionesFuertes[0]);
                    switch(opFuerte) {
                        case 0:
                            platillosOrden.add(restaurante.getMenu().get(2).copiar());
                            nPlatillos++;
                            break;
                        case 1:
                            platillosOrden.add(restaurante.getMenu().get(3).copiar());
                            nPlatillos++;
                            break;
                        case 2:
                            platillosOrden.add(restaurante.getMenu().get(4).copiar());
                            nPlatillos++;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                //POSTRE
                    try {
                        if(nPlatillos >= 20) {
                            throw new LimitePlatillosException("No se pueden agregar más de 20 platillos a una orden.");
                        }
                    } catch (LimitePlatillosException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(),"La Cucharetta",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    String[] opcionesPostres = new String[]{"Tiramisú","Gelato"};
                    int opPostre = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione el postre:",
                            "Agregar Orden",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcionesPostres,
                            opcionesPostres[0]);
                    switch(opPostre) {
                        case 0:
                            platillosOrden.add(restaurante.getMenu().get(5).copiar());
                            nPlatillos++;
                            break;
                        case 1:
                            platillosOrden.add(restaurante.getMenu().get(6).copiar());
                            nPlatillos++;
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    try {
                        if(platillosOrden.isEmpty()) {
                            throw new OrdenVaciaException("No se han agregado platillos a la orden.");
                        }
                        String nombresOrden = "";
                        for(Platillo p : platillosOrden) {
                            nombresOrden += p.getNombre();
                        }
                        String[] opcionesConfirmacion = new String[]{"Sí","No","Cancelar orden"};
                        int confirmacion = JOptionPane.showOptionDialog(
                                null,
                                "¿Confirma la orden con los siguientes platillos?\n" + nombresOrden,
                                "Confirmar Orden",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesConfirmacion,
                                opcionesConfirmacion[0]);
                        switch(confirmacion) {
                            case 0:
                                Orden orden = new Orden(platillosOrden);
                                restaurante.agregarOrden(orden);
                                JOptionPane.showMessageDialog(null,"Orden agregada correctamente.","La Cucharetta",JOptionPane.INFORMATION_MESSAGE);
                                return;
                            case 1:
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null,"Orden cancelada.","La Cucharetta",JOptionPane.INFORMATION_MESSAGE);
                                return;
                            default:
                                break;
                        }
                    } catch (OrdenVaciaException e) {
                        JOptionPane.showMessageDialog(null,e.getMessage(),"La Cucharetta",JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                default:
                    return;
            }
        }
    }

    //VER ÓRDENES COMPLETADAS POR FECHA
    public static void verOrdenesCompletadasPorFecha(Restaurante restaurante) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaSeleccionada=null;
        do {
            String fechaInput = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la fecha (dd/MM/yyyy):",
                    "Ver Órdenes por Fecha",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if(fechaInput == null) {
                return;
            }
            try {
                LocalDate.parse(fechaInput, formato);
                fechaSeleccionada = fechaInput;
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null,"Formato de fecha no válido. Intente de nuevo.","Error",JOptionPane.ERROR_MESSAGE);
            }
        } while (fechaSeleccionada == null);
        ManejadorArchivos.leerBitacoraPorFecha(fechaSeleccionada);
    }

    //MAIN
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        ArrayList<Cocinero> cocineros = new ArrayList<>();
        ArrayList<Thread> hilosCocineros = new ArrayList<>();

        cocineros.add(new Cocinero("Giovanni",1,"Entrada",restaurante));
        cocineros.add(new Cocinero("Luca",2,"PlatoFuerte",restaurante));
        cocineros.add(new Cocinero("Sofia",3,"Postre",restaurante));
        cocineros.add(new Cocinero("Marco",4,"Entrada",restaurante));
        cocineros.add(new Cocinero("Ivan",5,"PlatoFuerte",restaurante));
        cocineros.add(new Cocinero("Amelia",6,"Postre",restaurante));

        JOptionPane.showMessageDialog(null,"Bienvenido a La Cucharetta!","La Cucharetta",JOptionPane.INFORMATION_MESSAGE);
        boolean salir = false;

        for(Cocinero c : cocineros) {
            Thread t = new Thread(c);
            hilosCocineros.add(t);
        }

        for(Thread t : hilosCocineros) {
            t.start();
        }

        while(!salir) {

            String[] opciones = {"Ver Menú", "Agregar Orden", "Ver órdenes completadas","Ver órdenes por fecha","Salir"};
            int accion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "La Cucharetta",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch(accion) {
                case 0:
                //VER MENÚ (COMPLETADO)
                    System.out.println("\n========== MENÚ ==========");
                    try {
                        ManejadorArchivos.leerMenu();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"Archivo no encontrado.","Error",JOptionPane.ERROR_MESSAGE);
                        restaurante.mostrarMenu();
                    }
                    break;
                case 1:
                //AGREGAR ORDEN
                    agregarOrden(restaurante);
                    break;
                case 2:
                //VER ÓRDENES COMPLETADAS
                    System.out.println("\n===== ÓRDENES COMPLETADAS =====");
                    ManejadorArchivos.leerBitacora();
                    break;
                case 3:
                //VER ÓRDENES POR FECHA
                    verOrdenesCompletadasPorFecha(restaurante);
                    break;
                case 4:
                    salir=true;
                    restaurante.solicitarCierre();
                    try {
                        for (Thread t : hilosCocineros) {
                            t.join();
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Error al cerrar los hilos de los cocineros.");
                    }
                    JOptionPane.showMessageDialog(null,"Gracias por visitar La Cucharetta. ¡Hasta luego!","La Cucharetta",JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción no válida. Intenta de nuevo.","Error",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}
