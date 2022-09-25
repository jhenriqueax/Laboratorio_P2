package sapo.busca;

import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeRepository;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaRepository;

public class MainSapo {

	static PessoaController controller;
	static AtividadeController atvController;

	public static void main(String args[]){
		PessoaRepository repo = new PessoaRepository ();
		controller = new PessoaController(repo);
		AtividadeRepository reposi = new AtividadeRepository();

		Busca busca = new Busca(repo, reposi);

		String habilidades1[] = {"Ler", "Pensar", "Falar"};
		String habilidades2[] = {"Ler"};
		String habilidades3[] = {"Ler", "Pensar"};
		String habilidades4[] = {"Falar"};
		repo.cadastrarPessoa("John snow","123.456.789-10" , habilidades1);
		repo.cadastrarPessoa("Arya Stark","321.245.456-15" , habilidades2);
		repo.cadastrarPessoa("Tyrion Lennister","165.646.546-30" , habilidades3);
		repo.cadastrarPessoa("Litle Finger","143.123.456-17" , habilidades4);

		System.out.println(busca.exibirPessoa("Falar"));

		//System.out.println(atvController.cadastrarAtividade("Daenerys Targaryen", "Rainha da porra toda", "412.321.421.31"));

		//reposi.adicionarAtividade(null, null);

		//reposi.getAtividade(null);

	}
}
