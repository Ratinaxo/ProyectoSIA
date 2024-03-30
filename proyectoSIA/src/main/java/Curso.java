import java.util.*;
public class Curso {
    private String curso;
    private String profJefe;
    private HashMap<Integer,RecursoDigital> recursosMapa;

    public Curso(String curso, String profJefe){
        this.curso = curso;
        this.profJefe = profJefe;
        recursosMapa = new HashMap<>();
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfJefe() {
        return profJefe;
    }

    public void setProfJefe(String profJefe) {
        this.profJefe = profJefe;
    }

    public HashMap<Integer, RecursoDigital> getRecursosMapa() {
        return recursosMapa;
    }

    public void setRecursosMapa(HashMap<Integer, RecursoDigital> recursosMapa) {
        this.recursosMapa = recursosMapa;
    }

    public void agregarRecurso(String nombre, Integer id, int cant){
        if(!recursosMapa.containsKey(id)){
            RecursoDigital recurso = new RecursoDigital(id, nombre, cant);
            recursosMapa.put(id, recurso);
            System.out.println("Recurso digital agregado");
        }else System.out.println("El recurso ya se encuentra en el curso");
    }
    public void mostrarReecursos(){
        System.out.println(recursosMapa.values());
    }
}
