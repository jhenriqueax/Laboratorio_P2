package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.documento.DocumentoDTO;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.similaridade.SimilaridadeController;
import com.matheusgr.similaridade.SimilaridadeService;

class SimilaridadeTest  extends BaseTest{
	

	@Test
	void testeBasicoCoeficente() {
		
		String id1 = "123";
		String id2 = "321";
		
		
		this.documentoController.adicionaDocumentoTxt(id1, "Um dia feliz é um bom dia");
		this.documentoController.adicionaDocumentoTxt(id2, "Uma casa feliz é uma casa bonita");
		
		
		var documentoOpt = this.documentoController.recuperarDocumento(id1);
		var doc = documentoOpt.get();
		
		System.out.println(doc);
		
		
		System.out.println("falho");
		
	}

}
