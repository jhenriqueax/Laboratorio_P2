package sapo.atividade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaRepository;
import sapo.tarefa.Tarefa;
import sapo.util.PalavraUtil;

public class AtividadeService {
	
	
	private AtividadeRepository atividadeRepository ;
	private PessoaRepository pessoaRepository;
	
	public AtividadeService(AtividadeRepository atividadeRepository, PessoaRepository pr){
		this.atividadeRepository =  atividadeRepository;
		this.pessoaRepository = pr;
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpfResponsavel) {
		String codigoAtividade = this.gerarCodigoAtividade(nome);
		Pessoa responsavel = this.validaResponsavel(cpfResponsavel);
		Atividade atividade = new Atividade(nome, descricao,codigoAtividade, responsavel);
		this.atividadeRepository.adicionarAtividade(atividade, codigoAtividade);
		
		return codigoAtividade;
	}
	
	public void encerrarAtividade(String atividadeID) {
		
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeID);
		if(atividade == null) {
			throw new NoSuchElementException("Id de atividade inválido");
		}
		atividade.encerrarAtividade();
	}
	
	public void desativarAtividade(String atividadeID) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeID);
		if(atividade == null) {
			throw new NoSuchElementException("Id de atividade inválido");
		}
		
		atividade.desativarAtividade();
		
	}
	
	public void reabrirAtividade(String atividadeID) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeID);
		if(atividade == null) {
			throw new NoSuchElementException("Id de atividade inválido");
		}
		atividade.reabrirTarefa();
	}
	
	public String exibirAtividade(String atividadeID) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeID);
		
		if(atividade == null) {
			throw new NoSuchElementException("Id de atividade inválido");
		}
		
		return atividade.toString() ;
		
	}
	
	public void alterarDescricaoAtividade(String atividadeID, String descricao) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeID);
		if(atividade == null) {
			throw new NoSuchElementException("Id de atividade inválido");
		}
		atividade.alterarDescricao(descricao);
		
	}
	
	public void alterarResponsavelAtividade(String atividadeID, String cpfResponsavel) {
		Atividade atividade = this.atividadeRepository.getAtividade(atividadeID);
		if(atividade == null) {
			throw new NoSuchElementException("Id de atividade inválido");
		}
		Pessoa responsavel = this.validaResponsavel(cpfResponsavel);
		atividade.alterarResponsavelAtividade(responsavel);
	}
	
	public List<Tarefa> getTodasTarefas(){
		
		Collection<Atividade> atividades = atividadeRepository.getAtividades().values();
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		for(Atividade atividade : atividades) {
			
			tarefas.addAll(atividade.getTarefas().values());
		}
		return tarefas;
	}
 	
	private String gerarCodigoAtividade(String nomeAtividade) 
	{
		
		nomeAtividade = nomeAtividade.replace(" ", "");
		nomeAtividade = nomeAtividade.toLowerCase();
		String codigoAtividade = "";
		int consoantes = 0;
		
		for (int i = 0; i < nomeAtividade.length(); i++) {
			char letra = nomeAtividade.charAt(i);
			if(!PalavraUtil.verificaVogal(letra)) {
				codigoAtividade += Character.toUpperCase(letra);
				consoantes++;
			}
			if(consoantes == 3) {
				break;
			}
		}
	
		if(consoantes != 3) {
			for (int i = consoantes; i < 3; i++) {
				codigoAtividade += "X";
			}
		}
		
		codigoAtividade += "-"+3;
		
		return codigoAtividade;
	}
	
	private Pessoa validaResponsavel(String cpfResponsavel) {
		Pessoa responsavel = null;
		if(cpfResponsavel != null) {
			responsavel = this.pessoaRepository.getPessoa(cpfResponsavel);
		}
		return responsavel;
	}
}
