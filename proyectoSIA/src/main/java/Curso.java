import java.util.*;

class Curso
{
    private int id;
    private int capCurso;
    private String curso;
    private String profJefe;
    private Estudiante[] estudiantes; 
    private ArrayList <RecursoDigital> recursosDigitales;


    public Curso(int id, int capCurso, String profJefe, String curso)
    {
        this.id = id;
        this.curso = curso;
        this.profJefe = profJefe;
        this.capCurso = capCurso;
        this.estudiantes = new Estudiante[capCurso];
        this.recursosDigitales = new ArrayList<>();
    }


    //AGREGAR
    public void agregarRecurso(RecursoDigital recurso)
    {
        if (existeRecurso(recurso) != 1)
        {
            recursosDigitales.add(recurso);
            System.out.println("\nSe ha ingresado el recurso digital con exito");
        }
        else
            System.out.println("\nERROR: Ya existe este recurso para esta asignatura");
    }
    
    public int existeRecurso(RecursoDigital recurso)
    {   
        for (int i = 0; i < recursosDigitales.size(); i++)
        {
            if (recursosDigitales.get(i).getId() == recurso.getId())
            {
                if (recursosDigitales.get(i).getRecurso().equals(recurso.getRecurso()))
                {
                    if (recursosDigitales.get(i).getAsignatura().equals(recurso.getAsignatura()))
                    {
                        return 1;
                    }
                } 
            }
        }
        return 0;
    }
            
    
    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getCapCurso() {
        return capCurso;
    }


    public void setCapCurso(int capCurso) {
        this.capCurso = capCurso;
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


    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }


    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }


    public ArrayList<RecursoDigital> getRecursosDigitales() {
        return recursosDigitales;
    }


    public void setRecursosDigitales(ArrayList<RecursoDigital> recursosDigitales) {
        this.recursosDigitales = recursosDigitales;
    }
}