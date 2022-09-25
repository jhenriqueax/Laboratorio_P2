package sapo.pessoa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sapo.tarefa.TarefaSimples;

class AlunoTest {

	@Test
	void cadastrarAluno() {
		String habilidades[] = {"Programar em Java"};
		Pessoa aluno = new Pessoa("João Victor", "123.456.789-10", habilidades,"121110750",2);
		Assertions.assertNotNull(aluno);
	}

	@Test
	void testToString() {
		String habilidades[] = {"Programar em Java"};
		Pessoa aluno = new Pessoa("João Victor", "123.456.789-10", habilidades,"0000001",2);
		String representacao = "João Victor -123.456.789-10\n"
				+ "Aluno - 0000001 - 2\n"
				+ " - Programar em Java";
		Assertions.assertEquals(aluno.toString(),representacao);
	}
	@Test
	void definirFuncaoAluno() {
		String habilidades[] = {"Programar em Kotlin"};
		Pessoa aluno = new Pessoa("João Victor", "123.456.789-10", habilidades);
		aluno.definirFuncaoAluno("000001", 2);
		String representacaoPorfessor = "João Victor -123.456.789-10\n"
				+ "Aluno - 000001 - 2\n"
				+ " - Programar em Kotlin";
		Assertions.assertEquals(aluno.toString(),representacaoPorfessor);
	}
	
	@Test
	void calcularPontuacaoAluno() {
		String habilidades[] = {"Programar em Java"};
		Pessoa aluno = new Pessoa("João Victor", "123.456.789-10", habilidades,"121110750",2);
		TarefaSimples tarefa1 = new TarefaSimples("TVD-0", "Tarefa 1", habilidades);
		TarefaSimples tarefa2 = new TarefaSimples("TVD-2", "Tarefa 2", habilidades);
		TarefaSimples tarefa3 = new TarefaSimples("TVD-3", "Tarefa 3", habilidades);
		aluno.adicionarTarefa(tarefa1);
		aluno.adicionarTarefa(tarefa2);
		aluno.adicionarTarefa(tarefa3);
		aluno.finalizarTarefa(tarefa2);
		aluno.finalizarTarefa(tarefa3);
		Assertions.assertEquals(3,aluno.pegarNivel());
	}
	
	
	@Test
	void calcularPontuacaoPessoaParaAluno() {
		String habilidades[] = {"Programar em Java"};
		Pessoa aluno = new Pessoa("João Victor", "123.456.789-10", habilidades);
		TarefaSimples tarefa1 = new TarefaSimples("TVD-0", "Tarefa 1", habilidades);
		TarefaSimples tarefa2 = new TarefaSimples("TVD-2", "Tarefa 2", habilidades);
		TarefaSimples tarefa3 = new TarefaSimples("TVD-3", "Tarefa 3", habilidades);
		aluno.adicionarTarefa(tarefa1);
		aluno.adicionarTarefa(tarefa2);
		aluno.adicionarTarefa(tarefa3);
		aluno.finalizarTarefa(tarefa2);
		aluno.definirFuncaoAluno("121110750",2);
		TarefaSimples tarefa4 = new TarefaSimples("TVD-4", "Tarefa 1", habilidades);
		TarefaSimples tarefa5 = new TarefaSimples("TVD-5", "Tarefa 2", habilidades);
		TarefaSimples tarefa6 = new TarefaSimples("TVD-6", "Tarefa 3", null)  ;
		aluno.adicionarTarefa(tarefa4);
		aluno.adicionarTarefa(tarefa5);
		aluno.adicionarTarefa(tarefa6);
		aluno.finalizarTarefa(tarefa6);
		
		Assertions.assertEquals(5,aluno.pegarNivel());
	}
	

}
