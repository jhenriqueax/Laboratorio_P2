package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println("\n---\nMENU\n" + "(C)adastrar Contato\n" + "(L)istar Contatos\n" + "(E)xibir Contato\n"
				+ "(F)avoritos\n" + "(A)dicionar Favorito\n" + "(T)ags\n" + "(R)emover Contato\n" +"(S)air\n" + "\n" + "Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			exibeContatoFavorito(agenda);
			break;
		case "A":
			cadastradaContatoFavorito(agenda, scanner);
			break;
		case "T":
			cadastraTag(agenda, scanner);
			break;
		case "R":
			removeContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVALIDA!");
		}
	}

	/**
	 * Método que remove o contato selecionado.
	 * 
	 * @param agenda a agenda que estamos manipulando
	 * @param scanner para capturar entrada do usuário
	 */
	private static void removeContato(Agenda agenda, Scanner scanner) {
			
		System.out.println("Contato(s)> ");
		int posicao = scanner.nextInt();
		agenda.remove(posicao-1);
		
		
	}

	/**
	 * Método que cadastra as tags no contato selecionado.
	 * 
	 * @param agenda a agenda que estamos manipulando
	 * @param scanner para ler entradas do usuário
	 */
	private static void cadastraTag(Agenda agenda, Scanner scanner) {

		Contato[] contatos = agenda.getContatos();
		scanner.nextLine(); // captura o \n que o next deixa
		System.out.println("Contatos(s)> ");	
		String posicaoContato = scanner.nextLine();
		
		String[] arrayPosicao = posicaoContato.split(" ");
		System.out.println("Tag> ");
		String tag = scanner.nextLine();
		System.out.println("Posicao> ");
		int posicao = scanner.nextInt();
		
		for (int i = 0; i < arrayPosicao.length; i++) {
			int pos = Integer.parseInt((arrayPosicao[i]));
			contatos[pos-1].setTag(posicao, tag);
		}
		

	}
	
	/**
	 * Método que exibe os contatos favoritos armazenados no array de
	 * favoritos em agenda.
	 * 
	 * @param agenda a agenda que estamos manipulando
	 */
	private static void exibeContatoFavorito(Agenda agenda) {

		Favorito[] favoritos = agenda.getFavoritos();

		for (int i = 0; i < 10; i++) {
			if (favoritos[i] != null) {
				System.out.printf("%d - %s\n", i+1, favoritos[i].toString());
			}
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {

		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i+1, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda.
	 * 
	 * @param agenda  A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		boolean comparaBool = false;
		System.out.print("Qual contato> ");
		int posicao = scanner.nextInt();
		Contato contato = agenda.getContato(posicao-1);

		if (contato != null) {

			Favorito compara = new Favorito(contato.getNome(), contato.getSobrenome());
			for (int i = 0; i < 10; i++) {
				Favorito favoritos = agenda.getFavoritos(i);
				if (compara.equals(favoritos)) {
					comparaBool = true;
					break;
				}
			}
			
			if (comparaBool == true) {
				System.out.println("Dados do contato:\n" + "\n" + "❤️" + contato.toString());
			} else {
				System.out.println("Dados do contato:\n" + "\n" + contato.toString());
			}

		} else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Formata um contato para impressão na interface.
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + " - " + contato.getNome() + " " + contato.getSobrenome();
	}

	/**
	 * Método que cadastra contato favorito na posição no array de favoritos.
	 * 
	 * @param agenda a agenda que estamos manipulando
	 * @param scanner para ler a as entradas do usuário
	 */
	private static void cadastradaContatoFavorito(Agenda agenda, Scanner scanner) {
		boolean comparaBool = false;
		System.out.println("Contato> ");
		int contatoSalvo = scanner.nextInt();

		Contato contato = agenda.getContato(contatoSalvo-1);

		System.out.println("Posicao> ");
		int posicao = scanner.nextInt();

		Favorito compara = new Favorito(contato.getNome(), contato.getSobrenome());
		for (int i = 0; i <= 9; i++) {
			Favorito favoritos = agenda.getFavoritos(i);
			if (compara.equals(favoritos)) {
				comparaBool = true;
				break;
			}
		}

		if (comparaBool == true) {
			System.out.println("ESTE CONTATO JÁ FOI FAVORITADO");
		} else {
			
			contato.setPosicaofavorito(posicao-1);
			System.out.printf("CONTATO FAVORITADO NA POSIÇÃO %d !", posicao);
			agenda.cadastraContatoFavorito(posicao-1, contatoSalvo-1);
		}

	}

	/**
	 * Cadastra um contato na agenda, já realizando uma pré tratamento dos dados
	 * de forma que o método criaContato() só é chamado quando os parametros estão
	 * todos corretos (preenchidos como especificado) e não são repetidos.
	 * 
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine(); // captura o \n que o nextInt deixa

		if (1 > posicao || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else {

			System.out.print("\nNome> ");
			String nome = scanner.nextLine();

			if (nome.isEmpty()) {
				System.out.println("CONTATO INVALIDO");
			} else {

				System.out.print("Sobrenome>  ");
				String sobrenome = scanner.nextLine();
				

				System.out.print("Telefone> ");
				String telefone = scanner.nextLine();

				if (telefone.isEmpty()) {
					System.out.println("CONTATO INVALIDO");
				} else {

					if (!agenda.cadastraContato(posicao-1, nome, sobrenome, telefone)) {
						agenda.cadastraContato(posicao-1, nome, sobrenome, telefone);
						System.out.println("CADASTRO REALIZADO");
					} else {
						System.out.println("CONTATO JA CADASTRADO");
					}
				}
			}

		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv.
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda          A agenda que deve ser populada com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();

		int carregados = leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
