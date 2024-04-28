package Controllers;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import Model.Curso;
import Views.VentanaEliminarRecurso;
import Views.VentanaBuscarRecurso;
import Views.VentanaNoExisteRecurso;

public class ControladorEliminarRecurso implements MouseListener{
    private Curso curso;
    private int id;
    private VentanaEliminarRecurso ventana;
    private VentanaBuscarRecurso ventanaBusq;
    
    public ControladorEliminarRecurso(Curso curso, VentanaBuscarRecurso ventanaBusq){
        this.curso = curso;
        this.ventanaBusq = ventanaBusq;
        this.ventanaBusq.setListener(this);
        this.ventana = new VentanaEliminarRecurso();
        this.ventana.setListener(this);
    }
    
    public void eliminarRecurso(){
        if (curso.buscarRecursoID(id)){
            curso.eliminarRecurso(id);
            this.ventana.setVisible(false);
        }else{
            new VentanaNoExisteRecurso().setVisible(true);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        if(me.getSource() == ventana.getjButton1()){
            eliminarRecurso();
        }else if (me.getSource() == ventanaBusq.getjButton1()){
            this.id = Integer.parseInt(ventanaBusq.getjTextField1());
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
