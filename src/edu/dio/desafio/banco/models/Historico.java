package edu.dio.desafio.banco.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Historico {
	private List<Operacao> extrato;
	private float saldo = 0.00F;

	public Historico() {
		this.extrato = new ArrayList<Operacao>();
	}

	public void adicionarOperacao(Operacao op) {
		this.extrato.add(op);
		switch (op.getTipo()) {
		case 'c' -> {
			saldo += op.getValor();
			break;
		}
		case 'd' -> {
			saldo -= op.getValor();
			break;
		}
		default -> {
			break;
		}
		}
	}

	public List<Operacao> ordenarPorDataCrescente() {
		List<Operacao> operacoesPorDataCrescente = new ArrayList<Operacao>(extrato);
		Collections.sort(operacoesPorDataCrescente);

		return operacoesPorDataCrescente;
	}

	public List<Operacao> ordenarPorDataDescrescente() {
		List<Operacao> operacoesPorDataDescrescente = ordenarPorDataCrescente();
		Collections.reverse(operacoesPorDataDescrescente);

		return operacoesPorDataDescrescente;
	}

	public void imprimeExtrato() {
		System.out.println("\n-------------------------------- Extrato das Operações --------------------------------");
		extrato.forEach(e -> System.out.println(e));
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println(String.format("Saldo Atual:\t\t\t\t %.2f", saldo));
	}
}
