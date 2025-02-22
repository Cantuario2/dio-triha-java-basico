import java.util.InputMismatchException;
import java.util.Scanner;

import com.banco.modelos.ContaBancaria;

/**
 * Esta classe retornar as características de uma conta bancária conforme input
 * do usuário. A classe lança uma exceção do tipo InputMismatchException
 * 
 * @author cantuario2
 * @input Nome_do_Cliente Número_da_Agência Número_da_Conta Dígito_da_Conta
 *        Saldo_da_Conta
 * @version 1.0
 * @since 21/02/2025
 */
public class ContaTerminal {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in, "UTF-8");
		ContaBancaria conta = new ContaBancaria();

		System.out.println("BANCO NACIONAL DA ILHA DE JAVA");
		System.out.println("------------------------------");
		System.out.println("\nInforme o nome completo do cliente: ");
		conta.nomeCliente = scanner.nextLine();
		System.out.println("Informe o Número da Agência: ");
		conta.agenciaNumero = scanner.nextInt();
		System.out.println("Informe o Número da Conta: ");
		conta.numeroConta = scanner.nextInt();
		System.out.println("Informe o Dígito Verificador da Conta: ");
		conta.digitoConta = scanner.nextInt();
		System.out.println("Informe o Saldo da Conta: ");
		conta.saldoConta = Double.valueOf(scanner.nextDouble());
		scanner.close();

		System.out.println("\n\nOlá " + conta.nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
				+ conta.agenciaNumero + ", conta " + conta.numeroConta + "-" + conta.digitoConta + " e seu saldo R$ "
				+ conta.saldoConta + " já está disponível para saque,");
	}

}
