package sapo.pessoa.funcao;

import sapo.tarefa.Tarefa;

public class Aluno extends Funcao {
	
	private String matricula;
	private int periodo;
	
	public Aluno(String matricula, int periodo, int nivelAtual ) {
		super(nivelAtual);
		this.matricula = matricula;
		this.periodo = periodo;
	}
	
	public String toString() {
		return String.format("Aluno - %s - %d\n", this.matricula, this.periodo);
	}
	
	@Override
	protected void calcularNivel() {
		super.nivel =  super.nivelInicial + (int) (Math.floor(super.tarefasAbertas.size() / 2) +  Math.round(tarefasFinalizadasComHabilidadesComuns.size() * 1.5) + (super.tarefasFinalizadas.size()));
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
		
		if(cont == 0) super.tarefasFinalizadas.add(tarefa);
		
		this.calcularNivel();
	}
	
}
