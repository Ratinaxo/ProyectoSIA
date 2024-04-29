package Controllers;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import Model.Curso;
import Views.VentanaEliminarRecurso;
import Views.VentanaBuscarRecurso;
import Views.VentanaNoExisteRecurso;

public class ControladorEliminarRecurso implements MouseListener{
    private Curso curso;
    private VentanaEliminarRecurso ventana;
    private int id;

    public ControladorEliminarRecurso(Curso curso, VentanaBuscarRecurso ventanaBusq){
        this.curso = curso;
        this.ventana = new VentanaEliminarRecurso();
        this.ventana.setVisible(true);
        this.ventana.setListener(this);
    }
    
    public void eliminarRecurso(){
        if (curso.buscarRecursoID(Integer.parseInt(ventana.getjTextField1()))){
            curso.eliminarRecurso(Integer.parseInt(ventana.getjTextField1()));
            this.ventana.setVisible(false);
        }else new VentanaNoExisteRecurso().setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        if(me.getSource() == ventana.getjButton1()){
            eliminarRecurso();
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
