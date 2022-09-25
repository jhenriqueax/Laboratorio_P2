package sapo.pessoa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class PessoaRepository {

	
	Map<String,Pessoa> pessoas;
	
	public PessoaRepository() {
		this.pessoas = new HashMap<String,Pessoa>();
	}
	
	public Map<String, Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void cadastrarPessoa(String nome, String cpf, String[] habilidades) {
		boolean existePessoa = this.hasPessoa(cpf);
		if (existePessoa) {
			throw new IllegalArgumentException("CPF já encontra-se cadastrado no sistema");
		}

		Pessoa pessoa = new Pessoa(nome,cpf,habilidades);
		this.pessoas.put(cpf,pessoa);
	}
	
	public void cadastrarAluno(String cpf, String nome, String matricula, int periodo, String[] habilidades) {
		boolean existePessoa = this.hasPessoa(cpf);
		if (existePessoa) {
			throw new IllegalArgumentException("CPF já encontra-se cadastrado no sistema");
		}

		Pessoa pessoa = new Pessoa(nome, cpf, habilidades, matricula, periodo);
		this.pessoas.put(cpf,pessoa);
	}
	
	public void cadastrarProfessor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades) {
		boolean existePessoa = this.hasPessoa(cpf);
		if (existePessoa) {
			throw new IllegalArgumentException("CPF já encontra-se cadastrado no sistema");
		}

		Pessoa pessoa = new Pessoa(nome, cpf, habilidades, siape, disciplinas);
		this.pessoas.put(cpf,pessoa);
	}

	public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas) {
		Pessoa pessoa = getPessoa(cpf);
		pessoa.definirFuncaoProfessor(siape, disciplinas);
	}
	
	public void definirFuncaoAluno(String cpf, String matricula, int periodo) {
		Pessoa pessoa = getPessoa(cpf);
		pessoa.definirFuncaoAluno(matricula, periodo);
	}
	
	public void removerFuncao(String cpf) {
		Pessoa pessoa = getPessoa(cpf);
		pessoa.removerFuncao();
	}
	
	public int pegarNivel(String cpf) {
		Pessoa pessoa = getPessoa(cpf);
		return pessoa.pegarNivel();
	}
	
	public String listarPessoas() {
	
		Collection<Pessoa> pessoas = this.pessoas.values();
		List<Pessoa> todasPessoas = new ArrayList<>(pessoas);
		Collections.sort(todasPessoas, Pessoa.comparatorCPF);
		Collections.sort(todasPessoas, Pessoa.comparator);
		StringJoiner pessoasString = new StringJoiner("\n");
		for (Pessoa pessoa : todasPessoas) {
			pessoasString.add(pessoa.getNome() + " - " + pessoa.getCpf());
		}
		return pessoasString.toString();
	}
	
	public String exibePessoa(String cpf) {
		return getPessoa(cpf).toString();
	}

	public void alterarNomePessoa(String cpf, String novoNome) {
		Pessoa pessoa = getPessoa(cpf);
		pessoa.setNome(novoNome);
	}

	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		Pessoa pessoa = getPessoa(cpf);
		pessoa.setHabilidades(novasHabilidades);
	}

	public void removerPessoa(String cpf) {
		Pessoa pessoa = pessoas.get(cpf);
		if ( pessoa == null) {
			throw new NoSuchElementException("Nenhuma pessoa encontrada com esse CPF");
		}
		this.pessoas.remove(cpf);
		pessoas.forEach((k,v) -> v.removerComentario(cpf));
	}

	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		Pessoa pessoa = getPessoa(cpf);
		Pessoa pessoaComentario = getPessoa(autorCpf);
		pessoa.adicionarComentario(comentario,pessoaComentario);
	}

	public String listarComentariosPessoa(String cpf) {
		Pessoa pessoa = getPessoa(cpf);
		StringJoiner result = new StringJoiner("\n");
		result.add(pessoa.getNome() + "-" + pessoa.getCpf());
		pessoa.getComentarios().forEach(it -> result.add("--"+it+(pessoas.get(cpf).getNome())));;
		return result.toString();
	}

	public Pessoa getPessoa(String cpf) {
		Pessoa pessoa = pessoas.get(cpf);
		if ( pessoa == null) {
			throw new NoSuchElementException("Nenhuma pessoa encontrada com esse CPF");
		}
		return pessoa;
	}

	public boolean hasPessoa(String cpf) {

		Pessoa pessoa = pessoas.get(cpf);
		if(pessoa == null) {
			return false;
		}
		return true;
	}
}
