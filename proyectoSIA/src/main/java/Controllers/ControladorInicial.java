package Controllers;

import java.io.IOException;

import Model.Colegio;
import Views.VentanaAdministrar;
import Views.VentanaInicial;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorInicial implements MouseListener{
    private Colegio colegio;
    private VentanaInicial ventana;
    
    public ControladorInicial(Colegio colegio, VentanaInicial ventana){
        try
        {
            this.colegio = colegio;
            this.colegio.inicializarSistema();
            this.ventana = ventana;
            this.ventana.setListener(this);
        }
        catch (IOException e)
        {
            ventana.mostrarMensaje("Error al inicializar el sistema");
        }
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
    
    
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            admin();
            this.switchVentana();
            
        }else if (me.getSource() == ventana.getjButton2()){
            
        
        }else if (me.getSource() == ventana.getjButton3()){
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
