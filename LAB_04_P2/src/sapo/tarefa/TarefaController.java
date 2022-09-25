package sapo.tarefa;

public class TarefaController {

	TarefaService tarefaService;

	public TarefaController(TarefaService ts) {
		this.tarefaService = ts;
	}

	public String cadastrarTarefa(String atividadeID, String nome, String[] habilidades) {

		return this.tarefaService.cadastrarTarefa(atividadeID, nome, habilidades);
	}

	public void alterarNomeTarefa(String idTarefa, String novoNome) {

		this.tarefaService.alterarNomeTarefa(idTarefa, novoNome);
	}

	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {

		this.tarefaService.alterarHabilidadesTarefa(idTarefa, habilidades);
	}

	public void addHoraTarefa(String idTarefa, int horas) {

		this.tarefaService.addHoraTarefa(idTarefa, horas);
	}

	public void removerHoraTarefa(String idTarefa, int horas) {

		this.tarefaService.removerHoraTarefa(idTarefa, horas);
	}

	public String exibirTarefa(String idTarefa){

		return this.tarefaService.exibirTarefa(idTarefa);

	}

	public void concluirTarefa(String idTarefa) {

		this.tarefaService.concluirTarefa(idTarefa);
	}

	public void removerTarefa(String idTarefa) {

		this.tarefaService.removerTarefa(idTarefa);
	}

	public void associarPessoaTarefa(String cpf, String idTarefa) {

		this.tarefaService.associarPessoaTarefa(cpf, idTarefa);
	}

	public void removerPessoaTarefa(String cpf, String idTarefa) {

		this.tarefaService.removerPessoaTarefa(cpf, idTarefa);
	}

	public void cadastrarTarefaGerencial(String atividadeId, String[] habilidades,String[] idTarefas) {
		this.tarefaService.cadastrarTarefaGerencial(atividadeId, habilidades, idTarefas);
	}

	public void adicionarNaTarefaGerencial(String atividadeId, String idTarefaGerencial, String idTarefa) {
		this.tarefaService.adicionarNaTarefaGerencial(atividadeId,idTarefaGerencial,idTarefa);
	}

	public void removerDaTarefaGerencial(String atividadeId, String idTarefaGerencial, String idTarefa) {
		this.tarefaService.removerDaTarefaGerencial(atividadeId, idTarefaGerencial,idTarefa);
	}

	public void contarTodasTarefasNaTarefaGerencial(String atividadeId, String idTarefaGerencial) {
		this.tarefaService.contarTodasTarefasNaTarefaGerencial(atividadeId, idTarefaGerencial);
	}
}
