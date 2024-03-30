import java.util.*;
import java.io.*;

class Colegio {
    private ArrayList<Curso> cursos;
    private final BufferedReader lector;

    public Colegio(){
        cursos = new ArrayList<>();
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
        while(flag) {
            String input;
            System.out.println("=================Se han inicializado datos================\n");
            System.out.println("\nSeleccione que accion quiere realizar:\n");
            System.out.println("1.- Mostrar cursos");
            System.out.println("2.- Modificar recursos de un curso");
            System.out.println("4.- Salir");
            System.out.println("=====================================\n");
            System.out.println("Ingrese su opción: ");
            input = lector.readLine();
            switch (input) {
                case "1":
                    
                    break;
                case "2":
                    break;

                default:
                    break;
            }
        }
    }
}
