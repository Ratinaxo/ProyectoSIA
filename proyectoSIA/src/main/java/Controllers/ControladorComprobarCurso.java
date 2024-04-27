package Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Colegio;
import Views.VentanaComprobarCurso;
import Views.VentanaModificarRecursos;
import Views.VentanaNoExisteCurso;

public class ControladorComprobarCurso implements MouseListener{
    private Colegio colegio;
    private VentanaComprobarCurso ventana;

    public ControladorComprobarCurso(Colegio colegio, VentanaComprobarCurso ventana){
        this.colegio = colegio;
        this.ventana = ventana;
        this.ventana.setListener(this);
        this.ventana.setVisible(true);
    }
    
    public void comprobarCurso(){ //POSIBLE TRY-CATH
        VentanaNoExisteCurso vc = new VentanaNoExisteCurso();
        if (colegio.getMapaCursos().containsKey(this.ventana.getjTextField1())){
            VentanaModificarRecursos vv = new VentanaModificarRecursos();
            ControladorModificarRecursos cc = new ControladorModificarRecursos(colegio.getMapaCursos().get(this.ventana.getjTextField1()), vv);
            this.ventana.setVisible(false);
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
