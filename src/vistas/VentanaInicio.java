/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.DimensionesPantalla;
import controladores.OrdenNGoro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Portaticomps
 */
public class VentanaInicio extends JFrame implements ActionListener{
    private JLabel labelTitulo, labelCombo;
    private JComboBox valorMatriz;
    private JButton inicio,atras,salir;
    private JPanel panelMatriz, panelFondo;
    private JTextField fieldNumeros [][];
    private int n;
    private OrdenNGoro ng;
    private DimensionesPantalla dimPan;
    
    private JTable tabla;
    
    public VentanaInicio() {
        int filas, columnas;
        
        this.setTitle("Ruddy Cayo Huaylla");
        this.setExtendedState(MAXIMIZED_BOTH);
        dimPan = new DimensionesPantalla();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        labelTitulo = new JLabel("MATRIZ N-GORO");
        labelTitulo.setBounds(0,dimPan.PenY(0), dimPan.PenX(100), dimPan.PenY(15));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setForeground(Color.blue);
        labelTitulo.setFont(new Font("Agency FB", 1, dimPan.tamanioLetra(100)));
        this.add(labelTitulo);
        
        valorMatriz =new JComboBox();
        valorMatriz.setBounds(dimPan.PenX(70), dimPan.PenY(50), dimPan.PenX(10), dimPan.PenY(5));
        valorMatriz.setBackground(null);
        valorMatriz.setForeground(Color.BLACK);
        valorMatriz.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(25)));
        valorMatriz.addActionListener(this);
        this.add(valorMatriz);
      
        labelCombo =new JLabel("Valor Matriz:");
        labelCombo.setBounds(dimPan.PenX(55), dimPan.PenY(50), dimPan.PenX(30), dimPan.PenY(5));
        labelCombo.setForeground(Color.DARK_GRAY);
        labelCombo.setFont(new Font("arial", 1, dimPan.tamanioLetra(30)));
        this.add(labelCombo);
      
        valorMatriz.addItem("2 X 3");
        valorMatriz.addItem("3 X 4");
        valorMatriz.addItem("4 X 5");
        valorMatriz.addItem("5 X 6");
        valorMatriz.addItem("6 X 7");
      
        inicio = new JButton("INICIO");
        inicio.setLocation(dimPan.PenX(45), dimPan.PenY(70));
        inicio.setSize(dimPan.PenX(15), dimPan.PenY(10));
        inicio.addActionListener(this);
        inicio.setBackground(null);
        inicio.setForeground(Color.blue);
        inicio.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(40)));
        this.add(inicio);
    
        
                 
        atras = new JButton("ATRAS");
        atras.setLocation(dimPan.PenX(77), dimPan.PenY(86));
        atras.setSize(dimPan.PenX(10), dimPan.PenY(5));
        atras.addActionListener(this);
        atras.setBackground(null);
        atras.setForeground(Color.blue);
        atras.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(15)));
        atras.setVisible(false);
        this.add(atras);
        
        salir = new JButton("SALIR");
        salir.setLocation(dimPan.PenX(5), dimPan.PenY(70));
        salir.setSize(dimPan.PenX(15), dimPan.PenY(10));
        salir.addActionListener(this);
        salir.setBackground(null);
        salir.setForeground(Color.blue);
        salir.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(40)));
        this.add(salir);
        
    }
    
    public void dibujarMatriz(){
    
        panelMatriz = new JPanel();
        panelMatriz.setLayout(null);
        panelMatriz.setBounds(dimPan.PenX(10), dimPan.PenY(15), dimPan.PenX(80), dimPan.PenY(70));
        panelMatriz.setBackground(Color.BLACK);
        panelMatriz.setVisible(false);
        this.add(panelMatriz);
        
        panelFondo = new JPanel();
        panelFondo.setLayout(new GridLayout(n, (n+1), dimPan.PenX(1.5F), dimPan.PenY(2F)));
        panelFondo.setBounds(dimPan.PenX(1.5F), dimPan.PenY(2), dimPan.PenX(77), dimPan.PenY(66));
        panelFondo.setBackground(Color.BLACK);
        panelFondo.setVisible(true);
        panelMatriz.add(panelFondo);
        
        
        ng = new OrdenNGoro();
        //int matriz [] []= new int[n][n+1];
        ng.ordenNGoro(n);
        
        //fieldNumeros = new JTextField[n][n+1];
        System.out.println(n);
        JTextField fieldElemento;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n+1;j++){
            	fieldElemento = new JTextField();
            	fieldElemento.setHorizontalAlignment(SwingConstants.CENTER);
                fieldElemento.setFont(new Font("Arial", 1, dimPan.tamanioLetra(40)));
            	fieldElemento.setText(ng.devuelveMatriz()[i][j]+"");
            	fieldElemento.setEditable(false);
            	panelFondo.add(fieldElemento);
            }
        }
    }
    
	public void seccionar(){
		 if(valorMatriz.getSelectedItem().toString().equals("2 X 3")){
	         n=2;
	    }else{
	       if(valorMatriz.getSelectedItem().toString().equals("3 X 4")){
	         n=3;
	        }else
	            if(valorMatriz.getSelectedItem().toString().equals("4 X 5")){
	            n=4;                }
	            else
	                if(valorMatriz.getSelectedItem().toString().equals("5 X 6")){
	                n=5;
	                }
	                else
	                    if(valorMatriz.getSelectedItem().toString().equals("6 X 7")){
	                    n=6;
	                    }
	    }
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == atras) {
            panelMatriz.setVisible(false);
            valorMatriz.setVisible(true);
            inicio.setVisible(true);
            labelCombo.setVisible(true);
            atras.setVisible(false);
            salir.setVisible(true);
        } else if(e.getSource()==inicio){
            dibujarMatriz();
            panelMatriz.setVisible(true);
            
            valorMatriz.setVisible(false);
        inicio.setVisible(false);
        salir.setVisible(false);
        labelCombo.setVisible(false);
        atras.setVisible(true);
        }else if (e.getSource() == salir) {
            System.exit(0);
        } else if(e.getSource()==valorMatriz){
        	seccionar();
        }
    }
}
