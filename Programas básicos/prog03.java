package accounttest;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Account myAccount = new Account();
        
        System.out.printf("O nome inicial é: %s\n",myAccount.getName());
        
        System.out.print("Digite o nome: ");
        String theName = input.next();
        myAccount.setName(theName);
        System.out.println();
        
        System.out.printf("Nome no objeto myAccount é: %s\n",myAccount.getName());
    }
}
