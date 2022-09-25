package sapo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacedeTarefaTest {
	private Facade facede;

	@BeforeEach
	void iniciar() {
		this.facede = new Facade();
	}

	@Test
	void cadastrarTarefaTeste() {
		String[] habilidades = {"A","B","C"};
		String id = this.facede.cadastrarTarefa("123","TESTE", habilidades);
		assertNotNull(this.facede.exibirTarefa(id));
	}

	@Test
	void alterarNomeTarefaTeste() {
		String[] habilidades = {"A","B","C"};
		String id = this.facede.cadastrarTarefa("123","TESTE", habilidades);
		this.facede.alterarNomeTarefa(id, "NOVO");
		assertTrue(this.facede.exibirTarefa(id).contains("NOVO"));
	}

	@Test
	void alterarHabilidadesTarefaTeste() {
		String[] habilidades = {"A","B","C"};
		String id = this.facede.cadastrarTarefa("123","TESTE", habilidades);
		String[] novasHabilidades = {"D","E","F"};
		assertTrue(this.facede.exibirTarefa(id).contains("[D,E,F]"));
		assertFalse(this.facede.exibirTarefa(id).contains("[A,B,C]"));
	}

	@Test
	void addHoraTarefaTeste() {
		String[] habilidades = {"A","B","C"};
		String id = this.facede.cadastrarTarefa("123","TESTE", habilidades);
		this.facede.addHoraTarefa(id, 3);
		assertTrue(this.facede.exibirTarefa(id).contains("(3hora(s) executada(s))"));
	}

	@Test
	void removerHoraTarefaTeste() {
		String[] habilidades = {"A","B","C"};
		String id = this.facede.cadastrarTarefa("123","TESTE", habilidades);
		this.facede.addHoraTarefa(id, 5);
		this.facede.removerHoraTarefa(id, 2);
		assertTrue(this.facede.exibirTarefa(id).contains("(3hora(s) executada(s))"));
	}
}
