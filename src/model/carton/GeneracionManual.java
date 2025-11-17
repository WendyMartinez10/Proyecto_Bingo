/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.carton;

/**
 *
 * @author user
 */
public class GeneracionManual implements GeneradorCarton{
    private int[][] numeros;

    public GeneracionManual(int[][] numeros) {
        this.numeros = numeros;
    }

    @Override
    public int[][] generar() {
        return numeros;
    }
}
