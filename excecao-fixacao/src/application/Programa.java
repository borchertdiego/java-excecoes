package application;

import java.util.Scanner;

import model.entities.Conta;
import model.exception.SaqueException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Número da conta: ");
		Integer numeroConta = sc.nextInt();
		
		System.out.print("Usuário: ");
		String usuario = sc.next();
		
		System.out.print("Balanço inicial: ");
		Double balancoInicial = sc.nextDouble();
		
		System.out.print("Limite de saque: ");
		Double limiteSaque = sc.nextDouble();

		System.out.print("\nEntre com a quantidade para o saque: ");
		Double quantidadeSaque = sc.nextDouble();
		
		Conta conta = new Conta(numeroConta, usuario, balancoInicial, limiteSaque);
		
		try { 
			conta.saque(quantidadeSaque);
			
			System.out.println("Novo saldo: " + conta.getValorTotal());
		} catch (SaqueException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		
		sc.close();
	}

}
