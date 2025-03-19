package edu.dio.desafio.sudoku;

//import java.awt.Dimension;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import edu.dio.desafio.sudoku.ui.frame.MainFrame;
//import edu.dio.desafio.sudoku.ui.panel.MainPanel;
import edu.dio.desafio.sudoku.ui.screen.MainScreen;

public class UIMain {
	public static void main(String[] args) {
//		Dimension dimension = new Dimension(600, 600);
//		JPanel mainPanel = new MainPanel(dimension);
//		JFrame mainFrame = new MainFrame(dimension, mainPanel);
//		mainFrame.revalidate();
//		mainFrame.repaint();

		final Map<String, String> gameConfig = Stream.of(args)
				.collect(Collectors.toMap(k -> k.split(";")[0], v -> v.split(";")[1]));
		var mainScreen = new MainScreen(gameConfig);
		mainScreen.buildMainScreen();
	}
}
