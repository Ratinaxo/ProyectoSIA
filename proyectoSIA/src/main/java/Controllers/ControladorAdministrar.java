package Controllers;

import Model.Colegio;
import Model.Curso;
import Model.RecursoDigital;
import Views.VentanaBuscarCurso;
import Views.VentanaMostrarCursos;
import Views.VentanaAdministrar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import java.io.*;

public class ControladorAdministrar implements MouseListener{
    private Colegio colegio;
    private ArrayList<Curso> cursos;
    private VentanaAdministrar ventana;
    private ControladorInicial controladorIni;
    
    public ControladorAdministrar (Colegio colegio, VentanaAdministrar ventana, ControladorInicial controladorIni){
        this.colegio = colegio;
        this.cursos = this.colegio.getCursos();
        this.ventana = ventana;
        this.ventana.setListener(this);
        this.controladorIni = controladorIni;
        this.ventana.setVisible(true);
    }
    
    
    public void performAction(MouseEvent e){
        
    }
    
    public void mostrarCursos(){
        VentanaMostrarCursos vv = new VentanaMostrarCursos();
        String[] nomCursos = new String[cursos.size()];
        for (int i = 0; i < cursos.size(); i++){
            nomCursos[i] = cursos.get(i).getCurso();
        }
        vv.updateList(nomCursos);
        vv.setVisible(true);   
    }
    
    public void editarRecursos(){
        VentanaBuscarCurso vv = new VentanaBuscarCurso();
        ControladorBuscarCurso cc = new ControladorBuscarCurso(colegio, vv, this);
    }
    
    private void editarCursos() {
        ControladorEditarCursos cc = new ControladorEditarCursos(colegio, this);
    }
    
    public void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//main//java//Archivos//Datos_iniciales.txt"))) {
            if (!cursos.isEmpty()) {
                for (int i = 0; i < cursos.size(); i++) {
                    Curso curso = cursos.get(i);
                    String formatoCurso = formatoCurso(curso);
                    writer.write(formatoCurso);
                }
            }
        } catch (IOException e) {
            ventana.mostrarMensaje("El guardado de datos ha fallado");
        }
    }

    private String formatoCurso(Curso curso) {
        StringBuilder sb = new StringBuilder();
        RecursoDigital recurso;
        ArrayList<Integer> IdsRecursos = curso.getListaIDRecursos();
        HashMap<Integer,RecursoDigital> recursos = curso.getRecursosMapa();
        

        for (int i = 0; i < IdsRecursos.size(); i++)
        {
            recurso = recursos.get(IdsRecursos.get(i));


            sb.append(curso.getCurso()).append(",");
            sb.append(curso.getProfJefe()).append(",");
            sb.append(recurso.getNombre()).append(",");

            if (recurso.getAsignatura() != null) 
            {
                sb.append(recurso.getAsignatura());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    
    public void switchVentana(){
        if (ventana.isVisible()){
            ventana.setVisible(false);
        }else{
            ventana.setVisible(true);
        }
    }
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            mostrarCursos();
            
        }else if (me.getSource() == ventana.getjButton2()){
            editarRecursos();
            
        }else if (me.getSource() == ventana.getjButton3()){
            this.ventana.setVisible(false);
            editarCursos();
            
        }else if (me.getSource() == ventana.getjButton4()){
            guardarEnArchivo();
            controladorIni.switchVentana();
            
        }else if (me.getSource() == ventana.getjButton5()){
            this.ventana.setVisible(false);
            controladorIni.switchVentana();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
