package Model;

import java.util.*;

public class Colegio {
    private HashMap<String,Curso> mapaCursos;
    private ArrayList<Curso> cursos;

    public Colegio(){
        cursos = new ArrayList<>();
        mapaCursos = new HashMap<>();
    }
    
    public HashMap<String, Curso> getMapaCursos() {
        return mapaCursos;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public String[] mostrarCursos(){
        if(!cursos.isEmpty()){
            String[] cursos2 = new String[cursos.size()];
            for (int i = 0; i < cursos.size(); i++){
                cursos2[i] = cursos.get(i).getCurso();
            }
            return cursos2;
        }
        System.out.println("No hay clases");
        return null;
    }
    
    public Curso buscarCurso(String curso){
        if (this.mapaCursos.containsKey(curso))return this.mapaCursos.get(curso);
        return null;
    }
    
    public void inicializarSistema() {
        Curso curso;
        RecursoDigital recurso;
        ArrayList listaCursos, listaRecursos;
        String[] nombreCursos = {"1A","1B","2A","2B","3A","3B","4A","4B","5A","5B",
            "6A","6B","7A","7B","8A","8B"};
        String[] nombreProfes = {"Juan", "Jose", "Maria", "Carlos", "Laura", "Pedro", 
           "Ana", "Luis", "Sofia", "Diego", "Elena", "Pablo", "Carmen", "Andres", 
           "Lucia","Doroty"};
       
        String[] nombreRecursos = {"Aula virtual", "Correo electrónico", 
          "Herramientas Adobe", "Herramientas Office", 
          "Biblioteca virtual", "Herramientas de videoconferencia", 
          "Almacenamiento en la nube"};
        
        listaCursos = new ArrayList<>();
        listaRecursos = new ArrayList<>();
        for (int i = 0; i < nombreCursos.length; i++){
            listaCursos.add(nombreCursos[i]);
        }
        for (int i = 0; i < nombreRecursos.length; i++){
            listaRecursos.add(nombreRecursos[i]);
        }
        int i = 0;
        while(listaRecursos.size() != i){
            curso = new Curso((String)listaCursos.get(i), nombreProfes[i]);
            curso.agregarRecurso((String)listaRecursos.get(i), i);
            i++;
            cursos.add(curso);
            mapaCursos.put(curso.getCurso(),curso);
        }
    }

    public boolean modificarRecurso(String nomCurso, int idRecurso, String nvoNombreRecurso, String nvaAsignatura)
    {
        if (((Curso)mapaCursos.get((String)nomCurso)).modificarRecurso(idRecurso, nvoNombreRecurso, nvaAsignatura))
        {
            for (int i = 0; i < cursos.size(); i++)
            {
                if (((Curso)cursos.get(i)).getCurso().equals(nomCurso))
                {
                    ((Curso)cursos.get(i)).modificarRecurso(idRecurso, nvoNombreRecurso, nvaAsignatura);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean eliminarRecurso(String nomCurso, int idRecurso)
    {
        if (((Curso)mapaCursos.get((String)nomCurso)).eliminarRecurso(idRecurso))
        {
            for (int i = 0; i < cursos.size(); i++)
            {
                if (((Curso)cursos.get(i)).getCurso().equals(nomCurso))
                {
                    ((Curso)cursos.get(i)).eliminarRecurso(idRecurso);
                    
                    return true;
                }
            }
        }
        
        return false;
    }
}