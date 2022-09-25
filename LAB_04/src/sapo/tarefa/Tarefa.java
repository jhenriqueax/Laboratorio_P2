package sapo.tarefa;

public interface Tarefa {

    public void alterarNome(String nome);

    public String[] getHabilidades();

    public boolean isPendente();

	public String getId();

	public String getNome();
}
