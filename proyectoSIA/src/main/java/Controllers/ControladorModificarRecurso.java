package Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.Curso;
import Views.VentanaModificarRecurso;
import Views.VentanaBuscarRecurso;
import Views.VentanaNoExisteRecurso;

public class ControladorModificarRecurso implements MouseListener{
    private Curso curso;
    private VentanaModificarRecurso ventana;
    private VentanaBuscarRecurso ventanaBusq;
    private int id;
    
    public ControladorModificarRecurso(Curso curso, VentanaBuscarRecurso ventanaBusq){
        this.curso = curso;
        this.ventanaBusq = ventanaBusq;
        this.ventanaBusq.setListener(this);
        this.ventanaBusq.setVisible(true);
        this.ventana = new VentanaModificarRecurso();
        this.ventana.setListener(this);
        this.id = -1;
    }
    
    public void modificarRecurso(){
        
        if (curso.buscarRecursoID(id)){
            
        }else{
            new VentanaNoExisteRecurso().setVisible(true);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        if (me.getSource() == ventana.getjButton1()){
            modificarRecurso();
        }else if (me.getSource() == ventanaBusq.getjButton1()){
            this.id = Integer.parseInt(ventanaBusq.getjTextField1());
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
