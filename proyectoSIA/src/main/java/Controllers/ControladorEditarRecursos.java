package Controllers;

import java.awt.event.*;
import java.util.*;

import Model.Curso;
import Views.VentanaEditarRecursos;
import Views.VentanaListaRecursos;
import Views.VentanaBuscarRecurso;

public class ControladorEditarRecursos implements MouseListener{
    Curso curso;
    VentanaEditarRecursos ventana;
    VentanaBuscarRecurso ventanaBusq;
    public ControladorEditarRecursos(Curso curso, VentanaEditarRecursos ventana){
        this.curso = curso;
        this.ventana = ventana;
        this.ventanaBusq = new VentanaBuscarRecurso();
        this.ventana.setListener(this);
        this.ventana.setVisible(true);
    }
    
    public void mostrarRecursos() {
            ControladorMostrarRecursos cc = new ControladorMostrarRecursos(curso);
    }
    
    public void agregarRecursos() {
        ControladorAgregarRecurso cc = new ControladorAgregarRecurso(curso);
    }
        
    public void modificarRecurso() {
        
        ControladorModificarRecurso cc = new ControladorModificarRecurso(curso);
    }
    
    public void eliminarRecursos() {
        ControladorEliminarRecurso cc = new ControladorEliminarRecurso(curso, ventanaBusq);
    }
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            mostrarRecursos();
            
        }else if (me.getSource() == ventana.getjButton2()){
            agregarRecursos();
            
        }else if (me.getSource() == ventana.getjButton3()){
            modificarRecurso();
            
        }else if (me.getSource() == ventana.getjButton4()){
            eliminarRecursos();
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
