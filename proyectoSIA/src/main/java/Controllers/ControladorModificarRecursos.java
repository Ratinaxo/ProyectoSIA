package Controllers;

import java.awt.event.*;
import java.util.*;

import Model.Curso;
import Views.VentanaModificarRecursos;
import Views.VentanaListaRecursos;
import Views.VentanaAgregarRecurso;

public class ControladorModificarRecursos implements MouseListener{
    Curso curso;
    VentanaModificarRecursos ventana;
    
    public ControladorModificarRecursos(Curso curso, VentanaModificarRecursos ventana){
        this.curso = curso;
        this.ventana = ventana;
        this.ventana.setListener(this);
        this.ventana.setVisible(true);
    }
    
    public void mostrarRecursos() {
        if (curso.mostrarRecursos() != null){ 
            ControladorMostrarRecursos cc = new ControladorMostrarRecursos(curso);
            
        }
        
    }
    
    public void agregarRecursos() {
        VentanaAgregarRecurso vv = new VentanaAgregarRecurso();
        ControladorAgregarRecurso cc = new ControladorAgregarRecurso(curso, vv);
    }
        
    public void editarRecursos() {}
    
    public void eliminarRecursos() {}
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            mostrarRecursos();
            
        }else if (me.getSource() == ventana.getjButton2()){
            agregarRecursos();
            
        }/*else if (me.getSource() == ventana.getjButton3()){
            modificarCursos();
            
        }else if (me.getSource() == ventana.getjButton4()){
            ventana.setVisible(false);
            controladorIni.switchVentana();
        }*/
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
