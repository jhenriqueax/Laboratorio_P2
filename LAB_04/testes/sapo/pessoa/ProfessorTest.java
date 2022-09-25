package sapo.pessoa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sapo.tarefa.TarefaSimples;

class ProfessorTest {

	@Test
	void cadastroProfessor() {
		String habilidades[] = {"Programar em Kotlin"};
		String disciplinas[] = {"P2","LP2","IA","WEB"};
		Pessoa professor = new Pessoa("João Victor", "123.456.789-10", habilidades,"2291146-0",disciplinas);
		Assertions.assertNotNull(professor);
	}

	@Test
	void testToString() {
		String habilidades[] = {"Programar em Kotlin"};
		String disciplinas[] = {"P2","LP2","IA","WEB"};
		Pessoa professor = new Pessoa("João Victor", "123.456.789-10", habilidades,"2291146-0",disciplinas);
		String representacaoPorfessor = "João Victor -123.456.789-10\n"
				+ "Professor - 2291146-0 - P2,LP2,IA,WEB\n"
				+ " - Programar em Kotlin";
		Assertions.assertEquals(professor.toString(),representacaoPorfessor);
		
	}
	
	@Test
	void definirFuncaoProfessor() {
		String habilidades[] = {"Programar em Kotlin"};
		String disciplinas[] = {"P2","LP2","IA","WEB"};
		Pessoa professor = new Pessoa("João Victor", "123.456.789-10", habilidades);
		professor.definirFuncaoProfessor("2291146", disciplinas);
		String representacaoPorfessor = "João Victor -123.456.789-10\n"
				+ "Professor - 2291146 - P2,LP2,IA,WEB\n"
				+ " - Programar em Kotlin";
		System.out.println(professor.toString());
		Assertions.assertEquals(professor.toString(),representacaoPorfessor);
	}
	
	@Test
	void definirFuncaoProfessorJaSendoProfessor() {
		String habilidades[] = {"Programar em Kotlin"};
		String disciplinas[] = {"P2","LP2","IA","WEB"};
		Pessoa professor = new Pessoa("João Victor", "123.456.789-10", habilidades,"2291146-0",disciplinas);
		IllegalStateException exception =  Assertions.assertThrows(IllegalStateException.class, () -> professor.definirFuncaoProfessor("2291146", disciplinas));
		Assertions.assertEquals(exception.getMessage(),"Alteração de estado inválida");
	}
	
	@Test
	void calcularPontuacaoProfessor() {
		String habilidades[] = {"Programar em Java"};
		Pessoa professor = new Pessoa("João Victor", "123.456.789-10", habilidades,"121110750",habilidades);
		TarefaSimples tarefa1 = new TarefaSimples("TVD-0", "Tarefa 1", habilidades);
		TarefaSimples tarefa2 = new TarefaSimples("TVD-2", "Tarefa 2", habilidades);
		TarefaSimples tarefa3 = new TarefaSimples("TVD-3", "Tarefa 3", habilidades);
		professor.adicionarTarefa(tarefa1);
		professor.adicionarTarefa(tarefa2);
		professor.adicionarTarefa(tarefa3);
		professor.finalizarTarefa(tarefa2);
		professor.finalizarTarefa(tarefa3);
		Assertions.assertEquals(2,professor.pegarNivel());
	}
	
	

}
