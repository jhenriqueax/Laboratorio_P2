package sapo.pessoa;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import sapo.pessoa.funcao.Aluno;
import sapo.pessoa.funcao.Funcao;
import sapo.pessoa.funcao.FuncaoInterface;
import sapo.pessoa.funcao.Professor;
import sapo.tarefa.Tarefa;

public class Pessoa {

	private String nome;
	private String cpf;
	private String[] habilidades;
	private List<Comentario> comentarios;
	private FuncaoInterface funcao;
	private int nivel;
	

	public Pessoa(String nome, String cpf, String[] habilidades) {
		this.nome = nome;
		this.cpf = cpf;
		this.habilidades = habilidades;
		this.nivel = 0;
		this.comentarios = new ArrayList<Comentario>();
		this.funcao = new Funcao(this.nivel);
		
	}
	
	public Pessoa(String nome, String cpf, String[] habilidades, String matricula, int periodo ) {
		this.nome = nome;
		this.cpf = cpf;
		this.habilidades = habilidades;
		this.nivel = 0;
		this.comentarios = new ArrayList<Comentario>();
		this.funcao = new Aluno(matricula, periodo, this.nivel);
	}
	
	public Pessoa(String nome, String cpf, String[] habilidades, String siape, String[] disciplinas ) {
		this.nome = nome;
		this.cpf = cpf;
		this.habilidades = habilidades;
		this.nivel = 0;
		this.comentarios = new ArrayList<Comentario>();
		this.funcao = new Professor(siape, disciplinas, this.nivel);
	}

	public String toString() {
		return String.format("%s -%s\n%s%s", this.nome, this.cpf, this.funcao.toString()  , habilidadesToString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf);
	}

	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	public void setHabilidades(String[] novasHabilidades) {
		this.habilidades = novasHabilidades;
	}

	public String[] getHabilidades() {
		return this.habilidades;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCpf(String novoCpf) {
		this.cpf = novoCpf;
	}

	public void removerComentario(String cpf) {
		List<Comentario> novosComentarios = this.comentarios.stream()
					.filter((x) -> x.getAutorCpf() != cpf)
					 .collect(Collectors.toList());
		this.comentarios = novosComentarios;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void adicionarComentario(String comentario, Pessoa autor) {
		this.comentarios.add(new Comentario(comentario,autor, System.currentTimeMillis()));
	}

	private String habilidadesToString() {
		StringJoiner result = new StringJoiner("\n");
		String [] hb = this.habilidades;
		Arrays.sort(hb);
		for (String habilidade : hb) {
			result.add(" - " + habilidade);
		}
		return result.toString();
	}
	
	public static Comparator<Pessoa> comparatorCPF = new Comparator<Pessoa>() {
		  
	      public int compare(Pessoa p1, Pessoa p2) {
	            String nomePessoa1 = p1.getCpf();
	            String nomePessoa2 = p2.getCpf().toUpperCase();
	            return nomePessoa1.compareTo(nomePessoa2);
	      }
	 };

	public static Comparator<Pessoa> comparator = new Comparator<Pessoa>() {
		  
	      public int compare(Pessoa p1, Pessoa p2) {
	            String nomePessoa1 = p1.getNome().toUpperCase();
	            String nomePessoa2 = p2.getNome().toUpperCase();
	            return nomePessoa1.compareTo(nomePessoa2);
	      }
	 };
	 
	public void definirFuncaoProfessor(String siape, String[] disciplinas ) {
		if(this.funcao instanceof Professor) {
			throw new IllegalStateException("Alteração de estado inválida");
		}
		this.removerFuncao();
		this.funcao = new Professor(siape, disciplinas, this.nivel);
	}
	
	public void definirFuncaoAluno(String matricula, int periodo ) {
		if(this.funcao instanceof Aluno) {
			throw new IllegalStateException("Alteração de estado inválida");
		}
		this.removerFuncao();
		this.funcao = new Aluno(matricula, periodo, this.nivel);
	}
	
	public void removerFuncao() {
		this.nivel = funcao.getNivel();
		this.funcao = new Funcao(this.nivel);
	}
	
	public int pegarNivel() {
		this.nivel = funcao.getNivel();
		return this.nivel;
	}
	
	public void adicionarTarefa(Tarefa tarefa) {
		this.funcao.adicionarTarefa(tarefa);
	}
	
	public void finalizarTarefa(Tarefa tarefa) {
		this.funcao.finalizarTarefa(tarefa, this.habilidades);
	}
	
}
