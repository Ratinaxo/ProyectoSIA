package Controllers;

import Model.Curso;
import Views.VentanaAgregarRecurso;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ControladorAgregarRecurso implements MouseListener{
    Curso curso;
    VentanaAgregarRecurso ventana;

    public ControladorAgregarRecurso(Curso curso, VentanaAgregarRecurso ventana){
        this.curso = curso;
        this.ventana = ventana;
        this.ventana.setListener(this);
        this.ventana.setVisible(true);
    }

    public void agregarRecurso(){
        String t1, t3;
        int t2;
        t1 = ventana.getjTextField1();
        t2 = Integer.parseInt(ventana.getjTextField2());
        t3 = ventana.getjTextField3();
        if (t3.isEmpty()){
            curso.agregarRecurso(t1, t2);
        }else curso.agregarRecurso(t1, t2, t3);
        ventana.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            agregarRecurso();
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