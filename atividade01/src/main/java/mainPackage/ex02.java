/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author mateus-lyoshka
 */
public class ex02 implements Runnable{   
    
    @Override
    public void run(){
        Path path = Paths.get("/home/mateus-lyoshka/Documents/Prog/ProgamaçãoConcorrente/trabalho1/atividade-01-threads-MateusLyoshka/atividade01/quotes.txt");
        try(Stream<String> linhas = Files.lines(path)){
            linhas.forEach(linha -> {
                System.out.println("Linha: " + linha);
                try {
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                }
            });
            }catch(IOException ex){
        }     
    }
    
    public static void main(String[] args) {
        Thread nova = new Thread(new ex02());
        nova.start();
    }
}
