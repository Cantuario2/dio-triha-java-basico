package edu.dio.desafio.sudoku.ui.button;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CheckGameStatusButton extends JButton {

	private static final long serialVersionUID = 1L;

	public CheckGameStatusButton(final ActionListener actionListener) {
		this.setText("Verificar Jogo");
		this.addActionListener(actionListener);
	}
}
