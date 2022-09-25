package sapo.pessoa;

import java.util.StringJoiner;

public class Comentario {

	private String texto;
	private Pessoa autor;
	private long date;

	public Comentario(String texto, Pessoa autor, long date) {
		this.texto = texto;
		this.autor = autor;
		this.date = date;
	}

	public String getTexto() {
		return this.texto;
	}
	public String getAutorCpf() {
		return this.autor.getCpf();
	}
	public long getDate() {
		return this.date;
	}
	public String toString(){
		return "--"+this.texto+"("+this.autor.getCpf()+")";
	}
}
