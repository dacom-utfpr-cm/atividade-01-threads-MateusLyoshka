/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author mateus-lyoshka
 */
public class ex02 implements Runnable{   
    
    @Override
    public void run(){
        Path path = Paths.get("/home/mateus-lyoshka/Documents/Prog/ProgamaçãoConcorrente/trabalho1/atividade-01-threads-MateusLyoshka/atividade01/quotes.txt");
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String linha;
            while((linha = reader.readLine())!=null){
                System.out.println("Linha:"+linha);
                try {
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    reader.close();
                    System.out.println("A thread foi interrompida e o arquivo fechado!");
                    break;
                }
            }
            }catch(IOException ex){
                System.out.println("Erro ao ler arquivo: " + ex.getMessage());
        }     
    }
    
    public static void main(String[] args) {
        Thread nova = new Thread(new ex02());
        nova.start();
        
        Thread interrupter = new Thread(()->{
            try{
                Thread.sleep(20*1000);
                System.out.println("Interropendo a Thread 1");
                nova.interrupt();
            }catch(InterruptedException ex){
                System.out.println("Thread de interrupão interrompida");
                }
            }
        );
        
        interrupter.start();
    }
}
