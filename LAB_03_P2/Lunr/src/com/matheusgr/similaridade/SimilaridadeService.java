package com.matheusgr.similaridade;

import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa a similaridade.
 */
public class SimilaridadeService {

	private DocumentoService documentoService;
	private Object documentoController;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o cálculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interseção entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a união entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade é o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhança entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		

		String[] termos1 = this.documentoService.recuperaDocumento(docId1).get().getTexto();
		String[] termos2 = this.documentoService.recuperaDocumento(docId2).get().getTexto();
		
		int intersecao = 0;

	    for(int i = 0, j = 0; i < termos1.length && j < termos2.length;){
	        int res = termos1[i].compareTo(termos2[j]);
	        if(res == 0){
	            intersecao++;
	            i++;
	            j++;
	        }else if(res < 0){
	            i++;
	        }else{
	            j++;
	        }
	    }
	   
		int jaccard = intersecao / (termos1.length + termos2.length);
		
		
		return jaccard;
		
		
	}

}






