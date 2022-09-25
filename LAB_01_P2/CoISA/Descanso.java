package CoISA;

/**
 * Representação do tempo descansado por um estudante bem como seu status que
 * pode ser "cansado" caso a média (horas descansadas /semanas passadas) seja
 * menor que 26 ou "descansado" caso a média seja maior ou igual a 26.
 *
 * @author João Henrique Almeida Xavier
 */
public class Descanso {

	/**
	 * Atributo que armazena as horas descansadas.
	 * 
	 */
	private int horasDescansadas;

	/**
	 * Atributo que armazena o número de semanas passadas.
	 * 
	 */
	private int semanas;

	/**
	 * Atributo que armazena a média, calculada pela divisão das horas pela semanas
	 * com (semanas != 0).
	 * 
	 */
	private double mediaDescanso;

	/**
	 * Construtor que inicializa os parametros, horasDescansadas, semanas e
	 * mediaDescanso.
	 */
	public Descanso() {
		this.horasDescansadas = 0;
		this.semanas = 1;
		this.mediaDescanso = 0;
	}

	/**
	 * Método que adicina o paramentro valor (horas descansadas pelo aluno) ao
	 * atributo horas.
	 * 
	 * @param valor horas descansadas
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescansadas = valor;
	}

	/**
	 * Método que adiciona o paramentro valor (semanas passadas) ao atributo
	 * semanas.
	 * 
	 * @param valor semanas
	 */
	public void defineNumeroSemanas(int valor) {
		this.semanas = valor;
	}

	/**
	 * Método que calcula a média de horas descansadas por semana por meio da
	 * divisão de horas por semanas.
	 *
	 * @return a representação em Double da média de horas descansadas por semana.
	 **/
	public String getStatusGeral() {

		this.mediaDescanso = this.horasDescansadas / this.semanas;

		if (this.mediaDescanso >= 26) {
			return "descansado";
		} else {
			return "cansado";
		}

	}

}
