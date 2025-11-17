/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.carton;


import java.util.Random;

/**
 *
 * @author user
 */
public class GeneracionAutomatica implements GeneradorCarton {
    
    private Random random = new Random();

    @Override
    public int[][] generar() {

        int[][] matriz = new int[5][5];

      
        int[] min = {1, 16, 31, 46, 61};
        int[] max = {15, 30, 45, 60, 75};

        for (int col = 0; col < 5; col++) {
            boolean[] usados = new boolean[76];

            for (int fila = 0; fila < 5; fila++) {

                if (fila == 2 && col == 2) {
                    matriz[fila][col] = 0; 
                    continue;
                }

                int num;
                do {
                    num = random.nextInt(max[col] - min[col] + 1) + min[col];
                } while (usados[num]);

                usados[num] = true;
                matriz[fila][col] = num;
            }
        }

        return matriz;
    }
}
