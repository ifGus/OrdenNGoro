/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import vistas.MatrizNGoro;

/**
 *
 * @author Portaticomps
 */
public class OrdenNGoro {

    int n;
    int filas; //= n;
    int columnas; //= n + 1;
    int[][] Matriz;
    public OrdenNGoro(){
        
    }
    public void ordenNGoro(int n) {//ordena 
        filas = n;
        columnas = n + 1;
        Matriz = new int[filas][columnas];
        int i = 0;
        int j = 0;
        for (int c = 1; c <= filas * columnas; c++) {
            
            System.out.println("C: "+c);
            System.out.println("i: "+i);
            System.out.println("j: "+j);
            Matriz[i][j] = c;
            i = c % filas;
            j = c % columnas;
        }
    }
    public int[][] devuelveMatriz(){
        return Matriz;
    } 
}    
    