package Controllers;

import Model.Colegio;
import Views.VentanaAdministrar;
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
    
    public void admin(){
        VentanaAdministrar ventana = new VentanaAdministrar();
        ControladorAdministrar controlador = new ControladorAdministrar(colegio, ventana, this);
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
            admin();
            this.switchVentana();
        }else if (me.getSource() == ventana.getjButton2()){
            System.exit(0);
            this.switchVentana();
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
