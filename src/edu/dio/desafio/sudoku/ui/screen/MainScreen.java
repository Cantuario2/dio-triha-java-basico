package edu.dio.desafio.sudoku.ui.screen;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.dio.desafio.sudoku.models.GameStatusEnum;
import edu.dio.desafio.sudoku.models.LittleSquare;
import edu.dio.desafio.sudoku.services.BoardService;
import edu.dio.desafio.sudoku.services.EventEnum;
import edu.dio.desafio.sudoku.services.NotifierService;
import edu.dio.desafio.sudoku.ui.button.CheckGameStatusButton;
import edu.dio.desafio.sudoku.ui.button.FinishGameButton;
import edu.dio.desafio.sudoku.ui.button.ResetButton;
import edu.dio.desafio.sudoku.ui.frame.MainFrame;
import edu.dio.desafio.sudoku.ui.input.NumberText;
import edu.dio.desafio.sudoku.ui.panel.MainPanel;
import edu.dio.desafio.sudoku.ui.panel.SudokuSector;

public class MainScreen {
	private final static Dimension dimension = new Dimension(600, 600);

	private final BoardService boardService;
	private final NotifierService notifierService;

	private JButton checkGameSatusButton;
	private JButton resetButton;
	private JButton finishGameButton;

	public MainScreen(final Map<String, String> gameConfig) {
		this.boardService = new BoardService(gameConfig);
		this.notifierService = new NotifierService();
	}

	public void buildMainScreen() {
		JPanel mainPanel = new MainPanel(dimension);
		JFrame mainFrame = new MainFrame(dimension, mainPanel);

		for (int row = 0; row < 9; row += 3) {
			int endRow = row + 2;
			for (int col = 0; col < 9; col += 3) {
				int endCol = col + 2;
				List<LittleSquare> squares = getSquaresFromSector(boardService.getSquares(), col, endCol, row, endRow);
				JPanel sector = generateSection(squares);
				mainPanel.add(sector);
			}
		}

		addResetButton(mainPanel);
		addShowGameStatusButton(mainPanel);
		addFinishGameButton(mainPanel);

		mainFrame.revalidate();
		mainFrame.repaint();
	}

	private List<LittleSquare> getSquaresFromSector(List<List<LittleSquare>> squares, final int initCol,
			final int endCol, final int initRow, final int endRow) {
		List<LittleSquare> squareSector = new ArrayList<LittleSquare>();
		for (int r = initRow; r <= endRow; r++) {
			for (int c = initCol; c <= endCol; c++) {
				squareSector.add(squares.get(c).get(r));
			}
		}
		return squareSector;
	}

	private JPanel generateSection(final List<LittleSquare> squaresList) {
		List<NumberText> fields = new ArrayList<>(squaresList.stream().map(NumberText::new).toList());
		fields.forEach(t -> notifierService.subscriber(EventEnum.CLEAR_SPACE, t));
		return new SudokuSector(fields);
	}

	private void addFinishGameButton(JPanel mainPanel) {

		finishGameButton = new FinishGameButton(e -> {
			if (boardService.isFinished()) {
				JOptionPane.showMessageDialog(null, "Parabéns! Você concluiu o jogo!");
				resetButton.setEnabled(false);
				checkGameSatusButton.setEnabled(false);
				finishGameButton.setEnabled(false);
			} else {
				String message = "Seu jogo contém alguma inconsistência. Ajuste e tente novamente.";
				JOptionPane.showMessageDialog(null, message, "Finalizar Jogo", 1);
			}
		});
		mainPanel.add(finishGameButton);
	}

	private void addShowGameStatusButton(JPanel mainPanel) {
		checkGameSatusButton = new CheckGameStatusButton(e -> {
			boolean hasErrors = boardService.hasErrors();
			GameStatusEnum gameStatus = boardService.getStaus();
			String message = switch (gameStatus) {
			case STARTED -> "O jogo foi iniciado";
			case INCOMPLETE -> "O jogo está incompleto";
			case COMPLETE -> "O jogo está completo";
			};
			message += hasErrors ? " e contém erros. Verifique." : " e não contém erros.";
			JOptionPane.showMessageDialog(null, message, "Status do Jogo", 1);
		});
		mainPanel.add(checkGameSatusButton);
	}

	private void addResetButton(JPanel mainPanel) {
		resetButton = new ResetButton(e -> {
			var dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente limpar o jogo?", "Limpar jogo",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == 0) {
				boardService.reset();
				notifierService.notify(EventEnum.CLEAR_SPACE);
			}
		});

		mainPanel.add(resetButton);
	}
}
