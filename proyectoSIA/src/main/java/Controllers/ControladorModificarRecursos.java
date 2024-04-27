package Controllers;
import java.awt.event.*;

import Model.Curso;
import Views.VentanaModificarRecursos;

public class ControladorModificarRecursos implements ActionListener{
    Curso curso;
    VentanaModificarRecursos ventana;
    
    public ControladorModificarRecursos(Curso curso, VentanaModificarRecursos ventana){
        this.curso = curso;
        this.ventana = ventana;
        this.ventana.setVisible(true);
    }
    
    public void mostrarRecursos() {}
    
    public void agregarRecursos() {}
    
    public void editarRecursos() {}
    
    public void eliminarRecursos() {}
    
    @Override
    public void actionPerformed(ActionEvent e){}
}
