package com.matheusgr.apresentacao;

public class caixaAlta implements representacaoInterface {
	
	private String texto;

	public caixaAlta(String texto) {
		this.texto = texto;
	}

	@Override
	public String representacao() {
		return texto.toUpperCase();
	}

}
