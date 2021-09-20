package br.com.fabricio.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.fabricio.python.util.Python;

public class MainTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		doWork();
	}

	public static void doWork() {
		// escolha de atividade
		int choise = -1;
		boolean quit = false;
		do {
			ask();

			choise = Python.input(Python.str("o que voce deseja fazer: "), false).nextInt();
			switch (choise) {
			case 1 -> fatorial();
			case 2 -> fibonacci();
			case 3 -> average();
			case 4 -> readText();

			case 0 -> {
				Python.print("tchua volte sempre");
				quit = !quit;
			}

			default -> Python.printw("Opção inválida!", "=+", true);
			}

		} while (!quit);
	}

	public static void fatorial() {
		// fatorial feito com as classes criadas
		int value = Python.input("digite um número para saber seu fatorial: ", false).nextInt();
		int result = 1;

		for (int i = 1; i <= value; i++) {
			result *= i;
		}

		Python.printf("O resultado do fatorial de {} é {}", value, result);
	}

	public static void fibonacci() {
		// fibonacci feito com as classes criadas
		int value = Python.input("digite um número para saber o fibonacci: ", false).nextInt();

		int current = 1, before = 0;

		for (int i = 1; i < value; i++) {
			if (value <= 2) {
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
			quit = Python.inputs("deseja sair? [s/n]").trim().equalsIgnoreCase("s");

		} while (!quit);

		value = Python.average(numbers);
		Python.printf("a média dos valores {} é {}", numbers, value);
	}

	public static void readText() {
		String n = Python.inputs("digite o caminho do texto: ");

		try {
			String[][] table = Python.open(n).makeTable(";");

			Python.printTable(table);
		} catch (FileNotFoundException e) {
			Python.print("arquivo não encontrado");
		}
	}

	public static void ask() {
		int cont = 0;
		String options = "sair%fatorial%fibonacci%média%ler texto";

		for (String option : options.split("[%]")) {
			Python.printf("[{}] - {}", cont, option);
			cont++;
		}
	}

}
