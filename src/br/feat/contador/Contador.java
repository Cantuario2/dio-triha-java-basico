package br.feat.contador;

import java.util.*;

import custom.exceptions.ParametrosInvalidosException;

public class Contador {
	public static void main(String[] args) throws Exception {
		Scanner terminal = new Scanner(System.in).useLocale(Locale.forLanguageTag("br"));

		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();
		terminal.close();

		contar(parametroUm, parametroDois);
	}

	static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
		if (parametroUm > parametroDois) {
			throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
		} else {
			int contagem = parametroDois - parametroUm;
			for (int i = 0; i < contagem; i++) {
				System.out.printf("\nImprimindo o número %d", i + 1);
			}
		}
	}
}