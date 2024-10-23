/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mateus-lyoshka
 */
public class ex05 implements Runnable {
    private static List<Integer> numeros = new ArrayList<>();
    
    @Override
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String input = "0";
        while(!input.equalsIgnoreCase("PARAR")){
            System.out.print("Informe um numero (ou qualquer letra para sair): ");
            input = scanner.nextLine();
            try{
                int numero = Integer.parseInt(input);
                numeros.add(numero);
            } catch(NumberFormatException e){
                System.out.println("Digito não numérico, encerrando...");
                break;
            }
        }
    }
   
    
    public static void main(String[] args) throws InterruptedException {
        Thread leitura = new Thread(new ex05());
        leitura.start();
        leitura.join();
        int soma = 0;
        for(int numero: numeros){
            soma += numero;
        }
        System.out.println("O resultado da soma é:"+soma);
    }
}
