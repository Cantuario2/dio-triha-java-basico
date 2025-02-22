package com.banco.modelos;

public class ContaBancaria {
	public String nomeCliente;
	public int agenciaNumero;
	public int numeroConta;
	public int digitoConta;
	public double saldoConta;

	public ContaBancaria() {
	}

	public ContaBancaria(String nomeCliente, int agenciaNumero, int numeroConta, int digitoConta, float saldoConta) {
		this.nomeCliente = nomeCliente;
		this.agenciaNumero = agenciaNumero;
		this.numeroConta = numeroConta;
		this.digitoConta = digitoConta;
		this.saldoConta = saldoConta;
	}
}
