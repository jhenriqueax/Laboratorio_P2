package sapo.pessoa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sapo.atividade.Atividade;
import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaSimples;

class PessoaTest {

	@Test
	void cadastrarPessoa() {
		String habilidades[] = {"Programar em Kotlin"};
		Pessoa pessoa = new Pessoa("Gledson Luan", "123.456.789-10", habilidades);
		Assertions.assertNotNull(pessoa);
	}
	
	@Test
	void verificarToSring() {
		String habilidades[] = {"Programar em Kotlin"};
		Pessoa pessoa = new Pessoa("Gledson Luan", "123.456.789-10", habilidades);
		String representacaoPessoa = "Gledson Luan -123.456.789-10\n"
				+ " - Programar em Kotlin";
		
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
		
	}
	@Test
	void verificarToSringSemHabilidades() {
		String habilidades[] = {};
		Pessoa pessoa = new Pessoa("Gledson Luan", "123.456.789-10", habilidades);
		String representacaoPessoa = "Gledson Luan -123.456.789-10\n";
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
		
	}
	
	@Test
	void alterarNome() {
		String habilidades[] = {};
		Pessoa pessoa = new Pessoa("Gledson Luan", "123.456.789-10", habilidades);
		pessoa.setNome("João Henrique");
		String representacaoPessoa = "João Henrique -123.456.789-10\n";
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
	}
	
	@Test
	void alterarHabilidade() {
		String habilidades[] = {};
		Pessoa pessoa = new Pessoa("Gledson Luan", "123.456.789-10", habilidades);
		String novasHabilidades[] = {"Programar em Kotlin"};
		pessoa.setHabilidades(novasHabilidades);
		String representacaoPessoa = "Gledson Luan -123.456.789-10\n"
				+ " - Programar em Kotlin";
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
	}
	
	@Test
	void calcularNivelSemFuncao() {
		String habilidades[] = {"Programar em Kotlin"};
		Pessoa pessoa = new Pessoa("Gledson Luan", "123.456.789-10", habilidades);
		TarefaSimples tarefa1 = new TarefaSimples("TVD-0", "Tarefa 1", habilidades);
		TarefaSimples tarefa2 = new TarefaSimples("TVD-2", "Tarefa 2", habilidades);
		TarefaSimples tarefa3 = new TarefaSimples("TVD-3", "Tarefa 3", habilidades);
		pessoa.adicionarTarefa(tarefa1);
		pessoa.adicionarTarefa(tarefa2);
		pessoa.adicionarTarefa(tarefa3);
		pessoa.finalizarTarefa(tarefa3);
		Assertions.assertEquals(2,pessoa.pegarNivel());
		
	}

}
