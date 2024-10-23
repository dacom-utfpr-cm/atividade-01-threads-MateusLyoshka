/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateus-lyoshka
 */
public class ex04 implements Runnable {
    
    @Override
    public void run(){
        int cont = 0;
        while(cont < 100){
                cont++;
                System.out.println("Contando "+cont);
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                System.out.println("Thread interrompida!");
                break;
            }   
        }
    }
    
    private static final List<Thread> listaThreads = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Thread contador1 = new Thread(new ex04());
        Thread contador2 = new Thread(new ex04());
        Thread contador3 = new Thread(new ex04());
        listaThreads.add(contador1);
        listaThreads.add(contador2);
        listaThreads.add(contador3);
        contador1.start();
        contador2.start();
        contador3.start();
        
        Thread monitor = new Thread(new ex04monitor(listaThreads));
        monitor.start();
        
        Thread interruptor = new Thread(()->{
            listaThreads.forEach(t -> new Thread(() -> {
                try {
                    Thread.sleep(((int) ((Math.random()*20)+1))*1000);
                    t.interrupt();
                } catch (InterruptedException e) {
                    System.out.println("Thread interruptor foi interrompida!");
                }
            }).start());
        });
        interruptor.start();
    }
}
