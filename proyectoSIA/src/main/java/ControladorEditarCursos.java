import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class ControladorEditarCursos implements MouseListener{
    private ArrayList<Curso> cursos;
    private VentanaEditarCursos ventana;
    private ControladorInicial controladorIni;
    
    public ControladorEditarCursos (ArrayList cursos, VentanaEditarCursos ventana, ControladorInicial controladorIni){
        this.cursos = cursos;
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
    public void modificarCursos(){
        
    }
    public void eliminarCursos(){
        
    }
    
    
    @Override
    public void mouseClicked (MouseEvent me) {
        if (me.getSource() == ventana.getjButton1()){
            mostrarCursos();
            
            controladorIni.showVentana();
        }else if (me.getSource() == ventana.getjButton2()){
            ventana.setVisible(false);
            controladorIni.showVentana();
        }else if (me.getSource() == ventana.getjButton3()){
            ventana.setVisible(false);
            controladorIni.showVentana();
        }else if (me.getSource() == ventana.getjButton4()){
            ventana.setVisible(false);
            controladorIni.showVentana();
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
