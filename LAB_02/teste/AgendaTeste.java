

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;
import agenda.Favorito;



class AgendaTeste {
	
	private Agenda agendaTeste;
	
	

	
	@BeforeEach
	void preparaAgenda(){
		
		Agenda agenda = new Agenda();
		this.agendaTeste = agenda;
		
	}

	
	/**
	 * Testando comportamento com todos os  parametros 
	 */
	@Test
	void testaCadastraContato01(){
	
		assertFalse(agendaTeste.cadastraContato(2, "Eduardo", "Gabriel", "12345678"));
	}
	
	/**
	 * Testando comportamento sem o parametro sobrenome 
	 */
	@Test
	void testaCadastraContato02(){
	
		assertFalse(agendaTeste.cadastraContato(2, "Livia", "", "12345678"));
		
	}
	
	/**
	 * Testando comportamento com os limites das posiçoes do array de 100
	 */
	@Test
	void testaCadastraContato03(){
	
		assertFalse(agendaTeste.cadastraContato(1, "Joao", "Henrique", "555-1234"));
		assertFalse(agendaTeste.cadastraContato(50, "Gabriel", "Lacerda", "555-2345"));
		assertFalse(agendaTeste.cadastraContato(99, "Lucas", "Carvalho", "555-3456"));
		
		
	}
	
	/**
	 * Testando comportamento com o contato já cadastrado 
	 */
	@Test
	void testaCadastraContato04(){
		
		agendaTeste.cadastraContato(2, "Joao", "Henrique", "12345678");
	
		assertTrue(agendaTeste.cadastraContato(22, "Joao", "Henrique", "12345678"));
		
	}

	/**
	 * Testando cadastro de contatos no método cadastraContatoFavorito
	 */
	@Test 
	void testaCadastroFavorito01(){
		
		agendaTeste.cadastraContato(1, "Joao", "Henrique", "555-12345");
		
		agendaTeste.cadastraContatoFavorito(4, 1);
		
		Contato contato = agendaTeste.getContato(1);
		Favorito favorito = agendaTeste.getFavoritos(4);
		
		String contatoTeste = contato.getNome() + contato.getSobrenome();
		String favoritoTeste = favorito.getNome() + favorito.getSobrenome();
		
		assertEquals(contatoTeste, favoritoTeste);
		
	}
	/**
	 * Testando cadastro de contatos no método cadastraContatoFavorito no
	 * limite mínimo do array de favoritos de tamanho 10
	 */
	@Test 
	void testaCadastroFavorito02(){
		
		agendaTeste.cadastraContato(1, "Joao", "Henrique", "555-12345");
		
		agendaTeste.cadastraContatoFavorito(0, 1);
		
		Contato contato = agendaTeste.getContato(1);
		Favorito favorito = agendaTeste.getFavoritos(0);
		
		String contatoTeste = contato.getNome() + contato.getSobrenome();
		String favoritoTeste = favorito.getNome() + favorito.getSobrenome();
		
		assertEquals(contatoTeste, favoritoTeste);
	
	}
	
	/**
	 * Testando cadastro de contatos no método cadastraContatoFavorito no
	 * limite máximo do array de favoritos de tamanho 10
	 */
	@Test 
	void testaCadastroFavorito03(){
		
		agendaTeste.cadastraContato(1, "Joao", "Henrique", "555-12345");
		
		agendaTeste.cadastraContatoFavorito(9, 1);
		
		Contato contato = agendaTeste.getContato(1);
		Favorito favorito = agendaTeste.getFavoritos(9);
		
		String contatoTeste = contato.getNome() + contato.getSobrenome();
		String favoritoTeste = favorito.getNome() + favorito.getSobrenome();
		
		assertEquals(contatoTeste, favoritoTeste);
	
	}
	
	/**
	 * Testando remove contatos 
	 */
	@Test 
	void testaRemove01(){
		
		agendaTeste.cadastraContato(1, "Joao", "Henrique", "555-12345");
		
		agendaTeste.cadastraContatoFavorito(4, 1);
		
		agendaTeste.remove(1);
		
		
		assertEquals(agendaTeste.getContato(1), null);
		assertEquals(agendaTeste.getFavoritos(1),null);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	






}
