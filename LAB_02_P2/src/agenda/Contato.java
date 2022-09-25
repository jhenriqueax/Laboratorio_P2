

package agenda;

import java.util.Objects;

/**
 * Classe contato implementada para criar objetos do tipo contato que irão receber informações como:
 * nome, sobrenome, telefone e possiveis tags definidas pelo usúario, bem como a posição favorita 
 * (caso o contato sejá favoritado). 
 * 
 * @author João Henrique Almeida Xavier
 */
public class Contato {

	/**
	 * Atributo do tipo str, que salva o nome do contato.
	 */
	private String nome;
	/**
	 * Atributo do tipo str, que salva o sobrenome do contato.
	 */
	private String sobrenome;
	/**
	 * Atributo do tipo str, que salva o telefone do contato.
	 */
	private String telefone;
	/**
	 * Array de str com tamanho 5, que salva as tags do contato.
	 */
	private String[] tag;
	/**
	 * Atributo do tipo int, que salva a posição em que o contato foi favoritado.
	 */
	private int posicaoFavorito;
	/**
	 * Atributo do tipo str, que auxilia na concatenação das tags para sua exibição 
	 * no método toString
	 */
	private String concatena;
	/**\
	 * /**
	 * Atributo do tipo str, que auxilia na formatação das tags para sua exibição 
	 * no método toString
	 */
	private String formatada;
	
	
	/**
	 * Construtor que "constroi"  o objeto contato com os parametros nome, sobrenome
	 * e telefone previamente informados pelo usuário, além de inicializar o array de tags.
	 *  
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tag = new String[5];
		this.concatena = "";
	
	}
	
	
	/**
	 * Método que retornar a posição em que o contato foi favoritado.
	 *
	 * @return posicaoFavorito posicao favorita do contato
	 */
	public int getPosicaofavorito() {
		return posicaoFavorito;
	}

	/**
	 * Método que defini (salva) a posição em que o contato foi favoritado.
	 * 
	 * @param posicaofavorito posicao favorita do contato
	 */
	public void setPosicaofavorito(int posicaofavorito) {
		this.posicaoFavorito = posicaofavorito;
	}

	/**
	 * Método que define o nome do contato.
	 * 
	 * @param nome nome do contato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método que retorna o nome do contato.
	 * 
	 * @return nome nome do contato
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Método que retorna o sobrenome do contato.
	 * 
	 * @return sobrenome sobrenome do contato
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}

	/**
	 * Método que retorna o telefone do contato.
	 * 
	 * @return telefone telefone do contato
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Método que retorna a(s) tag(s) do contato.
	 * 
	 * @return tag tag(s) associadas ao contato
	 */
	public String[] getTag() {
		return tag;
	}

	/**
	 * Métódo que define as tags, informadas pelo usuário, no contato.
	 * 
	 * @param posicao posição que será armazenada a tag
	 * @param tag tag informada pelo usúario.
	 */
	public void setTag(int posicao, String tag) {
		this.tag[posicao] = tag;

	}

	/**
	 * Método que auxilia na impressão o objeto contato, retornando uma str formatada, 
	 * contendo nome, sobrenome, telefone e tags do objeto contatos.
	 */
	public String toString() {

		for (int i = 0; i < tag.length; i++) {

			if (tag[i] != null) {
				concatena += tag[i] + " ";
			}
		}

		formatada = String.format("%s %s\n%s \n%s", this.nome, this.sobrenome, this.telefone, this.concatena);
		return formatada;

	}


	
	/**
	 * Método hashcode utilizando na implementação do equals
	 */
	public int hashCode() {
		return Objects.hash(nome, sobrenome, telefone);
	}
	
	/**
	 * Método equal que compara 2 objetos.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}

	
}
