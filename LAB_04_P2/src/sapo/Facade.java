package sapo;

import sapo.atividade.AtividadeRepository;
import sapo.atividade.AtividadeService;
import sapo.busca.Busca;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaRepository;
import sapo.atividade.AtividadeController;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaService;

public class Facade {

	private PessoaController pessoaController;
	private TarefaController tarefaController;
	private AtividadeController atividadeController;
	private Busca busca;

	public Facade() {
		PessoaRepository pr = new PessoaRepository();
		AtividadeRepository ar = new AtividadeRepository();
		AtividadeService as = new AtividadeService(ar, pr);
		TarefaService ts = new TarefaService();
		
		
		
		this.busca = new Busca(pr, ar);
		this.pessoaController = new PessoaController(pr);
		this.atividadeController = new AtividadeController(as);
		this.tarefaController = new TarefaController(ts);

	}

	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		this.pessoaController.cadastrarPessoa(nome, cpf, habilidades);
	}

	public String exibirPessoa(String cpf) {
		return this.pessoaController.exibirPessoa(cpf);
	}

	public void alterarNomePessoa(String cpf, String novoNome) {
		this.pessoaController.alterarNomePessoa(cpf, novoNome);
	}

	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		this.pessoaController.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}

	public void removerPessoa(String cpf) {
		this.pessoaController.removerPessoa(cpf);
	}

	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		this.pessoaController.adicionarComentarioPessoa(cpf, comentario, autorCpf);
	}

	public String listarComentariosPessoa(String cpf) {
		return this.pessoaController.listarComentariosPessoa(cpf);
	}
	
	public void cadastrarAluno(String cpf, String nome, String matricula, int periodo, String[] habilidades) {
		this.pessoaController.cadastrarAluno(cpf, nome, matricula, periodo, habilidades);
	}
	
	public void cadastrarProfessor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades) {
		this.pessoaController.cadastrarProfessor(cpf, nome, siape, disciplinas, habilidades); 
	}
	
	public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas) {
		this.pessoaController.definirFuncaoProfessor(cpf, siape, disciplinas);
	}
	
	public void definirFuncaoAluno(String cpf, String matricula, int periodo) {
		this.pessoaController.definirFuncaoAluno(cpf, matricula, periodo);
	}
	
	public void removerFuncao(String cpf) {
		this.pessoaController.removerFuncao(cpf);
	}
	
	public int pegarNivel(String cpf) {
		return this.pessoaController.pegarNivel(cpf);
	}
	
	public String listarPessoas() {
		return this.pessoaController.listarPessoas();
	}


	public String cadastrarAtividade(String nome, String descricao, String cpfResponsavel)
	{
		return this.atividadeController.cadastrarAtividade(nome, descricao, cpfResponsavel);
	}

	public void encerrarAtividade(String atividadeID)
	{
		this.atividadeController.encerrarAtividade(atividadeID);
	}

	public void desativarAtividade(String atividadeID)
	{
		this.atividadeController.desativarAtividade(atividadeID);
	}

	public void reabrirAtividade(String atividadeID)
	{
		this.atividadeController.reabrirAtividade(atividadeID);
	}

	public String exibirAtividade(String atividadeID)
	{
		return this.atividadeController.exibirAtividade(atividadeID);
	}

	public void alterarDescricaoAtividade(String atividadeID, String descricao)
	{
		this.atividadeController.alterarDescricaoAtividade(atividadeID, descricao);
	}

	public void alterarResponsavelAtividade(String atividadeID, String cpfResponsavel)
	{
		this.atividadeController.alterarResponsavelAtividade(atividadeID, cpfResponsavel);
	}

	public String cadastrarTarefa(String atividadeID, String nome, String[] habilidades) {
		return this.tarefaController.cadastrarTarefa(atividadeID, nome, habilidades);
	}

	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		this.tarefaController.alterarNomeTarefa(idTarefa, novoNome);
	}

	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		this.tarefaController.alterarHabilidadesTarefa(idTarefa, habilidades);
	}

	public void addHoraTarefa(String idTarefa, int horas) {
		this.tarefaController.addHoraTarefa(idTarefa, horas);
	}

	public void removerHoraTarefa(String idTarefa, int horas) {
		this.tarefaController.removerHoraTarefa(idTarefa, horas);
	}

	public String exibirTarefa(String idTarefa){
		return this.tarefaController.exibirTarefa(idTarefa);

	}

	public void concluirTarefa(String idTarefa) {
		this.tarefaController.concluirTarefa(idTarefa);
	}

	public void removerTarefa(String idTarefa) {

		this.tarefaController.removerTarefa(idTarefa);
	}

	public void associarPessoaTarefa(String cpf, String idTarefa) {

		this.tarefaController.associarPessoaTarefa(cpf, idTarefa);
	}

	public void removerPessoaTarefa(String cpf, String idTarefa) {

		this.tarefaController.removerPessoaTarefa(cpf, idTarefa);
	}

	public void cadastrarTarefaGerencial(String atividadeId, String[] habilidades,String[] idTarefas) {
		this.tarefaController.cadastrarTarefaGerencial(atividadeId, habilidades, idTarefas);
	}

	public void adicionarNaTarefaGerencial(String atividadeId, String idTarefaGerencial, String idTarefa) {
		this.tarefaController.adicionarNaTarefaGerencial(atividadeId,idTarefaGerencial,idTarefa);
	}

	public void removerDaTarefaGerencial(String atividadeId, String idTarefaGerencial, String idTarefa) {
		this.tarefaController.removerDaTarefaGerencial(atividadeId, idTarefaGerencial,idTarefa);
	}

	public void contarTodasTarefasNaTarefaGerencial(String atividadeId, String idTarefaGerencial) {
		this.tarefaController.contarTodasTarefasNaTarefaGerencial(atividadeId, idTarefaGerencial);
	}

}
