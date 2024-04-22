package Controllers;

import Model.Colegio;
import Views.VentanaEditarRecursos;
import Views.VentanaEditarCursos;
import Views.VentanaInicial;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorInicial implements MouseListener{
    private Colegio colegio;
    private VentanaInicial ventana;
    
    public ControladorInicial(Colegio colegio, VentanaInicial ventana){
        this.colegio = colegio;
        this.colegio.inicializarSistema();
        this.ventana = ventana;
        this.ventana.setListener(this);
    }
    
    public void performAction(MouseEvent e){}
    
    public void editarCursos(){
        VentanaEditarCursos ventana = new VentanaEditarCursos();
        ControladorEditarCursos controlador = new ControladorEditarCursos(colegio.getCursos(), ventana, this);
    }
    public void editarRecursos(){
        VentanaEditarRecursos ventana = new VentanaEditarRecursos();
        ControladorEditarRecursos controlador = new ControladorEditarRecursos(colegio, ventana, this);
        //controlador = new ControladorEditarCursos(colegio.getCursos(), ventana);
    }
    
    public void switchVentana(){
        if (ventana.isVisible()){
            ventana.setVisible(false);
        }else{
            ventana.setVisible(true);
        }
    }
    
    public void showVentana(){
        ventana.setVisible(true);
    }
    public void notShowVentana(){
        ventana.setVisible(false);
    }
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            editarCursos();
            this.switchVentana();
        }else if (me.getSource() == ventana.getjButton2()){
            editarRecursos();
            this.switchVentana();
        }else if (me.getSource() == ventana.getjButton3())
            System.exit(0);
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
