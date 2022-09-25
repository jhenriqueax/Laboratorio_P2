package sapo.pessoa.funcao;

import sapo.tarefa.Tarefa;

public interface FuncaoInterface {
	
	public void adicionarTarefa(Tarefa tarefa);
	public void finalizarTarefa(Tarefa tarefa, String[] habilidade);
	public int getNivel();
	

}
