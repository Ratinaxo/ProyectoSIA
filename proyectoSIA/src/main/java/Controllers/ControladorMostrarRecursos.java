package Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Views.VentanaBuscarPorAsignatura;
import Views.VentanaListaRecursos;
import Model.Curso;

public class ControladorMostrarRecursos implements MouseListener{
    Curso curso;
    VentanaBuscarPorAsignatura ventanaBuscar;
    
    public ControladorMostrarRecursos(Curso curso){
        this.curso = curso;
        this.ventanaBuscar = new VentanaBuscarPorAsignatura();
        this.ventanaBuscar.setListener(this);
        this.ventanaBuscar.setVisible(true);
        
    }
    
    public void mostrarRecursos(){
        VentanaListaRecursos ventanaMostrar = new VentanaListaRecursos();
        if (!ventanaBuscar.getjTextField1().isEmpty()){
            ventanaMostrar.updateList(curso.mostrarRecursos(ventanaBuscar.getjTextField1()));
            ventanaMostrar.setVisible(true);
            this.ventanaBuscar.setVisible(false);
        }
        else{
            ventanaMostrar.updateList(curso.mostrarRecursos());
            ventanaMostrar.setVisible(true);
            this.ventanaBuscar.setVisible(false);
        }
    }
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventanaBuscar.getjButton1()){
            mostrarRecursos();
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
