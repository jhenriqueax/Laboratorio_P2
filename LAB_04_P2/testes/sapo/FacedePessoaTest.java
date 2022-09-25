package sapo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacedePessoaTest {
	private Facade facede;
	
	@BeforeEach
	void iniciar() {
		this.facede = new Facade();
	}
	
	@Test
	void cadastrarPessoa() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		String pessoa = this.facede.exibirPessoa("123.456.789-10");
		Assertions.assertNotNull(pessoa);
	}
	
	@Test
	void cadastrarPessoaNomeNull() {
		String habilidades[] = {"Programar em Kotlin"};
		IllegalArgumentException exception =  Assertions.assertThrows(IllegalArgumentException.class, () -> this.facede.cadastrarPessoa("", "123.456.789-10", habilidades));
		Assertions.assertEquals(exception.getMessage(),"Nome e Cpf não podem estar vazios");
	}
	
	@Test
	void cadastrarPessoaCPFNull() {
		String habilidades[] = {"Programar em Kotlin"};
		IllegalArgumentException exception =  Assertions.assertThrows(IllegalArgumentException.class, () -> this.facede.cadastrarPessoa("Gledson Luan", "", habilidades));
		Assertions.assertEquals(exception.getMessage(),"Nome e Cpf não podem estar vazios");
	}
	
	@Test
	void cadastrarPessoaComCPFJaExistente() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		IllegalArgumentException exception =  Assertions.assertThrows(IllegalArgumentException.class, () -> this.facede.cadastrarPessoa("João Henrique", "123.456.789-10", habilidades));
		Assertions.assertEquals(exception.getMessage(),"CPF já encontra-se cadastrado no sistema");
	}
	
	@Test
	void exibirPessoa() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		String pessoa = this.facede.exibirPessoa("123.456.789-10");
		String representacaoPessoa = "Gledson Luan -123.456.789-10\n"
				+ " - Programar em Kotlin";
		
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
	}
	
	@Test
	void exibirPessoaCPFInvalido() {
		NoSuchElementException exception =  Assertions.assertThrows(NoSuchElementException.class, () -> this.facede.exibirPessoa("123.456.789-10"));
		Assertions.assertEquals(exception.getMessage(),"Nenhuma pessoa encontrada com esse CPF");
	}
	
	@Test
	void alterarNomePessoa() {
		String habilidades[] = {};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		this.facede.alterarNomePessoa("123.456.789-10", "João Henrique");
		String representacaoPessoa = "João Henrique -123.456.789-10\n";
		String pessoa = this.facede.exibirPessoa("123.456.789-10");
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
	}
	
	@Test
	void alterarNomePessoaNull() {
		String habilidades[] = {};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		IllegalArgumentException exception =  Assertions.assertThrows(IllegalArgumentException.class, () -> this.facede.alterarNomePessoa("123.456.789-10", ""));
		Assertions.assertEquals(exception.getMessage(),"Nome não pode estar vazio");
	}
	
	@Test
	void alterarHabilidadePessoa() {
		String habilidades[] = {};
		String novasHabilidades[] = {"Programar em Kotlin"};
		
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		this.facede.alterarHabilidadesPessoa("123.456.789-10", novasHabilidades);
		
		String pessoa = this.facede.exibirPessoa("123.456.789-10");
		String representacaoPessoa = "Gledson Luan -123.456.789-10\n"
				+ " - Programar em Kotlin";
		
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
	}
	
	@Test
	void alterarHabilidadePessoaHabilidadeNull() {
		String habilidades[] = {"Programar em Kotlin"};
		String novasHabilidades[] = {};
		
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		this.facede.alterarHabilidadesPessoa("123.456.789-10", novasHabilidades);
		
		String pessoa = this.facede.exibirPessoa("123.456.789-10");
		String representacaoPessoa = "Gledson Luan -123.456.789-10\n";
		Assertions.assertEquals(pessoa.toString(),representacaoPessoa);
	}
	
	
	@Test
	void removerPessoa() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		this.facede.removerPessoa("123.456.789-10");
		NoSuchElementException exception =  Assertions.assertThrows(NoSuchElementException.class, () -> this.facede.exibirPessoa("123.456.789-10"));
		Assertions.assertEquals(exception.getMessage(),"Nenhuma pessoa encontrada com esse CPF");
		
	}
	
	@Test
	void removerPessoaCPFInvalido() {
		NoSuchElementException exception =  Assertions.assertThrows(NoSuchElementException.class, () -> this.facede.removerPessoa("123.456.789-10"));
		Assertions.assertEquals(exception.getMessage(),"Nenhuma pessoa encontrada com esse CPF");
	}
	
	/*@Test
	void adicionarComentarioPessoa() {
		this.facede.cadastrarPessoa("Gledson Luan", "111.111.111-11", null);
		this.facede.cadastrarPessoa("João Henrique", "222.222.222-22", null);
		this.facede.adicionarComentarioPessoa("111.111.111-11", "Comentario teste","222.222.222-22" );
		String comentariosPessoa = "Gledson Luan – 111.111.111-11\n"+
								   "Comentários:\n"+
								   "-- Comentário teste (João Henrique)";
		System.out.println(this.facede.listarComentariosPessoa("111.111.111-11"));
		Assertions.assertEquals(comentariosPessoa,this.facede.listarComentariosPessoa("111.111.111-11"));
	}*/
	
	@Test
	void cadastrarAluno() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarAluno("Gledson Luan", "123.456.789-10","000001",1, habilidades);
		String pessoa = this.facede.exibirPessoa("123.456.789-10");
		Assertions.assertNotNull(pessoa);
	}
	
	@Test
	void exibirAluno() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarAluno("Gledson Luan", "123.456.789-10","000001",1, habilidades);
		String aluno = this.facede.exibirPessoa("123.456.789-10");
		String representacaoAluno = "Gledson Luan -123.456.789-10\n"
				+ "Aluno - 000001 - 1\n"
				+ " - Programar em Kotlin";
		Assertions.assertEquals(aluno,representacaoAluno);
	}
	
	@Test
	void cadastrarProfessor() {
		String habilidades[] = {"Programar em Kotlin", "Progamar em java"};
		String disciplinas[] = {"P2", "LP2", "WEB"};
		this.facede.cadastrarProfessor("Gledson Luan", "123.456.789-10","000001",disciplinas, habilidades);
		String pessoa = this.facede.exibirPessoa("123.456.789-10");
		Assertions.assertNotNull(pessoa);
	}
	
	
	@Test
	void exibirProfessor() {
		String habilidades[] = {"Programar em Kotlin", "Progamar em java"};
		String disciplinas[] = {"P2", "LP2", "WEB"};
		this.facede.cadastrarProfessor("Gledson Luan", "123.456.789-10","000001",disciplinas, habilidades);
		String professor = this.facede.exibirPessoa("123.456.789-10");
		String representacaoProfessor = "Gledson Luan -123.456.789-10\n"
				+ "Professor - 000001 - P2,LP2,WEB\n"
				+ " - Progamar em java\n"
				+ " - Programar em Kotlin";
		Assertions.assertEquals(professor,representacaoProfessor);
	}
	
	
	@Test
	void definirFuncaoProfessor() {
		String habilidades[] = {"Programar em Kotlin", "Progamar em java"};
		String disciplinas[] = {"P2", "LP2", "WEB"};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		this.facede.definirFuncaoProfessor("123.456.789-10", "000001", disciplinas);
		String professor = this.facede.exibirPessoa("123.456.789-10");
		String representacaoProfessor = "Gledson Luan -123.456.789-10\n"
				+ "Professor - 000001 - P2,LP2,WEB\n"
				+ " - Progamar em java\n"
				+ " - Programar em Kotlin";
		Assertions.assertEquals(professor,representacaoProfessor);
	}
	
	@Test
	void definirFuncaoAluno() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		this.facede.definirFuncaoAluno("123.456.789-10", "000001", 1);
		String aluno = this.facede.exibirPessoa("123.456.789-10");
		String representacaoAluno = "Gledson Luan -123.456.789-10\n"
				+ "Aluno - 000001 - 1\n"
				+ " - Programar em Kotlin";
		Assertions.assertEquals(aluno,representacaoAluno);
		
	}
	
	
	@Test
	void listarPessoas() {
		String habilidades[] = {"Programar em Kotlin"};
		this.facede.cadastrarPessoa("João Victor" , "101.876.543-21", habilidades);
		this.facede.cadastrarPessoa("João Victor" , "109.876.543-21", habilidades);
		this.facede.cadastrarPessoa("Gledson Luan", "123.456.789-10", habilidades);
		this.facede.cadastrarPessoa("João Henrique","111.111.111-11", habilidades);
		String pessoas = this.facede.listarPessoas();
		String representacaoPessoas = "Gledson Luan - 123.456.789-10\n"
				+ "João Henrique - 111.111.111-11\n"
				+ "João Victor - 109.876.543-21\n"
				+ "João Victor - 101.876.543-21";
		
		Assertions.assertEquals(pessoas,representacaoPessoas);
	}
}
