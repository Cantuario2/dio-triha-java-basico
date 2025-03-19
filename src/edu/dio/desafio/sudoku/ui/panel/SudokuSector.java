package edu.dio.desafio.sudoku.ui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import edu.dio.desafio.sudoku.ui.input.NumberText;

public class SudokuSector extends JPanel {

	private static final long serialVersionUID = 1L;

	public SudokuSector(final List<NumberText> textFields) {
		var dimension = new Dimension(170, 170);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setBorder(new LineBorder(Color.black, 2, true));
		this.setVisible(true);
		textFields.forEach(this::add);
	}
}
