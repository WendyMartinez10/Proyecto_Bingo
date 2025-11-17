/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import model.carton.Carton;
import model.juego.Juego;
import model.juego.TableroNumeros;
import model.juego.Tombola;
import model.juego.TipoJuego;
import view.PanelResultados;
import view.PanelTablero;
import view.PanelTombola;

/**
 *
 * @author AsusVivobook
 */
public class JuegoControlador {

    private Juego juego;


    private PanelTablero panelTablero;
    private PanelTombola panelTombola;
    private PanelResultados panelResultados;

    public JuegoControlador(PanelTablero panelTablero,
            PanelTombola panelTombola,
            PanelResultados panelResultados) {

        this.panelTablero = panelTablero;
        this.panelTombola = panelTombola;
        this.panelResultados = panelResultados;
    }

   
    public void iniciarJuego(TipoJuego tipo, List<Carton> cartones) {
        juego = new Juego(tipo);

       
        for (Carton c : cartones) {
            juego.agregarCarton(c);
        }

        panelTablero.actualizarTablero(juego.getTablero());
        panelResultados.limpiar();
        panelTombola.mostrarNumero("-");
    }

   
    public void sacarNumero() {
        if (juego == null) {
            return;
        }

        juego.verificarGanadores();

        juego.sacarNumero();

        panelTombola.mostrarNumero(String.valueOf(juego.getUltimoNumero()));
        panelTablero.actualizarTablero(juego.getTablero());

        if (juego.hayGanador()) {
            panelResultados.mostrarGanador(juego.getCartonGanador());
        }

        if (juego.hayGanador()) {
            return;
        }
    }

    public void agregarNumero(int numero) {
        if (juego == null) {
            return;
        }

        juego.verificarGanadores();
        if (juego.hayGanador()) {
            return;
        }

        juego.marcarNumeroManual(numero);

        panelTombola.mostrarNumero(String.valueOf(juego.getUltimoNumero()));
        panelTablero.actualizarTablero(juego.getTablero());

        if (juego.hayGanador()) {
            panelResultados.mostrarGanador(juego.getCartonGanador());
        }
    }

    
    public void reiniciar() {
        if (juego == null) {
            return;
        }

        juego.reiniciar();
        panelTablero.actualizarTablero(juego.getTablero());
        panelTombola.mostrarNumero("-");
        panelResultados.limpiar();
    }

    
    public Juego getJuego() {
        return juego;
    }

    public Tombola getTombola() {
        return juego.getTombola();
    }

    public TableroNumeros getTablero() {
        return juego.getTablero();
    }

    public void agregarCarton(Carton c) {
        juego.agregarCarton(c);
    }

}
