package Controllers;

import Exceptions.ExceptionAsignatura;
import Exceptions.ExcepcionMostrarRecursos;

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
        try
        {
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
        catch (ExceptionAsignatura a)
        {
            ventanaMostrar.displayMessage("Ha ocurrido un error en la busqueda del recurso asociado a la asignatura ingresada");
        }
        catch (ExcepcionMostrarRecursos b)
        {
            ventanaMostrar.displayMessage("Ha ocurrido un error para mostrar los recursos");
        }
        catch (Exception c)
        {
            ventanaMostrar.displayMessage("Ha ocurrido un error inesperado");
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
