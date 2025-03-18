package edu.dio.desafio.sudoku.models;

public enum GameStatusEnum {
	STARTED("Iniciado"), COMPLETE("Concluído"), INCOMPLETE("Incompleto");

	private String label;

	GameStatusEnum(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
