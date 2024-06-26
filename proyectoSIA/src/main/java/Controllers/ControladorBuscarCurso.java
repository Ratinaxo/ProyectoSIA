package Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Colegio;
import Views.VentanaBuscarCurso;
import Views.VentanaEditarRecursos;
import Views.VentanaNoExisteCurso;

public class ControladorBuscarCurso implements MouseListener{
    private Colegio colegio;
    private VentanaBuscarCurso ventana;
    private ControladorAdministrar admin;
    public ControladorBuscarCurso(Colegio colegio, VentanaBuscarCurso ventana, ControladorAdministrar admin){
        this.colegio = colegio;
        this.ventana = ventana;
        this.admin = admin;
        this.ventana.setListener(this);
        this.ventana.setVisible(true);
    }
    
    public void comprobarCurso(){
        VentanaNoExisteCurso vc = new VentanaNoExisteCurso();
        if (colegio.getMapaCursos().containsKey(this.ventana.getjTextField1())){
            VentanaEditarRecursos vv = new VentanaEditarRecursos();
            ControladorEditarRecursos cc = new ControladorEditarRecursos(colegio.getMapaCursos().get(this.ventana.getjTextField1()), vv, admin);
            this.ventana.setVisible(false);
            this.admin.switchVentana();
        }
        else{
            vc.setVisible(true);
        }
    }
    
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            comprobarCurso();
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