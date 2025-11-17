/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import model.juego.Tombola;
import view.PanelTombola;

/**
 *
 * @author AsusVivobook
 */
public class TombolaControlador {
    
    private Tombola tombola;
    private PanelTombola panel;

    public TombolaControlador(Tombola tombola, PanelTombola panel) {
        this.tombola = tombola;
        this.panel = panel;
    }

    public void sacarNumero() {
        int n = tombola.sacarNumero();
        panel.mostrarNumero(String.valueOf(n));
    }

    public void reiniciar() {
        tombola.reiniciar();
        panel.mostrarNumero("-");
    }
}
