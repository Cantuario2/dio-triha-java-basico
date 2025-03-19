package edu.dio.desafio.sudoku.ui.input;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.dio.desafio.sudoku.models.LittleSquare;
import edu.dio.desafio.sudoku.services.EventEnum;
import edu.dio.desafio.sudoku.services.EventListener;

public class NumberText extends JTextField implements EventListener {
	private static final long serialVersionUID = 1L;
	public NumberText(final LittleSquare square) {
		Dimension dimension = new Dimension(50, 50);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setVisible(true);
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setHorizontalAlignment(CENTER);
		this.setDocument(new NumberTextLimit());
		this.setEditable(!square.isFixed());
		if (square.isFixed()) {
			this.setText(square.getActual().toString());
		}
		this.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				changeSquare();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				changeSquare();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				changeSquare();
			}

			private void changeSquare() {
				if (getText().isEmpty()) {
					square.clearSquare();
					return;
				}
				square.setActual(Integer.parseInt(getText()));
			}
		});
	}

	@Override
	public void update(EventEnum eventType) {
		if (eventType.equals(EventEnum.CLEAR_SPACE) && (this.isEditable())) {
			this.setText("");
		}
	}
}