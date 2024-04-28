package Controllers;

import Model.Colegio;
import Model.Curso;

import Views.VentanaBuscarCurso;
import Views.VentanaMostrarCursos;
import Views.VentanaAdministrar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class ControladorAdministrar implements MouseListener{
    private Colegio colegio;
    private ArrayList<Curso> cursos;
    private VentanaAdministrar ventana;
    private ControladorInicial controladorIni;
    
    public ControladorAdministrar (Colegio colegio, VentanaAdministrar ventana, ControladorInicial controladorIni){
        this.colegio = colegio;
        this.cursos = this.colegio.getCursos();
        this.ventana = ventana;
        this.ventana.setListener(this);
        this.controladorIni = controladorIni;
        this.ventana.setVisible(true);
    }
    
    
    public void performAction(MouseEvent e){
        
    }
    public void mostrarCursos(){
        VentanaMostrarCursos vv = new VentanaMostrarCursos();
        String[] nomCursos = new String[cursos.size()];
        for (int i = 0; i < cursos.size(); i++){
            nomCursos[i] = cursos.get(i).getCurso();
        }
        vv.updateList(nomCursos);
        vv.setVisible(true);   
    }
    
    public void modificarRecursos(){//POSIBLE TRY-CATH
        VentanaBuscarCurso vv = new VentanaBuscarCurso();
        ControladorBuscarCurso cc = new ControladorBuscarCurso(colegio, vv);
        
    }
    
    
    
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            mostrarCursos();
            
        }else if (me.getSource() == ventana.getjButton2()){
            modificarRecursos();
            
        }else if (me.getSource() == ventana.getjButton3()){
            
        }else if (me.getSource() == ventana.getjButton4()){
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
