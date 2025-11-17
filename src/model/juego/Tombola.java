/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.juego;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import patters.observer.NumeroObserver;
import patters.observer.NumeroSubject;

/**
 *
 * @author user
 */
public class Tombola implements NumeroSubject{
    
    private List<NumeroObserver> observers = new ArrayList<>();
    private boolean[] numerosSalidos = new boolean[76];
    private Random random = new Random();


    @Override
    public void agregarObserver(NumeroObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(NumeroObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificar(int numero) {
        for (NumeroObserver o : observers) {
            o.actualizarNumero(numero);
        }
    }

   
 public int sacarNumero() {
    int numero;

    do {
        numero = random.nextInt(75) + 1; 
    } while (numerosSalidos[numero]);

    numerosSalidos[numero] = true;

    System.out.println("Número salido: " + numero);

   
    notificar(numero);

 
    return numero;
}
 
 
   public void agregarNumero(int numero) {
        if (numero < 1 || numero > 75) {
            throw new IllegalArgumentException("Número fuera de rango: " + numero);
        }
        if (numerosSalidos[numero]) {
            throw new IllegalStateException("El número ya salió: " + numero);
        }

        numerosSalidos[numero] = true;
        System.out.println("Número manual ingresado: " + numero);

        notificar(numero);
    }


    public boolean yaSalio(int num) {
        return numerosSalidos[num];
    }

    public void reiniciar() {
        for (int i = 1; i <= 75; i++) {
            numerosSalidos[i] = false;
        }
        System.out.println("Tómbola reiniciada.");
    }
}
