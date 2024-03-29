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

        while (opcion != 4)
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
                case 2:
                {
                    agregarRecursoACurso();
                    break;
                }
                case 3:
                {
                    mostrarDatosCursos();
                    break;
                }
                case 4:
                {
                    System.out.println("Adiós, que tenga un buen día");
                    break;
                }
                default:
                    System.out.println("Opción no válida, por favor seleccione otra opción.");
            }
        }
    }
   
    /********************************************************************************** */
    //FUNCION DE MENU
    private void mostrarMenu()
    {
        System.out.println("\nSeleccione qué acción quiere realizar:\n");
        System.out.println("1- Agregar curso");
        System.out.println("2- Agregar recurso a un curso");
        System.out.println("3- Mostar datos de cursos");
        System.out.println("4- salir");
        System.out.println("=====================================\n");
        System.out.print("Ingrese su opción: ");
    }

    /********************************************************************************** */
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

        if (!mapaCursos.containsKey(nombreCurso))
        {
            mapaCursos.put(curso.getCurso(), curso);
            System.out.println("Se ha ingresado el curso con exito");
        }
        else
            System.out.println("ALERTA: Ya existe un curso con el mismo nombre");
    }


    public void agregarRecursoACurso() throws IOException
    {   
        String nombreCurso, nombreRecurso, asignatura;
        RecursoDigital recursoEducativo;
        Curso curso;

        System.out.println("Ingrese el nombre del curso: ");
        nombreCurso = lector.readLine();

        curso = mapaCursos.get(nombreCurso);

        if (curso != null)
        {
            System.out.println("Ingrese el nombre del recurso digital: ");
            nombreRecurso = lector.readLine();
    
            System.out.println("Ingrese la asignatura donde se usara el recurso digital: ");
            asignatura = lector.readLine();
    
            recursoEducativo = new RecursoDigital(nombreRecurso, asignatura);

            curso.agregarRecurso(recursoEducativo);

            System.out.println("Se ha ingresado el recurso digital con exito");
        }
        else
        {
            System.out.println("No se ha podido encontrar el curso");
        }
    }

    /********************************************************************************** */
    //FUNCIONES DE MOSTRAR
    public void mostrarDatosCursos()
    {
        ArrayList <RecursoDigital> recursosDigitales;
        RecursoDigital recursoActual;

        System.out.println("Cursos en el colegio " + nombreColegio + ":");

        for (Map.Entry<String, Curso> entry : mapaCursos.entrySet())
        {
            Curso curso = entry.getValue();
            System.out.println("ID del Curso: " + curso.getId());
            System.out.println("Nombre del Curso: " + curso.getCurso());
            System.out.println("Profesor Jefe: " + curso.getProfJefe());
            System.out.println("Cantidad de Estudiantes: " + curso.getEstudiantes().length);
            System.out.println("Recursos Digitales:");

            recursosDigitales = curso.getRecursosDigitales();

            for (int i = 0; i < recursosDigitales.size(); i++)
            {
                recursoActual = recursosDigitales.get(i);
                System.out.println("ID del Recurso: " + recursoActual.getId());
                System.out.println("Nombre del Recurso: " + recursoActual.getRecurso());
                System.out.println("Asignatura: " + recursoActual.getAsignatura());
            }
            System.out.println("-------------------------------------");
        }
    }

    /********************************************************************************** */
    //GETTERS y SETEERS
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

