package Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.Colegio;
import Views.VentanaEditarCursos;

public class ControladorEditarCursos implements MouseListener{
    private Colegio colegio;
    private VentanaEditarCursos ventana;
    private ControladorAdministrar cc;
    public ControladorEditarCursos(Colegio colegio, ControladorAdministrar cc){
        this.colegio = colegio;
        this.cc = cc;
        this.ventana = new VentanaEditarCursos();
        this.ventana.setListener(this);
        this.ventana.setVisible(true);
    }
    
    private void agregarCurso(){
        ControladorAgregarCurso cc = new ControladorAgregarCurso(colegio);
    }
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            System.out.println("if statement");
            agregarCurso();
        }else if (me.getSource() == ventana.getjButton2()){
            this.cc.switchVentana();
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
