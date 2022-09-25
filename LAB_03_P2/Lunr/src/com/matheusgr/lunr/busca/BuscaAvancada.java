package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

public class BuscaAvancada implements Busca {

	private Map<String, String> mapa;

	/**
	 * Construtor padrão com os termos a serem encontrados.
	 * recebe como paramatro um mapa com os metadados
	 * 
	 * @param metaDados
	 */
	public BuscaAvancada(Map<String, String> metaDados) {
		(new ValidadorBusca()).valida(metaDados);

		this.mapa = metaDados;

	}

	
	/**
	 * 
	 * Realiza a busca a partir da consulta ao DocumentoService. além de 
	 * realizar uma "filtragem" verificando se estão TODOS os metadados indicados
	 * 	  
	 * O DocumentoService realiza apenas operações simples de busca, mas sem
	 * ordenação ou tratamento da lógica de relevância.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados 
	 * 
	 */
	public Map<Documento, Integer> busca(DocumentoService ds) {

		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		Map<Documento, Integer> filtro = new HashMap<>();

		for (String chave : this.mapa.keySet()) {
			String valor = this.mapa.get(chave);
			for (Documento d : ds.busca(chave, valor)) {
				respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
			}
		}
		for (Documento doc : respostaDocumento.keySet()) {
			int valor = respostaDocumento.get(doc);
			if (valor == mapa.size()) {
				filtro.put(doc, valor);
			}
		}
		return filtro;
	}

	
	
	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	@Override
	public String[][] descreveConsulta() {

		String[][] resultado = new String[this.mapa.size()][];

		Set<String> chaves = mapa.keySet();
		for (String chave : chaves) {
			if (chave != null) {
				for (int i = 0; i < this.mapa.size(); i++) {
					resultado[i] = new String[] { "TERMO " + (i + 1), this.mapa.get(chave) };

				}
			}
		}
		return resultado;
	}
}
