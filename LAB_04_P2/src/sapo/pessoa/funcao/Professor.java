package sapo.pessoa.funcao;

import java.util.StringJoiner;

import sapo.tarefa.Tarefa;

public class Professor extends Funcao {
	
	private String siape;
	private String[] disciplinas;
	
	public Professor(String siape, String[] disciplinas, int nivelAtual ) {
		super(nivelAtual);
		this.siape = siape;
		this.disciplinas = disciplinas;
	}
	
	public String toString() {
		return String.format("Professor - %s - %s\n", this.siape, disciplinasToString());
	}
	
	private String disciplinasToString() {
		StringJoiner disciplinasString = new StringJoiner(",");
		for (String disciplina : this.disciplinas) {
			disciplinasString.add(disciplina);
		}
		return disciplinasString.toString();
	}
	
	@Override
	public void finalizarTarefa(Tarefa tarefa, String[] habilidade) {
		super.tarefasAbertas.remove(tarefa);
		int cont = 0;
		String[] ArrayVazio = new String[0];
		String[] habilidadesTarefas = (tarefa.getHabilidades() != null)? tarefa.getHabilidades() : ArrayVazio ;
		for (int i = 0; i < habilidadesTarefas.length; i++) {
			for (int j = 0; j < habilidade.length; j++) {
				if(habilidadesTarefas[i].equals(habilidade[j])) {
					super.tarefasFinalizadasComHabilidadesComuns.add(tarefa);
					cont++;
					break;
				}
			}
			if(cont != 0) {
				break;
			}
		}
		
		for (int i = 0; i < habilidadesTarefas.length; i++) {
			for (int j = 0; j < disciplinas.length; j++) {
				if(habilidadesTarefas[i].equals(disciplinas[j])) {
					super.tarefasFinalizadasComHabilidadesComuns.add(tarefa);
					cont++;
					break;
				}
			}
			if(cont != 0) {
				break;
			}
		}
		
	
		if(cont == 0)super.tarefasFinalizadas.add(tarefa);
		
		this.calcularNivel();
	}
	
	
	@Override
	protected void calcularNivel() {
		super.nivel =  super.nivelInicial + (int) (Math.floor(super.tarefasAbertas.size() / 4) +  tarefasFinalizadasComHabilidadesComuns.size());
	}
	
}
