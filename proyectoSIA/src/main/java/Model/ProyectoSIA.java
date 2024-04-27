package Model;

import Views.VentanaInicial;
import Controllers.ControladorInicial;

public class ProyectoSIA {
    public static void main(String[] args){
        Colegio colegio = new Colegio();
        VentanaInicial ventana = new VentanaInicial();
        ControladorInicial controlador = new ControladorInicial(colegio, ventana);
        controlador.switchVentana();
        
    }
}
