package Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.Curso;
import Views.VentanaModificarRecurso;
import Views.VentanaNoExisteRecurso;

public class ControladorModificarRecurso implements MouseListener{
    private Curso curso;
    private VentanaModificarRecurso ventana;
    
    public ControladorModificarRecurso(Curso curso){
        this.curso = curso;
        this.ventana = new VentanaModificarRecurso();
        this.ventana.setVisible(true);
        this.ventana.setListener(this);
    }
    
    
    
    public void modificarRecurso(){
        if (curso.buscarRecursoID(Integer.parseInt(ventana.getjTextField1()))){
            curso.modificarRecurso(Integer.parseInt(ventana.getjTextField1()), ventana.getjTextField2(), ventana.getjTextField3());
            this.ventana.setVisible(false);
        }else new VentanaNoExisteRecurso().setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()) {
            modificarRecurso();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        
    }
    
    @Override
    public void mouseReleased(MouseEvent me){
        
    }
    
    @Override
    public void mouseEntered(MouseEvent me){
        
    }
    
    @Override
    public void mouseExited(MouseEvent me){
        
    }
}
