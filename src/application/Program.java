package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Products> listProducts = new ArrayList<>();
		int choice = 0;
		while (choice == 0) {
			menu();
			choice = sc.nextInt();
			if (choice == 1) {
				for (Products p : listProducts) {
					System.out.println(p);
				}
				choice = 0;
			}
			if (choice == 2) {
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
				choice = 0;
			}
			if (choice == 3) {
				System.out.println("Qual produto você deseja remover do estoque?");
				String name = sc.next();
				Products product = listProducts.stream().filter(x -> x.getName() == name).findFirst().orElse(null);
				if(product == null) {
					System.out.println("Este produto não existe");
				}else {
					System.out.println("Qual a quantidade que você deseja remover?");
					int quantity = sc.nextInt();
					product.removeProducts(quantity);
				}
				choice = 0;
			}
			if (choice == 4) {
				String choice1 = "";
				System.out.println("Você tem certeza que deseja limpar a lista? (Y/N)");
				choice1 = sc.next();
				if (choice1.charAt(0) == 'Y') {
					listProducts.removeAll(listProducts);
				}
				choice = 0;
			}
			sc.close();
		}
		}
		
	

	public static void menu() {
		System.out.println("O que você deseja fazer? ");
		System.out.println("1 - Imprirmir estoque");
		System.out.println("2 - Adicionar produto ao estoque");
		System.out.println("3 - Remover produto do estoque");
		System.out.println("4 - Limpar lista");
	}
	
}
