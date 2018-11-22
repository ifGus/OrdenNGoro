/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.DimensionesPantalla;


/**
 *
 * @author Portaticomps
 */
public class MatrizNGoro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DimensionesPantalla dimPan = new DimensionesPantalla();
        VentanaInicio inicio=new VentanaInicio();
        inicio.setSize(dimPan.horizontal(), dimPan.vertical());
        inicio.setVisible(true);
    }
   
}
