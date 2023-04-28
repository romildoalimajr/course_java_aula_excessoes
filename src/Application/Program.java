package Application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta:");
		System.out.print("Numero.: ");
		int number = sc.nextInt();
		System.out.print("Titular.: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		
		acc.withDraw(amount);
		
		if(amount > acc.getWithDrawLimit()) {
			System.out.println("Erro de saque: A quantia excede o limite de saque");
		}else if(amount > acc.getBalance()) {
			System.out.println("Erro de saque: Saldo Insuficiente");
		}else {
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		}
		
		sc.close();

	}

}
