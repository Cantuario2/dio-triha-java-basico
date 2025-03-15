package edu.dio.desafio.banco.interfaces;

import edu.dio.desafio.banco.models.Conta;

public interface IConta {
	void sacar(double valor);

	void depositar(double valor);

	void transferir(double valor, Conta contaDestino);

	void imprimirSaldo(String tipoDeConta);
}
