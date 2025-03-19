package edu.dio.desafio.sudoku.ui.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainPanel(final Dimension dimension) {
		this.setSize(dimension);
		this.setPreferredSize(dimension);
	}
}
