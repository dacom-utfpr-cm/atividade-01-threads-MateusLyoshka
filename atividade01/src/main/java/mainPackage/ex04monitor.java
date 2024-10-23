/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.util.List;

/**
 *
 * @author mateus-lyoshka
 */
public class ex04monitor implements Runnable {

    public List<Thread> threads;
    
    public ex04monitor(List<Thread> threads) {
        this.threads = threads;
    }
    
    @Override
    public void run(){
        while(true){
            while(!threads.isEmpty()){
                threads.removeIf(t -> {
                    if(t.getState() == Thread.State.TERMINATED){
                    System.out.printf("A thread %s foi interrompida!", t.getName());
                    return true;
                   } 
                    return false;
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("A thread monitor foi interrompida!");
                }
            }
        }
    }
}
