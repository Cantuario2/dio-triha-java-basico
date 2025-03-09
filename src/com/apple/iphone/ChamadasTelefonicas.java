package com.apple.iphone;

public abstract interface ChamadasTelefonicas {
	abstract void ligar(String numero);

	public abstract void atender();

	abstract void iniciarCorreioDeVoz();

	abstract void finalizar(String tipo);

}
