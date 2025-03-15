package edu.dio.desafio.banco.models;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Operacao implements Comparable<Operacao> {
	private OffsetDateTime data;
	private char tipo;
	private float valor;
	private String descricao;

	ZoneOffset zoneOffSet = ZoneOffset.of("-03:00");
	DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

	public Operacao(char tipo, float valor, String descricao) {
		this.data = OffsetDateTime.now(zoneOffSet);
		this.tipo = tipo;
		this.valor = valor;
		this.descricao = descricao;
	}

	protected OffsetDateTime getData() {
		return data;
	}

	protected char getTipo() {
		return tipo;
	}

	protected float getValor() {
		return valor;
	}

	protected String getDescricao() {
		return descricao;
	}

	@Override
	public int compareTo(Operacao o) {
		return Integer.compare(this.data.hashCode(), o.getData().hashCode());
	}

	@Override
	public String toString() {
		String tipoDescricao = tipo == 'c' ? "Crédito" : "Débito";
		return dtformatter.format(data) + "\t" + tipoDescricao + "\t\t" + String.format("%.2f", valor) + "\t\t"
				+ descricao;
	}

}
