package com.apple.iphone;

public interface NavegadorInternet {
	abstract void exibirPagina(String url);

	abstract void adicionarNovaAba();

	abstract void atualizarPagina();

	abstract void encerrar();

}
