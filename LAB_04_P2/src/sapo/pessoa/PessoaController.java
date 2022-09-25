package sapo.pessoa;

public class PessoaController {

	private PessoaRepository pr;

	public PessoaController(PessoaRepository pessoaRepository) {
		pr = pessoaRepository;
	}

	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		if (!nome.isBlank() && !cpf.isBlank()) {
			pr.cadastrarPessoa(nome, cpf, habilidades);
		} else {
			throw new IllegalArgumentException("Nome e Cpf não podem estar vazios");
		}
	}
	
	public void cadastrarAluno(String cpf, String nome, String matricula, int periodo, String[] habilidades) {
		if (nome.isBlank() || nome == null ) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		} 
		if(cpf.isBlank() || cpf == null) {
			throw new IllegalArgumentException("CPF não pode ser vazio");
		}
		if(matricula.isBlank() || matricula == null) {
			throw new IllegalArgumentException("Matricula não pode ser vazia");
		}
		if(periodo <= 0) {
			throw new IllegalArgumentException("Periodo não pode ser vazio");
		}
		
		pr.cadastrarAluno(nome, cpf, matricula, periodo, habilidades);
	}
	
	public void cadastrarProfessor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades) {
		if (nome.isBlank() || nome == null ) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		} 
		if(cpf.isBlank() || cpf == null) {
			throw new IllegalArgumentException("CPF não pode ser vazio");
		}
		if(siape.isBlank() || siape == null) {
			throw new IllegalArgumentException("Matricula não pode ser vazia");
		}
		
		pr.cadastrarProfessor(nome, cpf, siape, disciplinas, habilidades);
	}
	
	public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas) {
		if(cpf.isBlank() || cpf == null) {
			throw new IllegalArgumentException("CPF não pode ser vazio");
		}
		if(siape.isBlank() || siape == null) {
			throw new IllegalArgumentException("Matricula não pode ser vazia");
		}
		
		pr.definirFuncaoProfessor(cpf, siape, disciplinas);
	}
	
	public void definirFuncaoAluno(String cpf, String matricula, int periodo) {
		if(cpf.isBlank() || cpf == null) {
			throw new IllegalArgumentException("CPF não pode ser vazio");
		}
		if(matricula.isBlank() || matricula == null) {
			throw new IllegalArgumentException("Matricula não pode ser vazia");
		}
		if(periodo <= 0) {
			throw new IllegalArgumentException("Periodo não pode ser vazio");
		}
		
		pr.definirFuncaoAluno(cpf, matricula, periodo);
	}
	
	public void removerFuncao(String cpf) {
		if (cpf.isBlank() || cpf == null){
			throw new IllegalArgumentException("cpf não pode estar vazio");
		}
		pr.removerFuncao(cpf);
	}
	
	public int pegarNivel(String cpf) {
		if (cpf.isBlank() || cpf == null){
			throw new IllegalArgumentException("cpf não pode estar vazio");
		}
		
		return pr.pegarNivel(cpf);
	}
	
	public String listarPessoas() {
		
		return pr.listarPessoas();
	}
	
	public String exibirPessoa(String cpf) {
		if (cpf.isBlank() || cpf == null){
			throw new IllegalArgumentException("cpf não pode estar vazio");
		}
		return pr.exibePessoa(cpf);
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		if (!novoNome.isBlank()) {
			pr.alterarNomePessoa(cpf, novoNome);
		} else {
			throw new IllegalArgumentException("Nome não pode estar vazio");
		}
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		if (cpf.isBlank() || cpf == null){
			throw new IllegalArgumentException("cpf não pode estar vazio");
		}
		pr.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		if (cpf.isBlank() || cpf == null){
			throw new IllegalArgumentException("cpf não pode estar vazio");
		}
		pr.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		if (cpf.isBlank() || cpf == null || comentario.isBlank() || comentario == null || autorCpf.isBlank() || autorCpf == null){
			throw new IllegalArgumentException("cpf não pode estar vazio");
		}
		pr.adicionarComentarioPessoa(cpf, comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		if (cpf.isBlank() || cpf == null){
			throw new IllegalArgumentException("cpf não pode estar vazio");
		}
		return pr.listarComentariosPessoa(cpf);
	}
	
}
