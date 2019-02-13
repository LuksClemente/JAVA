package programatestejava;

import java.util.Scanner;

public class ProgramaTesteJava {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int a,b,maior,menor;
        
        System.out.print("Digite um numero: ");
        a = entrada.nextInt();
        System.out.print("Digite outro numero: ");
        b = entrada.nextInt();
        
        if(a>b){
            maior = a;
            menor = b;
        }
        else{
            maior = b;
            menor = a;
        }
        if(maior != menor){
            while(menor+1 < maior){
                System.out.printf("%d ",menor+1);
                menor++;
            }
            System.out.print("\n");
        }
        else{
            System.out.println("Números iguais!");
        }
    }
}
