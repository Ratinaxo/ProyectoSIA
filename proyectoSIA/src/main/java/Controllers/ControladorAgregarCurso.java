package Controllers;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import Model.Colegio;
import Views.VentanaAgregarCurso;

public class ControladorAgregarCurso implements MouseListener{
    Colegio colegio;
    VentanaAgregarCurso ventana;
    public ControladorAgregarCurso(Colegio colegio){
        this.colegio = colegio;
        this.ventana = new VentanaAgregarCurso();
        this.ventana.setListener(this);
        this.ventana.setVisible(true);
    }
    
    public void agregarCurso(){
        this.colegio.agregarCurso(this.ventana.getjTextField1(), this.ventana.getjTextField2());
    }
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            agregarCurso();
            this.ventana.dispose();
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
