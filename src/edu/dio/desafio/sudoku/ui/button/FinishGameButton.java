package edu.dio.desafio.sudoku.ui.button;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FinishGameButton extends JButton {

	private static final long serialVersionUID = 1L;

	public FinishGameButton(final ActionListener actionListener) {
		this.setText("Finalizar Jogo");
		this.addActionListener(actionListener);
	}
}
