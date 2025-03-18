package edu.dio.desafio.sudoku.models;

import java.util.Collection;
import java.util.List;
import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

public class Board {
	private List<List<LittleSquare>> squares = null;

	public Board(final List<List<LittleSquare>> squares) {
		this.squares = squares;
	}

	public List<List<LittleSquare>> getSquares() {
		return squares;
	}

	public GameStatusEnum getStatus() {
		if (!squares.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && nonNull(s.getActual()))) {
			return GameStatusEnum.STARTED;
		}
		return squares.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getActual()))
				? GameStatusEnum.INCOMPLETE
				: GameStatusEnum.COMPLETE;
	}

	public boolean hasErrors() {
		if (getStatus() != GameStatusEnum.STARTED) {
			return false;
		}
		return squares.stream().flatMap(Collection::stream)
				.anyMatch(s -> nonNull(s.getActual()) && s.getActual().equals(s.getExpected()));
	}

	public boolean changeValues(final int col, final int row, final Integer value) {
		LittleSquare square = squares.get(col).get(row);
		if (square.isFixed()) {
			return false;
		}
		square.setActual(value);
		return true;
	}

	public boolean clearValue(final int col, final int row) {
		LittleSquare square = squares.get(col).get(row);
		if (square.isFixed()) {
			return false;
		}
		square.clearSquare();
		return true;
	}

	public void resetBoard() {
		squares.forEach(col -> col.forEach(row -> row.clearSquare()));
	}

	public boolean isFinished() {
		return !hasErrors() && getStatus().equals(GameStatusEnum.COMPLETE);
	}
}
