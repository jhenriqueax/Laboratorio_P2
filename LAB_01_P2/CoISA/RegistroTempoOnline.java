package CoISA;

/**
 * Registro do tempo online, responsável por manter a informação sobre
 * quantidade de horas de internet que o aluno tem dedicado a uma disciplina
 * remota. Para cada disciplina, sera criado um objeto para o controle desse
 * estado (tempo online usado).
 *
 * @author João Henrique Almeida Xavier
 */
public class RegistroTempoOnline {

	/**
	 * Atributo que armazena o tempo Online do aluno na disciplina.
	 * 
	 */
	private int tempoOnline;

	/**
	 * Atributo que armazena o tempo online esperado, por padrão o valor é 120, mas
	 * esse valor pode ser alterado com a inicialização do construtor.
	 * 
	 **/
	private int tempoOnlineEsperado;

	/**
	 * Atributo que armazena o nome da disciplina passado pelo construtor.
	 *
	 */
	private String nomeDisciplina;

	/**
	 * Construtor que recebe o nome da disciplina (tempo online esperado padrão
	 * ("120")
	 * 
	 * @param nomeDisciplina nome da disciplina
	 * 
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnline = 0;
		this.tempoOnlineEsperado = 120;
	}

	/**
	 * Construtor que recebe o nome da disciplina, bem como, o tempo online que se
	 * espera que o aluno dedique a disciplina.
	 * 
	 * @param nomeDisciplina      nome da disciplina
	 * @param tempoOnlineEsperado tempo online esperado
	 * 
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
		this.tempoOnline = 0;
	}

	/**
	 * Método que adicina o parametro tempo (tempo dedicado pelo aluno) ao atributo
	 * tempoOnline.
	 * 
	 * @param tempo tempo online
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}

	/**
	 * Método que compara se o tempo dedicado pelo estudante (tempoOnline) é igual
	 * ou superior ao tempo esperado (tempoOnlineEsperado) caso afirmativo o
	 * parametro retorna "true" caso contrário retorna "false.
	 * 
	 * @return valor boleano indicado se o aluno atingiu a meta.
	 */
	public boolean atingiuMetaTempoOnline() {
		return this.tempoOnline >= this.tempoOnlineEsperado;

	}

	/**
	 * Método que retornar os parametros nomeDisciplina, tempoOnline e
	 * tempoOnlineEsperado de forma formatada.
	 * 
	 * @return string formatada
	 * 
	 */
	public String toString() {
		return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
	}

}
