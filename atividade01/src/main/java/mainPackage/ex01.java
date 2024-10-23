/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mainPackage;

import java.util.Random;

/**
 *
 * @author mateus-lyoshka
 */
public class ex01 implements Runnable {
    private int id;
    
    public ex01(int id){
        this.id = id;
    }
    
    @Override
    public void run(){
        Random random = new Random();
        int x = random.nextInt(10)+1;
        System.out.println("Thread:"+id+"Tempo de sleep:"+x);
        try{
           Thread.sleep(x*1000);
        }
        catch(InterruptedException ex){
            System.out.println("Sleep da thread"+id+" interrompido!");
            return;
        }
        System.out.println("Termino da thread:"+id);
    }
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ex01(1));
        Thread thread2 = new Thread(new ex01(2));
        Thread thread3 = new Thread(new ex01(3));
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        Thread Interrupção = new Thread(()->{
            try{
                Thread.sleep(1000);
                thread1.interrupt();
                System.out.println("Interrompendo thread1");
            }catch(InterruptedException ex){
                System.out.println("Thread de interrupção interrompida!" + ex.getMessage());
            }
        });
        Interrupção.start();
        
    }
}
