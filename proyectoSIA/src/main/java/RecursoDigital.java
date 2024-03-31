public class RecursoDigital{
    private Integer id;
    private String nombre;
    private String asignatura;

    public RecursoDigital(Integer id, String nombre, String asignatura) {
        this.id = id;
        this.nombre = nombre;
        this.asignatura = asignatura;
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
}