package Model;

import java.util.*;

public class Curso {
    private String curso;
    private String profJefe;
    private HashMap<Integer,RecursoDigital> recursosMapa;
    private ArrayList<Integer> listaIDRecursos;

    public Curso(String curso, String profJefe){
        this.curso = curso;
        this.profJefe = profJefe;
        recursosMapa = new HashMap<>();
        listaIDRecursos = new ArrayList<>();
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

    public void agregarRecurso(String nombre, Integer id){
        if(!recursosMapa.containsKey(id)){
            RecursoDigital recurso = new RecursoDigital(id, nombre, null);
            recursosMapa.put(id, recurso);
            listaIDRecursos.add(id);
            System.out.println("Recurso digital agregado");
        }else System.out.println("El recurso ya se encuentra en el curso");
    }
    
    //sobrecarga de metodo
    public void agregarRecurso(String nombre, Integer id, String asignatura){
        if(!recursosMapa.containsKey(id)){
            RecursoDigital recurso = new RecursoDigital(id, nombre, asignatura);
            recursosMapa.put(id, recurso);
            listaIDRecursos.add(id);
            System.out.println("Recurso digital agregado");
        }else System.out.println("El recurso ya se encuentra en el curso");
    }
    public void mostrarRecursos(){
        RecursoDigital recurso;
        for (int i = 0; i < listaIDRecursos.size(); i++){
            recurso = recursosMapa.get(listaIDRecursos.get(i));
            System.out.println("Nombre: " + recurso.getNombre());
        }
    }
    //Sobrecarga de metodo
    public void mostrarRecursos(String asignatura){
        RecursoDigital recurso;
        for (int i = 0; i < listaIDRecursos.size(); i++){
            recurso = recursosMapa.get(listaIDRecursos.get(i));
            if (asignatura.equals(recurso.getAsignatura())){
                System.out.println("Nombre: " + recurso.getNombre());
            }
        }
    }

    public boolean modificarRecurso(int idRecurso, String nvoNombreRecurso, String nvaAsignatura)
    {
        RecursoDigital recursoActual;

        if (recursosMapa.containsKey(idRecurso))
        {
            recursoActual = recursosMapa.get(idRecurso);
            recursoActual.setNombre(nvoNombreRecurso);
            recursoActual.setAsignatura(nvaAsignatura);
            
            return true;
        }
        return false;
    }

    public boolean eliminarRecurso(int idRecurso)
    {
        if (recursosMapa.containsKey((idRecurso)))
        {
            recursosMapa.remove(idRecurso);

            for (int i = 0; i < listaIDRecursos.size(); i++)
            {
                if (listaIDRecursos.get(i) == idRecurso)
                {
                    listaIDRecursos.remove(i);

                    return true;  
                }
            }
        }
        return false;
    }
}