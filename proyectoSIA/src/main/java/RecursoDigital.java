public class RecursoDigital{
    private Integer id;
    private String nombre;
    private String asignatura;
    private int cant;

    public RecursoDigital(Integer id, String nombre, int cant) {
        this.id = id;
        this.nombre = nombre;
        this.cant = cant;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}