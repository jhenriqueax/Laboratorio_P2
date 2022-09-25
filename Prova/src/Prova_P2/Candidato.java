package Prova_P2;

import java.util.Objects;

public class Candidato {

    private String nome;

    private int id;

    private int votos;
    
    
    
    public Candidato(String nome) {
		this.nome = nome;
	}
    
  

    public String getNome() {
		return nome;

    }

    public int getId(){
    
		return id;

    }

    public void setId(int id) {
		this.id = id;
	}



	public int getVotos() {
		return votos;

    }

    public void SetVotos() {
    	
	this.votos += 1;

    }

    
  public void zeraVotos(){
	  this.votos = 0;
  }
    

	public int hashCode() {
		return Objects.hash(nome);
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(nome, other.nome);
	}



	public String toString() {
		return null;

    }

}