package sapo.atividade;

import java.util.List;

import sapo.tarefa.Tarefa;

public class AtividadeController {
	
	private AtividadeService atividadeService;
	
	public AtividadeController(AtividadeService as) {
		this.atividadeService = as;
	}

	public List<Tarefa> getTodasTarefas(){
		
		return this.atividadeService.getTodasTarefas();
	}
	
	
	public String cadastrarAtividade(String nome, String descricao, String cpfResponsavel) 
	{
		if (nome.isBlank() || nome == null) {
			throw new IllegalArgumentException("Nome da atividade não pode ser vazio");
		}
		if (descricao.isBlank() || descricao == null) {
			throw new IllegalArgumentException("Descrição da atividade não pode ser vazio");
		}
		if (cpfResponsavel.isBlank() || cpfResponsavel == null) {
			throw new IllegalArgumentException("Uma atividade não pode ser cadastrada sem um responsável");
		}
		
		return this.atividadeService.cadastrarAtividade(nome, descricao, cpfResponsavel);
	}
	
	public void encerrarAtividade(String atividadeID) 
	{
		if (atividadeID.isBlank() || atividadeID == null) {
			throw new IllegalArgumentException("O id da atividade não pode ser vazio");
		}
		this.atividadeService.encerrarAtividade(atividadeID);
	}
	
	public void desativarAtividade(String atividadeID) 
	{
		if (atividadeID.isBlank() || atividadeID == null) {
			throw new IllegalArgumentException("O id da atividade não pode ser vazio");
		}
		this.atividadeService.desativarAtividade(atividadeID);
	}
	
	public void reabrirAtividade(String atividadeID) 
	{
		if (atividadeID.isBlank() || atividadeID == null) {
			throw new IllegalArgumentException("O id da atividade não pode ser vazio");
		}
		
		this.atividadeService.reabrirAtividade(atividadeID);
	}
	
	public String exibirAtividade(String atividadeID) 
	{
		if (atividadeID.isBlank() || atividadeID == null) {
			throw new IllegalArgumentException("O id da atividade não pode ser vazio");
		}
		return this.atividadeService.exibirAtividade(atividadeID);
	}
	
	public void alterarDescricaoAtividade(String atividadeID, String descricao) 
	{
		if (atividadeID.isBlank() || atividadeID == null) {
			throw new IllegalArgumentException("O id da atividade não pode ser vazio");
		}
		if (descricao.isBlank() || descricao == null) {
			throw new IllegalArgumentException("Descrição da atividade não pode ser vazio");
		}
		
		this.atividadeService.alterarDescricaoAtividade(atividadeID, descricao);
	}
	
	public void alterarResponsavelAtividade(String atividadeID, String cpfResponsavel) 
	{
		if (atividadeID.isBlank()) {
			throw new IllegalArgumentException("O id da atividade não pode ser vazio");
		}
		this.atividadeService.alterarResponsavelAtividade(atividadeID, cpfResponsavel);
	}
}
