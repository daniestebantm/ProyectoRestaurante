public abstract class Empleado implements Runnable {
    
    private String nombre;
    private int id;

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    //GETTERS

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    //SETTERS
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Empleado : " + nombre + " (ID: " + id + ")";
    }

}
