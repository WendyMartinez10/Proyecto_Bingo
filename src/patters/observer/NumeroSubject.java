/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package patters.observer;

/**
 *
 * @author Gipsy
 */
public interface NumeroSubject {

    void agregarObserver(NumeroObserver observer);

    void removerObserver(NumeroObserver observer);

    void notificar(int numero);
}
