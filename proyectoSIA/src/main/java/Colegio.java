import java.util.*;
import java.io.*;

class Colegio {
    private HashMap<String,Curso> mapaCursos;
    private ArrayList<Curso> cursos;
    private final BufferedReader lector;

    public Colegio(){
        cursos = new ArrayList<>();
        mapaCursos = new HashMap<>();
        lector = new BufferedReader(new InputStreamReader(System.in));
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void mostrarMenu() throws IOException{
        boolean flag = true;
        
        inicializarSistema();
        while(flag) {
            String input;
            int opcion;
            Curso curso;
            System.out.println("=================Se han inicializado datos================\n");
            System.out.println("\nSeleccione que accion quiere realizar:\n");
            System.out.println("1.- Mostrar cursos");
            System.out.println("2.- Mostrar datos de un curso");
            System.out.println("3.-Agregar recursos a un curso");
            System.out.println("4.- Salir");
            System.out.println("=====================================\n");
            System.out.println("Ingrese su opcion: ");
            input = lector.readLine();
            opcion = Integer.parseInt(input);
            
            switch (opcion) {
                case 1:
                    mostrarCursos();
                    break;
                case 2:
                    System.out.println("Ingrese el curso");
                    input = lector.readLine();
                    curso = mapaCursos.get((String)input);
                    System.out.println("Curso: " + curso.getCurso() + "Prof Jefe: " + curso.getProfJefe());
                    System.out.println("Recursos del curso: ");
                    curso.mostrarRecursos();
                    break;
                    
                case 3:
                    System.out.println("Ingrese el curso");
                    input = lector.readLine();
                    System.out.println("Ingrese el nombre del recurso");
                    String nomRecurso = (String)lector.readLine();
                    System.out.println("Ingrese la asignatura (0 sino posee)");
                    String nomAsignatura = (String)lector.readLine();
                    System.out.println("Ingrese el ID");
                    int ID = Integer.parseInt(lector.readLine());
                    
                    if (nomAsignatura.equals("0"))
                        (mapaCursos.get((String)input)).agregarRecurso(nomRecurso, ID);
                    else
                        (mapaCursos.get((String)input)).agregarRecurso(nomRecurso, ID, nomAsignatura);
                    
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    public void mostrarCursos(){
        if(!cursos.isEmpty()){
            for (int i = 0; i < cursos.size(); i++){
                System.out.println("Curso: "+(cursos.get(i)).getCurso()+" Profesor Jefe: "+(cursos.get(i)).getProfJefe());            
            }
        }
        else System.out.println("No hay clases");
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
}