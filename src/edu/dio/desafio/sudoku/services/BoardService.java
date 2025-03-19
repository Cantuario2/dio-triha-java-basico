package edu.dio.desafio.sudoku.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.dio.desafio.sudoku.models.Board;
import edu.dio.desafio.sudoku.models.GameStatusEnum;
import edu.dio.desafio.sudoku.models.LittleSquare;

public class BoardService {
	private final static int BOARD_LIMIT = 9;
	private final Board board;

	public BoardService(final Map<String, String> gameConfig) {
		this.board = new Board(initBoard(gameConfig));
	}

	public List<List<LittleSquare>> getSquares() {
		return this.board.getSquares();
	}

	public void reset() {
		this.board.resetBoard();
	}

	public boolean hasErrors() {
		return this.board.hasErrors();
	}

	public GameStatusEnum getStaus() {
		return board.getStatus();
	}

	public boolean isFinished() {
		return board.isFinished();
	}

	private List<List<LittleSquare>> initBoard(Map<String, String> gameConfig) {
		// Exatamente o mesmo método constante em startGame mas sema a validação
		List<List<LittleSquare>> squares = new ArrayList<>();
		for (int i = 0; i < BOARD_LIMIT; i++) {
			squares.add(new ArrayList<LittleSquare>());
			for (int j = 0; j < BOARD_LIMIT; j++) {
				String positionConfig = gameConfig.get("%s,%s".formatted(i, j));
				int expected = Integer.parseInt(positionConfig.split(",")[0]);
				boolean fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
				var currentSquare = new LittleSquare(expected, fixed);
				squares.get(i).add(currentSquare);
			}
		}

		return squares;
	}
}
