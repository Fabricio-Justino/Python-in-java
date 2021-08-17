package br.com.fabricio.main;

import java.util.ArrayList;
import java.util.List;

import br.com.fabricio.python.util.Python;

public class MainTest {

	public static void main(String[] args) {
		
		// escolha de atividade
		int choise = -1;
		boolean quit = false;
		do {
			ask();
			
			choise = Python.input(Python.str("o que voce deseja fazer: "), false).nextInt();
			switch(choise) {
			case 1 -> fatorial();
			case 2 -> fibonacci();
			case 3 -> average();
			
			case 0 -> {Python.print("tchua volte sempre"); quit = !quit;}
			
			default -> Python.printw("Opção inválida!", "=+"); 
			}
			
		} while (!quit); 
		
		
		
	}
	
	public static void fatorial() {
		//fatorial feito com as classes criadas
		int value = Python.input("digite um número para saber seu fatorial: ", false).nextInt();
		int result = 1;
		
		for(int i = 1; i <= value; i++) {
			result *= i;
		}
		
		Python.printf("O resultado do fatorial de {} é {}", value, result);
	}
	
	public static void fibonacci() {
		//fibonacci feito com as classes criadas
		int value = Python.input("digite um número para saber o fibonacci: ", false).nextInt();
		
		int current = 1, before = 0;
		
		for(int i = 1; i < value; i++) {
			if(value <= 2) {
				break;
			} 
			current += before;
			before = current - before;
		}		
		Python.printf("o fibonacci de {} é {}", value, current);
	}
	
	public static void average() {
		
		double value = -2;
		boolean quit = false;
		List<Double> numbers = new ArrayList<>();
		
		do {
			value = Python.input("informe um valor: ", false).nextDouble();
			numbers.add(value);
			quit = Python.inputs("deseja sair? [sim/não]").trim().equals("sim");
			
		} while (!quit);
		
		value = numbers.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
		Python.printf("a média dos valores {} é {}", numbers, value);
	}
	
	public static void ask() {
		int cont = 0;
		String options = "sair fatorial fibonacci média";
		
		for(String option : options.split("[ ]")) {
			Python.printf("[{}] - {}", cont, option);
			cont++;
		}
	}
	
}
