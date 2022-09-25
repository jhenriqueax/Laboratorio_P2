package sapo.busca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import sapo.atividade.Atividade;
import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeRepository;
import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaRepository;
import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaSimples;

public class Busca {

	private PessoaRepository pr;

	private AtividadeRepository ar;
	
	AtividadeController at;

	public Busca(PessoaRepository pessoaRepository, AtividadeRepository atividadeRepository) {

		this.pr = pessoaRepository;
		this.ar = atividadeRepository;
	}

	public List<Pessoa> exibirPessoa(String termo) {

		List<Pessoa> retorno = new ArrayList<>();

		Collection<Pessoa> pessoas = pr.getPessoas().values();

		String[] termoSeparados = termo.split(" ");

		for (Pessoa pessoa : pessoas) {
			int contador = 0;
			for (String termoSep : termoSeparados) {

				String[] nomes = pessoa.getNome().split(" ");
				String[] habilidades = pessoa.getHabilidades();
				String[] arraysJuntos = copiaArrayPessoa(nomes, habilidades);

				for (String compara : arraysJuntos)

					if (termoSep.equalsIgnoreCase(compara)) {

						contador++;

						if (contador == termoSeparados.length) {

							retorno.add(pessoa);
						}
					}
			}
		}

		Collections.sort(retorno, Pessoa.comparator);

		return retorno;
	}

	public List<Atividade> BuscarAtividade(String termo) {

		List<Atividade> retorno = new ArrayList<>();

		Collection<Atividade> atividades = ar.getAtividades().values();

		String[] termoSeparados = termo.split(" ");

		for (Atividade atividade : atividades) {
			int contador = 0;
			for (String termoSep : termoSeparados) {

				String[] descricao = atividade.getDescricao().split(" ");
				String[] nome = atividade.getNome().split(" ");
				String[] codigo = atividade.getCodigo().split("-");
				String[] arraysJuntos = copiaArrayAtividade(descricao, nome, codigo);

				for (String compara : arraysJuntos)

					if (termoSep.equalsIgnoreCase(compara)) {

						contador++;

						if (contador == termoSeparados.length) {

							retorno.add(atividade);
						}
					}
			}
		}

		Collections.sort(retorno, Atividade.comparator);

		return retorno;
	}

	public List<TarefaSimples> buscarTarefa(String termo) {

		List<TarefaSimples> retorno = new ArrayList<>();

		Collection<Atividade> atividades = ar.getAtividades().values();

		for (Atividade atividade : atividades) {

			Collection<Tarefa> tarefas = atividade.getTarefas().values();

			for (Tarefa tarefa : tarefas) {

				String nome = tarefa.getNome();

				if (nome.equalsIgnoreCase(termo)) {
					retorno.add((TarefaSimples) tarefa);
				}

			}
		}
		Collections.sort(retorno, TarefaSimples.comparator);
		return retorno;
	}
	
	public List<Tarefa> buscarTarefa(String IdAtividade, String termo) {

		List<Tarefa> retorno = new ArrayList<>();

		Atividade atividade = ar.getAtividade(IdAtividade);

			Collection<Tarefa> tarefas = atividade.getTarefas().values();

			for (Tarefa tarefa : tarefas) {

				String nome = tarefa.getNome();

				if (nome.equalsIgnoreCase(termo)) {
					retorno.add(tarefa);
				}

			}
			Collections.sort(retorno, TarefaSimples.comparator);
			return retorno;
		
		}

	
	
	public List<Tarefa>  sugerirTarefas(String cpf) {

		List<Tarefa> listTarefas = at.getTodasTarefas();
		String[] habilidadesPessoa = pr.getPessoa(cpf).getHabilidades();
		
		for(Tarefa tarefa : listTarefas)
		{
			String[] habilidadesTarefa = (((TarefaSimples) tarefa).getHabilidades());
			int matchs = contaMatchs(habilidadesPessoa, habilidadesTarefa);
				
			
			
			for(int i = 0; i <= habilidadesPessoa.length; i++){
				
				for(int j = 0; j < habilidadesTarefa.length -1; j++){
					
				//	if(habilidadesTarefa[j] > habilidadesTarefa[j + 1]){
						String aux = habilidadesTarefa[j];
						habilidadesTarefa[j] = habilidadesTarefa[j+1];
						habilidadesTarefa[j+1] = aux;
					}
				}
			}
			return null;
		}		
		
		
	

	
	
	
	
	private int contaMatchs(String[] array1, String[] array2){
		
		int match = 0;
		
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				
				if(array1[i].equals(array2[j])){
					match++;
				}
			}
		}
		
		return match;
	}
	
	private String[] copiaArrayPessoa(String[] array1, String[] array2) {

		int tam1 = array1.length;
		int tam2 = array2.length;

		String[] resultado = new String[array1.length + array2.length];

		System.arraycopy(array1, 0, resultado, 0, tam1);
		System.arraycopy(array2, 0, resultado, tam1, tam2);

		return resultado;
	}

	private String[] copiaArrayAtividade(String[] array1, String[] array2, String[] array3) {

		int tam1 = array1.length;
		int tam2 = array2.length;
		int tam3 = array3.length;

		String[] resultado = new String[array1.length + array2.length + array3.length];

		System.arraycopy(array1, 0, resultado, 0, tam1);
		System.arraycopy(array2, 0, resultado, tam1, tam2);
		System.arraycopy(array3, 0, resultado, tam1 + tam2, tam3);

		return resultado;
	}
}
