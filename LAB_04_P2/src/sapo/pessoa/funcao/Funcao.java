package sapo.pessoa.funcao;

import java.util.HashSet;
import java.util.Set;

import sapo.tarefa.Tarefa;

public class Funcao implements FuncaoInterface {
	
	protected Set<Tarefa> tarefasAbertas; 
	protected Set<Tarefa> tarefasFinalizadas; 
	protected Set<Tarefa> tarefasFinalizadasComHabilidadesComuns; 
	protected int nivel;
	protected int nivelInicial;
	
	public Funcao(int nivelAtual) {
		this.tarefasAbertas = new HashSet<Tarefa>();
		this.tarefasFinalizadas = new HashSet<Tarefa>();
		this.tarefasFinalizadasComHabilidadesComuns = new HashSet<Tarefa>();
		this.nivelInicial = nivelAtual;
		this.nivel = 0;
	}
	
	public String toString() {
		return "";
	}
	
	public void adicionarTarefa(Tarefa tarefa) {
		this.tarefasAbertas.add(tarefa);
		this.calcularNivel();
	}
	
	public void finalizarTarefa(Tarefa tarefa, String[] habilidade) {
		this.tarefasAbertas.remove(tarefa);
		this.tarefasFinalizadas.add(tarefa);
		
		this.calcularNivel();
	}

	protected void calcularNivel() {
		this.nivel =  this.nivelInicial + (int)(Math.floor(this.tarefasAbertas.size() / 2) + (this.tarefasFinalizadas.size()));
	}
	
	public int getNivel() {
		this.calcularNivel();
		return this.nivel;
	}
}
