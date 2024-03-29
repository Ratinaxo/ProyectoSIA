public class RecursoDigital
{
    int id;
    String recurso;
    String asignatura;

    public RecursoDigital (int id, String recurso, String asignatura)
    {
        this.id = id;
        this.recurso = recurso;
        this.asignatura = asignatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignnatura(String asignnatura) {
        this.asignatura = asignnatura;
    }
}