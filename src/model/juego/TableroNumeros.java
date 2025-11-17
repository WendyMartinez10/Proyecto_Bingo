/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.juego;

/**
 *
 * @author user
 */
public class TableroNumeros {

    private boolean[] marcados = new boolean[75];

    public void marcar(int n) {
        if (n < 1 || n > 75) {
            return;
        }
        marcados[n - 1] = true;
    }

    public boolean estaMarcado(int n) {
        if (n < 1 || n > 75) {
            return false;
        }
        return marcados[n - 1];
    }

    public boolean[] getNumerosSalidos() {
        return marcados;
    }

    public void reiniciar() {
        for (int i = 0; i < 75; i++) {
            marcados[i] = false;
        }
        System.out.println("Tablero reiniciado.");
    }

}
