package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100
 * contatos.
 * 
 * @author nazareno
 *
 */

public class Agenda {
	
	/**
	 * Atributo do tipo int, que define o tamanho da agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;
	/**
	 * Atributo do tipo int, que define o tamanho da agenda favoritos.
	 */
	private static final int TAMANHO_AGENDA_FAVORITOS = 10;
	/**
	 * Atributo do tipo  array de favorito que armazena os objetos do tipo favoritos.
	 */
	private Favorito[] favoritos;
	/**
	 * Atributo do tipo  array de contato que armazena os objetos do tipo contatos.
	 */
	private Contato[] contatos;

	
	/**
	 * Método que cria as agendas.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Favorito[TAMANHO_AGENDA_FAVORITOS];
	}
	 
	/**
	 * Método que acessa a lista de contatos favoritos mantida.
	 * 
	 * @return O array de contatos favoritos.
	 */
	public Favorito[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Método que acessa a lista de contatos mantida.
	 * 
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição
	 * que já existe sobrescreve o anterior.
	 * 
	 * @param posicao   Posição do contato.
	 * @param nome      Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone  Telefone do contato.
	 * 
	 * @return bool retorno se o contato foi cadastrado ou não
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {

		boolean cadastrado = false;
		
		Contato contatoCompara = new Contato(nome, sobrenome, telefone);

		for (int i = 0; i < contatos.length; i++) {

			if (contatos[i] != null) {
				if (contatos[i].equals(contatoCompara)) {
					cadastrado = true;
					break;
				}
			}
			if (i == 99) {
				this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
				cadastrado = false;
				break;
			}

		}
		return cadastrado;

	}

	/**
	 * Método que cadastra contatos favoritados no array.
	 * 
	 * @param posicao posição em que o objeto contato favorito será cadastrado
	 * @param contato contato que vai ser cadastrado dentro do array
	 */
	public void cadastraContatoFavorito(int posicao, int contato) {
		this.favoritos[posicao] = new Favorito(contatos[contato].getNome(), contatos[contato].getSobrenome());

	}
	
	/**
	 * Método que retorna obejto do tipo favoritos armenzado na posição informada.
	 * 
	 * @param posicao posição do array em que o objeto está armazenado
	 * @return objeto do tipo favoritos na posição informada pelo usuário
	 */
	public Favorito getFavoritos(int posicao) {
		return this.favoritos[posicao];
	}

	/**
	 * Método que remove os objetos contatos e favoritos do array em que estão armazenados.
	 * 
	 * @param posicao posicao em que o objeto contatos está armazenado dentro do array.
	 */
	public void remove(int posicao) {

		int posicaoFavoritos = contatos[posicao].getPosicaofavorito();

		favoritos[posicaoFavoritos] = null;
		contatos[posicao] = null;
	}

}
