/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
/**
 *
 * @author Jade
 */
public class TestLista {
    
    public static void main(String[]args){
        
        Lista lista = new Lista();
        ArrayList<Lista> listas = lista.consultarListas(1);
        
        for (int i = 0; i < listas.size(); i++) {
            System.out.println(listas.get(i).getNombreLista());
        }
        
    }
    
}
