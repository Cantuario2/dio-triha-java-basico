package edu.dio.desafio.sudoku.models;

public class LittleSquare {
	private Integer actual;
	private final int expected;
	private final boolean fixed;

	public LittleSquare(final int expected, final boolean fixed) {
		this.expected = expected;
		this.fixed = fixed;
		if (fixed) {
			actual = expected;
		}
	}

	public Integer getActual() {
		return actual;
	}

	public void setActual(final Integer actual) {
		if (fixed)
			return;
		this.actual = actual;
	}

	protected int getExpected() {
		return expected;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void clearSquare() {
		setActual(null);
	}

}
