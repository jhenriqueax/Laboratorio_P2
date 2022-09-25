package CoISA;

import java.util.Arrays;

/**
 * Cálculo da média aritmética das notas (nota1 + nota2 + notaX / X) informadas
 * como parametros, bem como o retorno se o aluno conseguiu ser aprovado (média
 * >= 7).
 *
 * @author João Henrique Almeida Xavier
 **/
public class Disciplina {

	/**
	 * Atributo que armazena as hora de estudo dedicado a disciplina.
	 * 
	 **/
	private int horasEstudo;

	/**
	 * Atributo array de notas que armazena as notas passadas pelo usuário.
	 */
	private double[] notas;

	/**
	 * Atributo que armazena o nome da disciplina passado pelo construtor.
	 * 
	 */
	private String nomeDisciplina;

	/**
	 * Contrutor que recebe o nome da disciplina e salva no parametro nome além de
	 * inicializar os meus outros atributos, horas de estudo e notas.
	 * 
	 * @param nome nome da disciplina
	 **/
	public Disciplina(String nome) {
		this.nomeDisciplina = nome;
		this.horasEstudo = 0;
		this.notas = new double[4];

	}

	/**
	 * Método que retorna nome da disciplina, horas de estudo e invoca meu método
	 * privado (media) que calcula a média aritmética e retorna tudo em forma de
	 * string já formatado.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " + this.media() + " " + Arrays.toString(notas);
	}

	/**
	 * Parametro que armazena as horas de estudo informadas pelo usuário no atributo
	 * horas informadas
	 * 
	 * @param horasInformadas horas informadas
	 */
	public void cadastraHoras(int horasInformadas) {
		this.horasEstudo += horasInformadas;
	}

	/**
	 * Método que recebe a qual prova está vinculado aquela nota e o valor da nota.
	 * 
	 * @param nota      prova
	 * @param valorNota valor tirado na prova
	 */
	public void cadastraNota(int nota, double valorNota) {
		if (4 >= nota && nota >= 1) {
			this.notas[nota - 1] = valorNota;
		}

	}

	/**
	 * Método privado que calcula a média aritmética das 4 notas informadas pelo
	 * usuário.
	 * 
	 * @return inteiro com a média das notas
	 */
	private double media() {
		double somaNotas = 0;
		for (double nota : notas) {
			somaNotas += nota;
		}
		return somaNotas / 4;
	}

	/**
	 * Método que retorna um valor booleano verdadeiro se a média aritmética é maior
	 * ou igual a 7.
	 * 
	 * @return valor booleano, true se media >= 7 e false se media < 7.
	 */
	public boolean aprovado() {

		return media() >= 7;

	}
}
