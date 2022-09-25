package CoISA;

import java.util.ArrayList;
import java.util.List;

//Usando github


/**
 * Registro de atividades complementares como: Estágios, projetos e Cursos, por
 * meio, dessa classe é possivel registrar tais atividades, bem como, calcular a
 * quatidade de créditos recebidos respectivamente (Projetos 3meses/5c),
 * (Estagios 300h/5c) e (Cursos 30h/1c).
 * 
 * @author João Henrique Almeida Xavier
 */
public class AtividadesComplementares {

	/**
	 * Atributo que armazena as horas de estágio e salva na forma de um array de
	 * tamanho 9
	 **/
	private String[] horasEstagio;
	/**
	 * Atributo que armazena os créditos de estágio na forma de uma String
	 * ("Creditos_Estagio " + valor)
	 */
	private String creditosEstagio;
	/**
	 * Atributo que armazena os créditos de estágio na forma de um inteiro
	 */
	private int creditosEstagioInt;

	/**
	 * Atributo que armazena as horas de projetos e salva na forma de um array de
	 * tamanho 16
	 **/
	private String[] horasProjetos;
	/**
	 * Atributo que armazena os créditos de projetos na forma de uma String
	 * ("Creditos_projeto " + valor)
	 */
	private String creditosProjetos;
	/**
	 * Atributo que armazena os créditos de projeto na forma de um inteiro.
	 */
	private int creditosProjetosInt;

	/**
	 * Atributo que armazena as horas de curso e salva na forma de um array de
	 * tamanho 1
	 **/
	private String[] horasCurso;
	/**
	 * Atributo que recebe os créditos do curso na forma de uma String
	 * ("Creditos_Cursos " + valor)
	 */
	private String creditosCurso;
	/**
	 * Atributo que armazena os créditos do curso na foma de inteiro
	 */
	private int creditosCursoInt;
	/**
	 * Atributo que armazen as horas do curso na forma de um double.
	 */
	private double horasCursoDouble;

	/**
	 * Atributo contador que auxilia em algumas operanções dentro dos métodos.
	 */
	private int contI;
	/**
	 * Atributo contador que auxilia em algumas operanções dentro dos métodos.
	 */
	private int contJ;

	/**
	 * Construtor que inicializa todos os atributos com os valores padrões.
	 */
	public AtividadesComplementares() {
		this.horasEstagio = new String[9];
		this.creditosEstagio = "";
		this.creditosEstagioInt = 0;
		this.horasProjetos = new String[16];
		this.creditosProjetos = "";
		this.creditosProjetosInt = 0;
		this.horasCurso = new String[1];
		this.creditosCurso = "";
		this.creditosCursoInt = 0;
		this.horasCursoDouble = 0;
		this.contI = 0;
		this.contJ = 0;
	}

	/**
	 * Método que recebe horas do estágio como parametro e passar para o array
	 * respectivo o valor já formatado, além de calcular a quatidade de créditos
	 * adquiridos e devolver a respectiva string já formatado.
	 * 
	 * @param horas
	 */
	public void adicionarEstagio(int horas) {

		this.horasEstagio[contI] = "Estagio " + horas;
		contI += 1;
		this.creditosEstagioInt += (horas / 300) * 5;
		this.creditosEstagio = "Creditos_Estagio " + creditosEstagioInt;
	}

	/**
	 * Método que recebe meses de projeto como parametro e passar para o array
	 * respectivo o valor já formatado, além de calcular a quatidade de créditos
	 * adquiridos e devolver a respectiva string já formatado.
	 * 
	 * @param meses
	 */
	public void adicionarProjeto(int meses) {

		this.horasProjetos[contJ] = "projeto " + meses;
		contJ += 1;
		this.creditosProjetosInt += (meses / 3) * 2;
		this.creditosProjetos = "Creditos_Projeto " + this.creditosProjetosInt;
	}

	/**
	 * Método que recebe horas de curso como parametro e passar para o array
	 * respectivo o valor já formatado, além de calcular a quatidade de créditos
	 * adquiridos e devolver a respectiva string já formatado.
	 * 
	 * @param horas
	 */
	public void adicionarCurso(double horas) {

		this.horasCursoDouble += horas;
		this.horasCurso[0] = "curso " + this.horasCursoDouble;
		this.creditosCursoInt = (int) (this.horasCursoDouble / 30);
		this.creditosCurso = "Creditos_Cursos " + this.creditosCursoInt;
	}

	/**
	 * Método que realiza a soma de todos os créditos adquiridos pelo estudante
	 * créditos de estágio + créditos de projetos + créditos de curso.
	 * 
	 * @return inteiro com a soma de todos os créditos.
	 */
	public int contaCreditos() {
		int retorno = this.creditosEstagioInt + this.creditosProjetosInt + this.creditosCursoInt;
		return retorno;
	}

	/**
	 * Método que inicialmente cria um arraylist chamado "retorno" que por meio de
	 * interações do for, vai recebendo os arrays de horas de estágio, horas de
	 * projeto e horas de curso, já criados anteriormente, em seguida recebe os
	 * valoes dos créditos, por fim o método transforma o arraylist em um array e
	 * retorna para o main.
	 * 
	 * @return array de String com a formatação solicitada pelo exercício
	 */
	public String[] pegaAtividades() {

		List<String> retorno = new ArrayList<String>();

		for (int i = 0; i < this.contI; i++) {
			retorno.add(horasEstagio[i]);
		}

		for (int i = 0; i < this.contJ; i++) {
			retorno.add(horasProjetos[i]);
		}

		for (int i = 0; i < horasCurso.length; i++) {
			if (horasCurso[i] != null) {
				retorno.add(horasCurso[i]);
			}

			retorno.add(creditosEstagio);
			retorno.add(creditosProjetos);
			retorno.add(creditosCurso);

		}

		String[] array = retorno.toArray(new String[0]);

		return array;

	}

}
