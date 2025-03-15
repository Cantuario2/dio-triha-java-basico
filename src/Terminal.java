import edu.dio.desafio.banco.models.Cliente;
import edu.dio.desafio.banco.models.ContaCorrente;
import edu.dio.desafio.banco.models.ContaPoupanca;
import edu.dio.desafio.banco.models.Historico;
import edu.dio.desafio.banco.models.Operacao;

public class Terminal {
	public static void main(String[] args) {
		System.out.println(
				"-----------------------------------\n------------- Banco X -------------\n-----------------------------------");
		Cliente cliente = new Cliente("Cantuario2");
		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca poupanca = new ContaPoupanca();
		Historico operacoes = new Historico();

		System.out.println(String.format("Cliente: %s", cliente.getNome()));
		System.out.println("\nValores iniciais");
		cc.imprimirSaldo();
		poupanca.imprimirSaldo();

		System.out.println("\nDepositando 550,00 na Conta Corrente...");
		cc.depositar(550);
		operacoes.adicionarOperacao(new Operacao('c', 550.00F, "Depósito Inicial"));
		cc.imprimirSaldo();

		System.out.println("\nTransferindo 125,50 da Conta Corrente para Conta Poupança...");
		cc.transferir(125.5, poupanca);
		operacoes.adicionarOperacao(new Operacao('d', 125.50F, "Transferência Conta Poupança"));
		cc.imprimirSaldo();
		poupanca.imprimirSaldo();

		System.out.println("\nFazendo empréstimo de 5000,00 na Conta Corrente...");
		cc.depositar(5000);
		operacoes.adicionarOperacao(new Operacao('c', 5000.00F, "Empréstimo Consignado"));
		operacoes.adicionarOperacao(new Operacao('d', 3.75F, "Seguro Empréstimo Consignado"));
		cc.imprimirSaldo();
		poupanca.imprimirSaldo();

		operacoes.imprimeExtrato();
	}
}
