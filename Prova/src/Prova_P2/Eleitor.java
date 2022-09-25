package Prova_P2;

import java.util.Objects;

public class Eleitor {



	private String nome;

    private String cpf;

    private boolean statusVotacao;

    public Eleitor(String nome, String cpf) {
    	this.nome = nome;
    	this.cpf = cpf;
    	this.statusVotacao = false;

    }

    public String getNome(){
    	return nome;

    }

    public String getCpf() {
    	return cpf;

    }

    public boolean getStatus(){
    	return statusVotacao;
    	


    }

	public void setStatusVotacao(boolean statusVotacao) {
		this.statusVotacao = statusVotacao;
	}    
    
	
	public int hashCode() {
		return Objects.hash(cpf);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleitor other = (Eleitor) obj;
		return Objects.equals(cpf, other.cpf);
	}
}