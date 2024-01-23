package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Products;

public class Program {
	
	static List<Products> listProducts = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		int choice = 0;
		while (choice == 0) {
			menu();
			choice = sc.nextInt();
			if (choice == 1) {
				imprimirLista();
				choice = 0;
			}

			if (choice == 2) {
				add();
				choice = 0;
			}

			if (choice == 3) {
				remove();
				choice = 0;
			}

			if (choice == 4) {
				limpar();
				choice = 0;
			}
			
			if(choice == 5) {
				valorTotal();
				choice = 0;
			}
		}
	}

	public static void menu() {
		System.out.println();
		System.out.println("O que você deseja fazer? ");
		System.out.println("1 - Imprirmir estoque");
		System.out.println("2 - Adicionar produto ao estoque");
		System.out.println("3 - Remover produto do estoque");
		System.out.println("4 - Limpar lista");
		System.out.println("5 - Valor Total do Estoque");
	}

	public static void imprimirLista() {
		for (Products p : listProducts) {
			System.out.println(p);
		}
		if (listProducts.isEmpty() == true) {
			System.out.println("A lista está vazia");
		}
	
	}

	public static void add() {
		System.out.println("Quantos produtos você deseja acrescentar ao estoque? ");
		int quantityProducts = sc.nextInt();
		for (int i = 0; i < quantityProducts; i++) {
			System.out.println("Dados do Produto #" + (i + 1) + ": ");
			System.out.print("Digite o nome do produto: ");
			String name = sc.next();
			System.out.print("Digite o valor do produto: ");
			double value = sc.nextDouble();
			System.out.print("Digite a quantidade de produtos: ");
			int quantity = sc.nextInt();
			Products product = new Products(name, value, quantity);
			listProducts.add(product);

		}
	}

	public static void remove() {
		System.out.println("Qual produto você deseja remover do estoque?");
		String name = sc.next();
		Products product = listProducts.stream().filter(x -> x.getName().equals(name) == true).findFirst().orElse(null);
		if (product == null) {
			System.out.println("Este produto não existe");
		} else {
			System.out.println("Qual a quantidade que você deseja remover?");
			int quantity = sc.nextInt();
			product.removeProducts(quantity);
		}
	}

	public static void limpar() {
		String choice1 = "";
	
		System.out.println("Você tem certeza que deseja limpar a lista? (Y/N)");
		choice1 = sc.next();
		if (choice1.charAt(0) == 'y') {
			listProducts = new ArrayList<>();
		}
	}
	
	public static void valorTotal() {
		double valorTotal = 0;
		for(int i = 0; i < listProducts.size(); i ++) {
			valorTotal += listProducts.get(i).totalValue();
		}
		System.out.println("Temos em estoque o valor de: R$" + valorTotal);
	}
}
