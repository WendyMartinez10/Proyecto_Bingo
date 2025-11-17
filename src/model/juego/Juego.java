/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.juego;

import java.util.ArrayList;
import java.util.List;

import model.carton.Carton;
import patrones.observer.NumeroObserver;

/**
 *
 * @author user
 */
public class Juego implements NumeroObserver {

    private Tombola tombola;
    private TableroNumeros tablero;
    private List<Carton> cartones;
    private TipoJuego tipoJuego;

    private boolean hayGanador = false;
    private Carton cartonGanador = null;
    private int ultimoNumero = -1;

    public Juego(TipoJuego tipoJuego) {
        this.tipoJuego = tipoJuego;
        this.tombola = new Tombola();
        this.tablero = new TableroNumeros();
        this.cartones = new ArrayList<>();

     
        tombola.agregarObserver(this);
    }

    // ================================
    //     CONFIGURAR PARTIDA
    // ================================
    public void agregarCarton(Carton carton) {
        cartones.add(carton);
        tombola.agregarObserver(carton); 
    }

    public List<Carton> getCartones() {
        return cartones;
    }

    public TableroNumeros getTablero() {
        return tablero;
    }

    public Tombola getTombola() {
        return tombola;
    }

    public boolean hayGanador() {
        return hayGanador;
    }

    public Carton getCartonGanador() {
        return cartonGanador;
    }

    public int getUltimoNumero() {
        return ultimoNumero;
    }

    // ================================
    //        FLUJO DEL JUEGO
    // ================================
    
    public void sacarNumero() {
        if (hayGanador) {
           
            return;
        }
        tombola.sacarNumero();
    }
    
    
public void marcarNumeroManual(int numero) {
    if (hayGanador) return;

    
    if (!tombola.yaSalio(numero)) {
        tombola.agregarNumero(numero); 
        tablero.marcar(numero);       
        ultimoNumero = numero;
        verificarGanadores();
    } else {
        javax.swing.JOptionPane.showMessageDialog(
            null,
            "El número " + numero + " ya fue ingresado.",
            "Número repetido",
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
    }
}


    
    @Override
    public void actualizarNumero(int numero) {
        ultimoNumero = numero;
        tablero.marcar(numero);

        verificarGanadores();
    }

    // ================================
    //         VERIFICAR GANADOR
    // ================================
    public void verificarGanadores() {
        for (Carton c : cartones) {

            boolean ganador = false;

            switch (tipoJuego) {
                case NORMAL:
                    ganador = c.esGanadorNormal();
                    break;
                case CUATRO_ESQUINAS:
                    ganador = c.cuatroEsquinas();
                    break;
                case CARTON_LLENO:
                    ganador = c.cartonLleno();
                    break;
                case DIAGONAL_PRINCIPAL:
                    ganador = c.diagonalPrincipal();
                    break;
                case DIAGONAL_SECUNDARIA:
                    ganador = c.diagonalSecundaria();
                    break;
            }

            if (ganador) {
                hayGanador = true;
                cartonGanador = c;

             
                String motivo = c.getTipoVictoria();

                javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "TENEMOS UN GANADOR!\n"
                        + "Cartón: " + c.getId() + "\n"
                        + "Victoria: " + motivo + "\n"
                        + "Número ganador: " + ultimoNumero,
                        "Ganador",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }
        }
    }

    // ================================
    //         REINICIAR JUEGO
    // ================================
    public void reiniciar() {
        hayGanador = false;
        cartonGanador = null;
        ultimoNumero = -1;

        tombola.reiniciar();
        tablero.reiniciar();

     
        for (Carton c : cartones) {
            boolean[][] marcados = c.getMarcados();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    marcados[i][j] = false;
                }
            }
            c.reiniciar();
            marcados[2][2] = true; 
        }
    }
}
