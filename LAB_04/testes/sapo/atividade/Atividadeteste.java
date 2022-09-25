package sapo.atividade;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sapo.pessoa.Pessoa;
import sapo.tarefa.Tarefa;

class Atividadeteste {
	

	@Test
	void CadastraAtividade() {
		String habilidades[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidades);
	
		
		Atividade atividade = new Atividade("Estudar", "descricao", "STD-0", pessoa);
		Assertions.assertNotNull(atividade);
	}
	
	@Test
	void AlteraDescricao() {
		String habilidades[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidades);
	
		
		Atividade atividade = new Atividade("Estudar", "descrição", "STD-0",pessoa);
		atividade.alterarDescricao("Mudei a descrição");
		String compara = atividade.getDescricao();
		Assertions.assertEquals("Mudei a descrição", compara);
	}
	
	@Test
	void AlteraResponsavel() {
		String habilidades[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidades);
		
		String novoHabilidade[] = {"manipuladora"};
		Pessoa novaPessoa = new Pessoa("Cersei Lannister", "123.456.234-43", novoHabilidade);
	
		
		Atividade atividade = new Atividade("Estudar", "descrição", "STD-0", pessoa);
		atividade.alterarResponsavelAtividade(novaPessoa);
		Pessoa compara = atividade.getResponsavel();
		Assertions.assertEquals(novaPessoa, compara);
	}
	
	@Test
	void DesativaAtividade() {
		String habilidades[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidades);
	
		
		Atividade atividade = new Atividade("Estudar", "descrição", "STD-0", pessoa);
		atividade.desativarAtividade();
		boolean boleano = atividade.isDesativada();
		Assertions.assertTrue(boleano);
	}
	
	@Test
	void EncerrarAtividade() {
		String habilidades[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidades);
	
		
		Atividade atividade = new Atividade("Estudar", "descrição", "STD-0", pessoa);
		atividade.encerrarAtividade();
		boolean boleano = atividade.isEncerrada();
		Assertions.assertTrue(boleano);
	}
	
	@Test
	void CadastrarTarefa() {
		String habilidades[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidades);
	
		
		Atividade atividade = new Atividade("Joao", "descrição", "STD", pessoa);
		String habilidades2[] = {"bla bla bla"};
		String codigo = atividade.adicionarTarefa("MinhaTarefa",habilidades2);
		Assertions.assertEquals("STD-0", codigo);
	}
	
	@Test
	void RemoveTarefa() {
		String habilidadesPessoa[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidadesPessoa);
	
		
		Atividade atividade = new Atividade("Estudar", "descrição", "STD", pessoa);
		String habilidades[] = {"bla bla bla"};
		atividade.adicionarTarefa("MinhaTarefa1",habilidades);
		atividade.adicionarTarefa("MinhaTarefa2",habilidades);
		atividade.adicionarTarefa("MinhaTarefa3",habilidades);
		atividade.adicionarTarefa("MinhaTarefa4",habilidades);
		atividade.removerTarefa("STD-3");
		atividade.removerTarefa("STD-2");
		int qntTarefas = atividade.getTarefas().size();
		Assertions.assertEquals(2 , qntTarefas);
	}
	
	@Test
	void ToString() {
		
		String habilidades[] = {"Ser Escroto"};
		Pessoa pessoa = new Pessoa("Jofrey Lannister", "123.456.789-10", habilidades);
	
		
		Atividade atividade = new Atividade("Estudar", "descrição", "STD-0", pessoa);
		String compara = atividade.toString();
		String teste = "STD-0: Estudar\n"
				+ "Responsável: Jofrey Lannister – 123.456.789-10\n"
				+ "===\n"
				+ "descrição\n"
				+ "===\n"
				+ "Tarefas: 0/0";
		Assertions.assertEquals(compara , teste);
	}
}