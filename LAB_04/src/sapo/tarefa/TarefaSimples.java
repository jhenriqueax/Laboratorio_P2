package sapo.tarefa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TarefaSimples implements Tarefa{

	private String nomeTarefa;
	private List<String> associados;
	private String[] habilidades;
	private int horas;
	private String id;
	private boolean status;



	public TarefaSimples(String atividadeID, String nome, String[] habilidades) {

		List<String> associados = new ArrayList<String>();
		this.associados = associados;
		this.id = atividadeID;
		this.nomeTarefa = nome;
		this.habilidades = habilidades;
		this.horas = 0;
		this.status = true;


	}

	public void alterarNome(String novoNome) {

		this.nomeTarefa = novoNome;
	}

	public void alterarHabilidade(String[] habilidades) {

		this.habilidades = habilidades;
	}

	public void adicionarHoras(int horas) {

		this.horas += horas;
	}

	public void removerHoras(int horas) {

		this.horas -= horas;
	}

	public void concluirTarefa() {

		this.status = false;
	}

	public String exibirTarefa(String nomeAtividade) {

		String retorno = this.nomeTarefa + " - " + this.id + "\n" + nomeAtividade + "\n" + this.habilidades + "\n" + "("
				+ this.horas + "hora(s) executada(s))" + "\n" + "===" + "\n" + "Equipe: " + "\n";

		for (String associado : this.associados) {
			retorno += associado + "\n";
		}
		return retorno;
	}

	public void associarPessoa(String cpf) {

		associados.add(cpf);
	}

	public void removerPessoa(String cpf) {

		associados.remove(cpf);
	}

	public List<String> getAssociados() {

		return this.associados;
	}


	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public boolean isPendente() {

		return !this.status;
	}

	public Boolean getStatus() {

		return this.status;
	}

	@Override
	 public String getId() {
		return id;
	}

	public static Comparator<Tarefa> comparator = new Comparator<Tarefa>() {

	      public int compare(Tarefa t1, Tarefa t2) {
	            String id1 = t1.getId();
	            String id2 = t2.getId();

	            return id1.compareTo(id2);

	      }
	 };

	public String getNome() {

		return this.nomeTarefa;
	}

	public String[] getHabilidades() {

		return this.habilidades;
	}

	public int getHoras() {

		return this.horas;
	}

}