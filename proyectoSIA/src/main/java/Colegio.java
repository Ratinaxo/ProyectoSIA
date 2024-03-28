import java.util.*;
import java.io.*;

class Colegio
{
    private String nombreColegio;
    private Map <String, Curso> mapaCursos;
    BufferedReader lector;


    public Colegio(String nombreColegio)
    {
        this.nombreColegio = nombreColegio;
        this.mapaCursos = new HashMap<>();
        lector = new BufferedReader(new InputStreamReader(System.in));
    }

    public void ejecutar() throws IOException
    {
        int opcion = 0;

        while (opcion != 7)
        {
            mostrarMenu();
            opcion = Integer.parseInt(lector.readLine());

            switch(opcion)
            {
                case 1:
                {
                    agregarCurso();
                    break;
                }
                
            }
        }
    }
    

    //FUNCION MENU
    private void mostrarMenu()
    {
        System.out.println("\nSeleccione qué acción quiere realizar:\n");
        System.out.println("1- Agregar curso");
        System.out.println("2- Buscar curso");
        System.out.println("3- Eliminar curso");
        System.out.println("4- Agregar recurso a un curso");
        System.out.println("5- Buscar recurso en un curso");
        System.out.println("6- Eliminar recurso de un curso");
        System.out.println("7- salir");
        System.out.println("=====================================\n");
        System.out.print("Ingrese su opción: ");
    }

    //Funciones de agregar
    public void agregarCurso() throws IOException
    {
        int id, capCurso;
        String profJefe, nombreCurso;
        Curso curso;

        System.out.print("Ingrese el ID del curso: ");
        id = Integer.parseInt(lector.readLine());

        System.out.print("Ingrese la capacidad del curso: ");
        capCurso = Integer.parseInt(lector.readLine());

        System.out.print("Ingrese el nombre del profesor jefe: ");
        profJefe = lector.readLine();

        System.out.print("Ingrese el nombre del curso: ");
        nombreCurso = lector.readLine();

        curso = new Curso (id, capCurso, profJefe, nombreCurso);
        mapaCursos.put(curso.getCurso(), curso);
    }
    
    
    //GETTER y SETEERS
    public Curso getCurso(String nombreCurso)
    {
        return mapaCursos.get(nombreCurso);
    }

    public String getNombreColegio()
    {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio)
    {
        this.nombreColegio = nombreColegio;
    }

    public Map <String, Curso> getCursos()
    {
        return mapaCursos;
    }

    public void setCursos(Map <String, Curso> mapaCursos)
    {
        this.mapaCursos = mapaCursos;
    }
}

