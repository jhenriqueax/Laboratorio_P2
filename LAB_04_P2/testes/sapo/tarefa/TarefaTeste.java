package sapo.tarefa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sapo.tarefa.TarefaSimples;


class tarefaTeste {

	TarefaSimples tarefa;

	@BeforeEach
	void setUp() {
		String[] habilidades = {"Mat","Geo","Hist"};
		this.tarefa = new TarefaSimples("123","Atividade 01", habilidades);
	}

	@Test
	void getNomeTeste() {
		assertEquals("Atividade 01", this.tarefa.getNome());
	}

	@Test
	void alteraNomeTeste() {
		this.tarefa.alterarNome("Atividade 02");
		assertEquals("Atividade 02",this.tarefa.getNome());
	}

	@Test
	void getHabilidadeTeste() {
		String[] habilidades = {"Mat","Geo","Hist"};
		assertEquals(habilidades,this.tarefa.getHabilidades());
	}

	@Test
	void alteraHabilidadeTeste() {
		String[] habilidades = {"Geo","Hist"};
		this.tarefa.alterarHabilidade(habilidades);
		assertEquals(habilidades,this.tarefa.getHabilidades());
	}

	@Test
	void aumentarHorasTeste() {
		this.tarefa.adicionarHoras(2);
		assertEquals(2,this.tarefa.getHoras());
	}

	@Test
	void diminuirHorasTeste() {
		this.tarefa.adicionarHoras(5);
		assertEquals(5,this.tarefa.getHoras());
		this.tarefa.removerHoras(2);;
		assertEquals(3,this.tarefa.getHoras());
	}

}
