package edu.dio.desafio.sudoku.ui.frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame(final Dimension dimension, final JPanel mainPanel) {
		super("Sudoku Maria Nilda");
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(mainPanel);
	}

}
