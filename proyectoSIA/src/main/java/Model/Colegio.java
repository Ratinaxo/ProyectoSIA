package Model;

import java.util.*;
import java.io.*;

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
    
    public void inicializarSistema() throws IOException
    {
        Curso curso, auxCurso;
        ArrayList<String> listaCursos = new ArrayList<>();
        ArrayList<String> listaRecursos = new ArrayList<>();
        ArrayList<String> listaProfes = new ArrayList<>();
        ArrayList<String> listaAsignaturas = new ArrayList<>();
    
        try (BufferedReader lector = new BufferedReader(new FileReader("src//main//java//Archivos//Datos_iniciales.txt")))
        {
            String linea;
            while ((linea = lector.readLine()) != null)
            {
                String[] partes = linea.split(",");
                listaCursos.add(partes[0]);
                listaProfes.add(partes[1]);
                listaRecursos.add(partes[2]);

                if (partes.length > 3)
                {
                    listaAsignaturas.add(partes[3]);
                }
                else
                {
                    listaAsignaturas.add(null);
                }
            }
        }
        catch (IOException e)
        {
            throw e;
        }
    
        for (int i = 0; i < listaCursos.size(); i++)
        {
            curso = new Curso(listaCursos.get(i), listaProfes.get(i));
            
            if (!mapaCursos.containsKey(curso.getCurso()))
            {
                if (listaAsignaturas.get(i) != null)
                {
                    curso.agregarRecurso(listaRecursos.get(i), i, listaAsignaturas.get(i));
                }
                else 
                {
                    curso.agregarRecurso(listaRecursos.get(i), i);
                }
                
                mapaCursos.put(curso.getCurso(), curso);
                cursos.add(curso);
            }
            else
            {
                auxCurso = mapaCursos.get(curso.getCurso());
                
                if (listaAsignaturas.get(i) != null)
                {
                    auxCurso.agregarRecurso(listaRecursos.get(i), i, listaAsignaturas.get(i));
                }
                else 
                {
                    auxCurso.agregarRecurso(listaRecursos.get(i), i);
                }
            }
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
    
    public void realizarReporte() throws IOException
    {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src//main//java//Archivos//Reporte.txt")))
        {
            if (!cursos.isEmpty())
            {
                escritor.write("Existe una cantidad de " + cursos.size() + " cursos en este establecimiento\n\n");
                escritor.write("Detalles de establecimiento:\n\n");

                for (int i = 0; i < cursos.size(); i++)
                {
                    Curso curso = cursos.get(i);
                    String formato = escribirReporte(curso);
                    escritor.write(formato);
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }


    private String escribirReporte(Curso curso)
    {
        StringBuilder reporte = new StringBuilder();

        reporte.append("Curso: ").append(curso.getCurso()).append("\n");
        reporte.append("Profesor jefe: ").append(curso.getProfJefe()).append("\n\n");

        int id;

        for (int i = 0; i < curso.getListaIDRecursos().size(); i++)
        {
            id = curso.getListaIDRecursos().get(i);
            RecursoDigital recurso = curso.getRecursosMapa().get(id);

            reporte.append("Recurso/Asignatura: ").append(recurso.getNombre()).append(" / ");
            if (recurso.getAsignatura() != null) {
                reporte.append(recurso.getAsignatura());
            }
            else
            {
                reporte.append("N/A");
            }
            reporte.append("\n");
        }

        if (curso.getListaIDRecursos().isEmpty())
        {
            reporte.append("Este curso no tiene recursos digitales asociados.\n\n");
        }

        reporte.append("\n=======================================\n\n");

        return reporte.toString();
    }

}