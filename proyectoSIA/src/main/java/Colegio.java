import java.util.*;
import java.io.*;

class Colegio {

    private String nombreColegio;
    private Map<String, Curso> mapaCursos;
    BufferedReader lector;

    public Colegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
        this.mapaCursos = new HashMap<>();
        lector = new BufferedReader(new InputStreamReader(System.in));
    }

    public void ejecutar() throws IOException {
        int opcion = 0;

        inicializarSistema();
        while (opcion != 5) {
            mostrarMenu();
            opcion = Integer.parseInt(lector.readLine());

            System.out.println("=====================================\n");

            switch (opcion) {
                case 1: {
                    agregarCurso();
                    break;
                }
                case 2: {
                    agregarRecursoACurso();
                    break;
                }
                case 3: {
                    mostrarDatosCursos();
                    break;
                }
                case 4: {
                    eliminarCurso();
                    break;
                }
                case 5: {
                    System.out.println("Adiós, que tenga un buen día");
                    break;
                }
                default:
                    System.out.println("Opción no válida, por favor seleccione otra opción.");
            }
            System.out.println("\n=====================================\n");
        }
    }

    /**
     * ********************************************************************************
     */
    //FUNCION DE MENU
    private void mostrarMenu() {
        System.out.println("\nSeleccione qué acción quiere realizar:\n");
        System.out.println("1- Agregar curso");
        System.out.println("2- Agregar recurso a un curso");
        System.out.println("3- Mostar datos de cursos");
        System.out.println("4.- Eliminar curso");
        System.out.println("5- salir");
        System.out.println("=====================================\n");
        System.out.println("Ingrese su opción: ");
    }

    /**
     * ********************************************************************************
     */
    //FUNCIONES PARA INICIALIZAR
    public void inicializarSistema() {
        Curso curso;
        RecursoDigital recursoEducativo;

        curso = new Curso(1, 30, "Arthur Doyle", "1ro basico A");
        mapaCursos.put(curso.getCurso(), curso);

        recursoEducativo = new RecursoDigital(10, "Kahoot", "Historia");
        curso.agregarRecurso(recursoEducativo);

        recursoEducativo = new RecursoDigital(13, "YouTube", "Ciencias Naturales");
        curso.agregarRecurso(recursoEducativo);

        curso = new Curso(2, 30, "Paulo Coelho", "3ro Medio B");
        mapaCursos.put(curso.getCurso(), curso);

        recursoEducativo = new RecursoDigital(53, "YouTube", "Filosofia");
        curso.agregarRecurso(recursoEducativo);

        recursoEducativo = new RecursoDigital(85, "PPTs", "Filosofia");
        curso.agregarRecurso(recursoEducativo);

        curso = new Curso(3, 30, "Paula Hawkins", "6to basico A");
        mapaCursos.put(curso.getCurso(), curso);

        recursoEducativo = new RecursoDigital(43, "Duolingo", "Ingles");
        curso.agregarRecurso(recursoEducativo);

        curso = new Curso(4, 30, "Abraham Stoker", "8vo basico A");
        mapaCursos.put(curso.getCurso(), curso);

        recursoEducativo = new RecursoDigital(66, "Canva", "Artes Visuales");
        curso.agregarRecurso(recursoEducativo);
    }

    /**
     * ********************************************************************************
     */
    //Funciones de agregar
    public void agregarCurso() throws IOException {
        int id, capCurso, flagId = 0, flagCurso = 0, flagProf = 0;
        String profJefe, nombreCurso;
        Curso cursoActual, curso;

        System.out.println("Ingrese el ID del curso: ");
        id = Integer.parseInt(lector.readLine());

        System.out.println("Ingrese la capacidad del curso: ");
        capCurso = Integer.parseInt(lector.readLine());

        System.out.println("Ingrese el nombre del profesor jefe: ");
        profJefe = lector.readLine();

        System.out.println("Ingrese el nombre del curso: ");
        nombreCurso = lector.readLine();
        
        for (Map.Entry<String, Curso> entry : mapaCursos.entrySet())
        {
            cursoActual = entry.getValue();
            
            if (cursoActual.getId() == id)
            {
                flagId = 1;
                break;
            }
            if (cursoActual.getCurso().equalsIgnoreCase(nombreCurso))
            {
                flagCurso = 1;
            }
            if (cursoActual.getProfJefe().equalsIgnoreCase(profJefe))
            {
                flagProf = 1;
            }
        }
        
        if (flagId == 1)
            System.out.println("\nALERTA: Ya existe un curso con el mismo ID");
        
        else if (flagCurso == 1)
            System.out.println("\nALERTA: Ya existe un curso con el mismo nombre");
        
        else if (flagProf == 1) 
            System.out.println("\nALERTA: Ya existe un curso con el mismo profesor jefe");
        
        else
        {
            curso = new Curso(id, capCurso, profJefe, nombreCurso);
            mapaCursos.put(curso.getCurso(), curso);
            System.out.println("\nSe ha ingresado el curso con éxito");
        }
    }

    public void agregarRecursoACurso() throws IOException {
        int idRecurso;
        String nombreCurso, nombreRecurso, asignatura;
        RecursoDigital recursoEducativo;
        Curso curso;

        System.out.println("Ingrese el nombre del curso: ");
        nombreCurso = lector.readLine();

        curso = mapaCursos.get(nombreCurso);

        if (curso != null) {
            System.out.println("Ingrese el ID del recurso digital: ");
            idRecurso = Integer.parseInt(lector.readLine());

            System.out.println("Ingrese el nombre del recurso digital: ");
            nombreRecurso = lector.readLine();

            System.out.println("Ingrese la asignatura donde se usara el recurso digital: ");
            asignatura = lector.readLine();

            recursoEducativo = new RecursoDigital(idRecurso, nombreRecurso, asignatura);

            curso.agregarRecurso(recursoEducativo);
        } else {
            System.out.println("No se ha podido encontrar el curso");
        }
    }

    /**
     * ********************************************************************************
     */
    //FUNCIONES DE MOSTRAR
    public void mostrarDatosCursos() {
        ArrayList<RecursoDigital> recursosDigitales;
        RecursoDigital recursoActual;

        System.out.println("Cursos en el colegio " + nombreColegio + ":\n");

        for (Map.Entry<String, Curso> entry : mapaCursos.entrySet()) {
            Curso curso = entry.getValue();
            System.out.println("ID del Curso: " + curso.getId());
            System.out.println("Nombre del Curso: " + curso.getCurso());
            System.out.println("Profesor Jefe: " + curso.getProfJefe());
            System.out.println("Cantidad de Estudiantes: " + curso.getEstudiantes().length);
            System.out.println("\nRecursos Digitales:\n");

            recursosDigitales = curso.getRecursosDigitales();

            for (int i = 0; i < recursosDigitales.size(); i++) {
                recursoActual = recursosDigitales.get(i);
                System.out.println("ID del Recurso: " + recursoActual.getId());
                System.out.println("Nombre del Recurso: " + recursoActual.getRecurso());
                System.out.println("Asignatura: " + recursoActual.getAsignatura() + "\n");
            }
            System.out.println("-------------------------------------");
        }
    }

    /**
     * ********************************************************************************
     */
    //FUNCIONES DE ELIMINAR
    public void eliminarCurso() throws IOException {
        int opcion = 0;
        int id;
        String nombreCurso;

        System.out.println("Indique de qué manera quiere encontrar el curso a eliminar");
        System.out.println("Opciones: ");
        System.out.println("1.- Nombre del curso");
        System.out.println("2.- ID Asignado");
        System.out.println("Ingrese opción: ");

        opcion = Integer.parseInt(lector.readLine());

        if (opcion == 1) {
            System.out.println("Ingrese nombre del curso: ");
            nombreCurso = lector.readLine();
            eliminarCursoIngresado(nombreCurso);

        } else if (opcion == 2) {
            System.out.println("Ingrese id del curso: ");
            id = Integer.parseInt(lector.readLine());
            eliminarCursoIngresado(id);

        }

    }

    private void eliminarCursoIngresado(String nombreCurso) {
        Curso cursoAEliminar = mapaCursos.get(nombreCurso);
        if (cursoAEliminar != null) {
            mapaCursos.remove(nombreCurso);
            System.out.println("Curso '" + nombreCurso + "' eliminado exitosamente.");
        } else {
            System.out.println("El curso '" + nombreCurso + "' no se encontró en el colegio.");
        }

    }

    private void eliminarCursoIngresado(int id) {
        Curso cursoAEliminar = null;

        for (Map.Entry<String, Curso> entry : mapaCursos.entrySet()) {

            if (entry.getValue().getId() == id) {
                cursoAEliminar = entry.getValue();
                break;
            }
        }

        if (cursoAEliminar != null) {
            mapaCursos.remove(cursoAEliminar.getCurso());
            System.out.println("Curso con ID '" + id + "' eliminado exitosamente.");

        } else {
            System.out.println("No se encontró ningún curso con el ID '" + id + "'.");
        }

    }

    /**
     * ********************************************************************************
     */
    //GETTERS y SETEERS
    public Curso getCurso(String nombreCurso) {
        return mapaCursos.get(nombreCurso);
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public Map<String, Curso> getCursos() {
        return mapaCursos;
    }

    public void setCursos(Map<String, Curso> mapaCursos) {
        this.mapaCursos = mapaCursos;
    }
}
