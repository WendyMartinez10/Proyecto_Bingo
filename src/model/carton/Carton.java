/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.carton;

import patters.observer.NumeroObserver;
import view.PanelCarton;

/**
 *
 * @author user
 */
public class Carton implements NumeroObserver {
  private String id;
    private int[][] numeros = new int[5][5];
    private boolean[][] marcados = new boolean[5][5];
     private PanelCarton panel;
    

public Carton(String id, int[][] numeros) {
    this.id = id;
    this.numeros = numeros;
    inicializarMarcados();
}

    private void inicializarMarcados() {
        marcados[2][2] = true;
    }

    
    public String getId() {
        return id;
    }

    public int[][] getNumeros() {
        return numeros;
    }

    public boolean[][] getMarcados() {
        return marcados;
    }

    public void setNumeros(int[][] matriz) {
        this.numeros = matriz;
    }
    
    public void setMarcados(boolean[][] marcados) {
    this.marcados = marcados;
}

    public PanelCarton getPanel() {
        return panel;
    }

    public void setPanel(PanelCarton panel) {
        this.panel = panel;
    }
    
    


public void marcar(int numero) {

    boolean encontrado = false;

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {

            if (numeros[i][j] == numero) {
                marcados[i][j] = true;  
                encontrado = true;
            }
        }
    }

   
    if (panel != null && encontrado) {
        panel.marcarNumero(numero, this);
    }
}



public void reiniciar() {
    if (panel != null) {
        panel.limpiar();
    }
}



    public void desmarcar(int numero) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numeros[i][j] == numero) {
                    marcados[i][j] = false;
                    return;
                }
            }
        }
    }


    public boolean cuatroEsquinas() {
        return marcados[0][0] && marcados[0][4]
                && marcados[4][0] && marcados[4][4];
    }

    public boolean filaCompleta(int fila) {
        for (int j = 0; j < 5; j++) {
            if (!marcados[fila][j]) {
                return false;
            }
        }
        return true;
    }

    public boolean columnaCompleta(int col) {
        for (int i = 0; i < 5; i++) {
            if (!marcados[i][col]) {
                return false;
            }
        }
        return true;
    }

    public boolean diagonalPrincipal() {
        for (int i = 0; i < 5; i++) {
            if (!marcados[i][i]) {
                return false;
            }
        }
        return true;
    }

    public boolean diagonalSecundaria() {
        for (int i = 0; i < 5; i++) {
            if (!marcados[i][4 - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean cartonLleno() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (i == 2 && j == 2) continue;

                if (!marcados[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

   
    public boolean esGanadorNormal() {

        for (int i = 0; i < 5; i++)
            if (filaCompleta(i)) return true;

        for (int j = 0; j < 5; j++)
            if (columnaCompleta(j)) return true;

        if (diagonalPrincipal()) return true;
        if (diagonalSecundaria()) return true;

        if (cuatroEsquinas()) return true;

        return false;
    }

    @Override
    public void actualizarNumero(int numeroSalido) {
        marcar(numeroSalido);
       
    }
    
    
    public String getTipoVictoria() {

    for (int i = 0; i < 5; i++) {
        if (filaCompleta(i)) return "Fila completa (" + (i + 1) + ")";
    }

    for (int j = 0; j < 5; j++) {
        if (columnaCompleta(j)) return "Columna completa (" + (j + 1) + ")";
    }

    if (diagonalPrincipal()) return "Diagonal Principal";

    if (diagonalSecundaria()) return "Diagonal Secundaria";

    if (cuatroEsquinas()) return "Cuatro Esquinas";

    if (cartonLleno()) return "Cartón Lleno";

    return "Ninguna";
}

}
