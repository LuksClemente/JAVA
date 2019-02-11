package primeiroprogramajava;

import java.util.Scanner;

public class PrimeiroProgramaJava {
    public static void main(String[] args) {
        float nota,pf,media;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite sua Média Final [0,0 - 10,0]: " );
        nota = entrada.nextFloat();
        if( (nota <= 10.0) && (nota >= 0.0) ){
            if( nota >= 7.0 ){
                System.out.println("APROVADO!");
            }
            else if (nota >= 4.0){
                System.out.println("Você terá que fazer PF!");
                System.out.print("Digite sua nota da PF [0,0-10,0]: ");
                pf = entrada.nextFloat();
                media = ((nota + pf)/2);
                if(media >= 5.0){
                    System.out.println("APROVADO!");
                }
                else{
                    System.out.println("REPROVADO!");
                }
            }
            if ( nota < 4.0){
                System.out.println("REPROVADO!");
            }
        }
        else {
            System.out.println("Nota inválida, fechando aplicativo");
        }
    }
}
