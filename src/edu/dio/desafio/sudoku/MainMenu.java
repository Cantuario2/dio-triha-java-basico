package edu.dio.desafio.sudoku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;
import edu.dio.desafio.sudoku.models.Board;
import edu.dio.desafio.sudoku.models.LittleSquare;
import edu.dio.desafio.sudoku.templates.BoardTemplate;

public class MainMenu {
	private final static Scanner scanner = new Scanner(System.in);
	private static Board board;
	private final static int BOARD_LIMIT = 9;

	public static void main(String[] args) {
		final Map<String, String> positions = Stream.of(args)
				.collect(Collectors.toMap(k -> k.split(";")[0], v -> v.split(";")[1]));
		int option = -1;

		System.out.println("Sudoku Java - Desafio Dio - Bootcamp Bradesco Java Cloud Native");
		while (true) {
			clearConsole();
			System.out.println("Selecione uma opção");
			System.out.println("1 - Iniciar um novo jogo");
			System.out.println("2 - Colocar um novo número");
			System.out.println("3 - Remover um número");
			System.out.println("4 - Visualizar jogo atual");
			System.out.println("5 - Verificar status do jogo");
			System.out.println("6 - Limpar jogo");
			System.out.println("7 - Finalizar jogo");
			System.out.println("8 - Sair");

			option = scanner.nextInt();

			switch (option) {
			case 1 -> startGame(positions);
			case 2 -> insertNumber();
			case 3 -> removeNumber();
			case 4 -> showCurrentGame();
			case 5 -> showGameStatus();
			case 6 -> clearGame();
			case 7 -> finishGame();
			case 8 -> System.exit(0);
			default -> System.out.println("Selecione uma opção válida!");
			}
		}
	}

	private static void startGame(Map<String, String> positions) {
		if (nonNull(board)) {
			System.out.println("Jogo já iniciado!");
			return;
		}

		List<List<LittleSquare>> squares = new ArrayList<>();
		for (int i = 0; i < BOARD_LIMIT; i++) {
			squares.add(new ArrayList<LittleSquare>());
			for (int j = 0; j < BOARD_LIMIT; j++) {
				String positionConfig = positions.get("%s,%s".formatted(i, j));
				int expected = Integer.parseInt(positionConfig.split(",")[0]);
				boolean fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
				var currentSquare = new LittleSquare(expected, fixed);
				squares.get(i).add(currentSquare);
			}
		}

		board = new Board(squares);
		System.out.println("Jogo pronto para começar.");
	}

	private static void insertNumber() {
		if (isNull(board)) {
			System.out.println("Jogo ainda não iniciado!");
			return;
		}

		System.out.println("Informe a coluna do número a ser inserido: ");
		int col = runUntilGetValidNumber(0, 8);
		System.out.println("Informe a linha do número a ser inserido: ");
		int row = runUntilGetValidNumber(0, 8);
		System.out.printf("Informe o número que será inserido na posição [%d,%d]", row, col);
		int value = runUntilGetValidNumber(1, 9);

		if (!board.changeValues(col, row, value)) {
			System.out.printf("A posição [%d,%d] tem um valor fixo.", row, col);
		}
	}

	private static void removeNumber() {
		if (isNull(board)) {
			System.out.println("Jogo ainda não iniciado!");
			return;
		}

		System.out.println("Informe a coluna do número a ser removido: ");
		int col = runUntilGetValidNumber(0, 8);
		System.out.println("Informe a linha do número a ser removido: ");
		int row = runUntilGetValidNumber(0, 8);

		if (!board.clearValue(col, row)) {
			System.out.printf("A posição [%d,%d] tem um valor fixo.", row, col);
		}
	}

	private static void showCurrentGame() {
		if (isNull(board)) {
			System.out.println("Jogo ainda não iniciado!");
			return;
		}

		var args = new Object[81];
		var argPos = 0;
		for (int i = 0; i < BOARD_LIMIT; i++) {
			for (List<LittleSquare> col : board.getSquares()) {
				args[argPos++] = " " + (isNull(col.get(i).getActual()) ? " " : col.get(i).getActual());
			}
		}

		System.out.println("Jogo atual:");
		System.out.println(BoardTemplate.BOARD.formatted(args));

	}

	private static void clearGame() {
		if (isNull(board)) {
			System.out.println("Jogo ainda não iniciado!");
			return;
		}

		System.out.println("Deseja realmente limpar o jogo? (Todo o progresso será perdido)");
		String confirm = scanner.next();
		while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não")
				&& !confirm.equalsIgnoreCase("nao")) {
			System.out.println("Informe 'sim' ou 'não'!");
			confirm = scanner.next();
		}
		if (confirm.equalsIgnoreCase("sim")) {
			board.resetBoard();
		}
	}

	private static void showGameStatus() {
		if (isNull(board)) {
			System.out.println("Jogo ainda não iniciado!");
			return;
		}

		System.out.printf("Status atual do jogo: %s\n", board.getStatus().getLabel());
		if (board.hasErrors()) {
			System.out.println("O jogo contém erros!");
		} else {
			System.out.println("Tudo certo! Continue jogando!");
		}
	}

	private static void finishGame() {
		if (isNull(board)) {
			System.out.println("Jogo ainda não iniciado!");
			return;
		}

		if (board.isFinished()) {
			System.out.println("Parabéns! Você concluiu o jogo!");
			showCurrentGame();
			board = null;
		} else if (board.hasErrors()) {
			System.out.println("O jogo contém erros! Corrija-os e tente novamente.");
		} else {
			System.out.println("Ainda há espaços à serem preenchidos. Verifique.");
		}
	}

	private static int runUntilGetValidNumber(final int min, final int max) {
		int current = scanner.nextInt();
		while (current < min || current > max) {
			System.out.printf("Informe um número entre %d e %d!", min, max);
			current = scanner.nextInt();
		}
		return current;
	}

	// @SuppressWarnings("deprecation")
	public static void clearConsole() {
		try {

			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				new ProcessBuilder("clear").start();
			// Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}
}
