package sapo.tarefa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarefaGerencial implements Tarefa{

	private String nome;
	private String id;
	private List<String> habilidades;
	private List<TarefaSimples> tarefas;

	public TarefaGerencial(String atividadeId, String[] habilidades,List<TarefaSimples>[] idTarefas) {
		this.id = atividadeId;
		this.habilidades = new ArrayList<String>();
		for (String habilidade: habilidades) {
			this.habilidades.add(habilidade);
		}
		this.tarefas = new ArrayList<TarefaSimples>();
		for (TarefaSimples ts: tarefas) {
			this.tarefas.add(ts);
		}
	}

	public void adicionarTarefa(TarefaSimples tarefa) {
		this.tarefas.add(tarefa);
	}

	public void removerTarefa(TarefaSimples tarefa) {
		this.tarefas.remove(tarefa);
	}

	public String contarTarefas() {
		return String.valueOf(this.tarefas.size());
	}

	@Override
	public void alterarNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean isPendente() {
		boolean result = false;
		for (Tarefa tarefa: tarefas){
			result = tarefa.isPendente();
		}
		return result;
	}

	@Override
	public String[] getHabilidades() {

		List<List<String>> habilidades = new ArrayList<List<String>>();
		for (int i = 0; i < this.tarefas.size(); i++){
			TarefaSimples tarefaH = this.tarefas.get(i);
			habilidades.add(Arrays.asList(tarefaH.getHabilidades()));
		}
		String[] result = habilidades.stream().toArray(String[]::new);
		return result;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getNome() {
		return this.nome;
	}
}
