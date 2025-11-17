/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patters.factory;

import model.carton.Carton;
import model.carton.GeneracionAutomatica;
import model.carton.GeneracionManual;
import model.carton.GeneradorCarton;
/**
 *
 * @author Gipsy
 */
public class CartonFactory {
    
   
    public static Carton crearCartonAutomatico(String id) {
        GeneradorCarton generador = new GeneracionAutomatica();
        int[][] numeros = generador.generar();
        return new Carton(id, numeros);
    }

    
    public static Carton crearCartonManual(String id, int[][] numeros) {
        GeneradorCarton generador = new GeneracionManual(numeros);
        int[][] matriz = generador.generar();
        return new Carton(id, matriz);
    }
}
