package Controllers;

import Model.Colegio;
import Views.VentanaEditarRecursos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorEditarRecursos implements MouseListener{
    private Colegio colegio;
    private VentanaEditarRecursos ventana;
    private ControladorInicial controladorIni;
    
    public ControladorEditarRecursos(Colegio colegio, VentanaEditarRecursos ventana, ControladorInicial controladorIni){
        this.colegio = colegio;
        this.ventana = ventana;
        this.controladorIni = controladorIni;
        this.ventana.setListener(this);
    }
    
    public void modificarRecurso(){
        
    }
    
    public void eliminarRecurso(){
        
    }
    
    
    public void performAction(MouseEvent e){}
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            modificarRecurso();
            controladorIni.switchVentana();
        }else if (me.getSource() == ventana.getjButton2()){
            eliminarRecurso();
            controladorIni.switchVentana();
        }else if (me.getSource() == ventana.getjButton3()){
            ventana.setVisible(false);
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
