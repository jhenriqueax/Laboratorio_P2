package sapo.tarefa;

import java.util.ArrayList;
import sapo.atividade.Atividade;
import sapo.atividade.AtividadeRepository;

public class TarefaService {

	private AtividadeRepository atividadeRepository;

	private String pegaIdAtividade(String idTarefa) {

		return idTarefa.substring(0, 4);
	}

	public String cadastrarTarefa(String atividadeID, String nome, String[] habilidades) {

		Atividade atividade = this.atividadeRepository.getAtividade(atividadeID);

		return atividade.adicionarTarefa(nome, habilidades);
	}

	public void alterarNomeTarefa(String idTarefa, String novoNome) {

		Tarefa tarefa = getTarefa(idTarefa);

		tarefa.alterarNome(novoNome);
	}

	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {

		TarefaSimples tarefa = (TarefaSimples) getTarefa(idTarefa);

		tarefa.alterarHabilidade(habilidades);
	}

	public void addHoraTarefa(String idTarefa, int horas) {

		TarefaSimples tarefa = (TarefaSimples) getTarefa(idTarefa);

		tarefa.adicionarHoras(horas);
	}

	public void removerHoraTarefa(String idTarefa, int horas) {

		TarefaSimples tarefa = (TarefaSimples) getTarefa(idTarefa);

		tarefa.removerHoras(horas);
	}

	public String exibirTarefa(String idTarefa){

		String cod = this.pegaIdAtividade(idTarefa);

		Atividade atividade = this.atividadeRepository.getAtividade(cod);

		return atividade.exibirTarefa(idTarefa);
	}

	public void concluirTarefa(String idTarefa) {

		TarefaSimples tarefa = (TarefaSimples) getTarefa(idTarefa);

		tarefa.concluirTarefa();
	}

	public void removerTarefa(String idTarefa) {

		String cod = this.pegaIdAtividade(idTarefa);

		Atividade atividade = this.atividadeRepository.getAtividade(cod);

		atividade.removerTarefa(idTarefa);
	}

	public void associarPessoaTarefa(String cpf, String idTarefa) {

		TarefaSimples tarefa = (TarefaSimples) getTarefa(idTarefa);

		tarefa.associarPessoa(cpf);
	}

	public void removerPessoaTarefa(String cpf, String idTarefa) {

		TarefaSimples tarefa = (TarefaSimples) getTarefa(idTarefa);

		ArrayList<String> associados = tarefa.getAssociados();

		for (String associado : associados) {

			if (associado.equals(cpf)) {

				tarefa.removerPessoa(cpf);

			}
		}
	}

	private Tarefa getTarefa(String idTarefa) {

		String codigoAtividade = this.pegaIdAtividade(idTarefa);
		Atividade atividade = this.atividadeRepository.getAtividade(codigoAtividade);

		TarefaSimples tarefa = atividade.getTarefa(idTarefa);


		return tarefa;
	}

	public String cadastrarTarefaGerencial(String atividadeId, String[] habilidades,String[] idTarefas) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeId);

		return atividade.adicionarTarefa(atividadeId, habilidades, idTarefas);
	}

	public void adicionarNaTarefaGerencial(String atividadeId, String idTarefaGerencial, String idTarefa) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeId);

		atividade.adicionarNaTarefaGerencial(idTarefaGerencial,idTarefa);
	}

	public void removerDaTarefaGerencial(String atividadeId, String idTarefaGerencial, String idTarefa) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeId);

		atividade.removerDaTarefaGerencial(idTarefaGerencial,idTarefa);
	}

	public String contarTodasTarefasNaTarefaGerencial(String atividadeId, String idTarefaGerencial) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeId);

		return atividade.contarTodasTarefaNaTarefaGerencial(idTarefaGerencial);
	}
}
