package sapo.atividade;

import sapo.pessoa.Pessoa;
import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaGerencial;
import sapo.tarefa.TarefaSimples;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Atividade {
	private Pessoa responsavel;
	private String nome;
	private String descricao;
	private String codigo;
	private boolean desativada;
	private boolean encerrada;
	private Map<String,Tarefa> tarefas;
	private int quantidadeTarefas;

	public Atividade(String nome, String descricao, String codigo, Pessoa pessoa) {
		this.nome = nome;
		this.descricao = descricao;
		this.codigo = codigo;
		this.responsavel = pessoa;
		this.desativada = false;
		this.encerrada = false;
		this.tarefas = new HashMap<String,Tarefa>();
		this.quantidadeTarefas = 0;
	}

	public String toString() {
		int quantTotalTarefas = this.tarefas.size();
		int quantTarefasPendentes = this.getQuantidadeTarefasPendentes();
		Tarefa tarefasPendentes[] = this.getPrimeirasTresTarefasPendentes();
		String responsavel = "\n";
		if (!this.responsavel.equals(null)) {
			responsavel += "Responsável: "+ this.responsavel.getNome() + " – " + this.responsavel.getCpf() + "\n";
		}
		String retorno = this.codigo + ": " + this.nome
						   + responsavel
						   + "===\n"
						   + this.descricao
						   + "\n"
						   + "===\n"
						   + "Tarefas: "+ quantTarefasPendentes +"/"+ quantTotalTarefas+ "\n";

						   for (int i = 0; i < tarefasPendentes.length; i++) {
							   if(tarefasPendentes[i] != null) {
								   retorno += tarefasPendentes[i] + "\n";
							   }
						   }

		return retorno.trim();
	}

	private Tarefa[] getPrimeirasTresTarefasPendentes() {
		Tarefa tarefasPendentes[] = new Tarefa[3];
		int index = 0;
		for (int i = 0; i < this.quantidadeTarefas; i++) {
			String codTarefa = this.nome+"-"+i;
			Tarefa tarefa= tarefas.get(codTarefa);

			if(tarefa == null) {
				continue;
			}

			if(tarefa.isPendente()) {
				tarefasPendentes[index] = tarefa;
				index++;
			}
		}

		return tarefasPendentes;
	}

	private int getQuantidadeTarefasPendentes() {
		int index = 0;
		for (int i = 0; i < this.quantidadeTarefas; i++) {
			String codTarefa = this.nome+"-"+i;
			Tarefa tarefa= tarefas.get(codTarefa);

			if(tarefa == null) {
				continue;
			}

			if(tarefa.isPendente()) {
				index++;
			}
		}

		return index;
	}

	public void encerrarAtividade() {
		if(this.desativada == true || this.encerrada == true) {
			throw new IllegalStateException("Alteração de estado inválida");
		}
		this.encerrada = true;
	}

	public void desativarAtividade() {
		if(this.desativada == true || this.encerrada == true) {
			throw new IllegalStateException("Alteração de estado inválida");
		}
		this.desativada = true;
	}

	public void reabrirTarefa() {
		if(this.encerrada == false && this.desativada == false ) {
			throw new IllegalStateException("Alteração de estado inválida");
		}
		this.encerrada = false;
		this.desativada = false;
	}

	public void alterarDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
	}

	public void alterarResponsavelAtividade(Pessoa novaPessoa) {
		this.responsavel = novaPessoa;
	}

	public String adicionarTarefa(String nome, String[] habilidades) {
		if (this.desativada == true || this.encerrada == true) {
			throw new IllegalStateException("Não é possivel inserir tarefas em uma atividade encerrada e desativada");
		}
		String codigoTarefa = this.codigo + "-" + this.quantidadeTarefas;
		this.tarefas.put(codigoTarefa,new TarefaSimples(codigoTarefa, nome, habilidades));
		this.quantidadeTarefas++;

		return codigoTarefa;
	}

	public String adicionarTarefa(String atividadeId, String[] habilidades,String[] idTarefas){
		if (this.desativada == true || this.encerrada == true) {
			throw new IllegalStateException("Não é possivel inserir tarefas em uma atividade encerrada e desativada");
		}
		String codigoTarefa = this.codigo + "-" + this.quantidadeTarefas;
		this.tarefas.put(codigoTarefa,new TarefaGerencial(atividadeId,habilidades,idTarefas));
		this.quantidadeTarefas++;

		return codigoTarefa;
	}

	public TarefaSimples getTarefa(String idTarefa) {
		return (TarefaSimples) this.tarefas.get(idTarefa);
	}

	public String exibirTarefa(String idTarefa) {
		Tarefa tarefa = this.tarefas.get(idTarefa);
		String resultado = "";
		if(tarefa == null) {
			throw new NoSuchElementException("Id da tarefa inválido");
		}

		if (tarefa instanceof TarefaSimples){
			TarefaSimples ts = (TarefaSimples) tarefa;
			resultado = ts.exibirTarefa(this.nome);
		}
		else if (tarefa instanceof TarefaGerencial){
			TarefaGerencial tg = (TarefaGerencial) tarefa;
			resultado = tg.toString();
		}

		return resultado;
	}

	public void removerTarefa(String idTarefa) {
		Tarefa tarefa = this.tarefas.get(idTarefa);
		if(tarefa == null) {
			throw new NoSuchElementException("Id da tarefa inválido");
		}
		this.tarefas.remove(idTarefa);
	}

	public Pessoa getResponsavel() {
		return this.responsavel;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public boolean isDesativada() {
		return desativada;
	}

	public boolean isEncerrada() {
		return encerrada;
	}

	public Map<String, Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(Map<String, Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	 public static Comparator<Atividade> comparator = new Comparator<Atividade>() {

	      public int compare(Atividade atv1, Atividade atv2) {
	            String atividade1 = atv1.getCodigo();
	            String atividade2 = atv2.getCodigo();


	            return atividade1.compareTo(atividade2);

	      }
	 };

	 public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa){
		TarefaGerencial tg = (TarefaGerencial) this.tarefas.get(idTarefaGerencial);
		tg.adicionarTarefa(idTarefa);
	 }

	 public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa){
		TarefaGerencial tg = (TarefaGerencial) this.tarefas.get(idTarefaGerencial);
		tg.removerTarefa(idTarefa);
	 }

	 public String contarTodasTarefaNaTarefaGerencial(String idTarefaGerencial){
		TarefaGerencial tg = (TarefaGerencial) this.tarefas.get(idTarefaGerencial);
		return tg.contarTarefas();
	 }
}
