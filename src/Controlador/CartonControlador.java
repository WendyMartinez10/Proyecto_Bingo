/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import model.carton.Carton;
import patrones.factory.CartonFactory;

/**
 *
 * @author AsusVivobook
 */
public class CartonControlador {
       
 
    public Carton generarCartonAutomatico(String id) {
        return CartonFactory.crearCartonAutomatico(id);
    }


    public Carton generarCartonManual(String id, int[][] numeros) {
        return CartonFactory.crearCartonManual(id, numeros);
    }
}
