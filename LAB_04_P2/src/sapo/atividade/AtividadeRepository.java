package sapo.atividade;

import java.util.HashMap;
import java.util.Map;

public class AtividadeRepository {
	
	public Map<String, Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(Map<String, Atividade> atividades) {
		this.atividades = atividades;
	}

	private Map<String,Atividade> atividades;
	
	
	public AtividadeRepository(){
		this.atividades = new HashMap<String,Atividade>();
	}
	
	public void adicionarAtividade(Atividade atividade, String codigoAtividade)
	{
		this.atividades.put(codigoAtividade, atividade);
	}
	
	public Atividade getAtividade(String atividadeID) {
		return this.atividades.get(atividadeID);
	}
	
	public int getQuantidadeAtividadesCadastradas() {
		
		return this.atividades.size();
	}

}
