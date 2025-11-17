package test;

import controller.CartonControlador;
import view.PanelCarton;
import model.carton.Carton;

import javax.swing.JFrame;

public class TestPanelCarton {

    public static void main(String[] args) {

        // Ventana
        JFrame ventana = new JFrame("Cartón Manual");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);

        PanelCarton panel = new PanelCarton();
        ventana.add(panel);

        CartonControlador controller = new CartonControlador();

        // Números definidos manualmente
        int[][] numeros = {
            {1, 16, 31, 46, 61},
            {2, 17, 32, 47, 62},
            {3, 18, 0, 48, 63},  // 0 = casilla libre
            {4, 19, 34, 49, 64},
            {5, 20, 35, 50, 65}
        };

        // Crear cartón manual a través de la Factory
        Carton cartonManual = controller.generarCartonManual("MANUAL1", numeros);

        // Mostrar cartón en el panel
        panel.mostrarCarton(cartonManual);

        ventana.setVisible(true);
    }
}
