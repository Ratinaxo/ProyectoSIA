package Model;

import Views.VentanaInicial;
import Controllers.ControladorInicial;

public class ProyectoSIA {
    public static void main(String[] args){
        Colegio colegio = new Colegio();
        VentanaInicial ventana = new VentanaInicial();
        ControladorInicial controlador = new ControladorInicial(colegio, ventana);
        //ControladorMostrarCursos controlador = new ControladorMostrarCursos(colegio.getCursos(), ventana);
    }
}
