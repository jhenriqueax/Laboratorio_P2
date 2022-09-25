package com.matheusgr.apresentacao;

public class ultimasNLinhas implements representacaoInterface {

	private String texto;
	private int numlinhas;

	public ultimasNLinhas(String texto, int numLinhas) {
		this.texto = texto;
		this.numlinhas = numLinhas;
	}

	@Override
	public String representacao() {

		String[] meuArray = texto.split("\n");

		String resultado = "";

		for (int i = 0; i < this.numlinhas; i++) {

			resultado += meuArray[meuArray.length - i] + " ";
		}

		return resultado;
	}

}
