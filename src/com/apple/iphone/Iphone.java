package com.apple.iphone;

import java.util.Scanner;

public class Iphone implements ChamadasTelefonicas, NavegadorInternet, ReprodutorMusical {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("------ iPhone ------");
			System.out.println("1 - Ligações Telefônicas");
			System.out.println("2 - Navegador da Internet");
			System.out.println("3 - Player de Música");
			System.out.println("4 - Desligar");
			int option = scanner.nextInt();

			switch (option) {
			case 1 -> telefonar();
			case 2 -> navegarInternet();
			case 3 -> tocarMusica();
			case 4 -> {
				System.out.println("Desligando Aparelho...\nAté breve!");
				System.exit(0);
			}
			default -> System.out.println("Escolha uma opção válida!");
			}
		}
	}

	private static Object tocarMusica() {
		while (true) {
			System.out.println("------ Reprodutor Musical ------");
			System.out.println("1 - Selecionar música");
			System.out.println("2 - Tocar música");
			System.out.println("3 - Pausar a música");
			System.out.println("4 - Finalizar a música");
			System.out.println("5 - Sair");
			int option = scanner.nextInt();

			switch (option) {
			case 1 -> {
				System.out.println("Digite o nome da música:");
				String musica = scanner.nextLine();
				selecionarMusicar(musica);
			}
			case 2 -> tocar();
			case 3 -> pausar();
			case 4 -> finalizar();
			case 5 -> main(null);
			default -> System.out.println("Escolha uma opção válida!");
			}
		}
	}

	private static Object navegarInternet() {
		while (true) {
			System.out.println("------ Navegador da Internet ------");
			System.out.println("1 - Exibir página");
			System.out.println("2 - Adicionar nova aba");
			System.out.println("3 - Atualizar página");
			System.out.println("4 - Sair");
			int option = scanner.nextInt();

			switch (option) {
			case 1 -> {
				System.out.println("Digite o endereço da página da web:");
				String urlPagina = scanner.nextLine();
				exibirPagina(urlPagina);
			}
			case 2 -> adicionarNovaAba();
			case 3 -> atualizarPagina();
			case 4 -> {
				encerrar();
				main(null);
			}
			default -> System.out.println("Escolha uma opção válida!");
			}
		}
	}

	private static void telefonar() {
		while (true) {
			System.out.println("------ Chamadas Telefônicas ------");
			System.out.println("1 - Fazer ligação");
			System.out.println("2 - Correio de voz");
			System.out.println("3 - Atender ligação");
			System.out.println("4 - Sair");
			int option = scanner.nextInt();

			switch (option) {
			case 1 -> {
				System.out.println("Digite o número do telefone:");
				String numero = scanner.nextLine();
				ligar(numero);
			}
			case 2 -> iniciarCorreioDeVoz();
			case 3 -> atender();
			case 4 -> main(null);
			default -> System.out.println("Escolha uma opção válida!");
			}
		}
	}

	@Override
	public void tocar() {
		System.out.println("Tocando a música...");

	}

	@Override
	public void pausar() {
		System.out.println("Pausando a música...");

	}

	@Override
	public void selecionarMusicar(String musica) {
		System.out.println("Selecionando a música " + musica + "...");

	}

	@Override
	public final void finalizar() {
		System.out.println("Finalizando o player de músicas...");

	}

	@Override
	public void exibirPagina(String url) {
		System.out.println("Exibindo a página " + url + "no navegador...");

	}

	@Override
	public void adicionarNovaAba() {
		System.out.println("Nova aba adicionada no navegador...");

	}

	@Override
	public void atualizarPagina() {
		System.out.println("Página atualizada no navegador.");

	}

	@Override
	public void encerrar() {
		System.out.println("Encerrando o navegador da internet...");

	}

	@Override
	public static void ligar(String numero) {
		System.out.println("Fazendo liagação telefônica para o número " + numero + "...");
		finalizar();
	}

	@Override
	public static void atender() {
		System.out.println("Ligação atendida.");
		finalizar();

	}

	@Override
	public static void iniciarCorreioDeVoz() {
		System.out.println("Iniciando correior de voz...");
		finalizar();

	}

	@Override
	public void finalizar(String tipo) {
		System.out.println("Ligação finalizada.");

	}

}
