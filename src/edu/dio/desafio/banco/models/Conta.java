package edu.dio.desafio.banco.models;

import edu.dio.desafio.banco.interfaces.IConta;

public class Conta implements IConta {
	protected static final int AGENCIA_PADRAO = 1;
	protected int agencia;
	protected int numero;
	protected double saldo;

	private static int SEQUENCIAL = 1;

	public Conta() {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
	}

	protected int getAgencia() {
		return agencia;
	}

	protected int getNumero() {
		return numero;
	}

	protected double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void imprimirSaldo(String tipoDeConta) {
		System.out.println(String.format("------- Saldo de Conta %s -------", tipoDeConta));
		System.out.println("Agência: " + this.agencia);
		System.out.println(String.format("Conta %s: %d", tipoDeConta, numero));
		System.out.println(String.format("Saldo atual: %.2f", saldo));
	}

}
