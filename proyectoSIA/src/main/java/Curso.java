import java.util.*;

public class Curso {
    private int id;
    private int cantEstudiantes;
    private ArrayList estudiantes;
    private String profJefe;
    private String curso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }

    public String getProfJefe() {
        return profJefe;
    }

    public void setProfJefe(String profJefe) {
        this.profJefe = profJefe;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
